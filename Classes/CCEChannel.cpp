#include "CCEChannel.h"


cce::CCEChannel::CCEChannel(void)
{
	unitTime=0.01;
	delay=0;
	loop=0;
}


cce::CCEChannel::~CCEChannel(void)
{
	  //log("~CCEChannel");
	  /*for (auto object : keyframes) {
		object->release();
        CC_SAFE_DELETE(object);
      }*/
	  animation=NULL;
	  //_channelCallback=NULL;
	  keyframes.clear();
}

cocos2d::FiniteTimeAction* cce::CCEChannel::getActions(){
	cocos2d::FiniteTimeAction *action;
	//log("create animation %s ",type.c_str());
	if(type=="Sprite"){
	  action = getSpriteActions();
	} else if(type=="BezierTo"||type=="BezierBy"){
		action = getBezierActions();
	}
	else if(type=="SplineTo"||type=="SplineBy"){
		action = getSplineActions();
	}
	else {
	   action = getNormalActions();
	}
	if(loop>1){
		//log("loop %d",loop);
		action = CCRepeat::create(action,loop);
	}else if(loop==-1){
		//log("loop forever ");
		action = CCRepeat::create(action,10000);
	}
	if(delay>0 && action!=NULL){
		//log("dely %f",delay);
		action = CCSequence::create(CCDelayTime::create(delay),action,nullptr);
	}
	return action;
}

cocos2d::FiniteTimeAction* cce::CCEChannel::getSplineActions(){
	int frameCount = this->keyframes.size();
	if(frameCount==0){
		return NULL;
	}
	CCPointArray * array = CCPointArray::create(frameCount); 
	int startIndex,endIndex;
	ActionMoveFrame *lastFrame;
	for (int i = 0; i < frameCount; i++) {
		ActionMoveFrame *frame = (ActionMoveFrame *)this->keyframes.at(i);
		array->addControlPoint(frame->getPosition());
		if(i==0){
			startIndex = frame->getFrameIndex();
		}
		if(i==(frameCount-1)){
			endIndex=frame->getFrameIndex();
			lastFrame=frame;
		}
	}
	 

	float duration = (endIndex-startIndex) * getUnitTime();
	cocos2d::FiniteTimeAction *action=NULL;
	if(type=="SplineTo"){
		action= CCCardinalSplineTo::create(duration, array,0);
	}else if(type=="SplineBy"){
		action=CCCardinalSplineBy::create(duration, array,0);
	}
	if(startIndex>0){
		action = CCSequence::create(CCDelayTime::create(startIndex*getUnitTime()),action,nullptr);
	}
	return lastFrame->getEasingAction(action);
}

cocos2d::FiniteTimeAction* cce::CCEChannel::getBezierActions(){
	int frameCount = this->keyframes.size();
		ccBezierConfig bezierCon;

	int startIndex,endIndex;
	ActionMoveFrame *lastFrame;
    for (int i = 0; i < frameCount; i++) {
		ActionMoveFrame *frame = (ActionMoveFrame *)this->keyframes.at(i);
		if(i==0){
			startIndex=frame->getFrameIndex();
			bezierCon.controlPoint_1=frame->getPosition();
		}else if(i==1){
			bezierCon.controlPoint_2=frame->getPosition();
		}else{
			endIndex=frame->getFrameIndex();
			bezierCon.endPosition =frame->getPosition();
			lastFrame=frame;
		}
	}

	float duration = (endIndex-startIndex) * getUnitTime();
	cocos2d::FiniteTimeAction *action=NULL;
	if(type=="BezierTo"){
		action=(CCBezierTo::create(duration, bezierCon));
	}else if(type=="BezierBy"){
		action=(CCBezierTo::create(duration, bezierCon));
	}
	if(startIndex>0){
		action = CCSequence::create(CCDelayTime::create(startIndex*getUnitTime()),action,nullptr);
	}
	
	return lastFrame->getEasingAction(action);
}

cocos2d::FiniteTimeAction* cce::CCEChannel::getSpriteActions(){
	int frameCount = this->keyframes.size();
	Vector<SpriteFrame *> cSpriteFrames;
	int startIndex=0;
	for (int i = 0; i < frameCount; i++) {
		SpriteNodeFrame *frame = (SpriteNodeFrame*)keyframes.at(i);
		SpriteFrame *spriteFrame = frame->getSpriteFrame();
		if(spriteFrame!=NULL){
			//log("pushBack %p",spriteFrame);
			cSpriteFrames.pushBack(spriteFrame);
		}
		if(i==0){
			startIndex = frame->getFrameIndex();
		}
	}

	//log("add sprite %f,%d",getUnitTime(),startIndex);
	if(startIndex<0){
		startIndex=0;
	}
	//log("add sprite %f,%d",getUnitTime(),startIndex);
	if(startIndex>0){
		return CCSequence::create(CCDelayTime::create(startIndex*getUnitTime()),Animate::create(Animation::createWithSpriteFrames(cSpriteFrames, getUnitTime(),1)),nullptr);
	}else{
		return Animate::create(Animation::createWithSpriteFrames(cSpriteFrames, getUnitTime(),1));
	}
}


cocos2d::FiniteTimeAction* cce::CCEChannel::getNormalActions(){
		
		int frameCount = this->keyframes.size();

		Vector<FiniteTimeAction *> cSequenceArray;

        for (int i = 0; i < frameCount; i++) {
            auto frame = this->keyframes.at(i);
            if (i == 0) {
                float duration = (frame->getFrameIndex()) * getUnitTime();
                FiniteTimeAction *cAction = frame->getAction(type,duration,NULL);
				if (cAction != nullptr){
                    cSequenceArray.pushBack((cAction));
				}else{
					log("Invalid key from %s ",type.c_str());
				}
            }
            else {
                auto srcFrame = this->keyframes.at(i - 1);
                float duration = (frame->getFrameIndex() - srcFrame->getFrameIndex()) * getUnitTime();
                FiniteTimeAction *cAction = frame->getAction(type,duration,srcFrame);
				if (cAction != nullptr){
                    cSequenceArray.pushBack((cAction));
				}else{
					log("Invalid key from %s ",type.c_str());
				}
            }
        }

		cSequenceArray.pushBack(ChannelEndAction::create(this));
		log("cSequenceArray action size %d",cSequenceArray.size());
        return  Sequence::create(cSequenceArray);
}