#include "CCEReader.h"
#include "CCFileUtils.h"
#include "CCEAnimationManager.h"


namespace cce {
	

	 bool equals(const char* str1,const char* str2){
		if(str1==NULL||str2==NULL){
			return false;
		}
		return strcmp(str1,str2)==0;
	}


	int getSizeWidth(Node *parentNode,tinyxml2::XMLElement *ele,float width){
			const char* sizeType = ele->Attribute("sizeType");
			if(sizeType!=NULL){
				if(equals(sizeType,"Percent")){
					if(parentNode!=NULL){
						return parentNode->getContentSize().width*width;
					}else{
						return Director::getInstance()->getWinSize().width*width;
					}
				}else if(equals(sizeType,"VisiblePercent")){
					return Director::getInstance()->getVisibleSize().width*width;
				}
			}
			return width;
	}

		int getSizeHeight(Node *parentNode,tinyxml2::XMLElement *ele,float height){
			const char* sizeType = ele->Attribute("sizeType");
			if(sizeType!=NULL){
				if(equals(sizeType,"Percent")){
					if(parentNode!=NULL){
						return parentNode->getContentSize().height*height;
					}else{
						return Director::getInstance()->getWinSize().height*height;
					}
				}else if(equals(sizeType,"VisiblePercent")){
					return Director::getInstance()->getVisibleSize().height*height;
				}
			}
			return height;
	}

		float getPositionXValue(void* parent,Node *node,tinyxml2::XMLElement *ele,float value){
			const char* positionType = ele->Attribute("positionType");
			const char* positionUnit = ele->Attribute("positionUnit");

			if(positionType!=NULL||positionUnit!=NULL){
				Node *parentNode = (Node *) parent;
				int parentW = 0;
				if(parentNode!=NULL){
					parentW = parentNode->getContentSize().width;
				}else{
					parentW = Director::getInstance()->getWinSize().width;
				}

				if(positionType!=NULL){
					if(strcmp(positionType,"LeftTop")==0||equals(positionType,"LeftCenter")||equals(positionType,"LeftBottom")){
						if(equals(positionUnit,"Percent")){
							value = parentW*value;
						}
					}else if(equals(positionType,"CenterTop")||equals(positionType,"Center")||equals(positionType,"CenterBottom")){
						if(equals(positionUnit,"Percent")){
							value = parentW*value;
						}
						value += parentW/2;
					}else if(equals(positionType,"RightTop")||equals(positionType,"RightCenter")||equals(positionType,"RightBottom")){
						if(equals(positionUnit,"Percent")){
							value = parentW*value;
						}
						value = parentW-value;
					}else if(equals(positionType,"VisibleOrigin")){
						value = Director::getInstance()->getVisibleOrigin().x+value;
					}
				}else{
				 if(equals(positionUnit,"Percent")){
					value = parentW*value;
				 }
				}
				
				//log(" %s x=%f \n",positionType,value);
			}
			return value;
	}


	float getPositionYValue(void* parent,Node *node,tinyxml2::XMLElement *ele,float value){
			const char* positionType = ele->Attribute("positionType");
			const char* positionUnit = ele->Attribute("positionUnit");
		    
			if(positionType!=NULL||positionUnit!=NULL){
				Node *parentNode = (Node *) parent;
				int parentH = 0;
				if(parentNode!=NULL){
					parentH = parentNode->getContentSize().height;
				}else{
					parentH = Director::getInstance()->getWinSize().height;
				}

				if(positionType!=NULL){
				if(equals(positionType,"LeftTop")||equals(positionType,"CenterTop")||equals(positionType,"RightTop")){
					if(equals(positionUnit,"Percent")){
						value = parentH*value;
					}
					value = parentH-value;
				}else if(equals(positionType,"LeftCenter")||equals(positionType,"Center")||equals(positionType,"RightCenter")){
					if(equals(positionUnit,"Percent")){
						value = parentH*value;
					}
					value = parentH/2+value;
				}else if(equals(positionType,"LeftBottom")||equals(positionType,"CenterBottom")||equals(positionType,"RightBottom")){
					if(equals(positionUnit,"Percent")){
						value = parentH*value;
					}
				}else if(equals(positionType,"VisibleOrigin")){
					value = Director::getInstance()->getVisibleOrigin().y+value;
				}
				}else{
					if(equals(positionUnit,"Percent")){
						value = parentH*value;
					}
				}
				//log(" %s y= %f \n",positionType,value);
			}
			
			
			return value;
	}

	Label * createLabel(void *parent, tinyxml2::XMLElement *ele){
		const char* texture = ele->Attribute("texture");
		if(texture==NULL){
			texture="";
		}
		const char* type = ele->Attribute("type");
		const char* fontName = ele->Attribute("fontName");
		if(fontName==NULL){
			fontName="arial";
		}
		const char* text = ele->Attribute("text");
		if(text==NULL){
			text="";
		}
		float size  = ele->FloatAttribute("fontSize");
		float height  = ele->IntAttribute("height");
		float width  = ele->IntAttribute("width");
		const char* vAlign = ele->Attribute("vAlign");
		if(vAlign==NULL){
			vAlign="CENTER";
		}
		const char* hAlign = ele->Attribute("hAlign");
		if(hAlign==NULL){
			hAlign="LEFT";
		}
		TextHAlignment hAlignment;
		TextVAlignment vAlignment;
		if (strcmp(vAlign, "Top") == 0) {
			vAlignment=(TextVAlignment::TOP);
		} else if (strcmp(vAlign, "Center") == 0) {
			vAlignment=(TextVAlignment::CENTER);
		} else if (strcmp(vAlign, "Bottom") == 0) {
			vAlignment=(TextVAlignment::BOTTOM);
		}else{
			vAlignment=(TextVAlignment::CENTER);
		}
		if (strcmp(hAlign, "Left") == 0) {
			hAlignment=(TextHAlignment::LEFT);
		} else if (strcmp(hAlign, "Center") == 0) {
			hAlignment=(TextHAlignment::CENTER);
		} else if (strcmp(hAlign, "Right") == 0) {
			hAlignment=(TextHAlignment::RIGHT);
		}else{
			hAlignment=(TextHAlignment::LEFT);
		}

		Label *node = NULL;
		std::string texturePath(texture);
		if(!texturePath.empty()){
			int offsetTTF = texturePath.find(".ttf");
			int offsetNFT = texturePath.find(".fnt");
			int offsetPNG = texturePath.find(".png");
			if (offsetTTF > 0) {
				node = Label::createWithTTF(TTFConfig(texture,size),text,hAlignment);
			} else if (offsetNFT> 0) {
				node = Label::createWithBMFont(texture,text,hAlignment);
			} else if (offsetPNG > 0) {
				int charWidth = ele->IntAttribute("charWidth");
				int charHeight = ele->IntAttribute("charHeight");
				std::string firstChar = ele->Attribute("firstChar");
				if(!firstChar.empty()){
					node = Label::createWithCharMap(texture,charWidth,charHeight,firstChar.at(0));
					node->setString(text);
				}
			}
		}
		else{
			node = Label::createWithSystemFont(text, fontName, size,Size(width,height),hAlignment,vAlignment);
		}
		return node;
	}

	Color3B& getColor3B(std::string color){
//		printf("parse color %s  ",color);
		int rr,gg,bb;
		if(color.length()==7){
			std::string r = color.substr(1,2);
			std::string g = color.substr(3,2);
			std::string b = color.substr(5,2);
			 rr = strtol(r.c_str(),NULL,16);
			 gg = strtol(g.c_str(),NULL,16);
			 bb = strtol(b.c_str(),NULL,16);
		}else if(color.length()==9){
			std::string a = color.substr(1,2);
			std::string r = color.substr(3,2);
			std::string g = color.substr(5,2);
			std::string b = color.substr(7,2);
			 rr = strtol(r.c_str(),NULL,16);
			 gg = strtol(g.c_str(),NULL,16);
			 bb = strtol(b.c_str(),NULL,16);
		}
		Color3B color3B(rr,gg,bb);
		return color3B;
	}

	Color4B& getColor4B(std::string color){
//		printf("parse color %s  ",color);
		int aa,rr,gg,bb;
		if(color.length()==7){
			std::string r = color.substr(1,2);
			std::string g = color.substr(3,2);
			std::string b = color.substr(5,2);
			 aa=255;
			 rr = strtol(r.c_str(),NULL,16);
			 gg = strtol(g.c_str(),NULL,16);
			 bb = strtol(b.c_str(),NULL,16);
		}else if(color.length()==9){
			std::string a = color.substr(1,2);
			std::string r = color.substr(3,2);
			std::string g = color.substr(5,2);
			std::string b = color.substr(7,2);
			aa = strtol(a.c_str(),NULL,16);
			 rr = strtol(r.c_str(),NULL,16);
			 gg = strtol(g.c_str(),NULL,16);
			 bb = strtol(b.c_str(),NULL,16);
		}
		Color4B color4B(rr,gg,bb,aa);
		return color4B;
	}

	Color4F& getColor4F(std::string color){
//		printf("parse color %s  ",color);
		int aa,rr,gg,bb;
		if(color.length()==7){
			std::string r = color.substr(1,2);
			std::string g = color.substr(3,2);
			std::string b = color.substr(5,2);
			 aa=255;
			 rr = strtol(r.c_str(),NULL,16);
			 gg = strtol(g.c_str(),NULL,16);
			 bb = strtol(b.c_str(),NULL,16);
		}else if(color.length()==9){
				std::string a = color.substr(1,2);
				std::string r = color.substr(3,2);
				std::string g = color.substr(5,2);
				std::string b = color.substr(7,2);
				aa = strtol(a.c_str(),NULL,16);
			 rr = strtol(r.c_str(),NULL,16);
			 gg = strtol(g.c_str(),NULL,16);
			 bb = strtol(b.c_str(),NULL,16);
		}
		Color4F color4F(rr/255,gg/255,bb/255,aa/255);
		return color4F;
	}

	void parseColor3B(Node *node,std::string color){
		int rr=255,gg=255,bb=255;
		if(color.length()==7){
			std::string r = color.substr(1,2);
			std::string g = color.substr(3,2);
			std::string b = color.substr(5,2);
			 rr = strtol(r.c_str(),NULL,16);
			 gg = strtol(g.c_str(),NULL,16);
			 bb = strtol(b.c_str(),NULL,16);
		}else if(color.length()==9){
			std::string a = color.substr(1,2);
			std::string r = color.substr(3,2);
			std::string g = color.substr(5,2);
			std::string b = color.substr(7,2);
			int aa = strtol(a.c_str(),NULL,16);
			 rr = strtol(r.c_str(),NULL,16);
			 gg = strtol(g.c_str(),NULL,16);
			 bb = strtol(b.c_str(),NULL,16);
			node->setOpacity(aa);
		}
		Color3B color3B(rr,gg,bb);
		node->setColor(color3B);
	}


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

	CCEReader::~CCEReader() {
            //log("~CCEReader");
			nodes.clear();
			nameNodes.clear();
			components.clear();
			eventHandlers.clear();
			CC_SAFE_DELETE(animationManager);
			animationManager=NULL;
			//log("CCEReader release ");
	}

    Ref *CCEReader::read(void * parent,const std::string &fullpath) {

        tinyxml2::XMLDocument *xmlDoc = new tinyxml2::XMLDocument();

        std::string xmlBuffer = FileUtils::getInstance()->getStringFromFile(fullpath);
        //log("xml:%s", xmlBuffer.c_str());
        if (xmlBuffer.empty()) {
            CCLOG("can not read xml file");
            return NULL;
        }
        xmlDoc->Parse(xmlBuffer.c_str(), xmlBuffer.size());

        // get root node
        tinyxml2::XMLElement *rootNode = xmlDoc->RootElement();
        if (nullptr == rootNode) {
            CCLOG("read root node error");
            return NULL;
        }
        // find the node
        tinyxml2::XMLElement *curNode = rootNode->FirstChildElement();

        Ref *ref = parse(parent, rootNode);

		Node* node = dynamic_cast <Node*>(ref);
		if(node!=NULL){
			CleanUpNode *cNode = new CleanUpNode();
			cNode->cceReader=this;
			node->addChild(cNode);
			this->retain();
		}
		return ref;
    }

