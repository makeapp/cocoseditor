//
// Created by yuanyou on 14-9-22.
//

#include "FunctionFactory.h"
#include "cocos2d.h"
#include "Cocos2dFunction.h"

using namespace cocos2d;

#if (CC_TARGET_PLATFORM == CC_PLATFORM_ANDROID)
	#include "jni.h"
	#include "platform/android/jni/JniHelper.h"
#endif

#if (CC_TARGET_PLATFORM == CC_PLATFORM_ANDROID)

extern "C" {
	
	std::string jstring2string(JNIEnv* env,jstring jstr) {
        if (jstr == NULL) {
            return "";
        }
        const char* chars = env->GetStringUTFChars(jstr, NULL);
        std::string ret(chars);
        env->ReleaseStringUTFChars(jstr, chars);

        return ret;
	}

	jstring chars2jstring(JNIEnv* env,const char* pat) {
			if (pat == NULL) {
				return NULL;
			}
		   jclass strClass = env->FindClass("java/lang/String");
		   jmethodID ctorID = env->GetMethodID(strClass, "<init>", "([BLjava/lang/String;)V");
		   jbyteArray bytes = env->NewByteArray(strlen(pat));
		   env->SetByteArrayRegion(bytes, 0, strlen(pat), (jbyte*)pat);
		   jstring encoding = env->NewStringUTF("utf-8");
		 return (jstring)env->NewObject(strClass, ctorID, bytes, encoding);
	}

	jstring string2jstring(JNIEnv* env,std::string str) {
       const char* pat = str.c_str();
       return chars2jstring(env,pat);
	}


	JNIEXPORT jstring JNICALL Java_org_fun_FunctionFactory_callNative(JNIEnv* env, jclass jc,jstring jmethodName,jstring jargs) {
        
        cocos2d::log("Java_org_fun_FunctionFactory_callNative ");
        cce::FunctionFactory *factory = cce::FunctionFactory::getInstance();
        std::string methodName = jstring2string(env,jmethodName);
        std::string args = jstring2string(env,jargs);
        std::string result =  factory->callFunction(methodName,args);
        return string2jstring(env,result);
    }

}
#endif

std::string cce::Function::invoke(std::string args) {

    return "";
}

cce::FunctionFactory* cce::FunctionFactory::_defaultFactory = NULL;

cce::FunctionFactory* cce::FunctionFactory::getInstance(){
	if (!_defaultFactory)
    {
        _defaultFactory = new FunctionFactory();


    }
	return _defaultFactory;
}


std::string cce::FunctionFactory::callFunction(std::string name,std::string params){
			cocos2d::log("call %s %s",name.c_str(),params.c_str());
			 if(functions[name]!=NULL){
				return functions[name]->invoke(params);
			 }else if(callbackFunctions[name]!=NULL){
			   return  callbackFunctions[name](name,params);
			 }
			 else{
				 #if (CC_TARGET_PLATFORM == CC_PLATFORM_ANDROID)
			     cocos2d::JniMethodInfo minfo;
				 bool isHave = JniHelper::getStaticMethodInfo(minfo,"org/fun/FunctionFactory","callLocal", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;");
				 if (isHave)
				 {
					jstring jname= minfo.env->NewStringUTF(name.c_str());
					jstring jparams= minfo.env->NewStringUTF(params.c_str());
					jstring ret;
					ret= (jstring)	minfo.env->CallStaticObjectMethod(minfo.classID, minfo.methodID,jname,jparams);
					minfo.env->DeleteLocalRef(minfo.classID);
					return jstring2string(minfo.env,ret);
				 }
				#endif
				return "";
			 }
}

