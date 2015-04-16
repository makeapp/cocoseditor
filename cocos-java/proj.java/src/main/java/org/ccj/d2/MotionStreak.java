/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.d2;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.Const;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import com.googlecode.javacpp.annotation.StdString;
import org.ccj.base.Color3B;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/4/25 15:55 $
 *          $Id$
 */

@Platform(include = "CCMotionStreak.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class MotionStreak extends Node
{
    public MotionStreak(Pointer p)
    {
        super(p);
    }

    /**
     * creates and initializes a motion streak with fade in seconds, minimum segments, stroke's width, color, texture filename
     */
    public native static MotionStreak create(float fade, float minSeg, float stroke, @Const @ByRef Color3B color, @StdString String path);

    /**
     * creates and initializes a motion streak with fade in seconds, minimum segments, stroke's width, color, texture
     */
    public native static MotionStreak create(float fade, float minSeg, float stroke, @Const @ByRef Color3B color, Texture2D texture);

    /**
     * color used for the tint
     */
    public native void tintWithColor(@Const @ByRef Color3B colors);

    /**
     * Remove all living segments of the ribbon
     */
    public native void reset();

    /**
     * When fast mode is enabled, new points are added faster but with lower precision
     */
    public native boolean isFastMode();

    public native void setFastMode(boolean bFastMode);

    public native boolean isStartingPositionInitialized();

    public native void setStartingPositionInitialized(boolean bStartingPositionInitialized);

    public native Texture2D getTexture();

    public native void setTexture(Texture2D texture);

}