    Ref *CCEReader::parse(void *parent, tinyxml2::XMLElement *ele) {
        const char *nodeName = ele->Name();
        //log("parse node name %s \n", nodeName);
        void *object = parent;
        if (strcmp(nodeName, "Node") == 0) {
            object = parseNode(parent, ele);
        } else if (strcmp(nodeName, "Sprite") == 0) {
            object = parseSprite(parent, ele);
        } else if (strcmp(nodeName, "Layer") == 0) {
            object = parseLayer(parent, ele);
        } else if (strcmp(nodeName, "Scene") == 0) {
            object = parseScene(parent, ele);
        } else if (strcmp(nodeName, "Component") == 0) {
            object = parseComponent(parent, ele);
        } else if (strcmp(nodeName, "LayerColor") == 0) {
            object = parseLayerColor(parent, ele);
        } else if (strcmp(nodeName, "LayerGradient") == 0) {
            object = parseLayerGradient(parent, ele);
        } else if (strcmp(nodeName, "Label") == 0) {
            object = parseLabel(parent, ele);
        }	else if (strcmp(nodeName, "LabelAtlas") == 0) {
            object = parseLabelAtlas(parent, ele);
        } else if (strcmp(nodeName, "Menu") == 0) {
            object = parseMenu(parent, ele);
        } else if (strcmp(nodeName, "MenuItemToggle") == 0) {
            object = parseMenuItemToggle(parent, ele);
			return (Node *)object;
        } else if (strcmp(nodeName, "MenuItemImage") == 0) {
            object = parseMenuItemImage(parent, ele);
        } else if (strcmp(nodeName, "MenuItemSprite") == 0) {
            object = parseMenuItemSprite(parent, ele);
        } else if (strcmp(nodeName, "MenuItemFont") == 0) {
            object = parseMenuItemFont(parent, ele);
        } else if (strcmp(nodeName, "MenuItemAtlasFont") == 0) {
            object = parseMenuItemAtlasFont(parent, ele);
        } else if (strcmp(nodeName, "MenuItemLabel") == 0) {
            object = parseMenuItemLabel(parent, ele);
        } else if (strcmp(nodeName, "Particles") == 0) {
            object = parseParticleSystem(parent, ele);
        } else if (strcmp(nodeName, "Button") == 0) {
            object = parseButton(parent, ele);
        } else if (strcmp(nodeName, "ScrollView") == 0) {
            object = parseScrollView(parent, ele);
        } else if (strcmp(nodeName, "ListView") == 0) {
            object = parseListView(parent, ele);
        } else if (strcmp(nodeName, "PageView") == 0) {
            object = parsePageView(parent, ele);
        } else if (strcmp(nodeName, "TextField") == 0) {
            object = parseTextField(parent, ele);
        } else if (strcmp(nodeName, "TextBMFont") == 0) {
            object = parseTextBMFont(parent, ele);
        } else if (strcmp(nodeName, "TextAtlas") == 0) {
            object = parseTextAtlas(parent, ele);
        } else if (strcmp(nodeName, "LoadingBar") == 0) {
            object = parseLoadingBar(parent, ele);
        } else if (strcmp(nodeName, "Slider") == 0) {
            object = parseSlider(parent, ele);
        } else if (strcmp(nodeName, "ImageView") == 0) {
            object = parseImageView(parent, ele);
        } else if (strcmp(nodeName, "CheckBox") == 0) {
            object = parseCheckBox(parent, ele);
        } else if (strcmp(nodeName, "UI") == 0) {
            object = parseUI(parent, ele);
        } else if (strcmp(nodeName, "Armature") == 0) {
            object = parseArmature(parent, ele);
        } else if (strcmp(nodeName, "PhysicsBody") == 0) {
            object = parsePhysicsBody(parent, ele);
        } else if (strcmp(nodeName, "CircleShape") == 0) {
            object = parseCircleShape(parent, ele);
        } else if (strcmp(nodeName, "BoxShape") == 0) {
            object = parseBoxShape(parent, ele);
        } else if (strcmp(nodeName, "PolygonShape") == 0) {
            object = parsePolygonShape(parent, ele);
        } else if (strcmp(nodeName, "EdgeSegmentShape") == 0) {
            object = parseEdgeSegmentShape(parent, ele);
        } else if (strcmp(nodeName, "EdgeBoxShape") == 0) {
            object = parseEdgeBoxShape(parent, ele);
        } else if (strcmp(nodeName, "EdgePolygonShape") == 0) {
            object = parseEdgePolygonShape(parent, ele);
        } else if (strcmp(nodeName, "EdgeChainShape") == 0) {
            object = parseEdgeChainShape(parent, ele);
        } else if (strcmp(nodeName, "Animation") == 0) {
            object = parseAnimation(parent, ele);
        } else if (strcmp(nodeName, "JointDistance") == 0) {
            object = parseJointDistancee(parent, ele);
        } else if (strcmp(nodeName, "JointFixed") == 0) {
            object = parseJointFixed(parent, ele);
        } else if (strcmp(nodeName, "JointGear") == 0) {
            object = parseJointGear(parent, ele);
        }  else if (strcmp(nodeName, "JointGroove") == 0) {
            object = parseJointGroove(parent, ele);
        } else if (strcmp(nodeName, "JointLimit") == 0) {
            object = parseJointLimit(parent, ele);
        } else if (strcmp(nodeName, "JointMotor") == 0) {
            object = parseJointMotor(parent, ele);
        } else if (strcmp(nodeName, "JointPin") == 0) {
            object = parseJointPin(parent, ele);
        } else if (strcmp(nodeName, "JointRatchet") == 0) {
            object = parseJointRatchet(parent, ele);
        } else if (strcmp(nodeName, "JointRotaryLimit") == 0) {
            object = parseJointRotaryLimit(parent, ele);
        } else if (strcmp(nodeName, "JointRotarySpring") == 0) {
            object = parseJointRotarySpring(parent, ele);
        } else if (strcmp(nodeName, "JointSpring") == 0) {
            object = parseJointSpring(parent, ele);
        } else if (strcmp(nodeName, "KeyFrame") == 0) {
            object = parseKeyFrame(parent, ele);
        } else if (strcmp(nodeName, "CCEReader") == 0) {
            object = parseCCEReader(parent, ele);
		}else if(strcmp(nodeName, "ParallaxNode") == 0){
			object = parseParallaxNode(parent, ele);
		}else if(strcmp(nodeName, "IncludeNode") == 0){
			object = parseIncludeNode(parent, ele);
		}else if(strcmp(nodeName, "Include") == 0){
			object = parseInclude(parent, ele);
		}else if(strcmp(nodeName, "Channel") == 0){
			object = parseChannel(parent, ele);
		}else if(strcmp(nodeName, "EventHandler") == 0){
			object = parseEventHandler(parent, ele);
		}else if(strcmp(nodeName, "KeyboardEvent") == 0){
			object = parseKeyboardEvent(parent, ele);
		}
		else if(strcmp(nodeName, "Action") == 0){
			object = parseEventAction(parent, ele);
		}else if(strcmp(nodeName, "ActionScene") == 0){
			object = parseEventActionScene(parent, ele);
		}else if(strcmp(nodeName, "RichText") == 0){
			object = parseRichText(parent, ele);
		}else if(strcmp(nodeName, "RichTextElement") == 0){
			object = parseRichTextElement(parent, ele);
		}else if(strcmp(nodeName, "ClippingNode") == 0){
			object = parseClippingNode(parent, ele);
		}else if(strcmp(nodeName, "ClippingStencil") == 0){
			object = parseClippingStencil(parent, ele);
		}else if(strcmp(nodeName, "DrawNode") == 0){
			object = parseDrawNode(parent, ele);
		}else if(strcmp(nodeName, "DrawLine") == 0){
			object = parseDrawLine(parent, ele);
		}else if(strcmp(nodeName, "DrawPoint") == 0){
			object = parseDrawPoint(parent, ele);
		}else if(strcmp(nodeName, "DrawRect") == 0){
			object = parseDrawRect(parent, ele);
		}else if(strcmp(nodeName, "DrawCircle") == 0){
			object = parseDrawCircle(parent, ele);
		}else if(strcmp(nodeName, "DrawDot") == 0){
			object = parseDrawDot(parent, ele);
		}else if(strcmp(nodeName, "DrawSegment") == 0){
			object = parseDrawSegment(parent, ele);
		}else if(strcmp(nodeName, "ProgressTimer") == 0){
			object = parseProgressTimer(parent, ele);
		}

        tinyxml2::XMLElement *child = ele->FirstChildElement();
        while (child) {
            parse(object, child);
			child = child->NextSiblingElement();
        }

        if (object) {
			Ref *ref = (Ref *) object;
			return ref;
           
        } else {
            return NULL;
        }
    }

	DrawNode *CCEReader::parseDrawNode(void *parent, tinyxml2::XMLElement *ele){
		auto node =  DrawNode::create();
		log("parseDrawNode");
			const tinyxml2::XMLAttribute *attr = ele->FirstAttribute();
			while (attr) {
				if (strcmp(attr->Name(), "alpha") == 0) {
					//node->setAlphaThreshold(attr->FloatValue());
				} else {
					parseNodeAttribute(parent,node,ele, attr);
				}
				attr = attr->Next();
			}
			
			addChildNode(parent,node,ele);

			return node;
	}

	Node *CCEReader::parseClippingStencil(void *parent, tinyxml2::XMLElement *ele){
		auto node =  Node::create();

		ClippingNode *parentNode = (ClippingNode*)parent;
		parentNode->setStencil(node);

		return node;
	}

	ClippingNode *CCEReader::parseClippingNode(void *parent, tinyxml2::XMLElement *ele){
			auto node =  ClippingNode::create();

			const tinyxml2::XMLAttribute *attr = ele->FirstAttribute();
			while (attr) {
				if (strcmp(attr->Name(), "alphaThreshold") == 0) {
					node->setAlphaThreshold(attr->FloatValue());
				}else if (strcmp(attr->Name(), "inverted") == 0) {
					node->setInverted(attr->BoolValue());
				}
				else {
					parseNodeAttribute(parent,node,ele, attr);
				}
				attr = attr->Next();
			}

			addChildNode(parent,node,ele);

			return node;
	}

	Node *CCEReader::parseDrawLine(void *parent, tinyxml2::XMLElement *ele){
		 Ref *ref = (Ref*)parent;
		 DrawNode *drawNode = dynamic_cast<DrawNode *> (ref);
		 if(drawNode==NULL){
			return NULL;
		 }
		 float fromX = ele->FloatAttribute("fromX");
		 float fromY = ele->FloatAttribute("fromY");
		 
		 float toX = ele->FloatAttribute("toX");
		 float toY = ele->FloatAttribute("toY");
		 
		 const char * color = ele->Attribute("color");
		 if(color==NULL){
			 color="#FF000000";
		 }
		 Color4F color4F = getColor4F(color);
   	     drawNode->drawLine(Vec2(fromX,fromY), Vec2(toX,toY),color4F);
	 return drawNode;
	}

	Node *CCEReader::parseDrawRect(void *parent, tinyxml2::XMLElement *ele){
		 Ref *ref = (Ref*)parent;
		 DrawNode *drawNode = dynamic_cast<DrawNode *> (ref);
		 if(drawNode==NULL){
			return NULL;
		 }
		 float fromX = ele->FloatAttribute("fromX");
		 float fromY = ele->FloatAttribute("fromY");
		 
		 float toX = ele->FloatAttribute("toX");
		 float toY = ele->FloatAttribute("toY");
		 
		 const char * color = ele->Attribute("color");
		 if(color==NULL){
			 color="#FF000000";
		 }
		 Color4F color4F = getColor4F(color);
   	     drawNode->drawRect(Vec2(fromX,fromY), Vec2(toX,toY),color4F);
	 return drawNode;
	}

	Node *CCEReader::parseDrawCircle(void *parent, tinyxml2::XMLElement *ele){
		 Ref *ref = (Ref*)parent;
		 DrawNode *drawNode = dynamic_cast<DrawNode *> (ref);
		 if(drawNode==NULL){
			return NULL;
		 }
		 float fromX = ele->FloatAttribute("positionX");
		 float fromY = ele->FloatAttribute("positionY");
		 
		 float radius = ele->FloatAttribute("radius");
		  float angle = ele->FloatAttribute("angle");
		 float scaleX = ele->FloatAttribute("scaleX");
		 float scaleY = ele->FloatAttribute("scaleY");
		 int segments = ele->IntAttribute("segments");
		 bool linceToCenter = ele->BoolAttribute("linceToCenter");
		 
		 const char * color = ele->Attribute("color");
		 if(color==NULL){
			 color="#FF000000";
		 }
		 Color4F color4F = getColor4F(color);
   	     drawNode->drawCircle(Vec2(fromX,fromY),radius,angle,segments,linceToCenter,scaleX,scaleY,color4F);

		// auto s = Director::getInstance()->getWinSize();
		//drawNode->drawSegment(Vec2(10,s.height/2), Vec2(s.width/2, s.height/2), 40, Color4F(1, 0, 1, 0.5));
		
		//drawNode->drawDot(Vec2(s.width/2, s.height/2), 10*(10-0), Color4F(CCRANDOM_0_1(), CCRANDOM_0_1(), CCRANDOM_0_1(), 1));

	 return drawNode;
	}

	Node *CCEReader::parseDrawSegment(void *parent, tinyxml2::XMLElement *ele){
		 Ref *ref = (Ref*)parent;
		 DrawNode *drawNode = dynamic_cast<DrawNode *> (ref);
		 if(drawNode==NULL){
			return NULL;
		 }
		 float fromX = ele->FloatAttribute("fromX");
		 float fromY = ele->FloatAttribute("fromY");
		 
		 float toX = ele->FloatAttribute("toX");
		 float toY = ele->FloatAttribute("toY");

		 float radius = ele->FloatAttribute("radius");
		 
		 const char * color = ele->Attribute("color");
		 if(color==NULL){
			 color="#FF000000";
		 }
		 Color4F color4F = getColor4F(color);
   	     drawNode->drawSegment(Vec2(fromX,fromY), Vec2(toX,toY),radius,color4F);
	 return drawNode;
	}

	Node *CCEReader::parseDrawDot(void *parent, tinyxml2::XMLElement *ele){
		 Ref *ref = (Ref*)parent;
		 DrawNode *drawNode = dynamic_cast<DrawNode *> (ref);
		 if(drawNode==NULL){
			return NULL;
		 }
		 float fromX = ele->FloatAttribute("positionX");
		 float fromY = ele->FloatAttribute("positionY");
		 
		 float radius = ele->FloatAttribute("radius");
		 
		 const char * color = ele->Attribute("color");
		 if(color==NULL){
			 color="#FF000000";
		 }
		 Color4F color4F = getColor4F(color);
   	     drawNode->drawDot(Vec2(fromX,fromY), radius,color4F);
	 return drawNode;
	}

	Node *CCEReader::parseDrawPoint(void *parent, tinyxml2::XMLElement *ele){
		Ref *ref = (Ref*)parent;
		 DrawNode *drawNode = dynamic_cast<DrawNode *> (ref);
		 if(drawNode==NULL){
			return NULL;
		 }
		 float fromX = ele->FloatAttribute("positionX");
		 float fromY = ele->FloatAttribute("positionY");
		 
		 float pointSize = ele->FloatAttribute("pointSize");
	
		 const char * color = ele->Attribute("color");
		 if(color==NULL){
			 color="#FF000000";
		 }
		 Color4F color4F = getColor4F(color);
   	     drawNode->drawPoint(Vec2(fromX,fromY), pointSize,color4F);
		 return drawNode;
	}

	Node *CCEReader::parseCCEReader(void *parent, tinyxml2::XMLElement *ele){
		const char* src = ele->Attribute("src");
		if(src){
			CCEReader *reader= CCEReader::create();
			nodeReaders.pushBack(reader);
		    Node *node = (Node *)reader->read(src);
			int tag = ele->IntAttribute("tag");
			if(tag>0){
				nodes[tag]=node;
			}
			const tinyxml2::XMLAttribute *attr = ele->FirstAttribute();
			while (attr) {
				parseNodeAttribute(parent,node,ele, attr);
				attr = attr->Next();
			}

			addChildNode(parent,node,ele);
			return node;
		}
		return NULL;
	}

    Scene *CCEReader::parseScene(void *parent, tinyxml2::XMLElement *ele) {

        Scene *scene = ele->BoolAttribute("physicsWorld") ? Scene::createWithPhysics() : Scene::create();
		bool resolutionPolicyEnable = ele->BoolAttribute("resolutionPolicyEnable");
		if(resolutionPolicyEnable){
			int dWith = ele->IntAttribute("designWidth");
			int dHeight = ele->IntAttribute("designHeight");
			const char * resolutionPolicy= ele->Attribute("resolutionPolicy");
			
			if(equals(resolutionPolicy,"EXACT_FIT")){
				Director::getInstance()->getOpenGLView()->setDesignResolutionSize(dWith,dHeight,ResolutionPolicy::EXACT_FIT);
			}else if(equals(resolutionPolicy,"NO_BORDER")){
				Director::getInstance()->getOpenGLView()->setDesignResolutionSize(dWith,dHeight,ResolutionPolicy::NO_BORDER);
			}else if(equals(resolutionPolicy,"SHOW_ALL")){
				Director::getInstance()->getOpenGLView()->setDesignResolutionSize(dWith,dHeight,ResolutionPolicy::SHOW_ALL);
			}else if(equals(resolutionPolicy,"FIXED_HEIGHT")){
				Director::getInstance()->getOpenGLView()->setDesignResolutionSize(dWith,dHeight,ResolutionPolicy::FIXED_HEIGHT);
			}else if(equals(resolutionPolicy,"FIXED_WIDTH")){
				Director::getInstance()->getOpenGLView()->setDesignResolutionSize(dWith,dHeight,ResolutionPolicy::FIXED_WIDTH);
			}else {
				Director::getInstance()->getOpenGLView()->setDesignResolutionSize(dWith,dHeight,ResolutionPolicy::UNKNOWN);
			}
		}
        const tinyxml2::XMLAttribute *attr = ele->FirstAttribute();
        while (attr) {
            if (strcmp(attr->Name(), "physicsDebug") == 0) {
                const char *debug = attr->Value();
                if (strcmp(debug, "None") == 0) {
                    scene->getPhysicsWorld()->setDebugDrawMask(PhysicsWorld::DEBUGDRAW_NONE);
                } else if (strcmp(debug, "Shape") == 0) {
                    scene->getPhysicsWorld()->setDebugDrawMask(PhysicsWorld::DEBUGDRAW_SHAPE);
                } else if (strcmp(debug, "Joint") == 0) {
                    scene->getPhysicsWorld()->setDebugDrawMask(PhysicsWorld::DEBUGDRAW_JOINT);
                } else if (strcmp(debug, "Contact") == 0) {
                    scene->getPhysicsWorld()->setDebugDrawMask(PhysicsWorld::DEBUGDRAW_CONTACT);
                } else if (strcmp(debug, "All") == 0) {
                    scene->getPhysicsWorld()->setDebugDrawMask(PhysicsWorld::DEBUGDRAW_ALL);
                }
            } else {
                parseNodeAttribute(parent,scene,ele, attr);
            }
            attr = attr->Next();
        }

        return scene;
    }

	ProgressTimer *CCEReader::parseProgressTimer(void *parent, tinyxml2::XMLElement *ele){
		/*
	  const char * spriteName =	ele->Attribute("sprite");
	  if(spriteName==NULL){
		return NULL;
	  }
	  Ref *ref = (Ref*)nameNodes[spriteName];
	  Sprite *sprite = dynamic_cast<Sprite*>(ref); 
	  if(sprite==NULL){
	   return NULL;
	  }*/
	  ProgressTimer *timer = ProgressTimer::create(NULL);
	  
	  float mx = ele->FloatAttribute("midpointX");
	  float my = ele->FloatAttribute("midpointY");

	  timer->setMidpoint(Vec2(mx,my));
	
	  float bx = ele->FloatAttribute("barChangeRateX");
	  float by = ele->FloatAttribute("barChangeRateY");
	  timer->setBarChangeRate(Vec2(bx,by));

	  const tinyxml2::XMLAttribute *attr = ele->FirstAttribute();
	  while (attr) {
            const char *attsKey = attr->Name();
			if (strcmp(attr->Name(), "type") == 0) {
				if(equals(attr->Value(),"Radial")){
					timer->setType(ProgressTimer::Type::RADIAL);
				}else if(equals(attr->Value(),"Bar")){
					timer->setType(ProgressTimer::Type::BAR);
				}else if(equals(attr->Value(),"percentage")){
					timer->setPercentage(attr->IntValue());
				}else if(equals(attr->Value(),"reverseDirection")){
					timer->setReverseDirection(attr->BoolValue());
				}
			} 
			parseNodeAttribute(parent,timer,ele, attr);
            attr = attr->Next();
      }
	  addChildNode(parent,timer,ele);
	  return timer;
	}

