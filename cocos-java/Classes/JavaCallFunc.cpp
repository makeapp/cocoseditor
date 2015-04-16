#include "JavaCallFunc.h"
#include "CCScriptSupport.h"

using namespace ccj;

JavaCallFunc * JavaCallFunc::create(){
      JavaCallFunc *callFun = new JavaCallFunc();
      return callFun;
}

 CallFunc* JavaCallFunc::clone()const{return NULL;};

void JavaCallFunc::execute(){
    BasicScriptData data(this,NULL);
    ScriptEvent event(kCallFuncEvent,&data);
    ScriptEngineManager::getInstance()->getScriptEngine()->sendEvent(&event);
}