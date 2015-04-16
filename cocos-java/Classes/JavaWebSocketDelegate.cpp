
#include "JavaWebSocketDelegate.h"
#include "JavaEngine.h"

using namespace cocos2d;
using namespace cocos2d::network;
using namespace ccj;

#define PTR_TO_JLONG(a) ((jlong)(uintptr_t)(a))


void JavaWebSocketDelegate::onOpen(WebSocket* ws){
    log("onOpen %d %d",jvmObject,onOpenMethod);

    JNIEnv* env = ccj::JavaEngine::getInstance()->getJVMEnv();

    jvmClass = env->FindClass("org/ccj/net/WebSocketDelegate");
//    jvmClass =  jvmClass = env->GetObjectClass(jvmObject);
    onOpenMethod = env->GetMethodID(jvmClass,"onOpen","(J)V");
    jvalue args[1];
    args[0].j= (jlong)PTR_TO_JLONG(this);
    env->CallVoidMethodA(jvmObject, onOpenMethod,args);
    if (env->ExceptionOccurred() != NULL) {
        env->ExceptionDescribe();
    }
}
void JavaWebSocketDelegate::onMessage(WebSocket* ws, const WebSocket::Data& data){
    log("onMessage");

    JNIEnv* env =  ccj::JavaEngine::getInstance()->getJVMEnv();

     jvmClass = env->FindClass("org/ccj/net/WebSocketDelegate");
     onMessageMethod = env->GetStaticMethodID(jvmClass,"onMessage","(J[BZ)V");
     jbyteArray jarray = env->NewByteArray(data.len);

     env->SetByteArrayRegion(jarray, 0, data.len, (jbyte*)data.bytes);
     env->CallStaticVoidMethod(jvmClass, onMessageMethod,PTR_TO_JLONG(this),jarray,data.len,data.isBinary);
     if (env->ExceptionOccurred() != NULL) {
         env->ExceptionDescribe();
     }
}

void JavaWebSocketDelegate::onClose(WebSocket* ws){

     JNIEnv* env =  ccj::JavaEngine::getInstance()->getJVMEnv();

     jvmClass = env->FindClass("org/ccj/net/WebSocketDelegate");
     onCloseMethod = env->GetStaticMethodID(jvmClass,"onClose","(J)V");

     env->CallStaticVoidMethod(jvmClass, onCloseMethod,PTR_TO_JLONG(this));
     if (env->ExceptionOccurred() != NULL) {
         env->ExceptionDescribe();
     }

}
void JavaWebSocketDelegate::onError(WebSocket* ws, const WebSocket::ErrorCode& error){
    log("onError");

     JNIEnv* env =  ccj::JavaEngine::getInstance()->getJVMEnv();

     jvmClass = env->FindClass("org/ccj/net/WebSocketDelegate");
     onErrorMethod = env->GetStaticMethodID(jvmClass,"onError","(JI)V");

     env->CallStaticVoidMethod(jvmClass, onErrorMethod,PTR_TO_JLONG(this),(jint)error);
     if (env->ExceptionOccurred() != NULL) {
         env->ExceptionDescribe();
     }
}

