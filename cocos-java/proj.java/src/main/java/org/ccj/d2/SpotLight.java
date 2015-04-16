package org.ccj.d2;

import com.googlecode.javacpp.annotation.*;
import org.ccj.base.Color3B;
import org.ccj.math.Vec3;

/**
 * Created by yuanyou on 2014/12/16.
 */


@Namespace("cocos2d")
@Opaque
public class SpotLight extends BaseLight {
    /**
     * Creates a spot light.
     * @param direction The light's direction
     * @param position The light's position
     * @param color The light's color.
     * @param innerAngle The light's inner angle (in radians).
     * @param outerAngle The light's outer angle (in radians).
     * @param range The light's range.
     *
     * @return The new spot light.
     */
    public native  static SpotLight create(@Const @ByRef Vec3 direction, @Const @ByRef Vec3 position, @Const @ByRef Color3B color, float innerAngle, float outerAngle, float range);

    /**
     * Sets the Direction in parent.
     *
     * @param dir The Direction in parent.
     */
    public native void setDirection(@Const @ByRef Vec3 dir);

    /**
     * Returns the Direction in parent.
     */
    public native Vec3 getDirection() ;

    /**
     * Returns direction in world.
     */
    public native  Vec3 getDirectionInWorld() ;

    /**
     * Sets the range of point or spot light.
     *
     * @param range The range of point or spot light.
     */
    public native  void setRange(float range);

    /**
     * Returns the range of point or spot light.
     *
     * @return The range of the point or spot light.
     */
    public native float getRange() ;
    /**
     * Sets the inner angle of a spot light (in radians).
     *
     * @param angle The angle of spot light (in radians).
     */
    public native void setInnerAngle(float angle);

    /**
     * Returns the inner angle the spot light (in radians).
     */
    public native  float getInnerAngle() ;

    /** get cos innerAngle */
    public native float getCosInnerAngle() ;

    /**
     * Sets the outer angle of a spot light (in radians).
     *
     * @param outerAngle The angle of spot light (in radians).
     */
    public native void setOuterAngle(float angle);

    /**
     * Returns the outer angle of the spot light (in radians).
     */
    public native float getOuterAngle() ;

    /** get cos outAngle */
    public native  float getCosOuterAngle() ;

}
