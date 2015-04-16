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

#ifndef __CCEKeyFrame_H__
#define __CCEKeyFrame_H__

#include "math/CCGeometry.h"
#include "2d/CCActionInterval.h"
#include "cocos2d.h"
//#include "AudioEngine.h"
#include "SimpleAudioEngine.h"

USING_NS_CC;

namespace cce {
    
	typedef std::function<void(Ref*,std::string)> Callback;

enum FrameType
{
	kKeyframeMove = 0,
	kKeyframeScale,
	kKeyframeRotate,
	kKeyframeTint,
	kKeyframeFade,
	kKeyframeEffect,
	kKeyframeMusic,
	kKeyframeCallback,
	kKeyframeVisible,
	kKeyframeZOrder,
	kKeyframeSprite,
	kKeyframeMax
};

enum class FrameEaseType
{
	Custom = -1,

	LINERAR = 0,
	INSTANT ,

    SINE_EASEIN,
	SINE_EASEOUT,
	SINE_EASEINOUT,

    QUAD_EASEIN,
	QUAD_EASEOUT,
    QUAD_EASEINOUT,

    CUBIC_EASEIN,
    CUBIC_EASEOUT,
    CUBIC_EASEINOUT,

    QUART_EASEIN,
    QUART_EASEOUT,
    QUART_EASEINOUT,

    QUINT_EASEIN,
	QUINT_EASEOUT,
    QUINT_EASEINOUT,

    EXPO_EASEIN,
    EXPO_EASEOUT,
    EXPO_EASEINOUT,

    CIRC_EASEIN,
    CIRC_EASEOUT,
    CIRC_EASEINOUT,

    ELASTIC_EASEIN,
    ELASTIC_EASEOUT,
    ELASTIC_EASEINOUT,

    BACK_EASEIN,
    BACK_EASEOUT,
    BACK_EASEINOUT,

    BOUNCE_EASEIN,
    BOUNCE_EASEOUT,
    BOUNCE_EASEINOUT,

	TWEEN_EASING_MAX = 10000
};

class CCEEaseInstant : public cocos2d::ActionEase
{
public:
    static CCEEaseInstant* create(cocos2d::ActionInterval *pAction);

	virtual CCEEaseInstant* clone() const override;
	virtual CCEEaseInstant* reverse() const override;
    virtual void update(float dt) override;
};

/**
*  @js NA
*  @lua NA
*/
class CCEKeyFrame: public cocos2d::Ref
{

public:

	/**
	* Default constructor
	*/
	CCEKeyFrame();

	/**
	* Default destructor
	*/
	virtual ~CCEKeyFrame();

	/**
	* Changes the index of action frame
	*
	* @param index   the index of action frame
	*/
	void setFrameIndex(int index);

	/**
	* Gets the index of action frame
	*
	* @return the index of action frame
	*/
	int getFrameIndex();

	/**
	* Changes the time of action frame
	*
	* @param fTime  the time of action frame
	*/
	void setFrameTime(float fTime);

	/**
	* Gets the time of action frame
	*
	* @return fTime  the time of action frame
	*/
	float getFrameTime();

	/**
	* Changes the type of action frame
	*
	* @param frameType   the type of action frame
	*/
	void setFrameType(int frameType);

	/**
	* Gets the type of action frame
	*
	* @return the type of action frame
	*/
	int getFrameType();

	/**
	* Changes the easing type.
	*
	* @param easingType the easing type.
	*/
	void setEasingType(int easingType);

	/**
	* Gets the easing type.
	*
	* @return the easing type.
	*/
	int getEasingType();

	/**
	* Gets the ActionInterval of CCEKeyFrame.
	*
	* @parame duration   the duration time of CCEKeyFrame
	*
	* @return ActionInterval
	*/
	virtual cocos2d::FiniteTimeAction* getAction(std::string name,float duration);
	/**
	* Gets the ActionInterval of CCEKeyFrame.
	*
	* @parame duration   the duration time of CCEKeyFrame
	*
	* @parame duration   the source CCEKeyFrame
	*
	* @return ActionInterval
	*/
	virtual cocos2d::FiniteTimeAction* getAction(std::string name,float duration,CCEKeyFrame* srcFrame);

