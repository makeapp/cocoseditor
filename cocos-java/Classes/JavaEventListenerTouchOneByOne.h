//
//  GCTestAppDelegate.h
//  GCTest
//
//  Created by Rohan Kuruvilla on 06/08/2012.
//  Copyright __MyCompanyName__ 2012. All rights reserved.
//

#ifndef  _APP_JavaEventListenerTouchOneByOne_H_
#define  _APP_JavaEventListenerTouchOneByOne_H_

#include "cocos2d.h"
#include "jni.h"
#include "CCPhysicsBody.h"
#include "CCPhysicsContact.h"

using namespace cocos2d;

namespace ccj{

/**
 The reason for implement as private inheritance is to hide some interface call by Director.
 */
class  JavaEventListenerTouchOneByOne : EventListenerTouchOneByOne
{
public:
 static JavaEventListenerTouchOneByOne* create();
 virtual bool init() ;
};
}
#endif // _APP_JAVAWEBSOCKETDELEGATE_H_

