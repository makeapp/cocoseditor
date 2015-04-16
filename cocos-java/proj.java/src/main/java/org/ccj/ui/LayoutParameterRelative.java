/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.ui;

import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.Name;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import com.googlecode.javacpp.annotation.StdString;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-3-6 下午12:03 $
 *          $Id$
 */
@Platform(include = "ui/UILayoutParameter.h")
@Name("cocos2d::ui::RelativeLayoutParameter")
@com.googlecode.javacpp.annotation.Opaque
public class LayoutParameterRelative
    extends LayoutParameter
{
    public static final int RELATIVE_ALIGN_NONE = 0;
    public static final int RELATIVE_ALIGN_PARENT_TOP_LEFT = 1;
    public static final int RELATIVE_ALIGN_PARENT_TOP_CENTER_HORIZONTAL = 2;
    public static final int RELATIVE_ALIGN_PARENT_TOP_RIGHT = 3;
    public static final int RELATIVE_ALIGN_PARENT_LEFT_CENTER_VERTICAL = 4;
    public static final int RELATIVE_CENTER_IN_PARENT = 5;
    public static final int RELATIVE_ALIGN_PARENT_RIGHT_CENTER_VERTICAL = 6;
    public static final int RELATIVE_ALIGN_PARENT_LEFT_BOTTOM = 7;
    public static final int RELATIVE_ALIGN_PARENT_BOTTOM_CENTER_HORIZONTAL = 8;
    public static final int RELATIVE_ALIGN_PARENT_RIGHT_BOTTOM = 9;

    public static final int RELATIVE_LOCATION_ABOVE_LEFTALIGN = 10;
    public static final int RELATIVE_LOCATION_ABOVE_CENTER = 11;
    public static final int RELATIVE_LOCATION_ABOVE_RIGHTALIGN = 12;
    public static final int RELATIVE_LOCATION_LEFT_OF_TOPALIGN = 13;
    public static final int RELATIVE_LOCATION_LEFT_OF_CENTER = 14;
    public static final int RELATIVE_LOCATION_LEFT_OF_BOTTOMALIGN = 15;
    public static final int RELATIVE_LOCATION_RIGHT_OF_TOPALIGN = 16;
    public static final int RELATIVE_LOCATION_RIGHT_OF_CENTER = 17;
    public static final int RELATIVE_LOCATION_RIGHT_OF_BOTTOMALIGN = 18;
    public static final int RELATIVE_LOCATION_BELOW_LEFTALIGN = 19;
    public static final int RELATIVE_LOCATION_BELOW_CENTER = 20;
    public static final int RELATIVE_LOCATION_BELOW_RIGHTALIGN = 21;

    /**
     * Allocates and initializes.
     *
     * @return A initialized LayoutParameter which is marked as "autorelease".
     */
    public native static LayoutParameterRelative create();

    /**
     * Sets RelativeAlign parameter for LayoutParameter.
     *
     * @param RelativeAlign
     *
     * @see RelativeAlign
     */
    public native void setAlign(@Cast("cocos2d::ui::RelativeLayoutParameter::RelativeAlign") int align);

    /**
     * Gets RelativeAlign parameter for LayoutParameter.
     *
     * @return RelativeAlign
     *
     * @see RelativeAlign
     */
    @Cast("int")
    public native int getAlign();

    /**
     * Sets a key for LayoutParameter. Witch widget named this is relative to.
     *
     * @param name
     */
    public native void setRelativeToWidgetName(@StdString String name);

    /**
     * Gets the key of LayoutParameter. Witch widget named this is relative to.
     *
     * @return name
     */
    @StdString
    public native String getRelativeToWidgetName();

    /**
     * Sets a name in Relative Layout for LayoutParameter.
     *
     * @param name
     */
    public native void setRelativeName(@StdString String name);

    /**
     * Gets a name in Relative Layout of LayoutParameter.
     *
     * @return name
     */
    @StdString
    public native String getRelativeName();
}
