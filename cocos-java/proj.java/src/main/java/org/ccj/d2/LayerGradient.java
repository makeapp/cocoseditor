/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.d2;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.*;
import org.ccj.base.Color3B;
import org.ccj.base.Color4B;
import org.ccj.math.Vec2;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-2-28 上午11:39 $
 *          $Id$
 */

@Platform(include = "CCLayer.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class LayerGradient
    extends Layer
{
    public LayerGradient()
    {
        super(null);
        allocate();
        putRef(this);
    }

    public LayerGradient(Pointer p)
    {
        super(p);
    }

    @Allocator
    @NoDeallocator
    @Name("cocos2d::LayerGradient::create")
    public native void allocate();

    /**
     * Creates a fullscreen black layer
     */
    public native static LayerGradient create();

    /**
     * Creates a full-screen Layer with a gradient between start and end.
     */
    public native static LayerGradient create(@ByRef Color4B start, @ByRef Color4B end);

    /**
     * Creates a full-screen Layer with a gradient between start and end in the direction of v.
     */
    public native static LayerGradient create(@ByRef Color4B start, @ByRef Color4B end, @ByRef Vec2 v);

//    public native boolean init();
//
//    /**
//     * Initializes the Layer with a gradient between start and end.
//     *
//     * @js init
//     * @lua init
//     */
//    public native boolean initWithColor(@ByRef Color4B start, @ByRef Color4B end);
//
//    /**
//     * Initializes the Layer with a gradient between start and end in the direction of v.
//     *
//     * @js init
//     * @lua init
//     */
//    public native boolean initWithColor(@ByRef Color4B start, @ByRef Color4B end, @ByRef Vec2 v);

    /**
     * Whether or not the interpolation will be compressed in order to display all the colors of the gradient both in canonical and non canonical vectors
     * Default: true
     */
    public native void setCompressedInterpolation(@Cast("bool") boolean compressedInterpolation);

    public native boolean isCompressedInterpolation();

    /**
     * Sets the start color of the gradient
     */
    public native void setStartColor(@ByRef Color3B startColor);

    /**
     * Returns the start color of the gradient
     */
    @ByRef
    @Const
    public native Color3B getStartColor();

    /**
     * Sets the end color of the gradient
     */
    public native void setEndColor(@ByRef Color3B endColor);

    /**
     * Returns the end color of the gradient
     */
    @ByRef
    @Const
    public native Color3B getEndColor();

    /**
     * Returns the start opacity of the gradient
     */
    public native void setStartOpacity(byte startOpacity);

    /**
     * Returns the start opacity of the gradient
     */
    public native byte getStartOpacity();

    /**
     * Returns the end opacity of the gradient
     */
    public native void setEndOpacity(byte endOpacity);

    /**
     * Returns the end opacity of the gradient
     */
    public native byte getEndOpacity();

    /**
     * Sets the directional vector that will be used for the gradient.
     * The default value is vertical direction (0,-1).
     */
    public native void setVector(@ByRef Vec2 alongVector);

    /**
     * Returns the directional vector used for the gradient
     */
    @ByRef
    @Const
    public native Vec2 getVector();

}
