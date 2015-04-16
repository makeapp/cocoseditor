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

/**
 * @brief EaseBounceOut action.
 * @warning This action doesn't use a bijective function. Actions like Sequence might have an unexpected result when used with this action.
 * @ingroup Actions
 * @since v0.8.2
 */
@Platform(include = "CCActionEase.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class EaseBounceOut
    extends EaseBounce
{
    /**
     * creates the action
     */
    public native static EaseBounceOut create(ActionInterval action);

    // Overrides
//        public native void update(float time) override;
    public native EaseBounceOut clone();

    public native EaseBounce reverse();
}
