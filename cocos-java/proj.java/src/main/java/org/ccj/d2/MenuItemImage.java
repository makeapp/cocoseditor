/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.d2;

import com.googlecode.javacpp.Pointer;
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
public class MenuItemImage
    extends MenuItem
{

    public MenuItemImage(Pointer p)
    {
        super(p);
    }

    public native static MenuItemImage create();

    /**
     * creates a menu item with a normal and selected image
     */
    public native static MenuItemImage create(String normalImage, String selectedImage);

    /**
     * creates a menu item with a normal,selected  and disabled image
     */
//    public native static MenuItemImage create(String normalImage, String selectedImage, String disabledImage);
    /** creates a menu item with a normal and selected image with target/selector */
//    public native static MenuItemImage create(String normalImage, String selectedImage, Object target, SEL_MenuHandler selector);
    /** creates a menu item with a normal and selected image with a callable object */
//    public native   static MenuItemImage create(StringnormalImage, StringselectedImage, const ccMenuCallback& callback);

    /** creates a menu item with a normal,selected  and disabled image with target/selector */
//    public native static MenuItemImage create(String, String selectedImage, String disabledImage, Object* target, SEL_MenuHandler selector);
    /** creates a menu item with a normal,selected  and disabled image with a callable object */
//    public native   static MenuItemImage create(StringnormalImage, StringselectedImage, StringdisabledImage, const ccMenuCallback& callback);

    /** sets the sprite frame for the normal image */
//        void setNormalSpriteFrame(SpriteFrame* frame);
    /** sets the sprite frame for the selected image */
//        void setSelectedSpriteFrame(SpriteFrame* frame);
    /** sets the sprite frame for the disabled image */
//        void setDisabledSpriteFrame(SpriteFrame* frame);
}
