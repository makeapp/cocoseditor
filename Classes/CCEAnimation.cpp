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

#include "CCEAnimation.h"
//#include "ui/UIWidget.h"
//#include "ui/UIHelper.h"
#include "cocos2d.h"

using namespace cocos2d;
//using namespace ui;

namespace cce {

    CCEAnimation::CCEAnimation()
            : _currentFrameIndex(0),
              _destFrameIndex(0),
              _fUnitTime(0.1f),
              _actionTag(0),
              _action(nullptr),
              _object(nullptr),
			  nextAction(nullptr),
              loop(1),
			  delay(0),
			  duration(0),
			  autoRun(false),
			  main(false) {

    }

    CCEAnimation::~CCEAnimation() {
        
		if (_action != nullptr) {
            CC_SAFE_RELEASE_NULL(_action);
        }
		//animationCallback=NULL;
        channels.clear();
    }

	static CCEAnimation* create(){
			CCEAnimation* animation= new CCEAnimation();
			animation->autorelease();
			animation->retain();
			return animation;
	}

    void CCEAnimation::setUnitTime(float fTime) {
        _fUnitTime = fTime;
    }

    float CCEAnimation::getUnitTime() {
        return _fUnitTime;
    }

    void CCEAnimation::setActionTag(int tag) {
        _actionTag = tag;
    }

    int CCEAnimation::getActionTag() {
        return _actionTag;
    }

    void CCEAnimation::setObject(Ref *node) {
        _object = node;
    }

    Ref *CCEAnimation::getObject() {
        return _object;
    }

    Node *CCEAnimation::getActionNode() {
        Node *cNode = dynamic_cast<Node *>(_object);
        if (cNode != nullptr) {
            return cNode;
        }
        return nullptr;
    }

	Spawn *CCEAnimation::createActions() {
		 Vector<FiniteTimeAction *> cSpawnArray;
		 for(int i=0;i<channels.size();i++){
			 auto action = channels.at(i)->getActions();
			 if(action!=NULL){
			 	 cSpawnArray.pushBack(action);
			 }else{
				 log("invalid action for %s",channels.at(i)->getType().c_str());
			 }
		 }
		 if(duration>0){
			 cSpawnArray.pushBack(CCSequence::create(CCDelayTime::create(duration),CallFunc::create(CC_CALLBACK_0(CCEAnimation::onAnimationEnd,this)),nullptr));
		 }
		 //log("create Spawn size %d",cSpawnArray.size());
		 return Spawn::create(cSpawnArray);
	}

    void CCEAnimation::playAction() {
	   
        if (_action == nullptr) {
			//log("create actions %p",this->getActionNode());
			_action = Sequence::create(CCDelayTime::create(delay),CallFunc::create(CC_CALLBACK_0(CCEAnimation::onAnimationStart,this)),createActions(),CallFunc::create(CC_CALLBACK_0(CCEAnimation::onAnimationEnd,this)), nullptr);
			_action->retain();
        }
        this->runAction();

		fireAnimationEvent("Start");
    }


    void CCEAnimation::runAction() {
        Node *cNode = this->getActionNode();
        if (cNode != nullptr && _action != nullptr) {
			if(!_action->isDone()){
				cNode->stopAction(_action);
			}
			//log("run action %s cNode isRunning %s %p",name.c_str(),cNode->isRunning()?"true":"false",cNode);
			cNode->runAction(_action);
        }else{
			log("invalid action node");
		}
    }

    void CCEAnimation::stopAction() {
        Node *cNode = this->getActionNode();
        if (cNode != nullptr && _action != nullptr) {
            cNode->stopAction(_action);
        }

		fireAnimationEvent("Stop");

		/*if(onAnimation!=NULL){
			onAnimation((Ref*)this,"onAnimationStop");
		}*/
    }

    bool CCEAnimation::isActionDoneOnce() {
        if (_action == nullptr) {
            return true;
        }
        return _action->isDone();
    }

	void CCEAnimation::onAnimationStart(){
		//log("onAnimationStart %s %p",getName().c_str(),this->getActionNode());
	}

	void CCEAnimation::onAnimationEnd(){
			//log("onAnimationEnd %s",getName().c_str());
			
			fireAnimationEvent("End");

			/*if(onAnimation!=NULL){
				onAnimation((Ref*)this,"onAnimationEnd");
			}*/
			if(!isActionDoneOnce()){
				stopAction();
			}
		
			if(animationManager->isAutoPlayNext()){
				if(!next.empty()){
					animationManager->play(next);
				}
			}
	}
}