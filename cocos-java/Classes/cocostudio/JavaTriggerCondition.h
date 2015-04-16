
#ifndef  _APP_JAVATRIGGERCONDITION_H_
#define  _APP_JAVATRIGGERCONDITION_H_

#include "cocos2d.h"
#include "cocostudio/TriggerBase.h"
 #include "JavaEngine.h"

class JavaTriggerCondition : public cocostudio::BaseTriggerCondition
{
    //DECLARE_CLASS_INFO
public:
     JavaTriggerCondition(void);
     virtual ~JavaTriggerCondition(void);
    static void registerType(const std::string& type);
    virtual bool init();
    virtual bool detect();
    virtual void serialize(const rapidjson::Value &val);
    virtual void removeAll();
};
#endif
