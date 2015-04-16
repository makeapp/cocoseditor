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

@Platform(include = "CCActionEase.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class EaseElastic
    extends ActionEase
{

    /**
     * get period of the wave in radians. default is 0.3
     */
    public native float getPeriod();

    /**
     * set period of the wave in radians.
     */
    public native void setPeriod(float fPeriod);

    //
    // Overrides
    //
    public native EaseElastic clone();

    public native EaseElastic reverse();

}
