#ifndef _CCEReader_H
#define _CCEReader_H


#include "2d/CCSprite.h"

#include "cocos2d.h"
#include "ui/CocosGUI.h"
#include "cocostudio/CCArmature.h"
#include "tinyxml2.h"
#include "CCEKeyFrame.h"
#include "CCEAnimation.h"
#include "CCEEventHandler.h"
#include "CCEAnimationManager.h"

#include <map>

using namespace cocos2d;
using namespace ui;

namespace cce {

    class CCEReader : public Ref {

    public:
        CCEReader() {
			animationManager = new CCEAnimationManager();
		};

        ~CCEReader();

        static CCEReader *create() {
            CCEReader *ret = new CCEReader();
            ret->autorelease();
            return ret;
        }

		static Color4B getPixelsColor(int x,int y){
			GLubyte pColor[4];
			glReadPixels(x,y,1,1,GL_RGBA,GL_UNSIGNED_BYTE,&pColor[0]);
			Color4B color;
			color.r=pColor[0];
			color.g=pColor[1];
			color.b=pColor[2];
			color.a=pColor[3];
			return color;
		};

		static Color4B getSpritePixelsColor(Sprite *sprite,int x,int y){
			CCRenderTexture* render = CCRenderTexture::create(CCDirector::sharedDirector()->getWinSize().width, CCDirector::sharedDirector()->getWinSize().height);
			render->begin();
			sprite->visit();
			GLubyte pColor[4];
			glReadPixels(x,y,1,1,GL_RGBA,GL_UNSIGNED_BYTE,&pColor[0]);
			Color4B color;
			color.r=pColor[0];
			color.g=pColor[1];
			color.b=pColor[2];
			color.a=pColor[3];
			render->end();
			return color;
		};

		/**

        /** Initializes the database. If path is null, it will create an in-memory DB */
        Ref *read(void * parent,const std::string &fullpath = "");
        
		Ref *read(const std::string &fullpath = ""){
			return read(NULL,fullpath);
		}

        //Map<int, Ref *> node1s;

		int getCCEReaderSize(){
			return nodeReaders.size();
		}

		CCEReader* getCCEReaderByIndex(int idx){
			return nodeReaders.at(idx);
		}

        std::vector<std::string> getComponentNames() {
			std::vector<std::string> keys;

        if (!components.empty())
        {
            keys.reserve(components.size());
            
            for (auto iter = components.cbegin(); iter != components.cend(); ++iter)
            {
                keys.push_back(iter->first);
            }
        }
		 return keys;
        }

        cocos2d::Vector<Node*>& getComponentNodes(std::string name) {
            return components.at(name);
        }

        Node *getNode(int tag) {
            return (Node *) nodes[tag];
        };
		
		Node *getNode(std::string name) {
			return (Node *) nameNodes[name];
        };

		CCEReader *getCCEReader(int tag) {
            return (CCEReader *) nodes[tag];
        };

		CCEReader *getCCEReader(std::string name) {
            return (CCEReader *) nameNodes[name];
        };


		PhysicsBody *getPhysicsBody(int tag) {
            return (PhysicsBody *) (nodes[tag]);
        };

		PhysicsJoint *getPhysicsJoint(int tag) {
            return (PhysicsJoint *) (nodes[tag]);
        };
		

		PhysicsJointDistance *getPhysicsJointDistance(int tag) {
            return (PhysicsJointDistance *) (nodes[tag]);
        };		
		
		PhysicsJointFixed *getPhysicsJointFixed(int tag) {
            return (PhysicsJointFixed *) (nodes[tag]);
        };	
		
		PhysicsJointGear *getPhysicsJointGear(int tag) {
            return (PhysicsJointGear *) (nodes[tag]);
        };	

		PhysicsJointGroove *getPhysicsJointGroove(int tag) {
            return (PhysicsJointGroove *) (nodes[tag]);
        };		
		
		PhysicsJointLimit *getPhysicsJointLimit(int tag) {
            return (PhysicsJointLimit *) (nodes[tag]);
        };		
		PhysicsJointMotor *getPhysicsJointMotor(int tag) {
            return (PhysicsJointMotor *) (nodes[tag]);
        };
		PhysicsJointPin *getPhysicsJointPin(int tag) {
            return (PhysicsJointPin *) (nodes[tag]);
        };
		PhysicsJointRatchet *getPhysicsJointRatchet(int tag) {
            return (PhysicsJointRatchet *) (nodes[tag]);
        };		
		
