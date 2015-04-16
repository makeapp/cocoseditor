/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.d2.action;

import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.Const;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import org.ccj.math.Size;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-2-28 上午11:39 $
 *          $Id$
 */

@Platform(include = "CCActionGrid3d.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class Waves3D
    extends Grid3DAction
{
    public native Waves3D clone();

    /**
     * creates an action with duration, grid size, waves and amplitude
     */
    public native static Waves3D create(float duration, @Const @ByRef Size gridSize, int waves, float amplitude);

    /**
     * returns the amplitude of the effect
     */
    public native float getAmplitude();

    /**
     * sets the amplitude to the effect
     */
    public native void setAmplitude(float amplitude);

    /**
     * returns the amplitude rate
     */
    public native float getAmplitudeRate();

    /**
     * sets the ampliture rate
     */
    public native void setAmplitudeRate(float amplitudeRate);

}
