/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.d2;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.Const;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import com.googlecode.javacpp.annotation.StdString;
import org.ccj.base.Ref;
import org.ccj.math.Rect;
import org.ccj.math.Size;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-2-28 上午11:39 $
 *          $Id$
 */

@Platform(include = "CCSprite.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class Sprite
    extends Node
{
    public Sprite()
    {
        super();
    }

    public Sprite(Pointer p)
    {
        super(p);
    }

    /**
     * Creates an empty sprite without texture. You can call setTexture method subsequently.
     *
     * @return An empty sprite object that is marked as autoreleased.
     */
    public native static Sprite create();

    /**
     * Creates a sprite with an image filename.
     * <p/>
     * After creation, the rect of sprite will be the size of the image,
     * and the offset will be (0,0).
     *
     * @param fileName The string which indicates a path to image file, e.g., "scene1/monster.png".
     *
     * @return A valid sprite object that is marked as autoreleased.
     */
    public native static Sprite create(String fileName);


    /**
     * Creates a sprite with an image filename and a rect.
     *
     * @param filename The string wich indicates a path to image file, e.g., "scene1/monster.png"
     * @param rect     Only the contents inside rect of filename's texture will be applied for this sprite.
     *
     * @return A valid sprite object that is marked as autoreleased.
     */
    public native static Sprite create(@StdString String filename, @ByRef Rect rect);

    /**
     * Creates a sprite with an exsiting texture contained in a Texture2D object
     * After creation, the rect will be the size of the texture, and the offset will be (0,0).
     *
     * @param texture A pointer to a Texture2D object.
     *
     * @return A valid sprite object that is marked as autoreleased.
     */
    public native static Sprite createWithTexture(Texture2D texture);

    /**
     * Creates a sprite with a texture and a rect.
     * <p/>
     * After creation, the offset will be (0,0).
     *
     * @param texture A pointer to an existing Texture2D object.
     *                You can use a Texture2D object for many sprites.
     * @param rect    Only the contents inside the rect of this texture will be applied for this sprite.
     * @param rotated Whether or not the rect is rotated
     *
     * @return A valid sprite object that is marked as autoreleased.
     */
    public native static Sprite createWithTexture(Texture2D texture, @ByRef Rect rect, boolean rotated);

    public static Sprite createWithTexture(Texture2D texture, @ByRef Rect rect)
    {
        return createWithTexture(texture, rect, false);
    }

    /**
     * Creates a sprite with an sprite frame.
     *
     * @param pSpriteFrame A sprite frame which involves a texture and a rect
     *
     * @return A valid sprite object that is marked as autoreleased.
     */
    public native static Sprite createWithSpriteFrame(SpriteFrame pSpriteFrame);

    /**
     * Creates a sprite with an sprite frame name.
     * <p/>
     * A SpriteFrame will be fetched from the SpriteFrameCache by spriteFrameName param.
     * If the SpriteFrame doesn't exist it will raise an exception.
     *
     * @param spriteFrameName A null terminated string which indicates the sprite frame name.
     *
     * @return A valid sprite object that is marked as autoreleased.
     */
    public native static Sprite createWithSpriteFrameName(String spriteFrameName);

    /// @}  end of creators group


    /// @{
    /// @name BatchNode methods


    /**
     * Returns the batch node object if this sprite is rendered by SpriteBatchNode
     *
     * @return The SpriteBatchNode object if this sprite is rendered by SpriteBatchNode,
     *         nullptr if the sprite isn't used batch node.
     */
//    public native  SpriteBatchNode* getBatchNode(void);

    /**
     * Sets the batch node to sprite
     * @warning This method is not recommended for game developers. Sample code for using batch node
     * @code
     * SpriteBatchNode *batch = SpriteBatchNode::create("Images/grossini_dance_atlas.png", 15);
     * Sprite *sprite = Sprite::createWithTexture(batch->getTexture(), Rect(0, 0, 57, 57));
     * batch->addChild(sprite);
     * layer->addChild(batch);
     * @endcode
     */
//    public native  void setBatchNode(SpriteBatchNode *spriteBatchNode);

    /// @} end of BatchNode methods


    /// @{
    /// @name Texture / Frame methods

    /**
     * Sets a new texture (from a filename) to the sprite.
     * It will call `setTextureRect()` with the texture's content size.
     * TODO: The whole Sprite API needs to be reviewed.
     */
    public native void setTexture(String filename);

    /** Sets a new texture to the sprite.
     The Texture's rect is not changed.
     */
//    public native  void setTexture(Texture2D *texture) override;

    /** returns the Texture2D object used by the sprite */
//    public native  Texture2D* getTexture() const override;

    /**
     * Updates the texture rect of the Sprite in points.
     * It will call setTextureRect(const Rect& rect, bool rotated, const Size& untrimmedSize) with \p rotated = false, and \p utrimmedSize = rect.size.
     */
    public native void setTextureRect(@ByRef Rect rect);

    /**
     * Sets the texture rect, rectRotated and untrimmed size of the Sprite in points.
     * It will update the texture coordinates and the vertex rectangle.
     */
    public native void setTextureRect(@ByRef Rect rect, boolean rotated, @ByRef Size untrimmedSize);

    /**
     * Sets the vertex rect.
     * It will be called internally by setTextureRect.
     * Useful if you want to create 2x images from SD images in Retina Display.
     * Do not call it manually. Use setTextureRect instead.
     */
    public native void setVertexRect(@ByRef Rect rect);

    /**
     * Sets a new SpriteFrame to the Sprite.
     */
    public native void setSpriteFrame(String spriteFrameName);
//    public native  void setSpriteFrame(SpriteFrame* newFrame);

    /** @deprecated Use `setSpriteFrame()` instead. */
//    CC_DEPRECATED_ATTRIBUTE public native  void setDisplayFrame(SpriteFrame *newFrame) { setSpriteFrame(newFrame); }

    /**
     * Returns whether or not a SpriteFrame is being displayed
     */
//    public native  bool isFrameDisplayed(SpriteFrame *pFrame) const;

    /**
     * Returns the current displayed frame.
     */
//    public native  SpriteFrame* getSpriteFrame() const;
    /** @deprecated Use `getSpriteFrame()` instead */
//    CC_DEPRECATED_ATTRIBUTE public native  SpriteFrame* getDisplayFrame() const { return getSpriteFrame(); }
    /** @deprecated Use `getSpriteFrame()` instead */
//    CC_DEPRECATED_ATTRIBUTE public native  SpriteFrame* displayFrame() const { return getSpriteFrame(); };

    /// @} End of frames methods


    /// @{
    /// @name Animation methods
    /**
     * Changes the display frame with animation name and index.
     * The animation name will be get from the AnimationCache
     */
//    public native  void setDisplayFrameWithAnimationName(String animationName, ssize_t frameIndex);
    /// @}


    /// @{
    /// @name Sprite Properties' setter/getters

    /**
     * Whether or not the Sprite needs to be updated in the Atlas.
     *
     * @return true if the sprite needs to be updated in the Atlas, false otherwise.
     */
    public native boolean isDirty();

    /**
     * Makes the Sprite to be updated in the Atlas.
     */
    public native void setDirty(@Cast("bool") boolean bDirty);

    /**
     * Returns the quad (tex coords, vertex coords and color) information.
     * @js NA
     * @lua NA
     */
//    inline V3F_C4B_T2F_Quad getQuad(void) const { return _quad; }

    /**
     * Returns whether or not the texture rectangle is rotated.
     */
//    inline bool isTextureRectRotated(void) const { return _rectRotated; }

    /**
     * Returns the index used on the TextureAtlas.
     */
//    inline ssize_t getAtlasIndex(void) const { return _atlasIndex; }

    /**
     * Sets the index used on the TextureAtlas.
     * @warning Don't modify this value unless you know what you are doing
     */
//    inline void setAtlasIndex(ssize_t atlasIndex) { _atlasIndex = atlasIndex; }

    /**
     * Returns the rect of the Sprite in points
     */
    @ByRef
    @Const
    public native Rect getTextureRect();

    /**
     * Gets the weak reference of the TextureAtlas when the sprite is rendered using via SpriteBatchNode
     */
//    inline TextureAtlas* getTextureAtlas(void) { return _textureAtlas; }

    /**
     * Sets the weak reference of the TextureAtlas when the sprite is rendered using via SpriteBatchNode
     */
//    inline void setTextureAtlas(TextureAtlas *pobTextureAtlas) { _textureAtlas = pobTextureAtlas; }

    /**
     * Gets the offset position of the sprite. Calculated automatically by editors like Zwoptex.
     */
//    inline const Vec2& getOffsetPosition(void) const { return _offsetPosition; }


    /**
     * Returns the flag which indicates whether the sprite is flipped horizontally or not.
     * <p/>
     * It only flips the texture of the sprite, and not the texture of the sprite's children.
     * Also, flipping the texture doesn't alter the anchorPoint.
     * If you want to flip the anchorPoint too, and/or to flip the children too use:
     * sprite->setScaleX(sprite->getScaleX() * -1);
     *
     * @return true if the sprite is flipped horizontally, false otherwise.
     */
    public native boolean isFlippedX();

    /**
     * Sets whether the sprite should be flipped horizontally or not.
     *
     * @param flippedX true if the sprite should be flipped horizontally, false otherwise.
     */
    public native void setFlippedX(@Cast("bool") boolean flippedX);

    /**
     * @js NA
     * @lua NA
     * @deprecated Use isFlippedX() instead
     */
    public native boolean isFlipX();

    /**
     * @deprecated Use setFlippedX() instead
     */
    public native void setFlipX(@Cast("bool") boolean flippedX);

    /**
     * Return the flag which indicates whether the sprite is flipped vertically or not.
     * <p/>
     * It only flips the texture of the sprite, and not the texture of the sprite's children.
     * Also, flipping the texture doesn't alter the anchorPoint.
     * If you want to flip the anchorPoint too, and/or to flip the children too use:
     * sprite->setScaleY(sprite->getScaleY() * -1);
     *
     * @return true if the sprite is flipped vertically, false otherwise.
     */
    public native boolean isFlippedY();

    /**
     * Sets whether the sprite should be flipped vertically or not.
     *
     * @param flippedY true if the sprite should be flipped vertically, false otherwise.
     */
    public native void setFlippedY(@Cast("bool") boolean flippedY);

    public static Sprite cast(Ref node)
    {
        return cast(node, Sprite.class);
    }

    /// @} End of Sprite properties getter/setters

    /** @deprecated Use isFlippedY() instead */
//    public native boolean   isFlipY();
    /** @deprecated Use setFlippedY() instead */
//    public native void setFlipY(@Cast("bool") boolean   flippedY) ;

    //
    // Overrides
    //
    /// @{
    /// @name Functions inherited from TextureProtocol
    /**
     *@code
     *When this function bound into js or lua,the parameter will be changed
     *In js: var setBlendFunc(var src, var dst)
     *In lua: local setBlendFunc(local src, local dst)
     *@endcode
     */
//    inline void setBlendFunc(const BlendFunc &blendFunc) override { _blendFunc = blendFunc; }
    /**
     * @js NA
     * @lua NA
     */
//    inline const BlendFunc& getBlendFunc() const override { return _blendFunc; }
}
