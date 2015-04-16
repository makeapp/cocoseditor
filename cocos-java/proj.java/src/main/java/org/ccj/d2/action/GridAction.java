/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.d2.action;

import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import org.ccj.d2.GridBase;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-2-28 上午11:39 $
 *          $Id$
 */

@Platform(include = "CCActionGrid.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class GridAction
    extends ActionInterval
{
    /**
     * returns the grid
     */
    public native GridBase getGrid();

    public native GridAction clone();

    public native GridAction reverse();

}