    Layer *CCEReader::parseLayer(void *parent, tinyxml2::XMLElement *ele) {
        Layer *node = Layer::create();
        const tinyxml2::XMLAttribute *attr = ele->FirstAttribute();
        
		float width=0,height=0;
		while (attr) {
            /*const char *attsKey = attr->Name();
			if (strcmp(attr->Name(), "width") == 0) {
				width = attr->FloatValue();
			}   else if (strcmp(attr->Name(), "height") == 0) {
				height = attr->FloatValue();
			} */ 
			parseLayerAttribute(parent,node,ele, attr);
            attr = attr->Next();
        }
        Node *parentNode = (Node *) parent;

		/*if(width>0 || height>0){
			width = getSizeWidth(parentNode,ele,width);
			height = getSizeHeight(parentNode,ele,height);
			node->setContentSize(Size(width,height));
		}*/
        if (parentNode) {
            parentNode->addChild(node);
        }
        return node;
    }

    Component *CCEReader::parseComponent(void *parent, tinyxml2::XMLElement *ele) {
        Node *parentNode = (Node *) parent;
        if (!parentNode) {
            return NULL;
        }
       
        const tinyxml2::XMLAttribute *attr = ele->FirstAttribute();
        const char *name;
        const char *type;
        while (attr) {
            if (strcmp(attr->Name(), "name") == 0) {
                name = attr->Value();
            } else if (strcmp(attr->Name(), "type") == 0) {
                type = attr->Value();
            }
            attr = attr->Next();
        }

		  auto iter = components.find(name);
		  if (iter != components.end()){
			  cocos2d::Vector<Node*> nodes = iter->second;
			  nodes.pushBack(parentNode);
			  iter->second=nodes;
			  //components.insert(std::pair<std::string, cocos2d::Vector<Node *>>(name, nodes));
		  }else{
			cocos2d::Vector<Node*> nodes;
			nodes.pushBack(parentNode);
			components.insert(std::pair<std::string, cocos2d::Vector<Node *>>(name, nodes));
		  }

    }

    Node *CCEReader::parseNode(void *parent, tinyxml2::XMLElement *ele) {
        Node *node = Node::create();
        const tinyxml2::XMLAttribute *attr = ele->FirstAttribute();
        while (attr) {
            parseNodeAttribute(parent,node, ele,attr);
            attr = attr->Next();
        }
		addChildNode(parent,node,ele);
        return node;
    }

	 Node *CCEReader::parseInclude(void *parent, tinyxml2::XMLElement *ele) {
       
        const tinyxml2::XMLAttribute *attr = ele->FirstAttribute();
        const char *src;
		while (attr) {
			if (strcmp(attr->Name(), "src") == 0) {
                src = attr->Value();
            }
			attr = attr->Next();
        }
		if(src){
		   Node *includeNode  = (Node*)read(parent,src);
		   //addChildNode(parent,includeNode,ele);
		   return includeNode;
		}
		
        return NULL;
    }

	  Node *CCEReader::parseIncludeNode(void *parent, tinyxml2::XMLElement *ele) {
        Node *node = Node::create();
        const tinyxml2::XMLAttribute *attr = ele->FirstAttribute();
        const char *src;
		while (attr) {
			if (strcmp(attr->Name(), "src") == 0) {
                src = attr->Value();
            }else{
				parseNodeAttribute(parent,node, ele,attr);
			}
			attr = attr->Next();
        }
		if(src){
			Node *parentNode = (Node *) parent;
			if(parentNode){
				node->setContentSize(parentNode->getContentSize());
				Node *includeNode  = (Node*)read(node,src);
			}
		}

		addChildNode(parent,node,ele);
        return node;
    }

	void CCEReader::addChildNode(void *parent,Node * node,tinyxml2::XMLElement *ele){
		   
		Node *parentNode = (Node *) parent;
		if (parentNode != NULL) {
			ParallaxNode *parallaxNode =dynamic_cast<ParallaxNode*> (parentNode);
			if(parallaxNode!=NULL){
				Vec2 ratio;
				Vec2 offset;
				ratio.x = ele->FloatAttribute("xRatio");
				ratio.y = ele->FloatAttribute("yRatio");
				offset.x = ele->FloatAttribute("offsetX");
				offset.y= ele->FloatAttribute("offsetY");
				
				parallaxNode->addChild(node,parallaxNode->getChildrenCount()+1,ratio,node->getPosition());
			}else{

				ProgressTimer *timer =dynamic_cast<ProgressTimer*> (parentNode);
				Sprite *sprite =dynamic_cast<Sprite*> (node);
				if(timer!=NULL && sprite!=NULL){
					timer->setSprite(sprite);
				}else{
					parentNode->addChild(node);
				}
				
			}
		}
	}

	ParallaxNode *CCEReader::parseParallaxNode(void *parent, tinyxml2::XMLElement *ele){
		ParallaxNode *node = ParallaxNode::create();
        const tinyxml2::XMLAttribute *attr = ele->FirstAttribute();
        while (attr) {
            parseNodeAttribute(parent,node,ele, attr);
            attr = attr->Next();
        }
		addChildNode(parent,node,ele);
        return node;
	}

    cce::CCEAnimation *CCEReader::parseAnimation(void *parent, tinyxml2::XMLElement *ele) {
		cce::CCEAnimation *anmiation =  cce::CCEAnimation::create();

        const tinyxml2::XMLAttribute *attr = ele->FirstAttribute();
        while (attr) {
            if (strcmp(attr->Name(), "name") == 0) {
                anmiation->setName(attr->Value());
				nameNodes[attr->Value()]=anmiation;
            } else if (strcmp(attr->Name(), "tag") == 0) {
                anmiation->setActionTag(attr->IntValue());
				nodes[attr->IntValue()]=anmiation;
            } else if (strcmp(attr->Name(), "main") == 0) {
				anmiation->setMain(equals("true",attr->Value()));
            }
			else if (strcmp(attr->Name(), "unitTime") == 0) {
                anmiation->setUnitTime(attr->FloatValue());
            }else if (strcmp(attr->Name(), "loop") == 0) {
				anmiation->setLoop(attr->IntValue());
            }else if (strcmp(attr->Name(), "auto") == 0) {
				anmiation->setAutoRun(attr->BoolValue());
            }else if (strcmp(attr->Name(), "next") == 0) {
				anmiation->setNext(attr->Value());
            }else if (strcmp(attr->Name(), "delay") == 0) {
				anmiation->setDelay(attr->FloatValue());
            }else if (strcmp(attr->Name(), "duration") == 0) {
				anmiation->setDuration(attr->FloatValue());
            }
            attr = attr->Next();
        }
        Node *node = (Node *) parent;
        if (node != NULL) {
            anmiation->setObject(node);
        }

        animationManager->addAnimation(anmiation);

        return anmiation;
    }

	cce::CCEChannel * CCEReader::parseChannel(void *parent, tinyxml2::XMLElement *ele){
		cce::CCEAnimation *nodeAnimation = (cce::CCEAnimation *)parent;
		if(!nodeAnimation){
			return NULL;
		}
		CCEChannel *channel =  CCEChannel::create();
		channel->setNode(nodeAnimation->getActionNode());
		nodeAnimation->addChannel(channel);
		
		int loop =ele->Attribute("loop")?ele->IntAttribute("loop"):nodeAnimation->getLoop();
		float unitTime =ele->Attribute("unitTime")? ele->FloatAttribute("unitTime"):nodeAnimation->getUnitTime();
		channel->setDelay(ele->FloatAttribute("delay"));
		channel->setLoop(loop);
		channel->setUnitTime(unitTime);
		channel->setType(ele->Attribute("type"));
		
		return channel;
	}

	cce::CCEEventHandler *CCEReader::parseKeyboardEvent(void *parent, tinyxml2::XMLElement *ele){
		Ref * parentNode = (Ref*)(parent);
		CCEEventHandler * eventHandler = dynamic_cast<CCEEventHandler*>(parentNode);
		if(eventHandler!=NULL){
			const char * eventName=ele->Attribute("name");
			const char * keyCode=ele->Attribute("keyCode");
			if(eventName==NULL||keyCode==NULL){
				return eventHandler;
			}
			eventHandler->eventName=eventName;
			eventHandler->eventArg = keyCode;
			eventHandler->handleNodeEvent(eventHandler->getNode(),eventName);
		}
		return eventHandler;
	}


	cce::CCEEventHandler *CCEReader::parseEventHandler(void *parent, tinyxml2::XMLElement *ele){
		
		/*tinyxml2::XMLElement *pNode = (tinyxml2::XMLElement*)ele->Parent();
		const char *pName =  pNode->Name();
		
		if(strcmp(pName, "Animation") == 0){
			
		}*/

		Ref * parentNode = (Ref*)(parent);
		
			/*Node * node = dynamic_cast<Node*>(parentNode);
			CCEAnimation *animation = (CCEAnimation*)parent;
			if(animation!=NULL){
				parentNode = (Node*)animation->getObject();
			}*/
		
		const char * eventName=ele->Attribute("event");
		const char * action=ele->Attribute("action");
		const char * actionTarget=ele->Attribute("target");
		float delay = ele->FloatAttribute("delay");
		if(actionTarget==NULL){
				actionTarget="";
		}
		if(eventName==NULL){
			eventName="";
		}
		CCEEventHandler *eventHandler =  CCEEventHandler::create();
		
		eventHandler->handleNodeEvent(parentNode,eventName);
		
		if(action!=NULL){
			CCEEventAction *actionObj =   CCEEventAction::create(action,actionTarget,delay);
			actionObj->reader = this;
			eventHandler->addAction(actionObj);
		}
		
		eventHandlers.pushBack(eventHandler);
		return eventHandler;
	}

	cce::CCEEventAction *CCEReader::parseEventActionScene(void *parent, tinyxml2::XMLElement *ele){
		CCEEventHandler * eventHandler = (CCEEventHandler*)parent;
		if(eventHandler==NULL){
			return NULL;
		}
		const char * action=ele->Attribute("name");
		const char * actionTarget=ele->Attribute("target");
		const char * transition=ele->Attribute("transition");
		float delay = ele->FloatAttribute("delay");
		float duration = ele->FloatAttribute("duration");
		if(action==NULL){
			return NULL;
		}
		if(actionTarget==NULL){
			actionTarget="";
		}
		std::string actionTargets=actionTarget;
		if(transition!=NULL){
			actionTargets.append(" ");
			actionTargets.append(transition);
			if(duration>0){
				actionTargets.append(" ");
				actionTargets.append(ele->Attribute("duration"));
			}
		}
		CCEEventAction *actionObj =  CCEEventAction::create(action,actionTargets,delay);
		actionObj->reader = this;

		eventHandler->addAction(actionObj);
	}

	cce::CCEEventAction *CCEReader::parseEventAction(void *parent, tinyxml2::XMLElement *ele){
		CCEEventHandler * eventHandler = (CCEEventHandler*)parent;
		if(eventHandler==NULL){
			return NULL;
		}
		const char * action=ele->Attribute("name");
		const char * actionTarget=ele->Attribute("target");
		float delay = ele->FloatAttribute("delay");
		if(action==NULL){
			return NULL;
		}
		if(actionTarget==NULL){
			actionTarget="";
		}

		CCEEventAction *actionObj =  CCEEventAction::create(action,actionTarget,delay);
		actionObj->reader = this;

		eventHandler->addAction(actionObj);
	}

	FrameEaseType geteasingType(const char* easing){
		if(equals(easing,"LINERAR")){
		  return FrameEaseType::LINERAR;
		}else if(equals(easing,"INSTANT")){
		  return FrameEaseType::INSTANT;
		}
		else if(equals(easing,"SINE_EASEIN")){
		  return FrameEaseType::SINE_EASEIN;
		}else if(equals(easing,"SINE_EASEOUT")){
		  return FrameEaseType::SINE_EASEOUT;
		}else if(equals(easing,"SINE_EASEINOUT")){
		 return FrameEaseType::SINE_EASEINOUT;
		}else if(equals(easing,"QUAD_EASEIN")){
		  return FrameEaseType::QUAD_EASEIN;
		}else if(equals(easing,"QUAD_EASEOUT")){
		  return FrameEaseType::QUAD_EASEOUT;
		}else if(equals(easing,"QUAD_EASEINOUT")){
		  return FrameEaseType::QUAD_EASEINOUT;
		}else if(equals(easing,"CUBIC_EASEIN")){
		  return FrameEaseType::CUBIC_EASEIN;
		}else if(equals(easing,"CUBIC_EASEOUT")){
		  return FrameEaseType::CUBIC_EASEOUT;
		}else if(equals(easing,"CUBIC_EASEINOUT")){
		  return FrameEaseType::CUBIC_EASEINOUT;
		}else if(equals(easing,"QUINT_EASEIN")){
		  return FrameEaseType::QUINT_EASEIN;
		}else if(equals(easing,"QUINT_EASEOUT")){
		  return FrameEaseType::QUINT_EASEOUT;
		}else if(equals(easing,"QUINT_EASEINOUT")){
		  return FrameEaseType::QUINT_EASEINOUT;
		}else if(equals(easing,"EXPO_EASEIN")){
		  return FrameEaseType::EXPO_EASEIN;
		}else if(equals(easing,"EXPO_EASEOUT")){
		  return FrameEaseType::EXPO_EASEOUT;
		}else if(equals(easing,"EXPO_EASEINOUT")){
		 return FrameEaseType::EXPO_EASEINOUT;
		}else if(equals(easing,"CIRC_EASEIN")){
		  return FrameEaseType::CIRC_EASEIN;
		}else if(equals(easing,"CIRC_EASEOUT")){
		  return FrameEaseType::CIRC_EASEOUT;
		}else if(equals(easing,"CIRC_EASEINOUT")){
		  return FrameEaseType::CIRC_EASEINOUT;
		}else if(equals(easing,"ELASTIC_EASEIN")){
		  return FrameEaseType::ELASTIC_EASEIN;
		}else if(equals(easing,"ELASTIC_EASEOUT")){
		  return FrameEaseType::ELASTIC_EASEOUT;
		}else if(equals(easing,"ELASTIC_EASEINOUT")){
		  return FrameEaseType::ELASTIC_EASEINOUT;
		}else if(equals(easing,"BACK_EASEIN")){
		  return FrameEaseType::BACK_EASEIN;
		}else if(equals(easing,"BACK_EASEOUT")){
		  return FrameEaseType::BACK_EASEOUT;
		}else if(equals(easing,"BACK_EASEINOUT")){
		  return FrameEaseType::BACK_EASEINOUT;
		}else if(equals(easing,"BOUNCE_EASEIN")){
		  return FrameEaseType::BOUNCE_EASEIN;
		}else if(equals(easing,"BOUNCE_EASEOUT")){
		  return FrameEaseType::BOUNCE_EASEOUT;
		}else if(equals(easing,"BOUNCE_EASEINOUT")){
		  return FrameEaseType::BOUNCE_EASEINOUT;
		}
	}

