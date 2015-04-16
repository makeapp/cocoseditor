#include "AppDelegate.h"

#include "cocos2d.h"
#include "SimpleAudioEngine.h"
#include "JavaEngine.h"


USING_NS_CC;
using namespace CocosDenshion;

AppDelegate::AppDelegate()
{
}

AppDelegate::~AppDelegate()
{
     CCLOG("destroyInstance");     
    //ScriptEngineManager::destroyInstance();
}

void AppDelegate::initGLContextAttrs()
{
    GLContextAttrs glContextAttrs = {8, 8, 8, 8, 24, 8};

    GLView::setGLContextAttrs(glContextAttrs);
}

bool AppDelegate::applicationDidFinishLaunching()
{
//    auto pEngine = JavaEngine::getInstance();
//    ScriptEngineManager::getInstance()->setScriptEngine(pEngine);

    //CCLOG("applicationDidFinishLaunching");
    // initialize director
//    CCDirector *pDirector = CCDirector::sharedDirector();

//    auto glview = director->getOpenGLView();
//    if(!glview) {
//        glview = GLView::create("Cpp Empty Test");
//        director->setOpenGLView(glview);
//    }

//    director->setOpenGLView(glview);

//    pDirector->setProjection(kCCDirectorProjection2D);
//    CCLOG("pDirector 2");

//    pDirector->setDisplayStats(true);

    // set FPS. the default value is 1.0/60 if you don't call this
//    pDirector->setAnimationInterval(1.0 / 60);

    ccj::JavaEngine::getInstance()->invoke("applicationDidFinishLaunching","");

    return true;
}

// This function will be called when the app is inactive. When comes a phone call,it's be invoked too
void AppDelegate::applicationDidEnterBackground()
{
    CCLOG("applicationDidEnterBackground");     
    Director::getInstance()->stopAnimation();
    //JavaEngine::getInstance()->invoke("applicationDidEnterBackground","");
    SimpleAudioEngine::getInstance()->pauseBackgroundMusic();
    SimpleAudioEngine::getInstance()->pauseAllEffects();
}

// this function will be called when the app is active again
void AppDelegate::applicationWillEnterForeground()
{
    CCLOG("applicationWillEnterForeground");     
    Director::getInstance()->startAnimation();
    //JavaEngine::getInstance()->invoke("applicationWillEnterForeground","");
    SimpleAudioEngine::getInstance()->resumeBackgroundMusic();
    SimpleAudioEngine::getInstance()->resumeAllEffects();
}
