/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.d2.action;

import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import com.googlecode.javacpp.annotation.StdString;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-2-28 上午11:39 $
 *          $Id$
 */

@Platform(include = "CCActionProgressTimer.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class ActionTween
    extends FadeOutUpTiles
{
    public native ActionTween clone();

    /**
     * creates an initializes the action with the property name (key), and the from and to parameters.
     */
    public native static ActionTween create(float duration, @StdString String key, float from, float to);

//    /**
//     * initializes the action with the property name (key), and the from and to parameters.
//     */
//    public native boolean initWithDuration(float duration, @StdString String key, float from, float to);
}