	cce::CCEKeyFrame *CCEReader::parseChannelKeyFrame(void *parent, tinyxml2::XMLElement *ele) {
		cce::CCEChannel *channel = (cce::CCEChannel *) parent;
		if(channel==NULL){
		  return NULL;
		}
		std::string type = channel->getType();
	    int easing = (int)geteasingType(ele->Attribute("easing"));
        int index = ele->Attribute("index")?ele->IntAttribute("index"):-1;

		if(type=="Position"||type=="MoveBy"||type=="MoveTo"||type=="BezierTo"||type=="BezierBy"||type=="SplineTo"||type=="SplineBy"){
		    float positionX = ele->FloatAttribute("positionX");
            float positionY = ele->FloatAttribute("positionY");
			positionX = getPositionXValue(channel->getNode()->getParent(),channel->getNode(),ele,positionX);
			positionY = getPositionYValue(channel->getNode()->getParent(),channel->getNode(),ele,positionY);
			cce::ActionMoveFrame *KeyFrame = new cce::ActionMoveFrame();
            KeyFrame->setPosition(Vec2(positionX, positionY));
            KeyFrame->setFrameIndex(index);
            KeyFrame->setEasingType(easing);
            channel->addFrame(KeyFrame);
		}else if(type=="Scale"||type=="ScaleBy"||type=="ScaleTo"){
		    float scaleX = ele->FloatAttribute("scaleX");
            float scaleY = ele->FloatAttribute("scaleY");
            cce::ActionScaleFrame *KeyFrame = new cce::ActionScaleFrame();
            KeyFrame->setScaleX(scaleX);
            KeyFrame->setScaleY(scaleY);
            KeyFrame->setFrameIndex(index);
            KeyFrame->setEasingType(easing);
            channel->addFrame(KeyFrame);
		}else if(type=="Rotation"||type=="RotationBy"||type=="RotationTo"){
		    float rotation = ele->FloatAttribute("rotation");
            cce::ActionRotationFrame *KeyFrame = new cce::ActionRotationFrame();
            KeyFrame->setRotation(rotation);
            KeyFrame->setFrameIndex(index);
            KeyFrame->setEasingType(easing);
            channel->addFrame(KeyFrame);
		}else if(type=="Opacity"){
		    float opacity = ele->FloatAttribute("opacity");
            cce::ActionFadeFrame *KeyFrame = new cce::ActionFadeFrame();
            KeyFrame->setOpacity(opacity);
           KeyFrame->setFrameIndex(index);
            KeyFrame->setEasingType(easing);
            channel->addFrame(KeyFrame);
		}else if(type=="Color"){
		    cce::ActionTintFrame *KeyFrame = new cce::ActionTintFrame();
			KeyFrame->setColor(getColor3B(ele->Attribute("color")));
            KeyFrame->setFrameIndex(index);
            KeyFrame->setEasingType(easing);
            channel->addFrame(KeyFrame);
		}else if(type=="Sprite"){
			const char *texture = ele->Attribute("texture");
		    //SpriteFrame *sp =	getSpriteFrame(texture);
		    if(texture!=NULL){
            cce::SpriteNodeFrame *KeyFrame = new cce::SpriteNodeFrame();
			KeyFrame->setFrameType(kKeyframeSprite);
            //KeyFrame->setSpriteFrame(sp);
			KeyFrame->setFrameIndex(index);
            KeyFrame->setEasingType(easing);
			KeyFrame->setTexture(texture);
			channel->addFrame(KeyFrame);
		   }else{
		     log("Can't find resource %s",texture);
		   }
		}else if(type=="Effect"){
			const char *effect = ele->Attribute("effect");
			 if(effect==NULL){
				 return NULL;
			   }
		    cce::EffectFrame *KeyFrame = new cce::EffectFrame();
		    KeyFrame->setEffect(effect);
			KeyFrame->setFrameIndex(index);
            KeyFrame->setEasingType(easing);
			channel->addFrame(KeyFrame);
		}else if(type=="Music"){
		   const char *music = ele->Attribute("music");
		   if(music==NULL){
			 return NULL;
		   }
		   int time = ele->Attribute("duration")?ele->IntAttribute("duration"):0;
		   cce::MusicFrame *KeyFrame = new cce::MusicFrame();
		   KeyFrame->setMusic(music);
		   KeyFrame->setTime(time);
		   KeyFrame->setFrameIndex(index);
           KeyFrame->setEasingType(easing);
		   channel->addFrame(KeyFrame);
		}else if(type=="Callback"){
		   const char *callback = ele->Attribute("callback");
		   if(callback==NULL){
			return NULL;
		   }
		   const char *callbackArg = ele->Attribute("callbackArg");
		   if(callbackArg==NULL){
				callbackArg="";
		   }
		   cce::CallbackFrame *KeyFrame = new cce::CallbackFrame();
		   CallbackAction *callbackAction=  CallbackAction::create();
		   callbackAction->manager=this->animationManager;
		   callbackAction->callback = callback;
		   callbackAction->callbackArg = callbackArg;
		   KeyFrame->setCallback(callbackAction);
		   KeyFrame->setFrameIndex(index);
           KeyFrame->setEasingType(easing);
		   channel->addFrame(KeyFrame);
		}else if(type=="Visible"){
		   bool visible = ele->BoolAttribute("visible");
		   cce::VisibleFrame *KeyFrame = new cce::VisibleFrame();
		   KeyFrame->setVisible(visible);
		   KeyFrame->setFrameIndex(index);
           KeyFrame->setEasingType(easing);
		   channel->addFrame(KeyFrame);
		}else if(type=="Flip"){
		   bool flipX = ele->BoolAttribute("flipX");
		   bool flipY = ele->BoolAttribute("flipY");
		   cce::FlipFrame *keyFrame = new cce::FlipFrame();
		   keyFrame->setFlipX(flipX);
		   keyFrame->setFlipY(flipY);
		   keyFrame->setFrameIndex(index);
           keyFrame->setEasingType(easing);
		   channel->addFrame(keyFrame);
		}
		else if(type=="ZOrder"){
		   int zorder = ele->IntAttribute("zorder");
		   cce::ZOrderFrame *KeyFrame = new cce::ZOrderFrame();
		   KeyFrame->setZOrder(zorder);
		   KeyFrame->setFrameIndex(index);
           KeyFrame->setEasingType(easing);
		   channel->addFrame(KeyFrame);
		}else if(type=="Progress"){
		   float percent = ele->FloatAttribute("percent");
		 
		   cce::ProgressFrame *KeyFrame = new cce::ProgressFrame();
		   KeyFrame->setPercent(percent);
		   KeyFrame->setFrameIndex(index);
           KeyFrame->setEasingType(easing);
		   channel->addFrame(KeyFrame);
		}
	}

    cce::CCEKeyFrame *CCEReader::parseKeyFrame(void *parent, tinyxml2::XMLElement *ele) {
		tinyxml2::XMLElement *pNode = (tinyxml2::XMLElement*)ele->Parent();
		const char *pName =  pNode->Name();
		
		if(strcmp(pName, "Channel") == 0){
			return parseChannelKeyFrame(parent,ele);
		}
		cce::CCEAnimation *keyFrameAnimation = (cce::CCEAnimation *) parent;
		if(keyFrameAnimation==NULL){
			return NULL;
		}
        int easing = (int)geteasingType(ele->Attribute("easing"));
        int index = ele->Attribute("index")?ele->IntAttribute("index"):-1;
        if (ele->Attribute("positionX") && ele->Attribute("positionY")) {
            float positionX = ele->FloatAttribute("positionX");
            float positionY = ele->FloatAttribute("positionY");
			positionX = getPositionXValue(keyFrameAnimation->getActionNode()->getParent(),keyFrameAnimation->getActionNode(),ele,positionX);
			positionY = getPositionYValue(keyFrameAnimation->getActionNode()->getParent(),keyFrameAnimation->getActionNode(),ele,positionY);
			cce::ActionMoveFrame *KeyFrame = new cce::ActionMoveFrame();
            KeyFrame->setPosition(Vec2(positionX, positionY));
            KeyFrame->setFrameIndex(index);
            KeyFrame->setEasingType(easing);
            keyFrameAnimation->getOrCreateChannel("MoveTo")->addFrame(KeyFrame);
        }
        if (ele->Attribute("scaleX") && ele->Attribute("scaleY")) {
            float scaleX = ele->FloatAttribute("scaleX");
            float scaleY = ele->FloatAttribute("scaleY");
            cce::ActionScaleFrame *KeyFrame = new cce::ActionScaleFrame();
            KeyFrame->setScaleX(scaleX);
            KeyFrame->setScaleY(scaleY);
            KeyFrame->setFrameIndex(index);
            KeyFrame->setEasingType(easing);
            keyFrameAnimation->getOrCreateChannel("Scale")->addFrame(KeyFrame);
        }
        if (ele->Attribute("rotation")) {
            float rotation = ele->FloatAttribute("rotation");
            cce::ActionRotationFrame *KeyFrame = new cce::ActionRotationFrame();
            KeyFrame->setRotation(rotation);
            KeyFrame->setFrameIndex(index);
            KeyFrame->setEasingType(easing);
            keyFrameAnimation->getOrCreateChannel("Rotation")->addFrame(KeyFrame);
        }
        if (ele->Attribute("opacity")) {
            float opacity = ele->FloatAttribute("opacity");
            cce::ActionFadeFrame *KeyFrame = new cce::ActionFadeFrame();
            KeyFrame->setOpacity(opacity);
           KeyFrame->setFrameIndex(index);
            KeyFrame->setEasingType(easing);
            keyFrameAnimation->getOrCreateChannel("Opacity")->addFrame(KeyFrame);
        }
        if (ele->Attribute("color")) {
            cce::ActionTintFrame *KeyFrame = new cce::ActionTintFrame();
			KeyFrame->setColor(getColor3B(ele->Attribute("color")));
            KeyFrame->setFrameIndex(index);
            KeyFrame->setEasingType(easing);
			keyFrameAnimation->getOrCreateChannel("Color")->addFrame(KeyFrame);
        }

		//log("add sprite frame index %d",index);

        if (ele->Attribute("texture")) {
           const char *texture = ele->Attribute("texture");
		    //log("add sprite frame %s",texture);
		   //SpriteFrame *sp =	getSpriteFrame(texture);
		   if(texture!=NULL){
            cce::SpriteNodeFrame *KeyFrame = new cce::SpriteNodeFrame();
			KeyFrame->setFrameType(kKeyframeSprite);
            //KeyFrame->setSpriteFrame(sp);
			KeyFrame->setFrameIndex(index);
            KeyFrame->setEasingType(easing);
			KeyFrame->setTexture(texture);
			keyFrameAnimation->getOrCreateChannel("Sprite")->addFrame(KeyFrame);
		   }else{
		     log("Can't find resource %s",texture);
		   }
        }

		if (ele->Attribute("effect")) {
           const char *effect = ele->Attribute("effect");
		  
		   cce::EffectFrame *KeyFrame = new cce::EffectFrame();
		   KeyFrame->setEffect(effect);
			KeyFrame->setFrameIndex(index);
            KeyFrame->setEasingType(easing);
			keyFrameAnimation->getOrCreateChannel("Effect")->addFrame(KeyFrame);
        }

		if (ele->Attribute("music")) {
           const char *music = ele->Attribute("music");
		   int time = ele->Attribute("duration")?ele->IntAttribute("duration"):0;
		   cce::MusicFrame *KeyFrame = new cce::MusicFrame();
		   KeyFrame->setMusic(music);
		   KeyFrame->setTime(time);
		   KeyFrame->setFrameIndex(index);
           KeyFrame->setEasingType(easing);
		   keyFrameAnimation->getOrCreateChannel("Music")->addFrame(KeyFrame);
        }

        if (ele->Attribute("callback")) {
           const char *callback = ele->Attribute("callback");
		  
		   cce::CallbackFrame *KeyFrame = new cce::CallbackFrame();
		   CallbackAction *callbackAction=  CallbackAction::create();
		   callbackAction->manager=this->animationManager;
		   callbackAction->callback = callback;
		   KeyFrame->setCallback(callbackAction);
		   KeyFrame->setFrameIndex(index);
           KeyFrame->setEasingType(easing);
		   keyFrameAnimation->getOrCreateChannel("Callback")->addFrame(KeyFrame);
        }

		if (ele->Attribute("visible")) {
		   bool visible = ele->BoolAttribute("visible");
		   
		   cce::VisibleFrame *KeyFrame = new cce::VisibleFrame();
		   KeyFrame->setVisible(visible);
		   KeyFrame->setFrameIndex(index);
           KeyFrame->setEasingType(easing);
		   keyFrameAnimation->getOrCreateChannel("Visible")->addFrame(KeyFrame);
        }

		if (ele->Attribute("zorder")) {
		   int zorder = ele->IntAttribute("zorder");
		   
		   cce::ZOrderFrame *KeyFrame = new cce::ZOrderFrame();
		   KeyFrame->setZOrder(zorder);
		   KeyFrame->setFrameIndex(index);
           KeyFrame->setEasingType(easing);
		  keyFrameAnimation->getOrCreateChannel("ZOrder")->addFrame(KeyFrame);
        }

		return NULL;
    }

    void CCEReader::parseLayerAttribute(void* parent,Node *node,tinyxml2::XMLElement *ele, const tinyxml2::XMLAttribute *attr) {
        Layer *layer = (Layer *) node;
        if (layer == NULL) {
            return;
        }
        if (strcmp(attr->Name(), "touchEnabled") == 0) {
            layer->setTouchEnabled(attr->BoolValue());
        } else if (strcmp(attr->Name(), "keyboardEnabled") == 0) {
            layer->setKeyboardEnabled(attr->BoolValue());
        } else if (strcmp(attr->Name(), "accelerometerEnabled") == 0) {
            layer->setAccelerometerEnabled(attr->BoolValue());
		}  
		else {
            parseNodeAttribute(parent,node,ele, attr);
        }
    }

    void CCEReader::parseNodeAttribute(void* parent,Node *node, tinyxml2::XMLElement *ele, const tinyxml2::XMLAttribute *attr) {
        
		Node *parentNode = (Node *) parent;

        if (strcmp(attr->Name(), "tag") == 0) {
            node->setTag(attr->IntValue());
            nodes[node->getTag()] = node;
        }else if (strcmp(attr->Name(), "name") == 0) {
			node->setName(attr->Value());
			nameNodes[node->getName()] = node;
        } 
		else if (strcmp(attr->Name(), "visible") == 0) {
            node->setVisible(attr->BoolValue());
        } else if (strcmp(attr->Name(), "zorder") == 0) {
            node->setLocalZOrder(attr->IntValue());
        } else if (strcmp(attr->Name(), "scaleX") == 0) {
            node->setScaleX(attr->FloatValue());
        } else if (strcmp(attr->Name(), "scaleY") == 0) {
            node->setScaleY(attr->FloatValue());
        } else if (strcmp(attr->Name(), "rotation") == 0) {
            node->setRotation(attr->FloatValue());
        } else if (strcmp(attr->Name(), "positionX") == 0) {
			float x = getPositionXValue(parent,node,ele,attr->FloatValue());
			node->setPositionX(x);
        }else if (strcmp(attr->Name(), "positionY") == 0) {
			float y = getPositionYValue(parent,node,ele,attr->FloatValue());
			node->setPositionY(y);
        }
		else if (strcmp(attr->Name(), "opacity") == 0) {
			node->setOpacity(attr->FloatValue());
        }
		 else if (strcmp(attr->Name(), "anchorPointX") == 0) {
			Vec2 anchorPoint=node->getAnchorPoint();
			Vec2 newAnchorPoint(attr->FloatValue(),anchorPoint.y);
			node->setAnchorPoint(newAnchorPoint);
        } else if (strcmp(attr->Name(), "anchorPointY") == 0) {
			Vec2 anchorPoint=node->getAnchorPoint();
			Vec2 newAnchorPoint(anchorPoint.x,attr->FloatValue());
			//newAnchorPoint.x=anchorPoint.x;
            //newAnchorPoint.y = attr->FloatValue();
			node->setAnchorPoint(newAnchorPoint);
        }else if (strcmp(attr->Name(), "color") == 0) {
			parseColor3B(node,attr->Value());
        }if (strcmp(attr->Name(), "width") == 0) {
			float width = attr->FloatValue();
			if(width>0 ){
				width = getSizeWidth(parentNode,ele,width);
				node->setContentSize(Size(width,node->getContentSize().height));
			}
		}   else if (strcmp(attr->Name(), "height") == 0) {
			float height = attr->FloatValue();
			if(height>0 ){
				height = getSizeHeight(parentNode,ele,height);
				node->setContentSize(Size(node->getContentSize().width,height));
			}
		} 
    }


