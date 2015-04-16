package org.ccj.d2;

import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;

/**
 * Created by yuanyou on 2014/12/16.
 */

@Platform(include = "CCLight.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class BaseLight extends Node {

 public static final int    DIRECTIONAL = 0;
    public static final int    POINT = 1;
    public static final int   SPOT = 2;
    public static final int   AMBIENT = 3;

    public static final int LIGHT0 = 1,
    LIGHT1 = 1 << 1,
    LIGHT2 = 1 << 2,
    LIGHT3 = 1 << 3,
    LIGHT4 = 1 << 4,
    LIGHT5 = 1 << 5,
    LIGHT6 = 1 << 6,
    LIGHT7 = 1 << 7,
    LIGHT8 = 1 << 8,
    LIGHT9 = 1 << 9,
    LIGHT10 = 1 << 10,
    LIGHT11 = 1 << 11,
    LIGHT12 = 1 << 12,
    LIGHT13 = 1 << 13,
    LIGHT14 = 1 << 14,
    LIGHT15 = 1 << 15;


    //get light type
    @Cast("int")
    public native int getLightType() ;

    /** intensity getter and setter */
    public native float getIntensity();

    public native void setIntensity(float intensity);

    /**light flag getter and setter*/
    @Cast("int")
    public native int getLightFlag() ;
    public native void setLightFlag(@Cast("LightFlag")int flag);

    /**
     * light enabled getter and setter.
     */
    public native  void setEnabled(boolean enabled);
    public native boolean isEnabled() ;

}
