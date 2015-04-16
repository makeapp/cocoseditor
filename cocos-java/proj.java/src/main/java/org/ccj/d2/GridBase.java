/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.d2;

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
 * @version $Date:14-3-5 上午11:06 $
 *          $Id$
 */
@Platform(include = "CCGrid.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class GridBase extends Pointer
{

    /**
     * create one Grid
     */
    public native static GridBase create(@Const @ByRef Size gridSize, Texture2D texture, boolean flipped);

    /**
     * create one Grid
     */
    public native static GridBase create(@Const @ByRef Size gridSize);

    /**
     * @js NA
     * @lua NA
     */
//      public native ~GridBase();
    public native boolean initWithSize(@Const @ByRef Size gridSize, Texture2D texture, boolean flipped);

    public native boolean initWithSize(@Const @ByRef Size gridSize);

    /**
     * whether or not the grid is active
     */
    public native boolean isActive();

    public native void setActive(@Cast("bool") boolean active);

    /**
     * number of times that the grid will be reused
     */
    public native int getReuseGrid();

    public native void setReuseGrid(int reuseGrid);

    /**
     * size of the grid
     */
    @Const
    @ByRef
    public native Size getGridSize();

    public native void setGridSize(@Const @ByRef Size gridSize);

    /**
     * pixels between the grids
     */
    @Const
    @ByRef
    public native Vec2 getStep();

    public native void setStep(@Const @ByRef Vec2 step);

    /**
     * is texture flipped
     */
    public native boolean isTextureFlipped();

    public native void setTextureFlipped(@Cast("bool") boolean flipped);

    public native void beforeDraw();

    public native void afterDraw(Node target);

    public native void blit();

    public native void reuse();

    public native void calculateVertexPoints();

    public native void set2DProjection();
}
