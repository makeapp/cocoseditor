#include "CCEEventHandler.h"
#include "AudioEngine.h"
#include "FunctionFactory.h"
#include "SimpleAudioEngine.h"

using namespace cce;
using namespace cocos2d;
using namespace cocos2d::ui;

CCEEventHandler::CCEEventHandler(void)
{
}


CCEEventHandler::~CCEEventHandler(void)
{
	//log("~CCEEventHandler");
	actions.clear();
	//auto dispatcher = Director::getInstance()->getEventDispatcher();
	//dispatcher->removeCustomEventListeners();
}

void CCEEventHandler::handleActions(){
	for(auto action:actions){
		action->doDelayAction(node);
	}
}

EventKeyboard::KeyCode getKeyCode(string keycode){
if("KEY_PAUSE"==keycode)return EventKeyboard::KeyCode::KEY_NONE;
else if("KEY_PAUSE"==keycode)return EventKeyboard::KeyCode::KEY_PAUSE;
else if("KEY_SCROLL_LOCK"==keycode)return EventKeyboard::KeyCode::KEY_SCROLL_LOCK;
else if("KEY_PRINT"==keycode)return EventKeyboard::KeyCode::KEY_PRINT;
else if("KEY_SYSREQ"==keycode)return EventKeyboard::KeyCode::KEY_SYSREQ;
else if("KEY_BREAK"==keycode)return EventKeyboard::KeyCode::KEY_BREAK;
else if("KEY_ESCAPE"==keycode)return EventKeyboard::KeyCode::KEY_ESCAPE;
else if("KEY_BACK"==keycode)return EventKeyboard::KeyCode::KEY_BACK;
else if("KEY_BACKSPACE"==keycode)return EventKeyboard::KeyCode::KEY_BACKSPACE;
else if("KEY_TAB"==keycode)return EventKeyboard::KeyCode::KEY_TAB;
else if("KEY_BACK_TAB"==keycode)return EventKeyboard::KeyCode::KEY_BACK_TAB;
else if("KEY_RETURN"==keycode)return EventKeyboard::KeyCode::KEY_RETURN;
else if("KEY_CAPS_LOCK"==keycode)return EventKeyboard::KeyCode::KEY_CAPS_LOCK;
else if("KEY_SHIFT"==keycode)return EventKeyboard::KeyCode::KEY_SHIFT;
else if("KEY_CTRL"==keycode)return EventKeyboard::KeyCode::KEY_CTRL;
else if("KEY_ALT"==keycode)return EventKeyboard::KeyCode::KEY_ALT;
else if("KEY_MENU"==keycode)return EventKeyboard::KeyCode::KEY_MENU;
else if("KEY_HYPER"==keycode)return EventKeyboard::KeyCode::KEY_HYPER;
else if("KEY_INSERT"==keycode)return EventKeyboard::KeyCode::KEY_INSERT;
else if("KEY_HOME"==keycode)return EventKeyboard::KeyCode::KEY_HOME;
else if("KEY_PG_UP"==keycode)return EventKeyboard::KeyCode::KEY_PG_UP;
else if("KEY_DELETE"==keycode)return EventKeyboard::KeyCode::KEY_DELETE;
else if("KEY_END"==keycode)return EventKeyboard::KeyCode::KEY_END;
else if("KEY_PG_DOWN"==keycode)return EventKeyboard::KeyCode::KEY_PG_DOWN;
else if("KEY_LEFT_ARROW"==keycode)return EventKeyboard::KeyCode::KEY_LEFT_ARROW;
else if("KEY_RIGHT_ARROW"==keycode)return EventKeyboard::KeyCode::KEY_RIGHT_ARROW;
else if("KEY_UP_ARROW"==keycode)return EventKeyboard::KeyCode::KEY_UP_ARROW;
else if("KEY_DOWN_ARROW"==keycode)return EventKeyboard::KeyCode::KEY_DOWN_ARROW;
else if("KEY_NUM_LOCK"==keycode)return EventKeyboard::KeyCode::KEY_NUM_LOCK;
else if("KEY_KP_PLUS"==keycode)return EventKeyboard::KeyCode::KEY_KP_PLUS;
else if("KEY_KP_MINUS"==keycode)return EventKeyboard::KeyCode::KEY_KP_MINUS;
else if("KEY_KP_MULTIPLY"==keycode)return EventKeyboard::KeyCode::KEY_KP_MULTIPLY;
else if("KEY_KP_DIVIDE"==keycode)return EventKeyboard::KeyCode::KEY_KP_DIVIDE;
else if("KEY_KP_ENTER"==keycode)return EventKeyboard::KeyCode::KEY_KP_ENTER;
else if("KEY_KP_HOME"==keycode)return EventKeyboard::KeyCode::KEY_KP_HOME;
else if("KEY_KP_UP"==keycode)return EventKeyboard::KeyCode::KEY_KP_UP;
else if("KEY_KP_PG_UP"==keycode)return EventKeyboard::KeyCode::KEY_KP_PG_UP;
else if("KEY_KP_LEFT"==keycode)return EventKeyboard::KeyCode::KEY_KP_LEFT;
else if("KEY_KP_FIVE"==keycode)return EventKeyboard::KeyCode::KEY_KP_FIVE;
else if("KEY_KP_RIGHT"==keycode)return EventKeyboard::KeyCode::KEY_KP_RIGHT;
else if("KEY_KP_END"==keycode)return EventKeyboard::KeyCode::KEY_KP_END;
else if("KEY_KP_DOWN"==keycode)return EventKeyboard::KeyCode::KEY_KP_DOWN;
else if("KEY_KP_PG_DOWN"==keycode)return EventKeyboard::KeyCode::KEY_KP_PG_DOWN;
else if("KEY_KP_INSERT"==keycode)return EventKeyboard::KeyCode::KEY_KP_INSERT;
else if("KEY_KP_DELETE"==keycode)return EventKeyboard::KeyCode::KEY_KP_DELETE;
else if("KEY_F1"==keycode)return EventKeyboard::KeyCode::KEY_F1;
else if("KEY_F2"==keycode)return EventKeyboard::KeyCode::KEY_F2;
else if("KEY_F3"==keycode)return EventKeyboard::KeyCode::KEY_F3;
else if("KEY_F4"==keycode)return EventKeyboard::KeyCode::KEY_F4;
else if("KEY_F5"==keycode)return EventKeyboard::KeyCode::KEY_F5;
else if("KEY_F6"==keycode)return EventKeyboard::KeyCode::KEY_F6;
else if("KEY_F7"==keycode)return EventKeyboard::KeyCode::KEY_F7;
else if("KEY_F8"==keycode)return EventKeyboard::KeyCode::KEY_F8;
else if("KEY_F9"==keycode)return EventKeyboard::KeyCode::KEY_F9;
else if("KEY_F10"==keycode)return EventKeyboard::KeyCode::KEY_F10;
else if("KEY_F11"==keycode)return EventKeyboard::KeyCode::KEY_F11;
else if("KEY_F12"==keycode)return EventKeyboard::KeyCode::KEY_F12;
else if("KEY_SPACE"==keycode)return EventKeyboard::KeyCode::KEY_SPACE;
else if("KEY_EXCLAM"==keycode)return EventKeyboard::KeyCode::KEY_EXCLAM;
else if("KEY_QUOTE"==keycode)return EventKeyboard::KeyCode::KEY_QUOTE;
else if("KEY_NUMBER"==keycode)return EventKeyboard::KeyCode::KEY_NUMBER;
else if("KEY_DOLLAR"==keycode)return EventKeyboard::KeyCode::KEY_DOLLAR;
else if("KEY_PERCENT"==keycode)return EventKeyboard::KeyCode::KEY_PERCENT;
else if("KEY_CIRCUMFLEX"==keycode)return EventKeyboard::KeyCode::KEY_CIRCUMFLEX;
else if("KEY_AMPERSAND"==keycode)return EventKeyboard::KeyCode::KEY_AMPERSAND;
else if("KEY_APOSTROPHE"==keycode)return EventKeyboard::KeyCode::KEY_APOSTROPHE;
else if("KEY_LEFT_PARENTHESIS"==keycode)return EventKeyboard::KeyCode::KEY_LEFT_PARENTHESIS;
else if("KEY_RIGHT_PARENTHESIS"==keycode)return EventKeyboard::KeyCode::KEY_RIGHT_PARENTHESIS;
else if("KEY_ASTERISK"==keycode)return EventKeyboard::KeyCode::KEY_ASTERISK;
else if("KEY_PLUS"==keycode)return EventKeyboard::KeyCode::KEY_PLUS;
else if("KEY_COMMA"==keycode)return EventKeyboard::KeyCode::KEY_COMMA;
else if("KEY_MINUS"==keycode)return EventKeyboard::KeyCode::KEY_MINUS;
else if("KEY_PERIOD"==keycode)return EventKeyboard::KeyCode::KEY_PERIOD;
else if("KEY_SLASH"==keycode)return EventKeyboard::KeyCode::KEY_SLASH;
else if("KEY_0"==keycode)return EventKeyboard::KeyCode::KEY_0;
else if("KEY_1"==keycode)return EventKeyboard::KeyCode::KEY_1;
else if("KEY_2"==keycode)return EventKeyboard::KeyCode::KEY_2;
else if("KEY_3"==keycode)return EventKeyboard::KeyCode::KEY_3;
else if("KEY_4"==keycode)return EventKeyboard::KeyCode::KEY_4;
else if("KEY_5"==keycode)return EventKeyboard::KeyCode::KEY_5;
else if("KEY_6"==keycode)return EventKeyboard::KeyCode::KEY_6;
else if("KEY_7"==keycode)return EventKeyboard::KeyCode::KEY_7;
else if("KEY_8"==keycode)return EventKeyboard::KeyCode::KEY_8;
else if("KEY_9"==keycode)return EventKeyboard::KeyCode::KEY_9;
else if("KEY_COLON"==keycode)return EventKeyboard::KeyCode::KEY_COLON;
else if("KEY_SEMICOLON"==keycode)return EventKeyboard::KeyCode::KEY_SEMICOLON;
else if("KEY_LESS_THAN"==keycode)return EventKeyboard::KeyCode::KEY_LESS_THAN;
else if("KEY_EQUAL"==keycode)return EventKeyboard::KeyCode::KEY_EQUAL;
else if("KEY_GREATER_THAN"==keycode)return EventKeyboard::KeyCode::KEY_GREATER_THAN;
else if("KEY_QUESTION"==keycode)return EventKeyboard::KeyCode::KEY_QUESTION;
else if("KEY_AT"==keycode)return EventKeyboard::KeyCode::KEY_AT;
else if("KEY_CAPITAL_A"==keycode)return EventKeyboard::KeyCode::KEY_CAPITAL_A;
else if("KEY_CAPITAL_B"==keycode)return EventKeyboard::KeyCode::KEY_CAPITAL_B;
else if("KEY_CAPITAL_C"==keycode)return EventKeyboard::KeyCode::KEY_CAPITAL_C;
else if("KEY_CAPITAL_D"==keycode)return EventKeyboard::KeyCode::KEY_CAPITAL_D;
else if("KEY_CAPITAL_E"==keycode)return EventKeyboard::KeyCode::KEY_CAPITAL_E;
else if("KEY_CAPITAL_F"==keycode)return EventKeyboard::KeyCode::KEY_CAPITAL_F;
else if("KEY_CAPITAL_G"==keycode)return EventKeyboard::KeyCode::KEY_CAPITAL_G;
else if("KEY_CAPITAL_H"==keycode)return EventKeyboard::KeyCode::KEY_CAPITAL_H;
else if("KEY_CAPITAL_I"==keycode)return EventKeyboard::KeyCode::KEY_CAPITAL_I;
else if("KEY_CAPITAL_J"==keycode)return EventKeyboard::KeyCode::KEY_CAPITAL_J;
else if("KEY_CAPITAL_K"==keycode)return EventKeyboard::KeyCode::KEY_CAPITAL_K;
else if("KEY_CAPITAL_L"==keycode)return EventKeyboard::KeyCode::KEY_CAPITAL_L;
else if("KEY_CAPITAL_M"==keycode)return EventKeyboard::KeyCode::KEY_CAPITAL_M;
else if("KEY_CAPITAL_N"==keycode)return EventKeyboard::KeyCode::KEY_CAPITAL_N;
else if("KEY_CAPITAL_O"==keycode)return EventKeyboard::KeyCode::KEY_CAPITAL_O;
else if("KEY_CAPITAL_P"==keycode)return EventKeyboard::KeyCode::KEY_CAPITAL_P;
else if("KEY_CAPITAL_Q"==keycode)return EventKeyboard::KeyCode::KEY_CAPITAL_Q;
else if("KEY_CAPITAL_R"==keycode)return EventKeyboard::KeyCode::KEY_CAPITAL_R;
else if("KEY_CAPITAL_S"==keycode)return EventKeyboard::KeyCode::KEY_CAPITAL_S;
else if("KEY_CAPITAL_T"==keycode)return EventKeyboard::KeyCode::KEY_CAPITAL_T;
else if("KEY_CAPITAL_U"==keycode)return EventKeyboard::KeyCode::KEY_CAPITAL_U;
else if("KEY_CAPITAL_V"==keycode)return EventKeyboard::KeyCode::KEY_CAPITAL_V;
else if("KEY_CAPITAL_W"==keycode)return EventKeyboard::KeyCode::KEY_CAPITAL_W;
else if("KEY_CAPITAL_X"==keycode)return EventKeyboard::KeyCode::KEY_CAPITAL_X;
else if("KEY_CAPITAL_Y"==keycode)return EventKeyboard::KeyCode::KEY_CAPITAL_Y;
else if("KEY_CAPITAL_Z"==keycode)return EventKeyboard::KeyCode::KEY_CAPITAL_Z;
else if("KEY_LEFT_BRACKET"==keycode)return EventKeyboard::KeyCode::KEY_LEFT_BRACKET;
else if("KEY_BACK_SLASH"==keycode)return EventKeyboard::KeyCode::KEY_BACK_SLASH;
else if("KEY_RIGHT_BRACKET"==keycode)return EventKeyboard::KeyCode::KEY_RIGHT_BRACKET;
else if("KEY_UNDERSCORE"==keycode)return EventKeyboard::KeyCode::KEY_UNDERSCORE;
else if("KEY_GRAVE"==keycode)return EventKeyboard::KeyCode::KEY_GRAVE;
else if("KEY_A"==keycode)return EventKeyboard::KeyCode::KEY_A;

if("KEY_B"==keycode)return EventKeyboard::KeyCode::KEY_B;
else if("KEY_C"==keycode)return EventKeyboard::KeyCode::KEY_C;
else if("KEY_D"==keycode)return EventKeyboard::KeyCode::KEY_D;
else if("KEY_E"==keycode)return EventKeyboard::KeyCode::KEY_E;
else if("KEY_F"==keycode)return EventKeyboard::KeyCode::KEY_F;
else if("KEY_G"==keycode)return EventKeyboard::KeyCode::KEY_G;
else if("KEY_H"==keycode)return EventKeyboard::KeyCode::KEY_H;
else if("KEY_I"==keycode)return EventKeyboard::KeyCode::KEY_I;
else if("KEY_J"==keycode)return EventKeyboard::KeyCode::KEY_J;
else if("KEY_K"==keycode)return EventKeyboard::KeyCode::KEY_K;
else if("KEY_L"==keycode)return EventKeyboard::KeyCode::KEY_L;
else if("KEY_M"==keycode)return EventKeyboard::KeyCode::KEY_M;
else if("KEY_N"==keycode)return EventKeyboard::KeyCode::KEY_N;
else if("KEY_O"==keycode)return EventKeyboard::KeyCode::KEY_O;
else if("KEY_P"==keycode)return EventKeyboard::KeyCode::KEY_P;
else if("KEY_Q"==keycode)return EventKeyboard::KeyCode::KEY_Q;
else if("KEY_R"==keycode)return EventKeyboard::KeyCode::KEY_R;
else if("KEY_S"==keycode)return EventKeyboard::KeyCode::KEY_S;
else if("KEY_T"==keycode)return EventKeyboard::KeyCode::KEY_T;
else if("KEY_U"==keycode)return EventKeyboard::KeyCode::KEY_U;
else if("KEY_V"==keycode)return EventKeyboard::KeyCode::KEY_V;
else if("KEY_W"==keycode)return EventKeyboard::KeyCode::KEY_W;
else if("KEY_X"==keycode)return EventKeyboard::KeyCode::KEY_X;
else if("KEY_Y"==keycode)return EventKeyboard::KeyCode::KEY_Y;
else if("KEY_Z"==keycode)return EventKeyboard::KeyCode::KEY_Z;
else if("KEY_LEFT_BRACE"==keycode)return EventKeyboard::KeyCode::KEY_LEFT_BRACE;
else if("KEY_BAR"==keycode)return EventKeyboard::KeyCode::KEY_BAR;
else if("KEY_RIGHT_BRACE"==keycode)return EventKeyboard::KeyCode::KEY_RIGHT_BRACE;
else if("KEY_TILDE"==keycode)return EventKeyboard::KeyCode::KEY_TILDE;
else if("KEY_EURO"==keycode)return EventKeyboard::KeyCode::KEY_EURO;
else if("KEY_POUND"==keycode)return EventKeyboard::KeyCode::KEY_POUND;
else if("KEY_YEN"==keycode)return EventKeyboard::KeyCode::KEY_YEN;
else if("KEY_MIDDLE_DOT"==keycode)return EventKeyboard::KeyCode::KEY_MIDDLE_DOT;
else if("KEY_SEARCH"==keycode)return EventKeyboard::KeyCode::KEY_SEARCH;
else if("KEY_DPAD_LEFT"==keycode)return EventKeyboard::KeyCode::KEY_DPAD_LEFT;
else if("KEY_DPAD_RIGHT"==keycode)return EventKeyboard::KeyCode::KEY_DPAD_RIGHT;
else if("KEY_DPAD_UP"==keycode)return EventKeyboard::KeyCode::KEY_DPAD_UP;
else if("KEY_DPAD_DOWN"==keycode)return EventKeyboard::KeyCode::KEY_DPAD_DOWN;
else if("KEY_DPAD_CENTER"==keycode)return EventKeyboard::KeyCode::KEY_DPAD_CENTER;
else if("KEY_ENTER"==keycode)return EventKeyboard::KeyCode::KEY_ENTER;
else if("KEY_PLAY"==keycode)return EventKeyboard::KeyCode::KEY_PLAY;

}


