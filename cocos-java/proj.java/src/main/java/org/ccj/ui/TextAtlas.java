/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.ui;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.Const;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import com.googlecode.javacpp.annotation.StdString;
import org.ccj.d2.Node;
import org.ccj.math.Vec2;
import org.ccj.math.Size;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-3-6 下午12:03 $
 *          $Id$
 */
@Platform(include = "ui/UITextAtlas.h")
@Namespace("cocos2d::ui")
@com.googlecode.javacpp.annotation.Opaque
public class TextAtlas
    extends Widget
{
    public TextAtlas(Pointer p)
    {
        super(p);
    }

    /**
     * Allocates and initializes.
     */
    public native static TextAtlas create();

    /**
     * initializes the LabelAtlas with a string, a char map file(the atlas), the width and height of each element and the starting char of the atlas
     */
    public native void setProperty(String stringValue, String charMapFile, int itemWidth, int itemHeight, String startCharMap);

    //set string value for labelatlas.
    public native void setStringValue(String value);

    //get string value for labelatlas.
    @StdString
    @Const
    public native String getStringValue();

    // "setAnchorPoint" method of widget.
//    public native void setAnchorPoint(@Const @ByRef Vec2 pt);

    // "getContentSize" method of widget.
//    public native
//    @Const
//    @ByRef
//    Size getContentSize();

    // "getVirtualRenderer" method of widget.
//    public native Node getVirtualRenderer();

}
