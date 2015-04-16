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
import org.ccj.math.Vec2;
import org.ccj.math.Rect;
import org.ccj.math.Size;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-3-6 下午12:03 $
 *          $Id$
 */
@Platform(include = "ui/UIImageView.h")
@Namespace("cocos2d::ui")
@com.googlecode.javacpp.annotation.Opaque
public class ImageView
    extends Widget
{
    public ImageView(Pointer p)
    {
        super(p);
    }

    /**
     * Allocates and initializes.
     */
    public native static ImageView create();

    /**
     * Load texture for imageview.
     *
     * @param fileName file name of texture.
     * @param texType  @see UI_TEX_TYPE_LOCAL
     */
    public native void loadTexture(String fileName, @Cast("cocos2d::ui::Widget::TextureResType") int texType);

    public void loadTexture(String fileName)
    {
        loadTexture(fileName, UI_TEX_TYPE_LOCAL);
    }

    /**
     * Updates the texture rect of the ImageView in points.
     * It will call setTextureRect:rotated:untrimmedSize with rotated = NO, and utrimmedSize = rect.size.
     */
    public native void setTextureRect(@ByRef @Const Rect rect);

    /**
     * Sets if imageview is using scale9 renderer.
     *
     * @param true that using scale9 renderer, false otherwise.
     */
    public native void setScale9Enabled(@Cast("bool") boolean able);

    /**
     * Sets capinsets for imageview, if imageview is using scale9 renderer.
     *
     * @param capInsets capinsets for imageview
     */
    public native void setCapInsets(@ByRef @Const Rect capInsets);

    // "setFlipX" method of widget.
//    public native void setFlipX(@Cast("bool") boolean flipX);

    // "setFlipY" method of widget.
//    public native void setFlipY(@Cast("bool") boolean flipY);

    // "isFlipX" method of widget.
//    public native boolean isFlipX();

    // "isFlipY" method of widget.
//    public native boolean isFlipY();

    // "setAnchorPoint" method of widget.
//    public native void setAnchorPoint(@ByRef @Const Vec2 pt);

    // "ignoreContentAdaptWithSize" method of widget.
//    public native void ignoreContentAdaptWithSize(@Cast("bool") boolean ignore);


//    @Const
//    @ByRef
//    public native Size getContentSize();

//    public native Node getVirtualRenderer();
}