		PhysicsJointRotaryLimit *getPhysicsJointRotaryLimit(int tag) {
            return (PhysicsJointRotaryLimit *) (nodes[tag]);
        };	
		
		PhysicsJointRotarySpring *getPhysicsJointRotarySpring(int tag) {
            return (PhysicsJointRotarySpring *) (nodes[tag]);
        };
		
		PhysicsJointSpring *getPhysicsJointSpring(int tag) {
            return (PhysicsJointSpring *) (nodes[tag]);
        };

		PhysicsShape *getPhysicsShape(int tag) {
            return (PhysicsShape *) (nodes[tag]);
        };
		
		PhysicsShapeBox *getPhysicsShapeBox(int tag) {
            return (PhysicsShapeBox *) (nodes[tag]);
        };
		
		PhysicsShapeCircle *getPhysicsShapeCircle(int tag) {
            return (PhysicsShapeCircle *) (nodes[tag]);
        };

		PhysicsShapeEdgeBox *getPhysicsShapeEdgeBox(int tag) {
            return (PhysicsShapeEdgeBox *) (nodes[tag]);
        };
		
		PhysicsShapeEdgeChain *getPhysicsShapeEdgeChain(int tag) {
            return (PhysicsShapeEdgeChain *) (nodes[tag]);
        };	
		
		PhysicsShapeEdgePolygon *getPhysicsShapeEdgePolygon(int tag) {
            return (PhysicsShapeEdgePolygon *) (nodes[tag]);
        };

		PhysicsShapeEdgeSegment *getPhysicsShapeEdgeSegment(int tag) {
            return (PhysicsShapeEdgeSegment *) (nodes[tag]);
        };
		
		PhysicsShapePolygon *getPhysicsShapePolygon(int tag) {
            return (PhysicsShapePolygon *) (nodes[tag]);
        };

        Sprite *getSprite(int tag) {
            return (Sprite *) (nodes[tag]);
        };

		Sprite *getSprite(std::string nodeName) {
			 return (Sprite *) (nameNodes[nodeName]);
        };

        Layer *getLayer(int tag) {
            return (Layer *) (nodes[tag]);
        };

		Layer *getLayer(std::string nodeName) {
            return (Layer *) (nameNodes[nodeName]);
        };

        Scene *getScene(int tag) {
            return (Scene *) (nodes[tag]);
        };

		Scene *getScene(std::string nodeName) {
            return (Scene *) (nameNodes[nodeName]);
        };

		CCEAnimation *getAnimation(int tag) {
			return  (CCEAnimation *) (nodes[tag]);
        };

		CCEAnimation *getAnimation(std::string nodeName) {
			return (CCEAnimation *) (nameNodes[nodeName]);
        };

        Menu *getMenu(int tag) {
            return (Menu *) (nodes[tag]);
        };

		Menu *getMenu(std::string nodeName) {
            return (Menu *) (nameNodes[nodeName]);
        };

        MenuItem *getMenuItem(int tag) {
            return (MenuItem *) (nodes[tag]);
        }

		MenuItem *getMenuItem(std::string nodeName) {
            return (MenuItem *) (nameNodes[nodeName]);
        }

        Ref *getRef(int tag) {
            return (Ref *) (nodes[tag]);
        }

		Ref *getRef(std::string name) {
			if(name.empty()){
				return NULL;
			}
            return (Ref *) (nameNodes[name]);
        }

        Label *getLabel(int tag) {
            return (Label *) (nodes[tag]);
        };

		      Label *getLabel(std::string name) {
            return (Label *) (nameNodes[name]);
        };

        ui::Widget *getWidget(int tag) {
            return (ui::Widget *) (nodes[tag]);
        };

		       ui::Widget *getWidget(std::string name) {
				   return (ui::Widget *) (nameNodes[name]);
        };


        void playAnimation(std::string name) {
            animationManager->play(name);
        }

        void playAnimation(int tag) {
            animationManager->play(tag);
        }
        
        void playAutoAnimations() {
            animationManager->playAuto();
        }

        void stopAnimation(int tag) {
            animationManager->stop(tag);
        }

        /**
        * Stop the action.
        */
        void stopAnimation(std::string name) {
           animationManager->stop(name);
        }

        void stopAllAnimation() {
            animationManager->stopAll();
        }

		CCEAnimationManager* getAnimationManager(){
		  return animationManager;
		}

