/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.d2.action;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.Const;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import org.ccj.math.Vec2;
import org.ccj.math.Size;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-2-28 上午11:39 $
 *          $Id$
 */

@Platform(include = "CCActionProgressTimer.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class TurnOffTiles
    extends TiledGrid3DAction
{
    public native TurnOffTiles clone();

    /**
     * creates the action with the grid size and the duration
     */
    public native static TurnOffTiles create(float duration, @Const @ByRef Size gridSize);

    /**
     * creates the action with a random seed, the grid size and the duration
     */
    public native static TurnOffTiles create(float duration, @Const @ByRef Size gridSize, int seed);

    public native void shuffle(@Cast("unsigned int *") Pointer array, int len);

    public native void turnOnTile(@Const @ByRef Vec2 pos);

    public native void turnOffTile(@Const @ByRef Vec2 pos);

}
