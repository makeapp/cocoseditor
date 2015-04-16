
#ifndef  _APP_JAVATRIGGERACTION_H_
#define  _APP_JAVATRIGGERACTION_H_

#include "cocos2d.h"
#include "cocostudio/TriggerBase.h"
#include "JavaEngine.h"

class  JavaTriggerAction: public cocostudio::BaseTriggerAction
{
 DECLARE_CLASS_INFO
public:
 static void registerType(const std::string& type);
 JavaTriggerAction(void);
 virtual ~JavaTriggerAction(void);

 virtual bool init();
 virtual void done();
 virtual void serialize(const rapidjson::Value &val);
 virtual void removeAll();
};
#endif
