/****************************************************************************
 Copyright (c) 2012      cocos2d-x.org
 Copyright (c) 2013-2014 Chukong Technologies Inc.

 http://www.cocos2d-x.org

 Permission is hereby granted, free of charge, to any person obtaining a copy
 of this software and associated documentation files (the "Software"), to deal
 in the Software without restriction, including without limitation the rights
 to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 copies of the Software, and to permit persons to whom the Software is
 furnished to do so, subject to the following conditions:

 The above copyright notice and this permission notice shall be included in
 all copies or substantial portions of the Software.

 THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 THE SOFTWARE.
 ****************************************************************************/

#include "JavaEngine.h"
#include "cocos2d.h"
#include "CCArray.h"
#include "CCScheduler.h"
#include "AppDelegate.h"
#include "FunctionFactory.h"
#include "platform/android/jni/JniHelper.h"

using namespace ccj;

#define JLONG_TO_PTR(a) ((void*)(uintptr_t)(a))
#define PTR_TO_JLONG(a) ((jlong)(uintptr_t)(a))

#ifdef __APPLE__
#define JNIEXPORT __attribute__((visibility("default")))   __attribute__ ((used))
#endif
extern "C" {
    
    JNIEXPORT void JNICALL Java_org_ccj_Engine_init(JNIEnv* env, jobject obj) {
        jobject rarg = NULL;
        ccj::JavaEngine* rptr;
        jthrowable exc = NULL;
        rptr = ccj::JavaEngine::getInstance();
        if (rptr != NULL) {
            JavaVM *javaVm;
            env->GetJavaVM(&javaVm);
            rptr->setJavaVM(javaVm);
            rptr->initJVMEnv(env);
        }
        if (exc != NULL) {
            env->Throw(exc);
        }
    }
    
    JNIEXPORT jstring JNICALL Java_org_ccj_Engine_invoke(JNIEnv* env, jobject obj,jstring jmethodName,jstring jargs) {
        
        //     CCLog("Java_cc_Engine_invoke ");
        ccj::JavaEngine *engine = ccj::JavaEngine::getInstance();
        std::string methodName = engine->jstring2string(jmethodName);
        std::string args = engine->jstring2string(jargs);
        std::string result =  engine->execute(methodName,args);
        return engine->string2jstring(result);
    }
    
    JNIEXPORT void JNICALL _Java_org_ccj_Engine_log(JNIEnv* env, jclass jclazz,jstring msg) {
        
        ccj::JavaEngine *engine = ccj::JavaEngine::getInstance();
        std::string log = engine->jstring2string(msg);
        //      CCLog(log.c_str());
    }

    
}


JavaEngine* JavaEngine::_defaultEngine = NULL;

JavaEngine* JavaEngine::getInstance(void)
{
    if (!_defaultEngine)
    {
        _defaultEngine = new JavaEngine();
        ScriptEngineManager::getInstance()->setScriptEngine(_defaultEngine);
    }
    if(false){
        Java_org_ccj_Engine_init(NULL,NULL);
    }
    return _defaultEngine;
}

JavaEngine::~JavaEngine(void)
{
    _defaultEngine = NULL;
}

JNIEnv* JavaEngine::getJVMEnv(){

  JavaVM *javaVM = getJavaVM();

   JNIEnv* env;
   if (javaVM->GetEnv((void **)&env, JNI_VERSION_1_4) != JNI_OK) {
       log("error get env ");
       return env;
   }
   return env;
}

    static jobject createObject (JNIEnv *env, jclass cls ) {
        if (cls == NULL) {
            return NULL;
        }
        if (env->functions->AllocObject) {
            return env->AllocObject(cls);
        } else {
            jmethodID mid = env->GetMethodID(cls, "<init>", "()V");
            if (mid == NULL || env->ExceptionCheck()) {
                printf("Error getting default constructor of %s, while VM does not support AllocObject()");
                return NULL;
            }
            return env->NewObject(cls, mid);
        }
    }

