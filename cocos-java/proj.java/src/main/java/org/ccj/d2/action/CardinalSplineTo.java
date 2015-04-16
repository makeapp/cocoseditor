/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.d2.action;

import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import org.ccj.math.Vec2;
import org.ccj.base.PointArray;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-2-28 上午11:39 $
 *          $Id$
 */

@Platform(include = "CCActionCatmullRom.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class CardinalSplineTo
    extends ActionInterval
{
    public native CardinalSplineTo clone();

    public native CardinalSplineTo reverse();


    /**
     * creates an action with a Cardinal Spline array of points and tension
     *
     * @code when this function bound to js or lua,the input params are changed
     * in js: var create(var t,var table)
     * in lua: lcaol create(local t, local table)
     * @endcode
     */
    public native static CardinalSplineTo create(float duration, PointArray points, float tension);


    /**
     * initializes the action with a duration and an array of points
     */
    public native boolean initWithDuration(float duration, PointArray points, float tension);

    public native void updatePosition(@ByRef Vec2 newPos);

    public native PointArray getPoints();

    /**
     * @js NA
     * @lua NA
     */
    public native void setPoints(PointArray points);
}
