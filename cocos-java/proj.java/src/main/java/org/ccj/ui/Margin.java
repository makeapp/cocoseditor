/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.ui;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.MemberGetter;
import com.googlecode.javacpp.annotation.Name;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-3-17 下午1:05 $
 *          $Id$
 */

@Platform(include = "ui/UILayoutParameter.h")
@Namespace("cocos2d::ui")
@com.googlecode.javacpp.annotation.Opaque
public class Margin extends Pointer
{
    Margin(float l, float t, float r, float b)
    {
        allocate(l, t, r, b);
    }

    @MemberGetter
    @Name("left")
    public native float getLeft();

    @MemberGetter
    @Name("top")
    public native float getTop();

    @MemberGetter
    @Name("right")
    public native float getRight();

    @MemberGetter
    @Name("bottom")
    public native float getBottom();

    public native void allocate(float l, float t, float r, float b);

    public native void setMargin(float l, float t, float r, float b);
}
