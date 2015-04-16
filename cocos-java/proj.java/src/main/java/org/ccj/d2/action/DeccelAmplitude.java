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

@Platform(include = "CCActionGrid.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class DeccelAmplitude
    extends ActionInterval
{
    public native DeccelAmplitude clone();

    public native DeccelAmplitude reverse();

    /**
     * creates the action with an inner action that has the amplitude property, and a duration time
     */
    public native static DeccelAmplitude create(Action action, float duration);

    /**
     * get amplitude rate
     */
    public native float getRate();

    /**
     * set amplitude rate
     */
    public native void setRate(float fRate);
}
