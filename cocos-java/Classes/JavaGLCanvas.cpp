#include "AppDelegate.h"

#include <jni.h>
#include <jawt_md.h>
#include <windows.h>
#include "JavaGLCanvas.h"
//#include "cocos2d.h"

static HGLRC    hRC = NULL;
static HDC        hDC = NULL;
#define _DEBUG 1

#define JLONG_TO_PTR(a) ((void*)(uintptr_t)(a))
#define PTR_TO_JLONG(a) ((jlong)(uintptr_t)(a))

extern "C" {

/*
 * Class:     MyWindow
 * Method:    initializeOpenGL
 * Signature: ()V
 */


JNIEXPORT jint JNICALL Java_org_ccj_GLCanvas_getHWND(JNIEnv *env,jclass jclazz, jobject canvas)
{
//    get the window handle
    GLCanvasInfo info(env, canvas);
    HWND hWnd = (HWND)info.getHWND();
     printf("get hwnd %d \n",(int)hWnd);
     printf("get getHDC %d \n",(int)info.getHDC());
    if(hWnd == NULL){
      return NULL;
    }else{
      void* address = hWnd;
      return (int)address;
    }

  return 0;
}



//CGLWindowLite::setPixelFormat(HDC hdc, int colorBits, int depthBits, int stencilBits)
//{
//  PIXELFORMATDESCRIPTOR pfd;
//
//  // find out the best matched pixel format
//  int pixelFormat = findPixelFormat(hdc, colorBits, depthBits, stencilBits);
//  if(pixelFormat == 0)
//    return false;
//
//  // set members of PIXELFORMATDESCRIPTOR with given mode ID
//  ::DescribePixelFormat(hdc, pixelFormat, sizeof(pfd), &pfd);
//
//  // set the fixel format
//  if(!::SetPixelFormat(hdc, pixelFormat, &pfd))
//    return false;
//
//  return true;
//}


}