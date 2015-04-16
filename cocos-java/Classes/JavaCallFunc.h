//
//  GCTestAppDelegate.h
//  GCTest
//
//  Created by Rohan Kuruvilla on 06/08/2012.
//  Copyright __MyCompanyName__ 2012. All rights reserved.
//

#ifndef  _APP_JAVAFUN_H_
#define  _APP_JAVAFUN_H_

#include "CCActionInstant.h"
using namespace cocos2d;
/**
 @brief    The cocos2d Application.

 The reason for implement as private inheritance is to hide some interface call by Director.
 */
namespace ccj{

class  JavaCallFunc : private cocos2d::CallFunc
{
public:
//    JavaCallFunc();
//    virtual ~JavaCallFunc();

    static JavaCallFunc* create();

	
	virtual CallFunc* clone() const override;

    virtual void execute();
};

}
#endif // _APP_JAVAFUN_H_

