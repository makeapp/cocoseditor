/****************************************************************************
Copyright (c) 2013-2014 Chukong Technologies Inc.

http://www.cocos2d-x.org

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
****************************************************************************/

#include "CCEInputDelegate.h"
#include "base/CCDirector.h"
#include "platform/CCDevice.h"
#include "base/CCEventListenerTouch.h"
#include "base/CCEventListenerAcceleration.h"
#include "base/CCEventListenerKeyboard.h"
#include "base/CCEventDispatcher.h"

using namespace cocos2d;

namespace cce {

CCEInputDelegate::CCEInputDelegate(void)
: _touchEnabled(false)
, _touchListener(nullptr)
, _accelerometerEnabled(false)
, _accelerometerListener(nullptr)
, _keypadEnabled(false)
, _keyboardListener(nullptr)
, _touchPriority(-1)
, _touchMode(Touch::DispatchMode::ALL_AT_ONCE)
{

}

CCEInputDelegate::~CCEInputDelegate(void)
{
    auto dispatcher = Director::getInstance()->getEventDispatcher();
    dispatcher->removeEventListener(_touchListener);
    dispatcher->removeEventListener(_keyboardListener);
    dispatcher->removeEventListener(_accelerometerListener);
    Device::setAccelerometerEnabled(false);
}

bool CCEInputDelegate::onTouchBegan(Touch *pTouch, Event *pEvent)
{
    CC_UNUSED_PARAM(pTouch);
    CC_UNUSED_PARAM(pEvent);
    return true;
}

void CCEInputDelegate::onTouchMoved(Touch *pTouch, Event *pEvent)
{
    CC_UNUSED_PARAM(pTouch);
    CC_UNUSED_PARAM(pEvent);
}
    
void CCEInputDelegate::onTouchEnded(Touch *pTouch, Event *pEvent)
{
    CC_UNUSED_PARAM(pTouch);
    CC_UNUSED_PARAM(pEvent);
}

void CCEInputDelegate::onTouchCancelled(Touch *pTouch, Event *pEvent)
{
    CC_UNUSED_PARAM(pTouch);
    CC_UNUSED_PARAM(pEvent);
}    

void CCEInputDelegate::onTouchesBegan(const std::vector<Touch*>& pTouches, Event *pEvent)
{
    CC_UNUSED_PARAM(pTouches);
    CC_UNUSED_PARAM(pEvent);
}

void CCEInputDelegate::onTouchesMoved(const std::vector<Touch*>& pTouches, Event *pEvent)
{
    CC_UNUSED_PARAM(pTouches);
    CC_UNUSED_PARAM(pEvent);
}

void CCEInputDelegate::onTouchesEnded(const std::vector<Touch*>& pTouches, Event *pEvent)
{
    CC_UNUSED_PARAM(pTouches);
    CC_UNUSED_PARAM(pEvent);
}

void CCEInputDelegate::onTouchesCancelled(const std::vector<Touch*>& pTouches, Event *pEvent)
{
    CC_UNUSED_PARAM(pTouches);
    CC_UNUSED_PARAM(pEvent);
}

bool CCEInputDelegate::isTouchEnabled() const
{
    return _touchEnabled;
}

void CCEInputDelegate::setTouchEnabled(bool enabled)
{
    if (_touchEnabled != enabled)
    {
        auto dispatcher = Director::getInstance()->getEventDispatcher();
        _touchEnabled = enabled;
        if (enabled)
        {            
            if( _touchMode == Touch::DispatchMode::ALL_AT_ONCE ) {
                // Register Touch Event
                auto listener = EventListenerTouchAllAtOnce::create();
                
                listener->onTouchesBegan = CC_CALLBACK_2(CCEInputDelegate::onTouchesBegan, this);
                listener->onTouchesMoved = CC_CALLBACK_2(CCEInputDelegate::onTouchesMoved, this);
                listener->onTouchesEnded = CC_CALLBACK_2(CCEInputDelegate::onTouchesEnded, this);
                listener->onTouchesCancelled = CC_CALLBACK_2(CCEInputDelegate::onTouchesCancelled, this);
                
                dispatcher->addEventListenerWithFixedPriority(listener, _touchPriority);
                _touchListener = listener;
            } else {
                // Register Touch Event
                auto listener = EventListenerTouchOneByOne::create();
                listener->setSwallowTouches(true);
                
                listener->onTouchBegan = CC_CALLBACK_2(CCEInputDelegate::onTouchBegan, this);
                listener->onTouchMoved = CC_CALLBACK_2(CCEInputDelegate::onTouchMoved, this);
                listener->onTouchEnded = CC_CALLBACK_2(CCEInputDelegate::onTouchEnded, this);
                listener->onTouchCancelled = CC_CALLBACK_2(CCEInputDelegate::onTouchCancelled, this);
                
                dispatcher->addEventListenerWithFixedPriority(listener, _touchPriority);
                _touchListener = listener;
            }
        }
        else
        {
            dispatcher->removeEventListener(_touchListener);
        }
    }
}

void CCEInputDelegate::setTouchMode(Touch::DispatchMode mode)
{
    if(_touchMode != mode)
    {
        _touchMode = mode;
        
		if( _touchEnabled)
        {
			setTouchEnabled(false);
			setTouchEnabled(true);
		}
    }
}

void CCEInputDelegate::setTouchPriority(int priority)
{
    if (_touchPriority != priority)
    {
        _touchPriority = priority;
        
		if( _touchEnabled)
        {
			setTouchEnabled(false);
			setTouchEnabled(true);
		}
    }
}

int CCEInputDelegate::getTouchPriority() const
{
    return _touchPriority;
}

Touch::DispatchMode CCEInputDelegate::getTouchMode() const
{
    return _touchMode;
}

bool CCEInputDelegate::isAccelerometerEnabled() const
{
    return _accelerometerEnabled;
}

void CCEInputDelegate::setAccelerometerEnabled(bool enabled)
{
    if (enabled != _accelerometerEnabled)
    {
        _accelerometerEnabled = enabled;

        auto dispatcher = Director::getInstance()->getEventDispatcher();
        dispatcher->removeEventListener(_accelerometerListener);
        _accelerometerListener = nullptr;
        
        Device::setAccelerometerEnabled(enabled);
        
        if (enabled)
        {
            auto listener = EventListenerAcceleration::create(CC_CALLBACK_2(CCEInputDelegate::onAcceleration, this));
            dispatcher->addEventListenerWithFixedPriority(listener, -1);
            _accelerometerListener = listener;
        }
    }
}

bool CCEInputDelegate::isKeypadEnabled() const
{
    return _keypadEnabled;
}

void CCEInputDelegate::setKeypadEnabled(bool enabled)
{
    if (enabled != _keypadEnabled)
    {
        _keypadEnabled = enabled;

        auto dispatcher = Director::getInstance()->getEventDispatcher();
        dispatcher->removeEventListener(_keyboardListener);
        
        if (enabled)
        {
            auto listener = EventListenerKeyboard::create();
            listener->onKeyPressed = CC_CALLBACK_2(CCEInputDelegate::onKeyPressed, this);
            listener->onKeyReleased = CC_CALLBACK_2(CCEInputDelegate::onKeyReleased, this);
            
            dispatcher->addEventListenerWithFixedPriority(listener, -1);
            _keyboardListener = listener;
        }
    }
}


}
