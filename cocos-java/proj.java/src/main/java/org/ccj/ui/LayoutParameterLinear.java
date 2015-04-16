/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.ui;

import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.Name;
import com.googlecode.javacpp.annotation.Platform;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-3-6 下午12:03 $
 *          $Id$
 */
@Platform(include = "ui/UILayoutParameter.h")
@Name("cocos2d::ui::LinearLayoutParameter")
@com.googlecode.javacpp.annotation.Opaque
public class LayoutParameterLinear
    extends LayoutParameter
{

    public static final int LINEAR_GRAVITY_NONE = 0;
    public static final int LINEAR_GRAVITY_LEFT = 1;
    public static final int LINEAR_GRAVITY_TOP = 2;
    public static final int LINEAR_GRAVITY_RIGHT = 3;
    public static final int LINEAR_GRAVITY_BOTTOM = 4;
    public static final int LINEAR_GRAVITY_CENTER_VERTICAL = 5;
    public static final int LINEAR_GRAVITY_CENTER_HORIZONTAL = 6;

    /**
     * Allocates and initializes.
     *
     * @return A initialized LayoutParameter which is marked as "autorelease".
     */
    public native static LayoutParameterLinear create();

    /**
     * Sets LinearGravity parameter for LayoutParameter.
     *
     * @param LinearGravity
     *
     * @see LinearGravity
     */
    public native void setGravity(@Cast("cocos2d::ui::LinearLayoutParameter::LinearGravity") int gravity);

    /**
     * Gets LinearGravity parameter for LayoutParameter.
     *
     * @return LinearGravity
     *
     * @see LinearGravity
     */
    @Cast("int")
    public native int getGravity();


}
