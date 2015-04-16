package org.ccj.d2;

import com.googlecode.javacpp.annotation.*;
import org.ccj.base.Color3B;
import org.ccj.math.Vec3;

/**
 * Created by yuanyou on 2014/12/16.
 */


@Namespace("cocos2d")
@Opaque
public class AmbientLight extends BaseLight {
    /**
     * Creates a ambient light.
     * @param color The light's color.
     *
     * @return The new ambient light.
     */
    public native  static AmbientLight create(@Const @ByRef Color3B color);

}
