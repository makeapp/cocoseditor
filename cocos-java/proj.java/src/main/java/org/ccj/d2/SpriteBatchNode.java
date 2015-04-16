/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.d2;

import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import com.googlecode.javacpp.annotation.StdString;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/4/22 19:54 $
 *          $Id$
 */

@Platform(include = "CCSpriteBatchNode.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class SpriteBatchNode extends Node
{

    /**
     * creates a SpriteBatchNode with a texture2d and capacity of children.
     * The capacity will be increased in 33% in runtime if it run out of space.
     */
    public native static SpriteBatchNode createWithTexture(Texture2D tex, int capacity);

    public native static SpriteBatchNode createWithTexture(Texture2D tex);

    /**
     * creates a SpriteBatchNode with a file image (.png, .jpeg, .pvr, etc) and capacity of children.
     * The capacity will be increased in 33% in runtime if it run out of space.
     * The file will be loaded using the TextureMgr.
     */
    public native static SpriteBatchNode create(@StdString String fileImage, int capacity);

    public native static SpriteBatchNode create(@StdString String fileImage);


    /** returns the TextureAtlas object */
//          public native TextureAtlas getTextureAtlas() ;

    /** sets the TextureAtlas object */
//    public native void setTextureAtlas(TextureAtlas* textureAtlas);

    /**
     * returns an array with the descendants (children, gran children, etc.).
     * This is specific to BatchNode. In order to use the children, use getChildren() instead
     */
//          public native const std::vector<Sprite*>& getDescendants();
    public native void increaseAtlasCapacity();

    /**
     * removes a child given a certain index. It will also cleanup the running actions depending on the cleanup parameter.
     *
     * @warning Removing a child from a SpriteBatchNode is very slow
     */
    public native void removeChildAtIndex(int index, boolean doCleanup);

    public native void appendChild(Sprite sprite);

    public native void removeSpriteFromAtlas(Sprite sprite);

    public native int rebuildIndexInOrder(Sprite parent, int index);

    public native int highestAtlasIndexInChild(Sprite sprite);

    public native int lowestAtlasIndexInChild(Sprite sprite);

    public native int atlasIndexForChild(Sprite sprite, int z);

    /* Sprites use this to start sortChildren, don't call this manually */
    public native void reorderBatch(@Cast("bool") boolean reorder);

    //
    // Overrides
    //
    // TextureProtocol
    public native Texture2D getTexture();

    public native void setTexture(Texture2D texture);
    /**
     *@code
     *When this function bound into js or lua,the parameter will be changed
     *In js: var setBlendFunc(var src, var dst)
     *@endcode
     * @lua NA
     */
//        public native void setBlendFunc(const BlendFunc &blendFunc) override;
    /**
     * @js NA
     * @lua NA
     */
//    public native const BlendFunc& getBlendFunc() const override;

//    public native void visit(Renderer *renderer, const kmMat4 &parentTransform, bool parentTransformUpdated) override;

//        using Node::addChild;
//public native void addChild(Node * child, int zOrder, int tag) override;
//    public native void reorderChild(Node *child, int zOrder) override;
//            
//    public native void removeChild(Node *child, bool cleanup) override;
//    public native void removeAllChildrenWithCleanup(bool cleanup) override;
//    public native void sortAllChildren() override;
//    public native void draw(Renderer *renderer, const kmMat4 &transform, bool transformUpdated) override;
//        virtual std::string getDescription() const override;

    /**
     * Inserts a quad at a certain index into the texture atlas. The Sprite won't be added into the children array.
     * This method should be called only when you are dealing with very big AtlasSrite and when most of the Sprite won't be updated.
     * For example: a tile map (TMXMap) or a label with lots of characters (LabelBMFont)
     */
    public native void insertQuadFromSprite(Sprite sprite, int index);

    /* This is the opposite of "addQuadFromSprite.
    It add the sprite to the children and descendants array, but it doesn't update add it to the texture atlas
    */
    public native SpriteBatchNode addSpriteWithoutQuad(Sprite child, int z, int aTag);
}
