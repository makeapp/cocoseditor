//
//  GCTestAppDelegate.h
//  GCTest
//
//  Created by Rohan Kuruvilla on 06/08/2012.
//  Copyright __MyCompanyName__ 2012. All rights reserved.
//

#ifndef  _APP_JavaEventListener_H_
#define  _APP_JavaEventListener_H_

#include "cocos2d.h"

using namespace cocos2d;

namespace ccj {
/**
 The reason for implement as private inheritance is to hide some interface call by Director.
 */
class  JavaEventListener : EventListener
{
public:
  static JavaEventListener* create(Type t, const ListenerID& listenerID);

  bool doInit(Type t, const ListenerID& listenerID) ;
  /// Overrides
    virtual bool checkAvailable() override;
    virtual JavaEventListener* clone() override;
};

}
#endif // _APP_JAVAWEBSOCKETDELEGATE_H_

