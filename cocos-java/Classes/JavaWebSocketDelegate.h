//
//  GCTestAppDelegate.h
//  GCTest
//
//  Created by Rohan Kuruvilla on 06/08/2012.
//  Copyright __MyCompanyName__ 2012. All rights reserved.
//

#ifndef  _APP_JAVAWEBSOCKETDELEGATE_H_
#define  _APP_JAVAWEBSOCKETDELEGATE_H_

#include "cocos2d.h"
#include "jni.h"
#include "network/WebSocket.h"

using namespace cocos2d::network;

namespace ccj{

struct WebSocketScriptData
{
    WebSocket* ws;
    int action;
    void * data;
};

/**
 The reason for implement as private inheritance is to hide some interface call by Director.
 */
class  JavaWebSocketDelegate : WebSocket::Delegate
{
public:
      void init(JNIEnv* env, jobject obj)
       {
//         jvmEnv=env;
         jvmObject = env->NewWeakGlobalRef(obj);
//         env->DeleteLocalRef(obj);
//         jvmClass = env->GetObjectClass(jvmObject);
//         onOpenMethod = env->GetMethodID(jvmClass,"onOpen","()V");
//         onCloseMethod = env->GetMethodID(jvmClass,"onClose","()V");
//         onMessageMethod = env->GetMethodID(jvmClass,"onMessage","([BZ)V");
//         onErrorMethod = env->GetMethodID(jvmClass,"onClose","(I)V");
       }

      void onOpen(WebSocket* ws);
      void onMessage(WebSocket* ws, const WebSocket::Data& data) ;
      void onClose(WebSocket* ws);
      void onError(WebSocket* ws, const WebSocket::ErrorCode& error) ;
private:
      JNIEnv* jvmEnv;
      jobject jvmObject;
      jclass  jvmClass;
      jmethodID onOpenMethod;
      jmethodID onCloseMethod;
      jmethodID onErrorMethod;
      jmethodID onMessageMethod;

};

}
#endif // _APP_JAVAWEBSOCKETDELEGATE_H_

