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
public class Waves
    extends Grid3DAction
{
    public native Waves clone();

    /**
     * initializes the action with amplitude, horizontal sin, vertical sin, a grid and duration
     */
    public native static Waves create(float duration, @ByRef @Const Size gridSize, int waves, float amplitude, boolean horizontal, boolean vertical);

    public native float getAmplitude();

    public native void setAmplitude(float amplitude);

    public native float getAmplitudeRate();

    public native void setAmplitudeRate(float amplitudeRate);

}
