//
//  GCTestAppDelegate.h
//  GCTest
//
//  Created by Rohan Kuruvilla on 06/08/2012.
//  Copyright __MyCompanyName__ 2012. All rights reserved.
//


#include "JavaEventListenerCustom.h"
#include "JavaEngine.h"

using namespace cocos2d;
using namespace ccj;

bool JavaEventListenerCustom::doInit(const std::string& eventName){
	 JNIEnv* env = JavaEngine::getInstance()->getJVMEnv();
	 jclass javaClass = env->FindClass("org/ccj/event/EventListenerCustom");
	 jmethodID handleCommonEventMethod =env->GetStaticMethodID(javaClass, "handleEvenCustom", "(Jjava/lang/String;J)V");
	 
	 auto onCallback = [=](EventCustom* sevent){
			 jstring eventName = ccj::JavaEngine::getInstance()->string2jstring(sevent->getEventName());
			 env->CallStaticVoidMethod(javaClass, handleCommonEventMethod, PTR_TO_JLONG(sevent->getCurrentTarget())
				 ,eventName,PTR_TO_JLONG(sevent));
			if (env->ExceptionOccurred() != NULL) {
				env->ExceptionDescribe();
			}
	 };
	this->init(eventName,onCallback);
}

JavaEventListenerCustom* JavaEventListenerCustom::create(const std::string& eventName)
{
    JavaEventListenerCustom* listener = new JavaEventListenerCustom();
	
    if (listener != nullptr && listener->doInit(eventName))
    {
        listener->autorelease();
		return listener;
	}
    CC_SAFE_DELETE(listener);
    return nullptr;
}
