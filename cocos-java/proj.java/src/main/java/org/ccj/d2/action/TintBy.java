/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.d2.action;

import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-2-28 上午11:39 $
 *          $Id$
 */

/**
 * @brief Tints a Node that implements the NodeRGB protocol from current tint to a custom one.
 * @since v0.7.2
 */
@Platform(include = "CCActionInterval.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class TintBy
    extends ActionInterval
{
    /**
     * creates an action with duration and color
     */
    public native static TintBy create(float duration, @Cast("GLshort") int deltaRed, @Cast("GLshort") int deltaGreen, @Cast("GLshort") int deltaBlue);

    //
    // Overrides
    //
    public native TintBy clone();

    public native TintBy reverse();

}
