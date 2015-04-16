/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.d2.action;

import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.Const;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import org.ccj.math.Size;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-2-28 上午11:39 $
 *          $Id$
 */

@Platform(include = "CCActionProgressTimer.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class ShatteredTiles3D
    extends TiledGrid3DAction
{
    public native ShatteredTiles3D clone();

    /**
     * creates the action with a range, whether of not to shatter Z vertices, a grid size and duration
     */
    public native static ShatteredTiles3D create(float duration, @Const @ByRef Size gridSize, int range, boolean shatterZ);
}
