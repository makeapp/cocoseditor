/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.d2.action;

import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import org.ccj.d2.Animation;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-2-28 上午11:39 $
 *          $Id$
 */

/**
 * @brief Animates a sprite given the name of an Animation
 */
@Platform(include = "CCActionInterval.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class Animate
    extends ActionInterval
{
    /**
     * creates the action with an Animation and will restore the original frame when the animation is over
     */
    public native static Animate create(Animation animation);

    /**
     * sets the Animation object to be animated
     */
    public native void setAnimation(Animation animation);

    /**
     * returns the Animation object that is being animated
     */
    public native Animation getAnimation();

    //
    // Overrides
    //
    public native Animate clone();

    public native Animate reverse();

}