void JavaEngine::initJVMEnv(JNIEnv* env)
{
    if(env==NULL){
      return ;
    }
    this->env = env;
    AppDelegate *app = new AppDelegate();
    javaClass = env->FindClass("org/ccj/Engine");
    handleMenuClickedEventMethod =env->GetStaticMethodID(javaClass, "handleMenuClickedEvent", "(J)V");
    handleReleaseObjectMethod =env->GetStaticMethodID(javaClass, "releaseObject", "(J)V");
    handleReleaseHandlerMethod =env->GetStaticMethodID(javaClass, "releaseHandler", "(J)V");
    handleNodeEventMethod =env->GetStaticMethodID(javaClass, "handleNodeEvent", "(JI)V");
    handleComponentEventMethod =env->GetStaticMethodID(javaClass, "handlerComponentEvent", "(JI)V");
    handleCallFuncActionEventMethod =env->GetStaticMethodID(javaClass, "handleCallFuncActionEvent", "(J)V");
    handleSchedulerMethod =env->GetStaticMethodID(javaClass, "handleScheduler", "(JF)V");
    handleKeypadEventMethod =env->GetStaticMethodID(javaClass, "handleKeypadEvent", "(JIJ)V");
	handleKeypadPressEventMethod =env->GetStaticMethodID(javaClass, "handleKeypadPressEvent", "(JIJ)V");
	handleKeypadReleaseEventMethod =env->GetStaticMethodID(javaClass, "handleKeypadReleaseEvent", "(JIJ)V");
    handleAccelerometerEventMethod =env->GetStaticMethodID(javaClass, "handleEventAcc", "(JJJ)V");
    handleCommonEventMethod =env->GetStaticMethodID(javaClass, "handleCommonEvent", "(JILjava/lang/String;)V");
    handleTouchEventMethod =env->GetStaticMethodID(javaClass, "handleTouchEvent", "(JJIJ)I");
    handleTouchesEventMethod =env->GetStaticMethodID(javaClass, "handleTouchesEvent", "(J[JIJ)V");
    //handleControlEventMethod =env->GetStaticMethodID(javaClass, "handleControlEvent", "(JI)V");
    handleEvenCustomMethod =env->GetStaticMethodID(javaClass, "handleEvenCustom", "(JLjava/lang/String;J)V");
    //handleEventAccMethod =env->GetStaticMethodID(javaClass, "handleEventAcc", "(JFFFJ)V");
    executeMethod =env->GetStaticMethodID(javaClass, "execute", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;");
    if (env->ExceptionOccurred() != NULL) {
            env->ExceptionDescribe();
    }
    
    
}

void JavaEngine::addSearchPath(const char* path)
{

}

void JavaEngine::removeScriptHandler(int nHandler)
{
   env->CallStaticVoidMethod(javaClass, handleReleaseHandlerMethod,nHandler);
   if (env->ExceptionOccurred() != NULL) {
       env->ExceptionDescribe();
   }
}

void JavaEngine::removeScriptObjectByObject(Object* object)
{
   env->CallStaticVoidMethod(javaClass, handleReleaseObjectMethod, PTR_TO_JLONG(object));
   if (env->ExceptionOccurred() != NULL) {
       env->ExceptionDescribe();
   }
}


std::string JavaEngine::execute(std::string methodName,std::string args){
     log("execute %s %s",methodName.c_str(),args.c_str());
	return  cce::FunctionFactory::getInstance()->callFunction(methodName,args);
}

std::string JavaEngine::invoke(std::string methodName,std::string args){
    if(executeMethod==NULL){
      return "";
    }

    jstring jmethodName = string2jstring(methodName);
    jstring jargs = string2jstring(args);
    jstring ret;
    ret= (jstring)env->CallStaticObjectMethod(javaClass,executeMethod,jmethodName,jargs);
     if (env->ExceptionOccurred() != NULL) {
         env->ExceptionDescribe();
     }
  return jstring2string(ret);
}

int JavaEngine::executeString(const char *codes)
{
    jstring code = chars2jstring(codes);
    int ret=0;
    ret= env->CallStaticIntMethod(javaClass, executeStringMethod,code);
    if (env->ExceptionOccurred() != NULL) {
       env->ExceptionDescribe();
    }
    return ret;
}

int JavaEngine::executeScriptFile(const char* filename)
{
    jclass javaClass = env->FindClass(filename);

    return 0;
}

int JavaEngine::executeGlobalFunction(const char* functionName)
{
    return 0;
}

bool JavaEngine::handleAssert(const char *msg)
{
    return false;
}

int JavaEngine::reallocateScriptHandler(int nHandler)
{    
    return 0;
}

bool JavaEngine::parseConfig(ConfigType type, const std::string& str)
{
    return false;
}

int JavaEngine::sendEvent(ScriptEvent* evt)
{
    if (NULL == evt)
        return 0;
//    CCLog("sendEvent %d ",evt->type);
    switch (evt->type)
    {
        case kNodeEvent:
            {
               return handleNodeEvent(evt->data);
            }
            break;
        case kMenuClickedEvent:
            {
                return handleMenuClickedEvent(evt->data);
            }
            break;
        case kCallFuncEvent:
            {
                return handleCallFuncActionEvent(evt->data);
            }
            break;
        case kScheduleEvent:
            {
                return handleScheduler(evt->data);
            }
            break;
        case kTouchEvent:
            {
                return handleTouchEvent(evt->data);
            }
            break;
        case kTouchesEvent:
            {
                return handleTouchesEvent(evt->data);
            }
            break;
        case kKeypadEvent:
            {
                return handleKeypadEvent(evt->data);
            }
            break;
		/*case kKeypadEventPress:
            {
                return handleKeypadPressEvent(evt->data);
            }
            break;	
	    case kKeypadEventRelease:
            {
                return handleKeypadReleaseEvent(evt->data);
            }
            break;	*/
        case kAccelerometerEvent:
            {
                return handleAccelerometerEvent(evt->data);
            }
            break;
        case kCommonEvent:
            {
                return handleCommonEvent(evt->data);
            }
            break;
        case kControlEvent:
            {
                return handlerControlEvent(evt->data);
            }
            break;
        case kComponentEvent:
            {
                return handlerComponentEvent(evt->data);
            }
//
//        case kComponentEvent:
//            {
//                return handleEvenCustom(evt->data);
//            }
            break;
        default:
            break;
    }
    
    return 0;
}

//int JavaEngine::handlerWebSocketEvent(void* data)
//{
//    if (NULL == data)
//        return 0;
//
//    WebSocketScriptData* basicScriptData = (WebSocketScriptData*)data;
//    if (NULL == basicScriptData->ws)
//        return 0;
//
//    int action = basicScriptData->action;
//    env->CallStaticVoidMethod(javaClass, handleComponentEventMethod, PTR_TO_JLONG(basicScriptData->nativeObject),action);
//    if (env->ExceptionOccurred() != NULL) {
//        env->ExceptionDescribe();
//    }
//    return 0;
//}

int JavaEngine::handlerComponentEvent(void* data)
{
    if (NULL == data)
        return 0;
    
    BasicScriptData* basicScriptData = (BasicScriptData*)data;
    if (NULL == basicScriptData->nativeObject || NULL == basicScriptData->value)
        return 0;
    
    int action = *((int*)(basicScriptData->value));
    env->CallStaticVoidMethod(javaClass, handleComponentEventMethod, PTR_TO_JLONG(basicScriptData->nativeObject),action);
    if (env->ExceptionOccurred() != NULL) {
        env->ExceptionDescribe();
    }
    return 0;
}

int JavaEngine::handleNodeEvent(void* data)
{
    if (NULL == data)
        return 0;

    BasicScriptData* basicScriptData = (BasicScriptData*)data;
    if (NULL == basicScriptData->nativeObject || NULL == basicScriptData->value)
        return 0;

    int action = *((int*)(basicScriptData->value));
    env->CallStaticVoidMethod(javaClass, handleNodeEventMethod, PTR_TO_JLONG(basicScriptData->nativeObject),action);
    if (env->ExceptionOccurred() != NULL) {
        env->ExceptionDescribe();
    }
    return 0;
}

int JavaEngine::handleMenuClickedEvent(void* data)
{
    if (NULL == data)
        return 0;
    
    BasicScriptData* basicScriptData = (BasicScriptData*)data;
    if (NULL == basicScriptData->nativeObject)
        return 0;
        
//    MenuItem* menuItem = static_cast<MenuItem*>(basicScriptData->nativeObject);

//    CCLog("CallVoidMethod %d %d %d %d",javaClass,handleMenuClickedEventMethod,javaObject,basicScriptData->nativeObject);
    env->CallStaticVoidMethod(javaClass, handleMenuClickedEventMethod, PTR_TO_JLONG(basicScriptData->nativeObject));
    if (env->ExceptionOccurred() != NULL) {
        env->ExceptionDescribe();
    }
    return 0;
}

int JavaEngine::handleCallFuncActionEvent(void* data)
{
    if (NULL == data)
        return 0;
    
    BasicScriptData* basicScriptData = static_cast<BasicScriptData*>(data);
    if (NULL == basicScriptData->nativeObject)
        return 0;

    env->CallStaticVoidMethod(javaClass, handleCallFuncActionEventMethod, PTR_TO_JLONG(basicScriptData->nativeObject));
    if (env->ExceptionOccurred() != NULL) {
        env->ExceptionDescribe();
    }

    return 0;
}

int JavaEngine::handleScheduler(void* data)
{
    if (NULL == data)
        return 0;
    
    SchedulerScriptData* schedulerInfo = static_cast<SchedulerScriptData*>(data);
    if((long)schedulerInfo->handler==-1){
        env->CallStaticVoidMethod(javaClass, handleSchedulerMethod,PTR_TO_JLONG(schedulerInfo->node),schedulerInfo->elapse);
    }else{
        env->CallStaticVoidMethod(javaClass, handleSchedulerMethod,(long)schedulerInfo->handler,schedulerInfo->elapse);
    }
    if (env->ExceptionOccurred() != NULL) {
        env->ExceptionDescribe();
    }

    return 0;
}

int JavaEngine::handleKeypadEvent(void* data)
{
    if (NULL == data)
        return 0;
    
    KeypadScriptData* keypadScriptData = static_cast<KeypadScriptData*>(data);
    if (NULL == keypadScriptData->nativeObject)
        return 0;

    EventKeyboard::KeyCode action = keypadScriptData->actionType;

    env->CallStaticVoidMethod(javaClass, handleKeypadEventMethod, PTR_TO_JLONG(keypadScriptData->nativeObject),(int)action);
    if (env->ExceptionOccurred() != NULL) {
        env->ExceptionDescribe();
    }

    return 0;
}


int JavaEngine::handleKeypadPressEvent(void* data)
{
    if (NULL == data)
        return 0;
    
    KeypadScriptData* keypadScriptData = static_cast<KeypadScriptData*>(data);
    if (NULL == keypadScriptData->nativeObject)
        return 0;

    EventKeyboard::KeyCode action = keypadScriptData->actionType;

    env->CallStaticVoidMethod(javaClass, handleKeypadPressEventMethod, PTR_TO_JLONG(keypadScriptData->nativeObject),(int)action);
    if (env->ExceptionOccurred() != NULL) {
        env->ExceptionDescribe();
    }

    return 0;
}


int JavaEngine::handleKeypadReleaseEvent(void* data)
{
    if (NULL == data)
        return 0;
    
    KeypadScriptData* keypadScriptData = static_cast<KeypadScriptData*>(data);
    if (NULL == keypadScriptData->nativeObject)
        return 0;

    EventKeyboard::KeyCode action = keypadScriptData->actionType;

    env->CallStaticVoidMethod(javaClass, handleKeypadReleaseEventMethod, PTR_TO_JLONG(keypadScriptData->nativeObject),(int)action);
    if (env->ExceptionOccurred() != NULL) {
        env->ExceptionDescribe();
    }

    return 0;
}

int JavaEngine::handleAccelerometerEvent(void* data)
{
    if (NULL == data)
        return 0;
    
    BasicScriptData* basicScriptData = static_cast<BasicScriptData*>(data);
    if (NULL == basicScriptData->nativeObject || NULL == basicScriptData->value)
        return 0;
    Acceleration* accelerationValue = static_cast<Acceleration*>(basicScriptData->value);
    env->CallStaticVoidMethod(javaClass, handleAccelerometerEventMethod, PTR_TO_JLONG(basicScriptData->nativeObject),
          PTR_TO_JLONG(accelerationValue)
          );
    if (env->ExceptionOccurred() != NULL) {
        env->ExceptionDescribe();
    }

    return 0;
}

int JavaEngine::handleCommonEvent(void* data)
{
    if (NULL == data)
        return 0;
   
    CommonScriptData* commonInfo = static_cast<CommonScriptData*>(data);
    if (NULL == commonInfo->eventName || 0 == commonInfo->handler)
        return 0;

    jstring eventName = string2jstring(commonInfo->eventName);
    env->CallStaticVoidMethod(javaClass, handleCommonEventMethod, PTR_TO_JLONG(commonInfo->eventSource),commonInfo->handler,eventName);
    if (env->ExceptionOccurred() != NULL) {
        env->ExceptionDescribe();
    }
    return 0;
}

int JavaEngine::handleTouchEvent(void* data)
{
    if (NULL == data)
        return 0;
    
    TouchScriptData* touchScriptData = static_cast<TouchScriptData*>(data);
    if (NULL == touchScriptData->nativeObject || NULL == touchScriptData->touch)
        return 0;

    int ret = 1;

    Touch* touch = touchScriptData->touch;
    if (NULL != touch && handleTouchEventMethod!=NULL) {
        //jclass touchClazz = env->FindClass("org/ccj/Touch");
        //jclass touchEventClazz = env->FindClass("org/ccj/TouchEvent");

        //jobject touchEvent = createObject(env,touchEventClazz);
        //jfieldID eventCodeField = env->GetFieldID(touchEventClazz, "actionCode", "I");
        //env->SetIntField(touchEvent, eventCodeField, (int)touchScriptData->actionType);

        //jobject touchObj = createObject(env,touchClazz);
        //jfieldID addressFid = env->GetFieldID(touchClazz, "address", "J");
        //env->SetLongField(touchObj, addressFid, PTR_TO_JLONG(touch));

        jlong address = PTR_TO_JLONG(touchScriptData->nativeObject);
		jlong touchAddress = PTR_TO_JLONG(touch);
        ret = env->CallStaticIntMethod(javaClass, handleTouchEventMethod, address,touchAddress, (int)touchScriptData->actionType);
        if (env->ExceptionOccurred() != NULL) {
            env->ExceptionDescribe();
        }
    }
    return ret;
}

int JavaEngine::handleTouchesEvent(void* data)
{
    if (NULL == data)
        return 0;
    
    TouchesScriptData* touchesScriptData = static_cast<TouchesScriptData*>(data);
    if (NULL == touchesScriptData->nativeObject || touchesScriptData->touches.size() == 0)
        return 0;

    Director* pDirector = Director::getInstance();
    int ret = 0;

    int size = touchesScriptData->touches.size();
    jlongArray touchArray = env->NewLongArray(size);

    int i=0;

    for (auto& touch : touchesScriptData->touches)
    {
        jlong touchAddress = PTR_TO_JLONG(touch);
		//touchArray[i]=touchAddress;
        i++;
    }

    jlong address = PTR_TO_JLONG(touchesScriptData->nativeObject);
    env->CallStaticVoidMethod(javaClass, handleTouchesEventMethod,address ,touchArray,(int)touchesScriptData->actionType);
    if (env->ExceptionOccurred() != NULL) {
        env->ExceptionDescribe();
    }

    return ret;
}

int JavaEngine::handlerControlEvent(void* data)
{
    if ( NULL == data )
        return 0;
    
    BasicScriptData* basicScriptData = static_cast<BasicScriptData*>(data);
    if (NULL == basicScriptData->nativeObject)
        return 0;
    
    int controlEvents = *((int*)(basicScriptData->value));
    
    int ret = 0;

    env->CallStaticVoidMethod(javaClass, handleControlEventMethod, PTR_TO_JLONG(basicScriptData->nativeObject),controlEvents);
    if (env->ExceptionOccurred() != NULL) {
        env->ExceptionDescribe();
    }
    return ret;
}

int JavaEngine::handleEventAcc(void* data)
{
    if (nullptr == data)
        return 0;
    
    BasicScriptData* basicScriptData = static_cast<BasicScriptData*>(data);
    if (nullptr == basicScriptData->nativeObject || nullptr == basicScriptData->value)
        return 0;
    return 0;
}


int JavaEngine::handleEvenCustom(void* data)
{
    if (nullptr == data)
        return 0;
    
    BasicScriptData * basicData = static_cast<BasicScriptData*>(data);
    if (NULL == basicData->nativeObject || nullptr == basicData->value )
        return 0;
    
    EventCustom* eventCustom = static_cast<EventCustom*>(basicData->value);

    jstring envetName = string2jstring(eventCustom->getEventName());
    env->CallStaticVoidMethod(javaClass, handleSchedulerMethod, PTR_TO_JLONG(basicData->nativeObject),envetName);
    if (env->ExceptionOccurred() != NULL) {
        env->ExceptionDescribe();
    }
    return 0;
}

std::string JavaEngine::jstring2string(jstring jstr) {
        if (jstr == NULL) {
            return "";
        }
        JNIEnv* env = this->getJVMEnv();
        const char* chars = env->GetStringUTFChars(jstr, NULL);
        std::string ret(chars);
        env->ReleaseStringUTFChars(jstr, chars);

        return ret;
}

jstring JavaEngine::string2jstring(std::string str) {
//        if (str == NULL) {
//            str="";
//        }
       const char* pat = str.c_str();
       return chars2jstring(pat);
}

jstring JavaEngine::chars2jstring(const char* pat) {
        if (pat == NULL) {
            return NULL;
        }
       JNIEnv* env = this->getJVMEnv();
       jclass strClass = env->FindClass("java/lang/String");
//       CCLOG("chars2jstring find stringclass %d",strClass);
       jmethodID ctorID = env->GetMethodID(strClass, "<init>", "([BLjava/lang/String;)V");
       jbyteArray bytes = env->NewByteArray(strlen(pat));
       env->SetByteArrayRegion(bytes, 0, strlen(pat), (jbyte*)pat);
       jstring encoding = env->NewStringUTF("utf-8");
     return (jstring)env->NewObject(strClass, ctorID, bytes, encoding);
}

