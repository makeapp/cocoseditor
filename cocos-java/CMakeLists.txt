set(APP_NAME cocosjdk)
set(APP_EXE_NAME cocosjvm)
set(APP_LIB_NAME cocosjava)
set(COCOSAWT_NAME cocosjawt)


if(QT)
  set(PLATFORM_SRC proj.qt/main.cpp )
elseif(ANDROID)
  set(PLATFORM_SRC proj.android/jni/main.cpp )
elseif(WIN32)
#  set(PLATFORM_SRC proj.win32/main.cpp)
  set(PLATFORM_INCLUDE D:/develop/Java/jdk1.7.0-32/include D:/develop/Java/jdk1.7.0-32/include/win32 )
elseif(APPLE)
  if(IOS)
    set(PLATFORM_SRC proj.ios/main.m proj.ios/AppController.mm proj.ios/RootViewController.mm )
  else()
    set(PLATFORM_SRC proj.mac/main.m )
  endif()
else()
  set(PLATFORM_SRC proj.linux/main.cpp )
endif()

set(APP_SRC
  ${PLATFORM_SRC}
  Classes/AppDelegate.cpp
  Classes/JavaEngineJNI.cpp
  Classes/JavaEngine.cpp
  Classes/JavaCallFunc.cpp
  Classes/JavaStorageClass.cpp
  Classes/JavaComController.cpp
  Classes/JavaWebSocketDelegate.cpp
  Classes/JavaPhysicsContactListener.cpp
  Classes/JavaTriggerCondition.cpp
  Classes/JavaTriggerAction.cpp
  Classes/Function.cpp
)

include_directories(
    ../../cocos
    ../../cocos/gui
    ../../cocos/math/kazmath/include/kazmath
    external/jvm/include
    external/jvm/classpath
    Classes
    ${PLATFORM_INCLUDE}
)

# add the executable

if(WIN32)
	link_directories(${CMAKE_CURRENT_SOURCE_DIR}/external/jvm/prebuilt/win32)
  add_library(${APP_LIB_NAME} SHARED ${APP_SRC})
  add_library(${COCOSAWT_NAME} SHARED Classes/JavaGLCanvas.cpp)
  add_executable(${APP_EXE_NAME} ${APP_SRC} proj.win32/main.cpp)

  

elseif(ANDROID)
  add_library(${APP_LIB_NAME} SHARED ${APP_SRC})
endif()

if(WIN32 AND MSVC)
  #Visual Studio Defaults to wrong type
  set_target_properties(${APP_EXE_NAME} PROPERTIES LINK_FLAGS_DEBUG "/SUBSYSTEM:console /force:multiple")
  set_target_properties(${APP_EXE_NAME} PROPERTIES LINK_FLAGS_RELEASELINK_FLAGS_RELEASE "/SUBSYSTEM:console /force:multiple")
endif()


if(WIN32)
 set(APP_BIN_DIR "${CMAKE_BINARY_DIR}/bin/${APP_NAME}")
 set_target_properties(${APP_EXE_NAME} PROPERTIES RUNTIME_OUTPUT_DIRECTORY  "${APP_BIN_DIR}")
 set_target_properties(${APP_EXE_NAME} PROPERTIES RUNTIME_OUTPUT_DIRECTORY  "${APP_BIN_DIR}")
 set_target_properties(${APP_LIB_NAME} PROPERTIES RUNTIME_OUTPUT_DIRECTORY  "${APP_BIN_DIR}")
 set_target_properties(${APP_LIB_NAME} PROPERTIES RUNTIME_OUTPUT_DIRECTORY  "${APP_BIN_DIR}")
 set_target_properties(${COCOSAWT_NAME} PROPERTIES RUNTIME_OUTPUT_DIRECTORY  "${APP_BIN_DIR}")
 set_target_properties(${COCOSAWT_NAME} PROPERTIES RUNTIME_OUTPUT_DIRECTORY  "${APP_BIN_DIR}")
elseif(ANDROID)
 set_target_properties(${APP_LIB_NAME}
     PROPERTIES
     ARCHIVE_OUTPUT_DIRECTORY "${CMAKE_BINARY_DIR}/bin/${APP_NAME}/${ARCH_DIR}"
     LIBRARY_OUTPUT_DIRECTORY "${CMAKE_BINARY_DIR}/bin/${APP_NAME}/${ARCH_DIR}"
 )
endif()

target_link_libraries(${APP_EXE_NAME}
  cocos2d
  cocosbuilder
  cocostudio
  extensions
  audio
  curl
  jvm
  ws2_32
  ${PLATFORM_LIB}
  )
  
target_link_libraries(${APP_LIB_NAME}
  cocos2d
  cocosbuilder
  cocostudio
  extensions
  audio
  curl
  ws2_32
  ${PLATFORM_LIB}
  )

target_link_libraries(${COCOSAWT_NAME} jawt)