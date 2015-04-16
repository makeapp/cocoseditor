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
import org.ccj.math.Vec2;
import org.ccj.math.Size;
import org.ccj.base.Value;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/4/25 13:55 $
 *          $Id$
 */

@Platform(include = "CCTMXLayer.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class TMXLayer extends SpriteBatchNode
{
    /** creates a TMXLayer with an tileset info, a layer info and a map info */
//   public native  static TMXLayer  create(TMXTilesetInfo  tilesetInfo, TMXLayerInfo  layerInfo, TMXMapInfo  mapInfo);

    /** initializes a TMXLayer with a tileset info, a layer info and a map info */
//      public native  boolean initWithTilesetInfo(TMXTilesetInfo   tilesetInfo, TMXLayerInfo  layerInfo, TMXMapInfo  mapInfo);

    /**
     * dealloc the map that contains the tile position from memory.
     * Unless you want to know at runtime the tiles positions, you can safely call this method.
     * If you are going to call layer->tileGIDAt() then, don't release the map
     */
    public native void releaseMap();

    /**
     * returns the tile (Sprite) at a given a tile coordinate.
     * The returned Sprite will be already added to the TMXLayer. Don't add it again.
     * The Sprite can be treated like any other Sprite: rotated, scaled, translated, opacity, color, etc.
     * You can remove either by calling:
     * - layer->removeChild(sprite, cleanup);
     * - or layer->removeTileAt(Vec2(x,y));
     */
    public native Sprite getTileAt(@ByRef Vec2 tileCoordinate);
//      CC_DEPRECATED_ATTRIBUTE Sprite* tileAt(const Vec2& tileCoordinate) { return getTileAt(tileCoordinate); };

    /** returns the tile gid at a given tile coordinate. It also returns the tile flags.
     This method requires the the tile map has not been previously released (eg. don't call [layer releaseMap])
     */
//      public native int getTileGIDAt(@ByRef @Const Vec2 tileCoordinate, TMXTileFlags* flags = nullptr);
//      CC_DEPRECATED_ATTRIBUTE int tileGIDAt(const Vec2& tileCoordinate, TMXTileFlags* flags = nullptr){
//          return getTileGIDAt(tileCoordinate, flags);
//      };

    /**
     * sets the tile gid (gid = tile global id) at a given tile coordinate.
     * The Tile GID can be obtained by using the method "tileGIDAt" or by using the TMX editor -> Tileset Mgr +1.
     * If a tile is already placed at that position, then it will be removed.
     */
    public native void setTileGID(int gid, @ByRef @Const Vec2 tileCoordinate);

    /**
     * sets the tile gid (gid = tile global id) at a given tile coordinate.
     * The Tile GID can be obtained by using the method "tileGIDAt" or by using the TMX editor -> Tileset Mgr +1.
     * If a tile is already placed at that position, then it will be removed.
     * <p/>
     * Use withFlags if the tile flags need to be changed as well
     */

//    public native void setTileGID(int gid, @ByRef @Const Vec2 tileCoordinate, TMXTileFlags flags);

    /**
     * removes a tile at given tile coordinate
     */
    public native void removeTileAt(@ByRef @Const Vec2 tileCoordinate);

    /**
     * returns the position in points of a given tile coordinate
     */
    @ByVal
    public native Vec2 getPositionAt(@ByRef @Const Vec2 tileCoordinate);
//      CC_DEPRECATED_ATTRIBUTE Vec2 positionAt(const Vec2& tileCoordinate) { return getPositionAt(tileCoordinate); };

    /**
     * return the value for the specific property name
     */
    @ByVal
    public native Value getProperty(@StdString String propertyName);
//      CC_DEPRECATED_ATTRIBUTE Value propertyNamed(@StdString  String  propertyName) const { return getProperty(propertyName); };

    /**
     * Creates the tiles
     */
    public native void setupTiles();

    @StdString
    @Const
    public native String getLayerName();

    public native void setLayerName(@StdString String layerName);

    /**
     * size of the layer in tiles
     */
    @ByRef
    @Const
    public native Size getLayerSize();

    public native void setLayerSize(@ByRef @Const Size size);

    /**
     * size of the map's tile (could be different from the tile's size)
     */
    @ByRef
    @Const
    public native Size getMapTileSize();

    public native void setMapTileSize(@ByRef @Const Size size);

    /**
     * pointer to the map of tiles
     *
     * @js NA
     * @lua NA
     */
//    public native int getTiles();

//    public native void setTiles(int tiles);

    /** Tileset information for the layer */
//        public native TMXTilesetInfo getTileSet();
//        public native void setTileSet(TMXTilesetInfo info) ;

    /**
     * Layer orientation, which is the same as the map orientation
     */
    public native int getLayerOrientation();

    public native void setLayerOrientation(int orientation);

    /**
     * properties from the layer. They can be added using Tiled
     */
//    @ByRef
//    @Const
//    public native ValueMap getProperties();

//    public native void setProperties(@ByRef @Const ValueMap properties);
    //
    // Override
    //

    /**
     * TMXLayer doesn't support adding a Sprite manually.
     *
     * @warning addchild(z, tag); is not supported on TMXLayer. Instead of setTileGID.
     */
    public native void addChild(Node child, int zOrder, int tag);

    // super method
    public native void removeChild(Node child, boolean cleanup);

    @StdString
    public native String getDescription();
}
