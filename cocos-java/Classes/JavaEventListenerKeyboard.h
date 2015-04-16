//
//  GCTestAppDelegate.h
//  GCTest
//
//  Created by Rohan Kuruvilla on 06/08/2012.
//  Copyright __MyCompanyName__ 2012. All rights reserved.
//

#ifndef  _APP_JavaEventListenerKeyboard_H_
#define  _APP_JavaEventListenerKeyboard_H_

#include "cocos2d.h"

using namespace cocos2d;
namespace ccj{
/**
 The reason for implement as private inheritance is to hide some interface call by Director.
 */
class  JavaEventListenerKeyboard : EventListenerKeyboard
{
public:
 static JavaEventListenerKeyboard* create();

 JavaEventListenerKeyboard();

 ~JavaEventListenerKeyboard();
 
  virtual bool init() ;

private:
	
};
}
#endif // _APP_JAVAWEBSOCKETDELEGATE_H_

