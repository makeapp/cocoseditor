package org.ccj.d2;

import com.googlecode.javacpp.annotation.*;
import org.ccj.base.Color3B;
import org.ccj.math.Vec3;

/**
 * Created by yuanyou on 2014/12/16.
 */


@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class DirectionLight extends BaseLight {
    /**
     * Creates a direction light.
     * @param direction The light's direction
     * @param color The light's color.
     *
     * @return The new direction light.
     */
   public native static DirectionLight create(@Const @ByRef Vec3 direction, @Const @ByRef Color3B color);

    /**
     * Sets the Direction in parent.
     *
     * @param dir The Direction in parent.
     */
    public native void setDirection(@Const @ByRef Vec3 dir);

    /**
     * Returns the Direction in parent.
     */
    @ByVal
    public native Vec3 getDirection() ;

    /**
     * Returns direction in world.
     */
    @ByVal
    public native Vec3 getDirectionInWorld() ;
}
