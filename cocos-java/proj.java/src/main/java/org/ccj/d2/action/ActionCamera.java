/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.d2.action;

import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.Const;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import org.ccj.math.Vec3;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-2-28 上午11:39 $
 *          $Id$
 */

@Platform(include = "CCActionCamera.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class ActionCamera
    extends ActionInterval
{
    public native ActionCamera clone();

    public native ActionCamera reverse();


    /* sets the Eye value of the Camera */
    public native void setEye(@Const @ByRef Vec3 eye);

    public native void setEye(float x, float y, float z);

    /* returns the Eye value of the Camera */
    @Const
    @ByRef
    public native Vec3 getEye();

    /* sets the Center value of the Camera */
    public native void setCenter(@Const @ByRef Vec3 center);

    /* returns the Center value of the Camera */
    @Const
    @ByRef
    public native Vec3 getCenter();

    /* sets the Up value of the Camera */
    public native void setUp(@Const @ByRef Vec3 up);

    /* Returns the Up value of the Camera */
    @Const
    @ByRef
    public native Vec3 getUp();
}
