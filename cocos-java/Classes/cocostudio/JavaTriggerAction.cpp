
#include "JavaTriggerAction.h"

using namespace cocos2d;
using namespace cocostudio;

IMPLEMENT_CLASS_INFO(JavaTriggerAction);

 void JavaTriggerAction::registerType(const std::string& type){
    //cocostudio::ObjectFactory::TInfo typeObj(type, &JavaTriggerAction::createInstance);
}

JavaTriggerAction::JavaTriggerAction(void){

}

JavaTriggerAction:: ~JavaTriggerAction(void){

}

bool JavaTriggerAction::init(){
// CCLOG("JavaTriggerAction:init");

  JNIEnv* env = ccj::JavaEngine::getInstance()->getJVMEnv();

     jclass jvmClass = env->FindClass("org/ccj/editor/cocostudio/TriggerAction");
     jmethodID method = env->GetStaticMethodID(jvmClass,"init","(J)Z");

     return  env->CallStaticBooleanMethod(jvmClass, method,(jlong)PTR_TO_JLONG(this));
     if (env->ExceptionOccurred() != NULL) {
         env->ExceptionDescribe();
     }

     return false;
}

void JavaTriggerAction::done(){
//    CCLOG("JavaTriggerAction:done");

    JNIEnv* env = ccj::JavaEngine::getInstance()->getJVMEnv();

         jclass jvmClass = env->FindClass("org/ccj/editor/cocostudio/TriggerAction");
         jmethodID method = env->GetStaticMethodID(jvmClass,"done","(J)V");

          env->CallStaticVoidMethod(jvmClass, method,(jlong)PTR_TO_JLONG(this));
         if (env->ExceptionOccurred() != NULL) {
             env->ExceptionDescribe();
         }
}

 void JavaTriggerAction::serialize(const rapidjson::Value &val){
//     CCLOG("JavaTriggerAction:serialize");

      JNIEnv* env = ccj::JavaEngine::getInstance()->getJVMEnv();

      jclass jvmClass = env->FindClass("org/ccj/editor/cocostudio/TriggerAction");

      jmethodID method = env->GetStaticMethodID(jvmClass,"serialize","(JJ)V");

      env->CallStaticVoidMethod(jvmClass, method,(jlong)PTR_TO_JLONG(this),(jlong)PTR_TO_JLONG(&val));
      if (env->ExceptionOccurred() != NULL) {
          env->ExceptionDescribe();
      }
 }

void JavaTriggerAction::removeAll(){
//     CCLOG("JavaTriggerAction:removeAll");

    JNIEnv* env = ccj::JavaEngine::getInstance()->getJVMEnv();

    jclass jvmClass = env->FindClass("org/ccj/editor/cocostudio/TriggerAction");
    jmethodID method = env->GetStaticMethodID(jvmClass,"removeAll","(J)V");

    env->CallStaticVoidMethod(jvmClass, method,(jlong)PTR_TO_JLONG(this));
    if (env->ExceptionOccurred() != NULL) {
        env->ExceptionDescribe();
    }
}