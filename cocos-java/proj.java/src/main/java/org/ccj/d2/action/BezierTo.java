/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.d2.action;

import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.Const;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-2-28 上午11:39 $
 *          $Id$
 */

/**
 * @brief An action that moves the target with a cubic Bezier curve by a certain distance.
 */
@Platform(include = "CCActionInterval.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class BezierTo
    extends ActionInterval
{
    /**
     * creates the action with a duration and a bezier configuration
     *
     * @code when this function bound to js or lua,the input params are changed
     * in js: var create(var t,var table)
     * in lua: lcaol create(local t, local table)
     * @endcode
     */
    public native static BezierTo create(float t, @ByRef @Const BezierConfig c);

    //
    // Overrides
    //
//     public native  void startWithTarget(Node *target) override;
//    public native BezierTo clone();

//    public native BezierTo reverse();

}
