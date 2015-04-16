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

#include "CCEAnimationManager.h"

#ifndef _CCEAnimation_
#define _CCEAnimation_

#include "CCEKeyFrame.h"
#include "CCEChannel.h"

namespace cce {
class CCEAnimationManager;
class CCEAnimation;

/**
*  @js NA
*  @lua NA
*/
    class CCEAnimation : public cocos2d::Ref {
    public:
		
		//std::function<void(Ref*,std::string)> onAnimation;

        /**
        * Default constructor
        */
		CCEAnimation();

        /**
        * Default destructor
        */
        virtual ~CCEAnimation();

		static CCEAnimation* create(){
			CCEAnimation *animation = new CCEAnimation();
			animation->autorelease();
			return animation;
		}

        /**
        * Sets the time interval of frame.
        *
        * @param fTime   the time interval of frame
        */
        void setUnitTime(float fTime);

        /**
        * Gets the time interval of frame.
        *
        * @return fTime   the time interval of frame
        */
        float getUnitTime();

        /**
        * Sets tag for ActionNode
        *
        * @param tag    tag of ActionNode
        */
        void setActionTag(int tag);

        /**
        * Gets tag for ActionNode
        *
        * @return tag    tag of ActionNode
        */
        int getActionTag();

        /**
        * Sets node which will run a action.
        *
        * @param  node which will run a action
        */
        void setObject(cocos2d::Ref *node);

        /**
        * Gets node which will run a action.
        *
        * @return  node which will run a action
        */
        cocos2d::Ref *getObject();


        /**
        * Play the action.
        */
        virtual void playAction();

        /**
        * Stop the action.
        */
        virtual void stopAction();

        /**
        * Gets if the action is done once time.
        *
        * @return   that if the action is done once time
        */
        virtual bool isActionDoneOnce();

        std::string getName() {
            return name;
        }

        void setName(std::string name) {
            this->name=name;
        }

        void setNext(std::string next) {
            this->next=next;
        }

		std::string getNext() {
            return next;
        }

        void setSrc(std::string src) {
            this->src=src;
        }

		std::string getSrc() {
            return src;
        }

		void setLoop(int loop){
			this->loop=loop;
		}

		int getLoop(){
			return this->loop;
		}

		void setAutoRun(bool autoRun){
			this->autoRun=autoRun;
		}

		bool getAutoRun(){
		 return	this->autoRun;
		}

		void setMain(bool main){
			this->main=main;
		}

		bool isMain(){
		 return	this->main;
		}

		virtual cocos2d::Spawn *createActions();

		virtual cocos2d::Node *getActionNode();

		bool isPlaying(){
			return !isActionDoneOnce();
		};

		void setDelay(float delay){
			this->delay=delay;
		}

		float getDelay(){
			return this->delay;
		}

		void setDuration(float duration){
			this->duration = duration;
		}

		float getDuration(){
			return this->duration;
		}

		cocos2d::Vector<CCEChannel *>& getChannels(){
			return channels;
		}

		void onAnimationStart();

		void onAnimationEnd();

		void addChannel(CCEChannel *channel){
			if(channel==NULL){
				return ;
			}
			channel->setAnimation(this);
			channels.pushBack(channel);
		}

		CCEChannel * getOrCreateChannel(std::string type){
			CCEChannel *channel = NULL;
			for(int i=0;i<channels.size();i++){
				 channel = channels.at(i);
				 if(channel!=NULL  && channel->getType()==type){
					break;
				 }
			}
			if(channel==NULL){
			  channel =  CCEChannel::create();
			  channel->setType(type);
			  channel->setLoop(getLoop());
			  channel->setUnitTime(getUnitTime());
			  addChannel(channel);
			}
			return channel;
		}

		void setCallback(Callback callback){
			addCallback(callback);
		}

		void addCallback(Callback callback){
			callbackes.push_back(callback);
		}

		void fireAnimationEvent(std::string name){
			for(int i=0;i<callbackes.size();i++){
				Callback call = callbackes.at(i);
				call(this,name);
			}
		}

		CCEAnimationManager *animationManager;

    protected:
        int _currentFrameIndex;
        int _destFrameIndex;
		bool autoRun;
		bool main;
        float _fUnitTime;
        std::string name;
		std::string next;
		std::string src;
        int _actionTag;
        int loop;
		float delay;
		float duration;
		std::vector<Callback> callbackes;
        cocos2d::Spawn *_actionSpawn;
        cocos2d::Action *_action;
		cocos2d::FiniteTimeAction *nextAction;
        cocos2d::Ref *_object;
		cocos2d::Vector<CCEChannel *> channels;
    protected:

        virtual void runAction();

     };
}


#endif