		cocos2d::Vector<CCEEventHandler *> getEventHandlers(){
			return eventHandlers;
		}
		
		private:
				std::unordered_map<std::string,cocos2d::Vector<Node*>> components;

		cocos2d::Vector<CCEReader*> nodeReaders;

		cocos2d::Vector<CCEEventHandler *> eventHandlers;

        std::map<int, void *> nodes;
		std::map<std::string, void *> nameNodes;

		CCEAnimationManager *animationManager;

		PhysicsBody *getBodyA(void *parent,int tag);
		PhysicsBody *getBodyB(int tag);
		
		
		//  使用 CCSAXDelegator 重写3个回调函数

        Ref *parse(void *parent, tinyxml2::XMLElement *ele);

        Layer *parseLayer(void *parent, tinyxml2::XMLElement *ele);

        Scene *parseScene(void *parent, tinyxml2::XMLElement *ele);

        Node *parseNode(void *parent, tinyxml2::XMLElement *ele);

		ProgressTimer *parseProgressTimer(void *parent, tinyxml2::XMLElement *ele);

		Node *parseInclude(void *parent, tinyxml2::XMLElement *ele);

		ClippingNode *parseClippingNode(void *parent, tinyxml2::XMLElement *ele);

		Node *parseClippingStencil(void *parent, tinyxml2::XMLElement *ele);

		DrawNode *parseDrawNode(void *parent, tinyxml2::XMLElement *ele);

		Node *parseDrawLine(void *parent, tinyxml2::XMLElement *ele);
		
		Node *parseDrawRect(void *parent, tinyxml2::XMLElement *ele);

		Node *parseDrawCircle(void *parent, tinyxml2::XMLElement *ele);

		Node *parseDrawPoint(void *parent, tinyxml2::XMLElement *ele);

		Node *parseDrawSegment(void *parent, tinyxml2::XMLElement *ele);

		Node *parseDrawDot(void *parent, tinyxml2::XMLElement *ele);


		cce::CCEKeyFrame *parseChannelKeyFrame(void *parent, tinyxml2::XMLElement *ele) ;

		cce::CCEChannel *parseChannel(void *parent, tinyxml2::XMLElement *ele);

		Node *parseIncludeNode(void *parent, tinyxml2::XMLElement *ele);

		ParallaxNode *parseParallaxNode(void *parent, tinyxml2::XMLElement *ele);

		void addChildNode(void *parent,Node * node,tinyxml2::XMLElement *ele);
        
		Node *parseCCEReader(void *parent, tinyxml2::XMLElement *ele);

        Component *parseComponent(void *parent, tinyxml2::XMLElement *ele);

        LayerColor *parseLayerColor(void *parent, tinyxml2::XMLElement *ele);

        LayerGradient *parseLayerGradient(void *parent, tinyxml2::XMLElement *ele);

        ParticleSystem *parseParticleSystem(void *parent, tinyxml2::XMLElement *ele);

		Label *parseLabel(void *parent, tinyxml2::XMLElement *ele);

        LabelAtlas *parseLabelAtlas(void *parent, tinyxml2::XMLElement *ele);

        Menu *parseMenu(void *parent, tinyxml2::XMLElement *ele);

        MenuItemToggle *parseMenuItemToggle(void *parent, tinyxml2::XMLElement *ele);

        MenuItemImage *parseMenuItemImage(void *parent, tinyxml2::XMLElement *ele);

        MenuItemSprite *parseMenuItemSprite(void *parent, tinyxml2::XMLElement *ele);

        MenuItemFont *parseMenuItemFont(void *parent, tinyxml2::XMLElement *ele);

        MenuItemAtlasFont *parseMenuItemAtlasFont(void *parent, tinyxml2::XMLElement *ele);

        MenuItemLabel *parseMenuItemLabel(void *parent, tinyxml2::XMLElement *ele);

        cce::CCEAnimation *parseAnimation(void *parent, tinyxml2::XMLElement *ele);

        cce::CCEKeyFrame *parseKeyFrame(void *parent, tinyxml2::XMLElement *ele);

		cce::CCEEventHandler *parseEventHandler(void *parent, tinyxml2::XMLElement *ele);

		cce::CCEEventHandler *parseKeyboardEvent(void *parent, tinyxml2::XMLElement *ele);

		cce::CCEEventAction *parseEventAction(void *parent, tinyxml2::XMLElement *ele);

		cce::CCEEventAction *parseEventActionScene(void *parent, tinyxml2::XMLElement *ele);