void CCEEventHandler::doKeyEvent(EventKeyboard::KeyCode key){
	if(key==getKeyCode(eventArg)){
		handleActions();
	}
}

void CCEEventHandler::clickEvent(Ref *pSender){
		handleActions();
}

void CCEEventHandler::handleNodeEvent(Ref* ref,std::string eventName){
			this->node = ref;
			this->eventName = eventName;
			Node *node=dynamic_cast<Node*>(ref);

			if(eventName.empty()){
				return ;
			}

			if(eventName=="onTouch"){
				
				auto listener1 = EventListenerTouchOneByOne::create();
				listener1->setSwallowTouches(true);
				listener1->onTouchBegan = [](Touch* touch, Event* event){
					auto target = static_cast<Node*>(event->getCurrentTarget());
        
					Vec2 locationInNode = target->convertToNodeSpace(touch->getLocation());
					Size s = target->getContentSize();
					Rect rect = Rect(0, 0, s.width, s.height);
					if (rect.containsPoint(locationInNode) && target->isVisible())
					{
						return true;
					}
					return false;
				};

				listener1->onTouchEnded = [=](Touch* touch, Event* event){
					auto target = static_cast<Node*>(event->getCurrentTarget());
					Vec2 locationInNode = target->convertToNodeSpace(touch->getLocation());
					Size s = target->getContentSize();
					Rect rect = Rect(0, 0, s.width, s.height);
					if (rect.containsPoint(locationInNode))
					{
						handleActions();
					}
				};
				if(node!=NULL){
					Director::getInstance()->getEventDispatcher()->addEventListenerWithSceneGraphPriority(listener1,node);
				}
			}else if(eventName=="onKeyPressed"){
				auto keyboardEventListener = EventListenerKeyboard::create();
				keyboardEventListener->onKeyPressed = [=](EventKeyboard::KeyCode key, Event* event){
					//auto target = static_cast<Sprite*>(event->getCurrentTarget());
					doKeyEvent(key);
					event->stopPropagation();
				};
				
				Director::getInstance()->getEventDispatcher()->addEventListenerWithSceneGraphPriority(keyboardEventListener,node);
			}
			else if(eventName=="onKeyReleased"){
				auto keyboardEventListener = EventListenerKeyboard::create();
				keyboardEventListener->onKeyReleased = [=](EventKeyboard::KeyCode key, Event* event){
					//auto target = static_cast<Sprite*>(event->getCurrentTarget());
					doKeyEvent(key);
					event->stopPropagation();
				};
				Director::getInstance()->getEventDispatcher()->addEventListenerWithSceneGraphPriority(keyboardEventListener,node);
			}
			else if(eventName=="onWidgetClick"){
				Widget *widget = dynamic_cast<Widget*>(node);
				if(widget!=NULL){
					widget->addClickEventListener(CC_CALLBACK_1(CCEEventHandler::clickEvent,this));
				}
			}else if(eventName=="onAnimationStart"||eventName=="onAnimationEnd"||eventName=="onAnimationStop"){
				CCEAnimation *animtion=dynamic_cast<CCEAnimation*>(ref);
				animtion->setCallback([=](Ref* event,std::string name){
					if(name=="Start" && eventName=="onAnimationStart"){
						handleActions();
					}else if(name=="End" && eventName=="onAnimationEnd"){
						handleActions();
					}else if(name=="Stop" && eventName=="onAnimationStop"){
						handleActions();
					}
				});
			}
			/*else{
				 log("add addCustomEventListener %s",eventName.c_str());
				 auto dispatcher = Director::getInstance()->getEventDispatcher();
				 dispatcher->addCustomEventListener(eventName, [=](EventCustom* event){
					 Ref *target =  ( Ref *)event->getUserData();
					 if(this->node == target){
						handleActions();
					 }
				 });
				// dispatcher->removeCustomEventListeners
			}*/
}