	/**
	*Set the ActionInterval easing parameter.
	*
	*@parame parameter   the parameter for frame ease
	*
	*/
	virtual void setEasingParameter(std::vector<float>& parameter);

	virtual cocos2d::FiniteTimeAction* getEasingAction(cocos2d::FiniteTimeAction* action);
protected:
	/**
	* Gets the Easing Action of CCEKeyFrame.
	*
	* @parame action   the duration time of CCEKeyFrame
	*
	* @return ActionInterval
	*/
	
protected:
	int _frameType;	
	int _frameIndex;
	float _fTime;
	FrameEaseType _easingType;
	std::vector<float> _Parameter;
};

/**
*  @js NA
*  @lua NA
*/
class ActionMoveFrame:public CCEKeyFrame
{
public:

	/**
	* Default constructor
	*/
	ActionMoveFrame();

	/**
	* Default destructor
	*/
	virtual ~ActionMoveFrame();

	/**
	* Changes the move action position.
	*
	* @param the move action position.
	*/
	void setPosition(cocos2d::Vec2 pos);

	/**
	* Gets the move action position.
	*
	* @return the move action position.
	*/
	cocos2d::Vec2 getPosition();

	/**
	* Gets the ActionInterval of CCEKeyFrame.
	*
	* @parame duration   the duration time of CCEKeyFrame
	*
	* @return ActionInterval
	*/
	virtual cocos2d::FiniteTimeAction* getAction(std::string name,float duration);
protected:
    cocos2d::Vec2 _position;
};

/**
*  @js NA
*  @lua NA
*/
class ActionScaleFrame:public CCEKeyFrame
{
public:

	/**
	* Default constructor
	*/
	ActionScaleFrame();

	/**
	* Default destructor
	*/
	virtual ~ActionScaleFrame();

	/**
	* Changes the scale action scaleX.
	*
	* @param the scale action scaleX.
	*/
	void setScaleX(float scaleX);

	/**
	* Gets the scale action scaleX.
	*
	* @return the scale action scaleX.
	*/
	float getScaleX();

	/**
	* Changes the scale action scaleY.
	*
	* @param rotation the scale action scaleY.
	*/
	void setScaleY(float scaleY);

	/**
	* Gets the scale action scaleY.
	*
	* @return the the scale action scaleY.
	*/
	float getScaleY();

	/**
	* Gets the ActionInterval of CCEKeyFrame.
	*
	* @parame duration   the duration time of CCEKeyFrame
	*
	* @return ActionInterval
	*/
	virtual cocos2d::FiniteTimeAction* getAction(std::string name,float duration);
protected:
	float _scaleX;
	float _scaleY;
};
/**
*  @js NA
*  @lua NA
*/
class ActionRotationFrame:public CCEKeyFrame
{
public:

	/**
	* Default constructor
	*/
	ActionRotationFrame();

	/**
	* Default destructor
	*/
	virtual ~ActionRotationFrame();

	/**
	* Changes rotate action rotation.
	*
	* @param rotation rotate action rotation.
	*/
	void setRotation(float rotation);

	/**
	* Gets the rotate action rotation.
	*
	* @return the rotate action rotation.
	*/
	float getRotation();

	/**
	* Gets the ActionInterval of CCEKeyFrame.
	*
	* @parame duration   the duration time of CCEKeyFrame
	*
	* @return ActionInterval
	*/
	virtual cocos2d::FiniteTimeAction* getAction(std::string name,float duration);
	/**
	* Gets the ActionInterval of CCEKeyFrame.
	*
	* @parame duration   the duration time of CCEKeyFrame
	*
	* @parame duration   the source CCEKeyFrame
	*
	* @return ActionInterval
	*/
	virtual cocos2d::FiniteTimeAction* getAction(std::string name,float duration,CCEKeyFrame* srcFrame);
public:
	float _rotation;
};
/**
*  @js NA
*  @lua NA
*/
class ActionFadeFrame:public CCEKeyFrame
{
public:

	/**
	* Default constructor
	*/
	ActionFadeFrame();

