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
public class EaseInOut
    extends EaseRateAction
{
    /**
     * Creates the action with the inner action and the rate parameter
     */
    public native static EaseInOut create(ActionInterval action, float rate);

    // Overrides
//      public native void update(float time) override;
    public native EaseInOut clone();

    public native EaseInOut reverse();

}
