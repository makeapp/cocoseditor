package org.ccj;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;

/**
 * Created by yuanyou on 2015/1/2.
 */

@Platform(include = "CCDevice.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class Device extends Pointer {

    public static final int     CENTER        = 0x33, ///< Horizontal center and vertical center.
        TOP           = 0x13, ///< Horizontal center and vertical top.
        TOP_RIGHT     = 0x12, ///< Horizontal right and vertical top.
        RIGHT         = 0x32, ///< Horizontal right and vertical center.
        BOTTOM_RIGHT = 0x22, ///< Horizontal right and vertical bottom.
        BOTTOM        = 0x23, ///< Horizontal center and vertical bottom.
        BOTTOM_LEFT  = 0x21, ///< Horizontal left and vertical bottom.
        LEFT          = 0x31, ///< Horizontal left and vertical center.
        TOP_LEFT      = 0x11; ///< Horizontal left and vertical top.

    /**
     *  Gets the DPI of device
     *  @return The DPI of device.
     */
  public native  static int getDPI();

    /**
     * To enable or disable accelerometer.
     */
    public native  static void setAccelerometerEnabled(boolean isEnabled);
    /**
     *  Sets the interval of accelerometer.
     */
    public native  static void setAccelerometerInterval(float interval);

//    public native  static Data getTextureDataForText(const char * text, const FontDefinition& textDefinition, TextAlign align, int &width, int &height, bool& hasPremultipliedAlpha);

    public native  static void setKeepScreenOn(boolean value);

}
