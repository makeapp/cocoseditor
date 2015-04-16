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
public class MenuItemToggle
    extends MenuItem
{
    public MenuItemToggle(Pointer p)
    {
        super(p);
    }
    /** creates a menu item from a Array with a target selector
     * @js NA
     * @lua NA
     */
//    public native    static MenuItemToggle * createWithTarget(Object* target, SEL_MenuHandler selector, const Vector<MenuItem*>& menuItems);
    /** creates a menu item from a list of items with a target/selector
     * @js NA
     * @lua NA
     */
//    public native     static MenuItemToggle createWithTarget(Object* target, SEL_MenuHandler selector, MenuItem* item, ...)CC_REQUIRES_NULL_TERMINATION;

    /** creates a menu item from a Array with a callable object */
//    public native    static MenuItemToggle * createWithCallback(const ccMenuCallback& callback, const Vector<MenuItem*>& menuItems);
    /** creates a menu item from a list of items with a callable object */
//    public native   static MenuItemToggle createWithCallback(const ccMenuCallback& callback, MenuItem* item, ...) CC_REQUIRES_NULL_TERMINATION;

    /**
     * creates a menu item with no target/selector and no items
     */
    public native static MenuItemToggle create();

    /**
     * creates a menu item with a item
     */
    public native static MenuItemToggle create(MenuItem item);

    /**
     * add more menu item
     */
    public native void addSubItem(MenuItem item);

    /**
     * return the selected item
     */
    public native MenuItem getSelectedItem();

    /**
     * @deprecated Use getSelectedItem() instead
     */
    public native MenuItem selectedItem();

    /**
     * Gets the index of the selected item
     */
    public native int getSelectedIndex();

    /**
     * Sets the index of the selected item
     */
    public native void setSelectedIndex(int index);

    /** Gets the array that contains the subitems.
     You can add/remove items in runtime, and you can replace the array with a new one.
     @since v0.7.2
      * @js NA
     * @lua NA
     */
//    public native   Vector<MenuItem*>& getSubItems();
//    public native    Vector<MenuItem*>& getSubItems();

    /**
     * Sets the array that contains the subitems.
     */
//      public native    void setSubItems(const Vector<MenuItem*>& items);

    // Overrides
    public native void activate();

    public native void selected();

    public native void unselected();

    public native void setEnabled(@Cast("bool") boolean var);
}
