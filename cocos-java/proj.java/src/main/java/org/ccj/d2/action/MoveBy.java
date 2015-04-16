/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.d2.action;

import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.Const;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import org.ccj.math.Vec2;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-2-28 上午11:39 $
 *          $Id$
 */


/**
 * Moves a Node object x,y pixels by modifying it's position attribute.
 * x and y are relative to the position of the object.
 * Several MoveBy actions can be concurrently called, and the resulting
 * movement will be the sum of individual movements.
 *
 * @since v2.1beta2-custom
 */
@Platform(include = "CCActionInterval.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class MoveBy
    extends ActionInterval
{

    /**
     * creates the action
     */
    public native static MoveBy create(float duration, @ByRef @Const Vec2 deltaPosition);

    //
    // Overrides
    //
    public native MoveBy clone();

    public native MoveBy reverse();
}
