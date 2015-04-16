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
 * @brief Scales a Node object to a zoom factor by modifying it's scale attribute.
 * @warning This action doesn't support "reverse"
 */
@Platform(include = "CCActionInterval.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class ScaleTo
    extends ActionInterval
{
    /**
     * creates the action with the same scale factor for X and Y
     */
    public native static ScaleTo create(float duration, float s);

    /**
     * creates the action with and X factor and a Y factor
     */
    public native static ScaleTo create(float duration, float sx, float sy);

    //
    // Overrides
    //
    public native ScaleTo clone();

    public native ScaleTo reverse();

}