CCEEventAction::~CCEEventAction(void){
	//log("~CCEEventAction");
	Director::getInstance()->getInstance()->getScheduler()->unschedule("doDelayAction",this);
}


void CCEEventAction::doDelayAction(Ref* node){
	if(node!=NULL){
		this->node=node;
		if(delay>0){
			Director::getInstance()->getInstance()->getScheduler()->schedule(
				CC_CALLBACK_1(CCEEventAction::onDelayTime, this),this, 0,0,delay,false, "doDelayAction");
		}else{
			doAction(node);
		}
	}
}

void CCEEventAction::onDelayTime(float t){
	doAction(this->node);
}


void CCEEventAction::doAction(Ref *node){
	if(action.empty()){
		return;
	}
	log("doAction %s",action.c_str());

	if("startAnimation"==action && reader!=NULL){
		reader->playAnimation(target);
	}else if("stopAnimation"==action && reader!=NULL){
		reader->stopAnimation(target);
	}else if("stopAllAnimation"==action && reader!=NULL){
		reader->stopAllAnimation();
	}
	else if("callback"==action ){
		Callback callback = reader->getAnimationManager()->callbackFunctions[target];
	   if(callback){
	     callback(node,target);
	   }else{
		   CallFunc *fun = reader->getAnimationManager()->callFunctions[target];
		   if(fun!=NULL){
			   fun->update(1);
		   }
	   }
	}else if("audioEffect"==action||"playEffect"==action){
		//experimental::AudioEngine::play2d(target);
		CocosDenshion::SimpleAudioEngine::getInstance()->playEffect(target.c_str());
	}else if("stopAllEffects"==action){
		CocosDenshion::SimpleAudioEngine::getInstance()->stopAllEffects();
	}else if("stopBackgroundMusic"==action){
		CocosDenshion::SimpleAudioEngine::getInstance()->stopBackgroundMusic();
	}else if("playMusic"==action){
		CocosDenshion::SimpleAudioEngine::getInstance()->playBackgroundMusic(target.c_str());
	}
	else if("stopMusic"==action){
		CocosDenshion::SimpleAudioEngine::getInstance()->stopBackgroundMusic();
	}else if("addSpriteFramesWithFile"==action){
		SpriteFrameCache::getInstance()->addSpriteFramesWithFile(target);
	}else if("removeSpriteFrames"==action){
		SpriteFrameCache::getInstance()->removeSpriteFrames();
	}else if("removeUnusedSpriteFrames"==action){
		SpriteFrameCache::getInstance()->removeUnusedSpriteFrames();
	}else if("removeSpriteFrameByName"==action){
		SpriteFrameCache::getInstance()->removeSpriteFrameByName(target);
	}else if("removeSpriteFramesFromFile"==action){
		SpriteFrameCache::getInstance()->removeSpriteFramesFromFile(target);
	}else if("removeAllTextures"==action){
		TextureCache::getInstance()->removeAllTextures();
	}else if("removeUnusedTextures"==action){
		SpriteFrameCache::getInstance()->removeUnusedSpriteFrames();
		TextureCache::getInstance()->removeUnusedTextures();
		log("CachedTextureInfo: %s",TextureCache::getInstance()->getCachedTextureInfo().c_str());
	}else if("removeTextureForKey"==action){
		TextureCache::getInstance()->removeTextureForKey(target);
	}else if("dumpCachedTextureInfo"==action){
		log("CachedTextureInfo: %s",TextureCache::getInstance()->getCachedTextureInfo().c_str());
	}
	else if("popScene"==action){
		Director::getInstance()->popScene();
	}else if("end"==action){
		Director::getInstance()->end();
	}else if("popToRootScene"==action){
		Director::getInstance()->popToRootScene();
	}else if("runScene"==action){
		FunctionFactory::getInstance()->callFunction("runScene",target);
	}else if("replaceScene"==action){
		FunctionFactory::getInstance()->callFunction("replaceScene",target);
	}else if("pushScene"==action){
		FunctionFactory::getInstance()->callFunction("pushScene",target);
	}else{
		Ref *ref = reader->getRef(target);
		Node *actionNode =NULL;
		if(ref!=NULL){
			actionNode = dynamic_cast<Node*>(ref);
		}
		if(actionNode==NULL && node!=NULL){
			actionNode = dynamic_cast<Node*>(node);
		}
		if(actionNode==NULL){
			return;	
		}
		if("hide"==action){
			actionNode->setVisible(false);
		}else if("show"==action){
			actionNode->setVisible(true);
		}else if("toggleVisible"==action){
			actionNode->setVisible(!actionNode->isVisible());
		}else if("removeChildren"==action){
			actionNode->removeAllChildren();
		}else if("removeSelf"==action){
			actionNode->removeFromParent();
		}else if("stopAllActions"==action){
			actionNode->stopAllActions();
		}else{
			log("Invalid action %s ",action.c_str());
		}
	}
}