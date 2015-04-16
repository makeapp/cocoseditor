/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.d2;

import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.Const;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import org.ccj.math.Vec2;
import org.ccj.math.Rect;
import org.ccj.base.Ref;
import org.ccj.math.Size;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-3-5 下午2:57 $
 *          $Id$
 */

@Platform(include = "CCSpriteFrame.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class SpriteFrame
    extends Ref
{
    /**
     * Create a SpriteFrame with a texture filename, rect in points.
     * It is assumed that the frame was not trimmed.
     */
    public native static SpriteFrame create(String filename, @Const @ByRef Rect rect);

    /**
     * Create a SpriteFrame with a texture filename, rect, rotated, offset and originalSize in pixels.
     * The originalSize is the size in pixels of the frame before being trimmed.
     */
    public native static SpriteFrame create(String filename, @Const @ByRef Rect rect, boolean rotated, @Const @ByRef Vec2 offset, @Const @ByRef Size originalSize);

    /**
     * Create a SpriteFrame with a texture, rect in points.
     * It is assumed that the frame was not trimmed.
     */
    public native static SpriteFrame createWithTexture(Texture2D pobTexture, @Const @ByRef Rect rect);

    /**
     * Create a SpriteFrame with a texture, rect, rotated, offset and originalSize in pixels.
     * The originalSize is the size in points of the frame before being trimmed.
     */
    public native static SpriteFrame createWithTexture(Texture2D pobTexture, @Const @ByRef Rect rect, boolean rotated, @Const @ByRef Vec2 offset, @Const @ByRef Size originalSize);
    /**
     * @js NA
     * @lua NA
     */
//      virtual ~SpriteFrame(void);

    /**
     * Initializes a SpriteFrame with a texture, rect in points.
     * It is assumed that the frame was not trimmed.
     */
//    public native boolean initWithTexture(Texture2D pobTexture, @Const @ByRef Rect rect);

    /**
     * Initializes a SpriteFrame with a texture filename, rect in points;
     * It is assumed that the frame was not trimmed.
     */
//    public native boolean initWithTextureFilename(String filename, @Const @ByRef Rect rect);

    /**
     * Initializes a SpriteFrame with a texture, rect, rotated, offset and originalSize in pixels.
     * The originalSize is the size in points of the frame before being trimmed.
     */
//    public native boolean initWithTexture(Texture2D pobTexture, @Const @ByRef Rect rect, boolean rotated, @Const @ByRef Vec2 offset, @Const @ByRef Size originalSize);

    /**
     * Initializes a SpriteFrame with a texture, rect, rotated, offset and originalSize in pixels.
     * The originalSize is the size in pixels of the frame before being trimmed.
     *
     * @since v1.1
     */
//    public native boolean initWithTextureFilename(String filename, @Const @ByRef Rect rect, boolean rotated, @Const @ByRef Vec2 offset, @Const @ByRef Size originalSize);


    // attributes
    @Const
    @ByRef
    public native Rect getRectInPixels();

    public native void setRectInPixels(@Const @ByRef Rect rectInPixels);

    public native boolean isRotated();

    public native void setRotated(@Cast("bool") boolean rotated);

    /**
     * get rect of the frame
     */
    @Const
    @ByRef
    public native Rect getRect();

    /**
     * set rect of the frame
     */
    public native void setRect(@Const @ByRef Rect rect);

    /**
     * get offset of the frame
     */
    @Const
    @ByRef
    public native Vec2 getOffsetInPixels();

    /**
     * set offset of the frame
     */
    public native void setOffsetInPixels(@Const @ByRef Vec2 offsetInPixels);

    /**
     * get original size of the trimmed image
     */
    @Const
    @ByRef
    public native Size getOriginalSizeInPixels();

    /**
     * set original size of the trimmed image
     */
    public native void setOriginalSizeInPixels(@Const @ByRef Size sizeInPixels);

    /**
     * get original size of the trimmed image
     */
    @Const
    @ByRef
    public native Size getOriginalSize();

    /**
     * set original size of the trimmed image
     */
    public native void setOriginalSize(@Const @ByRef Size sizeInPixels);

    /**
     * get texture of the frame
     */
    public native Texture2D getTexture();

    /**
     * set texture of the frame, the texture is retained
     */
    public native void setTexture(Texture2D pobTexture);

    @Const
    @ByRef
    public native Vec2 getOffset();

    public native void setOffset(@Const @ByRef Vec2 offsets);

    // Overrides
    public native SpriteFrame clone();
}
