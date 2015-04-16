#include "JavaLayerLoader.h"
#include "cocosbuilder/CocosBuilder.h"
#include "cocos2d.h"

USING_NS_CC;
USING_NS_CC_EXT;
using namespace cocosbuilder;


bool JavaLayerLoaderProxy::onAssignCCBMemberVariable(Object * pTarget, const char * pMemberVariableName, Node * pNode) {
     CCLog("onAssignCCBMemberVariable");
   return true;
};

bool JavaLayerLoaderProxy::onAssignCCBCustomProperty(Object* pTarget, const char* pMemberVariableName, const Value& pCCBValue)
{
  CCLog("onAssignCCBCustomProperty");

 return true;
};

void JavaLayerLoaderProxy::onNodeLoaded(Node * pNode,NodeLoader * pNodeLoader) {
  CCLog("onNodeLoaded");
};

Control::Handler JavaLayerLoaderProxy::onResolveCCBCCControlSelector(Object * pTarget, const char * pSelectorName) {
       CCLog("onResolveCCBCCControlSelector");
  return NULL;
};

SEL_MenuHandler JavaLayerLoaderProxy::onResolveCCBCCMenuItemSelector(Object * pTarget, const char * pSelectorName) {

   CCLog("onResolveCCBCCMenuItemSelector");
return NULL;
};