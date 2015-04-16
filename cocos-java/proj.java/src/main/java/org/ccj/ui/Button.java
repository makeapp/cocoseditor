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
import com.googlecode.javacpp.annotation.StdString;
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
@Platform(include = "ui/UIButton.h")
@Namespace("cocos2d::ui")
@com.googlecode.javacpp.annotation.Opaque
public class Button
    extends Widget
{
    public Button(Pointer p)
    {
        super(p);
    }

    /**
     * Allocates and initializes.
     */
    public native static Button create();

    /**
     * Load textures for button.
     *
     * @param normal   normal state texture.
     * @param selected selected state texture.
     * @param disabled dark state texture.
     * @param texType  @see UI_TEX_TYPE_LOCAL
     */
    public native void loadTextures(String normal, String selected, String disabled, @Cast("cocos2d::ui::Widget::TextureResType") int texType);

    public void loadTextures(String normal, String selected, String disabled)
    {
        loadTextures(normal, selected, disabled, UI_TEX_TYPE_LOCAL);
    }

    /**
     * Load normal state texture for button.
     *
     * @param normal  normal state texture.
     * @param texType @see UI_TEX_TYPE_LOCAL
     */
    public native void loadTextureNormal(String normal, @Cast("cocos2d::ui::Widget::TextureResType") int texType);

    public void loadTextureNormal(String normal)
    {
        loadTextureNormal(normal, UI_TEX_TYPE_LOCAL);
    }

    /**
     * Load selected state texture for button.
     *
     * @param selected selected state texture.
     * @param texType  @see UI_TEX_TYPE_LOCAL
     */
    public native void loadTexturePressed(String selected, @Cast("cocos2d::ui::Widget::TextureResType") int texType);

    public void loadTexturePressed(String selected)
    {
        loadTexturePressed(selected, UI_TEX_TYPE_LOCAL);
    }

    /**
     * Load dark state texture for button.
     *
     * @param disabled dark state texture.
     * @param texType  @see UI_TEX_TYPE_LOCAL
     */
    public native void loadTextureDisabled(String disabled, @Cast("cocos2d::ui::Widget::TextureResType") int texType);

    public void loadTextureDisabled(String disabled)
    {
        loadTextureDisabled(disabled, UI_TEX_TYPE_LOCAL);
    }

    /**
     * Sets capinsets for button, if button is using scale9 renderer.
     *
     * @param capInsets capinsets for button
     */
    public native void setCapInsets(@Const @ByRef Rect capInsets);

    /**
     * Sets capinsets for button, if button is using scale9 renderer.
     *
     * @param capInsets capinsets for button
     */
    public native void setCapInsetsNormalRenderer(@Const @ByRef Rect capInsets);

    /**
     * Sets capinsets for button, if button is using scale9 renderer.
     *
     * @param capInsets capinsets for button
     */
    public native void setCapInsetsPressedRenderer(@Const @ByRef Rect capInsets);

    /**
     * Sets capinsets for button, if button is using scale9 renderer.
     *
     * @param capInsets capinsets for button
     */
    public native void setCapInsetsDisabledRenderer(@Const @ByRef Rect capInsets);

    // "setAnchorPoint" of widget.
//    public native void setAnchorPoint(@Const @ByRef Vec2 pt);

    /**
     * Sets if button is using scale9 renderer.
     *
     * @param true that using scale9 renderer, false otherwise.
     */
    public native void setScale9Enabled(@Cast("bool") boolean able);

    // "setFlipX" of widget.
//    public native void setFlipX(@Cast("bool") boolean flipX);

    // "setFlipY" of widget.
//    public native void setFlipY(@Cast("bool") boolean flipY);

    // "isFlipX" of widget.
//    public native boolean isFlipX();

    // "isFlipY" of widget.
//    public native boolean isFlipY();

    /**
     * Changes if button can be clicked zoom effect.
     *
     * @param true that can be clicked zoom effect, false otherwise.
     */
    public native void setPressedActionEnabled(@Cast("bool") boolean enabled);

    // "ignoreContentAdaptWithSize" method of widget.
//    public native void ignoreContentAdaptWithSize(@Cast("bool") boolean ignore);

    // "getContentSize" method of widget.
//    @Const
//    @ByRef
//    public native Size getContentSize();

    // "getVirtualRenderer" method of widget.
//    public native Node getVirtualRenderer();

    /**
     * Sets color to widget
     * <p/>
     * It default change the color of widget's children.
     *
     * @param color
//     */
//    public native void setColor(@ByRef @Const Color3B color);

    /**
     * Returns the "class name" of widget.
     */
//    @StdString
//    public native String getDescription();


    public native void setTitleText(@StdString String text);

    @StdString
    public native String getTitleText();

    public native void setTitleColor(@ByRef @Const Color3B color);

    @ByRef
    @Const
    public native Color3B getTitleColor();

    public native void setTitleFontSize(float size);

    public native float getTitleFontSize();

    public native void setTitleFontName(@StdString String fontName);

    @StdString
    public native String getTitleFontName();
}
