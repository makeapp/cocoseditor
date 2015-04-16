/****************************************************************************
 Copyright (c) 2012      cocos2d-x.org
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

#ifndef __CC_JAVA_ENGINE_H__
#define __CC_JAVA_ENGINE_H__

#include "cocos2d.h"
#include "Function.h"
#include "CCScriptSupport.h"
#include "jni.h"

typedef std::string (*METHOD_CALL)(std::string);
#define PTR_TO_JLONG(a) ((jlong)(uintptr_t)(a))

using namespace cocos2d;

namespace ccj{

typedef bool (*SEL_TouchEventBegin)(Touch*, Event*);



class JavaEngine : public ScriptEngineProtocol
{
public:
    static JavaEngine* getInstance(void);

    virtual ~JavaEngine(void);
    
    virtual ccScriptType getScriptType() {
        return kScriptTypeLua;
    };

    void initJVMEnv(JNIEnv* env);

    JNIEnv* getJVMEnv();

    void setJavaVM(JavaVM *javaVM){this->javaVM=javaVM;}

    JavaVM * getJavaVM(){
      return javaVM;
    }
    /**
     @brief Add a path to find lua files in
     @param path to be added to the Lua path
     */
    virtual void addSearchPath(const char* path);


    /**
     @brief Remove Object from lua state
     @param object to remove
     */
    virtual void removeScriptObjectByObject(Ref* object);

    /**
     @brief Remove Lua function reference
     */
    virtual void removeScriptHandler(int nHandler);
    
    /**
     @brief Reallocate Lua function reference
     */
    virtual int reallocateScriptHandler(int nHandler);
    
    /**
     @brief Execute script code contained in the given string.
     @param codes holding the valid script code that should be executed.
     @return 0 if the string is excuted correctly.
     @return other if the string is excuted wrongly.
     */
    virtual int executeString(const char* codes);
    
    /**
     @brief Execute a script file.
     @param filename String object holding the filename of the script file that is to be executed
     */
    virtual int executeScriptFile(const char* filename);
    
    /**
     @brief Execute a scripted global function.
     @brief The function should not take any parameters and should return an integer.
     @param functionName String object holding the name of the function, in the global script environment, that is to be executed.
     @return The integer value returned from the script function.
     */
    virtual int executeGlobalFunction(const char* functionName);

//    virtual int executeNodeEvent(Node* pNode, int nAction);
//    virtual int executeMenuItemEvent(MenuItem* pMenuItem);
//    virtual int executeNotificationEvent(NotificationCenter* pNotificationCenter, const char* pszName);
//    virtual int executeCallFuncActionEvent(CallFunc* pAction, Object* pTarget = NULL);
//    virtual int executeSchedule(int nHandler, float dt, Node* pNode = NULL);
//    virtual int executeLayerTouchesEvent(Layer* pLayer, int eventType, Set *pTouches);
//    virtual int executeLayerTouchEvent(Layer* pLayer, int eventType, Touch *pTouch);
//    virtual int executeLayerKeypadEvent(Layer* pLayer, int eventType);
//    /** execute a accelerometer event */
//    virtual int executeAccelerometerEvent(Layer* pLayer, Acceleration* pAccelerationValue);
//    virtual int executeEvent(int nHandler, const char* pEventName, Object* pEventSource = NULL, const char* pEventSourceClassName = NULL);

    virtual bool handleAssert(const char *msg);
    
    virtual bool parseConfig(ConfigType type, const std::string& str) override;
    virtual int sendEvent(ScriptEvent* message) override;

    std::string invoke(std::string methodName,std::string args);
    std::string execute(std::string methodName,std::string args);

    std::string jstring2string(jstring jstr);
    jstring string2jstring(std::string str);
    jstring chars2jstring(const char* pat);

private:

    int handleNodeEvent(void* data);
    int handlerComponentEvent(void* data);
    int handleMenuClickedEvent(void* data);
    int handleCallFuncActionEvent(void* data);
    int handleScheduler(void* data);
    int handleKeypadEvent(void* data);
	int handleKeypadPressEvent(void* data);
	int handleKeypadReleaseEvent(void* data);
    int handleAccelerometerEvent(void* data);
    int handleCommonEvent(void* data);
    int handleTouchEvent(void* data);
    int handleTouchesEvent(void* data);
    int handlerControlEvent(void* data);
    int handleEvenCustom(void* data);
    int handleEventAcc(void* data);
private:
    JavaVM *javaVM;
    JNIEnv* env;
    jobject javaObject;
    jclass  javaClass;
    jmethodID handleMenuClickedEventMethod;
    jmethodID handleReleaseObjectMethod;
    jmethodID handleReleaseHandlerMethod;
    jmethodID handleNodeEventMethod;
    jmethodID handleComponentEventMethod;
    jmethodID handleCallFuncActionEventMethod;
    jmethodID handleSchedulerMethod;
    jmethodID handleKeypadEventMethod;
	jmethodID handleKeypadPressEventMethod;
	jmethodID handleKeypadReleaseEventMethod;
    jmethodID handleAccelerometerEventMethod;
    jmethodID handleCommonEventMethod;
    jmethodID handleTouchEventMethod;
    jmethodID handleTouchesEventMethod;
    jmethodID handleControlEventMethod;
    jmethodID handleEvenCustomMethod;
    jmethodID handleEventAccMethod;
    jmethodID executeStringMethod;
    jmethodID executeMethod;

    static JavaEngine* _defaultEngine;
};

}

#endif // __CC_JAVA_ENGINE_H__
