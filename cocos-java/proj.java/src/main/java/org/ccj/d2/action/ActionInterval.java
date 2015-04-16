/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.d2.action;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-2-28 上午11:39 $
 *          $Id$
 */

@Platform(include = "CCActionInterval.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class ActionInterval
    extends FiniteTimeAction
{
    public ActionInterval(Pointer p)
    {
        super(p);
    }

    public ActionInterval()
    {
    }

    /**
     * how many seconds had elapsed since the actions started to run.
     */
    public native float getElapsed();

    //extension in GridAction
    public native void setAmplitudeRate(float amp);

    public native float getAmplitudeRate();

    public native ActionInterval reverse();

    public native ActionInterval clone();
}
