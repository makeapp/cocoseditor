//
//  GCTestAppDelegate.h
//  GCTest
//
//  Created by Rohan Kuruvilla on 06/08/2012.
//  Copyright __MyCompanyName__ 2012. All rights reserved.
//


#include "JavaEventListenerTouchOneByOne.h"
#include "JavaEngine.h"

using namespace cocos2d;
using namespace ccj;


bool JavaEventListenerTouchOneByOne::init(){
	 EventListenerTouchOneByOne::init();
	 JNIEnv* env = JavaEngine::getInstance()->getJVMEnv();
	 jclass javaClass = env->FindClass("org/ccj/event/EventListenerTouchOneByOne");
	 jmethodID handleTouchEventMethod =env->GetStaticMethodID(javaClass, "handleTouchEvent", "(JJIJ)I");

	this->onTouchBegan = [=](Touch *touch, Event* event){
			int ret=1;
		    ret = env->CallStaticIntMethod(javaClass, handleTouchEventMethod,
				   PTR_TO_JLONG(this),
				   PTR_TO_JLONG(touch), 
				   EventTouch::EventCode::BEGAN,
				   PTR_TO_JLONG(event));
			if (env->ExceptionOccurred() != NULL) {
				env->ExceptionDescribe();
			}
			return ret>0;
		};

		this->onTouchMoved = [=](Touch *touch, Event* event){
			int ret=1;
		    ret = env->CallStaticIntMethod(javaClass, handleTouchEventMethod,
				   PTR_TO_JLONG(this),
				   PTR_TO_JLONG(touch), 
				   EventTouch::EventCode::MOVED,
				   PTR_TO_JLONG(event));
			if (env->ExceptionOccurred() != NULL) {
				env->ExceptionDescribe();
			}
		};

		this->onTouchEnded = [=](Touch *touch, Event* event){
			int ret=1;
		    ret = env->CallStaticIntMethod(javaClass, handleTouchEventMethod,
				   PTR_TO_JLONG(this),
				   PTR_TO_JLONG(touch), 
				   EventTouch::EventCode::ENDED,
				   PTR_TO_JLONG(event));
			if (env->ExceptionOccurred() != NULL) {
				env->ExceptionDescribe();
			}
		};

		this->onTouchCancelled = [=](Touch *touch, Event* event){
			int ret=1;
		    ret = env->CallStaticIntMethod(javaClass, handleTouchEventMethod,
				   PTR_TO_JLONG(this),
				   PTR_TO_JLONG(touch), 
				   EventTouch::EventCode::CANCELLED,
				   PTR_TO_JLONG(event));
			if (env->ExceptionOccurred() != NULL) {
				env->ExceptionDescribe();
			}
		};
		return true;
}

JavaEventListenerTouchOneByOne* JavaEventListenerTouchOneByOne::create()
{
    JavaEventListenerTouchOneByOne* listener = new JavaEventListenerTouchOneByOne();

    if (listener != nullptr && listener->init())
    {
        listener->autorelease();
    

		
		return listener;
	}
    CC_SAFE_DELETE(listener);
    return nullptr;
}