	/**
	* Default destructor
	*/
	virtual ~ActionFadeFrame();

	/**
	* Changes the fade action opacity.
	*
	* @param opacity the fade action opacity
	*/
	void setOpacity(int opacity);

	/**
	* Gets the fade action opacity.
	*
	* @return the fade action opacity.
	*/
	int getOpacity();

	/**
	* Gets the ActionInterval of CCEKeyFrame.
	*
	* @parame duration   the duration time of CCEKeyFrame
	*
	* @return ActionInterval
	*/
	virtual cocos2d::FiniteTimeAction* getAction(std::string name,float duration);
protected:
	float _opacity;
};
/**
*  @js NA
*  @lua NA
*/
class ActionTintFrame:public CCEKeyFrame
{

public:

	/**
	* Default constructor
	*/
	ActionTintFrame();

	/**
	* Default destructor
	*/
	virtual ~ActionTintFrame();

	/**
	* Changes the tint action color.
	*
	* @param ccolor the tint action color
	*/
	void setColor(cocos2d::Color3B ccolor);

	/**
	* Gets the tint action color.
	*
	* @return the tint action color.
	*/
	cocos2d::Color3B getColor();

	/**
	* Gets the ActionInterval of CCEKeyFrame.
	*
	* @parame duration   the duration time of CCEKeyFrame
	*
	* @return ActionInterval
	*/
	virtual cocos2d::FiniteTimeAction* getAction(std::string name,float duration);
protected:
	cocos2d::Color3B _color;
};


class SpriteNodeFrame:public CCEKeyFrame
{

public:

	/**
	* Default constructor
	*/
	SpriteNodeFrame(){
		_frameType = (int)kKeyframeSprite;
	}

	/**
	* Default destructor
	*/
	virtual ~SpriteNodeFrame(){
		
	}

	/**
	* Changes the tint action color.
	*
	* @param ccolor the tint action color
	*/
	void setSpriteFrame(cocos2d::SpriteFrame *spriteFrame1){this->spriteFrame=spriteFrame1;};

	SpriteFrame *getSpriteFrame(const char *value) {
        std::string textureName(value);
        int pos = 0;
        if ((pos = textureName.find(".plist/")) > 0) {
            std::string plistPath = textureName.substr(0, pos + 6).c_str();
            std::string frameName = textureName.substr(pos + 7).c_str();
            SpriteFrameCache *cache = SpriteFrameCache::getInstance();
            cache->addSpriteFramesWithFile(plistPath);
            return cache->getSpriteFrameByName(frameName);
        } else{ 
			//SpriteFrameCache::getInstance()->addSpriteFrame();
            
			SpriteFrame *spriteFrame = SpriteFrameCache::getInstance()->getSpriteFrameByName(textureName);
			if(spriteFrame==NULL){
				Texture2D *texture = Director::getInstance()->getTextureCache()->addImage(textureName);
			    if(texture!=NULL){
				   Size size =	texture->getContentSize();
				   Rect r(0,0,size.width,size.height);
				   spriteFrame= SpriteFrame::createWithTexture(texture,r);
				}
			}
			return spriteFrame;
        }
        return NULL;
    }

	/**
	* Gets the tint action color.
	*
	* @return the tint action color.
	*/
	cocos2d::SpriteFrame* getSpriteFrame(){
		return getSpriteFrame(this->texture.c_str());
	};


	void setTexture(std::string texture){
	  this->texture=texture;
	}
	/**
	* Gets the ActionInterval of CCEKeyFrame.
	*
	* @parame duration   the duration time of KeyFrame
	*
	* @return ActionInterval
	*/
	virtual cocos2d::FiniteTimeAction* getAction(std::string name,float duration);
	protected:
	cocos2d::SpriteFrame *spriteFrame;
	
	std::string texture;

};


class EffectFrame:public CCEKeyFrame
{

public:

	/**
	* Default constructor
	*/
	EffectFrame(){
		_frameType = (int)kKeyframeEffect;
	}

	/**
	* Default destructor
	*/
	virtual ~EffectFrame(){
		
	}

