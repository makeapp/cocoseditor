
#include "cocos2d.h"
#include "CCEKeyFrame.h"
#include "CCEAnimation.h"

#ifndef __CCEChannel_H__
#define __CCEChannel_H__

namespace cce{
	class CCEChannel;
	class CCEAnimation;

class CCEChannel :
	public cocos2d::Ref
{

public:
		CCEChannel(void);
		~CCEChannel(void);

		static CCEChannel* create(){
			   CCEChannel *channel = new CCEChannel();
			   channel->autorelease();
			   return channel;
		}

		cocos2d::FiniteTimeAction* getActions();

		cocos2d::FiniteTimeAction* getSpriteActions();

		cocos2d::FiniteTimeAction* getNormalActions();

		cocos2d::FiniteTimeAction* getBezierActions();

		cocos2d::FiniteTimeAction* getSplineActions();

		/**
        * Insets a ActionFrame to ActionNode.
        *
        * @param index  the index of ActionFrame
        *
        * @param frame  the ActionFrame which will be inserted
        */
        void insertFrame(int index, CCEKeyFrame *frame){
			keyframes.insert(index,frame);
		};

        /**
        * Pushs back a KeyFrame to ActionNode.
        *
        * @param frame  the KeyFrame which will be added
        */
		void addFrame(CCEKeyFrame *frame){
			if(frame!=NULL){
				frame->autorelease();
				if(frame->getFrameIndex()==-1||frame->getFrameIndex()<0){
					frame->setFrameIndex(keyframes.size());
				}
				keyframes.pushBack(frame);
			}
		};

        /**
        * Remove a KeyFrame from ActionNode.
        *
        * @param frame  the KeyFrame which will be removed
        */
		void deleteFrame(CCEKeyFrame *frame){
			keyframes.eraseObject(frame);
		};

        /**
        * Remove all KeyFrames from ActionNode.
        */
		void clearAllFrame(){
			keyframes.clear();
		};

		void setLoop(int loop){
			this->loop=loop;
		};

		float getUnitTime(){
			return this->unitTime;
		};

		void setUnitTime(float unitTime){
			this->unitTime=unitTime;
		};

		void setType(std::string type){
			this->type = type;
		};

		std::string getType(){
		  return type;
		};

		void setDelay(float delay){
			this->delay=delay;
		}

		float getDelay(){
			return this->delay;
		}

		cocos2d::Node *getNode(){
		  return node;
		};

		void setNode(cocos2d::Node *node){
		  this->node=node;
		};

		void setChannelCallback(Callback callback)			
		{
			this->_channelCallback=callback;
		};

		Callback getChannelCallback(){
			return this->_channelCallback;
		};

		void setAnimation(CCEAnimation *animation){
			this->animation = animation;
		}
			
		CCEAnimation* getAnimation(){
			 return this->animation;
		}
private:
	float unitTime;
	float delay;
	int loop;
	std::string type;
	cocos2d::Node *node;
	cocos2d::Vector<CCEKeyFrame *>  keyframes;
	Callback _channelCallback;
	CCEAnimation * animation;
};

class  ChannelEndAction : public cocos2d::ActionInstant{
	public:
	
		CCEChannel *channel;

	ChannelEndAction(){}

	 static ChannelEndAction * create(CCEChannel *channel)
	{
		ChannelEndAction *ret = new ChannelEndAction();
		if (ret ) {
			ret->channel=channel;
			ret->autorelease();
			return ret;
		}

		CC_SAFE_DELETE(ret);
		return nullptr;
	}
    
	  
	 virtual void update(float time) override{
		 if(time>=1){
			 Callback callback=channel->getChannelCallback();
			 if(callback){
			 	callback(channel,"Stop");
			 }
		 }
	 }


	virtual  ChannelEndAction* reverse() const override{
		return NULL;
	 }

	 virtual ChannelEndAction* clone() const override{
		  return NULL;
	 }
};

}

#endif