/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.d2;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.ByVal;
import com.googlecode.javacpp.annotation.Const;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import com.googlecode.javacpp.annotation.StdString;
import org.ccj.math.Vec2;
import org.ccj.math.Rect;
import org.ccj.math.Size;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-3-5 下午2:58 $
 *          $Id$
 */
@Platform(include = "CCTexture2D.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class Texture2D extends Pointer
{
    /**
     * @js NA
     * @lua NA
     */
    @StdString
    public native String getDescription();

    /** These functions are needed to create mutable textures
     * @js NA
     * @lua NA
     */
//       void releaseData();
    /**
     * @js NA
     * @lua NA
     */
//       void* keepData(void *data, unsigned int length);

    /** Initializes with a texture2d with data
     * @js NA
     * @lua NA
     */
//       boolean initWithData(const void *data, ssize_t dataLen, Texture2D::PixelFormat pixelFormat, int pixelsWide, int pixelsHigh, const Size& contentSize);

    /** Initializes with mipmaps */
//       boolean initWithMipmaps(MipmapInfo* mipmaps, int mipmapsNum, Texture2D::PixelFormat pixelFormat, int pixelsWide, int pixelsHigh);

    /**
     Drawing extensions to make it easy to draw basic quads using a Texture2D object.
     These functions require GL_TEXTURE_2D and both GL_VERTEX_ARRAY and GL_TEXTURE_COORD_ARRAY client states to be enabled.
     */
    /**
     * draws a texture at a given point
     */
    public native void drawAtPoint(@ByRef @Const Vec2 point);

    /**
     * draws a texture inside a rect
     */
    public native void drawInRect(@ByRef @Const Rect rect);

    /**
     Extensions to make it easy to create a Texture2D object from an image file.
     */
    /**
     Initializes a texture from a UIImage object.
     We will use the format you specified with setDefaultAlphaPixelFormat to convert the image for texture.
     NOTE: It will not convert the pvr image file.
     */
//       public native   boolean initWithImage(Image * image);

    /**
     Initializes a texture from a UIImage object.
     we will use the format you passed to the function to convert the image format to the texture format.
     If you pass PixelFormat::Automatic, we will auto detect the image render type and use that type for texture to render.
     **/
//       public native  boolean initWithImage(Image * image, PixelFormat format);

    /** Initializes a texture from a string with dimensions, alignment, font name and font size */
//       public native  boolean initWithString(String text,  String fontName, float fontSize,  Size dimensions , TextHAlignment hAlignment = TextHAlignment::CENTER, TextVAlignment vAlignment = TextVAlignment::TOP);
    /** Initializes a texture from a string using a text definition*/
//       public native  boolean initWithString(String text,  FontDefinition& textDefinition);

    /** sets the min filter, mag filter, wrap s and wrap t texture parameters.
     If the texture size is NPOT (non power of 2), then in can only use GL_CLAMP_TO_EDGE in GL_TEXTURE_WRAP_{S,T}.

     @warning Calling this method could allocate additional texture memory.

     @since v0.8
      * @code
     * When this function bound into js or lua,the input parameter will be changed
     * In js: var setBlendFunc(var arg1, var arg2, var arg3, var arg4)
     * In lua: local setBlendFunc(local arg1, local arg2, local arg3, local arg4)
     * @endcode
     */
//       public native void setTexParameters(const TexParams& texParams);
    /**
     * @js NA
     * @lua NA
     */
//    public native  void setTexParameters(const TexParams* texParams) { return setTexParameters(*texParams); };

    /**
     * sets antialias texture parameters:
     * - GL_TEXTURE_MIN_FILTER = GL_LINEAR
     * - GL_TEXTURE_MAG_FILTER = GL_LINEAR
     *
     * @warning Calling this method could allocate additional texture memory.
     * @since v0.8
     */
    public native void setAntiAliasTexParameters();

    /**
     * sets alias texture parameters:
     * - GL_TEXTURE_MIN_FILTER = GL_NEAREST
     * - GL_TEXTURE_MAG_FILTER = GL_NEAREST
     *
     * @warning Calling this method could allocate additional texture memory.
     * @since v0.8
     */
    public native void setAliasTexParameters();


    /**
     * Generates mipmap images for the texture.
     * It only works if the texture size is POT (power of 2).
     *
     * @since v0.99.0
     */
    public native void generateMipmap();

    /**
     * returns the pixel format.
     *
     * @since v2.0
     */
    public native String getStringForFormat();
//    public native CC_DEPRECATED_ATTRIBUTE const char* stringForFormat() const { return getStringForFormat(); };

    /**
     * returns the bits-per-pixel of the in-memory OpenGL texture
     *
     * @since v1.0
     */
    public native int getBitsPerPixelForFormat();
//    public native   int bitsPerPixelForFormat() const { return getBitsPerPixelForFormat(); };

    /** Helper functions that returns bits per pixels for a given format.
     @since v2.0
     */
//    public native    int getBitsPerPixelForFormat(Texture2D::PixelFormat format) const;
//    public native     int bitsPerPixelForFormat(Texture2D::PixelFormat format) const { return getBitsPerPixelForFormat(format); };

    /**
     * content size
     */
    @ByRef
    @Const
    public native Size getContentSizeInPixels();

    public native boolean hasPremultipliedAlpha();

    public native boolean hasMipmaps();

    /** Gets the pixel format of the texture */
//    public native   Texture2D::PixelFormat getPixelFormat() const;

    /**
     * Gets the width of the texture in pixels
     */
    public native int getPixelsWide();

    /**
     * Gets the height of the texture in pixels
     */
    public native int getPixelsHigh();

    /** Gets the texture name */
//       public native  GLuint getName() const;

    /** Gets max S */
//       public native  GLfloat getMaxS() const;
    /** Sets max S */
//       public native void setMaxS(GLfloat maxS);

    /** Gets max T */
//       public native GLfloat getMaxT() const;

    /**
     * Sets max T
     */
//       public native void setMaxT(GLfloat maxT);
    @ByVal
    public native Size getContentSize();

//    public native void setShaderProgram(GLProgram* program);
//    public native  GLProgram* getShaderProgram() const;
}
