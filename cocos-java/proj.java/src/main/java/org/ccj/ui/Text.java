/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.ui;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.Cast;
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
@Platform(include = "ui/UIText.h")
@Namespace("cocos2d::ui")
@com.googlecode.javacpp.annotation.Opaque
public class Text
    extends Widget
{
    public Text(Pointer p)
    {
        super(p);
    }

    /**
     * Allocates and initializes.
     */
    public native static Text create();

    /**
     * Changes the string value of label.
     *
     * @param text string value.
     */
    public native void setText(@StdString String text);

    /**
     * Gets the string value of label.
     *
     * @return text  string value.
     */
    @StdString
    public native String getStringValue();

    /**
     * Gets the string length of label.
     *
     * @return string length.
     */
    public native int getStringLength();

    /**
     * Sets the font size of label.
     *
     * @param font size.
     */
    public native void setFontSize(int size);

    /**
     * Sets the font name of label.
     *
     * @param font name.
     */
    public native void setFontName(String name);

    /**
     * Sets the touch scale enabled of label.
     *
     * @param touch scale enabled of label.
     */
    public native void setTouchScaleChangeEnabled(@Cast("bool") boolean enabled);

    /**
     * Gets the touch scale enabled of label.
     *
     * @return touch scale enabled of label.
     */
    public native boolean isTouchScaleChangeEnabled();

    /**
     * Changes both X and Y scale factor of the widget.
     * <p/>
     * 1.0 is the default scale factor. It modifies the X and Y scale at the same time.
     *
     * @param scale The scale factor for both X and Y axis.
     */
//    public native void setScale(float fScale);

    /**
     * Changes the scale factor on X axis of this widget
     * <p/>
     * The deafult value is 1.0 if you haven't changed it before
     *
     * @param fScaleX The scale factor on X axis.
     */
//    public native void setScaleX(float fScaleX);

    /**
     * Changes the scale factor on Y axis of this widget
     * <p/>
     * The Default value is 1.0 if you haven't changed it before.
     *
     * @param fScaleY The scale factor on Y axis.
     */
//    public native void setScaleY(float fScaleY);


    // "setFlipX" method of widget.
//    public native void setFlipX(@Cast("bool") boolean flipX);

    // "setFlipY" method of widget.
//    public native void setFlipY(@Cast("bool") boolean flipY);

    // "isFlipX" method of widget.
//    public native boolean isFlipX();

    // "isFlipY" method of widget.
//    public native boolean isFlipY();

    // "setAnchorPoint" method of widget.
//    public native void setAnchorPoint(@Const @ByRef Vec2 pt);

    // "getContentSize" method of widget.
    @Const
    @ByRef
//    public native Size getContentSize();

    // "getVirtualRenderer" method of widget.
//    public native Node getVirtualRenderer();

    public native void setTextAreaSize(@Const @ByRef Size size);

    public native void setTextHorizontalAlignment(@Cast("cocos2d::TextHAlignment") int alignment);

    public native void setTextVerticalAlignment(@Cast("cocos2d::TextVAlignment") int alignment);
}
