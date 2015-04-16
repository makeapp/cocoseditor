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
public class Twirl
    extends Grid3DAction
{
    public native Twirl clone();

    /**
     * creates the action with center position, number of twirls, amplitude, a grid size and duration
     */
    public native static Twirl create(float duration, @Const @ByRef Size gridSize, @Const @ByRef Vec2 position, int twirls, float amplitude);

    /**
     * get twirl center
     */
    @Const
    @ByRef
    public native Vec2 getPosition();

    /**
     * set twirl center
     */
    public native void setPosition(@Const @ByRef Vec2 position);

    public native float getAmplitude();

    public native void setAmplitude(float amplitude);

    public native float getAmplitudeRate();

    public native void setAmplitudeRate(float amplitudeRate);

}
