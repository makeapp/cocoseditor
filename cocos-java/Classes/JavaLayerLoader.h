#include "cocosbuilder/CocosBuilder.h"

#include "cocos2d.h"

#ifndef _JAVALAYERLOADER_H
#define _JAVALAYERLOADER_H

USING_NS_CC;
USING_NS_CC_EXT;
using namespace cocosbuilder;


class JavaLayerLoaderProxy:  public cocos2d::Layer
, public cocosbuilder::CCBSelectorResolver
, public cocosbuilder::CCBMemberVariableAssigner {
    
public:
    JavaLayerLoaderProxy () {
      CCLog("JavaLayerLoaderProxy");
    }
    virtual ~JavaLayerLoaderProxy() {}

    CCB_STATIC_NEW_AUTORELEASE_OBJECT_WITH_INIT_METHOD(JavaLayerLoaderProxy, create);
    virtual cocos2d::SEL_MenuHandler onResolveCCBCCMenuItemSelector(cocos2d::Object * pTarget, const char * pSelectorName);

    virtual cocos2d::extension::Control::Handler onResolveCCBCCControlSelector(cocos2d::Object * pTarget, const char * pSelectorName);
    virtual bool onAssignCCBMemberVariable(cocos2d::Object * pTarget, const char * pMemberVariableName, cocos2d::Node * pNode);
    virtual void onNodeLoaded(cocos2d::Node * pNode, cocosbuilder::NodeLoader * pNodeLoader);
    virtual bool JavaLayerLoaderProxy::onAssignCCBCustomProperty(Object* pTarget, const char* pMemberVariableName, const Value& pCCBValue);
};

class  JavaLayerLoader : public cocosbuilder::LayerLoader {
public:
    CCB_STATIC_NEW_AUTORELEASE_OBJECT_METHOD(JavaLayerLoader, loader);
    
protected:
    CCB_VIRTUAL_NEW_AUTORELEASE_CREATECCNODE_METHOD(JavaLayerLoaderProxy);
};

#endif