    Sprite *CCEReader::parseSprite(void *parent, tinyxml2::XMLElement *ele) {
        Sprite *node = Sprite::create();
        const tinyxml2::XMLAttribute *attr = ele->FirstAttribute();
        while (attr) {
            if (strcmp(attr->Name(), "src") == 0||strcmp(attr->Name(), "texture") == 0) {
                std::string textureName(attr->Value());
                int pos = 0;
                if ((pos = textureName.find(".plist/")) > 0) {
                    std::string plistPath = textureName.substr(0, pos + 6).c_str();
                    std::string frameName = textureName.substr(pos + 7).c_str();
                    SpriteFrameCache *cache = SpriteFrameCache::getInstance();
                    cache->addSpriteFramesWithFile(plistPath);
                    node->setSpriteFrame(frameName);
                } else {
				    Texture2D *texture = Director::getInstance()->getTextureCache()->addImage(attr->Value());
					if(texture!=NULL){
						node->setTexture(attr->Value());
					}else{
						log("can't find sprite %s",attr->Value());
					}
                }
            } else {
                parseNodeAttribute(parent,node,ele, attr);
            }
            attr = attr->Next();
        }

        addChildNode(parent,node,ele);
        return node;
    }


    PhysicsBody *CCEReader::parsePhysicsBody(void *parent, tinyxml2::XMLElement *ele) {
        PhysicsBody *physicsBody = PhysicsBody::create();
        Node *node = (Node *) parent;
        if (node) {
            const tinyxml2::XMLAttribute *attr = ele->FirstAttribute();
			Vec2 positionOffset;
			Vec2 velocity;
			Vec2 force;
            while (attr) {
                const char *attsKey = attr->Name();
                if (0 == strcmp(attsKey, "dynamic")) {
                    physicsBody->setDynamic(attr->BoolValue());
                } else if (0 == strcmp(attsKey, "enable")) {
                    physicsBody->setEnable(attr->BoolValue());
                } else if (0 == strcmp(attsKey, "rotationEnable")) {
                    physicsBody->setRotationEnable(attr->BoolValue());
                } else if (0 == strcmp(attsKey, "rest")) {
                    physicsBody->setResting(attr->BoolValue());
                } else if (0 == strcmp(attsKey, "tag")) {
                    physicsBody->setTag(attr->IntValue());
					nodes[attr->IntValue()] = physicsBody;
                } else if (0 == strcmp(attsKey, "angularDamping")) {
                    physicsBody->setAngularDamping(attr->FloatValue());
                } else if (0 == strcmp(attsKey, "linearDamping")) {
                    physicsBody->setLinearDamping(attr->FloatValue());
                } else if (0 == strcmp(attsKey, "moment")) {
                    physicsBody->setMoment(attr->FloatValue());
                }else if (0 == strcmp(attsKey, "positionOffsetX")) {
					positionOffset.x=(attr->FloatValue());
                }else if (0 == strcmp(attsKey, "positionOffsetY")) {
					positionOffset.y=(attr->FloatValue());
                }else if (0 == strcmp(attsKey, "group")) {
					physicsBody->setGroup(attr->IntValue());
                }else if (0 == strcmp(attsKey, "collisionBitmask")) {
					physicsBody->setCollisionBitmask(attr->IntValue());
                }else if (0 == strcmp(attsKey, "contactTestBitmask")) {
					physicsBody->setContactTestBitmask(attr->IntValue());
                }else if (0 == strcmp(attsKey, "categoryBitmask")) {
					physicsBody->setCategoryBitmask(attr->IntValue());
                }else if (0 == strcmp(attsKey, "velocityLimit")) {
					physicsBody->setVelocityLimit(attr->FloatValue());
                }else if (0 == strcmp(attsKey, "angularVelocityLimit")) {
					physicsBody->setAngularVelocityLimit(attr->FloatValue());
                }else if (0 == strcmp(attsKey, "angularVelocity")) {
					physicsBody->setAngularVelocity(attr->FloatValue());
                }else if (0 == strcmp(attsKey, "velocityX")) {
					velocity.x=(attr->FloatValue());
                }else if (0 == strcmp(attsKey, "velocityY")) {
					velocity.y=(attr->FloatValue());
                }else if (0 == strcmp(attsKey, "forceX")) {
					force.x=(attr->FloatValue());
                }else if (0 == strcmp(attsKey, "forceY")) {
					force.y=(attr->FloatValue());
                }else if (0 == strcmp(attsKey, "rotationOffset")) {
					physicsBody->setRotationOffset(attr->FloatValue());
                }else if (0 == strcmp(attsKey, "tag")) {
					physicsBody->setTag(attr->IntValue());
                }
                attr = attr->Next();
            }
			if(physicsBody->isDynamic()){
				physicsBody->setVelocity(velocity);
				physicsBody->applyForce(force);
			}
			physicsBody->setPositionOffset(positionOffset);
			node->setPhysicsBody(physicsBody);
			Scene* scene = nullptr;
			for (node = node->getParent(); node != nullptr; node = node->getParent())
			{
				Scene* tmpScene = dynamic_cast<Scene*>(node);
				if (tmpScene != nullptr && tmpScene->getPhysicsWorld() != nullptr)
				{
					scene = tmpScene;
					break;
				}
			}
			if(scene){
				scene->getPhysicsWorld()->addBody(physicsBody);
			}
        }
        return physicsBody;
    }

    PhysicsShapeCircle *CCEReader::parseCircleShape(void *parent, tinyxml2::XMLElement *ele) {
        PhysicsMaterial material;
        float radius;
        Vec2 offset;
		int tag=0;
        const tinyxml2::XMLAttribute *attr = ele->FirstAttribute();
        while (attr) {
            const char *attsKey = attr->Name();
            if (0 == strcmp(attsKey, "radius")) {
                radius = attr->FloatValue();
            } else if (0 == strcmp(attsKey, "density")) {
                material.density = attr->FloatValue();
            } else if (0 == strcmp(attsKey, "restitution")) {
                material.restitution = attr->FloatValue();
            } else if (0 == strcmp(attsKey, "friction")) {
                material.friction = attr->FloatValue();
            } else if (0 == strcmp(attsKey, "offsetX")) {
                offset.x = attr->FloatValue();
            } else if (0 == strcmp(attsKey, "offsetY")) {
                offset.y = attr->FloatValue();
            }else if (strcmp(attr->Name(), "tag") == 0) {
				tag=attr->IntValue();
			} 
            attr = attr->Next();
        }
        PhysicsBody *physicsBody = (PhysicsBody *) parent;
        if (physicsBody) {
           PhysicsShape *shape = physicsBody->addShape(PhysicsShapeCircle::create(radius, material, offset));
		   if(tag>0){
			   shape->setTag(tag);
			   nodes[tag]=shape;
		   }
		}
        return NULL;
    }

    PhysicsShapeBox *CCEReader::parseBoxShape(void *parent, tinyxml2::XMLElement *ele) {
        PhysicsMaterial material;
        Size size;
        Vec2 offset;
		int tag=0;
        const tinyxml2::XMLAttribute *attr = ele->FirstAttribute();
        while (attr) {
            const char *attsKey = attr->Name();
            if (0 == strcmp(attsKey, "width")) {
                size.width = attr->FloatValue();
            } else if (0 == strcmp(attsKey, "height")) {
                size.height = attr->FloatValue();
            }
            else if (0 == strcmp(attsKey, "density")) {
                material.density = attr->FloatValue();
            } else if (0 == strcmp(attsKey, "restitution")) {
                material.restitution = attr->FloatValue();
            } else if (0 == strcmp(attsKey, "friction")) {
                material.friction = attr->FloatValue();
            } else if (0 == strcmp(attsKey, "offsetX")) {
                offset.x = attr->FloatValue();
            } else if (0 == strcmp(attsKey, "offsetY")) {
                offset.y = attr->FloatValue();
            }else if (strcmp(attr->Name(), "tag") == 0) {
				tag=attr->IntValue();
			} 
            attr = attr->Next();
        }
        PhysicsBody *physicsBody = (PhysicsBody *) parent;
        if (physicsBody) {
           PhysicsShape *shape=  physicsBody->addShape(PhysicsShapeBox::create(size, material, offset), false);
		   if(tag>0){
			   shape->setTag(tag);
			   nodes[tag]=shape;
			}
		}
        return NULL;
    }

    PhysicsShapePolygon *CCEReader::parsePolygonShape(void *parent, tinyxml2::XMLElement *ele) {
        PhysicsMaterial material;
        Size size;
        Vec2 offset;
		int tag=0;
        PhysicsBody *physicsBody = (PhysicsBody *) parent;
        if (!physicsBody) {
            return NULL;
        }
        const tinyxml2::XMLAttribute *attr = ele->FirstAttribute();
        while (attr) {
            const char *attsKey = attr->Name();
            if (0 == strcmp(attsKey, "width")) {
                size.width = attr->FloatValue();
            } else if (0 == strcmp(attsKey, "height")) {
                size.height = attr->FloatValue();
            }
            else if (0 == strcmp(attsKey, "density")) {
                material.density = attr->FloatValue();
            } else if (0 == strcmp(attsKey, "restitution")) {
                material.restitution = attr->FloatValue();
            } else if (0 == strcmp(attsKey, "friction")) {
                material.friction = attr->FloatValue();
            } else if (0 == strcmp(attsKey, "offsetX")) {
                offset.x = attr->FloatValue();
            } else if (0 == strcmp(attsKey, "offsetY")) {
                offset.y = attr->FloatValue();
            }else if (strcmp(attr->Name(), "tag") == 0) {
				tag=attr->IntValue();
			} 
            attr = attr->Next();
        }
        Vec2 *vertexsArray = new Vec2[1000];
        int idx = 0;
        tinyxml2::XMLElement *child = ele->FirstChildElement();
        while (child) {
            const char *childName = child->Name();
            if (strcmp(childName, "Vertex") == 0) {
                Vec2 vertex;
                const tinyxml2::XMLAttribute *attr = child->FirstAttribute();
                while (attr) {
                    const char *attsKey = attr->Name();
                    if (0 == strcmp(attsKey, "x")) {
                        vertex.x = attr->FloatValue();
                    } else if (0 == strcmp(attsKey, "y")) {
                        vertex.y = attr->FloatValue();
                    }
                    attr = attr->Next();
                }
                vertexsArray[idx++] = (vertex);
            }
            child = child->NextSiblingElement();
        }

        PhysicsShapePolygon *shape = PhysicsShapePolygon::create(vertexsArray, idx, material, offset);
		if(tag>0){
				 shape->setTag(tag);
			   nodes[tag]=shape;
		   }
        physicsBody->addShape(shape, false);

        return shape;
    }

    PhysicsShapeEdgeSegment *CCEReader::parseEdgeSegmentShape(void *parent, tinyxml2::XMLElement *ele) {
        PhysicsBody *physicsBody = (PhysicsBody *) parent;
        if (!physicsBody) {
            return NULL;
        }
        PhysicsMaterial material;
        Vec2 from, to;
        float border=1;
		int tag=0;
        const tinyxml2::XMLAttribute *attr = ele->FirstAttribute();
        while (attr) {
            const char *attsKey = attr->Name();
            if (0 == strcmp(attsKey, "fromX")) {
                from.x = attr->FloatValue();
            } else if (0 == strcmp(attsKey, "fromY")) {
                from.y = attr->FloatValue();
            }
            else if (0 == strcmp(attsKey, "toX")) {
                to.x = attr->FloatValue();
            } else if (0 == strcmp(attsKey, "toY")) {
                to.y = attr->FloatValue();
            } else if (0 == strcmp(attsKey, "border")) {
                border = attr->FloatValue();
            }
            else if (0 == strcmp(attsKey, "density")) {
                material.density = attr->FloatValue();
            } else if (0 == strcmp(attsKey, "restitution")) {
                material.restitution = attr->FloatValue();
            } else if (0 == strcmp(attsKey, "friction")) {
                material.friction = attr->FloatValue();
            }else if (strcmp(attr->Name(), "tag") == 0) {
				tag=attr->IntValue();
			} 
            attr = attr->Next();
        }
		Vec2 *vertexsArray = new Vec2[1000];
        int idx = 0;
        tinyxml2::XMLElement *child = ele->FirstChildElement();
        while (child) {
            const char *childName = child->Name();
            if (strcmp(childName, "Vertex") == 0) {
                Vec2 vertex;
                const tinyxml2::XMLAttribute *attr = child->FirstAttribute();
                while (attr) {
                    const char *attsKey = attr->Name();
                    if (0 == strcmp(attsKey, "x")) {
                        vertex.x = attr->FloatValue();
                    } else if (0 == strcmp(attsKey, "y")) {
                        vertex.y = attr->FloatValue();
                    }
                    attr = attr->Next();
                }
                vertexsArray[idx++] = (vertex);
            }
            child = child->NextSiblingElement();
        }
		if(idx>1){
			Vec2 last=vertexsArray[0];
			for(int i=1;i<idx;i++){
				PhysicsShapeEdgeSegment *shape = PhysicsShapeEdgeSegment::create(last, vertexsArray[i], material, border);
				if(tag>0){
					 shape->setTag(tag);
				   nodes[tag+i-1]=shape;
				}
				physicsBody->addShape(shape, false);
				last=vertexsArray[i];
			}
		}else{
			PhysicsShapeEdgeSegment *shape = PhysicsShapeEdgeSegment::create(from, to, material, border);
			if(tag>0){
				   nodes[tag]=shape;
			   }
			physicsBody->addShape(shape, false);
			return shape;
		}
    }

    PhysicsShapeEdgeBox *CCEReader::parseEdgeBoxShape(void *parent, tinyxml2::XMLElement *ele) {
        PhysicsBody *physicsBody = (PhysicsBody *) parent;
        if (!physicsBody) {
            return NULL;
        }
        PhysicsMaterial material;
        Size size;
        float border=1;
		int tag=0;
        const tinyxml2::XMLAttribute *attr = ele->FirstAttribute();
        while (attr) {
            const char *attsKey = attr->Name();
            if (0 == strcmp(attsKey, "width")) {
                size.width = attr->FloatValue();
            } else if (0 == strcmp(attsKey, "height")) {
                size.height = attr->FloatValue();
            }
            else if (0 == strcmp(attsKey, "border")) {
                border = attr->FloatValue();
            }
            else if (0 == strcmp(attsKey, "density")) {
                material.density = attr->FloatValue();
            } else if (0 == strcmp(attsKey, "restitution")) {
                material.restitution = attr->FloatValue();
            } else if (0 == strcmp(attsKey, "friction")) {
                material.friction = attr->FloatValue();
            }else if (strcmp(attr->Name(), "tag") == 0) {
				tag=attr->IntValue();
			} 
            attr = attr->Next();
        }
        PhysicsShapeEdgeBox *shape = PhysicsShapeEdgeBox::create(size, material, border);
        if(tag>0){
			 shape->setTag(tag);
			   nodes[tag]=shape;
		   }
		physicsBody->addShape(shape, false);
        return shape;
    }

    PhysicsShapeEdgePolygon *CCEReader::parseEdgePolygonShape(void *parent, tinyxml2::XMLElement *ele) {
        PhysicsBody *physicsBody = (PhysicsBody *) parent;
        if (!physicsBody) {
            return NULL;
        }
        PhysicsMaterial material;
        Size size;
        float border=1;
		int tag=0;
        const tinyxml2::XMLAttribute *attr = ele->FirstAttribute();
        while (attr) {
            const char *attsKey = attr->Name();
            if (0 == strcmp(attsKey, "width")) {
                size.width = attr->FloatValue();
            } else if (0 == strcmp(attsKey, "height")) {
                size.height = attr->FloatValue();
            }
            else if (0 == strcmp(attsKey, "density")) {
                material.density = attr->FloatValue();
            } else if (0 == strcmp(attsKey, "restitution")) {
                material.restitution = attr->FloatValue();
            } else if (0 == strcmp(attsKey, "friction")) {
                material.friction = attr->FloatValue();
            } else if (0 == strcmp(attsKey, "border")) {
                border = attr->FloatValue();
            }else if (strcmp(attr->Name(), "tag") == 0) {
				tag=attr->IntValue();
			} 
            attr = attr->Next();
        }

        Vec2 *vertexsArray = new Vec2[1000];
        int idx = 0;
        tinyxml2::XMLElement *child = ele->FirstChildElement();
        while (child) {
            const char *childName = child->Name();
            if (strcmp(childName, "Vertex") == 0) {
                Vec2 vertex;
                const tinyxml2::XMLAttribute *attr = child->FirstAttribute();
                while (attr) {
                    const char *attsKey = attr->Name();
                    if (0 == strcmp(attsKey, "x")) {
                        vertex.x = attr->FloatValue();
                    } else if (0 == strcmp(attsKey, "y")) {
                        vertex.y = attr->FloatValue();
                    }
                    attr = attr->Next();
                }
                vertexsArray[idx++] = (vertex);
            }
            child = child->NextSiblingElement();
        }

        PhysicsShapeEdgePolygon *shape = PhysicsShapeEdgePolygon::create(vertexsArray, idx, material, border);
        if(tag>0){
			 shape->setTag(tag);
			   nodes[tag]=shape;
		   }
		physicsBody->addShape(shape, false);
        return shape;
    }

