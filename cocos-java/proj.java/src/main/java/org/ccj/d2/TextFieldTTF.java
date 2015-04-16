/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.d2;

import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.Const;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import com.googlecode.javacpp.annotation.StdString;
import org.ccj.base.Color3B;
import org.ccj.math.Size;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-2-28 上午11:34 $
 *          $Id$
 */
@Platform(include = "CCMenu.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class TextFieldTTF
    extends Label
{
    //char * description();

    /**
     * creates a TextFieldTTF from a fontname, alignment, dimension and font size
     */
    public native static TextFieldTTF textFieldWithPlaceHolder(@StdString String placeholder, @Const @ByRef Size dimensions, @Cast("cocos2d::TextHAlignment") int alignment, @StdString String fontName, float fontSize);

    /**
     * creates a LabelTTF from a fontname and font size
     */
    public native static TextFieldTTF textFieldWithPlaceHolder(@StdString String placeholder, @StdString String fontName, float fontSize);

    /**
     * initializes the TextFieldTTF with a font name, alignment, dimension and font size
     */
    public native boolean initWithPlaceHolder(@StdString String placeholder, @Const @ByRef Size dimensions, @Cast("cocos2d::TextHAlignment") int alignment, @StdString String fontName, float fontSize);

    /**
     * initializes the TextFieldTTF with a font name and font size
     */
    public native boolean initWithPlaceHolder(@StdString String placeholder, @StdString String fontName, float fontSize);

    /**
     * @brief Open keyboard and receive input text.
     */
    public native boolean attachWithIME();

    /**
     * @brief End text input and close keyboard.
     */
    public native boolean detachWithIME();

    //////////////////////////////////////////////////////////////////////////
    // properties
    //////////////////////////////////////////////////////////////////////////
    /**
     * @js NA
     * @lua NA
     */
//    public native TextFieldDelegate* getDelegate() const { return _delegate; };

    /**
     * @js NA
     * @lua NA
     */
//    public native void setDelegate(TextFieldDelegate* delegate) { _delegate = delegate; };
    public native int getCharCount();

    @ByRef
    @Const
    public native Color3B getColorSpaceHolder();

    public native void setColorSpaceHolder(@ByRef @Const Color3B color);

}
