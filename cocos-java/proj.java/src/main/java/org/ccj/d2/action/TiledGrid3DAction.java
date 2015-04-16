/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.d2.action;

import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.ByVal;
import com.googlecode.javacpp.annotation.Const;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import org.ccj.d2.GridBase;
import org.ccj.math.Vec2;
import org.ccj.base.Quad3;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-2-28 上午11:39 $
 *          $Id$
 */

@Platform(include = "CCActionGrid.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class TiledGrid3DAction
    extends GridAction
{
    /**
     * returns the grid
     */
    public native GridBase getGrid();

    public native TiledGrid3DAction clone();

    /**
     * creates the action with size and duration
     *
     * @js NA
     * @lua NA
     */
//    public native static TiledGrid3DAction create(float duration, @ByRef Size gridSize);

    /**
     * returns the tile that belongs to a certain position of the grid
     *
     * @js NA
     * @lua NA
     */
    @ByVal
    public native Quad3 getTile(@ByRef @Const Vec2 position);

    /**
     * returns the non-transformed tile that belongs to a certain position of the grid
     *
     * @js NA
     * @lua NA
     */
    @ByVal
    public native Quad3 getOriginalTile(@ByRef @Const Vec2 position);

    /**
     * sets a new tile to a certain position of the grid
     *
     * @js NA
     * @lua NA
     */
    public native void setTile(@ByRef @Const Vec2 position, @ByRef @Const Quad3 coords);
}