    PhysicsShapeEdgeChain *CCEReader::parseEdgeChainShape(void *parent, tinyxml2::XMLElement *ele) {
        PhysicsBody *physicsBody = (PhysicsBody *) parent;
        if (!physicsBody) {
            return NULL;
        }
        PhysicsMaterial material;
        Size size;
        float border=1;
		int tag=0;
        const tinyxml2::XMLAttribute *attr = ele->FirstAttribute();
        while (attr) {
            const char *attsKey = attr->Name();
            if (0 == strcmp(attsKey, "width")) {
                size.width = attr->FloatValue();
            } else if (0 == strcmp(attsKey, "height")) {
                size.height = attr->FloatValue();
            }
            else if (0 == strcmp(attsKey, "density")) {
                material.density = attr->FloatValue();
            } else if (0 == strcmp(attsKey, "restitution")) {
                material.restitution = attr->FloatValue();
            } else if (0 == strcmp(attsKey, "friction")) {
                material.friction = attr->FloatValue();
            } else if (0 == strcmp(attsKey, "border")) {
                border = attr->FloatValue();
            }else if (strcmp(attr->Name(), "tag") == 0) {
				tag=attr->IntValue();
			} 
            attr = attr->Next();
        }

        Vec2 *vertexsArray = new Vec2[1000];
        int idx = 0;
        tinyxml2::XMLElement *child = ele->FirstChildElement();
        while (child) {
            const char *childName = child->Name();
            if (strcmp(childName, "Vertex") == 0) {
                Vec2 vertex;
                const tinyxml2::XMLAttribute *attr = child->FirstAttribute();
                while (attr) {
                    const char *attsKey = attr->Name();
                    if (0 == strcmp(attsKey, "x")) {
                        vertex.x = attr->FloatValue();
                    } else if (0 == strcmp(attsKey, "y")) {
                        vertex.y = attr->FloatValue();
                    }
                    attr = attr->Next();
                }
                vertexsArray[idx++] = (vertex);
            }
            child = child->NextSiblingElement();
        }


        PhysicsShapeEdgeChain *shape = PhysicsShapeEdgeChain::create(vertexsArray, idx, material, border);
        if(tag>0){
			 shape->setTag(tag);
			   nodes[tag]=shape;
		   }
		physicsBody->addShape(shape, false);
        return shape;
    }

	PhysicsBody *CCEReader::getBodyA(void *parent,int tag){
		Ref *ref = (Ref*)nodes[tag];
		Ref *pNode = (Ref*)parent;
		if(ref){
			PhysicsBody *body =dynamic_cast<PhysicsBody*> (ref);
			if(body){
				return body;
			}
			Node *node =dynamic_cast<Node*> (ref);
			if(node!=NULL){
				return node->getPhysicsBody();
			}
			if(pNode){
				PhysicsBody *body1 =dynamic_cast<PhysicsBody*> (pNode);
				if(body1){
					return body1;
				}
				Node *node =dynamic_cast<Node*> (pNode);
				if(node){
					return node->getPhysicsBody();
				}
			}
		}
		return NULL;
	}	
	
	PhysicsBody *CCEReader::getBodyB(int tag){
		Ref *ref = (Ref*)nodes[tag];
		if(ref){
			PhysicsBody *body =dynamic_cast<PhysicsBody*> (ref);
			if(body!=NULL){
				return body;
			}
			Node *node =dynamic_cast<Node*> (ref);
			if(node!=NULL){
				return node->getPhysicsBody();
			}
		}
		return NULL;
	}


	PhysicsJointDistance *CCEReader::parseJointDistancee(void *parent, tinyxml2::XMLElement *ele){
		int tag = ele->IntAttribute("tag");
		int tagA = ele->IntAttribute("tagA");
		int tagB = ele->IntAttribute("tagB");
		PhysicsBody *bodyA = getBodyA(parent,tagA);
		PhysicsBody *bodyB = getBodyB(tagB);
		if(bodyA&& bodyB){
			Vec2 pointA;
			Vec2 pointB;
			pointA.x= ele->FloatAttribute("anchorPointXA");
			pointA.y= ele->FloatAttribute("anchorPointYA");
			pointB.x= ele->FloatAttribute("anchorPointXB");
			pointB.y= ele->FloatAttribute("anchorPointYB");
			
			PhysicsJointDistance* joint = PhysicsJointDistance::construct(bodyA, bodyB, pointA,pointB);
			if(tag>0){
				 joint->setTag(tag);
				nodes[tag]=joint;
			}
			joint->setDistance(ele->IntAttribute("distance"));
			bodyA->getWorld()->addJoint(joint);
			return joint;
		}
		return NULL;
	}
        
	PhysicsJointFixed *CCEReader::parseJointFixed(void *parent, tinyxml2::XMLElement *ele){
		int tag = ele->IntAttribute("tag");
		int tagA = ele->IntAttribute("tagA");
		int tagB = ele->IntAttribute("tagB");
		PhysicsBody *bodyA = getBodyA(parent,tagA);
		PhysicsBody *bodyB = getBodyB(tagB);
		if(bodyA&& bodyB){
			Vec2 pointA;
			pointA.x= ele->FloatAttribute("anchorPointX");
			pointA.y= ele->FloatAttribute("anchorPointY");
			
			PhysicsJointFixed* joint = PhysicsJointFixed::construct(bodyA, bodyB,pointA);
			if(tag>0){
				joint->setTag(tag);		
				nodes[tag]=joint;
			}
			bodyA->getWorld()->addJoint(joint);
			return joint;
		}
		return NULL;
	}
    
	PhysicsJointGear *CCEReader::parseJointGear(void *parent, tinyxml2::XMLElement *ele){
			int tag = ele->IntAttribute("tag");
		int tagA = ele->IntAttribute("tagA");
		int tagB = ele->IntAttribute("tagB");
		PhysicsBody *bodyA = getBodyA(parent,tagA);
		PhysicsBody *bodyB = getBodyB(tagB);
		if(bodyA&& bodyB){
			float phase,ratio;
			phase = ele->FloatAttribute("phase");
			ratio = ele->FloatAttribute("ratio");
			PhysicsJointGear* joint = PhysicsJointGear::construct(bodyA, bodyB,phase,ratio);
			if(tag>0){
				joint->setTag(tag);
				nodes[tag]=joint;
			}
			bodyA->getWorld()->addJoint(joint);
			return joint;
		}
		return NULL;
	}

    PhysicsJointGroove *CCEReader::parseJointGroove(void *parent, tinyxml2::XMLElement *ele){
			int tag = ele->IntAttribute("tag");
		int tagA = ele->IntAttribute("tagA");
		int tagB = ele->IntAttribute("tagB");
		PhysicsBody *bodyA = getBodyA(parent,tagA);
		PhysicsBody *bodyB = getBodyB(tagB);
		if(bodyA&& bodyB){
			Vec2 pointA;
			Vec2 pointB;
			Vec2 pointC;
			pointA.x= ele->FloatAttribute("grooveXA");
			pointA.y= ele->FloatAttribute("grooveYA");
			pointB.x= ele->FloatAttribute("grooveXB");
			pointB.y= ele->FloatAttribute("grooveYB");
			pointC.x= ele->FloatAttribute("anchorPointX");
			pointC.y= ele->FloatAttribute("anchorPointY");
			
			PhysicsJointGroove* joint = PhysicsJointGroove::construct(bodyA, bodyB, pointA,pointB,pointC);
			if(tag>0){
				joint->setTag(tag);
				nodes[tag]=joint;
			}
			bodyA->getWorld()->addJoint(joint);
			return joint;
		}
		return NULL;
	}
        
	PhysicsJointLimit *CCEReader::parseJointLimit(void *parent, tinyxml2::XMLElement *ele){
		int tag = ele->IntAttribute("tag");
		int tagA = ele->IntAttribute("tagA");
		int tagB = ele->IntAttribute("tagB");
		PhysicsBody *bodyA = getBodyA(parent,tagA);
		PhysicsBody *bodyB = getBodyB(tagB);
		if(bodyA&& bodyB){
			Vec2 pointA;
			Vec2 pointB;
			pointA.x= ele->FloatAttribute("anchorPointXA");
			pointA.y= ele->FloatAttribute("anchorPointYA");
			pointB.x= ele->FloatAttribute("anchorPointXB");
			pointB.y= ele->FloatAttribute("anchorPointYB");
			
			PhysicsJointLimit* joint = PhysicsJointLimit::construct(bodyA, bodyB, pointA,pointB);
			if(tag>0){
				joint->setTag(tag);
				nodes[tag]=joint;
			}
			joint->setMax(ele->IntAttribute("max"));
			joint->setMin(ele->IntAttribute("min"));
			bodyA->getWorld()->addJoint(joint);
			return joint;
		}
		return NULL;
	}
        
	PhysicsJointMotor *CCEReader::parseJointMotor(void *parent, tinyxml2::XMLElement *ele){
			int tag = ele->IntAttribute("tag");
		int tagA = ele->IntAttribute("tagA");
		int tagB = ele->IntAttribute("tagB");
		PhysicsBody *bodyA = getBodyA(parent,tagA);
		PhysicsBody *bodyB = getBodyB(tagB);
		if(bodyA&& bodyB){
			float rate;
			rate = ele->FloatAttribute("rate");
			PhysicsJointMotor* joint = PhysicsJointMotor::construct(bodyA, bodyB,rate);
			if(tag>0){
				joint->setTag(tag);
				nodes[tag]=joint;
			}
			bodyA->getWorld()->addJoint(joint);
			return joint;
		}
		return NULL;
	}
        
	
	PhysicsJointPin *CCEReader::parseJointPin(void *parent, tinyxml2::XMLElement *ele){
		int tag = ele->IntAttribute("tag");
		int tagA = ele->IntAttribute("tagA");
		int tagB = ele->IntAttribute("tagB");
		PhysicsBody *bodyA = getBodyA(parent,tagA);
		PhysicsBody *bodyB = getBodyB(tagB);
		if(bodyA&& bodyB){
			Vec2 pointA;
			pointA.x= ele->FloatAttribute("anchorPointX");
			pointA.y= ele->FloatAttribute("anchorPointY");
			
			PhysicsJointPin* joint = PhysicsJointPin::construct(bodyA, bodyB,pointA);
			if(tag>0){
				joint->setTag(tag);
				nodes[tag]=joint;
			}
			bodyA->getWorld()->addJoint(joint);
			return joint;
		}
		return NULL;
	}
        
	
	PhysicsJointRatchet *CCEReader::parseJointRatchet(void *parent, tinyxml2::XMLElement *ele){
			int tag = ele->IntAttribute("tag");
		int tagA = ele->IntAttribute("tagA");
		int tagB = ele->IntAttribute("tagB");
		PhysicsBody *bodyA = getBodyA(parent,tagA);
		PhysicsBody *bodyB = getBodyB(tagB);
		if(bodyA&& bodyB){
			float phase,ratchet;
			phase = ele->FloatAttribute("phase");
			ratchet = ele->FloatAttribute("ratchet");
			PhysicsJointRatchet* joint = PhysicsJointRatchet::construct(bodyA, bodyB,phase,ratchet);
			if(tag>0){
				joint->setTag(tag);
				nodes[tag]=joint;
			}
			bodyA->getWorld()->addJoint(joint);
			return joint;
		}
		return NULL;
	}
        
	PhysicsJointRotaryLimit *CCEReader::parseJointRotaryLimit(void *parent, tinyxml2::XMLElement *ele){
		int tag = ele->IntAttribute("tag");
		int tagA = ele->IntAttribute("tagA");
		int tagB = ele->IntAttribute("tagB");
		PhysicsBody *bodyA = getBodyA(parent,tagA);
		PhysicsBody *bodyB = getBodyB(tagB);
		if(bodyA&& bodyB){
			float max,min;
			max = ele->FloatAttribute("max");
			min = ele->FloatAttribute("min");
			PhysicsJointRotaryLimit* joint = PhysicsJointRotaryLimit::construct(bodyA, bodyB,max,min);
			if(tag>0){
				joint->setTag(tag);
				nodes[tag]=joint;
			}
			bodyA->getWorld()->addJoint(joint);
			return joint;
		}
		return NULL;
	}
        
	PhysicsJointRotarySpring *CCEReader::parseJointRotarySpring(void *parent, tinyxml2::XMLElement *ele){
		int tag = ele->IntAttribute("tag");
		int tagA = ele->IntAttribute("tagA");
		int tagB = ele->IntAttribute("tagB");
		PhysicsBody *bodyA = getBodyA(parent,tagA);
		PhysicsBody *bodyB = getBodyB(tagB);
		if(bodyA&& bodyB){
			float stiffness,damping;
			stiffness = ele->FloatAttribute("stiffness");
			damping = ele->FloatAttribute("damping");
			PhysicsJointRotarySpring* joint = PhysicsJointRotarySpring::construct(bodyA, bodyB,stiffness,damping);
			if(tag>0){
				joint->setTag(tag);
				nodes[tag]=joint;
			}
			bodyA->getWorld()->addJoint(joint);
			return joint;
		}
		return NULL;
	}
        
	
	PhysicsJointSpring *CCEReader::parseJointSpring(void *parent, tinyxml2::XMLElement *ele){
		int tag = ele->IntAttribute("tag");
		int tagA = ele->IntAttribute("tagA");
		int tagB = ele->IntAttribute("tagB");
		PhysicsBody *bodyA = getBodyA(parent,tagA);
		PhysicsBody *bodyB = getBodyB(tagB);
		if(bodyA&& bodyB){
			Vec2 pointA;
			Vec2 pointB;
			pointA.x= ele->FloatAttribute("anchorPointXA");
			pointA.y= ele->FloatAttribute("anchorPointYA");
			pointB.x= ele->FloatAttribute("anchorPointXB");
			pointB.y= ele->FloatAttribute("anchorPointYB");
			float stiffness,damping;
			stiffness = ele->FloatAttribute("stiffness");
			damping = ele->FloatAttribute("damping");
			PhysicsJointSpring* joint = PhysicsJointSpring::construct(bodyA, bodyB, pointA,pointB,stiffness,damping);
			if(tag>0){
				joint->setTag(tag);
				nodes[tag]=joint;
			}
			bodyA->getWorld()->addJoint(joint);
			return joint;
		}
		return NULL;
	}

    LayerColor *CCEReader::parseLayerColor(void *parent, tinyxml2::XMLElement *ele) {
        LayerColor *node = LayerColor::create();
        const tinyxml2::XMLAttribute *attr = ele->FirstAttribute();
		
		float width=0,height=0;
		while (attr) {
			parseLayerAttribute(parent,node,ele, attr);
            attr = attr->Next();
        }
		
		/*if(width>0 || height>0){
			width = getSizeWidth(ele,width);
			height = getSizeHeight(ele,height);
			node->setContentSize(Size(width,height));
		}*/

        addChildNode(parent,node,ele);
        return node;
    }

	

