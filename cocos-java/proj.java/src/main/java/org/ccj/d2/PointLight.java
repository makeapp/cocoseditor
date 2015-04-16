package org.ccj.d2;

import com.googlecode.javacpp.annotation.*;
import org.ccj.base.Color3B;
import org.ccj.math.Vec3;

/**
 * Created by yuanyou on 2014/12/16.
 */


@Namespace("cocos2d")
@Opaque
public class PointLight extends BaseLight {
    /**
     * Creates a point light.
     * @param position The light's position
     * @param color The light's color.
     * @param range The light's range.
     *
     * @return The new point light.
     */
   public native static PointLight create(@Const @ByRef Vec3 position, @Const @ByRef Color3B color, float range);

    /** get or set range */
    public native  float getRange();
    public native void setRange(float range) ;
}
