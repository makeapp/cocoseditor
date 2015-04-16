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
@Platform(include = "ui/UITextBMFont.h")
@Namespace("cocos2d::ui")
@com.googlecode.javacpp.annotation.Opaque
public class TextBMFont
    extends Widget
{
    public TextBMFont(Pointer p)
    {
        super(p);
    }

    /**
     * Allocates and initializes.
     */
    public native static TextBMFont create();

    /**
     * init a bitmap font atlas with an initial string and the FNT file
     */
    public native void setFntFile(String fileName);

    /**
     * set string value for labelbmfont
     */
    public native void setText(String value);

    /**
     * get string value for labelbmfont
     */
    @StdString
    public native String getStringValue();

//    public native void setAnchorPoint(@Const @ByRef Vec2 pt);

//    public native
//    @Const
//    @ByRef
//    Size getContentSize();


//    public native Node getVirtualRenderer();
}
