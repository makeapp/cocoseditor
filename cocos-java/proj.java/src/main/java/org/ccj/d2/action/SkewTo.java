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
 * Skews a Node object to given angles by modifying it's skewX and skewY attributes
 *
 * @since v1.0
 */
@Platform(include = "CCActionInterval.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class SkewTo
    extends ActionInterval
{
    /**
     * creates the action
     */
    public native static SkewTo create(float t, float sx, float sy);

    //
    // Overrides
    //
    public native SkewTo clone();

    public native SkewTo reverse();

}