	/**
	* Changes the tint action color.
	*
	* @param ccolor the tint action color
	*/
	void setEffect(const char *effect){this->effect=effect;};

	/**
	* Gets the tint action color.
	*
	* @return the tint action color.
	*/
    const char * getSpriteFrame(){return this->effect;};

	/**
	* Gets the ActionInterval of CCEKeyFrame.
	*
	* @parame duration   the duration time of KeyFrame
	*
	* @return ActionInterval
	*/
	 cocos2d::FiniteTimeAction* getAction(std::string name,float duration){
		 return Sequence::create(DelayTime::create(duration),cocos2d::CallFunc::create(CC_CALLBACK_0(EffectFrame::play,this)),nullptr);
	 }

	 void play(){
		 //experimental::AudioEngine::play2d(effect);
		  CocosDenshion::SimpleAudioEngine::getInstance()->playEffect(effect);
	 }
	protected:
	const char  *effect;
};


class MusicFrame:public CCEKeyFrame
{

public:

	/**
	* Default constructor
	*/
	MusicFrame(){
		_frameType = (int)kKeyframeMusic;
	}

	/**
	* Default destructor
	*/
	virtual ~MusicFrame(){
		
	}

	/**
	* Changes the tint action color.
	*
	* @param ccolor the tint action color
	*/
	void setMusic(const char *music){this->music=music;};

	/**
	* Gets the tint action color.
	*
	* @return the tint action color.
	*/
    const char * getMusic(){return this->music;};

	void setTime(int time){
	     this->time=time;
	}
	/**
	* Gets the ActionInterval of CCEKeyFrame.
	*
	* @parame duration   the duration time of KeyFrame
	*
	* @return ActionInterval
	*/
	 cocos2d::FiniteTimeAction* getAction(std::string name,float duration){
		// log("wait %f",duration);
		 log("create music %s %f %d",music,duration,time);
		 return Sequence::create(DelayTime::create(duration),cocos2d::CallFunc::create(CC_CALLBACK_0(MusicFrame::play,this)),DelayTime::create(this->time),nullptr);
	 }

	 void play(){
		  log("play %s ",music);
		 // log("wait play %s",music);
		 //audioId =  experimental::AudioEngine::play2d(music);
		 //experimental::AudioEngine::setFinishCallback(audioId,&onFinish);
		 CocosDenshion::SimpleAudioEngine::getInstance()->playBackgroundMusic(music);
	 }

	 void onFinish(int id,const std::string path){
		 log("on Finsh %s",path.c_str());
	 }

	protected:
	const char  *music;
	int time;
	int audioId;
};


class CallbackFrame:public CCEKeyFrame
{

public:

	/**
	* Default constructor
	*/
	CallbackFrame(){
		_frameType = (int)kKeyframeCallback;
	}

	/**
	* Default destructor
	*/
	virtual ~CallbackFrame(){
		
	}

	/**
	* Changes the tint action color.
	*
	* @param ccolor the tint action color
	*/
	void setCallback(cocos2d::FiniteTimeAction *callback){this->callback=callback;};

	/**
	* Gets the tint action color.
	*
	* @return the tint action color.
	*/
   cocos2d::FiniteTimeAction  * getCallback(){return this->callback;};

	/**
	* Gets the ActionInterval of CCEKeyFrame.
	*
	* @parame duration   the duration time of KeyFrame
	*
	* @return ActionInterval
	*/
	 cocos2d::FiniteTimeAction* getAction(std::string name,float duration){
	     return Sequence::create(DelayTime::create(duration),callback,nullptr);  
	 }

	protected:
	cocos2d::FiniteTimeAction  *callback;
};


class VisibleFrame:public CCEKeyFrame
{

public:

	/**
	* Default constructor
	*/
	VisibleFrame(){
		_frameType = (int)kKeyframeVisible;
	}

	/**
	* Default destructor
	*/
	virtual ~VisibleFrame(){
		
	}

	/**
	* Changes the tint action color.
	*
	* @param ccolor the tint action color
	*/
	void setVisible(bool visible){this->visible=visible;};

