//
//  GCTestAppDelegate.h
//  GCTest
//
//  Created by Rohan Kuruvilla on 06/08/2012.
//  Copyright __MyCompanyName__ 2012. All rights reserved.
//


#include "JavaEventListenerTouchAllAtOnce.h"
#include "JavaEngine.h"

using namespace cocos2d;
using namespace ccj;

bool JavaEventListenerTouchAllAtOnce::init(){
	EventListenerTouchAllAtOnce::init();
	 JNIEnv* env = JavaEngine::getInstance()->getJVMEnv();
	 jclass javaClass = env->FindClass("org/ccj/event/EventListenerTouchAllAtOnce");
	 jmethodID handleTouchesEventMethod =env->GetStaticMethodID(javaClass, "handleTouchesEvent", "(J[JIJ)V");

	this->onTouchesBegan = [=](const std::vector<Touch*>& touches, Event* event){
				EventTouch *eventTouch = (EventTouch*)event;	
				int size = touches.size();
				jlongArray touchArray = env->NewLongArray(size);
				int i=0;
				for (auto& touch : touches)
				{
					jlong touchAddress = PTR_TO_JLONG(touch);
					env->SetLongArrayRegion(touchArray,i,i+1,&touchAddress);
					i++;
				}
				

				env->CallStaticVoidMethod(javaClass, handleTouchesEventMethod,
					PTR_TO_JLONG(this),touchArray,
					eventTouch->getEventCode(),
					PTR_TO_JLONG(event));
				if (env->ExceptionOccurred() != NULL) {
					env->ExceptionDescribe();
				}		

			};

		this->onTouchesMoved = this->onTouchesBegan;
		this->onTouchesEnded = this->onTouchesBegan;
		this->onTouchesCancelled =this->onTouchesBegan;
		return true;
}

JavaEventListenerTouchAllAtOnce* JavaEventListenerTouchAllAtOnce::create()
{
    JavaEventListenerTouchAllAtOnce* listener = new JavaEventListenerTouchAllAtOnce();

    if (listener != nullptr && listener->init())
    {
        listener->autorelease();
    

		
		return listener;
	}
    CC_SAFE_DELETE(listener);
    return nullptr;
}
