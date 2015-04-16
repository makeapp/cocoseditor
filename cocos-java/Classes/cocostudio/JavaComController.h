//
//  GCTestAppDelegate.h
//  GCTest
//
//  Created by Rohan Kuruvilla on 06/08/2012.
//  Copyright __MyCompanyName__ 2012. All rights reserved.
//

#ifndef  _APP_JAVACOMCONTROLLER_H_
#define  _APP_JAVACOMCONTROLLER_H_

#include "cocostudio/CCComController.h"
#include "CCEventTouch.h"
#include "CCEController.h"
/**
 @brief    The cocos2d Application.

 The reason for implement as private inheritance is to hide some interface call by Director.
 */
class  JavaComController : public cocostudio::ComController
{
public:
        static JavaComController* create();

         /**
         * @js NA
         * @lua NA
         */
        virtual void onEnter() override;
        /**
         * @js NA
         * @lua NA
         */
        virtual void onExit() override;
        virtual void update(float delta) override;
        /**
         * @js NA
         */
        virtual void onAcceleration(cocos2d::Acceleration* acc, cocos2d::Event* event) ;
        /**
         * @js NA
         */
        virtual void onKeyPressed(cocos2d::EventKeyboard::KeyCode keyCode, cocos2d::Event* event) ;
        /**
         * @js NA
         */
        virtual void onKeyReleased(cocos2d::EventKeyboard::KeyCode keyCode, cocos2d::Event* event) ;
        /**
         * @js NA
         */
        virtual bool onTouchBegan(cocos2d::Touch *touch, cocos2d::Event *event);
        /**
         * @js NA
         */
        virtual void onTouchMoved(cocos2d::Touch *touch, cocos2d::Event *event);
        /**
         * @js NA
         */
        virtual void onTouchEnded(cocos2d::Touch *touch, cocos2d::Event *event);
        /**
         * @js NA
         */
        virtual void onTouchCancelled(cocos2d::Touch *touch, cocos2d::Event *event);
        /**
         * @js NA
         */
        virtual void onTouchesBegan(const std::vector<cocos2d::Touch*>& touches, cocos2d::Event *event);
        /**
         * @js NA
         */
        virtual void onTouchesMoved(const std::vector<cocos2d::Touch*>& touches, cocos2d::Event *event);
        /**
         * @js NA
         */
        virtual void onTouchesEnded(const std::vector<cocos2d::Touch*>& touches, cocos2d::Event *event);
        /**
         * @js NA
         */
        virtual void onTouchesCancelled(const std::vector<cocos2d::Touch*>& touches, cocos2d::Event *event);

 private:
 int executeScriptTouchHandler(cocos2d::EventTouch::EventCode eventType, cocos2d::Touch* touch, cocos2d::Event* event);
 int executeScriptTouchesHandler(cocos2d::EventTouch::EventCode eventType, const std::vector<cocos2d::Touch*>& touches, cocos2d::Event* event);

};
#endif // _APP_JAVAFUN_H_

