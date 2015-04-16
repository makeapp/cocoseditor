//
//  GCTestAppDelegate.h
//  GCTest
//
//  Created by Rohan Kuruvilla on 06/08/2012.
//  Copyright __MyCompanyName__ 2012. All rights reserved.
//


#include "JavaPhysicsContactListener.h"
#include "JavaEngine.h"

using namespace cocos2d;
using namespace ccj;

JavaPhysicsContactListener* JavaPhysicsContactListener::create()
{
    JavaPhysicsContactListener* obj = new JavaPhysicsContactListener();

    if (obj != nullptr && obj->init())
    {
        obj->autorelease();
        return obj;
    }

    CC_SAFE_DELETE(obj);
    return nullptr;
}


 bool JavaPhysicsContactListener::handleContactBegin(PhysicsContact& contact){
//    CCLOG("handleContactBegin %d",contact);

    JNIEnv* env = ccj::JavaEngine::getInstance()->getJVMEnv();

    jclass jvmClass = env->FindClass("org/ccj/physics/PhysicsContactListener");
    jmethodID onContactBeginM = env->GetStaticMethodID(jvmClass,"onContactBegin","(JJ)Z");

    return  env->CallStaticBooleanMethod(jvmClass, onContactBeginM,(jlong)PTR_TO_JLONG(this),(jlong)PTR_TO_JLONG(&contact));
    if (env->ExceptionOccurred() != NULL) {
        env->ExceptionDescribe();
    }

    return false;
 }

 bool JavaPhysicsContactListener::handleContactPreSolve(PhysicsContact& contact, PhysicsContactPreSolve& solve){
//    CCLOG("handleContactPreSolve %d",contact);

    JNIEnv* env = ccj::JavaEngine::getInstance()->getJVMEnv();

      jclass jvmClass = env->FindClass("org/ccj/physics/PhysicsContactListener");
      jmethodID onContactPreSolveM = env->GetStaticMethodID(jvmClass,"onContactPreSolve","(JJJ)Z");

      return  env->CallStaticBooleanMethod(jvmClass, onContactPreSolveM,(jlong)PTR_TO_JLONG(this),(jlong)PTR_TO_JLONG(&contact),(jlong)PTR_TO_JLONG(&solve));
      if (env->ExceptionOccurred() != NULL) {
          env->ExceptionDescribe();
      }

    return false;
 }

 void JavaPhysicsContactListener::handleContactPostSolve(PhysicsContact& contact, const PhysicsContactPostSolve& solve){

//               CCLOG("handleContactPostSolve %d",contact);

    JNIEnv* env = ccj::JavaEngine::getInstance()->getJVMEnv();

             jclass jvmClass = env->FindClass("org/ccj/physics/PhysicsContactListener");
             jmethodID onContactPreSolveM = env->GetStaticMethodID(jvmClass,"onContactPostSolve","(JJJ)V");

               env->CallStaticVoidMethod(jvmClass, onContactPreSolveM,(jlong)PTR_TO_JLONG(this),(jlong)PTR_TO_JLONG(&contact),(jlong)PTR_TO_JLONG(&solve));
             if (env->ExceptionOccurred() != NULL) {
                 env->ExceptionDescribe();
             }


 }

 void JavaPhysicsContactListener::handleContactSeperate(PhysicsContact& contact){
//               CCLOG("handleContactSeperate %d",contact);
    JNIEnv* env = ccj::JavaEngine::getInstance()->getJVMEnv();

    jclass jvmClass = env->FindClass("org/ccj/physics/PhysicsContactListener");
    jmethodID onContactSeperateM = env->GetStaticMethodID(jvmClass,"onContactSeperate","(JJ)V");

    env->CallStaticVoidMethod(jvmClass, onContactSeperateM,(jlong)PTR_TO_JLONG(this),(jlong)PTR_TO_JLONG(&contact));
    if (env->ExceptionOccurred() != NULL) {
        env->ExceptionDescribe();
    }
 }
