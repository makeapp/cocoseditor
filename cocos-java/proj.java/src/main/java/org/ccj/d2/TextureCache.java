/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.d2;

import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import com.googlecode.javacpp.annotation.StdString;
import org.ccj.base.Ref;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/4/22 18:25 $
 *          $Id$
 */

@Platform(include = "CCTextureCache.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class TextureCache extends Ref
{
    /**
     * Returns the shared instance of the cache
     */
    public native static TextureCache getInstance();

    /**
     * purges the cache. It releases the retained instance.
     *
     * @since v0.99.0
     */
    public native static void destroyInstance();

    /**
     * Returns a Texture2D object given an filename.
     * If the filename was not previously loaded, it will create a new Texture2D
     * object and it will return it. It will use the filename as a key.
     * Otherwise it will return a reference of a previously loaded image.
     * Supported image extensions: .png, .bmp, .tiff, .jpeg, .pvr
     */
    public native Texture2D addImage(@StdString String filepath);
    
        /* Returns a Texture2D object given a file image
        * If the file image was not previously loaded, it will create a new Texture2D object and it will return it.
        * Otherwise it will load a texture in a new thread, and when the image is loaded, the callback will be called with the Texture2D as a parameter.
        * The callback will be called from the main thread, so it is safe to create any cocos2d object from the callback.
        * Supported image extensions: .png, .jpg
        * @since v0.8
        */
//           public native void addImageAsync(@StdString  String filepath, const std::function<void(Texture2D*)>& callback);

    /** Returns a Texture2D object given an Image.
     * If the image was not previously loaded, it will create a new Texture2D object and it will return it.
     * Otherwise it will return a reference of a previously loaded image.
     * The "key" parameter will be used as the "key" for the cache.
     * If "key" is nil, then a new texture will be created each time.
     */
//    public native  Texture2D addImage(Image  image, @StdString  String key);

    /**
     * Returns an already created texture. Returns nil if the texture doesn't exist.
     *
     * @since v0.99.5
     */
    public native Texture2D getTextureForKey(@StdString String key);

    /**
     * Reload texture from the image file
     * If the file image hasn't loaded before, load it.
     * Otherwise the texture will be reloaded from the file image.
     * The "filenName" parameter is the related/absolute path of the file image.
     * Return true if the reloading is succeed, otherwise return false.
     */
    public native boolean reloadTexture(@StdString String fileName);

    /**
     * Purges the dictionary of loaded textures.
     * Call this method if you receive the "Memory Warning"
     * In the short term: it will free some resources preventing your app from being killed
     * In the medium term: it will allocate more resources
     * In the long term: it will be the same
     */
    public native void removeAllTextures();

    /**
     * Removes unused textures
     * Textures that have a retain count of 1 will be deleted
     * It is convenient to call this method after when starting a new Scene
     *
     * @since v0.8
     */
    public native void removeUnusedTextures();

    /**
     * Deletes a texture from the cache given a texture
     */
    public native void removeTexture(Texture2D texture);

    /**
     * Deletes a texture from the cache given a its key name
     *
     * @since v0.99.4
     */
    public native void removeTextureForKey(@StdString String key);

    /** Output to CCLOG the current contents of this TextureCache
     * This will attempt to calculate the size of each texture, and the total texture memory in use
     *
     * @since v1.0
     */
//    public native std::string getCachedTextureInfo() const;

}
