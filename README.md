# cocoseditor

Cocos2d-Java����

Cocos2d-Java�ǻ���Cocos2d-x��ʹ��Java����������Cocos2d��ƽ̨��Ϸ�����棬 ��-lua��-js ��api�������������ݣ�����ϰ��Java�Ŀ����߿�����ƽ̨��Ϸ

CocosEditor����

�ǻ���Intellij Idea����ƽ̨�Ͻ��ж��ƶ������ֻ���Ϸ���ߣ���������Window/Macϵͳ��1.x�汾֧��js��lua�ű����ԡ� 2.x�汾��֧��Java���ԣ�������Ϸ�������ɿ�����ֲ��Android��iosƽ̨�� �����߼��ϴ���༭���ɼ��ɵõĳ�����ƣ�����������������ƣ�ͼƬ��� �����ӱ༭������ϵͳ����ͼ�ȹ��ܣ��ҵ��Է��㣬��ʵʱģ�⡣

��վ��http://www.cocoseditor.com/
���ͣ�http://blog.cocoseditor.com/
��̳��http://forum.cocoseditor.com/



#### cocos2d-x-3.7.zip ��ѹ����ǰ��cocos2d-x-3.7Ŀ¼��

#### �޸� CCScriptSupport.h �ļ�
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


#### �޸�CCEvent.h

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

#### ��VS��cocos2d-x-3.7\build\cocos2d-win32.sln��Ŀ���� cocoseditor\cocos-java\proj.win32\cocosjava.vcxproj �ӵ� VS��Ŀ��
��cocosjava����Ϊ������,���� ���û�����������cocosjava.dll

#### ���ú�NDK�����󣬽��뵽cocoseditor\cocos-java\proj.android ����build_native������android�µ�so�⣬���û����������libs\armeabi\libcocosjava.so�ļ�
