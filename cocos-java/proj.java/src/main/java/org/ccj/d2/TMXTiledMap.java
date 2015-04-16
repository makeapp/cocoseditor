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
import org.ccj.math.Size;
import org.ccj.base.Value;
import org.ccj.base.ValueMap;
import org.ccj.base.VectorTMXObjectGroup;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/4/25 13:51 $
 *          $Id$
 */

@Platform(include = "CCTMXTiledMap.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class TMXTiledMap
    extends Node
{
    /**
     * creates a TMX Tiled Map with a TMX file.
     */
    public native static TMXTiledMap create(@StdString String tmxFile);

    /**
     * initializes a TMX Tiled Map with a TMX formatted XML string and a path to TMX resources
     */
    public native static TMXTiledMap createWithXML(@StdString String tmxString, @StdString String resourcePath);

    /**
     * return the TMXLayer for the specific layer
     */
    public native TMXLayer getLayer(@StdString String layerName);
    /**
     * @js NA
     * @lua NA
     */
//     CC_DEPRECATED_ATTRIBUTE TMXLayer* layerNamed(@StdString  String  layerName) const { return getLayer(layerName); };

    /**
     * return the TMXObjectGroup for the specific group
     */
    public native TMXObjectGroup getObjectGroup(@StdString String groupName);
    /**
     * @js NA
     * @lua NA
     */
//     CC_DEPRECATED_ATTRIBUTE TMXObjectGroup* objectGroupNamed(@StdString  String  groupName) const { return getObjectGroup(groupName); };

    /**
     * return the value for the specific property name
     */
    @ByVal
    public native Value getProperty(@StdString String propertyName);
    /**
     * @js NA
     * @lua NA
     */
//     CC_DEPRECATED_ATTRIBUTE Value propertyNamed(const char *propertyName) const { return getProperty(propertyName); };

    /**
     * return properties dictionary for tile GID
     */
    @ByVal
    public native Value getPropertiesForGID(int GID);
//     CC_DEPRECATED_ATTRIBUTE Value propertiesForGID(int GID) const { return getPropertiesForGID(GID); };

    /**
     * Assings properties to argument value, returns true if it did found properties
     * for that GID and did assinged a value, else it returns false.
     */
//    public native boolean getPropertiesForGID(int GID, Value value);

    /**
     * the map's size property measured in tiles
     */
    @ByRef
    @Const
    public native Size getMapSize();

    public native void setMapSize(@ByRef @Const Size mapSize);

    /**
     * the tiles's size property measured in pixels
     */
    @ByRef
    @Const
    public native Size getTileSize();

    public native void setTileSize(@ByRef @Const Size tileSize);

    /**
     * map orientation
     */
    public native int getMapOrientation();

    public native void setMapOrientation(int mapOrientation);

    /**
     * object groups
     */
    @ByRef
    @Const
    public native VectorTMXObjectGroup getObjectGroups();

    public native void setObjectGroups(@ByRef @Const VectorTMXObjectGroup groups);

    /**
     * properties
     */
    @ByRef
    @Const
    public native ValueMap getProperties();

    public native void setProperties(@ByRef @Const ValueMap properties);
}
