# cocoseditor

Cocos2d-Java引擎

Cocos2d-Java是基于Cocos2d-x，使用Java语言来开发Cocos2d跨平台游戏的引擎， 和-lua，-js 的api风格相近，方便快捷，便于习惯Java的开发者开发跨平台游戏

CocosEditor工具

是基于Intellij Idea开放平台上进行定制而来的手机游戏工具，可运行在Window/Mac系统，1.x版本支持js和lua脚本语言。 2.x版本暂支持Java语言，所有游戏发布包可快速移植到Android和ios平台。 本工具集合代码编辑，可见可得的场景设计，动画制作，字体设计，图片打包 、粒子编辑，物理系统，地图等功能，且调试方便，和实时模拟。

网站：http://www.cocoseditor.com/
博客：http://blog.cocoseditor.com/
论坛：http://forum.cocoseditor.com/



#### cocos2d-x-3.7.zip 解压到当前的cocos2d-x-3.7目录下

#### 修改 CCScriptSupport.h 文件
 enum ScriptEventType
{
    kNodeEvent = 0,
    kMenuClickedEvent,
    kCallFuncEvent,
    kScheduleEvent,
    kTouchEvent,
    kTouchesEvent,
    kKeypadEvent,
    kAccelerometerEvent,
    kControlEvent,
    kCommonEvent,
    kComponentEvent,
    kRestartGame,kKeypadEventPress,kKeypadEventRelease
};


#### 修改CCEvent.h

void setSourceId(std::string  id){
		this->sourceId = id;
	}

	std::string  getSourceId(){
		return this->sourceId;
	}
	
	 std::string  sourceId;
	 
#### CCEventKeyboard.h

	 KeyCode getKeyCode(){
		 return _keyCode;
	 }	 

#### javaactivity-android.cpp
  /*JNIEXPORT jint JNI_OnLoad(JavaVM *vm, void *reserved)
{
    JniHelper::setJavaVM(vm);

    cocos_android_app_init(JniHelper::getEnv());

    return JNI_VERSION_1_4;
}*/
  
  
#### cd cocos2d-x-3.7 git clone https://github.com/makeapp/cocoseditor.git

#### 用VS打开cocos2d-x-3.7\build\cocos2d-win32.sln项目，把 cocoseditor\cocos-java\proj.win32\cocosjava.vcxproj 加到 VS项目中
把cocosjava设置为启动项,运行 如果没有问题会生成cocosjava.dll

#### 配置好NDK环境后，进入到cocoseditor\cocos-java\proj.android 运行build_native会生成android下的so库，如果没有问题会产生libs\armeabi\libcocosjava.so文件
