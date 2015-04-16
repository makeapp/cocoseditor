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
public class ReuseGrid
    extends ActionInterval
{
    public native ReuseGrid clone();

    public native ReuseGrid reverse();

    /**
     * creates the action with an inner action that has the amplitude property, and a duration time
     */
    public native static ReuseGrid create(int times);


}
