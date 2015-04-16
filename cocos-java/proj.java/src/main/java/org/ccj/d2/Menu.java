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
 * @version $Date:14-2-28 上午11:34 $
 *          $Id$
 */
@Platform(include = "CCMenu.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class Menu
    extends Layer
{

    public Menu(Pointer p)
    {
        super(p);
    }

    /**
     * creates an empty Menu
     */
    public native static Menu create();

    /**
     * creates a Menu with MenuItem objects
     */
    public static Menu create(MenuItem... items)
    {
        Menu menu = create();
        for (MenuItem item : items) {
            menu.addChild(item);
        }
        return menu;
    }

    /** creates a Menu with a Array of MenuItem objects */
//        public native static Menu createWithArray(const Vector<MenuItem*>& arrayOfItems);

    /**
     * creates a Menu with it's item, then use addChild() to add
     * other items. It is used for script, it can't init with undetermined
     * number of variables.
     */
    public native static Menu createWithItem(MenuItemImage item);

    /**
     * creates a Menu with MenuItem objects
     */
//        public native static Menu createWithItems(MenuItem *firstItem, va_list args);

//        /** align items vertically */
    public native void alignItemsVertically();

    //        /** align items vertically with padding
//        @since v0.7.2
//        */
    public native void alignItemsVerticallyWithPadding(float padding);

    //
//        /** align items horizontally */
    public native void alignItemsHorizontally();

    //        /** align items horizontally with padding
//        @since v0.7.2
//        */
    public native void alignItemsHorizontallyWithPadding(float padding);

    //
//        /** align items in rows of columns */
//        void alignItemsInColumns(int columns, ...) CC_REQUIRES_NULL_TERMINATION;
//        void alignItemsInColumns(int columns, va_list args);
//        void alignItemsInColumnsWithArray(const ValueVector& rows);
//    
//        /** align items in columns of rows */
//        void alignItemsInRows(int rows, ...) CC_REQUIRES_NULL_TERMINATION;
//        void alignItemsInRows(int rows, va_list args);
//        void alignItemsInRowsWithArray(const ValueVector& columns);
//    
    public native boolean isEnabled();

    public native void setEnabled(@Cast("bool") boolean value);


    public static Menu cast(Node node)
    {
        return cast(node, Menu.class);
    }
}
