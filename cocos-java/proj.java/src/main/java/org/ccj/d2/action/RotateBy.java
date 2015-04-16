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

/**
 * @brief Rotates a Node object clockwise a number of degrees by modifying it's rotation attribute.
 */
@Platform(include = "CCActionInterval.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class RotateBy
    extends ActionInterval
{

    /**
     * creates the action
     */
    public native static RotateBy create(float duration, float deltaAngle);

    public native static RotateBy create(float duration, float deltaAngleX, float deltaAngleY);
    public native static RotateBy  create(float duration, @Const @ByRef Vec3 deltaAngle3D);
    //
    // Override
    //
    public native RotateBy clone();

    public native RotateBy reverse();
}
