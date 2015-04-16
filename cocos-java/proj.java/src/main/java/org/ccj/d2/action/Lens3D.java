/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.d2.action;

import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.Cast;
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
public class Lens3D
    extends Grid3DAction
{
    public native Lens3D clone();

    /**
     * creates the action with center position, radius, a grid size and duration
     */
    public native static Lens3D create(float duration, @Const @ByRef Size gridSize, @Const @ByRef Vec2 position, float radius);

    /**
     * Get lens center position
     */
    public native float getLensEffect();

    /**
     * Set lens center position
     */
    public native void setLensEffect(float lensEffect);

    /**
     * Set whether lens is concave
     */
    public native void setConcave(@Cast("bool") boolean concave);

    @Const
    @ByRef
    public native Vec2 getPosition();

    public native void setPosition(@Const @ByRef Vec2 position);
}
