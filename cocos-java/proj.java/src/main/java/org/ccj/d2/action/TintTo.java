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
 * @warning This action doesn't support "reverse"
 * @since v0.7.2
 */
@Platform(include = "CCActionInterval.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class TintTo
    extends ActionInterval
{
    /**
     * creates an action with duration and color
     */
    public native static TintTo create(float duration, @Cast("GLubyte") byte red, @Cast("GLubyte") byte green, @Cast("GLubyte") byte blue);

    //
    // Overrides
    //
    public native TintTo clone();

    public native TintTo reverse();

}
