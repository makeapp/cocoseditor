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

@Platform(include = "CCActionInterval.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class BezierBy
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
    public native static BezierBy create(float t, @ByRef @Const BezierConfig c);

    //
    // Overrides
    //
    public native BezierBy clone();

    public native BezierBy reverse();
}
