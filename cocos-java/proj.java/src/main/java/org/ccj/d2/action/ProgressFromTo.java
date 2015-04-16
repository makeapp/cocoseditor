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

@Platform(include = "CCActionProgressTimer.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class ProgressFromTo
    extends ActionInterval
{
    public native ProgressFromTo clone();

    public native ProgressFromTo reverse();

    /**
     * Creates and initializes with a duration and a percent
     */
    public native static ProgressFromTo create(float duration, float fromPercentage, float toPercentage);

}
