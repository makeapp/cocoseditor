#ifndef __cocos2dx_cocoseditor_h__
#define __cocos2dx_cocoseditor_h__

#include "jsapi.h"
#include "jsfriendapi.h"


extern JSClass  *jsb_cce_CCEChannel_class;
extern JSObject *jsb_cce_CCEChannel_prototype;

bool js_cocos2dx_cocoseditor_CCEChannel_constructor(JSContext *cx, uint32_t argc, jsval *vp);
void js_cocos2dx_cocoseditor_CCEChannel_finalize(JSContext *cx, JSObject *obj);
void js_register_cocos2dx_cocoseditor_CCEChannel(JSContext *cx, JSObject *global);
void register_all_cocos2dx_cocoseditor(JSContext* cx, JSObject* obj);
bool js_cocos2dx_cocoseditor_CCEChannel_setUnitTime(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEChannel_insertFrame(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEChannel_setAnimation(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEChannel_setDelay(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEChannel_clearAllFrame(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEChannel_setType(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEChannel_getBezierActions(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEChannel_setNode(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEChannel_getSplineActions(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEChannel_getNormalActions(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEChannel_getActions(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEChannel_getChannelCallback(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEChannel_getType(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEChannel_addFrame(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEChannel_getUnitTime(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEChannel_setLoop(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEChannel_setChannelCallback(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEChannel_getDelay(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEChannel_getAnimation(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEChannel_deleteFrame(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEChannel_getSpriteActions(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEChannel_getNode(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEChannel_create(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEChannel_CCEChannel(JSContext *cx, uint32_t argc, jsval *vp);

extern JSClass  *jsb_cce_CCEAnimation_class;
extern JSObject *jsb_cce_CCEAnimation_prototype;

bool js_cocos2dx_cocoseditor_CCEAnimation_constructor(JSContext *cx, uint32_t argc, jsval *vp);
void js_cocos2dx_cocoseditor_CCEAnimation_finalize(JSContext *cx, JSObject *obj);
void js_register_cocos2dx_cocoseditor_CCEAnimation(JSContext *cx, JSObject *global);
void register_all_cocos2dx_cocoseditor(JSContext* cx, JSObject* obj);
bool js_cocos2dx_cocoseditor_CCEAnimation_getNext(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEAnimation_setUnitTime(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEAnimation_setActionTag(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEAnimation_setNext(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEAnimation_getObject(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEAnimation_createActions(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEAnimation_isActionDoneOnce(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEAnimation_setMain(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEAnimation_getOrCreateChannel(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEAnimation_setDelay(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEAnimation_setObject(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEAnimation_getName(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEAnimation_fireAnimationEvent(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEAnimation_getActionTag(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEAnimation_onAnimationEnd(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEAnimation_playAction(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEAnimation_setSrc(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEAnimation_setName(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEAnimation_getChannels(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEAnimation_getAutoRun(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEAnimation_getLoop(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEAnimation_setCallback(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEAnimation_getDuration(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEAnimation_addChannel(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEAnimation_getUnitTime(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEAnimation_isPlaying(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEAnimation_setLoop(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEAnimation_getDelay(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEAnimation_getActionNode(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEAnimation_getSrc(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEAnimation_isMain(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEAnimation_setAutoRun(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEAnimation_setDuration(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEAnimation_stopAction(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEAnimation_addCallback(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEAnimation_create(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEAnimation_CCEAnimation(JSContext *cx, uint32_t argc, jsval *vp);

extern JSClass  *jsb_cce_CCEAnimationManager_class;
extern JSObject *jsb_cce_CCEAnimationManager_prototype;

bool js_cocos2dx_cocoseditor_CCEAnimationManager_constructor(JSContext *cx, uint32_t argc, jsval *vp);
void js_cocos2dx_cocoseditor_CCEAnimationManager_finalize(JSContext *cx, JSObject *obj);
void js_register_cocos2dx_cocoseditor_CCEAnimationManager(JSContext *cx, JSObject *global);
void register_all_cocos2dx_cocoseditor(JSContext* cx, JSObject* obj);
bool js_cocos2dx_cocoseditor_CCEAnimationManager_play(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEAnimationManager_addAnimation(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEAnimationManager_setAutoPlayNext(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEAnimationManager_playAuto(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEAnimationManager_stop(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEAnimationManager_isAutoPlayNext(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEAnimationManager_stopAll(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEAnimationManager_addCallFun(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEAnimationManager_addCallback(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEAnimationManager_setChannelCallback(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEAnimationManager_setAnimationCallback(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEAnimationManager_create(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEAnimationManager_CCEAnimationManager(JSContext *cx, uint32_t argc, jsval *vp);

extern JSClass  *jsb_cce_CCEEventHandler_class;
extern JSObject *jsb_cce_CCEEventHandler_prototype;

bool js_cocos2dx_cocoseditor_CCEEventHandler_constructor(JSContext *cx, uint32_t argc, jsval *vp);
void js_cocos2dx_cocoseditor_CCEEventHandler_finalize(JSContext *cx, JSObject *obj);
void js_register_cocos2dx_cocoseditor_CCEEventHandler(JSContext *cx, JSObject *global);
void register_all_cocos2dx_cocoseditor(JSContext* cx, JSObject* obj);
bool js_cocos2dx_cocoseditor_CCEEventHandler_addAction(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEEventHandler_doKeyEvent(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEEventHandler_handleActions(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEEventHandler_handleNodeEvent(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEEventHandler_getEventName(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEEventHandler_getEventArg(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEEventHandler_getNode(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEEventHandler_create(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEEventHandler_CCEEventHandler(JSContext *cx, uint32_t argc, jsval *vp);

extern JSClass  *jsb_cce_CCEReader_class;
extern JSObject *jsb_cce_CCEReader_prototype;

bool js_cocos2dx_cocoseditor_CCEReader_constructor(JSContext *cx, uint32_t argc, jsval *vp);
void js_cocos2dx_cocoseditor_CCEReader_finalize(JSContext *cx, JSObject *obj);
void js_register_cocos2dx_cocoseditor_CCEReader(JSContext *cx, JSObject *global);
void register_all_cocos2dx_cocoseditor(JSContext* cx, JSObject* obj);
bool js_cocos2dx_cocoseditor_CCEReader_getLabel(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEReader_getAnimationManager(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEReader_getPhysicsJointGear(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEReader_getCCEReaderByIndex(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEReader_getPhysicsShapeCircle(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEReader_stopAllAnimation(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEReader_playAutoAnimations(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEReader_getPhysicsJointFixed(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEReader_getCCEReader(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEReader_getMenuItem(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEReader_getRef(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEReader_getPhysicsJointRotarySpring(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEReader_getMenu(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEReader_getPhysicsShapeEdgePolygon(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEReader_getSprite(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEReader_getPhysicsJointDistance(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEReader_getComponentNodes(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEReader_getLayer(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEReader_stopAnimation(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEReader_getPhysicsJointLimit(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEReader_read(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEReader_getAnimation(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEReader_getPhysicsShapePolygon(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEReader_playAnimation(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEReader_getPhysicsJointRotaryLimit(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEReader_getPhysicsShapeEdgeChain(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEReader_getWidget(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEReader_getPhysicsBody(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEReader_getPhysicsShapeEdgeSegment(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEReader_getPhysicsShape(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEReader_getPhysicsJointGroove(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEReader_getPhysicsJoint(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEReader_getPhysicsShapeEdgeBox(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEReader_getPhysicsJointMotor(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEReader_getEventHandlers(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEReader_getComponentNames(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEReader_getPhysicsShapeBox(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEReader_getScene(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEReader_getCCEReaderSize(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEReader_getPhysicsJointRatchet(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEReader_getPhysicsJointPin(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEReader_getNode(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEReader_getPhysicsJointSpring(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEReader_create(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEReader_getSpritePixelsColor(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEReader_getPixelsColor(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_CCEReader_CCEReader(JSContext *cx, uint32_t argc, jsval *vp);

extern JSClass  *jsb_cce_FunctionFactory_class;
extern JSObject *jsb_cce_FunctionFactory_prototype;

bool js_cocos2dx_cocoseditor_FunctionFactory_constructor(JSContext *cx, uint32_t argc, jsval *vp);
void js_cocos2dx_cocoseditor_FunctionFactory_finalize(JSContext *cx, JSObject *obj);
void js_register_cocos2dx_cocoseditor_FunctionFactory(JSContext *cx, JSObject *global);
void register_all_cocos2dx_cocoseditor(JSContext* cx, JSObject* obj);
bool js_cocos2dx_cocoseditor_FunctionFactory_registerCallbackFunction(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_FunctionFactory_callFunction(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_FunctionFactory_registerFunction(JSContext *cx, uint32_t argc, jsval *vp);
bool js_cocos2dx_cocoseditor_FunctionFactory_getInstance(JSContext *cx, uint32_t argc, jsval *vp);
#endif

