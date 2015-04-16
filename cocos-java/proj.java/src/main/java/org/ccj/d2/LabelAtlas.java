/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.d2;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.Const;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import com.googlecode.javacpp.annotation.StdString;
import org.ccj.base.Ref;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/4/22 18:14 $
 *          $Id$
 */

@Platform(include = "CCLabelTTF.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class LabelAtlas extends AtlasNode
{
    public LabelAtlas(Pointer p)
    {
        super(p);
    }

    public LabelAtlas()
    {
    }

    /**
     * creates an empty LabelAtlas, user need to call initWithString(...) later to make this object work properly *
     */
    public native static LabelAtlas create();

    /**
     * creates the LabelAtlas with a string, a char map file(the atlas), the width and height of each element and the starting char of the atlas
     */
    public native static LabelAtlas create(@StdString String string, @StdString String charMapFile, int itemWidth, int itemHeight, int startCharMap);

    /**
     * creates the LabelAtlas with a string and a configuration file
     *
     * @since v2.0
     */
    public native static LabelAtlas create(@StdString String string, @StdString String fntFile);

    /**
     * initializes the LabelAtlas with a string, a char map file(the atlas), the width and height of each element and the starting char of the atlas
     */
    public native boolean initWithString(@StdString String string, @StdString String charMapFile, int itemWidth, int itemHeight, int startCharMap);

    /**
     * initializes the LabelAtlas with a string and a configuration file
     *
     * @since v2.0
     */
    public native boolean initWithString(@StdString String string, @StdString String fntFile);

    /**
     * initializes the LabelAtlas with a string, a texture, the width and height in points of each element and the starting char of the atlas
     */
    public native boolean initWithString(@StdString String string, Texture2D texture, int itemWidth, int itemHeight, int startCharMap);

    // super methods
//         public native void updateAtlasValues();

    public native void setString(@StdString String label);

    @StdString
    @Const
    public native String getString();

    public static LabelAtlas cast(Ref tag)
    {
        return cast(tag, LabelAtlas.class);
    }
}
