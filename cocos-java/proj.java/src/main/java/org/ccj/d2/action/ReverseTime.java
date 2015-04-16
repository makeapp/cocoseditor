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
 * @brief Executes an action in reverse order, from time=duration to time=0
 * @warning Use this action carefully. This action is not
 * sequenceable. Use it as the default "reversed" method
 * of your own actions, but using it outside the "reversed"
 * scope is not recommended.
 */
@Platform(include = "CCActionInterval.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class ReverseTime
    extends ActionInterval
{
    /**
     * creates the action
     */
    public native static ReverseTime create(FiniteTimeAction action);

    //
    // Overrides
    //
    public native ReverseTime reverse();

    public native ReverseTime clone();

}