    LayerGradient *CCEReader::parseLayerGradient(void *parent, tinyxml2::XMLElement *ele) {
        LayerGradient *node = LayerGradient::create();
        const tinyxml2::XMLAttribute *attr = ele->FirstAttribute();
		
        while (attr) {
            const char *attsKey = attr->Name();
            Vec2 vector;
            if (0 == strcmp(attsKey, "startColor")) {
                const char *value = attr->Value();
				node->setStartColor(getColor3B(value));
            }
            else if (0 == strcmp(attsKey, "endColor")) {
                const char *value = attr->Value();
                node->setEndColor(getColor3B(value));
            } else if (0 == strcmp(attsKey, "vectorX")) {
                vector.x = attr->FloatValue();
                node->setVector(vector);
            } else if (0 == strcmp(attsKey, "vectorY")) {
                vector.y = attr->FloatValue();
                node->setVector(vector);
            }
			else {
                parseLayerAttribute(parent,node,ele, attr);
            }
            attr = attr->Next();
        }

        addChildNode(parent,node,ele);
        return node;
    }

    ParticleSystem *CCEReader::parseParticleSystem(void *parent, tinyxml2::XMLElement *ele) {

        ParticleSystem *node = NULL;
        {
            const tinyxml2::XMLAttribute *attr = ele->FirstAttribute();
            while (attr) {
                if (strcmp(attr->Name(), "src") == 0) {
                    node = ParticleSystemQuad::create(attr->Value());
                    break;
                } else if (strcmp(attr->Name(), "type") == 0) {
                    if (strcmp(attr->Value(), "Flower") == 0) {
                        node = ParticleFlower::create();
                    } else if (strcmp(attr->Value(), "Sun") == 0) {
                        node = ParticleSun::create();
                    } else if (strcmp(attr->Value(), "Fire") == 0) {
                        node = ParticleFire::create();
                    } else if (strcmp(attr->Value(), "Fireworks") == 0) {
                        node = ParticleFireworks::create();
                    } else if (strcmp(attr->Value(), "Galaxy") == 0) {
                        node = ParticleGalaxy::create();
                    } else if (strcmp(attr->Value(), "Meteor") == 0) {
                        node = ParticleMeteor::create();
                    } else if (strcmp(attr->Value(), "Spiral") == 0) {
                        node = ParticleSpiral::create();
                    } else if (strcmp(attr->Value(), "Explosion") == 0) {
                        node = ParticleExplosion::create();
                    } else if (strcmp(attr->Value(), "Smoke") == 0) {
                        node = ParticleSmoke::create();
                    } else if (strcmp(attr->Value(), "Snow") == 0) {
                        node = ParticleSnow::create();
                    } else if (strcmp(attr->Value(), "Rain") == 0) {
                        node = ParticleRain::create();
                    }
                    break;
                }
                attr = attr->Next();
            }
        }

        if (node == NULL) {
            node = ParticleSystemQuad::create();
        }
        {
            const tinyxml2::XMLAttribute *attr = ele->FirstAttribute();
            Vec2 gravity;
            while (attr) {
                const char *attrName = attr->Name();
                if (strcmp(attrName, "mode") == 0) {

                } else if (strcmp(attrName, "emitRate") == 0) {
                    node->setEmissionRate(attr->FloatValue());
                } else if (strcmp(attrName, "duration") == 0) {
                    node->setDuration(attr->FloatValue());
                } else if (strcmp(attrName, "totalParticles") == 0) {
                    node->setTotalParticles(attr->FloatValue());
                } else if (strcmp(attrName, "life") == 0) {
                    node->setLife(attr->FloatValue());
                } else if (strcmp(attrName, "lifeVar") == 0) {
                    node->setLifeVar(attr->FloatValue());
                } else if (strcmp(attrName, "startSize") == 0) {
                    node->setStartSize(attr->FloatValue());
                } else if (strcmp(attrName, "startSizeVar") == 0) {
                    node->setStartSizeVar(attr->FloatValue());
                } else if (strcmp(attrName, "endSize") == 0) {
                    node->setEndSize(attr->FloatValue());
                } else if (strcmp(attrName, "endSizeVar") == 0) {
                    node->setEndSizeVar(attr->FloatValue());
                } else if (strcmp(attrName, "startSpin") == 0) {
                    node->setStartSpin(attr->FloatValue());
                } else if (strcmp(attrName, "startSpinVar") == 0) {
                    node->setStartSpinVar(attr->FloatValue());
                } else if (strcmp(attrName, "endSpin") == 0) {
                    node->setEndSpin(attr->FloatValue());
                } else if (strcmp(attrName, "endSpinVar") == 0) {
                    node->setEndSpinVar(attr->FloatValue());
                } else if (strcmp(attrName, "angle") == 0) {
                    node->setAngle(attr->FloatValue());
                } else if (strcmp(attrName, "angleVar") == 0) {
                    node->setAngleVar(attr->FloatValue());
                } else if (strcmp(attrName, "startColor") == 0) {
                    Color4F color;
                    node->setStartColor(color);
                } else if (strcmp(attrName, "startColorVar") == 0) {
                    Color4F color;
                    node->setStartColorVar(color);
                } else if (strcmp(attrName, "endColor") == 0) {
                    Color4F color;
                    node->setEndColor(color);
                } else if (strcmp(attrName, "endColorVar") == 0) {
                    Color4F color;
                    node->setEndColorVar(color);
                } else if (strcmp(attrName, "gravityX") == 0) {
                    gravity.x = attr->FloatValue();
                    node->setGravity(gravity);
                } else if (strcmp(attrName, "gravityY") == 0) {
                    gravity.y = attr->FloatValue();
                    node->setGravity(gravity);
                } else if (strcmp(attrName, "speed") == 0) {
                    node->setSpeed(attr->FloatValue());
                } else if (strcmp(attrName, "speedVar") == 0) {
                    node->setSpeedVar(attr->FloatValue());
                } else if (strcmp(attrName, "tangentialAccel") == 0) {
                    node->setTangentialAccel(attr->FloatValue());
                } else if (strcmp(attrName, "tangentialAccelVar") == 0) {
                    node->setTangentialAccelVar(attr->FloatValue());
                } else if (strcmp(attrName, "radialAccel") == 0) {
                    node->setRadialAccel(attr->FloatValue());
                } else if (strcmp(attrName, "radialAccelVar") == 0) {
                    node->setRadialAccelVar(attr->FloatValue());
                } else if (strcmp(attrName, "startRadius") == 0) {
                    node->setStartRadius(attr->FloatValue());
                } else if (strcmp(attrName, "startRadiusVar") == 0) {
                    node->setStartRadiusVar(attr->FloatValue());
                } else if (strcmp(attrName, "endRadius") == 0) {
                    node->setEndRadius(attr->FloatValue());
                } else if (strcmp(attrName, "endRadiusVar") == 0) {
                    node->setEndRadiusVar(attr->FloatValue());
                } else if (strcmp(attrName, "rotatePerSecond") == 0) {
                    node->setRotatePerSecond(attr->FloatValue());
                } else if (strcmp(attrName, "rotatePerSecondVar") == 0) {
                    node->setRotatePerSecondVar(attr->FloatValue());
                } else if (strcmp(attrName, "texture") == 0) {
                    //node->setTexture(attr->FloatValue());
                } else {
                    parseNodeAttribute(parent,node,ele, attr);
                }

                attr = attr->Next();
            }
        }

        addChildNode(parent,node,ele);
        return node;
    }



	Label *CCEReader::parseLabel(void *parent, tinyxml2::XMLElement *ele){
		
		Label *node = createLabel(parent,ele);
		
		if(node!=NULL){
			const tinyxml2::XMLAttribute *attr = ele->FirstAttribute();
			while (attr) {
				parseNodeAttribute(parent,node,ele, attr);
				attr = attr->Next();
			}

			addChildNode(parent,node,ele);
		}
		return node;
	}

    LabelAtlas *CCEReader::parseLabelAtlas(void *parent, tinyxml2::XMLElement *ele) {

        int charWidth = 0, charHeight, firstChar;
        const char *image;
        const char *text;
        {
            const tinyxml2::XMLAttribute *attr = ele->FirstAttribute();
            while (attr) {
                if (strcmp(attr->Name(), "texture") == 0) {
                    image = (attr->Value());
                } else if (strcmp(attr->Name(), "text") == 0) {
                    text = (attr->Value());
                } else if (strcmp(attr->Name(), "charWidth") == 0) {
                    charWidth = (attr->IntValue());
                } else if (strcmp(attr->Name(), "charHeight") == 0) {
                    charHeight = (attr->IntValue());
                } else if (strcmp(attr->Name(), "firstChar") == 0) {
                    firstChar = (attr->IntValue());
                }
                else {
//                    parseNodeAttribute(node,attr);
                }
                attr = attr->Next();
            }
        }

        LabelAtlas *node = LabelAtlas::create(text, image, charWidth, charHeight, firstChar);

        {
            const tinyxml2::XMLAttribute *attr = ele->FirstAttribute();
            while (attr) {
                parseNodeAttribute(parent,node,ele, attr);
                attr = attr->Next();
            }
        }

		addChildNode(parent,node,ele);
        return node;
    }

    Menu *CCEReader::parseMenu(void *parent, tinyxml2::XMLElement *ele) {
        Menu *node = Menu::create();
        const tinyxml2::XMLAttribute *attr = ele->FirstAttribute();
        while (attr) {
            parseLayerAttribute(parent,node,ele, attr);
            attr = attr->Next();
        }

       addChildNode(parent,node,ele);
        return node;
    }

    MenuItemToggle *CCEReader::parseMenuItemToggle(void *parent, tinyxml2::XMLElement *ele) {

        MenuItemToggle *node = MenuItemToggle::create();
        const tinyxml2::XMLAttribute *attr = ele->FirstAttribute();
		while (attr) {
			parseNodeAttribute(parent,node, ele,attr);
			attr = attr->Next();
        }
        
		
		
		tinyxml2::XMLElement *child = ele->FirstChildElement();
        while (child) {
			MenuItem *object=NULL;
            const char *nodeName = child->Name();
			if (strcmp(nodeName, "MenuItemImage") == 0) {
				object = parseMenuItemImage(NULL, child);
			} else if (strcmp(nodeName, "MenuItemSprite") == 0) {
				object = parseMenuItemSprite(NULL, child);
			} else if (strcmp(nodeName, "MenuItemFont") == 0) {
				object = parseMenuItemFont(NULL, child);
			} else if (strcmp(nodeName, "MenuItemAtlasFont") == 0) {
				object = parseMenuItemAtlasFont(NULL, child);
			} else if (strcmp(nodeName, "MenuItemLabel") == 0) {
				object = parseMenuItemLabel(NULL, child);
			}
			if(object!=NULL){
				node->addSubItem(object);
			}
			child = child->NextSiblingElement();
        }
		
		addChildNode(parent,node,ele);
        return node;
    }


    Sprite *createSprite(const char *value) {
        std::string textureName(value);
        int pos = 0;
        if ((pos = textureName.find(".plist/")) > 0) {
            std::string plistPath = textureName.substr(0, pos + 6).c_str();
            std::string frameName = textureName.substr(pos + 7).c_str();
            SpriteFrameCache *cache = SpriteFrameCache::getInstance();
            cache->addSpriteFramesWithFile(plistPath);
            return Sprite::createWithSpriteFrameName(frameName);
        } else {
            return Sprite::create(value);
        }
        return NULL;
    }

    MenuItemImage *CCEReader::parseMenuItemImage(void *parent, tinyxml2::XMLElement *ele) {

        MenuItemImage *node = MenuItemImage::create();
        const tinyxml2::XMLAttribute *attr = ele->FirstAttribute();
        while (attr) {
            if (strcmp(attr->Name(), "normalTexture") == 0) {
                node->setNormalImage(createSprite(attr->Value()));
            } else if (strcmp(attr->Name(), "selectedTexture") == 0) {
                node->setSelectedImage(createSprite(attr->Value()));
            } else if (strcmp(attr->Name(), "disabledTexture") == 0) {
                node->setDisabledImage(createSprite(attr->Value()));
            }
            else {
                parseNodeAttribute(parent,node,ele, attr);
            }
            attr = attr->Next();
        }

        addChildNode(parent,node,ele);
        return node;
    }

    MenuItemSprite *CCEReader::parseMenuItemSprite(void *parent, tinyxml2::XMLElement *ele) {
        return NULL;
    }


    MenuItemFont *CCEReader::parseMenuItemFont(void *parent, tinyxml2::XMLElement *ele) {
		MenuItemFont *node = MenuItemFont::create(ele->Attribute("text"));
        const tinyxml2::XMLAttribute *attr = ele->FirstAttribute();
        while (attr) {
            if (strcmp(attr->Name(), "fontName") == 0) {
				node->setFontName(attr->Value());
            }else if (strcmp(attr->Name(), "fontSize") == 0) {
				node->setFontSize(attr->IntValue());
            }
            else {
                parseNodeAttribute(parent,node,ele, attr);
            }
            attr = attr->Next();
        }

        addChildNode(parent,node,ele);
        return node;
    }

    MenuItemAtlasFont *CCEReader::parseMenuItemAtlasFont(void *parent, tinyxml2::XMLElement *ele) {
        MenuItemAtlasFont *node = MenuItemAtlasFont::create(ele->Attribute("text"), ele->Attribute("texture"), ele->IntAttribute("charWidth"),
                ele->IntAttribute("charHeight"), ele->IntAttribute("firstChar"));
        const tinyxml2::XMLAttribute *attr = ele->FirstAttribute();
        while (attr) {
            parseNodeAttribute(parent,node, ele,attr);
            attr = attr->Next();
        }

        addChildNode(parent,node,ele);
        return node;
    }

    MenuItemLabel *CCEReader::parseMenuItemLabel(void *parent, tinyxml2::XMLElement *ele) {

		Label *label = createLabel(parent,ele);
        
		MenuItemLabel *node = MenuItemLabel::create(label);

        const tinyxml2::XMLAttribute *attr = ele->FirstAttribute();
        while (attr) {
            parseNodeAttribute(parent,node,ele, attr);
            attr = attr->Next();
        }

        addChildNode(parent,node,ele);
        return node;
    }

    bool isPlist(const char *value) {
        std::string textureName(value);
        int pos = 0;
        if ((pos = textureName.find(".plist/")) > 0) {
            return true;
        }
        return false;
    }

    std::string getTextureName(const char *value) {
        std::string textureName(value);
        int pos = 0;
        if ((pos = textureName.find(".plist/")) > 0) {
            std::string plistPath = textureName.substr(0, pos + 6).c_str();
            std::string frameName = textureName.substr(pos + 7).c_str();
            SpriteFrameCache *cache = SpriteFrameCache::getInstance();
            cache->addSpriteFramesWithFile(plistPath);
            return frameName;
        }
        return textureName;
    }

    ui::Button *CCEReader::parseButton(void *parent, tinyxml2::XMLElement *ele) {
        ui::Button *node = ui::Button::create();

        const tinyxml2::XMLAttribute *attr = ele->FirstAttribute();
        while (attr) {
            if (strcmp(attr->Name(), "textureNormal") == 0) {
                bool isPlistFile = isPlist(attr->Value());
                node->loadTextureNormal(getTextureName(attr->Value()), isPlistFile ? ui::TextureResType::PLIST : ui::TextureResType::LOCAL);
            }
            if (strcmp(attr->Name(), "texturePressed") == 0) {
                bool isPlistFile = isPlist(attr->Value());
                node->loadTexturePressed(getTextureName(attr->Value()), isPlistFile ? ui::TextureResType::PLIST : ui::TextureResType::LOCAL);
            }
            if (strcmp(attr->Name(), "textureDisabled") == 0) {
                bool isPlistFile = isPlist(attr->Value());
                node->loadTextureDisabled(getTextureName(attr->Value()), isPlistFile ? ui::TextureResType::PLIST : ui::TextureResType::LOCAL);
            } else if (strcmp(attr->Name(), "fontName") == 0) {
                node->setTitleFontName(attr->Value());
            } else if (strcmp(attr->Name(), "fontSize") == 0) {
                node->setTitleFontSize(attr->IntValue());
            } else if (strcmp(attr->Name(), "textColor") == 0) {
				node->setTitleColor(getColor3B(attr->Value()));
            } else if (strcmp(attr->Name(), "text") == 0) {
				node->setTitleText(attr->Value());
            }
            else {
                parseNodeAttribute(parent,node,ele, attr);
            }
            attr = attr->Next();
        }

        addChildNode(parent,node,ele);
        return node;

    }

