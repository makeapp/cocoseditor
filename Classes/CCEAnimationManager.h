/****************************************************************************
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

#ifndef __CCEAnimationManager_H__
#define __CCEAnimationManager_H__

#include "CCEAnimation.h"
#include "CCEChannel.h"

namespace cce {

    class CCEAnimationManager : public cocos2d::Ref {
    
	public:
		std::unordered_map<std::string, Callback> callbackFunctions;
		std::unordered_map<std::string, CallFunc*> callFunctions;
		
		void setAnimationCallback(Callback callback)			
		{
			for (int i=0;i<animations.size(); i++)
            {
				CCEAnimation * animation = animations.at(i);
				animation->setCallback(callback);
            }
		};

		void setChannelCallback(Callback callback)			
		{
			for (int i=0;i<animations.size(); i++)
            {
				CCEAnimation * animation = animations.at(i);
			    cocos2d::Vector<CCEChannel *> channels =	animation->getChannels();
				for(int j=0;j<channels.size();j++){
					channels.at(j)->setChannelCallback(callback);
				}
            }
		};


        /**
        * Default constructor
        * @js ctor
        */
        CCEAnimationManager();

        /**
        * Default destructor
        * @js NA
        * @lua NA
        */
        virtual ~CCEAnimationManager();

        /**
        * Gets the static instance of ActionManager.
        * @js getInstance
        * @lua getInstance
        */
        static CCEAnimationManager* create();

        /**
        * Purges ActionManager point.
        * @js purge
        * @lua destroyActionManager
        */
        //static void destroyInstance();

        /**
        * Play the action.
        */
         void play(std::string name){
			for (int i=0;i<animations.size(); i++)
            {
				CCEAnimation * animation = animations.at(i);
				if(strcmp(animation->getName().c_str(), name.c_str()) ==0){
					animation->playAction();
				}
            }
		}

        void play(int tag) {
            if (animationsTagMap[tag] != NULL) {
                animationsTagMap[tag]->playAction();
            }
		}

		void playAuto() {

		    for (int i=0;i<animations.size(); i++)
            {
				CCEAnimation * animation = animations.at(i);
				if(animation->getAutoRun()){
					log("play auto %s",animation->getName().c_str());
					animation->playAction();
				}
            }
        }

        virtual void stop(int tag) {
            if (animationsTagMap[tag] != NULL&& animationsTagMap[tag]->isPlaying()) {
                animationsTagMap[tag]->stopAction();
            }
        }

        /**
        * Stop the action.
        */
		void stop(std::string name){
		for (int i=0;i<animations.size(); i++)
            {
				CCEAnimation * animation = animations.at(i);
				if(animation->isPlaying()){
					if(strcmp(animation->getName().c_str(), name.c_str()) ==0){
						animation->stopAction();
					}
				}
            }
		}

         void stopAll(){
			 for (int i=0;i<animations.size(); i++)
            {
				CCEAnimation * animation = animations.at(i);
				if(animation->isPlaying()){
					animation->stopAction();
				}
            }
		}

        void addAnimation(CCEAnimation *animation);

		void setAutoPlayNext(bool autoNext){
			this->autoPlayNext=autoNext;
		}

		bool isAutoPlayNext(){
		  return this->autoPlayNext;
		}

		void addCallback(const std::string callbackNamed,Callback callFunc){
			callbackFunctions[callbackNamed]=callFunc;
			if(callbackNamed=="onAnimationCallback"){
				setAnimationCallback(callFunc);
			}else if(callbackNamed=="onChannelCallback"){
				setChannelCallback(callFunc);
			}
		}


		void addCallFun(const std::string callbackNamed,CallFunc* callFunc){
			callFunctions[callbackNamed]=callFunc;
		}

    protected:
		
        cocos2d::Vector<CCEAnimation *> animations;
        std::unordered_map<int, CCEAnimation *> animationsTagMap;
		bool autoPlayNext;
    };


	class  CallbackAction : public cocos2d::ActionInterval{
	public:
	 cce::CCEAnimationManager *manager;
	 std::string callback;
	 std::string callbackArg;
	 
	 CallbackAction(){}

	 static CallbackAction * create()
	{
		CallbackAction *ret = new CallbackAction();

		if (ret ) {
			
			ret->retain();				
			return ret;
		}

		CC_SAFE_DELETE(ret);
		return nullptr;
	}
    
	  
	virtual void update(float time) override;


	virtual  CallbackAction* reverse() const override{
		return NULL;
	 }

	 virtual CallbackAction* clone() const override{
		  return NULL;
	 }
};

}
#endif