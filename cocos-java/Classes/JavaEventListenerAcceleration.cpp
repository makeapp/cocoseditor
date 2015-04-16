//
//  GCTestAppDelegate.h
//  GCTest
//
//  Created by Rohan Kuruvilla on 06/08/2012.
//  Copyright __MyCompanyName__ 2012. All rights reserved.
//


#include "JavaEventListenerAcceleration.h"
#include "JavaEngine.h"

using namespace cocos2d;
using namespace ccj;


bool JavaEventListenerAcceleration::doInit(){
	 JNIEnv* env = JavaEngine::getInstance()->getJVMEnv();
	 jclass javaClass = env->FindClass("org/ccj/event/EventListenerAcceleration");
	 jmethodID  handleAccelerometerEventMethod =env->GetStaticMethodID(javaClass, "handleEventAcc", "(JJJ)V");

	auto onAccelerationEvent= [=](Acceleration* acc, Event* sevent){
	
		env->CallStaticVoidMethod(javaClass, handleAccelerometerEventMethod, PTR_TO_JLONG(acc),
          PTR_TO_JLONG(sevent)
          );
		if (env->ExceptionOccurred() != NULL) {
			env->ExceptionDescribe();
		}
	};
	return this->init(onAccelerationEvent);
}

JavaEventListenerAcceleration* JavaEventListenerAcceleration::create()
{
    JavaEventListenerAcceleration* listener = new JavaEventListenerAcceleration();

    if (listener != nullptr && listener->doInit())
    {
        listener->autorelease();
    
		return listener;
	}
    CC_SAFE_DELETE(listener);
    return nullptr;
}
