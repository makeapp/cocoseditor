#include "jsb_cocos2dx_cocoseditor_auto.hpp"
#include "cocos2d_specifics.hpp"
#include "CCEReader.h"
#include "CCEEventHandler.h"
#include "CCEAnimation.h"
#include "CCEAnimationManager.h"
#include "CCEChannel.h"
#include "FunctionFactory.h"

template<class T>
static bool dummy_constructor(JSContext *cx, uint32_t argc, jsval *vp) {
    JS::RootedValue initializing(cx);
    bool isNewValid = true;
    JSObject* global = ScriptingCore::getInstance()->getGlobalObject();
    isNewValid = JS_GetProperty(cx, global, "initializing", &initializing) && JSVAL_TO_BOOLEAN(initializing);
    if (isNewValid)
    {
        TypeTest<T> t;
        js_type_class_t *typeClass = nullptr;
        std::string typeName = t.s_name();
        auto typeMapIter = _js_global_type_map.find(typeName);
        CCASSERT(typeMapIter != _js_global_type_map.end(), "Can't find the class type!");
        typeClass = typeMapIter->second;
        CCASSERT(typeClass, "The value is null.");

        JSObject *_tmp = JS_NewObject(cx, typeClass->jsclass, typeClass->proto, typeClass->parentProto);
        JS_SET_RVAL(cx, vp, OBJECT_TO_JSVAL(_tmp));
        return true;
    }

    JS_ReportError(cx, "Constructor for the requested class is not available, please refer to the API reference.");
    return false;
}

static bool empty_constructor(JSContext *cx, uint32_t argc, jsval *vp) {
    return false;
}

static bool js_is_native_obj(JSContext *cx, JS::HandleObject obj, JS::HandleId id, JS::MutableHandleValue vp)
{
    vp.set(BOOLEAN_TO_JSVAL(true));
    return true;    
}
JSClass  *jsb_cce_CCEChannel_class;
JSObject *jsb_cce_CCEChannel_prototype;

