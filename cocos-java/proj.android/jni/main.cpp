#include "cocos2d.h"
#include "platform/android/jni/JniHelper.h"
#include "CCEventType.h"
#include "AppDelegate.h"
#include <jni.h>
#include <android/log.h>
#define  LOG_TAG    "main"
#define  LOGD(...)  __android_log_print(ANDROID_LOG_DEBUG,LOG_TAG,__VA_ARGS__)

using namespace cocos2d;

void cocos_android_app_init (JNIEnv* env, jobject thiz) {
    LOGD("cocos_android_app_init");
//    AppDelegate *pAppDelegate = new AppDelegate();
//    JNIEnv* env = cocos2d::JniHelper::getEnv();
//    cocos2d::JniMethodInfo methodInfo;
//    if(cocos2d::JniHelper::getMethodInfo(methodInfo,"com/makeapp/cocosplayer/CocosPlayerActivity","onGameStart","()V")){
//        //env->CallObjectMethod(app->activity->clazz, methodInfo.methodID);
//    }else{
//        LOGD("can't find doGameStarted");
//    }
}
