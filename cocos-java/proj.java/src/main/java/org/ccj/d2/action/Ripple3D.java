/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.d2.action;

import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.Const;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import org.ccj.math.Vec2;
import org.ccj.math.Size;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-2-28 上午11:39 $
 *          $Id$
 */

@Platform(include = "CCActionGrid3d.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class Ripple3D
    extends Grid3DAction
{
    public native Ripple3D clone();

    /**
     * creates the action with radius, number of waves, amplitude, a grid size and duration
     */
    public native static Ripple3D create(float duration, @ByRef @Const Size gridSize, @ByRef @Const Vec2 position, float radius, int waves, float amplitude);

    /**
     * get center position
     */
    @ByRef
    @Const
    public native Vec2 getPosition();

    /**
     * set center position
     */
    public native void setPosition(@ByRef @Const Vec2 position);

    public native float getAmplitude();

    public native void setAmplitude(float fAmplitude);

    public native float getAmplitudeRate();

    public native void setAmplitudeRate(float fAmplitudeRate);

}
