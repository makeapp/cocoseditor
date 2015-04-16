/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.d2;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.ByVal;
import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import org.ccj.math.Rect;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-2-28 上午11:39 $
 *          $Id$
 */

@Platform(include = "CCMenuItem.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class MenuItem
    extends Node
{

    public MenuItem(Pointer p)
    {
        super(p);
    }

    public native static MenuItem create();

    @ByVal
    public native Rect rect();

    /**
     * Activate the item
     */
    public native void activate();

    /**
     * The item was selected (not activated), similar to "mouse-over"
     */
    public native void selected();

    /**
     * The item was unselected
     */
    public native void unselected();

    /**
     * returns whether or not the item is enabled
     */
    public native boolean isEnabled();

    /**
     * enables or disables the item
     */
    public native void setEnabled(@Cast("bool") boolean value);

    /**
     * returns whether or not the item is selected
     */
    public native boolean isSelected();



    MenuItemListener menuItemListener;

    public void setOnClickListener(MenuItemListener menuItemListener)
    {
        this.menuItemListener = menuItemListener;
        putRef(this);
    }

    public void onItemClicked()
    {
        if (menuItemListener != null) {
            menuItemListener.onClicked(this);
        }
    }

    public interface MenuItemListener
    {
        public void onClicked(MenuItem item);
    }
}
