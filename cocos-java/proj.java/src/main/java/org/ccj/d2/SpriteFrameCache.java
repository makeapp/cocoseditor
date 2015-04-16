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
 * @version $Date:2014/4/23 12:26 $
 *          $Id$
 */
@Platform(include = "CCSpriteFrameCache.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class SpriteFrameCache extends Ref
{
    /**
     * Returns the shared instance of the Sprite Frame cache
     */
    public native static SpriteFrameCache getInstance();


    /**
     * Destroys the cache. It releases all the Sprite Frames and the retained instance.
     */
    public native static void destroyInstance();


    /**
     * Adds multiple Sprite Frames from a plist file.
     * A texture will be loaded automatically. The texture name will composed by replacing the .plist suffix with .png
     * If you want to use another texture, you should use the addSpriteFramesWithFile(@StdString  String  plist, @StdString  String  textureFileName) method.
     *
     * @js addSpriteFrames
     * @lua addSpriteFrames
     */
    public native void addSpriteFramesWithFile(@StdString String plist);

    /**
     * Adds multiple Sprite Frames from a plist file. The texture will be associated with the created sprite frames.
     *
     * @js addSpriteFrames
     * @lua addSpriteFrames
     * @since v0.99.5
     */
    public native void addSpriteFramesWithFile(@StdString String plist, @StdString String textureFileName);

    /**
     * Adds multiple Sprite Frames from a plist file. The texture will be associated with the created sprite frames.
     *
     * @js addSpriteFrames
     * @lua addSpriteFrames
     */
    public native void addSpriteFramesWithFile(@StdString String plist, Texture2D texture);

    /**
     * Adds an sprite frame with a given name.
     * If the name already exists, then the contents of the old name will be replaced with the new one.
     */
    public native void addSpriteFrame(SpriteFrame frame, @StdString String frameName);

    /**
     * Purges the dictionary of loaded sprite frames.
     * Call this method if you receive the "Memory Warning".
     * In the short term: it will free some resources preventing your app from being killed.
     * In the medium term: it will allocate more resources.
     * In the long term: it will be the same.
     */
    public native void removeSpriteFrames();

    /**
     * Removes unused sprite frames.
     * Sprite Frames that have a retain count of 1 will be deleted.
     * It is convenient to call this method after when starting a new Scene.
     */
    public native void removeUnusedSpriteFrames();

    /**
     * Deletes an sprite frame from the sprite frame cache.
     */
    public native void removeSpriteFrameByName(@StdString String name);

    /**
     * Removes multiple Sprite Frames from a plist file.
     * Sprite Frames stored in this file will be removed.
     * It is convenient to call this method when a specific texture needs to be removed.
     *
     * @since v0.99.5
     */
    public native void removeSpriteFramesFromFile(@StdString String plist);

    /**
     * Removes all Sprite Frames associated with the specified textures.
     * It is convenient to call this method when a specific texture needs to be removed.
     *
     * @since v0.995.
     */
    public native void removeSpriteFramesFromTexture(Texture2D texture);

    /**
     * Returns an Sprite Frame that was previously added.
     * If the name is not found it will return nil.
     * You should retain the returned copy if you are going to use it.
     *
     * @js getSpriteFrame
     * @lua getSpriteFrame
     */
    public native SpriteFrame getSpriteFrameByName(@StdString String name);
}
