LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE := cocoslua

LOCAL_MODULE_FILENAME := libcocoslua

LOCAL_SRC_FILES := main.cpp \
                   ../../Classes/AppDelegate.cpp

LOCAL_C_INCLUDES := $(LOCAL_PATH)/../../Classes \
                    $(LOCAL_PATH)/../../../../../external/lua/tolua \


LOCAL_WHOLE_STATIC_LIBRARIES = cocos2dx_static
LOCAL_WHOLE_STATIC_LIBRARIES += cocosdenshion_static
LOCAL_WHOLE_STATIC_LIBRARIES += cocosbuilder_static
LOCAL_WHOLE_STATIC_LIBRARIES += cocostudio_static
LOCAL_WHOLE_STATIC_LIBRARIES += cocoseditor_static
LOCAL_WHOLE_STATIC_LIBRARIES += cocos_network_static
LOCAL_WHOLE_STATIC_LIBRARIES += cocos_extension_static
LOCAL_WHOLE_STATIC_LIBRARIES += cocos_localstorage_static
LOCAL_WHOLE_STATIC_LIBRARIES += cocos_lua_static

LOCAL_CXXFLAGS += -fpermissive

include $(BUILD_SHARED_LIBRARY)

$(call import-module,editor-support/cocosbuilder)
$(call import-module,editor-support/cocoseditor)
$(call import-module,editor-support/cocostudio)
$(call import-module,network)
$(call import-module,.)
$(call import-module,audio/android)
$(call import-module,storage/local-storage)
$(call import-module,scripting/lua-bindings)
