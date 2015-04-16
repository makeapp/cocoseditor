//
//  GCTestAppDelegate.h
//  GCTest
//
//  Created by Rohan Kuruvilla on 06/08/2012.
//  Copyright __MyCompanyName__ 2012. All rights reserved.
//


#include "JavaEventListener.h"
#include "JavaEngine.h"

using namespace cocos2d;
using namespace ccj;

bool JavaEventListener::doInit(Type t, const ListenerID& listenerID){
	JNIEnv* env = JavaEngine::getInstance()->getJVMEnv();
	jclass javaClass = env->FindClass("org/ccj/event/EventListenerJava");
	jmethodID onEventMethod =env->GetStaticMethodID(javaClass, "onEvent", "(JIJ)V");
	
	auto fun = [=](Event* event){
		log("onEvent %d",event->getType());
		env->CallStaticVoidMethod(javaClass, onEventMethod, PTR_TO_JLONG(this),event->getType(), PTR_TO_JLONG(event));
		if (env->ExceptionOccurred() != NULL) {
		  env->ExceptionDescribe();
		}
	};
	this->init(t,listenerID,fun);
	return true;
}

JavaEventListener* JavaEventListener::create(Type t, const ListenerID& listenerID)
{
    JavaEventListener* listener = new JavaEventListener();

    if (listener != nullptr && listener->doInit(t,listenerID))
    {
        listener->autorelease();
		return listener;
	}
    CC_SAFE_DELETE(listener);
    return nullptr;
}

/// Overrides
 bool JavaEventListener::checkAvailable(){
	 return _onEvent!=NULL;
 }

 JavaEventListener* JavaEventListener::clone(){
	auto ret = new (std::nothrow) JavaEventListener();
	if (ret && ret->init(this->getType(),this->getListenerID(),_onEvent))
    {  
        ret->autorelease();
    }
    else
    {
        CC_SAFE_DELETE(ret);
    }
    return ret;
 };
