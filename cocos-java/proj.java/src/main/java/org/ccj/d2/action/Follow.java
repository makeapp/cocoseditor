/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.d2.action;

import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.Const;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import org.ccj.d2.Node;
import org.ccj.math.Rect;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-2-28 上午11:39 $
 *          $Id$
 */

@Platform(include = "CCAction.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class Follow
    extends Action
{
    /**
     * Creates the action with a set boundary or with no boundary.
     *
     * @param followedNode The node to be followed.
     * @param rect         The boundary. If \p rect is equal to Rect::ZERO, it'll work
     *                     with no boundary.
     */
    public native static Follow create(Node followedNode, @ByRef @Const Rect rect);

    public native boolean isBoundarySet();

    /**
     * alter behavior - turn on/off boundary
     */
    public native void setBoudarySet(@Cast("bool") boolean value);

    //
    // Override
    //
    public native Follow clone();

    public native Follow reverse();

}
