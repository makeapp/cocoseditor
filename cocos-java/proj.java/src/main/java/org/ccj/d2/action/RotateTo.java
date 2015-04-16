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
 * @brief Rotates a Node object to a certain angle by modifying it's
 * rotation attribute.
 * The direction will be decided by the shortest angle.
 */
@Platform(include = "CCActionInterval.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class RotateTo
    extends ActionInterval
{
    /**
     * creates the action with separate rotation angles
     */
    public native static RotateTo create(float duration, float deltaAngleX, float deltaAngleY);

    /**
     * creates the action
     */
    public native static RotateTo create(float duration, float deltaAngle);

    //
    // Overrides
    //
    public native RotateTo clone();

    public native RotateTo reverse();

}
