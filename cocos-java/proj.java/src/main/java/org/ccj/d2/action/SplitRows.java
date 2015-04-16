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

@Platform(include = "CCActionProgressTimer.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class SplitRows
    extends TiledGrid3DAction
{
    public native SplitRows clone();

    /**
     * creates the action with the number of rows to split and the duration
     */
    public native static SplitRows create(float duration, int rows);

}
