LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE := cocosjava

LOCAL_MODULE_FILENAME := libcocosjava

LOCAL_SRC_FILES := main.cpp  \
                    ../../Classes/AppDelegate.cpp \
                    ../../Classes/JavaEngine.cpp    \
                    ../../Classes/JavaEngineJNI.cpp    \
                    ../../Classes/JavaCallFunc.cpp   \
                    ../../Classes/JavaStorageClass.cpp  \
                    ../../Classes/JavaEventListener.cpp  \
                    ../../Classes/JavaEventListenerTouchAllAtOnce.cpp  \
                    ../../Classes/JavaEventListenerTouchOneByOne.cpp  \
                    ../../Classes/JavaWebSocketDelegate.cpp \
                    ../../Classes/JavaPhysicsContactListener.cpp  \
                    ../../../Classes/FunctionFactory.cpp \
                    ../../../Classes/CCEAnimation.cpp \
                    ../../../Classes/CCEAnimationManager.cpp \
                    ../../../Classes/CCEKeyFrame.cpp \
                    ../../../Classes/CCEEventHandler.cpp \
                    ../../../Classes/CCEChannel.cpp \
                    ../../../Classes/CCEReader.cpp \
                    ../../../Classes/CCEInputDelegate.cpp \
                    ../../../Classes/CCEController.cpp


LOCAL_C_INCLUDES := $(LOCAL_PATH)/../../Classes \
                    $(LOCAL_PATH)/../../../Classes \
                    $(LOCAL_PATH)/../../..extensions \
                    $(LOCAL_PATH)/../../../.. \
                    $(LOCAL_PATH)/../../../../cocos/2d \
                    $(LOCAL_PATH)/../../../../cocos/3d \
                    $(LOCAL_PATH)/../../../../cocos/renderer \
                    $(LOCAL_PATH)/../../../../cocos/audio \
                    $(LOCAL_PATH)/../../../../cocos/math \
                    $(LOCAL_PATH)/../../../../cocos/network \
                    $(LOCAL_PATH)/../../../../cocos/physics \
                    $(LOCAL_PATH)/../../../../cocos/storage \
                    $(LOCAL_PATH)/../../../../cocos/ui \
                    $(LOCAL_PATH)/../../../../cocos/base \
                    $(LOCAL_PATH)/../../../../cocos/deprecated \
                    $(LOCAL_PATH)/../../../../cocos/editor-support

LOCAL_STATIC_LIBRARIES := cocos2dx_static
LOCAL_STATIC_LIBRARIES += cocos_localstorage_static
LOCAL_CXXFLAGS += -fpermissive
include $(BUILD_SHARED_LIBRARY)

$(call import-module,.)
$(call import-module,storage/local-storage)