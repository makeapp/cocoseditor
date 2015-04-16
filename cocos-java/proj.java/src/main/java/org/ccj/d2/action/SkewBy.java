/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.d2.action;

import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-2-28 上午11:39 $
 *          $Id$
 */

/**
 * Skews a Node object by skewX and skewY degrees
 *
 * @since v1.0
 */
@Platform(include = "CCActionInterval.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class SkewBy
    extends SkewTo
{

    /**
     * creates the action
     */
    public native static SkewBy create(float t, float deltaSkewX, float deltaSkewY);

    //
    // Overrides
    //
//    public native void startWithTarget(Node *target) override;
    public native SkewBy clone();

    public native SkewBy reverse();
}
