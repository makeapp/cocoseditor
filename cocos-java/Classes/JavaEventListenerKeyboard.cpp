//
//  GCTestAppDelegate.h
//  GCTest
//
//  Created by Rohan Kuruvilla on 06/08/2012.
//  Copyright __MyCompanyName__ 2012. All rights reserved.
//


#include "JavaEventListenerKeyboard.h"
#include "JavaEngine.h"

using namespace cocos2d;
using namespace ccj;


JavaEventListenerKeyboard::JavaEventListenerKeyboard(){
  	 }

JavaEventListenerKeyboard::~JavaEventListenerKeyboard(){

}

bool JavaEventListenerKeyboard::init(){

    JNIEnv* env = JavaEngine::getInstance()->getJVMEnv();
	jclass javaClass = env->FindClass("org/ccj/event/EventListenerKeyboard");
	jmethodID handleKeypadPressEventMethod =env->GetStaticMethodID(javaClass, "handleKeypadPressEvent", "(JIJ)V");
	jmethodID  handleKeypadReleaseEventMethod =env->GetStaticMethodID(javaClass, "handleKeypadReleaseEvent", "(JIJ)V");

	this->onKeyPressed = [=](EventKeyboard::KeyCode keyCode, Event* sevent){
			 env->CallStaticVoidMethod(javaClass, handleKeypadPressEventMethod, PTR_TO_JLONG(sevent->getCurrentTarget()),(int)keyCode,PTR_TO_JLONG(sevent));
			 if (env->ExceptionOccurred() != NULL) {
				env->ExceptionDescribe();
			 }
	};

	this->onKeyReleased = [=](EventKeyboard::KeyCode keyCode, Event* sevent){
			 env->CallStaticVoidMethod(javaClass, handleKeypadPressEventMethod, PTR_TO_JLONG(sevent->getCurrentTarget()),(int)keyCode,PTR_TO_JLONG(sevent));
			 if (env->ExceptionOccurred() != NULL) {
				env->ExceptionDescribe();
			 }
	};
}

JavaEventListenerKeyboard* JavaEventListenerKeyboard::create()
{
    JavaEventListenerKeyboard* listener = new JavaEventListenerKeyboard();

    if (listener != nullptr && listener->init())
    {
        listener->autorelease();		
		return listener;
	}
    CC_SAFE_DELETE(listener);
    return nullptr;
}
