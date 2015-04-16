
#include "JavaTriggerCondition.h"

using namespace cocos2d;
using namespace cocostudio;

//IMPLEMENT_CLASS_INFO(JavaTriggerCondition);

void JavaTriggerCondition::registerType(const std::string& type1){
//  cocostudio::ObjectFactory::TInfo typeObj(type1, &JavaTriggerCondition::createInstance);
}

JavaTriggerCondition::JavaTriggerCondition(void){}
JavaTriggerCondition::~JavaTriggerCondition(void){}

bool JavaTriggerCondition::init(){
//  CCLOG(" JavaTriggerCondition::init");

  JNIEnv* env = ccj::JavaEngine::getInstance()->getJVMEnv();

       jclass jvmClass = env->FindClass("org/ccj/editor/cocostudio/TriggerCondition");
       jmethodID method = env->GetStaticMethodID(jvmClass,"init","(J)Z");

       return  env->CallStaticBooleanMethod(jvmClass, method,(jlong)PTR_TO_JLONG(this));
       if (env->ExceptionOccurred() != NULL) {
           env->ExceptionDescribe();
       }
  return false;
}
bool JavaTriggerCondition::detect(){
//   CCLOG(" JavaTriggerCondition::detect");
   JNIEnv* env = ccj::JavaEngine::getInstance()->getJVMEnv();

          jclass jvmClass = env->FindClass("org/ccj/editor/cocostudio/TriggerCondition");
          jmethodID method = env->GetStaticMethodID(jvmClass,"detect","(J)Z");

          return  env->CallStaticBooleanMethod(jvmClass, method,(jlong)PTR_TO_JLONG(this));
          if (env->ExceptionOccurred() != NULL) {
              env->ExceptionDescribe();
          }
  return false;
}
void JavaTriggerCondition::serialize(const rapidjson::Value &val){
//    CCLOG(" JavaTriggerCondition::serialize");

    JNIEnv* env = ccj::JavaEngine::getInstance()->getJVMEnv();

              jclass jvmClass = env->FindClass("org/ccj/editor/cocostudio/TriggerCondition");
              jmethodID method = env->GetStaticMethodID(jvmClass,"serialize","(JJ)V");

                env->CallStaticVoidMethod(jvmClass, method,(jlong)PTR_TO_JLONG(this),(jlong)PTR_TO_JLONG(&val));
              if (env->ExceptionOccurred() != NULL) {
                  env->ExceptionDescribe();
              }
}
void JavaTriggerCondition::removeAll(){
//             CCLOG(" JavaTriggerCondition::removeAll");
 JNIEnv* env = ccj::JavaEngine::getInstance()->getJVMEnv();

               jclass jvmClass = env->FindClass("org/ccj/editor/cocostudio/TriggerCondition");
               jmethodID method = env->GetStaticMethodID(jvmClass,"removeAll","(J)V");

                 env->CallStaticVoidMethod(jvmClass, method,(jlong)PTR_TO_JLONG(this));
               if (env->ExceptionOccurred() != NULL) {
                   env->ExceptionDescribe();
               }
}
