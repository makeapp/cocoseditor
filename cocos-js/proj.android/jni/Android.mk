LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE := cocosjs

LOCAL_ARM_MODE := arm

LOCAL_MODULE_FILENAME := libcocosjs

LOCAL_SRC_FILES := main.cpp \
                   ../../Classes/AppDelegate.cpp \
                   ../../Classes/jsb_cocos2dx_cocoseditor_auto.cpp \
                   ../../../Classes/Cocos2dFunction.cpp \
                   ../../../Classes/FunctionFactory.cpp \
                   ../../../Classes/CCEAnimation.cpp \
                   ../../../Classes/CCEAnimationManager.cpp \
                   ../../../Classes/CCEKeyFrame.cpp \
                   ../../../Classes/CCEEventHandler.cpp \
                   ../../../Classes/CCEChannel.cpp \
                   ../../../Classes/CCEReader.cpp

LOCAL_C_INCLUDES := $(LOCAL_PATH)/../../Classes \
                    $(LOCAL_PATH)/../../../Classes


LOCAL_STATIC_LIBRARIES := cocos2dx_static
LOCAL_STATIC_LIBRARIES += cocos_localstorage_static
LOCAL_STATIC_LIBRARIES += cocos_jsb_static

LOCAL_EXPORT_CFLAGS := -DCOCOS2D_DEBUG=1

include $(BUILD_SHARED_LIBRARY)

$(call import-module,scripting/js-bindings)