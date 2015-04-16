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
 * @brief Moves a Node object to a parabolic position simulating a jump movement by modifying it's position attribute.
 */
@Platform(include = "CCActionInterval.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class JumpBy
    extends ActionInterval
{
    /**
     * creates the action
     */
    public native static JumpBy create(float duration, @ByRef @Const Vec2 position, float height, int jumps);

    //
    // Overrides
    //
    public native JumpBy clone();

    public native JumpBy reverse();


}
