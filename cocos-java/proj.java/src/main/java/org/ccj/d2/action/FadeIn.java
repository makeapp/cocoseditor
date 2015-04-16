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

@Platform(include = "CCActionInterval.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class FadeIn
    extends ActionInterval
{
    /**
     * creates the action
     */
    public native static FadeIn create(float d);

    //
    // Overrides
    //
//     public native  void update(float time) override;
    public native FadeIn clone();

    public native ActionInterval reverse();

}
