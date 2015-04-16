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
import org.ccj.math.Rect;
import org.ccj.math.Size;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-3-6 下午12:03 $
 *          $Id$
 */
@Platform(include = "ui/UILoadingBar.h")
@Namespace("cocos2d::ui")
@com.googlecode.javacpp.annotation.Opaque
public class LoadingBar
    extends Widget
{
    public LoadingBar(Pointer p)
    {
        super(p);
    }

    /**
     * Allocates and initializes.
     */
    public native static LoadingBar create();

    /**
     * Changes the progress direction of loadingbar.
     *
     * @param LoadingBarType
     *
     * @see LoadingBarType  LoadingBarTypeLeft means progress left to right, LoadingBarTypeRight otherwise.
     */
    public native void setDirection(@Cast("cocos2d::ui::LoadingBar::Direction") int dir);

    /**
     * Gets the progress direction of loadingbar.
     *
     * @param LoadingBarType
     *
     * @see LoadingBarType  LoadingBarTypeLeft means progress left to right, LoadingBarTypeRight otherwise.
     */
    @Cast("int")
    public native int getDirection();

    /**
     * Load texture for loadingbar.
     *
     * @param fileName file name of texture.
     * @param texType  @see UI_TEX_TYPE_LOCAL
     */
    public native void loadTexture(String texture, @Cast("cocos2d::ui::Widget::TextureResType") int texType);

    public void loadTexture(String texture)
    {
        loadTexture(texture, UI_TEX_TYPE_LOCAL);
    }

    /**
     * Changes the progress direction of loadingbar.
     *
     * @param percent percent value from 1 to 100.
     */
    public native void setPercent(int percent);

    /**
     * Gets the progress direction of loadingbar.
     *
     * @return percent    percent value from 1 to 100.
     */
    public native int getPercent();

    /**
     * Sets if loadingbar is using scale9 renderer.
     *
     * @param true that using scale9 renderer, false otherwise.
     */
    public native void setScale9Enabled(@Cast("bool") boolean enabled);

    /**
     * Sets capinsets for loadingbar, if loadingbar is using scale9 renderer.
     *
     * @param capInsets capinsets for loadingbar
     */
    public native void setCapInsets(@ByRef @Const Rect capInsets);

    // "ignoreContentAdaptWithSize" method of widget.
//    public native void ignoreContentAdaptWithSize(@Cast("bool") boolean ignore);

    // "getContentSize" method of widget.
//    @Const
//    @ByRef
//    public native Size getContentSize();

    // "getVirtualRenderer" method of widget.
//    public native Node getVirtualRenderer();


}
