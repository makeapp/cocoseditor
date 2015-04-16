/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.ui;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.Const;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import org.ccj.d2.Node;
import org.ccj.base.Color3B;
import org.ccj.math.Vec2;
import org.ccj.math.Rect;
import org.ccj.math.Size;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-3-6 下午12:03 $
 *          $Id$
 */
@Platform(include = "ui/UILayout.h")
@Namespace("cocos2d::ui")
@com.googlecode.javacpp.annotation.Opaque
public class Layout
    extends Widget
{
    public static final int LAYOUT_COLOR_NONE = 0;
    public static final int LAYOUT_COLOR_SOLID = 1;
    public static final int LAYOUT_COLOR_GRADIENT = 2;

    public static final int LAYOUT_TYPE_ABSOLUTE = 0;
    public static final int LAYOUT_TYPE_LINEAR_VERTICAL = 1;
    public static final int LAYOUT_TYPE_LINEAR_HORIZONTAL = 2;
    public static final int LAYOUT_TYPE_RELATIVE = 3;

    public static final int LAYOUT_CLIPPING_STENCIL = 0;
    public static final int LAYOUT_CLIPPING_SCISSOR = 0;

    public Layout(Pointer p)
    {
        super(p);
    }

    /**
     * Allocates and initializes a layout.
     */
    public native static Layout create();

    //background

    /**
     * Sets a background image for layout
     *
     * @param fileName image file path.
     * @param texType  @see TextureResType. UI_TEX_TYPE_LOCAL means local file, UI_TEX_TYPE_PLIST means sprite frame.
     */
    public native void setBackGroundImage(String fileName, @Cast("cocos2d::ui::Widget::TextureResType") int texType);

    /**
     * Sets a background image capinsets for layout, if the background image is a scale9 render.
     *
     * @param capinsets of background image.
     */
    public native void setBackGroundImageCapInsets(@Const @ByRef Rect capInsets);

    /**
     * Sets Color Type for layout.
     *
     * @param type @see LayoutBackGroundColorType.
     */
    public native void setBackGroundColorType(@Cast("cocos2d::ui::Layout::BackGroundColorType") int type);

    /**
     * Sets background iamge use scale9 renderer.
     *
     * @param enabled true that use scale9 renderer, false otherwise.
     */
    public native void setBackGroundImageScale9Enabled(@Cast("bool") boolean enabled);

    /**
     * Sets background color for layout, if color type is LAYOUT_COLOR_SOLID
     *
     * @param color
     */
    public native void setBackGroundColor(@Const @ByRef Color3B color);

    /**
     * Sets background color for layout, if color type is LAYOUT_COLOR_GRADIENT
     *
     * @param start color
     * @param end   color
     */
    public native void setBackGroundColor(@Const @ByRef Color3B startColor, @Const @ByRef Color3B endColor);

    /**
     * Sets background opacity layout.
     *
     * @param opacity
     */
    public native void setBackGroundColorOpacity(int opacity);

    /**
     * Sets background color vector for layout, if color type is LAYOUT_COLOR_GRADIENT
     *
     * @param vector
     */
    public native void setBackGroundColorVector(@Const @ByRef Vec2 vector);

    /**
     * Remove the background image of layout.
     */
    public native void removeBackGroundImage();

    /**
     * Gets background image texture size.
     *
     * @return background image texture size.
     */

    public native
    @Const
    @ByRef
    Size getBackGroundImageTextureSize();

    /**
     * Changes if layout can clip it's content and child.
     * <p/>
     * If you really need this, please enable it. But it would reduce the rendering efficiency.
     *
     * @param clipping enabled.
     */
    public native void setClippingEnabled(@Cast("bool") boolean enabled);

    public native void setClippingType(@Cast("cocos2d::ui::Layout::ClippingType") int type);

    /**
     * Gets if layout is clipping enabled.
     *
     * @return if layout is clipping enabled.
     */
    public native boolean isClippingEnabled();


    /**
     * Sets LayoutType.
     *
     * @param LayoutType
     *
     * @see LayoutType
     */
    public native void setLayoutType(@Cast("cocos2d::ui::Layout::Type") int type);

    /**
     * Gets LayoutType.
     *
     * @return LayoutType
     *
     * @see LayoutType
     */
    @Cast("int")
    public native int getLayoutType();


    public native void addChild(Node child);

    /**
     * Adds a child to the container with a z-order
     * <p/>
     * If the child is added to a 'running' node, then 'onEnter' and 'onEnterTransitionDidFinish' will be called immediately.
     *
     * @param child  A child node
     * @param zOrder Z order for drawing priority. Please refer to setLocalZOrder(int)
     */
    public native void addChild(Node child, int zOrder);

    /**
     * Adds a child to the container with z order and tag
     * <p/>
     * If the child is added to a 'running' node, then 'onEnter' and 'onEnterTransitionDidFinish' will be called immediately.
     *
     * @param child  A child node
     * @param zOrder Z order for drawing priority. Please refer to setLocalZOrder(int)
     * @param tag    A interger to identify the node easily. Please refer to setTag(int)
     */
    public native void addChild(Node child, int zOrder, int tag);

//    public native void visit();

    public native void sortAllChildren();


    public native void onEnter();

    public native void onExit();

    public native boolean hitTest(@Const @ByRef Vec2 pt);
}
