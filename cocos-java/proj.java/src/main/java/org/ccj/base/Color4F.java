/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.base;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.MemberGetter;
import com.googlecode.javacpp.annotation.Name;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-3-5 上午11:07 $
 *          $Id$
 */
@Platform(include = "CCTypes.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class Color4F
    extends Pointer
{
    public Color4F(float r, float g, float b, float a)
    {
        allocate(r, g, b, a);
    }

    public native void allocate(float r, float g, float b, float a);


    @MemberGetter()
    @Name("r")
    public native float getR();

    @MemberGetter()
    @Name("g")
    public native float getG();

    @MemberGetter()
    @Name("b")
    public native float getB();

    @MemberGetter()
    @Name("a")
    public native float getA();

    public Color4B toColor4B()
    {
        return new Color4B((int) (getR() * 255), (int) (getG() * 255), (int) (getB() * 255), (int) (getA() * 255));
    }

    public static final Color4F WHITE = new Color4F(1, 1, 1, 1);
    public static final Color4F YELLOW = new Color4F(1, 1, 0, 1);
    public static final Color4F GREEN = new Color4F(0, 1, 0, 1);
    public static final Color4F BLUE = new Color4F(0, 0, 1, 1);
    public static final Color4F RED = new Color4F(1, 0, 0, 1);
    public static final Color4F MAGENTA = new Color4F(1, 0, 1, 1);
    public static final Color4F BLACK = new Color4F(0, 0, 0, 1);
    public static final Color4F ORANGE = new Color4F(1f, 0.5f, 0f, 1f);
    public static final Color4F GRAY = new Color4F(0.65f, 0.65f, 0.65f, 1);
}
