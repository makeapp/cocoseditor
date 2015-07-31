//
//  GCTestAppDelegate.h
//  GCTest
//
//  Created by Rohan Kuruvilla on 06/08/2012.
//  Copyright __MyCompanyName__ 2012. All rights reserved.
//

#ifndef  _APP_JAVAEVENTLISTENERPHYSICSCONTACT_H_
#define  _APP_JAVAEVENTLISTENERPHYSICSCONTACT_H_

#include "cocos2d.h"
#include "jni.h"
#include "CCPhysicsBody.h"
#include "CCPhysicsContact.h"

using namespace cocos2d;
namespace ccj{
/**
 The reason for implement as private inheritance is to hide some interface call by Director.
 */
class  JavaPhysicsContactListener : EventListenerPhysicsContact
{
public:
 static JavaPhysicsContactListener* create();

 void regContactBegin(){
   this->onContactBegin = CC_CALLBACK_1(JavaPhysicsContactListener::handleContactBegin, this);
 };

 void regContactPreSolve(){
    this->onContactPreSolve =CC_CALLBACK_2(JavaPhysicsContactListener::handleContactPreSolve, this);
 }

 void regContactPostSolve(){
    this->onContactPostSolve =CC_CALLBACK_2(JavaPhysicsContactListener::handleContactPostSolve, this);
 }
 void regContactSeperate(){
    //this->onContactSeperate= CC_CALLBACK_1(JavaPhysicsContactListener::handleContactSeperate, this);
 }

 bool handleContactBegin(PhysicsContact& contact);
 bool handleContactPreSolve(PhysicsContact& contact, PhysicsContactPreSolve& solve);
 void handleContactPostSolve(PhysicsContact& contact, const PhysicsContactPostSolve& solve);
 void handleContactSeperate(PhysicsContact& contact);

};

}
#endif // _APP_JAVAWEBSOCKETDELEGATE_H_

