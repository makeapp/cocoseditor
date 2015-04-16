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

@Platform(include = "CCAction.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class Speed
    extends Action
{
    /**
     * create the action
     */
    public native static Speed create(ActionInterval action, float speed);

    public native float getSpeed();

    /**
     * alter the speed of the inner function in runtime
     */
    public native void setSpeed(float speed);


    public native void setInnerAction(ActionInterval action);

    public native ActionInterval getInnerAction();

    //
    // Override
    //
    public native Speed clone();

    public native Speed reverse();

}
