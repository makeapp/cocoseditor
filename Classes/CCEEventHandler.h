
#include "cocos2d.h"
#include "CCEAnimationManager.h"
#include "ui/UIWidget.h"
#include "CCEReader.h"

#ifndef __CCEEventListener_H_
#define __CCEEventListener_H_

namespace cce{
	class CCEReader;

	class CCEEventAction :public cocos2d::Ref{

	public:
			CCEEventAction(std::string action,std::string actionTarget,float delay){
				this->action=action;
				this->target = actionTarget;
				this->delay = delay;
			}

			~CCEEventAction();

			static CCEEventAction* create(std::string action,std::string actionTarget,float delay){
				CCEEventAction *eventAction = new CCEEventAction(action,actionTarget,delay);
				eventAction->autorelease();
				return eventAction;
			}

			std::string getAction(){
				return action;
			}

			std::string getTarget(){
				return target;
			}

			float getDelay(){
				return delay;
			}

			void doAction(Ref* node);

			void doDelayAction(Ref* node);

			void onDelayTime(float t);

			CCEReader * reader;
	private:
			std::string action;
			std::string target;
			float delay;
			
			Ref *node;
	};

	class CCEEventHandler :public cocos2d::Ref	{
		public:
			CCEEventHandler();
			~CCEEventHandler();

			static CCEEventHandler* create(){
				CCEEventHandler *eventHandler = new CCEEventHandler();
				eventHandler->autorelease();
				return eventHandler;
			}

		    std::string eventName;
			std::string eventArg;
			std::string getEventName(){
				return eventName;
			}

			std::string getEventArg(){
				return eventArg;
			}

			Ref* getNode(){
				return node;
			}

			void handleNodeEvent(Ref* node,std::string eventName);

			void addAction(CCEEventAction *action){
				actions.pushBack(action);
			};
			void doKeyEvent(EventKeyboard::KeyCode key);
			void handleActions();
	private:
		
		Ref* node;
		void clickEvent(Ref *pSender);
		cocos2d::Vector<CCEEventAction*> actions;
	};


	
}


#endif

