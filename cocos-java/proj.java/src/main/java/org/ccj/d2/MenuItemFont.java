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
 * @version $Date:14-2-28 上午11:39 $
 *          $Id$
 */

@Platform(include = "CCMenuItem.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class MenuItemFont
    extends MenuItemLabel
{
    public MenuItemFont(Pointer p)
    {
        super(p);
    }

    /**
     * creates a menu item from a string without target/selector. To be used with MenuItemToggle
     */
    public native static MenuItemFont create(String value);

    public static MenuItemFont create(String value, MenuItemListener listener)
    {
        MenuItemFont itemFont = MenuItemFont.create(value);
        itemFont.setOnClickListener(listener);
        return itemFont;
    }
    /** creates a menu item from a string with a target/selector */
//       static MenuItemFont * create( String value, Object* target, SEL_MenuHandler selector);
    /** creates a menu item from a string with a target/selector */
//      static MenuItemFont * create( String value,  ccMenuCallback& callback);

    /**
     * set default font size
     */
    public native static void setFontSize(int size);

    /**
     * get default font size
     */
    public native static int getFontSize();

    public native static int fontSize();

    /**
     * set the default font name
     */
    public native static void setFontName(String name);

    /**
     * get the default font name
     */
    @StdString
    public native static String getFontName();

    @StdString
    public native static String fontName();

    /**
     * set font size
     * c++ can not overload static and non-static member functions with the same parameter types
     * so change the name to setFontSizeObj
     *
     * @js setFontSize
     */
    public native void setFontSizeObj(int size);

    /**
     * get font size
     *
     * @js getFontSize
     */
    public native int getFontSizeObj();


    public native int fontSizeObj();

    /**
     * set the font name
     * c++ can not overload static and non-static member functions with the same parameter types
     * so change the name to setFontNameObj
     *
     * @js setFontName
     */
    public native void setFontNameObj(@StdString String name);

    /**
     * returns the name of the Font
     *
     * @js getFontNameObj
     */
    @StdString
    public native String getFontNameObj();

    /**
     * deprecated Use getFontNameObj() instead
     */
//    public native String fontNameObj()
//    {
//        return getFontNameObj();
//    }
}
