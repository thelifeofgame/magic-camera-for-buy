LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

OPENCV_CAMERA_MODULES := on

OPENCV_INSTALL_MODULES := on

OPENCV_LIB_TYPE := SHARED

include C:\Users\Administrator\workspace\sdk-opencv\native\jni\OpenCV.mk

 

LOCAL_SRC_FILES  := My9_4-master.cpp

LOCAL_C_INCLUDES += $(LOCAL_PATH)

LOCAL_LDLIBS     += -llog -ldl

 

LOCAL_MODULE     := My9_4-master

include $(BUILD_SHARED_LIBRARY)
