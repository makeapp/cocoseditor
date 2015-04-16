#include "../Classes/AppDelegate.h"
#include "CCGLView.h"
#include "cocos2d.h"
#include "main.h"
#include "jni.h"
#include "jvm.h"
#include "JavaEngine.h"

USING_NS_CC;

void JVMOnLoad0(JavaVM* vm)
{
   JNI_OnLoad(vm,NULL);
}

// uncomment below line, open debug console
#define USE_WIN32_CONSOLE

int main(int argc,const char **argv) {
     auto pEngine = JavaEngine::getInstance();
     ScriptEngineManager::getInstance()->setScriptEngine(pEngine);
     printf("Loading JavaEngine %d \n",pEngine);
     const char* args[] = {"java","-Xbootclasspath/a:./classpath.jar","-cp","./cocosplayer-1.0-SNAPSHOT.jar;./cocosplayer-1.0-SNAPSHOT-tests.jar","cc.TestMain"};
     launchVm(argc,argv,JVMOnLoad0);
  return 0;
}

//int APIENTRY _tWinMain(HINSTANCE hInstance,
//                       HINSTANCE hPrevInstance,
//                       LPTSTR    lpCmdLine,
//                       int       nCmdShow)
//{
//    UNREFERENCED_PARAMETER(hPrevInstance);
//    UNREFERENCED_PARAMETER(lpCmdLine);
//
//#ifdef USE_WIN32_CONSOLE
//    AllocConsole();
//    freopen("CONIN$", "r", stdin);
//    freopen("CONOUT$", "w", stdout);
//    freopen("CONOUT$", "w", stderr);
//#endif
//
//
//  AppDelegate app;
//  //GLView eglView;
//  //eglView.init("CocosPlayer",960,600);
//  int ret = Application::getInstance()->run();
//
////    printf("Loading jvm ... \n");
//
//    /*auto pEngine = JavaEngine::getInstance();
//    ScriptEngineManager::getInstance()->setScriptEngine(pEngine);
//    printf("Loading JavaEngine %d \n",pEngine);
//    const char* args[] = {"java","-Xbootclasspath/a:./classpath.jar","-cp","./cocos2dx-java-1.0-SNAPSHOT.jar","cc.Main"};
//    launchVm1(5,args);
//    launchVm2(5,args);
//    launchVm4();
//    launchVm(5,args,JVMOnLoad0);
//    Sleep(1000000);*/
//
//#ifdef USE_WIN32_CONSOLE
//    FreeConsole();
//#endif
//
//    return 0;
//}
//