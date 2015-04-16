/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.d2;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-2-28 上午11:39 $
 *          $Id$
 */

@Platform(include = "CCMenuItem.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class MenuItemSprite
    extends MenuItem
{
    public MenuItemSprite(Pointer p)
    {
        super(p);
    }

    /**
     * creates a menu item with a normal, selected and disabled image
     */
    public native static MenuItemSprite create(Node normalSprite, Node selectedSprite, Node disabledSprite);
    /** creates a menu item with a normal and selected image with target/selector */
//    public native    static MenuItemSprite * create(Node normalSprite, Node selectedSprite, Object* target, SEL_MenuHandler selector);
    /** creates a menu item with a normal,selected  and disabled image with target/selector */
//    public native    static MenuItemSprite * create(Node normalSprite, Node selectedSprite, Node disabledSprite, Object* target, SEL_MenuHandler selector);
    /** creates a menu item with a normal and selected image with a callable object */
//    public native   static MenuItemSprite * create(Node normalSprite, Node selectedSprite, const ccMenuCallback& callback);
    /** creates a menu item with a normal,selected  and disabled image with target/selector */
//    public native   static MenuItemSprite * create(Node normalSprite, Node selectedSprite, Node disabledSprite, const ccMenuCallback& callback);

    /**
     * Gets the image used when the item is not selected
     */
    public native Node getNormalImage();

    /**
     * Sets the image used when the item is not selected
     */
    public native void setNormalImage(Node image);

    /**
     * Gets the image used when the item is selected
     */
    public native Node getSelectedImage();

    /**
     * Sets the image used when the item is selected
     */
    public native void setSelectedImage(Node image);

    /**
     * Gets the image used when the item is disabled
     */
    public native Node getDisabledImage();

    /**
     * Sets the image used when the item is disabled
     */
    public native void setDisabledImage(Node image);

    /**
     * @since v0.99.5
     */
    public native void selected();

    public native void unselected();

    public native void setEnabled(@Cast("bool") boolean bEnabled);
}
