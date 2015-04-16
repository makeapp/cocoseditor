/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.d2;

import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.ByVal;
import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.Const;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import org.ccj.math.Vec2;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/7/18 9:03 $
 *          $Id$
 */

@Platform(include = "CCParallaxNode.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class ProgressTimer extends Node
{
    /**
     * Types of progress
     *
     * @since v0.99.1
     */
//       enum class Type
//       {
    /// Radial Counter-Clockwise
    public static final int TYPE_RADIAL = 0,
    /// Bar
    TYPE_BAR = 1;
//       };

    /**
     * Creates a progress timer with the sprite as the shape the timer goes through
     */
    public native static ProgressTimer create(Sprite sp);

    /**
     * Change the percentage to change progress.
     */
    @Cast("int")
    public native int getType();


    /**
     * Percentages are from 0 to 100
     */
    public native float getPercentage();

    /**
     * The image to show the progress percentage, retain
     */
    public native Sprite getSprite();

    public native void setPercentage(float percentage);

    public native void setSprite(Sprite sprite);

    public native void setType(@Cast("cocos2d::ProgressTimer::Type") int type);

    /**
     * @js setReverseDirection
     * @lua setReverseDirection
     */
    public native void setReverseProgress(boolean reverse);

    public native boolean isReverseDirection();

    public native void setReverseDirection(boolean value);

    /**
     * Midpoint is used to modify the progress start position.
     * If you're using radials type then the midpoint changes the center point
     * If you're using bar type the the midpoint changes the bar growth
     * it expands from the center but clamps to the sprites edge so:
     * you want a left to right then set the midpoint all the way to Vec2(0,y)
     * you want a right to left then set the midpoint all the way to Vec2(1,y)
     * you want a bottom to top then set the midpoint all the way to Vec2(x,0)
     * you want a top to bottom then set the midpoint all the way to Vec2(x,1)
     */
    public native void setMidpoint(@Const @ByRef Vec2 point);

    /**
     * Returns the Midpoint
     */
    @ByVal
    public native Vec2 getMidpoint();

    /**
     * This allows the bar type to move the component at a specific rate
     * Set the component to 0 to make sure it stays at 100%.
     * For example you want a left to right bar but not have the height stay 100%
     * Set the rate to be Vec2(0,1); and set the midpoint to = Vec2(0,.5f);
     */
    public native void setBarChangeRate(@Const @ByRef Vec2 barChangeRate);

    /**
     * Returns the BarChangeRate
     */
    @ByVal
    public native Vec2 getBarChangeRate();
}
