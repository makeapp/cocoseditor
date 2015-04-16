/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.d2;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import com.googlecode.javacpp.annotation.StdString;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/4/22 18:16 $
 *          $Id$
 */
@Platform(include = "CCAtlasNode.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class AtlasNode extends Label
{
    public AtlasNode(Pointer p)
    {
        super(p);
    }

    public AtlasNode()
    {
    }

    /**
     * creates a AtlasNode  with an Atlas file the width and height of each item and the quantity of items to render
     */
    public native static AtlasNode create(@StdString String filename, int tileWidth, int tileHeight, int itemsToRender);

    /**
     * updates the Atlas (indexed vertex array).
     * Shall be overridden in subclasses
     */
    public native void updateAtlasValues();

//    public native void setTextureAtlas(TextureAtlas textureAtlas);
//    public native TextureAtlas getTextureAtlas() ;

    public native void setQuadsToDraw(int quadsToDraw);

    public native int getQuadsToDraw();


    // Overrides
//         public native void draw(Renderer *renderer, const kmMat4 &transform, bool transformUpdated) override;
    public native Texture2D getTexture();

    public native void setTexture(Texture2D texture);


    /**
     * @code
     * When this function bound into js or lua,the parameter will be changed
     * In js: var setBlendFunc(var src, var dst)
     * @endcode
     * @lua NA
     */
//         public native void setBlendFunc(const BlendFunc& blendFunc) override;
    /**
     * @js NA
     * @lua NA
     */
//         public native  BlendFunc getBlendFunc() const override;


    /**
     * initializes an AtlasNode  with an Atlas file the width and height of each item and the quantity of items to render
     */
//    public native boolean initWithTileFile(@StdString String tile, int tileWidth, int tileHeight, int itemsToRender);

    /**
     * initializes an AtlasNode  with a texture the width and height of each item measured in points and the quantity of items to render
     */
//    public native boolean initWithTexture(Texture2D texture, int tileWidth, int tileHeight, int itemsToRender);

}