	/**
	* Gets the tint action color.
	*
	* @return the tint action color.
	*/
   bool  getVisible(){return this->visible;};

	/**
	* Gets the ActionInterval of CCEKeyFrame.
	*
	* @parame duration   the duration time of KeyFrame
	*
	* @return ActionInterval
	*/
	 cocos2d::FiniteTimeAction* getAction(std::string name,float duration){
		 if(visible){
			return Sequence::create(DelayTime::create(duration),Show::create(),nullptr);  
		 }else{
			return Sequence::create(DelayTime::create(duration),Hide::create(),nullptr);
		 }
	 }

	protected:
		bool  visible;
};

class  ZOrderAction : public cocos2d::ActionInstant{
	public:
	int zorder;
	 
	 ZOrderAction(){}

	 static ZOrderAction * create(float duration,int zorder)
	{
		ZOrderAction *ret = new ZOrderAction();
		ret->zorder=zorder;
		if (ret ) {
			ret->setDuration(duration);
			ret->autorelease();
			return ret;
		}

		CC_SAFE_DELETE(ret);
		return nullptr;
	}
    
	  
	 virtual void update(float time) override{
		 if(time>=1){
			 getTarget()->setZOrder(zorder);
		 }
	 }


	virtual  ZOrderAction* reverse() const override{
		return NULL;
	 }

	 virtual ZOrderAction* clone() const override{
		  return NULL;
	 }
};


class ZOrderFrame:public CCEKeyFrame
{

public:

	/**
	* Default constructor
	*/
	ZOrderFrame(){
		_frameType = (int)kKeyframeZOrder;
	}

	/**
	* Default destructor
	*/
	virtual ~ZOrderFrame(){
		
	}

	/**
	* Changes the tint action color.
	*
	* @param ccolor the tint action color
	*/
	void setZOrder(int zorder){this->zorder=zorder;};

	/**
	* Gets the tint action color.
	*
	* @return the tint action color.
	*/
   int  getZOrder(){return this->zorder;};

	/**
	* Gets the ActionInterval of CCEKeyFrame.
	*
	* @parame duration   the duration time of KeyFrame
	*
	* @return ActionInterval
	*/
	 cocos2d::FiniteTimeAction* getAction(std::string name,float duration){
		 return ZOrderAction::create(duration,zorder);
	 }

	protected:
		int  zorder;
};


class FlipFrame:public CCEKeyFrame
{

public:

	/**
	* Default constructor
	*/
	FlipFrame(){
		
	}

	/**
	* Default destructor
	*/
	virtual ~FlipFrame(){
		
	}

	/**
	* Changes the tint action color.
	*
	* @param ccolor the tint action color
	*/
	void setFlipX(bool x){this->x=x;};

	void setFlipY(bool y){this->y=y;};

	/**
	* Gets the ActionInterval of CCEKeyFrame.
	*
	* @parame duration   the duration time of KeyFrame
	*
	* @return ActionInterval
	*/
	 cocos2d::FiniteTimeAction* getAction(std::string name,float duration){
		return CCSequence::create(CCDelayTime::create(duration),CCFlipX::create(x),CCFlipY::create(y),nullptr);
	 }

	protected:
		bool  x;
		bool  y;
};

class ProgressFrame:public CCEKeyFrame
{

public:

	/**
	* Default constructor
	*/
	ProgressFrame(){
		
	}

	/**
	* Default destructor
	*/
	virtual ~ProgressFrame(){
		
	}


	void setPercent(float percent){this->percent=percent;};

	/**
	* Gets the ActionInterval of CCEKeyFrame.
	*
	* @parame duration   the duration time of KeyFrame
	*
	* @return ActionInterval
	*/
	 cocos2d::FiniteTimeAction* getAction(std::string name,float duration,CCEKeyFrame* srcFrame){
		 if(srcFrame==NULL){
			return CCProgressFromTo::create(duration,0,percent);
		 }else{
			  ProgressFrame *lastFrame = (ProgressFrame*)srcFrame; 
			  return CCProgressFromTo::create(duration,lastFrame->percent,percent);
		 }
	 }



	protected:
		float  percent;
};

}

#endif
