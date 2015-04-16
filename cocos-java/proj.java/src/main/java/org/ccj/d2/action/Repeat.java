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
 * @brief Repeats an action a number of times.
 * To repeat an action forever use the RepeatForever action.
 */
@Platform(include = "CCActionInterval.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class Repeat
    extends ActionInterval
{
    /**
     * creates a Repeat action. Times is an unsigned integer between 1 and pow(2,30)
     */
    public native static Repeat create(FiniteTimeAction action, int times);

    //
    // Overrides
    //
    public native Repeat clone();

    public native Repeat reverse();

}
