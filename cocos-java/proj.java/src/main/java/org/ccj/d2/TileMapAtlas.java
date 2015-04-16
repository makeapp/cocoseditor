/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.d2;

import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.ByVal;
import com.googlecode.javacpp.annotation.Const;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import com.googlecode.javacpp.annotation.StdString;
import org.ccj.base.Color3B;
import org.ccj.math.Vec2;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/4/27 10:19 $
 *          $Id$
 */
@Platform(include = "CCTileMapAtlas.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class TileMapAtlas extends AtlasNode
{
    /**
     * creates a TileMap with a tile file (atlas) with a map file and the width and height of each tile in points.
     * The tile file will be loaded using the TextureMgr.
     */
    public native static TileMapAtlas create(@StdString String tile, @StdString String mapFile, int tileWidth, int tileHeight);

    /**
     * @js NA
     * @lua NA
     */
//      virtual ~TileMapAtlas();

    /** initializes a TileMap with a tile file (atlas) with a map file and the width and height of each tile in points.
     The file will be loaded using the TextureMgr.
     */
//      bool initWithTileFile(@StdString  String   tile, @StdString  String   mapFile, int tileWidth, int tileHeight);

    /**
     * returns a tile from position x,y.
     * For the moment only channel R is used
     */
    @ByVal
    public native Color3B getTileAt(@Const @ByRef Vec2 position);
//      CC_DEPRECATED_ATTRIBUTE Color3B tileAt(const Vec2& position) const { return getTileAt(position); };

    /**
     * sets a tile at position x,y.
     * For the moment only channel R is used
     */
    public native void setTile(@Const @ByRef Color3B tile, @Const @ByRef Vec2 position);

    /**
     * dealloc the map from memory
     */
    public native void releaseMap();

//    public native  struct sImageTGA* getTGAInfo() const { return _TGAInfo; };
//    public native  void setTGAInfo(struct sImageTGA* TGAInfo) { _TGAInfo = TGAInfo; };

}