    void CCEReader::parseWidgetAttribute(void* parent,Node *node,tinyxml2::XMLElement *ele, const tinyxml2::XMLAttribute *attr) {
        parseNodeAttribute(parent,node,ele, attr);
    }

    ui::ScrollView *CCEReader::parseScrollView(void *parent, tinyxml2::XMLElement *ele) {
        ui::ScrollView *node = ui::ScrollView::create();

        const tinyxml2::XMLAttribute *attr = ele->FirstAttribute();
        Size size;
        while (attr) {
            if (strcmp(attr->Name(), "direction") == 0) {
                if (strcmp(attr->Value(), "Vertical") == 0) {
                    node->setDirection(ui::ScrollView::Direction::VERTICAL);
                } else if (strcmp(attr->Value(), "Horizontal") == 0) {
                    node->setDirection(ui::ScrollView::Direction::HORIZONTAL);
                } else if (strcmp(attr->Value(), "Both") == 0) {
                    node->setDirection(ui::ScrollView::Direction::BOTH);
                }
                else {
                    node->setDirection(ui::ScrollView::Direction::NONE);
                }

            } else if (strcmp(attr->Name(), "bounce") == 0) {
                node->setBounceEnabled(attr->BoolValue());
            } else if (strcmp(attr->Name(), "innerWidth") == 0) {
                size.width = attr->FloatValue();
                node->setInnerContainerSize(size);
            } else if (strcmp(attr->Name(), "innerHeight") == 0) {
                size.height = attr->FloatValue();
                node->setInnerContainerSize(size);
            }
            else {
                parseWidgetAttribute(parent,node,ele, attr);
            }
            attr = attr->Next();
        }

        addChildNode(parent,node,ele);
        return node;
    }

    ui::ListView *CCEReader::parseListView(void *parent, tinyxml2::XMLElement *ele) {
        ui::ListView *node = ui::ListView::create();

        const tinyxml2::XMLAttribute *attr = ele->FirstAttribute();
        Size size;
        while (attr) {
            if (strcmp(attr->Name(), "direction") == 0) {
                if (strcmp(attr->Value(), "Vertical") == 0) {
                    node->setDirection(ui::ScrollView::Direction::VERTICAL);
                } else if (strcmp(attr->Value(), "Horizontal") == 0) {
                    node->setDirection(ui::ScrollView::Direction::HORIZONTAL);
                } else if (strcmp(attr->Value(), "Both") == 0) {
                    node->setDirection(ui::ScrollView::Direction::BOTH);
                }
                else {
                    node->setDirection(ui::ScrollView::Direction::NONE);
                }

            } else if (strcmp(attr->Name(), "bounce") == 0) {
                node->setBounceEnabled(attr->BoolValue());
            } else if (strcmp(attr->Name(), "innerWidth") == 0) {
                size.width = attr->FloatValue();
                node->setInnerContainerSize(size);
            } else if (strcmp(attr->Name(), "innerHeight") == 0) {
                size.height = attr->FloatValue();
                node->setInnerContainerSize(size);
            }
            else {
                parseWidgetAttribute(parent,node,ele, attr);
            }
            attr = attr->Next();
        }

       addChildNode(parent,node,ele);
        return node;
    }

    ui::PageView *CCEReader::parsePageView(void *parent, tinyxml2::XMLElement *ele) {
        ui::PageView *node = ui::PageView::create();

        const tinyxml2::XMLAttribute *attr = ele->FirstAttribute();
        while (attr) {
            parseWidgetAttribute(parent,node,ele, attr);
            attr = attr->Next();
        }

        addChildNode(parent,node,ele);
        return node;
    }

	ui::Text *CCEReader::parseText(void *parent, tinyxml2::XMLElement *ele){
		ui::Text *node = ui::Text::create();
		const tinyxml2::XMLAttribute *attr = ele->FirstAttribute();
        while (attr) {
			if (strcmp(attr->Name(), "fontName") == 0) {
                node->setFontName(attr->Value());
            } else if (strcmp(attr->Name(), "fontSize") == 0) {
                node->setFontSize(attr->IntValue());
            } else if (strcmp(attr->Name(), "text") == 0) {
                node->setText(attr->Value());
            } else if (strcmp(attr->Name(), "vAlign") == 0) {
                const char *value = attr->Value();
                if (strcmp(value, "Top") == 0) {
                    node->setTextVerticalAlignment(TextVAlignment::TOP);
                } else if (strcmp(value, "Center") == 0) {
                    node->setTextVerticalAlignment(TextVAlignment::CENTER);
                } else if (strcmp(value, "Bottom") == 0) {
                    node->setTextVerticalAlignment(TextVAlignment::BOTTOM);
                }
            } else if (strcmp(attr->Name(), "hAlign") == 0) {
                const char *value = attr->Value();
                if (strcmp(value, "Left") == 0) {
                    node->setTextHorizontalAlignment(TextHAlignment::LEFT);
                } else if (strcmp(value, "Center") == 0) {
                    node->setTextHorizontalAlignment(TextHAlignment::CENTER);
                } else if (strcmp(value, "Right") == 0) {
                    node->setTextHorizontalAlignment(TextHAlignment::RIGHT);
                }
            }
            else {
                parseWidgetAttribute(parent,node,ele, attr);
            }
            attr = attr->Next();
        }

        addChildNode(parent,node,ele);
        return node;
	}

	ui::TextAtlas *CCEReader::parseTextAtlas(void *parent, tinyxml2::XMLElement *ele){
		ui::TextAtlas *node = ui::TextAtlas::create();	
	  	std::string text = ele->Attribute("text");
		std::string texture = ele->Attribute("texture");
		std::string firstChar = ele->Attribute("firstChar");
		int charWidth = ele->IntAttribute("charWidth");
		int charHeight = ele->IntAttribute("charHeight");
		node->setProperty(text,texture,charWidth,charHeight,firstChar);
		
		const tinyxml2::XMLAttribute *attr = ele->FirstAttribute();
        while (attr) {
            parseWidgetAttribute(parent,node,ele, attr);
            attr = attr->Next();
        }

		addChildNode(parent,node,ele);
        return node;
	}

	ui::TextBMFont *CCEReader::parseTextBMFont(void *parent, tinyxml2::XMLElement *ele){
		ui::TextBMFont *node = ui::TextBMFont::create();	
		const tinyxml2::XMLAttribute *attr = ele->FirstAttribute();
        while (attr) {
			if (strcmp(attr->Name(), "src") == 0) {
                node->setFntFile(attr->Value());
            }  else if (strcmp(attr->Name(), "text") == 0) {
                node->setText(attr->Value());
            } 
            else {
                parseWidgetAttribute(parent,node,ele, attr);
            }
            attr = attr->Next();
        }

        addChildNode(parent,node,ele);
        return node;
	}

    ui::TextField *CCEReader::parseTextField(void *parent, tinyxml2::XMLElement *ele) {
        ui::TextField *node = ui::TextField::create();

        const tinyxml2::XMLAttribute *attr = ele->FirstAttribute();
        while (attr) {
            if (strcmp(attr->Name(), "pattern") == 0) {
                node->setPasswordStyleText(attr->Value());
            } else if (strcmp(attr->Name(), "fontName") == 0) {
                node->setFontName(attr->Value());
            } else if (strcmp(attr->Name(), "fontSize") == 0) {
                node->setFontSize(attr->IntValue());
            } else if (strcmp(attr->Name(), "text") == 0) {
                node->setText(attr->Value());
            } else if (strcmp(attr->Name(), "maxLength") == 0) {
                node->setMaxLength(attr->IntValue());
            }
            else {
                parseWidgetAttribute(parent,node,ele, attr);
            }
            attr = attr->Next();
        }

        addChildNode(parent,node,ele);
        return node;
    }

    ui::LoadingBar *CCEReader::parseLoadingBar(void *parent, tinyxml2::XMLElement *ele) {
        ui::LoadingBar *node = ui::LoadingBar::create();

        const tinyxml2::XMLAttribute *attr = ele->FirstAttribute();
        while (attr) {
            if (strcmp(attr->Name(), "texture") == 0) {
                bool isPlistFile = isPlist(attr->Value());
                node->loadTexture(getTextureName(attr->Value()), isPlistFile ? ui::TextureResType::PLIST : ui::TextureResType::LOCAL);
            } else if (strcmp(attr->Name(), "percent") == 0) {
                node->setPercent(attr->FloatValue());
            } else if (strcmp(attr->Name(), "direction") == 0) {
                if (strcmp(attr->Value(), "LEFT") == 0) {
                    node->setDirection(ui::LoadingBar::Direction::LEFT);
                } else {
                    node->setDirection(ui::LoadingBar::Direction::RIGHT);
                }
            }
            else {
                parseWidgetAttribute(parent,node,ele, attr);
            }
            attr = attr->Next();
        }

        addChildNode(parent,node,ele);
        return node;
    }

    ui::Slider *CCEReader::parseSlider(void *parent, tinyxml2::XMLElement *ele) {
        ui::Slider *node = ui::Slider::create();

        const tinyxml2::XMLAttribute *attr = ele->FirstAttribute();
        while (attr) {
            if (strcmp(attr->Name(), "barTexture") == 0) {
                bool isPlistFile = isPlist(attr->Value());
                node->loadBarTexture(getTextureName(attr->Value()), isPlistFile ? ui::TextureResType::PLIST : ui::TextureResType::LOCAL);
            } else if (strcmp(attr->Name(), "ballTextureNormal") == 0) {
                bool isPlistFile = isPlist(attr->Value());
                node->loadSlidBallTextureNormal(getTextureName(attr->Value()), isPlistFile ? ui::TextureResType::PLIST : ui::TextureResType::LOCAL);
            } else if (strcmp(attr->Name(), "ballTexturePressed") == 0) {
                bool isPlistFile = isPlist(attr->Value());
                node->loadSlidBallTexturePressed(getTextureName(attr->Value()), isPlistFile ? ui::TextureResType::PLIST : ui::TextureResType::LOCAL);
            } else if (strcmp(attr->Name(), "ballTextureDisabled") == 0) {
                bool isPlistFile = isPlist(attr->Value());
                node->loadSlidBallTextureDisabled(getTextureName(attr->Value()), isPlistFile ? ui::TextureResType::PLIST : ui::TextureResType::LOCAL);
            }
            else {
                parseWidgetAttribute(parent,node,ele, attr);
            }
            attr = attr->Next();
        }

        addChildNode(parent,node,ele);
        return node;
    }

    ui::CheckBox *CCEReader::parseCheckBox(void *parent, tinyxml2::XMLElement *ele) {
        ui::CheckBox *node = ui::CheckBox::create();

        const tinyxml2::XMLAttribute *attr = ele->FirstAttribute();
        while (attr) {
            if (strcmp(attr->Name(), "textureBackGround") == 0) {
                bool isPlistFile = isPlist(attr->Value());
                node->loadTextureBackGround(getTextureName(attr->Value()), isPlistFile ? ui::TextureResType::PLIST : ui::TextureResType::LOCAL);
            } else if (strcmp(attr->Name(), "textureBackGroundSelected") == 0) {
                bool isPlistFile = isPlist(attr->Value());
                node->loadTextureBackGroundSelected(getTextureName(attr->Value()), isPlistFile ? ui::TextureResType::PLIST : ui::TextureResType::LOCAL);
            } else if (strcmp(attr->Name(), "textureBackGroundDisabled") == 0) {
                bool isPlistFile = isPlist(attr->Value());
                node->loadTextureBackGroundDisabled(getTextureName(attr->Value()), isPlistFile ? ui::TextureResType::PLIST : ui::TextureResType::LOCAL);
            } else if (strcmp(attr->Name(), "textureFrontCrossDisabled") == 0) {
                bool isPlistFile = isPlist(attr->Value());
                node->loadTextureFrontCrossDisabled(getTextureName(attr->Value()), isPlistFile ? ui::TextureResType::PLIST : ui::TextureResType::LOCAL);
            } else if (strcmp(attr->Name(), "textureFrontCross") == 0) {
                bool isPlistFile = isPlist(attr->Value());
                node->loadTextureFrontCross(getTextureName(attr->Value()), isPlistFile ? ui::TextureResType::PLIST : ui::TextureResType::LOCAL);
            } else if (strcmp(attr->Name(), "selected") == 0) {
				node->setSelected( attr->BoolValue());
            }
            else {
                parseWidgetAttribute(parent,node,ele, attr);
            }
            attr = attr->Next();
        }

       addChildNode(parent,node,ele);
        return node;
    }

    ui::ImageView *CCEReader::parseImageView(void *parent, tinyxml2::XMLElement *ele) {
        ui::ImageView *node = ui::ImageView::create();

        const tinyxml2::XMLAttribute *attr = ele->FirstAttribute();
        while (attr) {
            if (strcmp(attr->Name(), "texture") == 0) {
                bool isPlistFile = isPlist(attr->Value());
                node->loadTexture(getTextureName(attr->Value()), isPlistFile ? ui::TextureResType::PLIST : ui::TextureResType::LOCAL);
            }
            else {
                parseWidgetAttribute(parent,node,ele, attr);
            }
            attr = attr->Next();
        }

        addChildNode(parent,node,ele);
        return node;
    }


	ui::RichText *CCEReader::parseRichText(void *parent, tinyxml2::XMLElement *ele){
		ui::RichText *text =  ui::RichText::create();
		const tinyxml2::XMLAttribute *attr = ele->FirstAttribute();
        while (attr) {
            if (equals(attr->Name(), "ignoreContentAdaptWithSize")) {
				text->ignoreContentAdaptWithSize(attr->BoolValue());
			}
            else {
                parseWidgetAttribute(parent,text,ele, attr);
            }
            attr = attr->Next();
        }
		addChildNode(parent,text,ele);
		return text;
	}

	ui::RichElement *CCEReader::parseRichTextElement(void *parent, tinyxml2::XMLElement *ele){
		ui::RichText *richText = (ui::RichText*)parent;

		if(richText==NULL){
			return NULL;
		}

		int tag = ele->IntAttribute("tag");
		const char * color = ele->Attribute("color");
		const char * name = ele->Attribute("name");
		const char * text = ele->Attribute("text");
		const char * fontName = ele->Attribute("fontName");
		const char * image = ele->Attribute("image");
		int fontSize = ele->IntAttribute("fontSize");
		if(text==NULL){
			return NULL;
		}
		if(color==NULL){
			color="#000000";
		}
		if(fontName==NULL){
			fontName = "Marker Felt";
		}
		if(fontSize<=0){
			fontSize = 10;
		}
		Color3B  color3B = getColor3B(color);
		RichElement *element =NULL;
		if(image!=NULL){
			element = RichElementImage::create(tag, color3B, 255,image);
		}else if(text!=NULL){
			element = RichElementText::create(tag, color3B, 255, text, fontName, fontSize);
		}
		if(tag>0){
			 nodes[tag] = element;
		}
		if(name!=NULL){
			nameNodes[name]=element;
		}
		
		richText->pushBackElement(element);
		return element;
	}

    ui::Widget *CCEReader::parseUI(void *parent, tinyxml2::XMLElement *ele) {
        return NULL;
    }

    cocostudio::Armature *CCEReader::parseArmature(void *parent, tinyxml2::XMLElement *ele) {
        return NULL;
    }

    void CleanUpNode::cleanup(){
		//log("CleanUpNode %p", cceReader);
		CC_SAFE_RELEASE(cceReader);
	}

	void CleanUpNode::onEnter(){
		for(int i=0;i<cceReader->getEventHandlers().size();i++){
		  CCEEventHandler *handler=cceReader->getEventHandlers().at(i);
		  if(handler->eventName=="onEnter"){
			  handler->handleActions();
		  }
		}
		//auto dispatcher = Director::getInstance()->getEventDispatcher();
		//dispatcher->dispatchCustomEvent("onEnter",this);
	}

	void CleanUpNode::onExit(){
		for(int i=0;i<cceReader->getEventHandlers().size();i++){
		  CCEEventHandler *handler=cceReader->getEventHandlers().at(i);
		  if(handler->eventName=="onExit"){
			  handler->handleActions();
		  }
		}
		//auto dispatcher = Director::getInstance()->getEventDispatcher();
		//dispatcher->dispatchCustomEvent("onExit",this);
	}

}
