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

@Platform(include = "CCActionInstant.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class CallFuncN
    extends ActionInstant
{
    /** creates the action with the callback of type std::function<void()>.
     This is the preferred way to create the callback.
     */
//    public native  static CallFuncN  create(const std::function<void(Node*)>& func);

    /**
     * creates the action with the callback of type std::function<void()>.
     * This is the preferred way to create the callback.
     */
//       static CallFuncN * create(const std::function<void(Node*)>& func);
//    public native CallFuncN clone();

//    public native CallFuncN reverse();

}