        ui::Button *parseButton(void *parent, tinyxml2::XMLElement *ele);

        ui::ScrollView *parseScrollView(void *parent, tinyxml2::XMLElement *ele);

        ui::ListView *parseListView(void *parent, tinyxml2::XMLElement *ele);

        ui::PageView *parsePageView(void *parent, tinyxml2::XMLElement *ele);

		ui::Text *parseText(void *parent, tinyxml2::XMLElement *ele);

		ui::TextAtlas *parseTextAtlas(void *parent, tinyxml2::XMLElement *ele);

		ui::TextBMFont *parseTextBMFont(void *parent, tinyxml2::XMLElement *ele);

        ui::TextField *parseTextField(void *parent, tinyxml2::XMLElement *ele);

        ui::LoadingBar *parseLoadingBar(void *parent, tinyxml2::XMLElement *ele);

        ui::Slider *parseSlider(void *parent, tinyxml2::XMLElement *ele);

        ui::CheckBox *parseCheckBox(void *parent, tinyxml2::XMLElement *ele);

        ui::ImageView *parseImageView(void *parent, tinyxml2::XMLElement *ele);

        ui::Widget *parseUI(void *parent, tinyxml2::XMLElement *ele);

		ui::RichText *parseRichText(void *parent, tinyxml2::XMLElement *ele);

		ui::RichElement *parseRichTextElement(void *parent, tinyxml2::XMLElement *ele);

        cocostudio::Armature *parseArmature(void *parent, tinyxml2::XMLElement *ele);

        void parseNodeAttribute(void *parent, Node *node, tinyxml2::XMLElement *ele, const tinyxml2::XMLAttribute *attr);

        void parseWidgetAttribute(void *parent,Node *node,tinyxml2::XMLElement *ele, const tinyxml2::XMLAttribute *attr);

        void parseLayerAttribute(void *parent, Node *node,tinyxml2::XMLElement *ele, const tinyxml2::XMLAttribute *attr);

        Sprite *parseSprite(void *parent, tinyxml2::XMLElement *ele);

        PhysicsBody *parsePhysicsBody(void *parent, tinyxml2::XMLElement *ele);

        PhysicsShapeCircle *parseCircleShape(void *parent, tinyxml2::XMLElement *ele);

        PhysicsShapeBox *parseBoxShape(void *parent, tinyxml2::XMLElement *ele);

        PhysicsShapePolygon *parsePolygonShape(void *parent, tinyxml2::XMLElement *ele);

        PhysicsShapeEdgeSegment *parseEdgeSegmentShape(void *parent, tinyxml2::XMLElement *ele);

        PhysicsShapeEdgeBox *parseEdgeBoxShape(void *parent, tinyxml2::XMLElement *ele);

        PhysicsShapeEdgePolygon *parseEdgePolygonShape(void *parent, tinyxml2::XMLElement *ele);

        PhysicsShapeEdgeChain *parseEdgeChainShape(void *parent, tinyxml2::XMLElement *ele);

        PhysicsJointDistance *parseJointDistancee(void *parent, tinyxml2::XMLElement *ele);
        PhysicsJointFixed *parseJointFixed(void *parent, tinyxml2::XMLElement *ele);
        PhysicsJointGear *parseJointGear(void *parent, tinyxml2::XMLElement *ele);
        PhysicsJointGroove *parseJointGroove(void *parent, tinyxml2::XMLElement *ele);
        PhysicsJointLimit *parseJointLimit(void *parent, tinyxml2::XMLElement *ele);
        PhysicsJointMotor *parseJointMotor(void *parent, tinyxml2::XMLElement *ele);
        PhysicsJointPin *parseJointPin(void *parent, tinyxml2::XMLElement *ele);
        PhysicsJointRatchet *parseJointRatchet(void *parent, tinyxml2::XMLElement *ele);
        PhysicsJointRotaryLimit *parseJointRotaryLimit(void *parent, tinyxml2::XMLElement *ele);
        PhysicsJointRotarySpring *parseJointRotarySpring(void *parent, tinyxml2::XMLElement *ele);
        PhysicsJointSpring *parseJointSpring(void *parent, tinyxml2::XMLElement *ele);

		
    };

	class CleanUpNode :public Node{
		public :
		  virtual void cleanup();

		  virtual void onEnter();

		  virtual void onExit();
		  
		  CCEReader *cceReader;
	};
}

#endif