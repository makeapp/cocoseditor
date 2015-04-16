/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.d2.action;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import org.ccj.base.Ref;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-2-28 上午11:39 $
 *          $Id$
 */

/**
 * @brief Base class actions that do have a finite time duration.
 * Possible actions:
 * - An action with a duration of 0 seconds
 * - An action with a duration of 35.5 seconds
 * <p/>
 * Infinite time actions are valid
 */
@Platform(include = "CCAction.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class FiniteTimeAction
    extends Action
{
    public FiniteTimeAction(Pointer p)
    {
        super(p);
    }

    public FiniteTimeAction()
    {
    }

    //! get duration in seconds of the action
    public native float getDuration();

    //! set duration in seconds of the action
    public native void setDuration(float duration);

    //
    // Overrides
    //
    public native FiniteTimeAction reverse();

    public native FiniteTimeAction clone();

    public static FiniteTimeAction cast(Ref node)
    {
        return cast(node, FiniteTimeAction.class);
    }

}
