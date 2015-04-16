/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.ui;

import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.Const;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import org.ccj.base.Ref;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-3-6 下午12:03 $
 *          $Id$
 */
@Platform(include = "ui/UILayoutParameter.h")
@Namespace("cocos2d::ui")
@com.googlecode.javacpp.annotation.Opaque
public class LayoutParameter
    extends Ref
{
    public static final int LAYOUT_PARAMETER_NONE = 0;
    public static final int LAYOUT_PARAMETER_LINEAR = 1;
    public static final int LAYOUT_PARAMETER_RELATIVE = 2;

    /**
     * Allocates and initializes.
     *
     * @return A initialized LayoutParameter which is marked as "autorelease".
     */
    public native static LayoutParameter create();

    /**
     * Sets Margin parameter for LayoutParameter.
     *
     * @param margin
     *
     * @see Margin
     */
    public native void setMargin(@ByRef @Const Margin margin);

    /**
     * Gets Margin parameter of LayoutParameter.
     *
     * @return const Margin&
     *
     * @see Margin
     */
    @ByRef
    @Const
    public native Margin getMargin();

    /**
     * Gets LayoutParameterType of LayoutParameter.
     *
     * @return LayoutParameterType
     *
     * @see LayoutParameterType
     */
    @Cast("int")
    public native int getLayoutType();
}
