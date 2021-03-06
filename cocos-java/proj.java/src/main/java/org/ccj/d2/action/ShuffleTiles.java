/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.d2.action;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.ByVal;
import com.googlecode.javacpp.annotation.Cast;
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
public class ShuffleTiles
    extends TiledGrid3DAction
{
    public native ShuffleTiles clone();

    /**
     * creates the action with a random seed, the grid size and the duration
     */
    public native static ShuffleTiles create(float duration, @Const @ByRef Size gridSize, int seed);

    public native void shuffle(@Cast("unsigned int *") Pointer pointer, int len);

    @ByVal
    public native Size getDelta(@Const @ByRef Size pos);

//    public native void placeTile(@Const @ByRef Vec2 pos, Tile *t);
}
