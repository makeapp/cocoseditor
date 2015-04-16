/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.d2;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.*;
import org.ccj.base.Color3B;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-2-28 上午11:39 $
 *          $Id$
 */

@Platform(include = "CCLayer.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class LayerRGBA
    extends Layer
{
    public LayerRGBA()
    {
        super(null);
        allocate();
        putRef(this);
    }

    public LayerRGBA(Pointer p)
    {
        super(p);
    }


    @Allocator
    @NoDeallocator
    @Name("cocos2d::LayerRGBA::create")
    public native void allocate();


    public native static LayerRGBA create();

    public native boolean isCascadeOpacityEnabled();

    public native void setCascadeOpacityEnabled(@Cast("bool") boolean cascadeOpacityEnabled);

    @ByRef
    @Const
    public native Color3B getColor();

    @ByRef
    @Const
    public native Color3B getDisplayedColor();

    public native void setColor(@ByRef Color3B color);

    public native void updateDisplayedColor(@ByRef Color3B parentColor);

    public native boolean isCascadeColorEnabled();

    public native void setCascadeColorEnabled(@Cast("bool") boolean cascadeColorEnabled);

    public native void setOpacityModifyRGB(@Cast("bool") boolean bValue);

    public native boolean isOpacityModifyRGB();

}
