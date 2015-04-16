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
public class EaseExponentialInOut
    extends ActionEase
{

    /**
     * creates the action
     */
    public native static EaseExponentialInOut create(ActionInterval action);

    // Overrides
//     public native void update(float time) override;
    public native EaseExponentialInOut clone();

    public native EaseExponentialInOut reverse();
}