bool js_cocos2dx_cocoseditor_CCEChannel_setUnitTime(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEChannel* cobj = (cce::CCEChannel *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEChannel_setUnitTime : Invalid Native Object");
    if (argc == 1) {
        double arg0;
        ok &= JS::ToNumber( cx, JS::RootedValue(cx, argv[0]), &arg0);
        JSB_PRECONDITION2(ok, cx, false, "js_cocos2dx_cocoseditor_CCEChannel_setUnitTime : Error processing arguments");
        cobj->setUnitTime(arg0);
        JS_SET_RVAL(cx, vp, JSVAL_VOID);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEChannel_setUnitTime : wrong number of arguments: %d, was expecting %d", argc, 1);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEChannel_insertFrame(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEChannel* cobj = (cce::CCEChannel *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEChannel_insertFrame : Invalid Native Object");
    if (argc == 2) {
        int arg0;
        cce::CCEKeyFrame* arg1;
        ok &= jsval_to_int32(cx, argv[0], (int32_t *)&arg0);
        do {
            if (!argv[1].isObject()) { ok = false; break; }
            js_proxy_t *jsProxy;
            JSObject *tmpObj = JSVAL_TO_OBJECT(argv[1]);
            jsProxy = jsb_get_js_proxy(tmpObj);
            arg1 = (cce::CCEKeyFrame*)(jsProxy ? jsProxy->ptr : NULL);
            JSB_PRECONDITION2( arg1, cx, false, "Invalid Native Object");
        } while (0);
        JSB_PRECONDITION2(ok, cx, false, "js_cocos2dx_cocoseditor_CCEChannel_insertFrame : Error processing arguments");
        cobj->insertFrame(arg0, arg1);
        JS_SET_RVAL(cx, vp, JSVAL_VOID);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEChannel_insertFrame : wrong number of arguments: %d, was expecting %d", argc, 2);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEChannel_setAnimation(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEChannel* cobj = (cce::CCEChannel *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEChannel_setAnimation : Invalid Native Object");
    if (argc == 1) {
        cce::CCEAnimation* arg0;
        do {
            if (!argv[0].isObject()) { ok = false; break; }
            js_proxy_t *jsProxy;
            JSObject *tmpObj = JSVAL_TO_OBJECT(argv[0]);
            jsProxy = jsb_get_js_proxy(tmpObj);
            arg0 = (cce::CCEAnimation*)(jsProxy ? jsProxy->ptr : NULL);
            JSB_PRECONDITION2( arg0, cx, false, "Invalid Native Object");
        } while (0);
        JSB_PRECONDITION2(ok, cx, false, "js_cocos2dx_cocoseditor_CCEChannel_setAnimation : Error processing arguments");
        cobj->setAnimation(arg0);
        JS_SET_RVAL(cx, vp, JSVAL_VOID);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEChannel_setAnimation : wrong number of arguments: %d, was expecting %d", argc, 1);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEChannel_setDelay(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEChannel* cobj = (cce::CCEChannel *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEChannel_setDelay : Invalid Native Object");
    if (argc == 1) {
        double arg0;
        ok &= JS::ToNumber( cx, JS::RootedValue(cx, argv[0]), &arg0);
        JSB_PRECONDITION2(ok, cx, false, "js_cocos2dx_cocoseditor_CCEChannel_setDelay : Error processing arguments");
        cobj->setDelay(arg0);
        JS_SET_RVAL(cx, vp, JSVAL_VOID);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEChannel_setDelay : wrong number of arguments: %d, was expecting %d", argc, 1);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEChannel_clearAllFrame(JSContext *cx, uint32_t argc, jsval *vp)
{
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEChannel* cobj = (cce::CCEChannel *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEChannel_clearAllFrame : Invalid Native Object");
    if (argc == 0) {
        cobj->clearAllFrame();
        JS_SET_RVAL(cx, vp, JSVAL_VOID);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEChannel_clearAllFrame : wrong number of arguments: %d, was expecting %d", argc, 0);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEChannel_setType(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEChannel* cobj = (cce::CCEChannel *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEChannel_setType : Invalid Native Object");
    if (argc == 1) {
        std::string arg0;
        ok &= jsval_to_std_string(cx, argv[0], &arg0);
        JSB_PRECONDITION2(ok, cx, false, "js_cocos2dx_cocoseditor_CCEChannel_setType : Error processing arguments");
        cobj->setType(arg0);
        JS_SET_RVAL(cx, vp, JSVAL_VOID);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEChannel_setType : wrong number of arguments: %d, was expecting %d", argc, 1);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEChannel_getBezierActions(JSContext *cx, uint32_t argc, jsval *vp)
{
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEChannel* cobj = (cce::CCEChannel *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEChannel_getBezierActions : Invalid Native Object");
    if (argc == 0) {
        cocos2d::FiniteTimeAction* ret = cobj->getBezierActions();
        jsval jsret = JSVAL_NULL;
        do {
            if (ret) {
                js_proxy_t *jsProxy = js_get_or_create_proxy<cocos2d::FiniteTimeAction>(cx, (cocos2d::FiniteTimeAction*)ret);
                jsret = OBJECT_TO_JSVAL(jsProxy->obj);
            } else {
                jsret = JSVAL_NULL;
            }
        } while (0);
        JS_SET_RVAL(cx, vp, jsret);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEChannel_getBezierActions : wrong number of arguments: %d, was expecting %d", argc, 0);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEChannel_setNode(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEChannel* cobj = (cce::CCEChannel *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEChannel_setNode : Invalid Native Object");
    if (argc == 1) {
        cocos2d::Node* arg0;
        do {
            if (!argv[0].isObject()) { ok = false; break; }
            js_proxy_t *jsProxy;
            JSObject *tmpObj = JSVAL_TO_OBJECT(argv[0]);
            jsProxy = jsb_get_js_proxy(tmpObj);
            arg0 = (cocos2d::Node*)(jsProxy ? jsProxy->ptr : NULL);
            JSB_PRECONDITION2( arg0, cx, false, "Invalid Native Object");
        } while (0);
        JSB_PRECONDITION2(ok, cx, false, "js_cocos2dx_cocoseditor_CCEChannel_setNode : Error processing arguments");
        cobj->setNode(arg0);
        JS_SET_RVAL(cx, vp, JSVAL_VOID);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEChannel_setNode : wrong number of arguments: %d, was expecting %d", argc, 1);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEChannel_getSplineActions(JSContext *cx, uint32_t argc, jsval *vp)
{
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEChannel* cobj = (cce::CCEChannel *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEChannel_getSplineActions : Invalid Native Object");
    if (argc == 0) {
        cocos2d::FiniteTimeAction* ret = cobj->getSplineActions();
        jsval jsret = JSVAL_NULL;
        do {
            if (ret) {
                js_proxy_t *jsProxy = js_get_or_create_proxy<cocos2d::FiniteTimeAction>(cx, (cocos2d::FiniteTimeAction*)ret);
                jsret = OBJECT_TO_JSVAL(jsProxy->obj);
            } else {
                jsret = JSVAL_NULL;
            }
        } while (0);
        JS_SET_RVAL(cx, vp, jsret);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEChannel_getSplineActions : wrong number of arguments: %d, was expecting %d", argc, 0);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEChannel_getNormalActions(JSContext *cx, uint32_t argc, jsval *vp)
{
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEChannel* cobj = (cce::CCEChannel *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEChannel_getNormalActions : Invalid Native Object");
    if (argc == 0) {
        cocos2d::FiniteTimeAction* ret = cobj->getNormalActions();
        jsval jsret = JSVAL_NULL;
        do {
            if (ret) {
                js_proxy_t *jsProxy = js_get_or_create_proxy<cocos2d::FiniteTimeAction>(cx, (cocos2d::FiniteTimeAction*)ret);
                jsret = OBJECT_TO_JSVAL(jsProxy->obj);
            } else {
                jsret = JSVAL_NULL;
            }
        } while (0);
        JS_SET_RVAL(cx, vp, jsret);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEChannel_getNormalActions : wrong number of arguments: %d, was expecting %d", argc, 0);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEChannel_getActions(JSContext *cx, uint32_t argc, jsval *vp)
{
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEChannel* cobj = (cce::CCEChannel *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEChannel_getActions : Invalid Native Object");
    if (argc == 0) {
        cocos2d::FiniteTimeAction* ret = cobj->getActions();
        jsval jsret = JSVAL_NULL;
        do {
            if (ret) {
                js_proxy_t *jsProxy = js_get_or_create_proxy<cocos2d::FiniteTimeAction>(cx, (cocos2d::FiniteTimeAction*)ret);
                jsret = OBJECT_TO_JSVAL(jsProxy->obj);
            } else {
                jsret = JSVAL_NULL;
            }
        } while (0);
        JS_SET_RVAL(cx, vp, jsret);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEChannel_getActions : wrong number of arguments: %d, was expecting %d", argc, 0);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEChannel_getChannelCallback(JSContext *cx, uint32_t argc, jsval *vp)
{
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEChannel* cobj = (cce::CCEChannel *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEChannel_getChannelCallback : Invalid Native Object");
    if (argc == 0) {
        cce::Callback ret = cobj->getChannelCallback();
        jsval jsret = JSVAL_NULL;
        #pragma warning NO CONVERSION FROM NATIVE FOR std::function;
        JS_SET_RVAL(cx, vp, jsret);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEChannel_getChannelCallback : wrong number of arguments: %d, was expecting %d", argc, 0);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEChannel_getType(JSContext *cx, uint32_t argc, jsval *vp)
{
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEChannel* cobj = (cce::CCEChannel *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEChannel_getType : Invalid Native Object");
    if (argc == 0) {
        std::string ret = cobj->getType();
        jsval jsret = JSVAL_NULL;
        jsret = std_string_to_jsval(cx, ret);
        JS_SET_RVAL(cx, vp, jsret);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEChannel_getType : wrong number of arguments: %d, was expecting %d", argc, 0);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEChannel_addFrame(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEChannel* cobj = (cce::CCEChannel *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEChannel_addFrame : Invalid Native Object");
    if (argc == 1) {
        cce::CCEKeyFrame* arg0;
        do {
            if (!argv[0].isObject()) { ok = false; break; }
            js_proxy_t *jsProxy;
            JSObject *tmpObj = JSVAL_TO_OBJECT(argv[0]);
            jsProxy = jsb_get_js_proxy(tmpObj);
            arg0 = (cce::CCEKeyFrame*)(jsProxy ? jsProxy->ptr : NULL);
            JSB_PRECONDITION2( arg0, cx, false, "Invalid Native Object");
        } while (0);
        JSB_PRECONDITION2(ok, cx, false, "js_cocos2dx_cocoseditor_CCEChannel_addFrame : Error processing arguments");
        cobj->addFrame(arg0);
        JS_SET_RVAL(cx, vp, JSVAL_VOID);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEChannel_addFrame : wrong number of arguments: %d, was expecting %d", argc, 1);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEChannel_getUnitTime(JSContext *cx, uint32_t argc, jsval *vp)
{
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEChannel* cobj = (cce::CCEChannel *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEChannel_getUnitTime : Invalid Native Object");
    if (argc == 0) {
        double ret = cobj->getUnitTime();
        jsval jsret = JSVAL_NULL;
        jsret = DOUBLE_TO_JSVAL(ret);
        JS_SET_RVAL(cx, vp, jsret);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEChannel_getUnitTime : wrong number of arguments: %d, was expecting %d", argc, 0);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEChannel_setLoop(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEChannel* cobj = (cce::CCEChannel *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEChannel_setLoop : Invalid Native Object");
    if (argc == 1) {
        int arg0;
        ok &= jsval_to_int32(cx, argv[0], (int32_t *)&arg0);
        JSB_PRECONDITION2(ok, cx, false, "js_cocos2dx_cocoseditor_CCEChannel_setLoop : Error processing arguments");
        cobj->setLoop(arg0);
        JS_SET_RVAL(cx, vp, JSVAL_VOID);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEChannel_setLoop : wrong number of arguments: %d, was expecting %d", argc, 1);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEChannel_setChannelCallback(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEChannel* cobj = (cce::CCEChannel *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEChannel_setChannelCallback : Invalid Native Object");
    if (argc == 1) {
        std::function<void (cocos2d::Ref *, std::basic_string<char>)> arg0;
        do {
		    std::shared_ptr<JSFunctionWrapper> func(new JSFunctionWrapper(cx, JS_THIS_OBJECT(cx, vp), argv[0]));
		    auto lambda = [=](cocos2d::Ref* larg0, std::basic_string<char> larg1) -> void {
		        jsval largv[2];
		        do {
		            if (larg0) {
		                js_proxy_t *jsProxy = js_get_or_create_proxy<cocos2d::Ref>(cx, (cocos2d::Ref*)larg0);
		                largv[0] = OBJECT_TO_JSVAL(jsProxy->obj);
		            } else {
		                largv[0] = JSVAL_NULL;
		            }
		        } while (0);
		        largv[1] = std_string_to_jsval(cx, larg1);
		        jsval rval;
		        bool ok = func->invoke(2, &largv[0], rval);
		        if (!ok && JS_IsExceptionPending(cx)) {
		            JS_ReportPendingException(cx);
		        }
		    };
		    arg0 = lambda;
		} while(0)
		;
        JSB_PRECONDITION2(ok, cx, false, "js_cocos2dx_cocoseditor_CCEChannel_setChannelCallback : Error processing arguments");
        cobj->setChannelCallback(arg0);
        JS_SET_RVAL(cx, vp, JSVAL_VOID);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEChannel_setChannelCallback : wrong number of arguments: %d, was expecting %d", argc, 1);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEChannel_getDelay(JSContext *cx, uint32_t argc, jsval *vp)
{
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEChannel* cobj = (cce::CCEChannel *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEChannel_getDelay : Invalid Native Object");
    if (argc == 0) {
        double ret = cobj->getDelay();
        jsval jsret = JSVAL_NULL;
        jsret = DOUBLE_TO_JSVAL(ret);
        JS_SET_RVAL(cx, vp, jsret);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEChannel_getDelay : wrong number of arguments: %d, was expecting %d", argc, 0);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEChannel_getAnimation(JSContext *cx, uint32_t argc, jsval *vp)
{
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEChannel* cobj = (cce::CCEChannel *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEChannel_getAnimation : Invalid Native Object");
    if (argc == 0) {
        cce::CCEAnimation* ret = cobj->getAnimation();
        jsval jsret = JSVAL_NULL;
        do {
            if (ret) {
                js_proxy_t *jsProxy = js_get_or_create_proxy<cce::CCEAnimation>(cx, (cce::CCEAnimation*)ret);
                jsret = OBJECT_TO_JSVAL(jsProxy->obj);
            } else {
                jsret = JSVAL_NULL;
            }
        } while (0);
        JS_SET_RVAL(cx, vp, jsret);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEChannel_getAnimation : wrong number of arguments: %d, was expecting %d", argc, 0);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEChannel_deleteFrame(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEChannel* cobj = (cce::CCEChannel *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEChannel_deleteFrame : Invalid Native Object");
    if (argc == 1) {
        cce::CCEKeyFrame* arg0;
        do {
            if (!argv[0].isObject()) { ok = false; break; }
            js_proxy_t *jsProxy;
            JSObject *tmpObj = JSVAL_TO_OBJECT(argv[0]);
            jsProxy = jsb_get_js_proxy(tmpObj);
            arg0 = (cce::CCEKeyFrame*)(jsProxy ? jsProxy->ptr : NULL);
            JSB_PRECONDITION2( arg0, cx, false, "Invalid Native Object");
        } while (0);
        JSB_PRECONDITION2(ok, cx, false, "js_cocos2dx_cocoseditor_CCEChannel_deleteFrame : Error processing arguments");
        cobj->deleteFrame(arg0);
        JS_SET_RVAL(cx, vp, JSVAL_VOID);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEChannel_deleteFrame : wrong number of arguments: %d, was expecting %d", argc, 1);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEChannel_getSpriteActions(JSContext *cx, uint32_t argc, jsval *vp)
{
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEChannel* cobj = (cce::CCEChannel *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEChannel_getSpriteActions : Invalid Native Object");
    if (argc == 0) {
        cocos2d::FiniteTimeAction* ret = cobj->getSpriteActions();
        jsval jsret = JSVAL_NULL;
        do {
            if (ret) {
                js_proxy_t *jsProxy = js_get_or_create_proxy<cocos2d::FiniteTimeAction>(cx, (cocos2d::FiniteTimeAction*)ret);
                jsret = OBJECT_TO_JSVAL(jsProxy->obj);
            } else {
                jsret = JSVAL_NULL;
            }
        } while (0);
        JS_SET_RVAL(cx, vp, jsret);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEChannel_getSpriteActions : wrong number of arguments: %d, was expecting %d", argc, 0);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEChannel_getNode(JSContext *cx, uint32_t argc, jsval *vp)
{
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEChannel* cobj = (cce::CCEChannel *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEChannel_getNode : Invalid Native Object");
    if (argc == 0) {
        cocos2d::Node* ret = cobj->getNode();
        jsval jsret = JSVAL_NULL;
        do {
            if (ret) {
                js_proxy_t *jsProxy = js_get_or_create_proxy<cocos2d::Node>(cx, (cocos2d::Node*)ret);
                jsret = OBJECT_TO_JSVAL(jsProxy->obj);
            } else {
                jsret = JSVAL_NULL;
            }
        } while (0);
        JS_SET_RVAL(cx, vp, jsret);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEChannel_getNode : wrong number of arguments: %d, was expecting %d", argc, 0);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEChannel_create(JSContext *cx, uint32_t argc, jsval *vp)
{
    if (argc == 0) {
        cce::CCEChannel* ret = cce::CCEChannel::create();
        jsval jsret = JSVAL_NULL;
        do {
        if (ret) {
            js_proxy_t *jsProxy = js_get_or_create_proxy<cce::CCEChannel>(cx, (cce::CCEChannel*)ret);
            jsret = OBJECT_TO_JSVAL(jsProxy->obj);
        } else {
            jsret = JSVAL_NULL;
        }
    } while (0);
        JS_SET_RVAL(cx, vp, jsret);
        return true;
    }
    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEChannel_create : wrong number of arguments");
    return false;
}

bool js_cocos2dx_cocoseditor_CCEChannel_constructor(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;
    cce::CCEChannel* cobj = new (std::nothrow) cce::CCEChannel();
    cocos2d::Ref *_ccobj = dynamic_cast<cocos2d::Ref *>(cobj);
    if (_ccobj) {
        _ccobj->autorelease();
    }
    TypeTest<cce::CCEChannel> t;
    js_type_class_t *typeClass = nullptr;
    std::string typeName = t.s_name();
    auto typeMapIter = _js_global_type_map.find(typeName);
    CCASSERT(typeMapIter != _js_global_type_map.end(), "Can't find the class type!");
    typeClass = typeMapIter->second;
    CCASSERT(typeClass, "The value is null.");
    JSObject *obj = JS_NewObject(cx, typeClass->jsclass, typeClass->proto, typeClass->parentProto);
    JS_SET_RVAL(cx, vp, OBJECT_TO_JSVAL(obj));
    // link the native object with the javascript object
    js_proxy_t* p = jsb_new_proxy(cobj, obj);
    JS_AddNamedObjectRoot(cx, &p->obj, "cce::CCEChannel");
    if (JS_HasProperty(cx, obj, "_ctor", &ok) && ok)
        ScriptingCore::getInstance()->executeFunctionWithOwner(OBJECT_TO_JSVAL(obj), "_ctor", argc, argv);
    return true;
}



void js_cce_CCEChannel_finalize(JSFreeOp *fop, JSObject *obj) {
    CCLOGINFO("jsbindings: finalizing JS object %p (CCEChannel)", obj);
}

void js_register_cocos2dx_cocoseditor_CCEChannel(JSContext *cx, JSObject *global) {
    jsb_cce_CCEChannel_class = (JSClass *)calloc(1, sizeof(JSClass));
    jsb_cce_CCEChannel_class->name = "CCEChannel";
    jsb_cce_CCEChannel_class->addProperty = JS_PropertyStub;
    jsb_cce_CCEChannel_class->delProperty = JS_DeletePropertyStub;
    jsb_cce_CCEChannel_class->getProperty = JS_PropertyStub;
    jsb_cce_CCEChannel_class->setProperty = JS_StrictPropertyStub;
    jsb_cce_CCEChannel_class->enumerate = JS_EnumerateStub;
    jsb_cce_CCEChannel_class->resolve = JS_ResolveStub;
    jsb_cce_CCEChannel_class->convert = JS_ConvertStub;
    jsb_cce_CCEChannel_class->finalize = js_cce_CCEChannel_finalize;
    jsb_cce_CCEChannel_class->flags = JSCLASS_HAS_RESERVED_SLOTS(2);

    static JSPropertySpec properties[] = {
        {"__nativeObj", 0, JSPROP_ENUMERATE | JSPROP_PERMANENT, JSOP_WRAPPER(js_is_native_obj), JSOP_NULLWRAPPER},
        {0, 0, 0, JSOP_NULLWRAPPER, JSOP_NULLWRAPPER}
    };

    static JSFunctionSpec funcs[] = {
        JS_FN("setUnitTime", js_cocos2dx_cocoseditor_CCEChannel_setUnitTime, 1, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("insertFrame", js_cocos2dx_cocoseditor_CCEChannel_insertFrame, 2, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("setAnimation", js_cocos2dx_cocoseditor_CCEChannel_setAnimation, 1, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("setDelay", js_cocos2dx_cocoseditor_CCEChannel_setDelay, 1, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("clearAllFrame", js_cocos2dx_cocoseditor_CCEChannel_clearAllFrame, 0, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("setType", js_cocos2dx_cocoseditor_CCEChannel_setType, 1, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("getBezierActions", js_cocos2dx_cocoseditor_CCEChannel_getBezierActions, 0, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("setNode", js_cocos2dx_cocoseditor_CCEChannel_setNode, 1, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("getSplineActions", js_cocos2dx_cocoseditor_CCEChannel_getSplineActions, 0, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("getNormalActions", js_cocos2dx_cocoseditor_CCEChannel_getNormalActions, 0, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("getActions", js_cocos2dx_cocoseditor_CCEChannel_getActions, 0, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("getChannelCallback", js_cocos2dx_cocoseditor_CCEChannel_getChannelCallback, 0, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("getType", js_cocos2dx_cocoseditor_CCEChannel_getType, 0, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("addFrame", js_cocos2dx_cocoseditor_CCEChannel_addFrame, 1, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("getUnitTime", js_cocos2dx_cocoseditor_CCEChannel_getUnitTime, 0, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("setLoop", js_cocos2dx_cocoseditor_CCEChannel_setLoop, 1, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("setChannelCallback", js_cocos2dx_cocoseditor_CCEChannel_setChannelCallback, 1, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("getDelay", js_cocos2dx_cocoseditor_CCEChannel_getDelay, 0, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("getAnimation", js_cocos2dx_cocoseditor_CCEChannel_getAnimation, 0, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("deleteFrame", js_cocos2dx_cocoseditor_CCEChannel_deleteFrame, 1, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("getSpriteActions", js_cocos2dx_cocoseditor_CCEChannel_getSpriteActions, 0, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("getNode", js_cocos2dx_cocoseditor_CCEChannel_getNode, 0, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FS_END
    };

    static JSFunctionSpec st_funcs[] = {
        JS_FN("create", js_cocos2dx_cocoseditor_CCEChannel_create, 0, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FS_END
    };

    jsb_cce_CCEChannel_prototype = JS_InitClass(
        cx, global,
        NULL, // parent proto
        jsb_cce_CCEChannel_class,
        js_cocos2dx_cocoseditor_CCEChannel_constructor, 0, // constructor
        properties,
        funcs,
        NULL, // no static properties
        st_funcs);
    // make the class enumerable in the registered namespace
//  bool found;
//FIXME: Removed in Firefox v27 
//  JS_SetPropertyAttributes(cx, global, "CCEChannel", JSPROP_ENUMERATE | JSPROP_READONLY, &found);

    // add the proto and JSClass to the type->js info hash table
    TypeTest<cce::CCEChannel> t;
    js_type_class_t *p;
    std::string typeName = t.s_name();
    if (_js_global_type_map.find(typeName) == _js_global_type_map.end())
    {
        p = (js_type_class_t *)malloc(sizeof(js_type_class_t));
        p->jsclass = jsb_cce_CCEChannel_class;
        p->proto = jsb_cce_CCEChannel_prototype;
        p->parentProto = NULL;
        _js_global_type_map.insert(std::make_pair(typeName, p));
    }
}

JSClass  *jsb_cce_CCEAnimation_class;
JSObject *jsb_cce_CCEAnimation_prototype;

bool js_cocos2dx_cocoseditor_CCEAnimation_getNext(JSContext *cx, uint32_t argc, jsval *vp)
{
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEAnimation* cobj = (cce::CCEAnimation *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEAnimation_getNext : Invalid Native Object");
    if (argc == 0) {
        std::string ret = cobj->getNext();
        jsval jsret = JSVAL_NULL;
        jsret = std_string_to_jsval(cx, ret);
        JS_SET_RVAL(cx, vp, jsret);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEAnimation_getNext : wrong number of arguments: %d, was expecting %d", argc, 0);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEAnimation_setUnitTime(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEAnimation* cobj = (cce::CCEAnimation *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEAnimation_setUnitTime : Invalid Native Object");
    if (argc == 1) {
        double arg0;
        ok &= JS::ToNumber( cx, JS::RootedValue(cx, argv[0]), &arg0);
        JSB_PRECONDITION2(ok, cx, false, "js_cocos2dx_cocoseditor_CCEAnimation_setUnitTime : Error processing arguments");
        cobj->setUnitTime(arg0);
        JS_SET_RVAL(cx, vp, JSVAL_VOID);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEAnimation_setUnitTime : wrong number of arguments: %d, was expecting %d", argc, 1);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEAnimation_setActionTag(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEAnimation* cobj = (cce::CCEAnimation *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEAnimation_setActionTag : Invalid Native Object");
    if (argc == 1) {
        int arg0;
        ok &= jsval_to_int32(cx, argv[0], (int32_t *)&arg0);
        JSB_PRECONDITION2(ok, cx, false, "js_cocos2dx_cocoseditor_CCEAnimation_setActionTag : Error processing arguments");
        cobj->setActionTag(arg0);
        JS_SET_RVAL(cx, vp, JSVAL_VOID);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEAnimation_setActionTag : wrong number of arguments: %d, was expecting %d", argc, 1);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEAnimation_setNext(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEAnimation* cobj = (cce::CCEAnimation *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEAnimation_setNext : Invalid Native Object");
    if (argc == 1) {
        std::string arg0;
        ok &= jsval_to_std_string(cx, argv[0], &arg0);
        JSB_PRECONDITION2(ok, cx, false, "js_cocos2dx_cocoseditor_CCEAnimation_setNext : Error processing arguments");
        cobj->setNext(arg0);
        JS_SET_RVAL(cx, vp, JSVAL_VOID);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEAnimation_setNext : wrong number of arguments: %d, was expecting %d", argc, 1);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEAnimation_getObject(JSContext *cx, uint32_t argc, jsval *vp)
{
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEAnimation* cobj = (cce::CCEAnimation *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEAnimation_getObject : Invalid Native Object");
    if (argc == 0) {
        cocos2d::Ref* ret = cobj->getObject();
        jsval jsret = JSVAL_NULL;
        do {
            if (ret) {
                js_proxy_t *jsProxy = js_get_or_create_proxy<cocos2d::Ref>(cx, (cocos2d::Ref*)ret);
                jsret = OBJECT_TO_JSVAL(jsProxy->obj);
            } else {
                jsret = JSVAL_NULL;
            }
        } while (0);
        JS_SET_RVAL(cx, vp, jsret);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEAnimation_getObject : wrong number of arguments: %d, was expecting %d", argc, 0);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEAnimation_createActions(JSContext *cx, uint32_t argc, jsval *vp)
{
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEAnimation* cobj = (cce::CCEAnimation *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEAnimation_createActions : Invalid Native Object");
    if (argc == 0) {
        cocos2d::Spawn* ret = cobj->createActions();
        jsval jsret = JSVAL_NULL;
        do {
            if (ret) {
                js_proxy_t *jsProxy = js_get_or_create_proxy<cocos2d::Spawn>(cx, (cocos2d::Spawn*)ret);
                jsret = OBJECT_TO_JSVAL(jsProxy->obj);
            } else {
                jsret = JSVAL_NULL;
            }
        } while (0);
        JS_SET_RVAL(cx, vp, jsret);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEAnimation_createActions : wrong number of arguments: %d, was expecting %d", argc, 0);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEAnimation_isActionDoneOnce(JSContext *cx, uint32_t argc, jsval *vp)
{
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEAnimation* cobj = (cce::CCEAnimation *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEAnimation_isActionDoneOnce : Invalid Native Object");
    if (argc == 0) {
        bool ret = cobj->isActionDoneOnce();
        jsval jsret = JSVAL_NULL;
        jsret = BOOLEAN_TO_JSVAL(ret);
        JS_SET_RVAL(cx, vp, jsret);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEAnimation_isActionDoneOnce : wrong number of arguments: %d, was expecting %d", argc, 0);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEAnimation_setMain(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEAnimation* cobj = (cce::CCEAnimation *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEAnimation_setMain : Invalid Native Object");
    if (argc == 1) {
        bool arg0;
        arg0 = JS::ToBoolean(JS::RootedValue(cx, argv[0]));
        JSB_PRECONDITION2(ok, cx, false, "js_cocos2dx_cocoseditor_CCEAnimation_setMain : Error processing arguments");
        cobj->setMain(arg0);
        JS_SET_RVAL(cx, vp, JSVAL_VOID);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEAnimation_setMain : wrong number of arguments: %d, was expecting %d", argc, 1);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEAnimation_getOrCreateChannel(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEAnimation* cobj = (cce::CCEAnimation *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEAnimation_getOrCreateChannel : Invalid Native Object");
    if (argc == 1) {
        std::string arg0;
        ok &= jsval_to_std_string(cx, argv[0], &arg0);
        JSB_PRECONDITION2(ok, cx, false, "js_cocos2dx_cocoseditor_CCEAnimation_getOrCreateChannel : Error processing arguments");
        cce::CCEChannel* ret = cobj->getOrCreateChannel(arg0);
        jsval jsret = JSVAL_NULL;
        do {
            if (ret) {
                js_proxy_t *jsProxy = js_get_or_create_proxy<cce::CCEChannel>(cx, (cce::CCEChannel*)ret);
                jsret = OBJECT_TO_JSVAL(jsProxy->obj);
            } else {
                jsret = JSVAL_NULL;
            }
        } while (0);
        JS_SET_RVAL(cx, vp, jsret);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEAnimation_getOrCreateChannel : wrong number of arguments: %d, was expecting %d", argc, 1);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEAnimation_setDelay(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEAnimation* cobj = (cce::CCEAnimation *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEAnimation_setDelay : Invalid Native Object");
    if (argc == 1) {
        double arg0;
        ok &= JS::ToNumber( cx, JS::RootedValue(cx, argv[0]), &arg0);
        JSB_PRECONDITION2(ok, cx, false, "js_cocos2dx_cocoseditor_CCEAnimation_setDelay : Error processing arguments");
        cobj->setDelay(arg0);
        JS_SET_RVAL(cx, vp, JSVAL_VOID);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEAnimation_setDelay : wrong number of arguments: %d, was expecting %d", argc, 1);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEAnimation_setObject(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEAnimation* cobj = (cce::CCEAnimation *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEAnimation_setObject : Invalid Native Object");
    if (argc == 1) {
        cocos2d::Ref* arg0;
        do {
            if (!argv[0].isObject()) { ok = false; break; }
            js_proxy_t *jsProxy;
            JSObject *tmpObj = JSVAL_TO_OBJECT(argv[0]);
            jsProxy = jsb_get_js_proxy(tmpObj);
            arg0 = (cocos2d::Ref*)(jsProxy ? jsProxy->ptr : NULL);
            JSB_PRECONDITION2( arg0, cx, false, "Invalid Native Object");
        } while (0);
        JSB_PRECONDITION2(ok, cx, false, "js_cocos2dx_cocoseditor_CCEAnimation_setObject : Error processing arguments");
        cobj->setObject(arg0);
        JS_SET_RVAL(cx, vp, JSVAL_VOID);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEAnimation_setObject : wrong number of arguments: %d, was expecting %d", argc, 1);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEAnimation_getName(JSContext *cx, uint32_t argc, jsval *vp)
{
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEAnimation* cobj = (cce::CCEAnimation *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEAnimation_getName : Invalid Native Object");
    if (argc == 0) {
        std::string ret = cobj->getName();
        jsval jsret = JSVAL_NULL;
        jsret = std_string_to_jsval(cx, ret);
        JS_SET_RVAL(cx, vp, jsret);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEAnimation_getName : wrong number of arguments: %d, was expecting %d", argc, 0);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEAnimation_fireAnimationEvent(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEAnimation* cobj = (cce::CCEAnimation *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEAnimation_fireAnimationEvent : Invalid Native Object");
    if (argc == 1) {
        std::string arg0;
        ok &= jsval_to_std_string(cx, argv[0], &arg0);
        JSB_PRECONDITION2(ok, cx, false, "js_cocos2dx_cocoseditor_CCEAnimation_fireAnimationEvent : Error processing arguments");
        cobj->fireAnimationEvent(arg0);
        JS_SET_RVAL(cx, vp, JSVAL_VOID);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEAnimation_fireAnimationEvent : wrong number of arguments: %d, was expecting %d", argc, 1);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEAnimation_getActionTag(JSContext *cx, uint32_t argc, jsval *vp)
{
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEAnimation* cobj = (cce::CCEAnimation *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEAnimation_getActionTag : Invalid Native Object");
    if (argc == 0) {
        int ret = cobj->getActionTag();
        jsval jsret = JSVAL_NULL;
        jsret = int32_to_jsval(cx, ret);
        JS_SET_RVAL(cx, vp, jsret);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEAnimation_getActionTag : wrong number of arguments: %d, was expecting %d", argc, 0);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEAnimation_onAnimationEnd(JSContext *cx, uint32_t argc, jsval *vp)
{
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEAnimation* cobj = (cce::CCEAnimation *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEAnimation_onAnimationEnd : Invalid Native Object");
    if (argc == 0) {
        cobj->onAnimationEnd();
        JS_SET_RVAL(cx, vp, JSVAL_VOID);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEAnimation_onAnimationEnd : wrong number of arguments: %d, was expecting %d", argc, 0);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEAnimation_playAction(JSContext *cx, uint32_t argc, jsval *vp)
{
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEAnimation* cobj = (cce::CCEAnimation *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEAnimation_playAction : Invalid Native Object");
    if (argc == 0) {
        cobj->playAction();
        JS_SET_RVAL(cx, vp, JSVAL_VOID);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEAnimation_playAction : wrong number of arguments: %d, was expecting %d", argc, 0);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEAnimation_setSrc(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEAnimation* cobj = (cce::CCEAnimation *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEAnimation_setSrc : Invalid Native Object");
    if (argc == 1) {
        std::string arg0;
        ok &= jsval_to_std_string(cx, argv[0], &arg0);
        JSB_PRECONDITION2(ok, cx, false, "js_cocos2dx_cocoseditor_CCEAnimation_setSrc : Error processing arguments");
        cobj->setSrc(arg0);
        JS_SET_RVAL(cx, vp, JSVAL_VOID);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEAnimation_setSrc : wrong number of arguments: %d, was expecting %d", argc, 1);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEAnimation_setName(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEAnimation* cobj = (cce::CCEAnimation *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEAnimation_setName : Invalid Native Object");
    if (argc == 1) {
        std::string arg0;
        ok &= jsval_to_std_string(cx, argv[0], &arg0);
        JSB_PRECONDITION2(ok, cx, false, "js_cocos2dx_cocoseditor_CCEAnimation_setName : Error processing arguments");
        cobj->setName(arg0);
        JS_SET_RVAL(cx, vp, JSVAL_VOID);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEAnimation_setName : wrong number of arguments: %d, was expecting %d", argc, 1);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEAnimation_getChannels(JSContext *cx, uint32_t argc, jsval *vp)
{
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEAnimation* cobj = (cce::CCEAnimation *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEAnimation_getChannels : Invalid Native Object");
    if (argc == 0) {
        cocos2d::Vector<cce::CCEChannel *>& ret = cobj->getChannels();
        jsval jsret = JSVAL_NULL;
        jsret = ccvector_to_jsval(cx, ret);
        JS_SET_RVAL(cx, vp, jsret);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEAnimation_getChannels : wrong number of arguments: %d, was expecting %d", argc, 0);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEAnimation_getAutoRun(JSContext *cx, uint32_t argc, jsval *vp)
{
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEAnimation* cobj = (cce::CCEAnimation *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEAnimation_getAutoRun : Invalid Native Object");
    if (argc == 0) {
        bool ret = cobj->getAutoRun();
        jsval jsret = JSVAL_NULL;
        jsret = BOOLEAN_TO_JSVAL(ret);
        JS_SET_RVAL(cx, vp, jsret);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEAnimation_getAutoRun : wrong number of arguments: %d, was expecting %d", argc, 0);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEAnimation_getLoop(JSContext *cx, uint32_t argc, jsval *vp)
{
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEAnimation* cobj = (cce::CCEAnimation *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEAnimation_getLoop : Invalid Native Object");
    if (argc == 0) {
        int ret = cobj->getLoop();
        jsval jsret = JSVAL_NULL;
        jsret = int32_to_jsval(cx, ret);
        JS_SET_RVAL(cx, vp, jsret);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEAnimation_getLoop : wrong number of arguments: %d, was expecting %d", argc, 0);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEAnimation_setCallback(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEAnimation* cobj = (cce::CCEAnimation *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEAnimation_setCallback : Invalid Native Object");
    if (argc == 1) {
        std::function<void (cocos2d::Ref *, std::basic_string<char>)> arg0;
        do {
		    std::shared_ptr<JSFunctionWrapper> func(new JSFunctionWrapper(cx, JS_THIS_OBJECT(cx, vp), argv[0]));
		    auto lambda = [=](cocos2d::Ref* larg0, std::basic_string<char> larg1) -> void {
		        jsval largv[2];
		        do {
		            if (larg0) {
		                js_proxy_t *jsProxy = js_get_or_create_proxy<cocos2d::Ref>(cx, (cocos2d::Ref*)larg0);
		                largv[0] = OBJECT_TO_JSVAL(jsProxy->obj);
		            } else {
		                largv[0] = JSVAL_NULL;
		            }
		        } while (0);
		        largv[1] = std_string_to_jsval(cx, larg1);
		        jsval rval;
		        bool ok = func->invoke(2, &largv[0], rval);
		        if (!ok && JS_IsExceptionPending(cx)) {
		            JS_ReportPendingException(cx);
		        }
		    };
		    arg0 = lambda;
		} while(0)
		;
        JSB_PRECONDITION2(ok, cx, false, "js_cocos2dx_cocoseditor_CCEAnimation_setCallback : Error processing arguments");
        cobj->setCallback(arg0);
        JS_SET_RVAL(cx, vp, JSVAL_VOID);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEAnimation_setCallback : wrong number of arguments: %d, was expecting %d", argc, 1);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEAnimation_getDuration(JSContext *cx, uint32_t argc, jsval *vp)
{
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEAnimation* cobj = (cce::CCEAnimation *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEAnimation_getDuration : Invalid Native Object");
    if (argc == 0) {
        double ret = cobj->getDuration();
        jsval jsret = JSVAL_NULL;
        jsret = DOUBLE_TO_JSVAL(ret);
        JS_SET_RVAL(cx, vp, jsret);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEAnimation_getDuration : wrong number of arguments: %d, was expecting %d", argc, 0);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEAnimation_addChannel(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEAnimation* cobj = (cce::CCEAnimation *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEAnimation_addChannel : Invalid Native Object");
    if (argc == 1) {
        cce::CCEChannel* arg0;
        do {
            if (!argv[0].isObject()) { ok = false; break; }
            js_proxy_t *jsProxy;
            JSObject *tmpObj = JSVAL_TO_OBJECT(argv[0]);
            jsProxy = jsb_get_js_proxy(tmpObj);
            arg0 = (cce::CCEChannel*)(jsProxy ? jsProxy->ptr : NULL);
            JSB_PRECONDITION2( arg0, cx, false, "Invalid Native Object");
        } while (0);
        JSB_PRECONDITION2(ok, cx, false, "js_cocos2dx_cocoseditor_CCEAnimation_addChannel : Error processing arguments");
        cobj->addChannel(arg0);
        JS_SET_RVAL(cx, vp, JSVAL_VOID);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEAnimation_addChannel : wrong number of arguments: %d, was expecting %d", argc, 1);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEAnimation_getUnitTime(JSContext *cx, uint32_t argc, jsval *vp)
{
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEAnimation* cobj = (cce::CCEAnimation *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEAnimation_getUnitTime : Invalid Native Object");
    if (argc == 0) {
        double ret = cobj->getUnitTime();
        jsval jsret = JSVAL_NULL;
        jsret = DOUBLE_TO_JSVAL(ret);
        JS_SET_RVAL(cx, vp, jsret);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEAnimation_getUnitTime : wrong number of arguments: %d, was expecting %d", argc, 0);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEAnimation_isPlaying(JSContext *cx, uint32_t argc, jsval *vp)
{
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEAnimation* cobj = (cce::CCEAnimation *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEAnimation_isPlaying : Invalid Native Object");
    if (argc == 0) {
        bool ret = cobj->isPlaying();
        jsval jsret = JSVAL_NULL;
        jsret = BOOLEAN_TO_JSVAL(ret);
        JS_SET_RVAL(cx, vp, jsret);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEAnimation_isPlaying : wrong number of arguments: %d, was expecting %d", argc, 0);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEAnimation_setLoop(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEAnimation* cobj = (cce::CCEAnimation *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEAnimation_setLoop : Invalid Native Object");
    if (argc == 1) {
        int arg0;
        ok &= jsval_to_int32(cx, argv[0], (int32_t *)&arg0);
        JSB_PRECONDITION2(ok, cx, false, "js_cocos2dx_cocoseditor_CCEAnimation_setLoop : Error processing arguments");
        cobj->setLoop(arg0);
        JS_SET_RVAL(cx, vp, JSVAL_VOID);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEAnimation_setLoop : wrong number of arguments: %d, was expecting %d", argc, 1);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEAnimation_getDelay(JSContext *cx, uint32_t argc, jsval *vp)
{
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEAnimation* cobj = (cce::CCEAnimation *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEAnimation_getDelay : Invalid Native Object");
    if (argc == 0) {
        double ret = cobj->getDelay();
        jsval jsret = JSVAL_NULL;
        jsret = DOUBLE_TO_JSVAL(ret);
        JS_SET_RVAL(cx, vp, jsret);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEAnimation_getDelay : wrong number of arguments: %d, was expecting %d", argc, 0);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEAnimation_getActionNode(JSContext *cx, uint32_t argc, jsval *vp)
{
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEAnimation* cobj = (cce::CCEAnimation *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEAnimation_getActionNode : Invalid Native Object");
    if (argc == 0) {
        cocos2d::Node* ret = cobj->getActionNode();
        jsval jsret = JSVAL_NULL;
        do {
            if (ret) {
                js_proxy_t *jsProxy = js_get_or_create_proxy<cocos2d::Node>(cx, (cocos2d::Node*)ret);
                jsret = OBJECT_TO_JSVAL(jsProxy->obj);
            } else {
                jsret = JSVAL_NULL;
            }
        } while (0);
        JS_SET_RVAL(cx, vp, jsret);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEAnimation_getActionNode : wrong number of arguments: %d, was expecting %d", argc, 0);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEAnimation_getSrc(JSContext *cx, uint32_t argc, jsval *vp)
{
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEAnimation* cobj = (cce::CCEAnimation *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEAnimation_getSrc : Invalid Native Object");
    if (argc == 0) {
        std::string ret = cobj->getSrc();
        jsval jsret = JSVAL_NULL;
        jsret = std_string_to_jsval(cx, ret);
        JS_SET_RVAL(cx, vp, jsret);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEAnimation_getSrc : wrong number of arguments: %d, was expecting %d", argc, 0);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEAnimation_isMain(JSContext *cx, uint32_t argc, jsval *vp)
{
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEAnimation* cobj = (cce::CCEAnimation *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEAnimation_isMain : Invalid Native Object");
    if (argc == 0) {
        bool ret = cobj->isMain();
        jsval jsret = JSVAL_NULL;
        jsret = BOOLEAN_TO_JSVAL(ret);
        JS_SET_RVAL(cx, vp, jsret);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEAnimation_isMain : wrong number of arguments: %d, was expecting %d", argc, 0);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEAnimation_setAutoRun(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEAnimation* cobj = (cce::CCEAnimation *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEAnimation_setAutoRun : Invalid Native Object");
    if (argc == 1) {
        bool arg0;
        arg0 = JS::ToBoolean(JS::RootedValue(cx, argv[0]));
        JSB_PRECONDITION2(ok, cx, false, "js_cocos2dx_cocoseditor_CCEAnimation_setAutoRun : Error processing arguments");
        cobj->setAutoRun(arg0);
        JS_SET_RVAL(cx, vp, JSVAL_VOID);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEAnimation_setAutoRun : wrong number of arguments: %d, was expecting %d", argc, 1);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEAnimation_setDuration(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEAnimation* cobj = (cce::CCEAnimation *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEAnimation_setDuration : Invalid Native Object");
    if (argc == 1) {
        double arg0;
        ok &= JS::ToNumber( cx, JS::RootedValue(cx, argv[0]), &arg0);
        JSB_PRECONDITION2(ok, cx, false, "js_cocos2dx_cocoseditor_CCEAnimation_setDuration : Error processing arguments");
        cobj->setDuration(arg0);
        JS_SET_RVAL(cx, vp, JSVAL_VOID);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEAnimation_setDuration : wrong number of arguments: %d, was expecting %d", argc, 1);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEAnimation_stopAction(JSContext *cx, uint32_t argc, jsval *vp)
{
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEAnimation* cobj = (cce::CCEAnimation *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEAnimation_stopAction : Invalid Native Object");
    if (argc == 0) {
        cobj->stopAction();
        JS_SET_RVAL(cx, vp, JSVAL_VOID);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEAnimation_stopAction : wrong number of arguments: %d, was expecting %d", argc, 0);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEAnimation_addCallback(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEAnimation* cobj = (cce::CCEAnimation *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEAnimation_addCallback : Invalid Native Object");
    if (argc == 1) {
        std::function<void (cocos2d::Ref *, std::basic_string<char>)> arg0;
        do {
		    std::shared_ptr<JSFunctionWrapper> func(new JSFunctionWrapper(cx, JS_THIS_OBJECT(cx, vp), argv[0]));
		    auto lambda = [=](cocos2d::Ref* larg0, std::basic_string<char> larg1) -> void {
		        jsval largv[2];
		        do {
		            if (larg0) {
		                js_proxy_t *jsProxy = js_get_or_create_proxy<cocos2d::Ref>(cx, (cocos2d::Ref*)larg0);
		                largv[0] = OBJECT_TO_JSVAL(jsProxy->obj);
		            } else {
		                largv[0] = JSVAL_NULL;
		            }
		        } while (0);
		        largv[1] = std_string_to_jsval(cx, larg1);
		        jsval rval;
		        bool ok = func->invoke(2, &largv[0], rval);
		        if (!ok && JS_IsExceptionPending(cx)) {
		            JS_ReportPendingException(cx);
		        }
		    };
		    arg0 = lambda;
		} while(0)
		;
        JSB_PRECONDITION2(ok, cx, false, "js_cocos2dx_cocoseditor_CCEAnimation_addCallback : Error processing arguments");
        cobj->addCallback(arg0);
        JS_SET_RVAL(cx, vp, JSVAL_VOID);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEAnimation_addCallback : wrong number of arguments: %d, was expecting %d", argc, 1);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEAnimation_create(JSContext *cx, uint32_t argc, jsval *vp)
{
    if (argc == 0) {
        cce::CCEAnimation* ret = cce::CCEAnimation::create();
        jsval jsret = JSVAL_NULL;
        do {
        if (ret) {
            js_proxy_t *jsProxy = js_get_or_create_proxy<cce::CCEAnimation>(cx, (cce::CCEAnimation*)ret);
            jsret = OBJECT_TO_JSVAL(jsProxy->obj);
        } else {
            jsret = JSVAL_NULL;
        }
    } while (0);
        JS_SET_RVAL(cx, vp, jsret);
        return true;
    }
    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEAnimation_create : wrong number of arguments");
    return false;
}

bool js_cocos2dx_cocoseditor_CCEAnimation_constructor(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;
    cce::CCEAnimation* cobj = new (std::nothrow) cce::CCEAnimation();
    cocos2d::Ref *_ccobj = dynamic_cast<cocos2d::Ref *>(cobj);
    if (_ccobj) {
        _ccobj->autorelease();
    }
    TypeTest<cce::CCEAnimation> t;
    js_type_class_t *typeClass = nullptr;
    std::string typeName = t.s_name();
    auto typeMapIter = _js_global_type_map.find(typeName);
    CCASSERT(typeMapIter != _js_global_type_map.end(), "Can't find the class type!");
    typeClass = typeMapIter->second;
    CCASSERT(typeClass, "The value is null.");
    JSObject *obj = JS_NewObject(cx, typeClass->jsclass, typeClass->proto, typeClass->parentProto);
    JS_SET_RVAL(cx, vp, OBJECT_TO_JSVAL(obj));
    // link the native object with the javascript object
    js_proxy_t* p = jsb_new_proxy(cobj, obj);
    JS_AddNamedObjectRoot(cx, &p->obj, "cce::CCEAnimation");
    if (JS_HasProperty(cx, obj, "_ctor", &ok) && ok)
        ScriptingCore::getInstance()->executeFunctionWithOwner(OBJECT_TO_JSVAL(obj), "_ctor", argc, argv);
    return true;
}



void js_cce_CCEAnimation_finalize(JSFreeOp *fop, JSObject *obj) {
    CCLOGINFO("jsbindings: finalizing JS object %p (CCEAnimation)", obj);
}

void js_register_cocos2dx_cocoseditor_CCEAnimation(JSContext *cx, JSObject *global) {
    jsb_cce_CCEAnimation_class = (JSClass *)calloc(1, sizeof(JSClass));
    jsb_cce_CCEAnimation_class->name = "CCEAnimation";
    jsb_cce_CCEAnimation_class->addProperty = JS_PropertyStub;
    jsb_cce_CCEAnimation_class->delProperty = JS_DeletePropertyStub;
    jsb_cce_CCEAnimation_class->getProperty = JS_PropertyStub;
    jsb_cce_CCEAnimation_class->setProperty = JS_StrictPropertyStub;
    jsb_cce_CCEAnimation_class->enumerate = JS_EnumerateStub;
    jsb_cce_CCEAnimation_class->resolve = JS_ResolveStub;
    jsb_cce_CCEAnimation_class->convert = JS_ConvertStub;
    jsb_cce_CCEAnimation_class->finalize = js_cce_CCEAnimation_finalize;
    jsb_cce_CCEAnimation_class->flags = JSCLASS_HAS_RESERVED_SLOTS(2);

    static JSPropertySpec properties[] = {
        {"__nativeObj", 0, JSPROP_ENUMERATE | JSPROP_PERMANENT, JSOP_WRAPPER(js_is_native_obj), JSOP_NULLWRAPPER},
        {0, 0, 0, JSOP_NULLWRAPPER, JSOP_NULLWRAPPER}
    };

    static JSFunctionSpec funcs[] = {
        JS_FN("getNext", js_cocos2dx_cocoseditor_CCEAnimation_getNext, 0, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("setUnitTime", js_cocos2dx_cocoseditor_CCEAnimation_setUnitTime, 1, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("setActionTag", js_cocos2dx_cocoseditor_CCEAnimation_setActionTag, 1, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("setNext", js_cocos2dx_cocoseditor_CCEAnimation_setNext, 1, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("getObject", js_cocos2dx_cocoseditor_CCEAnimation_getObject, 0, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("createActions", js_cocos2dx_cocoseditor_CCEAnimation_createActions, 0, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("isActionDoneOnce", js_cocos2dx_cocoseditor_CCEAnimation_isActionDoneOnce, 0, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("setMain", js_cocos2dx_cocoseditor_CCEAnimation_setMain, 1, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("getOrCreateChannel", js_cocos2dx_cocoseditor_CCEAnimation_getOrCreateChannel, 1, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("setDelay", js_cocos2dx_cocoseditor_CCEAnimation_setDelay, 1, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("setObject", js_cocos2dx_cocoseditor_CCEAnimation_setObject, 1, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("getName", js_cocos2dx_cocoseditor_CCEAnimation_getName, 0, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("fireAnimationEvent", js_cocos2dx_cocoseditor_CCEAnimation_fireAnimationEvent, 1, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("getActionTag", js_cocos2dx_cocoseditor_CCEAnimation_getActionTag, 0, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("onAnimationEnd", js_cocos2dx_cocoseditor_CCEAnimation_onAnimationEnd, 0, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("playAction", js_cocos2dx_cocoseditor_CCEAnimation_playAction, 0, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("setSrc", js_cocos2dx_cocoseditor_CCEAnimation_setSrc, 1, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("setName", js_cocos2dx_cocoseditor_CCEAnimation_setName, 1, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("getChannels", js_cocos2dx_cocoseditor_CCEAnimation_getChannels, 0, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("getAutoRun", js_cocos2dx_cocoseditor_CCEAnimation_getAutoRun, 0, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("getLoop", js_cocos2dx_cocoseditor_CCEAnimation_getLoop, 0, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("setCallback", js_cocos2dx_cocoseditor_CCEAnimation_setCallback, 1, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("getDuration", js_cocos2dx_cocoseditor_CCEAnimation_getDuration, 0, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("addChannel", js_cocos2dx_cocoseditor_CCEAnimation_addChannel, 1, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("getUnitTime", js_cocos2dx_cocoseditor_CCEAnimation_getUnitTime, 0, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("isPlaying", js_cocos2dx_cocoseditor_CCEAnimation_isPlaying, 0, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("setLoop", js_cocos2dx_cocoseditor_CCEAnimation_setLoop, 1, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("getDelay", js_cocos2dx_cocoseditor_CCEAnimation_getDelay, 0, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("getActionNode", js_cocos2dx_cocoseditor_CCEAnimation_getActionNode, 0, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("getSrc", js_cocos2dx_cocoseditor_CCEAnimation_getSrc, 0, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("isMain", js_cocos2dx_cocoseditor_CCEAnimation_isMain, 0, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("setAutoRun", js_cocos2dx_cocoseditor_CCEAnimation_setAutoRun, 1, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("setDuration", js_cocos2dx_cocoseditor_CCEAnimation_setDuration, 1, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("stopAction", js_cocos2dx_cocoseditor_CCEAnimation_stopAction, 0, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("addCallback", js_cocos2dx_cocoseditor_CCEAnimation_addCallback, 1, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FS_END
    };

    static JSFunctionSpec st_funcs[] = {
        JS_FN("create", js_cocos2dx_cocoseditor_CCEAnimation_create, 0, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FS_END
    };

    jsb_cce_CCEAnimation_prototype = JS_InitClass(
        cx, global,
        NULL, // parent proto
        jsb_cce_CCEAnimation_class,
        js_cocos2dx_cocoseditor_CCEAnimation_constructor, 0, // constructor
        properties,
        funcs,
        NULL, // no static properties
        st_funcs);
    // make the class enumerable in the registered namespace
//  bool found;
//FIXME: Removed in Firefox v27 
//  JS_SetPropertyAttributes(cx, global, "CCEAnimation", JSPROP_ENUMERATE | JSPROP_READONLY, &found);

    // add the proto and JSClass to the type->js info hash table
    TypeTest<cce::CCEAnimation> t;
    js_type_class_t *p;
    std::string typeName = t.s_name();
    if (_js_global_type_map.find(typeName) == _js_global_type_map.end())
    {
        p = (js_type_class_t *)malloc(sizeof(js_type_class_t));
        p->jsclass = jsb_cce_CCEAnimation_class;
        p->proto = jsb_cce_CCEAnimation_prototype;
        p->parentProto = NULL;
        _js_global_type_map.insert(std::make_pair(typeName, p));
    }
}

JSClass  *jsb_cce_CCEAnimationManager_class;
JSObject *jsb_cce_CCEAnimationManager_prototype;

bool js_cocos2dx_cocoseditor_CCEAnimationManager_play(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;

    JSObject *obj = NULL;
    cce::CCEAnimationManager* cobj = NULL;
    obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cobj = (cce::CCEAnimationManager *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEAnimationManager_play : Invalid Native Object");
    do {
        if (argc == 1) {
            int arg0;
            ok &= jsval_to_int32(cx, argv[0], (int32_t *)&arg0);
            if (!ok) { ok = true; break; }
            cobj->play(arg0);
            JS_SET_RVAL(cx, vp, JSVAL_VOID);
            return true;
        }
    } while(0);

    do {
        if (argc == 1) {
            std::string arg0;
            ok &= jsval_to_std_string(cx, argv[0], &arg0);
            if (!ok) { ok = true; break; }
            cobj->play(arg0);
            JS_SET_RVAL(cx, vp, JSVAL_VOID);
            return true;
        }
    } while(0);

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEAnimationManager_play : wrong number of arguments");
    return false;
}
bool js_cocos2dx_cocoseditor_CCEAnimationManager_addAnimation(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEAnimationManager* cobj = (cce::CCEAnimationManager *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEAnimationManager_addAnimation : Invalid Native Object");
    if (argc == 1) {
        cce::CCEAnimation* arg0;
        do {
            if (!argv[0].isObject()) { ok = false; break; }
            js_proxy_t *jsProxy;
            JSObject *tmpObj = JSVAL_TO_OBJECT(argv[0]);
            jsProxy = jsb_get_js_proxy(tmpObj);
            arg0 = (cce::CCEAnimation*)(jsProxy ? jsProxy->ptr : NULL);
            JSB_PRECONDITION2( arg0, cx, false, "Invalid Native Object");
        } while (0);
        JSB_PRECONDITION2(ok, cx, false, "js_cocos2dx_cocoseditor_CCEAnimationManager_addAnimation : Error processing arguments");
        cobj->addAnimation(arg0);
        JS_SET_RVAL(cx, vp, JSVAL_VOID);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEAnimationManager_addAnimation : wrong number of arguments: %d, was expecting %d", argc, 1);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEAnimationManager_setAutoPlayNext(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEAnimationManager* cobj = (cce::CCEAnimationManager *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEAnimationManager_setAutoPlayNext : Invalid Native Object");
    if (argc == 1) {
        bool arg0;
        arg0 = JS::ToBoolean(JS::RootedValue(cx, argv[0]));
        JSB_PRECONDITION2(ok, cx, false, "js_cocos2dx_cocoseditor_CCEAnimationManager_setAutoPlayNext : Error processing arguments");
        cobj->setAutoPlayNext(arg0);
        JS_SET_RVAL(cx, vp, JSVAL_VOID);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEAnimationManager_setAutoPlayNext : wrong number of arguments: %d, was expecting %d", argc, 1);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEAnimationManager_playAuto(JSContext *cx, uint32_t argc, jsval *vp)
{
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEAnimationManager* cobj = (cce::CCEAnimationManager *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEAnimationManager_playAuto : Invalid Native Object");
    if (argc == 0) {
        cobj->playAuto();
        JS_SET_RVAL(cx, vp, JSVAL_VOID);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEAnimationManager_playAuto : wrong number of arguments: %d, was expecting %d", argc, 0);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEAnimationManager_stop(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;

    JSObject *obj = NULL;
    cce::CCEAnimationManager* cobj = NULL;
    obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cobj = (cce::CCEAnimationManager *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEAnimationManager_stop : Invalid Native Object");
    do {
        if (argc == 1) {
            std::string arg0;
            ok &= jsval_to_std_string(cx, argv[0], &arg0);
            if (!ok) { ok = true; break; }
            cobj->stop(arg0);
            JS_SET_RVAL(cx, vp, JSVAL_VOID);
            return true;
        }
    } while(0);

    do {
        if (argc == 1) {
            int arg0;
            ok &= jsval_to_int32(cx, argv[0], (int32_t *)&arg0);
            if (!ok) { ok = true; break; }
            cobj->stop(arg0);
            JS_SET_RVAL(cx, vp, JSVAL_VOID);
            return true;
        }
    } while(0);

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEAnimationManager_stop : wrong number of arguments");
    return false;
}
bool js_cocos2dx_cocoseditor_CCEAnimationManager_isAutoPlayNext(JSContext *cx, uint32_t argc, jsval *vp)
{
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEAnimationManager* cobj = (cce::CCEAnimationManager *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEAnimationManager_isAutoPlayNext : Invalid Native Object");
    if (argc == 0) {
        bool ret = cobj->isAutoPlayNext();
        jsval jsret = JSVAL_NULL;
        jsret = BOOLEAN_TO_JSVAL(ret);
        JS_SET_RVAL(cx, vp, jsret);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEAnimationManager_isAutoPlayNext : wrong number of arguments: %d, was expecting %d", argc, 0);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEAnimationManager_stopAll(JSContext *cx, uint32_t argc, jsval *vp)
{
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEAnimationManager* cobj = (cce::CCEAnimationManager *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEAnimationManager_stopAll : Invalid Native Object");
    if (argc == 0) {
        cobj->stopAll();
        JS_SET_RVAL(cx, vp, JSVAL_VOID);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEAnimationManager_stopAll : wrong number of arguments: %d, was expecting %d", argc, 0);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEAnimationManager_addCallFun(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEAnimationManager* cobj = (cce::CCEAnimationManager *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEAnimationManager_addCallFun : Invalid Native Object");
    if (argc == 2) {
        std::string arg0;
        cocos2d::CallFunc* arg1;
        ok &= jsval_to_std_string(cx, argv[0], &arg0);
        do {
            if (!argv[1].isObject()) { ok = false; break; }
            js_proxy_t *jsProxy;
            JSObject *tmpObj = JSVAL_TO_OBJECT(argv[1]);
            jsProxy = jsb_get_js_proxy(tmpObj);
            arg1 = (cocos2d::CallFunc*)(jsProxy ? jsProxy->ptr : NULL);
            JSB_PRECONDITION2( arg1, cx, false, "Invalid Native Object");
        } while (0);
        JSB_PRECONDITION2(ok, cx, false, "js_cocos2dx_cocoseditor_CCEAnimationManager_addCallFun : Error processing arguments");
        cobj->addCallFun(arg0, arg1);
        JS_SET_RVAL(cx, vp, JSVAL_VOID);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEAnimationManager_addCallFun : wrong number of arguments: %d, was expecting %d", argc, 2);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEAnimationManager_addCallback(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEAnimationManager* cobj = (cce::CCEAnimationManager *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEAnimationManager_addCallback : Invalid Native Object");
    if (argc == 2) {
        std::string arg0;
        std::function<void (cocos2d::Ref *, std::basic_string<char>)> arg1;
        ok &= jsval_to_std_string(cx, argv[0], &arg0);
        do {
		    std::shared_ptr<JSFunctionWrapper> func(new JSFunctionWrapper(cx, JS_THIS_OBJECT(cx, vp), argv[1]));
		    auto lambda = [=](cocos2d::Ref* larg0, std::basic_string<char> larg1) -> void {
		        jsval largv[2];
		        do {
		            if (larg0) {
		                js_proxy_t *jsProxy = js_get_or_create_proxy<cocos2d::Ref>(cx, (cocos2d::Ref*)larg0);
		                largv[0] = OBJECT_TO_JSVAL(jsProxy->obj);
		            } else {
		                largv[0] = JSVAL_NULL;
		            }
		        } while (0);
		        largv[1] = std_string_to_jsval(cx, larg1);
		        jsval rval;
		        bool ok = func->invoke(2, &largv[0], rval);
		        if (!ok && JS_IsExceptionPending(cx)) {
		            JS_ReportPendingException(cx);
		        }
		    };
		    arg1 = lambda;
		} while(0)
		;
        JSB_PRECONDITION2(ok, cx, false, "js_cocos2dx_cocoseditor_CCEAnimationManager_addCallback : Error processing arguments");
        cobj->addCallback(arg0, arg1);
        JS_SET_RVAL(cx, vp, JSVAL_VOID);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEAnimationManager_addCallback : wrong number of arguments: %d, was expecting %d", argc, 2);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEAnimationManager_setChannelCallback(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEAnimationManager* cobj = (cce::CCEAnimationManager *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEAnimationManager_setChannelCallback : Invalid Native Object");
    if (argc == 1) {
        std::function<void (cocos2d::Ref *, std::basic_string<char>)> arg0;
        do {
		    std::shared_ptr<JSFunctionWrapper> func(new JSFunctionWrapper(cx, JS_THIS_OBJECT(cx, vp), argv[0]));
		    auto lambda = [=](cocos2d::Ref* larg0, std::basic_string<char> larg1) -> void {
		        jsval largv[2];
		        do {
		            if (larg0) {
		                js_proxy_t *jsProxy = js_get_or_create_proxy<cocos2d::Ref>(cx, (cocos2d::Ref*)larg0);
		                largv[0] = OBJECT_TO_JSVAL(jsProxy->obj);
		            } else {
		                largv[0] = JSVAL_NULL;
		            }
		        } while (0);
		        largv[1] = std_string_to_jsval(cx, larg1);
		        jsval rval;
		        bool ok = func->invoke(2, &largv[0], rval);
		        if (!ok && JS_IsExceptionPending(cx)) {
		            JS_ReportPendingException(cx);
		        }
		    };
		    arg0 = lambda;
		} while(0)
		;
        JSB_PRECONDITION2(ok, cx, false, "js_cocos2dx_cocoseditor_CCEAnimationManager_setChannelCallback : Error processing arguments");
        cobj->setChannelCallback(arg0);
        JS_SET_RVAL(cx, vp, JSVAL_VOID);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEAnimationManager_setChannelCallback : wrong number of arguments: %d, was expecting %d", argc, 1);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEAnimationManager_setAnimationCallback(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEAnimationManager* cobj = (cce::CCEAnimationManager *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEAnimationManager_setAnimationCallback : Invalid Native Object");
    if (argc == 1) {
        std::function<void (cocos2d::Ref *, std::basic_string<char>)> arg0;
        do {
		    std::shared_ptr<JSFunctionWrapper> func(new JSFunctionWrapper(cx, JS_THIS_OBJECT(cx, vp), argv[0]));
		    auto lambda = [=](cocos2d::Ref* larg0, std::basic_string<char> larg1) -> void {
		        jsval largv[2];
		        do {
		            if (larg0) {
		                js_proxy_t *jsProxy = js_get_or_create_proxy<cocos2d::Ref>(cx, (cocos2d::Ref*)larg0);
		                largv[0] = OBJECT_TO_JSVAL(jsProxy->obj);
		            } else {
		                largv[0] = JSVAL_NULL;
		            }
		        } while (0);
		        largv[1] = std_string_to_jsval(cx, larg1);
		        jsval rval;
		        bool ok = func->invoke(2, &largv[0], rval);
		        if (!ok && JS_IsExceptionPending(cx)) {
		            JS_ReportPendingException(cx);
		        }
		    };
		    arg0 = lambda;
		} while(0)
		;
        JSB_PRECONDITION2(ok, cx, false, "js_cocos2dx_cocoseditor_CCEAnimationManager_setAnimationCallback : Error processing arguments");
        cobj->setAnimationCallback(arg0);
        JS_SET_RVAL(cx, vp, JSVAL_VOID);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEAnimationManager_setAnimationCallback : wrong number of arguments: %d, was expecting %d", argc, 1);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEAnimationManager_create(JSContext *cx, uint32_t argc, jsval *vp)
{
    if (argc == 0) {
        cce::CCEAnimationManager* ret = cce::CCEAnimationManager::create();
        jsval jsret = JSVAL_NULL;
        do {
        if (ret) {
            js_proxy_t *jsProxy = js_get_or_create_proxy<cce::CCEAnimationManager>(cx, (cce::CCEAnimationManager*)ret);
            jsret = OBJECT_TO_JSVAL(jsProxy->obj);
        } else {
            jsret = JSVAL_NULL;
        }
    } while (0);
        JS_SET_RVAL(cx, vp, jsret);
        return true;
    }
    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEAnimationManager_create : wrong number of arguments");
    return false;
}

bool js_cocos2dx_cocoseditor_CCEAnimationManager_constructor(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;
    cce::CCEAnimationManager* cobj = new (std::nothrow) cce::CCEAnimationManager();
    cocos2d::Ref *_ccobj = dynamic_cast<cocos2d::Ref *>(cobj);
    if (_ccobj) {
        _ccobj->autorelease();
    }
    TypeTest<cce::CCEAnimationManager> t;
    js_type_class_t *typeClass = nullptr;
    std::string typeName = t.s_name();
    auto typeMapIter = _js_global_type_map.find(typeName);
    CCASSERT(typeMapIter != _js_global_type_map.end(), "Can't find the class type!");
    typeClass = typeMapIter->second;
    CCASSERT(typeClass, "The value is null.");
    JSObject *obj = JS_NewObject(cx, typeClass->jsclass, typeClass->proto, typeClass->parentProto);
    JS_SET_RVAL(cx, vp, OBJECT_TO_JSVAL(obj));
    // link the native object with the javascript object
    js_proxy_t* p = jsb_new_proxy(cobj, obj);
    JS_AddNamedObjectRoot(cx, &p->obj, "cce::CCEAnimationManager");
    if (JS_HasProperty(cx, obj, "_ctor", &ok) && ok)
        ScriptingCore::getInstance()->executeFunctionWithOwner(OBJECT_TO_JSVAL(obj), "_ctor", argc, argv);
    return true;
}



void js_cce_CCEAnimationManager_finalize(JSFreeOp *fop, JSObject *obj) {
    CCLOGINFO("jsbindings: finalizing JS object %p (CCEAnimationManager)", obj);
}

void js_register_cocos2dx_cocoseditor_CCEAnimationManager(JSContext *cx, JSObject *global) {
    jsb_cce_CCEAnimationManager_class = (JSClass *)calloc(1, sizeof(JSClass));
    jsb_cce_CCEAnimationManager_class->name = "CCEAnimationManager";
    jsb_cce_CCEAnimationManager_class->addProperty = JS_PropertyStub;
    jsb_cce_CCEAnimationManager_class->delProperty = JS_DeletePropertyStub;
    jsb_cce_CCEAnimationManager_class->getProperty = JS_PropertyStub;
    jsb_cce_CCEAnimationManager_class->setProperty = JS_StrictPropertyStub;
    jsb_cce_CCEAnimationManager_class->enumerate = JS_EnumerateStub;
    jsb_cce_CCEAnimationManager_class->resolve = JS_ResolveStub;
    jsb_cce_CCEAnimationManager_class->convert = JS_ConvertStub;
    jsb_cce_CCEAnimationManager_class->finalize = js_cce_CCEAnimationManager_finalize;
    jsb_cce_CCEAnimationManager_class->flags = JSCLASS_HAS_RESERVED_SLOTS(2);

    static JSPropertySpec properties[] = {
        {"__nativeObj", 0, JSPROP_ENUMERATE | JSPROP_PERMANENT, JSOP_WRAPPER(js_is_native_obj), JSOP_NULLWRAPPER},
        {0, 0, 0, JSOP_NULLWRAPPER, JSOP_NULLWRAPPER}
    };

    static JSFunctionSpec funcs[] = {
        JS_FN("play", js_cocos2dx_cocoseditor_CCEAnimationManager_play, 1, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("addAnimation", js_cocos2dx_cocoseditor_CCEAnimationManager_addAnimation, 1, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("setAutoPlayNext", js_cocos2dx_cocoseditor_CCEAnimationManager_setAutoPlayNext, 1, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("playAuto", js_cocos2dx_cocoseditor_CCEAnimationManager_playAuto, 0, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("stop", js_cocos2dx_cocoseditor_CCEAnimationManager_stop, 1, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("isAutoPlayNext", js_cocos2dx_cocoseditor_CCEAnimationManager_isAutoPlayNext, 0, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("stopAll", js_cocos2dx_cocoseditor_CCEAnimationManager_stopAll, 0, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("addCallFun", js_cocos2dx_cocoseditor_CCEAnimationManager_addCallFun, 2, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("addCallback", js_cocos2dx_cocoseditor_CCEAnimationManager_addCallback, 2, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("setChannelCallback", js_cocos2dx_cocoseditor_CCEAnimationManager_setChannelCallback, 1, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("setAnimationCallback", js_cocos2dx_cocoseditor_CCEAnimationManager_setAnimationCallback, 1, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FS_END
    };

    static JSFunctionSpec st_funcs[] = {
        JS_FN("create", js_cocos2dx_cocoseditor_CCEAnimationManager_create, 0, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FS_END
    };

    jsb_cce_CCEAnimationManager_prototype = JS_InitClass(
        cx, global,
        NULL, // parent proto
        jsb_cce_CCEAnimationManager_class,
        js_cocos2dx_cocoseditor_CCEAnimationManager_constructor, 0, // constructor
        properties,
        funcs,
        NULL, // no static properties
        st_funcs);
    // make the class enumerable in the registered namespace
//  bool found;
//FIXME: Removed in Firefox v27 
//  JS_SetPropertyAttributes(cx, global, "CCEAnimationManager", JSPROP_ENUMERATE | JSPROP_READONLY, &found);

    // add the proto and JSClass to the type->js info hash table
    TypeTest<cce::CCEAnimationManager> t;
    js_type_class_t *p;
    std::string typeName = t.s_name();
    if (_js_global_type_map.find(typeName) == _js_global_type_map.end())
    {
        p = (js_type_class_t *)malloc(sizeof(js_type_class_t));
        p->jsclass = jsb_cce_CCEAnimationManager_class;
        p->proto = jsb_cce_CCEAnimationManager_prototype;
        p->parentProto = NULL;
        _js_global_type_map.insert(std::make_pair(typeName, p));
    }
}

JSClass  *jsb_cce_CCEEventHandler_class;
JSObject *jsb_cce_CCEEventHandler_prototype;

bool js_cocos2dx_cocoseditor_CCEEventHandler_addAction(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEEventHandler* cobj = (cce::CCEEventHandler *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEEventHandler_addAction : Invalid Native Object");
    if (argc == 1) {
        cce::CCEEventAction* arg0;
        do {
            if (!argv[0].isObject()) { ok = false; break; }
            js_proxy_t *jsProxy;
            JSObject *tmpObj = JSVAL_TO_OBJECT(argv[0]);
            jsProxy = jsb_get_js_proxy(tmpObj);
            arg0 = (cce::CCEEventAction*)(jsProxy ? jsProxy->ptr : NULL);
            JSB_PRECONDITION2( arg0, cx, false, "Invalid Native Object");
        } while (0);
        JSB_PRECONDITION2(ok, cx, false, "js_cocos2dx_cocoseditor_CCEEventHandler_addAction : Error processing arguments");
        cobj->addAction(arg0);
        JS_SET_RVAL(cx, vp, JSVAL_VOID);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEEventHandler_addAction : wrong number of arguments: %d, was expecting %d", argc, 1);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEEventHandler_doKeyEvent(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEEventHandler* cobj = (cce::CCEEventHandler *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEEventHandler_doKeyEvent : Invalid Native Object");
    if (argc == 1) {
        cocos2d::EventKeyboard::KeyCode arg0;
        ok &= jsval_to_int32(cx, argv[0], (int32_t *)&arg0);
        JSB_PRECONDITION2(ok, cx, false, "js_cocos2dx_cocoseditor_CCEEventHandler_doKeyEvent : Error processing arguments");
        cobj->doKeyEvent(arg0);
        JS_SET_RVAL(cx, vp, JSVAL_VOID);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEEventHandler_doKeyEvent : wrong number of arguments: %d, was expecting %d", argc, 1);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEEventHandler_handleActions(JSContext *cx, uint32_t argc, jsval *vp)
{
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEEventHandler* cobj = (cce::CCEEventHandler *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEEventHandler_handleActions : Invalid Native Object");
    if (argc == 0) {
        cobj->handleActions();
        JS_SET_RVAL(cx, vp, JSVAL_VOID);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEEventHandler_handleActions : wrong number of arguments: %d, was expecting %d", argc, 0);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEEventHandler_handleNodeEvent(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEEventHandler* cobj = (cce::CCEEventHandler *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEEventHandler_handleNodeEvent : Invalid Native Object");
    if (argc == 2) {
        cocos2d::Ref* arg0;
        std::string arg1;
        do {
            if (!argv[0].isObject()) { ok = false; break; }
            js_proxy_t *jsProxy;
            JSObject *tmpObj = JSVAL_TO_OBJECT(argv[0]);
            jsProxy = jsb_get_js_proxy(tmpObj);
            arg0 = (cocos2d::Ref*)(jsProxy ? jsProxy->ptr : NULL);
            JSB_PRECONDITION2( arg0, cx, false, "Invalid Native Object");
        } while (0);
        ok &= jsval_to_std_string(cx, argv[1], &arg1);
        JSB_PRECONDITION2(ok, cx, false, "js_cocos2dx_cocoseditor_CCEEventHandler_handleNodeEvent : Error processing arguments");
        cobj->handleNodeEvent(arg0, arg1);
        JS_SET_RVAL(cx, vp, JSVAL_VOID);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEEventHandler_handleNodeEvent : wrong number of arguments: %d, was expecting %d", argc, 2);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEEventHandler_getEventName(JSContext *cx, uint32_t argc, jsval *vp)
{
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEEventHandler* cobj = (cce::CCEEventHandler *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEEventHandler_getEventName : Invalid Native Object");
    if (argc == 0) {
        std::string ret = cobj->getEventName();
        jsval jsret = JSVAL_NULL;
        jsret = std_string_to_jsval(cx, ret);
        JS_SET_RVAL(cx, vp, jsret);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEEventHandler_getEventName : wrong number of arguments: %d, was expecting %d", argc, 0);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEEventHandler_getEventArg(JSContext *cx, uint32_t argc, jsval *vp)
{
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEEventHandler* cobj = (cce::CCEEventHandler *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEEventHandler_getEventArg : Invalid Native Object");
    if (argc == 0) {
        std::string ret = cobj->getEventArg();
        jsval jsret = JSVAL_NULL;
        jsret = std_string_to_jsval(cx, ret);
        JS_SET_RVAL(cx, vp, jsret);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEEventHandler_getEventArg : wrong number of arguments: %d, was expecting %d", argc, 0);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEEventHandler_getNode(JSContext *cx, uint32_t argc, jsval *vp)
{
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEEventHandler* cobj = (cce::CCEEventHandler *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEEventHandler_getNode : Invalid Native Object");
    if (argc == 0) {
        cocos2d::Ref* ret = cobj->getNode();
        jsval jsret = JSVAL_NULL;
        do {
            if (ret) {
                js_proxy_t *jsProxy = js_get_or_create_proxy<cocos2d::Ref>(cx, (cocos2d::Ref*)ret);
                jsret = OBJECT_TO_JSVAL(jsProxy->obj);
            } else {
                jsret = JSVAL_NULL;
            }
        } while (0);
        JS_SET_RVAL(cx, vp, jsret);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEEventHandler_getNode : wrong number of arguments: %d, was expecting %d", argc, 0);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEEventHandler_create(JSContext *cx, uint32_t argc, jsval *vp)
{
    if (argc == 0) {
        cce::CCEEventHandler* ret = cce::CCEEventHandler::create();
        jsval jsret = JSVAL_NULL;
        do {
        if (ret) {
            js_proxy_t *jsProxy = js_get_or_create_proxy<cce::CCEEventHandler>(cx, (cce::CCEEventHandler*)ret);
            jsret = OBJECT_TO_JSVAL(jsProxy->obj);
        } else {
            jsret = JSVAL_NULL;
        }
    } while (0);
        JS_SET_RVAL(cx, vp, jsret);
        return true;
    }
    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEEventHandler_create : wrong number of arguments");
    return false;
}

bool js_cocos2dx_cocoseditor_CCEEventHandler_constructor(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;
    cce::CCEEventHandler* cobj = new (std::nothrow) cce::CCEEventHandler();
    cocos2d::Ref *_ccobj = dynamic_cast<cocos2d::Ref *>(cobj);
    if (_ccobj) {
        _ccobj->autorelease();
    }
    TypeTest<cce::CCEEventHandler> t;
    js_type_class_t *typeClass = nullptr;
    std::string typeName = t.s_name();
    auto typeMapIter = _js_global_type_map.find(typeName);
    CCASSERT(typeMapIter != _js_global_type_map.end(), "Can't find the class type!");
    typeClass = typeMapIter->second;
    CCASSERT(typeClass, "The value is null.");
    JSObject *obj = JS_NewObject(cx, typeClass->jsclass, typeClass->proto, typeClass->parentProto);
    JS_SET_RVAL(cx, vp, OBJECT_TO_JSVAL(obj));
    // link the native object with the javascript object
    js_proxy_t* p = jsb_new_proxy(cobj, obj);
    JS_AddNamedObjectRoot(cx, &p->obj, "cce::CCEEventHandler");
    if (JS_HasProperty(cx, obj, "_ctor", &ok) && ok)
        ScriptingCore::getInstance()->executeFunctionWithOwner(OBJECT_TO_JSVAL(obj), "_ctor", argc, argv);
    return true;
}



void js_cce_CCEEventHandler_finalize(JSFreeOp *fop, JSObject *obj) {
    CCLOGINFO("jsbindings: finalizing JS object %p (CCEEventHandler)", obj);
}

void js_register_cocos2dx_cocoseditor_CCEEventHandler(JSContext *cx, JSObject *global) {
    jsb_cce_CCEEventHandler_class = (JSClass *)calloc(1, sizeof(JSClass));
    jsb_cce_CCEEventHandler_class->name = "CCEEventHandler";
    jsb_cce_CCEEventHandler_class->addProperty = JS_PropertyStub;
    jsb_cce_CCEEventHandler_class->delProperty = JS_DeletePropertyStub;
    jsb_cce_CCEEventHandler_class->getProperty = JS_PropertyStub;
    jsb_cce_CCEEventHandler_class->setProperty = JS_StrictPropertyStub;
    jsb_cce_CCEEventHandler_class->enumerate = JS_EnumerateStub;
    jsb_cce_CCEEventHandler_class->resolve = JS_ResolveStub;
    jsb_cce_CCEEventHandler_class->convert = JS_ConvertStub;
    jsb_cce_CCEEventHandler_class->finalize = js_cce_CCEEventHandler_finalize;
    jsb_cce_CCEEventHandler_class->flags = JSCLASS_HAS_RESERVED_SLOTS(2);

    static JSPropertySpec properties[] = {
        {"__nativeObj", 0, JSPROP_ENUMERATE | JSPROP_PERMANENT, JSOP_WRAPPER(js_is_native_obj), JSOP_NULLWRAPPER},
        {0, 0, 0, JSOP_NULLWRAPPER, JSOP_NULLWRAPPER}
    };

    static JSFunctionSpec funcs[] = {
        JS_FN("addAction", js_cocos2dx_cocoseditor_CCEEventHandler_addAction, 1, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("doKeyEvent", js_cocos2dx_cocoseditor_CCEEventHandler_doKeyEvent, 1, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("handleActions", js_cocos2dx_cocoseditor_CCEEventHandler_handleActions, 0, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("handleNodeEvent", js_cocos2dx_cocoseditor_CCEEventHandler_handleNodeEvent, 2, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("getEventName", js_cocos2dx_cocoseditor_CCEEventHandler_getEventName, 0, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("getEventArg", js_cocos2dx_cocoseditor_CCEEventHandler_getEventArg, 0, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("getNode", js_cocos2dx_cocoseditor_CCEEventHandler_getNode, 0, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FS_END
    };

    static JSFunctionSpec st_funcs[] = {
        JS_FN("create", js_cocos2dx_cocoseditor_CCEEventHandler_create, 0, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FS_END
    };

    jsb_cce_CCEEventHandler_prototype = JS_InitClass(
        cx, global,
        NULL, // parent proto
        jsb_cce_CCEEventHandler_class,
        js_cocos2dx_cocoseditor_CCEEventHandler_constructor, 0, // constructor
        properties,
        funcs,
        NULL, // no static properties
        st_funcs);
    // make the class enumerable in the registered namespace
//  bool found;
//FIXME: Removed in Firefox v27 
//  JS_SetPropertyAttributes(cx, global, "CCEEventHandler", JSPROP_ENUMERATE | JSPROP_READONLY, &found);

    // add the proto and JSClass to the type->js info hash table
    TypeTest<cce::CCEEventHandler> t;
    js_type_class_t *p;
    std::string typeName = t.s_name();
    if (_js_global_type_map.find(typeName) == _js_global_type_map.end())
    {
        p = (js_type_class_t *)malloc(sizeof(js_type_class_t));
        p->jsclass = jsb_cce_CCEEventHandler_class;
        p->proto = jsb_cce_CCEEventHandler_prototype;
        p->parentProto = NULL;
        _js_global_type_map.insert(std::make_pair(typeName, p));
    }
}

JSClass  *jsb_cce_CCEReader_class;
JSObject *jsb_cce_CCEReader_prototype;

bool js_cocos2dx_cocoseditor_CCEReader_getLabel(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;

    JSObject *obj = NULL;
    cce::CCEReader* cobj = NULL;
    obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cobj = (cce::CCEReader *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEReader_getLabel : Invalid Native Object");
    do {
        if (argc == 1) {
            std::string arg0;
            ok &= jsval_to_std_string(cx, argv[0], &arg0);
            if (!ok) { ok = true; break; }
            cocos2d::Label* ret = cobj->getLabel(arg0);
            jsval jsret = JSVAL_NULL;
            do {
            if (ret) {
                js_proxy_t *jsProxy = js_get_or_create_proxy<cocos2d::Label>(cx, (cocos2d::Label*)ret);
                jsret = OBJECT_TO_JSVAL(jsProxy->obj);
            } else {
                jsret = JSVAL_NULL;
            }
        } while (0);
            JS_SET_RVAL(cx, vp, jsret);
            return true;
        }
    } while(0);

    do {
        if (argc == 1) {
            int arg0;
            ok &= jsval_to_int32(cx, argv[0], (int32_t *)&arg0);
            if (!ok) { ok = true; break; }
            cocos2d::Label* ret = cobj->getLabel(arg0);
            jsval jsret = JSVAL_NULL;
            do {
            if (ret) {
                js_proxy_t *jsProxy = js_get_or_create_proxy<cocos2d::Label>(cx, (cocos2d::Label*)ret);
                jsret = OBJECT_TO_JSVAL(jsProxy->obj);
            } else {
                jsret = JSVAL_NULL;
            }
        } while (0);
            JS_SET_RVAL(cx, vp, jsret);
            return true;
        }
    } while(0);

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEReader_getLabel : wrong number of arguments");
    return false;
}
bool js_cocos2dx_cocoseditor_CCEReader_getAnimationManager(JSContext *cx, uint32_t argc, jsval *vp)
{
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEReader* cobj = (cce::CCEReader *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEReader_getAnimationManager : Invalid Native Object");
    if (argc == 0) {
        cce::CCEAnimationManager* ret = cobj->getAnimationManager();
        jsval jsret = JSVAL_NULL;
        do {
            if (ret) {
                js_proxy_t *jsProxy = js_get_or_create_proxy<cce::CCEAnimationManager>(cx, (cce::CCEAnimationManager*)ret);
                jsret = OBJECT_TO_JSVAL(jsProxy->obj);
            } else {
                jsret = JSVAL_NULL;
            }
        } while (0);
        JS_SET_RVAL(cx, vp, jsret);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEReader_getAnimationManager : wrong number of arguments: %d, was expecting %d", argc, 0);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEReader_getPhysicsJointGear(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEReader* cobj = (cce::CCEReader *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEReader_getPhysicsJointGear : Invalid Native Object");
    if (argc == 1) {
        int arg0;
        ok &= jsval_to_int32(cx, argv[0], (int32_t *)&arg0);
        JSB_PRECONDITION2(ok, cx, false, "js_cocos2dx_cocoseditor_CCEReader_getPhysicsJointGear : Error processing arguments");
        cocos2d::PhysicsJointGear* ret = cobj->getPhysicsJointGear(arg0);
        jsval jsret = JSVAL_NULL;
        do {
            if (ret) {
                js_proxy_t *jsProxy = js_get_or_create_proxy<cocos2d::PhysicsJointGear>(cx, (cocos2d::PhysicsJointGear*)ret);
                jsret = OBJECT_TO_JSVAL(jsProxy->obj);
            } else {
                jsret = JSVAL_NULL;
            }
        } while (0);
        JS_SET_RVAL(cx, vp, jsret);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEReader_getPhysicsJointGear : wrong number of arguments: %d, was expecting %d", argc, 1);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEReader_getCCEReaderByIndex(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEReader* cobj = (cce::CCEReader *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEReader_getCCEReaderByIndex : Invalid Native Object");
    if (argc == 1) {
        int arg0;
        ok &= jsval_to_int32(cx, argv[0], (int32_t *)&arg0);
        JSB_PRECONDITION2(ok, cx, false, "js_cocos2dx_cocoseditor_CCEReader_getCCEReaderByIndex : Error processing arguments");
        cce::CCEReader* ret = cobj->getCCEReaderByIndex(arg0);
        jsval jsret = JSVAL_NULL;
        do {
            if (ret) {
                js_proxy_t *jsProxy = js_get_or_create_proxy<cce::CCEReader>(cx, (cce::CCEReader*)ret);
                jsret = OBJECT_TO_JSVAL(jsProxy->obj);
            } else {
                jsret = JSVAL_NULL;
            }
        } while (0);
        JS_SET_RVAL(cx, vp, jsret);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEReader_getCCEReaderByIndex : wrong number of arguments: %d, was expecting %d", argc, 1);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEReader_getPhysicsShapeCircle(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEReader* cobj = (cce::CCEReader *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEReader_getPhysicsShapeCircle : Invalid Native Object");
    if (argc == 1) {
        int arg0;
        ok &= jsval_to_int32(cx, argv[0], (int32_t *)&arg0);
        JSB_PRECONDITION2(ok, cx, false, "js_cocos2dx_cocoseditor_CCEReader_getPhysicsShapeCircle : Error processing arguments");
        cocos2d::PhysicsShapeCircle* ret = cobj->getPhysicsShapeCircle(arg0);
        jsval jsret = JSVAL_NULL;
        do {
            if (ret) {
                js_proxy_t *jsProxy = js_get_or_create_proxy<cocos2d::PhysicsShapeCircle>(cx, (cocos2d::PhysicsShapeCircle*)ret);
                jsret = OBJECT_TO_JSVAL(jsProxy->obj);
            } else {
                jsret = JSVAL_NULL;
            }
        } while (0);
        JS_SET_RVAL(cx, vp, jsret);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEReader_getPhysicsShapeCircle : wrong number of arguments: %d, was expecting %d", argc, 1);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEReader_stopAllAnimation(JSContext *cx, uint32_t argc, jsval *vp)
{
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEReader* cobj = (cce::CCEReader *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEReader_stopAllAnimation : Invalid Native Object");
    if (argc == 0) {
        cobj->stopAllAnimation();
        JS_SET_RVAL(cx, vp, JSVAL_VOID);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEReader_stopAllAnimation : wrong number of arguments: %d, was expecting %d", argc, 0);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEReader_playAutoAnimations(JSContext *cx, uint32_t argc, jsval *vp)
{
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEReader* cobj = (cce::CCEReader *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEReader_playAutoAnimations : Invalid Native Object");
    if (argc == 0) {
        cobj->playAutoAnimations();
        JS_SET_RVAL(cx, vp, JSVAL_VOID);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEReader_playAutoAnimations : wrong number of arguments: %d, was expecting %d", argc, 0);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEReader_getPhysicsJointFixed(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEReader* cobj = (cce::CCEReader *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEReader_getPhysicsJointFixed : Invalid Native Object");
    if (argc == 1) {
        int arg0;
        ok &= jsval_to_int32(cx, argv[0], (int32_t *)&arg0);
        JSB_PRECONDITION2(ok, cx, false, "js_cocos2dx_cocoseditor_CCEReader_getPhysicsJointFixed : Error processing arguments");
        cocos2d::PhysicsJointFixed* ret = cobj->getPhysicsJointFixed(arg0);
        jsval jsret = JSVAL_NULL;
        do {
            if (ret) {
                js_proxy_t *jsProxy = js_get_or_create_proxy<cocos2d::PhysicsJointFixed>(cx, (cocos2d::PhysicsJointFixed*)ret);
                jsret = OBJECT_TO_JSVAL(jsProxy->obj);
            } else {
                jsret = JSVAL_NULL;
            }
        } while (0);
        JS_SET_RVAL(cx, vp, jsret);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEReader_getPhysicsJointFixed : wrong number of arguments: %d, was expecting %d", argc, 1);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEReader_getCCEReader(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;

    JSObject *obj = NULL;
    cce::CCEReader* cobj = NULL;
    obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cobj = (cce::CCEReader *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEReader_getCCEReader : Invalid Native Object");
    do {
        if (argc == 1) {
            std::string arg0;
            ok &= jsval_to_std_string(cx, argv[0], &arg0);
            if (!ok) { ok = true; break; }
            cce::CCEReader* ret = cobj->getCCEReader(arg0);
            jsval jsret = JSVAL_NULL;
            do {
            if (ret) {
                js_proxy_t *jsProxy = js_get_or_create_proxy<cce::CCEReader>(cx, (cce::CCEReader*)ret);
                jsret = OBJECT_TO_JSVAL(jsProxy->obj);
            } else {
                jsret = JSVAL_NULL;
            }
        } while (0);
            JS_SET_RVAL(cx, vp, jsret);
            return true;
        }
    } while(0);

    do {
        if (argc == 1) {
            int arg0;
            ok &= jsval_to_int32(cx, argv[0], (int32_t *)&arg0);
            if (!ok) { ok = true; break; }
            cce::CCEReader* ret = cobj->getCCEReader(arg0);
            jsval jsret = JSVAL_NULL;
            do {
            if (ret) {
                js_proxy_t *jsProxy = js_get_or_create_proxy<cce::CCEReader>(cx, (cce::CCEReader*)ret);
                jsret = OBJECT_TO_JSVAL(jsProxy->obj);
            } else {
                jsret = JSVAL_NULL;
            }
        } while (0);
            JS_SET_RVAL(cx, vp, jsret);
            return true;
        }
    } while(0);

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEReader_getCCEReader : wrong number of arguments");
    return false;
}
bool js_cocos2dx_cocoseditor_CCEReader_getMenuItem(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;

    JSObject *obj = NULL;
    cce::CCEReader* cobj = NULL;
    obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cobj = (cce::CCEReader *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEReader_getMenuItem : Invalid Native Object");
    do {
        if (argc == 1) {
            std::string arg0;
            ok &= jsval_to_std_string(cx, argv[0], &arg0);
            if (!ok) { ok = true; break; }
            cocos2d::MenuItem* ret = cobj->getMenuItem(arg0);
            jsval jsret = JSVAL_NULL;
            do {
            if (ret) {
                js_proxy_t *jsProxy = js_get_or_create_proxy<cocos2d::MenuItem>(cx, (cocos2d::MenuItem*)ret);
                jsret = OBJECT_TO_JSVAL(jsProxy->obj);
            } else {
                jsret = JSVAL_NULL;
            }
        } while (0);
            JS_SET_RVAL(cx, vp, jsret);
            return true;
        }
    } while(0);

    do {
        if (argc == 1) {
            int arg0;
            ok &= jsval_to_int32(cx, argv[0], (int32_t *)&arg0);
            if (!ok) { ok = true; break; }
            cocos2d::MenuItem* ret = cobj->getMenuItem(arg0);
            jsval jsret = JSVAL_NULL;
            do {
            if (ret) {
                js_proxy_t *jsProxy = js_get_or_create_proxy<cocos2d::MenuItem>(cx, (cocos2d::MenuItem*)ret);
                jsret = OBJECT_TO_JSVAL(jsProxy->obj);
            } else {
                jsret = JSVAL_NULL;
            }
        } while (0);
            JS_SET_RVAL(cx, vp, jsret);
            return true;
        }
    } while(0);

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEReader_getMenuItem : wrong number of arguments");
    return false;
}
bool js_cocos2dx_cocoseditor_CCEReader_getRef(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;

    JSObject *obj = NULL;
    cce::CCEReader* cobj = NULL;
    obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cobj = (cce::CCEReader *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEReader_getRef : Invalid Native Object");
    do {
        if (argc == 1) {
            std::string arg0;
            ok &= jsval_to_std_string(cx, argv[0], &arg0);
            if (!ok) { ok = true; break; }
            cocos2d::Ref* ret = cobj->getRef(arg0);
            jsval jsret = JSVAL_NULL;
            do {
            if (ret) {
                js_proxy_t *jsProxy = js_get_or_create_proxy<cocos2d::Ref>(cx, (cocos2d::Ref*)ret);
                jsret = OBJECT_TO_JSVAL(jsProxy->obj);
            } else {
                jsret = JSVAL_NULL;
            }
        } while (0);
            JS_SET_RVAL(cx, vp, jsret);
            return true;
        }
    } while(0);

    do {
        if (argc == 1) {
            int arg0;
            ok &= jsval_to_int32(cx, argv[0], (int32_t *)&arg0);
            if (!ok) { ok = true; break; }
            cocos2d::Ref* ret = cobj->getRef(arg0);
            jsval jsret = JSVAL_NULL;
            do {
            if (ret) {
                js_proxy_t *jsProxy = js_get_or_create_proxy<cocos2d::Ref>(cx, (cocos2d::Ref*)ret);
                jsret = OBJECT_TO_JSVAL(jsProxy->obj);
            } else {
                jsret = JSVAL_NULL;
            }
        } while (0);
            JS_SET_RVAL(cx, vp, jsret);
            return true;
        }
    } while(0);

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEReader_getRef : wrong number of arguments");
    return false;
}
bool js_cocos2dx_cocoseditor_CCEReader_getPhysicsJointRotarySpring(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEReader* cobj = (cce::CCEReader *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEReader_getPhysicsJointRotarySpring : Invalid Native Object");
    if (argc == 1) {
        int arg0;
        ok &= jsval_to_int32(cx, argv[0], (int32_t *)&arg0);
        JSB_PRECONDITION2(ok, cx, false, "js_cocos2dx_cocoseditor_CCEReader_getPhysicsJointRotarySpring : Error processing arguments");
        cocos2d::PhysicsJointRotarySpring* ret = cobj->getPhysicsJointRotarySpring(arg0);
        jsval jsret = JSVAL_NULL;
        do {
            if (ret) {
                js_proxy_t *jsProxy = js_get_or_create_proxy<cocos2d::PhysicsJointRotarySpring>(cx, (cocos2d::PhysicsJointRotarySpring*)ret);
                jsret = OBJECT_TO_JSVAL(jsProxy->obj);
            } else {
                jsret = JSVAL_NULL;
            }
        } while (0);
        JS_SET_RVAL(cx, vp, jsret);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEReader_getPhysicsJointRotarySpring : wrong number of arguments: %d, was expecting %d", argc, 1);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEReader_getMenu(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;

    JSObject *obj = NULL;
    cce::CCEReader* cobj = NULL;
    obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cobj = (cce::CCEReader *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEReader_getMenu : Invalid Native Object");
    do {
        if (argc == 1) {
            std::string arg0;
            ok &= jsval_to_std_string(cx, argv[0], &arg0);
            if (!ok) { ok = true; break; }
            cocos2d::Menu* ret = cobj->getMenu(arg0);
            jsval jsret = JSVAL_NULL;
            do {
            if (ret) {
                js_proxy_t *jsProxy = js_get_or_create_proxy<cocos2d::Menu>(cx, (cocos2d::Menu*)ret);
                jsret = OBJECT_TO_JSVAL(jsProxy->obj);
            } else {
                jsret = JSVAL_NULL;
            }
        } while (0);
            JS_SET_RVAL(cx, vp, jsret);
            return true;
        }
    } while(0);

    do {
        if (argc == 1) {
            int arg0;
            ok &= jsval_to_int32(cx, argv[0], (int32_t *)&arg0);
            if (!ok) { ok = true; break; }
            cocos2d::Menu* ret = cobj->getMenu(arg0);
            jsval jsret = JSVAL_NULL;
            do {
            if (ret) {
                js_proxy_t *jsProxy = js_get_or_create_proxy<cocos2d::Menu>(cx, (cocos2d::Menu*)ret);
                jsret = OBJECT_TO_JSVAL(jsProxy->obj);
            } else {
                jsret = JSVAL_NULL;
            }
        } while (0);
            JS_SET_RVAL(cx, vp, jsret);
            return true;
        }
    } while(0);

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEReader_getMenu : wrong number of arguments");
    return false;
}
bool js_cocos2dx_cocoseditor_CCEReader_getPhysicsShapeEdgePolygon(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEReader* cobj = (cce::CCEReader *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEReader_getPhysicsShapeEdgePolygon : Invalid Native Object");
    if (argc == 1) {
        int arg0;
        ok &= jsval_to_int32(cx, argv[0], (int32_t *)&arg0);
        JSB_PRECONDITION2(ok, cx, false, "js_cocos2dx_cocoseditor_CCEReader_getPhysicsShapeEdgePolygon : Error processing arguments");
        cocos2d::PhysicsShapeEdgePolygon* ret = cobj->getPhysicsShapeEdgePolygon(arg0);
        jsval jsret = JSVAL_NULL;
        do {
            if (ret) {
                js_proxy_t *jsProxy = js_get_or_create_proxy<cocos2d::PhysicsShapeEdgePolygon>(cx, (cocos2d::PhysicsShapeEdgePolygon*)ret);
                jsret = OBJECT_TO_JSVAL(jsProxy->obj);
            } else {
                jsret = JSVAL_NULL;
            }
        } while (0);
        JS_SET_RVAL(cx, vp, jsret);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEReader_getPhysicsShapeEdgePolygon : wrong number of arguments: %d, was expecting %d", argc, 1);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEReader_getSprite(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;

    JSObject *obj = NULL;
    cce::CCEReader* cobj = NULL;
    obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cobj = (cce::CCEReader *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEReader_getSprite : Invalid Native Object");
    do {
        if (argc == 1) {
            std::string arg0;
            ok &= jsval_to_std_string(cx, argv[0], &arg0);
            if (!ok) { ok = true; break; }
            cocos2d::Sprite* ret = cobj->getSprite(arg0);
            jsval jsret = JSVAL_NULL;
            do {
            if (ret) {
                js_proxy_t *jsProxy = js_get_or_create_proxy<cocos2d::Sprite>(cx, (cocos2d::Sprite*)ret);
                jsret = OBJECT_TO_JSVAL(jsProxy->obj);
            } else {
                jsret = JSVAL_NULL;
            }
        } while (0);
            JS_SET_RVAL(cx, vp, jsret);
            return true;
        }
    } while(0);

    do {
        if (argc == 1) {
            int arg0;
            ok &= jsval_to_int32(cx, argv[0], (int32_t *)&arg0);
            if (!ok) { ok = true; break; }
            cocos2d::Sprite* ret = cobj->getSprite(arg0);
            jsval jsret = JSVAL_NULL;
            do {
            if (ret) {
                js_proxy_t *jsProxy = js_get_or_create_proxy<cocos2d::Sprite>(cx, (cocos2d::Sprite*)ret);
                jsret = OBJECT_TO_JSVAL(jsProxy->obj);
            } else {
                jsret = JSVAL_NULL;
            }
        } while (0);
            JS_SET_RVAL(cx, vp, jsret);
            return true;
        }
    } while(0);

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEReader_getSprite : wrong number of arguments");
    return false;
}
bool js_cocos2dx_cocoseditor_CCEReader_getPhysicsJointDistance(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEReader* cobj = (cce::CCEReader *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEReader_getPhysicsJointDistance : Invalid Native Object");
    if (argc == 1) {
        int arg0;
        ok &= jsval_to_int32(cx, argv[0], (int32_t *)&arg0);
        JSB_PRECONDITION2(ok, cx, false, "js_cocos2dx_cocoseditor_CCEReader_getPhysicsJointDistance : Error processing arguments");
        cocos2d::PhysicsJointDistance* ret = cobj->getPhysicsJointDistance(arg0);
        jsval jsret = JSVAL_NULL;
        do {
            if (ret) {
                js_proxy_t *jsProxy = js_get_or_create_proxy<cocos2d::PhysicsJointDistance>(cx, (cocos2d::PhysicsJointDistance*)ret);
                jsret = OBJECT_TO_JSVAL(jsProxy->obj);
            } else {
                jsret = JSVAL_NULL;
            }
        } while (0);
        JS_SET_RVAL(cx, vp, jsret);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEReader_getPhysicsJointDistance : wrong number of arguments: %d, was expecting %d", argc, 1);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEReader_getComponentNodes(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEReader* cobj = (cce::CCEReader *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEReader_getComponentNodes : Invalid Native Object");
    if (argc == 1) {
        std::string arg0;
        ok &= jsval_to_std_string(cx, argv[0], &arg0);
        JSB_PRECONDITION2(ok, cx, false, "js_cocos2dx_cocoseditor_CCEReader_getComponentNodes : Error processing arguments");
        cocos2d::Vector<cocos2d::Node *>& ret = cobj->getComponentNodes(arg0);
        jsval jsret = JSVAL_NULL;
        jsret = ccvector_to_jsval(cx, ret);
        JS_SET_RVAL(cx, vp, jsret);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEReader_getComponentNodes : wrong number of arguments: %d, was expecting %d", argc, 1);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEReader_getLayer(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;

    JSObject *obj = NULL;
    cce::CCEReader* cobj = NULL;
    obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cobj = (cce::CCEReader *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEReader_getLayer : Invalid Native Object");
    do {
        if (argc == 1) {
            std::string arg0;
            ok &= jsval_to_std_string(cx, argv[0], &arg0);
            if (!ok) { ok = true; break; }
            cocos2d::Layer* ret = cobj->getLayer(arg0);
            jsval jsret = JSVAL_NULL;
            do {
            if (ret) {
                js_proxy_t *jsProxy = js_get_or_create_proxy<cocos2d::Layer>(cx, (cocos2d::Layer*)ret);
                jsret = OBJECT_TO_JSVAL(jsProxy->obj);
            } else {
                jsret = JSVAL_NULL;
            }
        } while (0);
            JS_SET_RVAL(cx, vp, jsret);
            return true;
        }
    } while(0);

    do {
        if (argc == 1) {
            int arg0;
            ok &= jsval_to_int32(cx, argv[0], (int32_t *)&arg0);
            if (!ok) { ok = true; break; }
            cocos2d::Layer* ret = cobj->getLayer(arg0);
            jsval jsret = JSVAL_NULL;
            do {
            if (ret) {
                js_proxy_t *jsProxy = js_get_or_create_proxy<cocos2d::Layer>(cx, (cocos2d::Layer*)ret);
                jsret = OBJECT_TO_JSVAL(jsProxy->obj);
            } else {
                jsret = JSVAL_NULL;
            }
        } while (0);
            JS_SET_RVAL(cx, vp, jsret);
            return true;
        }
    } while(0);

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEReader_getLayer : wrong number of arguments");
    return false;
}
bool js_cocos2dx_cocoseditor_CCEReader_stopAnimation(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;

    JSObject *obj = NULL;
    cce::CCEReader* cobj = NULL;
    obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cobj = (cce::CCEReader *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEReader_stopAnimation : Invalid Native Object");
    do {
        if (argc == 1) {
            std::string arg0;
            ok &= jsval_to_std_string(cx, argv[0], &arg0);
            if (!ok) { ok = true; break; }
            cobj->stopAnimation(arg0);
            JS_SET_RVAL(cx, vp, JSVAL_VOID);
            return true;
        }
    } while(0);

    do {
        if (argc == 1) {
            int arg0;
            ok &= jsval_to_int32(cx, argv[0], (int32_t *)&arg0);
            if (!ok) { ok = true; break; }
            cobj->stopAnimation(arg0);
            JS_SET_RVAL(cx, vp, JSVAL_VOID);
            return true;
        }
    } while(0);

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEReader_stopAnimation : wrong number of arguments");
    return false;
}
bool js_cocos2dx_cocoseditor_CCEReader_getPhysicsJointLimit(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEReader* cobj = (cce::CCEReader *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEReader_getPhysicsJointLimit : Invalid Native Object");
    if (argc == 1) {
        int arg0;
        ok &= jsval_to_int32(cx, argv[0], (int32_t *)&arg0);
        JSB_PRECONDITION2(ok, cx, false, "js_cocos2dx_cocoseditor_CCEReader_getPhysicsJointLimit : Error processing arguments");
        cocos2d::PhysicsJointLimit* ret = cobj->getPhysicsJointLimit(arg0);
        jsval jsret = JSVAL_NULL;
        do {
            if (ret) {
                js_proxy_t *jsProxy = js_get_or_create_proxy<cocos2d::PhysicsJointLimit>(cx, (cocos2d::PhysicsJointLimit*)ret);
                jsret = OBJECT_TO_JSVAL(jsProxy->obj);
            } else {
                jsret = JSVAL_NULL;
            }
        } while (0);
        JS_SET_RVAL(cx, vp, jsret);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEReader_getPhysicsJointLimit : wrong number of arguments: %d, was expecting %d", argc, 1);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEReader_read(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;

    JSObject *obj = NULL;
    cce::CCEReader* cobj = NULL;
    obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cobj = (cce::CCEReader *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEReader_read : Invalid Native Object");
    do {
        if (argc == 0) {
            cocos2d::Ref* ret = cobj->read();
            jsval jsret = JSVAL_NULL;
            do {
            if (ret) {
                js_proxy_t *jsProxy = js_get_or_create_proxy<cocos2d::Ref>(cx, (cocos2d::Ref*)ret);
                jsret = OBJECT_TO_JSVAL(jsProxy->obj);
            } else {
                jsret = JSVAL_NULL;
            }
        } while (0);
            JS_SET_RVAL(cx, vp, jsret);
            return true;
        }
    } while(0);

    do {
        if (argc == 1) {
            std::string arg0;
            ok &= jsval_to_std_string(cx, argv[0], &arg0);
            if (!ok) { ok = true; break; }
            cocos2d::Ref* ret = cobj->read(arg0);
            jsval jsret = JSVAL_NULL;
            do {
            if (ret) {
                js_proxy_t *jsProxy = js_get_or_create_proxy<cocos2d::Ref>(cx, (cocos2d::Ref*)ret);
                jsret = OBJECT_TO_JSVAL(jsProxy->obj);
            } else {
                jsret = JSVAL_NULL;
            }
        } while (0);
            JS_SET_RVAL(cx, vp, jsret);
            return true;
        }
    } while(0);

    do {
        if (argc == 1) {
            void* arg0;
            #pragma warning NO CONVERSION TO NATIVE FOR void*
			ok = false;
            if (!ok) { ok = true; break; }
            cocos2d::Ref* ret = cobj->read(arg0);
            jsval jsret = JSVAL_NULL;
            do {
            if (ret) {
                js_proxy_t *jsProxy = js_get_or_create_proxy<cocos2d::Ref>(cx, (cocos2d::Ref*)ret);
                jsret = OBJECT_TO_JSVAL(jsProxy->obj);
            } else {
                jsret = JSVAL_NULL;
            }
        } while (0);
            JS_SET_RVAL(cx, vp, jsret);
            return true;
        }
    } while(0);

    do {
        if (argc == 2) {
            void* arg0;
            #pragma warning NO CONVERSION TO NATIVE FOR void*
			ok = false;
            if (!ok) { ok = true; break; }
            std::string arg1;
            ok &= jsval_to_std_string(cx, argv[1], &arg1);
            if (!ok) { ok = true; break; }
            cocos2d::Ref* ret = cobj->read(arg0, arg1);
            jsval jsret = JSVAL_NULL;
            do {
            if (ret) {
                js_proxy_t *jsProxy = js_get_or_create_proxy<cocos2d::Ref>(cx, (cocos2d::Ref*)ret);
                jsret = OBJECT_TO_JSVAL(jsProxy->obj);
            } else {
                jsret = JSVAL_NULL;
            }
        } while (0);
            JS_SET_RVAL(cx, vp, jsret);
            return true;
        }
    } while(0);

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEReader_read : wrong number of arguments");
    return false;
}
bool js_cocos2dx_cocoseditor_CCEReader_getAnimation(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;

    JSObject *obj = NULL;
    cce::CCEReader* cobj = NULL;
    obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cobj = (cce::CCEReader *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEReader_getAnimation : Invalid Native Object");
    do {
        if (argc == 1) {
            std::string arg0;
            ok &= jsval_to_std_string(cx, argv[0], &arg0);
            if (!ok) { ok = true; break; }
            cce::CCEAnimation* ret = cobj->getAnimation(arg0);
            jsval jsret = JSVAL_NULL;
            do {
            if (ret) {
                js_proxy_t *jsProxy = js_get_or_create_proxy<cce::CCEAnimation>(cx, (cce::CCEAnimation*)ret);
                jsret = OBJECT_TO_JSVAL(jsProxy->obj);
            } else {
                jsret = JSVAL_NULL;
            }
        } while (0);
            JS_SET_RVAL(cx, vp, jsret);
            return true;
        }
    } while(0);

    do {
        if (argc == 1) {
            int arg0;
            ok &= jsval_to_int32(cx, argv[0], (int32_t *)&arg0);
            if (!ok) { ok = true; break; }
            cce::CCEAnimation* ret = cobj->getAnimation(arg0);
            jsval jsret = JSVAL_NULL;
            do {
            if (ret) {
                js_proxy_t *jsProxy = js_get_or_create_proxy<cce::CCEAnimation>(cx, (cce::CCEAnimation*)ret);
                jsret = OBJECT_TO_JSVAL(jsProxy->obj);
            } else {
                jsret = JSVAL_NULL;
            }
        } while (0);
            JS_SET_RVAL(cx, vp, jsret);
            return true;
        }
    } while(0);

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEReader_getAnimation : wrong number of arguments");
    return false;
}
bool js_cocos2dx_cocoseditor_CCEReader_getPhysicsShapePolygon(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEReader* cobj = (cce::CCEReader *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEReader_getPhysicsShapePolygon : Invalid Native Object");
    if (argc == 1) {
        int arg0;
        ok &= jsval_to_int32(cx, argv[0], (int32_t *)&arg0);
        JSB_PRECONDITION2(ok, cx, false, "js_cocos2dx_cocoseditor_CCEReader_getPhysicsShapePolygon : Error processing arguments");
        cocos2d::PhysicsShapePolygon* ret = cobj->getPhysicsShapePolygon(arg0);
        jsval jsret = JSVAL_NULL;
        do {
            if (ret) {
                js_proxy_t *jsProxy = js_get_or_create_proxy<cocos2d::PhysicsShapePolygon>(cx, (cocos2d::PhysicsShapePolygon*)ret);
                jsret = OBJECT_TO_JSVAL(jsProxy->obj);
            } else {
                jsret = JSVAL_NULL;
            }
        } while (0);
        JS_SET_RVAL(cx, vp, jsret);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEReader_getPhysicsShapePolygon : wrong number of arguments: %d, was expecting %d", argc, 1);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEReader_playAnimation(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;

    JSObject *obj = NULL;
    cce::CCEReader* cobj = NULL;
    obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cobj = (cce::CCEReader *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEReader_playAnimation : Invalid Native Object");
    do {
        if (argc == 1) {
            int arg0;
            ok &= jsval_to_int32(cx, argv[0], (int32_t *)&arg0);
            if (!ok) { ok = true; break; }
            cobj->playAnimation(arg0);
            JS_SET_RVAL(cx, vp, JSVAL_VOID);
            return true;
        }
    } while(0);

    do {
        if (argc == 1) {
            std::string arg0;
            ok &= jsval_to_std_string(cx, argv[0], &arg0);
            if (!ok) { ok = true; break; }
            cobj->playAnimation(arg0);
            JS_SET_RVAL(cx, vp, JSVAL_VOID);
            return true;
        }
    } while(0);

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEReader_playAnimation : wrong number of arguments");
    return false;
}
bool js_cocos2dx_cocoseditor_CCEReader_getPhysicsJointRotaryLimit(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEReader* cobj = (cce::CCEReader *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEReader_getPhysicsJointRotaryLimit : Invalid Native Object");
    if (argc == 1) {
        int arg0;
        ok &= jsval_to_int32(cx, argv[0], (int32_t *)&arg0);
        JSB_PRECONDITION2(ok, cx, false, "js_cocos2dx_cocoseditor_CCEReader_getPhysicsJointRotaryLimit : Error processing arguments");
        cocos2d::PhysicsJointRotaryLimit* ret = cobj->getPhysicsJointRotaryLimit(arg0);
        jsval jsret = JSVAL_NULL;
        do {
            if (ret) {
                js_proxy_t *jsProxy = js_get_or_create_proxy<cocos2d::PhysicsJointRotaryLimit>(cx, (cocos2d::PhysicsJointRotaryLimit*)ret);
                jsret = OBJECT_TO_JSVAL(jsProxy->obj);
            } else {
                jsret = JSVAL_NULL;
            }
        } while (0);
        JS_SET_RVAL(cx, vp, jsret);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEReader_getPhysicsJointRotaryLimit : wrong number of arguments: %d, was expecting %d", argc, 1);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEReader_getPhysicsShapeEdgeChain(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEReader* cobj = (cce::CCEReader *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEReader_getPhysicsShapeEdgeChain : Invalid Native Object");
    if (argc == 1) {
        int arg0;
        ok &= jsval_to_int32(cx, argv[0], (int32_t *)&arg0);
        JSB_PRECONDITION2(ok, cx, false, "js_cocos2dx_cocoseditor_CCEReader_getPhysicsShapeEdgeChain : Error processing arguments");
        cocos2d::PhysicsShapeEdgeChain* ret = cobj->getPhysicsShapeEdgeChain(arg0);
        jsval jsret = JSVAL_NULL;
        do {
            if (ret) {
                js_proxy_t *jsProxy = js_get_or_create_proxy<cocos2d::PhysicsShapeEdgeChain>(cx, (cocos2d::PhysicsShapeEdgeChain*)ret);
                jsret = OBJECT_TO_JSVAL(jsProxy->obj);
            } else {
                jsret = JSVAL_NULL;
            }
        } while (0);
        JS_SET_RVAL(cx, vp, jsret);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEReader_getPhysicsShapeEdgeChain : wrong number of arguments: %d, was expecting %d", argc, 1);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEReader_getWidget(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;

    JSObject *obj = NULL;
    cce::CCEReader* cobj = NULL;
    obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cobj = (cce::CCEReader *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEReader_getWidget : Invalid Native Object");
    do {
        if (argc == 1) {
            std::string arg0;
            ok &= jsval_to_std_string(cx, argv[0], &arg0);
            if (!ok) { ok = true; break; }
            cocos2d::ui::Widget* ret = cobj->getWidget(arg0);
            jsval jsret = JSVAL_NULL;
            do {
            if (ret) {
                js_proxy_t *jsProxy = js_get_or_create_proxy<cocos2d::ui::Widget>(cx, (cocos2d::ui::Widget*)ret);
                jsret = OBJECT_TO_JSVAL(jsProxy->obj);
            } else {
                jsret = JSVAL_NULL;
            }
        } while (0);
            JS_SET_RVAL(cx, vp, jsret);
            return true;
        }
    } while(0);

    do {
        if (argc == 1) {
            int arg0;
            ok &= jsval_to_int32(cx, argv[0], (int32_t *)&arg0);
            if (!ok) { ok = true; break; }
            cocos2d::ui::Widget* ret = cobj->getWidget(arg0);
            jsval jsret = JSVAL_NULL;
            do {
            if (ret) {
                js_proxy_t *jsProxy = js_get_or_create_proxy<cocos2d::ui::Widget>(cx, (cocos2d::ui::Widget*)ret);
                jsret = OBJECT_TO_JSVAL(jsProxy->obj);
            } else {
                jsret = JSVAL_NULL;
            }
        } while (0);
            JS_SET_RVAL(cx, vp, jsret);
            return true;
        }
    } while(0);

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEReader_getWidget : wrong number of arguments");
    return false;
}
bool js_cocos2dx_cocoseditor_CCEReader_getPhysicsBody(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEReader* cobj = (cce::CCEReader *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEReader_getPhysicsBody : Invalid Native Object");
    if (argc == 1) {
        int arg0;
        ok &= jsval_to_int32(cx, argv[0], (int32_t *)&arg0);
        JSB_PRECONDITION2(ok, cx, false, "js_cocos2dx_cocoseditor_CCEReader_getPhysicsBody : Error processing arguments");
        cocos2d::PhysicsBody* ret = cobj->getPhysicsBody(arg0);
        jsval jsret = JSVAL_NULL;
        do {
            if (ret) {
                js_proxy_t *jsProxy = js_get_or_create_proxy<cocos2d::PhysicsBody>(cx, (cocos2d::PhysicsBody*)ret);
                jsret = OBJECT_TO_JSVAL(jsProxy->obj);
            } else {
                jsret = JSVAL_NULL;
            }
        } while (0);
        JS_SET_RVAL(cx, vp, jsret);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEReader_getPhysicsBody : wrong number of arguments: %d, was expecting %d", argc, 1);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEReader_getPhysicsShapeEdgeSegment(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEReader* cobj = (cce::CCEReader *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEReader_getPhysicsShapeEdgeSegment : Invalid Native Object");
    if (argc == 1) {
        int arg0;
        ok &= jsval_to_int32(cx, argv[0], (int32_t *)&arg0);
        JSB_PRECONDITION2(ok, cx, false, "js_cocos2dx_cocoseditor_CCEReader_getPhysicsShapeEdgeSegment : Error processing arguments");
        cocos2d::PhysicsShapeEdgeSegment* ret = cobj->getPhysicsShapeEdgeSegment(arg0);
        jsval jsret = JSVAL_NULL;
        do {
            if (ret) {
                js_proxy_t *jsProxy = js_get_or_create_proxy<cocos2d::PhysicsShapeEdgeSegment>(cx, (cocos2d::PhysicsShapeEdgeSegment*)ret);
                jsret = OBJECT_TO_JSVAL(jsProxy->obj);
            } else {
                jsret = JSVAL_NULL;
            }
        } while (0);
        JS_SET_RVAL(cx, vp, jsret);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEReader_getPhysicsShapeEdgeSegment : wrong number of arguments: %d, was expecting %d", argc, 1);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEReader_getPhysicsShape(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEReader* cobj = (cce::CCEReader *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEReader_getPhysicsShape : Invalid Native Object");
    if (argc == 1) {
        int arg0;
        ok &= jsval_to_int32(cx, argv[0], (int32_t *)&arg0);
        JSB_PRECONDITION2(ok, cx, false, "js_cocos2dx_cocoseditor_CCEReader_getPhysicsShape : Error processing arguments");
        cocos2d::PhysicsShape* ret = cobj->getPhysicsShape(arg0);
        jsval jsret = JSVAL_NULL;
        do {
            if (ret) {
                js_proxy_t *jsProxy = js_get_or_create_proxy<cocos2d::PhysicsShape>(cx, (cocos2d::PhysicsShape*)ret);
                jsret = OBJECT_TO_JSVAL(jsProxy->obj);
            } else {
                jsret = JSVAL_NULL;
            }
        } while (0);
        JS_SET_RVAL(cx, vp, jsret);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEReader_getPhysicsShape : wrong number of arguments: %d, was expecting %d", argc, 1);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEReader_getPhysicsJointGroove(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEReader* cobj = (cce::CCEReader *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEReader_getPhysicsJointGroove : Invalid Native Object");
    if (argc == 1) {
        int arg0;
        ok &= jsval_to_int32(cx, argv[0], (int32_t *)&arg0);
        JSB_PRECONDITION2(ok, cx, false, "js_cocos2dx_cocoseditor_CCEReader_getPhysicsJointGroove : Error processing arguments");
        cocos2d::PhysicsJointGroove* ret = cobj->getPhysicsJointGroove(arg0);
        jsval jsret = JSVAL_NULL;
        do {
            if (ret) {
                js_proxy_t *jsProxy = js_get_or_create_proxy<cocos2d::PhysicsJointGroove>(cx, (cocos2d::PhysicsJointGroove*)ret);
                jsret = OBJECT_TO_JSVAL(jsProxy->obj);
            } else {
                jsret = JSVAL_NULL;
            }
        } while (0);
        JS_SET_RVAL(cx, vp, jsret);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEReader_getPhysicsJointGroove : wrong number of arguments: %d, was expecting %d", argc, 1);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEReader_getPhysicsJoint(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEReader* cobj = (cce::CCEReader *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEReader_getPhysicsJoint : Invalid Native Object");
    if (argc == 1) {
        int arg0;
        ok &= jsval_to_int32(cx, argv[0], (int32_t *)&arg0);
        JSB_PRECONDITION2(ok, cx, false, "js_cocos2dx_cocoseditor_CCEReader_getPhysicsJoint : Error processing arguments");
        cocos2d::PhysicsJoint* ret = cobj->getPhysicsJoint(arg0);
        jsval jsret = JSVAL_NULL;
        do {
            if (ret) {
                js_proxy_t *jsProxy = js_get_or_create_proxy<cocos2d::PhysicsJoint>(cx, (cocos2d::PhysicsJoint*)ret);
                jsret = OBJECT_TO_JSVAL(jsProxy->obj);
            } else {
                jsret = JSVAL_NULL;
            }
        } while (0);
        JS_SET_RVAL(cx, vp, jsret);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEReader_getPhysicsJoint : wrong number of arguments: %d, was expecting %d", argc, 1);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEReader_getPhysicsShapeEdgeBox(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEReader* cobj = (cce::CCEReader *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEReader_getPhysicsShapeEdgeBox : Invalid Native Object");
    if (argc == 1) {
        int arg0;
        ok &= jsval_to_int32(cx, argv[0], (int32_t *)&arg0);
        JSB_PRECONDITION2(ok, cx, false, "js_cocos2dx_cocoseditor_CCEReader_getPhysicsShapeEdgeBox : Error processing arguments");
        cocos2d::PhysicsShapeEdgeBox* ret = cobj->getPhysicsShapeEdgeBox(arg0);
        jsval jsret = JSVAL_NULL;
        do {
            if (ret) {
                js_proxy_t *jsProxy = js_get_or_create_proxy<cocos2d::PhysicsShapeEdgeBox>(cx, (cocos2d::PhysicsShapeEdgeBox*)ret);
                jsret = OBJECT_TO_JSVAL(jsProxy->obj);
            } else {
                jsret = JSVAL_NULL;
            }
        } while (0);
        JS_SET_RVAL(cx, vp, jsret);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEReader_getPhysicsShapeEdgeBox : wrong number of arguments: %d, was expecting %d", argc, 1);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEReader_getPhysicsJointMotor(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEReader* cobj = (cce::CCEReader *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEReader_getPhysicsJointMotor : Invalid Native Object");
    if (argc == 1) {
        int arg0;
        ok &= jsval_to_int32(cx, argv[0], (int32_t *)&arg0);
        JSB_PRECONDITION2(ok, cx, false, "js_cocos2dx_cocoseditor_CCEReader_getPhysicsJointMotor : Error processing arguments");
        cocos2d::PhysicsJointMotor* ret = cobj->getPhysicsJointMotor(arg0);
        jsval jsret = JSVAL_NULL;
        do {
            if (ret) {
                js_proxy_t *jsProxy = js_get_or_create_proxy<cocos2d::PhysicsJointMotor>(cx, (cocos2d::PhysicsJointMotor*)ret);
                jsret = OBJECT_TO_JSVAL(jsProxy->obj);
            } else {
                jsret = JSVAL_NULL;
            }
        } while (0);
        JS_SET_RVAL(cx, vp, jsret);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEReader_getPhysicsJointMotor : wrong number of arguments: %d, was expecting %d", argc, 1);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEReader_getEventHandlers(JSContext *cx, uint32_t argc, jsval *vp)
{
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEReader* cobj = (cce::CCEReader *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEReader_getEventHandlers : Invalid Native Object");
    if (argc == 0) {
        cocos2d::Vector<cce::CCEEventHandler *> ret = cobj->getEventHandlers();
        jsval jsret = JSVAL_NULL;
        jsret = ccvector_to_jsval(cx, ret);
        JS_SET_RVAL(cx, vp, jsret);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEReader_getEventHandlers : wrong number of arguments: %d, was expecting %d", argc, 0);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEReader_getComponentNames(JSContext *cx, uint32_t argc, jsval *vp)
{
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEReader* cobj = (cce::CCEReader *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEReader_getComponentNames : Invalid Native Object");
    if (argc == 0) {
        std::vector<std::string> ret = cobj->getComponentNames();
        jsval jsret = JSVAL_NULL;
        jsret = std_vector_string_to_jsval(cx, ret);
        JS_SET_RVAL(cx, vp, jsret);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEReader_getComponentNames : wrong number of arguments: %d, was expecting %d", argc, 0);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEReader_getPhysicsShapeBox(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEReader* cobj = (cce::CCEReader *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEReader_getPhysicsShapeBox : Invalid Native Object");
    if (argc == 1) {
        int arg0;
        ok &= jsval_to_int32(cx, argv[0], (int32_t *)&arg0);
        JSB_PRECONDITION2(ok, cx, false, "js_cocos2dx_cocoseditor_CCEReader_getPhysicsShapeBox : Error processing arguments");
        cocos2d::PhysicsShapeBox* ret = cobj->getPhysicsShapeBox(arg0);
        jsval jsret = JSVAL_NULL;
        do {
            if (ret) {
                js_proxy_t *jsProxy = js_get_or_create_proxy<cocos2d::PhysicsShapeBox>(cx, (cocos2d::PhysicsShapeBox*)ret);
                jsret = OBJECT_TO_JSVAL(jsProxy->obj);
            } else {
                jsret = JSVAL_NULL;
            }
        } while (0);
        JS_SET_RVAL(cx, vp, jsret);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEReader_getPhysicsShapeBox : wrong number of arguments: %d, was expecting %d", argc, 1);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEReader_getScene(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;

    JSObject *obj = NULL;
    cce::CCEReader* cobj = NULL;
    obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cobj = (cce::CCEReader *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEReader_getScene : Invalid Native Object");
    do {
        if (argc == 1) {
            std::string arg0;
            ok &= jsval_to_std_string(cx, argv[0], &arg0);
            if (!ok) { ok = true; break; }
            cocos2d::Scene* ret = cobj->getScene(arg0);
            jsval jsret = JSVAL_NULL;
            do {
            if (ret) {
                js_proxy_t *jsProxy = js_get_or_create_proxy<cocos2d::Scene>(cx, (cocos2d::Scene*)ret);
                jsret = OBJECT_TO_JSVAL(jsProxy->obj);
            } else {
                jsret = JSVAL_NULL;
            }
        } while (0);
            JS_SET_RVAL(cx, vp, jsret);
            return true;
        }
    } while(0);

    do {
        if (argc == 1) {
            int arg0;
            ok &= jsval_to_int32(cx, argv[0], (int32_t *)&arg0);
            if (!ok) { ok = true; break; }
            cocos2d::Scene* ret = cobj->getScene(arg0);
            jsval jsret = JSVAL_NULL;
            do {
            if (ret) {
                js_proxy_t *jsProxy = js_get_or_create_proxy<cocos2d::Scene>(cx, (cocos2d::Scene*)ret);
                jsret = OBJECT_TO_JSVAL(jsProxy->obj);
            } else {
                jsret = JSVAL_NULL;
            }
        } while (0);
            JS_SET_RVAL(cx, vp, jsret);
            return true;
        }
    } while(0);

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEReader_getScene : wrong number of arguments");
    return false;
}
bool js_cocos2dx_cocoseditor_CCEReader_getCCEReaderSize(JSContext *cx, uint32_t argc, jsval *vp)
{
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEReader* cobj = (cce::CCEReader *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEReader_getCCEReaderSize : Invalid Native Object");
    if (argc == 0) {
        int ret = cobj->getCCEReaderSize();
        jsval jsret = JSVAL_NULL;
        jsret = int32_to_jsval(cx, ret);
        JS_SET_RVAL(cx, vp, jsret);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEReader_getCCEReaderSize : wrong number of arguments: %d, was expecting %d", argc, 0);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEReader_getPhysicsJointRatchet(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEReader* cobj = (cce::CCEReader *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEReader_getPhysicsJointRatchet : Invalid Native Object");
    if (argc == 1) {
        int arg0;
        ok &= jsval_to_int32(cx, argv[0], (int32_t *)&arg0);
        JSB_PRECONDITION2(ok, cx, false, "js_cocos2dx_cocoseditor_CCEReader_getPhysicsJointRatchet : Error processing arguments");
        cocos2d::PhysicsJointRatchet* ret = cobj->getPhysicsJointRatchet(arg0);
        jsval jsret = JSVAL_NULL;
        do {
            if (ret) {
                js_proxy_t *jsProxy = js_get_or_create_proxy<cocos2d::PhysicsJointRatchet>(cx, (cocos2d::PhysicsJointRatchet*)ret);
                jsret = OBJECT_TO_JSVAL(jsProxy->obj);
            } else {
                jsret = JSVAL_NULL;
            }
        } while (0);
        JS_SET_RVAL(cx, vp, jsret);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEReader_getPhysicsJointRatchet : wrong number of arguments: %d, was expecting %d", argc, 1);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEReader_getPhysicsJointPin(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEReader* cobj = (cce::CCEReader *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEReader_getPhysicsJointPin : Invalid Native Object");
    if (argc == 1) {
        int arg0;
        ok &= jsval_to_int32(cx, argv[0], (int32_t *)&arg0);
        JSB_PRECONDITION2(ok, cx, false, "js_cocos2dx_cocoseditor_CCEReader_getPhysicsJointPin : Error processing arguments");
        cocos2d::PhysicsJointPin* ret = cobj->getPhysicsJointPin(arg0);
        jsval jsret = JSVAL_NULL;
        do {
            if (ret) {
                js_proxy_t *jsProxy = js_get_or_create_proxy<cocos2d::PhysicsJointPin>(cx, (cocos2d::PhysicsJointPin*)ret);
                jsret = OBJECT_TO_JSVAL(jsProxy->obj);
            } else {
                jsret = JSVAL_NULL;
            }
        } while (0);
        JS_SET_RVAL(cx, vp, jsret);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEReader_getPhysicsJointPin : wrong number of arguments: %d, was expecting %d", argc, 1);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEReader_getNode(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;

    JSObject *obj = NULL;
    cce::CCEReader* cobj = NULL;
    obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cobj = (cce::CCEReader *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEReader_getNode : Invalid Native Object");
    do {
        if (argc == 1) {
            std::string arg0;
            ok &= jsval_to_std_string(cx, argv[0], &arg0);
            if (!ok) { ok = true; break; }
            cocos2d::Node* ret = cobj->getNode(arg0);
            jsval jsret = JSVAL_NULL;
            do {
            if (ret) {
                js_proxy_t *jsProxy = js_get_or_create_proxy<cocos2d::Node>(cx, (cocos2d::Node*)ret);
                jsret = OBJECT_TO_JSVAL(jsProxy->obj);
            } else {
                jsret = JSVAL_NULL;
            }
        } while (0);
            JS_SET_RVAL(cx, vp, jsret);
            return true;
        }
    } while(0);

    do {
        if (argc == 1) {
            int arg0;
            ok &= jsval_to_int32(cx, argv[0], (int32_t *)&arg0);
            if (!ok) { ok = true; break; }
            cocos2d::Node* ret = cobj->getNode(arg0);
            jsval jsret = JSVAL_NULL;
            do {
            if (ret) {
                js_proxy_t *jsProxy = js_get_or_create_proxy<cocos2d::Node>(cx, (cocos2d::Node*)ret);
                jsret = OBJECT_TO_JSVAL(jsProxy->obj);
            } else {
                jsret = JSVAL_NULL;
            }
        } while (0);
            JS_SET_RVAL(cx, vp, jsret);
            return true;
        }
    } while(0);

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEReader_getNode : wrong number of arguments");
    return false;
}
bool js_cocos2dx_cocoseditor_CCEReader_getPhysicsJointSpring(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::CCEReader* cobj = (cce::CCEReader *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_CCEReader_getPhysicsJointSpring : Invalid Native Object");
    if (argc == 1) {
        int arg0;
        ok &= jsval_to_int32(cx, argv[0], (int32_t *)&arg0);
        JSB_PRECONDITION2(ok, cx, false, "js_cocos2dx_cocoseditor_CCEReader_getPhysicsJointSpring : Error processing arguments");
        cocos2d::PhysicsJointSpring* ret = cobj->getPhysicsJointSpring(arg0);
        jsval jsret = JSVAL_NULL;
        do {
            if (ret) {
                js_proxy_t *jsProxy = js_get_or_create_proxy<cocos2d::PhysicsJointSpring>(cx, (cocos2d::PhysicsJointSpring*)ret);
                jsret = OBJECT_TO_JSVAL(jsProxy->obj);
            } else {
                jsret = JSVAL_NULL;
            }
        } while (0);
        JS_SET_RVAL(cx, vp, jsret);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEReader_getPhysicsJointSpring : wrong number of arguments: %d, was expecting %d", argc, 1);
    return false;
}
bool js_cocos2dx_cocoseditor_CCEReader_create(JSContext *cx, uint32_t argc, jsval *vp)
{
    if (argc == 0) {
        cce::CCEReader* ret = cce::CCEReader::create();
        jsval jsret = JSVAL_NULL;
        do {
        if (ret) {
            js_proxy_t *jsProxy = js_get_or_create_proxy<cce::CCEReader>(cx, (cce::CCEReader*)ret);
            jsret = OBJECT_TO_JSVAL(jsProxy->obj);
        } else {
            jsret = JSVAL_NULL;
        }
    } while (0);
        JS_SET_RVAL(cx, vp, jsret);
        return true;
    }
    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEReader_create : wrong number of arguments");
    return false;
}

bool js_cocos2dx_cocoseditor_CCEReader_getSpritePixelsColor(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;
    if (argc == 3) {
        cocos2d::Sprite* arg0;
        int arg1;
        int arg2;
        do {
            if (!argv[0].isObject()) { ok = false; break; }
            js_proxy_t *jsProxy;
            JSObject *tmpObj = JSVAL_TO_OBJECT(argv[0]);
            jsProxy = jsb_get_js_proxy(tmpObj);
            arg0 = (cocos2d::Sprite*)(jsProxy ? jsProxy->ptr : NULL);
            JSB_PRECONDITION2( arg0, cx, false, "Invalid Native Object");
        } while (0);
        ok &= jsval_to_int32(cx, argv[1], (int32_t *)&arg1);
        ok &= jsval_to_int32(cx, argv[2], (int32_t *)&arg2);
        JSB_PRECONDITION2(ok, cx, false, "js_cocos2dx_cocoseditor_CCEReader_getSpritePixelsColor : Error processing arguments");
        cocos2d::Color4B ret = cce::CCEReader::getSpritePixelsColor(arg0, arg1, arg2);
        jsval jsret = JSVAL_NULL;
        jsret = cccolor4b_to_jsval(cx, ret);
        JS_SET_RVAL(cx, vp, jsret);
        return true;
    }
    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEReader_getSpritePixelsColor : wrong number of arguments");
    return false;
}

bool js_cocos2dx_cocoseditor_CCEReader_getPixelsColor(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;
    if (argc == 2) {
        int arg0;
        int arg1;
        ok &= jsval_to_int32(cx, argv[0], (int32_t *)&arg0);
        ok &= jsval_to_int32(cx, argv[1], (int32_t *)&arg1);
        JSB_PRECONDITION2(ok, cx, false, "js_cocos2dx_cocoseditor_CCEReader_getPixelsColor : Error processing arguments");
        cocos2d::Color4B ret = cce::CCEReader::getPixelsColor(arg0, arg1);
        jsval jsret = JSVAL_NULL;
        jsret = cccolor4b_to_jsval(cx, ret);
        JS_SET_RVAL(cx, vp, jsret);
        return true;
    }
    JS_ReportError(cx, "js_cocos2dx_cocoseditor_CCEReader_getPixelsColor : wrong number of arguments");
    return false;
}

bool js_cocos2dx_cocoseditor_CCEReader_constructor(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;
    cce::CCEReader* cobj = new (std::nothrow) cce::CCEReader();
    cocos2d::Ref *_ccobj = dynamic_cast<cocos2d::Ref *>(cobj);
    if (_ccobj) {
        _ccobj->autorelease();
    }
    TypeTest<cce::CCEReader> t;
    js_type_class_t *typeClass = nullptr;
    std::string typeName = t.s_name();
    auto typeMapIter = _js_global_type_map.find(typeName);
    CCASSERT(typeMapIter != _js_global_type_map.end(), "Can't find the class type!");
    typeClass = typeMapIter->second;
    CCASSERT(typeClass, "The value is null.");
    JSObject *obj = JS_NewObject(cx, typeClass->jsclass, typeClass->proto, typeClass->parentProto);
    JS_SET_RVAL(cx, vp, OBJECT_TO_JSVAL(obj));
    // link the native object with the javascript object
    js_proxy_t* p = jsb_new_proxy(cobj, obj);
    JS_AddNamedObjectRoot(cx, &p->obj, "cce::CCEReader");
    if (JS_HasProperty(cx, obj, "_ctor", &ok) && ok)
        ScriptingCore::getInstance()->executeFunctionWithOwner(OBJECT_TO_JSVAL(obj), "_ctor", argc, argv);
    return true;
}



void js_cce_CCEReader_finalize(JSFreeOp *fop, JSObject *obj) {
    CCLOGINFO("jsbindings: finalizing JS object %p (CCEReader)", obj);
}

void js_register_cocos2dx_cocoseditor_CCEReader(JSContext *cx, JSObject *global) {
    jsb_cce_CCEReader_class = (JSClass *)calloc(1, sizeof(JSClass));
    jsb_cce_CCEReader_class->name = "CCEReader";
    jsb_cce_CCEReader_class->addProperty = JS_PropertyStub;
    jsb_cce_CCEReader_class->delProperty = JS_DeletePropertyStub;
    jsb_cce_CCEReader_class->getProperty = JS_PropertyStub;
    jsb_cce_CCEReader_class->setProperty = JS_StrictPropertyStub;
    jsb_cce_CCEReader_class->enumerate = JS_EnumerateStub;
    jsb_cce_CCEReader_class->resolve = JS_ResolveStub;
    jsb_cce_CCEReader_class->convert = JS_ConvertStub;
    jsb_cce_CCEReader_class->finalize = js_cce_CCEReader_finalize;
    jsb_cce_CCEReader_class->flags = JSCLASS_HAS_RESERVED_SLOTS(2);

    static JSPropertySpec properties[] = {
        {"__nativeObj", 0, JSPROP_ENUMERATE | JSPROP_PERMANENT, JSOP_WRAPPER(js_is_native_obj), JSOP_NULLWRAPPER},
        {0, 0, 0, JSOP_NULLWRAPPER, JSOP_NULLWRAPPER}
    };

    static JSFunctionSpec funcs[] = {
        JS_FN("getLabel", js_cocos2dx_cocoseditor_CCEReader_getLabel, 1, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("getAnimationManager", js_cocos2dx_cocoseditor_CCEReader_getAnimationManager, 0, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("getPhysicsJointGear", js_cocos2dx_cocoseditor_CCEReader_getPhysicsJointGear, 1, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("getCCEReaderByIndex", js_cocos2dx_cocoseditor_CCEReader_getCCEReaderByIndex, 1, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("getPhysicsShapeCircle", js_cocos2dx_cocoseditor_CCEReader_getPhysicsShapeCircle, 1, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("stopAllAnimation", js_cocos2dx_cocoseditor_CCEReader_stopAllAnimation, 0, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("playAutoAnimations", js_cocos2dx_cocoseditor_CCEReader_playAutoAnimations, 0, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("getPhysicsJointFixed", js_cocos2dx_cocoseditor_CCEReader_getPhysicsJointFixed, 1, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("getCCEReader", js_cocos2dx_cocoseditor_CCEReader_getCCEReader, 1, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("getMenuItem", js_cocos2dx_cocoseditor_CCEReader_getMenuItem, 1, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("getRef", js_cocos2dx_cocoseditor_CCEReader_getRef, 1, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("getPhysicsJointRotarySpring", js_cocos2dx_cocoseditor_CCEReader_getPhysicsJointRotarySpring, 1, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("getMenu", js_cocos2dx_cocoseditor_CCEReader_getMenu, 1, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("getPhysicsShapeEdgePolygon", js_cocos2dx_cocoseditor_CCEReader_getPhysicsShapeEdgePolygon, 1, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("getSprite", js_cocos2dx_cocoseditor_CCEReader_getSprite, 1, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("getPhysicsJointDistance", js_cocos2dx_cocoseditor_CCEReader_getPhysicsJointDistance, 1, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("getComponentNodes", js_cocos2dx_cocoseditor_CCEReader_getComponentNodes, 1, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("getLayer", js_cocos2dx_cocoseditor_CCEReader_getLayer, 1, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("stopAnimation", js_cocos2dx_cocoseditor_CCEReader_stopAnimation, 1, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("getPhysicsJointLimit", js_cocos2dx_cocoseditor_CCEReader_getPhysicsJointLimit, 1, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("read", js_cocos2dx_cocoseditor_CCEReader_read, 0, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("getAnimation", js_cocos2dx_cocoseditor_CCEReader_getAnimation, 1, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("getPhysicsShapePolygon", js_cocos2dx_cocoseditor_CCEReader_getPhysicsShapePolygon, 1, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("playAnimation", js_cocos2dx_cocoseditor_CCEReader_playAnimation, 1, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("getPhysicsJointRotaryLimit", js_cocos2dx_cocoseditor_CCEReader_getPhysicsJointRotaryLimit, 1, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("getPhysicsShapeEdgeChain", js_cocos2dx_cocoseditor_CCEReader_getPhysicsShapeEdgeChain, 1, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("getWidget", js_cocos2dx_cocoseditor_CCEReader_getWidget, 1, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("getPhysicsBody", js_cocos2dx_cocoseditor_CCEReader_getPhysicsBody, 1, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("getPhysicsShapeEdgeSegment", js_cocos2dx_cocoseditor_CCEReader_getPhysicsShapeEdgeSegment, 1, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("getPhysicsShape", js_cocos2dx_cocoseditor_CCEReader_getPhysicsShape, 1, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("getPhysicsJointGroove", js_cocos2dx_cocoseditor_CCEReader_getPhysicsJointGroove, 1, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("getPhysicsJoint", js_cocos2dx_cocoseditor_CCEReader_getPhysicsJoint, 1, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("getPhysicsShapeEdgeBox", js_cocos2dx_cocoseditor_CCEReader_getPhysicsShapeEdgeBox, 1, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("getPhysicsJointMotor", js_cocos2dx_cocoseditor_CCEReader_getPhysicsJointMotor, 1, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("getEventHandlers", js_cocos2dx_cocoseditor_CCEReader_getEventHandlers, 0, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("getComponentNames", js_cocos2dx_cocoseditor_CCEReader_getComponentNames, 0, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("getPhysicsShapeBox", js_cocos2dx_cocoseditor_CCEReader_getPhysicsShapeBox, 1, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("getScene", js_cocos2dx_cocoseditor_CCEReader_getScene, 1, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("getCCEReaderSize", js_cocos2dx_cocoseditor_CCEReader_getCCEReaderSize, 0, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("getPhysicsJointRatchet", js_cocos2dx_cocoseditor_CCEReader_getPhysicsJointRatchet, 1, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("getPhysicsJointPin", js_cocos2dx_cocoseditor_CCEReader_getPhysicsJointPin, 1, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("getNode", js_cocos2dx_cocoseditor_CCEReader_getNode, 1, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("getPhysicsJointSpring", js_cocos2dx_cocoseditor_CCEReader_getPhysicsJointSpring, 1, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FS_END
    };

    static JSFunctionSpec st_funcs[] = {
        JS_FN("create", js_cocos2dx_cocoseditor_CCEReader_create, 0, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("getSpritePixelsColor", js_cocos2dx_cocoseditor_CCEReader_getSpritePixelsColor, 3, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("getPixelsColor", js_cocos2dx_cocoseditor_CCEReader_getPixelsColor, 2, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FS_END
    };

    jsb_cce_CCEReader_prototype = JS_InitClass(
        cx, global,
        NULL, // parent proto
        jsb_cce_CCEReader_class,
        js_cocos2dx_cocoseditor_CCEReader_constructor, 0, // constructor
        properties,
        funcs,
        NULL, // no static properties
        st_funcs);
    // make the class enumerable in the registered namespace
//  bool found;
//FIXME: Removed in Firefox v27 
//  JS_SetPropertyAttributes(cx, global, "CCEReader", JSPROP_ENUMERATE | JSPROP_READONLY, &found);

    // add the proto and JSClass to the type->js info hash table
    TypeTest<cce::CCEReader> t;
    js_type_class_t *p;
    std::string typeName = t.s_name();
    if (_js_global_type_map.find(typeName) == _js_global_type_map.end())
    {
        p = (js_type_class_t *)malloc(sizeof(js_type_class_t));
        p->jsclass = jsb_cce_CCEReader_class;
        p->proto = jsb_cce_CCEReader_prototype;
        p->parentProto = NULL;
        _js_global_type_map.insert(std::make_pair(typeName, p));
    }
}

JSClass  *jsb_cce_FunctionFactory_class;
JSObject *jsb_cce_FunctionFactory_prototype;

bool js_cocos2dx_cocoseditor_FunctionFactory_registerCallbackFunction(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::FunctionFactory* cobj = (cce::FunctionFactory *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_FunctionFactory_registerCallbackFunction : Invalid Native Object");
    if (argc == 2) {
        std::string arg0;
        std::function<std::basic_string<char> (std::basic_string<char>, std::basic_string<char>)> arg1;
        ok &= jsval_to_std_string(cx, argv[0], &arg0);
        do {
		    std::shared_ptr<JSFunctionWrapper> func(new JSFunctionWrapper(cx, JS_THIS_OBJECT(cx, vp), argv[1]));
		    auto lambda = [=](std::basic_string<char> larg0, std::basic_string<char> larg1) -> basic_string<char> {
		        jsval largv[2];
		        largv[0] = std_string_to_jsval(cx, larg0);
		        largv[1] = std_string_to_jsval(cx, larg1);
		        jsval rval;
		        bool ok = func->invoke(2, &largv[0], rval);
		        if (!ok && JS_IsExceptionPending(cx)) {
		            JS_ReportPendingException(cx);
		        }
		        std::basic_string<char> ret;
		        do {
		            if (!rval.isObject()) { ok = false; break; }
		            js_proxy_t *jsProxy;
		            JSObject *tmpObj = JSVAL_TO_OBJECT(rval);
		            jsProxy = jsb_get_js_proxy(tmpObj);
		            //ret = (std::basic_string<char>)(jsProxy ? jsProxy->ptr : NULL);
		            //JSB_PRECONDITION2( ret, cx, false, "Invalid Native Object");
		        } while (0);
		        return ret;
		    };
		    arg1 = lambda;
		} while(0)
		;
        JSB_PRECONDITION2(ok, cx, false, "js_cocos2dx_cocoseditor_FunctionFactory_registerCallbackFunction : Error processing arguments");
        cobj->registerCallbackFunction(arg0, arg1);
        JS_SET_RVAL(cx, vp, JSVAL_VOID);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_FunctionFactory_registerCallbackFunction : wrong number of arguments: %d, was expecting %d", argc, 2);
    return false;
}
bool js_cocos2dx_cocoseditor_FunctionFactory_callFunction(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::FunctionFactory* cobj = (cce::FunctionFactory *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_FunctionFactory_callFunction : Invalid Native Object");
    if (argc == 2) {
        std::string arg0;
        std::string arg1;
        ok &= jsval_to_std_string(cx, argv[0], &arg0);
        ok &= jsval_to_std_string(cx, argv[1], &arg1);
        JSB_PRECONDITION2(ok, cx, false, "js_cocos2dx_cocoseditor_FunctionFactory_callFunction : Error processing arguments");
        std::string ret = cobj->callFunction(arg0, arg1);
        jsval jsret = JSVAL_NULL;
        jsret = std_string_to_jsval(cx, ret);
        JS_SET_RVAL(cx, vp, jsret);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_FunctionFactory_callFunction : wrong number of arguments: %d, was expecting %d", argc, 2);
    return false;
}
bool js_cocos2dx_cocoseditor_FunctionFactory_registerFunction(JSContext *cx, uint32_t argc, jsval *vp)
{
    jsval *argv = JS_ARGV(cx, vp);
    bool ok = true;
    JSObject *obj = JS_THIS_OBJECT(cx, vp);
    js_proxy_t *proxy = jsb_get_js_proxy(obj);
    cce::FunctionFactory* cobj = (cce::FunctionFactory *)(proxy ? proxy->ptr : NULL);
    JSB_PRECONDITION2( cobj, cx, false, "js_cocos2dx_cocoseditor_FunctionFactory_registerFunction : Invalid Native Object");
    if (argc == 2) {
        std::string arg0;
        cce::Function* arg1;
        ok &= jsval_to_std_string(cx, argv[0], &arg0);
        do {
            if (!argv[1].isObject()) { ok = false; break; }
            js_proxy_t *jsProxy;
            JSObject *tmpObj = JSVAL_TO_OBJECT(argv[1]);
            jsProxy = jsb_get_js_proxy(tmpObj);
            arg1 = (cce::Function*)(jsProxy ? jsProxy->ptr : NULL);
            JSB_PRECONDITION2( arg1, cx, false, "Invalid Native Object");
        } while (0);
        JSB_PRECONDITION2(ok, cx, false, "js_cocos2dx_cocoseditor_FunctionFactory_registerFunction : Error processing arguments");
        cobj->registerFunction(arg0, arg1);
        JS_SET_RVAL(cx, vp, JSVAL_VOID);
        return true;
    }

    JS_ReportError(cx, "js_cocos2dx_cocoseditor_FunctionFactory_registerFunction : wrong number of arguments: %d, was expecting %d", argc, 2);
    return false;
}
bool js_cocos2dx_cocoseditor_FunctionFactory_getInstance(JSContext *cx, uint32_t argc, jsval *vp)
{
    if (argc == 0) {
        cce::FunctionFactory* ret = cce::FunctionFactory::getInstance();
        jsval jsret = JSVAL_NULL;
        do {
        if (ret) {
            js_proxy_t *jsProxy = js_get_or_create_proxy<cce::FunctionFactory>(cx, (cce::FunctionFactory*)ret);
            jsret = OBJECT_TO_JSVAL(jsProxy->obj);
        } else {
            jsret = JSVAL_NULL;
        }
    } while (0);
        JS_SET_RVAL(cx, vp, jsret);
        return true;
    }
    JS_ReportError(cx, "js_cocos2dx_cocoseditor_FunctionFactory_getInstance : wrong number of arguments");
    return false;
}



void js_cce_FunctionFactory_finalize(JSFreeOp *fop, JSObject *obj) {
    CCLOGINFO("jsbindings: finalizing JS object %p (FunctionFactory)", obj);
}

void js_register_cocos2dx_cocoseditor_FunctionFactory(JSContext *cx, JSObject *global) {
    jsb_cce_FunctionFactory_class = (JSClass *)calloc(1, sizeof(JSClass));
    jsb_cce_FunctionFactory_class->name = "FunctionFactory";
    jsb_cce_FunctionFactory_class->addProperty = JS_PropertyStub;
    jsb_cce_FunctionFactory_class->delProperty = JS_DeletePropertyStub;
    jsb_cce_FunctionFactory_class->getProperty = JS_PropertyStub;
    jsb_cce_FunctionFactory_class->setProperty = JS_StrictPropertyStub;
    jsb_cce_FunctionFactory_class->enumerate = JS_EnumerateStub;
    jsb_cce_FunctionFactory_class->resolve = JS_ResolveStub;
    jsb_cce_FunctionFactory_class->convert = JS_ConvertStub;
    jsb_cce_FunctionFactory_class->finalize = js_cce_FunctionFactory_finalize;
    jsb_cce_FunctionFactory_class->flags = JSCLASS_HAS_RESERVED_SLOTS(2);

    static JSPropertySpec properties[] = {
        {"__nativeObj", 0, JSPROP_ENUMERATE | JSPROP_PERMANENT, JSOP_WRAPPER(js_is_native_obj), JSOP_NULLWRAPPER},
        {0, 0, 0, JSOP_NULLWRAPPER, JSOP_NULLWRAPPER}
    };

    static JSFunctionSpec funcs[] = {
        JS_FN("registerCallbackFunction", js_cocos2dx_cocoseditor_FunctionFactory_registerCallbackFunction, 2, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("callFunction", js_cocos2dx_cocoseditor_FunctionFactory_callFunction, 2, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FN("registerFunction", js_cocos2dx_cocoseditor_FunctionFactory_registerFunction, 2, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FS_END
    };

    static JSFunctionSpec st_funcs[] = {
        JS_FN("getInstance", js_cocos2dx_cocoseditor_FunctionFactory_getInstance, 0, JSPROP_PERMANENT | JSPROP_ENUMERATE),
        JS_FS_END
    };

    jsb_cce_FunctionFactory_prototype = JS_InitClass(
        cx, global,
        NULL, // parent proto
        jsb_cce_FunctionFactory_class,
        dummy_constructor<cce::FunctionFactory>, 0, // no constructor
        properties,
        funcs,
        NULL, // no static properties
        st_funcs);
    // make the class enumerable in the registered namespace
//  bool found;
//FIXME: Removed in Firefox v27 
//  JS_SetPropertyAttributes(cx, global, "FunctionFactory", JSPROP_ENUMERATE | JSPROP_READONLY, &found);

    // add the proto and JSClass to the type->js info hash table
    TypeTest<cce::FunctionFactory> t;
    js_type_class_t *p;
    std::string typeName = t.s_name();
    if (_js_global_type_map.find(typeName) == _js_global_type_map.end())
    {
        p = (js_type_class_t *)malloc(sizeof(js_type_class_t));
        p->jsclass = jsb_cce_FunctionFactory_class;
        p->proto = jsb_cce_FunctionFactory_prototype;
        p->parentProto = NULL;
        _js_global_type_map.insert(std::make_pair(typeName, p));
    }
}

void register_all_cocos2dx_cocoseditor(JSContext* cx, JSObject* obj) {
    // first, try to get the ns
    JS::RootedValue nsval(cx);
    JS::RootedObject ns(cx);
    JS_GetProperty(cx, obj, "cce", &nsval);
    if (nsval == JSVAL_VOID) {
        ns = JS_NewObject(cx, NULL, NULL, NULL);
        nsval = OBJECT_TO_JSVAL(ns);
        JS_SetProperty(cx, obj, "cce", nsval);
    } else {
        JS_ValueToObject(cx, nsval, &ns);
    }
    obj = ns;

    js_register_cocos2dx_cocoseditor_FunctionFactory(cx, obj);
    js_register_cocos2dx_cocoseditor_CCEAnimation(cx, obj);
    js_register_cocos2dx_cocoseditor_CCEEventHandler(cx, obj);
    js_register_cocos2dx_cocoseditor_CCEChannel(cx, obj);
    js_register_cocos2dx_cocoseditor_CCEReader(cx, obj);
    js_register_cocos2dx_cocoseditor_CCEAnimationManager(cx, obj);
}

