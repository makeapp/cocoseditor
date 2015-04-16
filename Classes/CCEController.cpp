#include "CCEController.h"
#include "CCScriptSupport.h"
#include "CCNode.h"
USING_NS_CC;
using namespace cce;

CCEController * CCEController::create(){
      CCEController *callFun = new CCEController();
      return callFun;
}

//static bool sendComponentEventToJS(Component* node, int action)
//{
//    auto scriptEngine = ScriptEngineManager::getInstance()->getScriptEngine();
//
//    BasicScriptData data(node,(void*)&action);
//    ScriptEvent scriptEvent(kComponentEvent,(void*)&data);
//    if (scriptEngine->sendEvent(&scriptEvent))
//        return true;
//
//    return false;
//}

static bool sendNodeEventToJS(void* node, int action)
{
    auto scriptEngine = ScriptEngineManager::getInstance()->getScriptEngine();
    BasicScriptData data(node,(void*)&action);
    ScriptEvent scriptEvent(kNodeEvent,(void*)&data);
    if (scriptEngine->sendEvent(&scriptEvent))
        return true;
    return false;
}


/**
* @js NA
* @lua NA
*/
void CCEController::onEnter(){
    sendNodeEventToJS(this,kNodeOnEnter);
}
/**
* @js NA
* @lua NA
*/
void CCEController::onExit() {
   sendNodeEventToJS(this,kNodeOnExit);
}

void CCEController::update(float delta) {
     SchedulerScriptData data(-1,delta,this);
     ScriptEvent event(kScheduleEvent,&data);
     ScriptEngineManager::getInstance()->getScriptEngine()->sendEvent(&event);
}


/**
 * @js NA
 */
 void CCEController::onAcceleration(cocos2d::Acceleration* acc, cocos2d::Event* unused_event) {
         BasicScriptData data(this,(void*)acc);
         ScriptEvent event(kAccelerometerEvent,&data);
         ScriptEngineManager::getInstance()->getScriptEngine()->sendEvent(&event);
 };

/**
 * @js NA
 */
 void CCEController::onKeyPressed(cocos2d::EventKeyboard::KeyCode keyCode, cocos2d::Event* unused_event) {
       KeypadScriptData data(keyCode, this);
       ScriptEvent event(kKeypadEventPress,&data);
       ScriptEngineManager::getInstance()->getScriptEngine()->sendEvent(&event);
 };
/**
 * @js NA
 */
 void CCEController::onKeyReleased(cocos2d::EventKeyboard::KeyCode keyCode, cocos2d::Event* unused_event) {
       KeypadScriptData data(keyCode, this);
       ScriptEvent event(kKeypadEventRelease,&data);
       ScriptEngineManager::getInstance()->getScriptEngine()->sendEvent(&event);
 };

int CCEController::executeScriptTouchHandler(cocos2d::EventTouch::EventCode eventType, cocos2d::Touch* touch, cocos2d::Event* event)
{
      TouchScriptData data(eventType, this, touch, event);
      ScriptEvent scriptEvent(kTouchEvent, &data);
      return ScriptEngineManager::getInstance()->getScriptEngine()->sendEvent(&scriptEvent);
}

int CCEController::executeScriptTouchesHandler(cocos2d::EventTouch::EventCode eventType, const std::vector<Touch*>& touches, cocos2d::Event* event)
{
    TouchesScriptData data(eventType, this, touches, event);
    ScriptEvent scriptEvent(kTouchesEvent, &data);
    return ScriptEngineManager::getInstance()->getScriptEngine()->sendEvent(&scriptEvent);
}

/**
 * @js NA
 */
 bool CCEController::onTouchBegan(cocos2d::Touch *touch, cocos2d::Event *event){
    return executeScriptTouchHandler(EventTouch::EventCode::BEGAN, touch, event) == 0 ? false : true;
 }

/**
 * @js NA
 */
 void CCEController::onTouchMoved(cocos2d::Touch *touch, cocos2d::Event *event){
     executeScriptTouchHandler(EventTouch::EventCode::MOVED, touch, event);
 }
/**
 * @js NA
 */
 void CCEController::onTouchEnded(cocos2d::Touch *touch, cocos2d::Event *event){
         executeScriptTouchHandler(EventTouch::EventCode::ENDED, touch, event);
 }
/**
 * @js NA
 */
 void CCEController::onTouchCancelled(cocos2d::Touch *touch, cocos2d::Event *event){
         executeScriptTouchHandler(EventTouch::EventCode::CANCELLED, touch, event);
 }
/**
 * @js NA
 */
 void CCEController::onTouchesBegan(const std::vector<cocos2d::Touch*>& touches, cocos2d::Event *event){
         executeScriptTouchesHandler(EventTouch::EventCode::BEGAN, touches, event);
 }
/**
 * @js NA
 */
 void CCEController::onTouchesMoved(const std::vector<cocos2d::Touch*>& touches, cocos2d::Event *event){
         executeScriptTouchesHandler(EventTouch::EventCode::MOVED, touches, event);
 }
/**
 * @js NA
 */
 void CCEController::onTouchesEnded(const std::vector<cocos2d::Touch*>& touches, cocos2d::Event *event){
         executeScriptTouchesHandler(EventTouch::EventCode::ENDED, touches, event);
 }
/**
 * @js NA
 */
 void CCEController::onTouchesCancelled(const std::vector<cocos2d::Touch*>& touches, cocos2d::Event *event){
         executeScriptTouchesHandler(EventTouch::EventCode::CANCELLED, touches, event);
 }

