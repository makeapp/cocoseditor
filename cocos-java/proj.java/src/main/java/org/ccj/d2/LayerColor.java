/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.d2;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.Allocator;
import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.Name;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.NoDeallocator;
import com.googlecode.javacpp.annotation.Platform;
import org.ccj.base.Color4B;
import org.ccj.math.Size;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-2-28 上午11:39 $
 *          $Id$
 */

@Platform(include = "CCLayer.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class LayerColor
        extends Layer {

    public LayerColor() {
        super(null);
        allocate();
        putRef(this);
    }

    public LayerColor(@ByRef Color4B color) {
        super(null);
        allocate(color);
        putRef(this);
    }

    public LayerColor(Pointer p) {
        super(p);
    }

    @Allocator
    @NoDeallocator
    @Name("cocos2d::LayerColor::create")
    public native void allocate();

    @Allocator
    @NoDeallocator
    @Name("cocos2d::LayerColor::create")
    public native void allocate(@ByRef Color4B color);

    /**
     * creates a fullscreen black layer
     */
    public native static LayerColor create();

    /**
     * creates a Layer with color, width and height in Points
     */
    public native static LayerColor create(@ByRef Color4B color, @Cast("GLfloat") float width, @Cast("GLfloat") float height);

    /**
     * creates a Layer with color. Width and height are the window size.
     */
    public native static LayerColor create(@ByRef Color4B color);

    /**
     * change width in Points
     */
    public native void changeWidth(float w);

    /**
     * change height in Points
     */
    public native void changeHeight(float h);

    /**
     * change width and height in Points
     *
     * @since v0.8
     */
    public native void changeWidthAndHeight(float w, float h);

    //
    // Overrides
    //
//    public native void draw();

//    public native void onDraw();

    public native void setContentSize(@ByRef Size var);
    /** BlendFunction. Conforms to BlendProtocol protocol */
    /**
     * @js NA
     * @lua NA
     */
//    public native BlendFunc getBlendFunc();

    /**
     * @code When this function bound into js or lua,the parameter will be changed
     * In js: var setBlendFunc(var src, var dst)
     * In lua: local setBlendFunc(local src, local dst)
     * @endcode
     */
//    public native void setBlendFunc(BlendFunc blendFunc);

}
