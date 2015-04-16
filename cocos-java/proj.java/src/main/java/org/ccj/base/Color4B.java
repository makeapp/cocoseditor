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
public class Color4B
    extends Pointer
{
    public Color4B(int r, int g, int b, int a)
    {
        this((byte) r, (byte) g, (byte) b, (byte) a);
    }

    public Color4B(byte r, byte g, byte b, byte a)
    {
        allocate(r, g, b, a);
    }

    public native void allocate(byte r, byte g, byte b, byte a);

    @MemberGetter()
    @Name("r")
    public native byte getR();

    @MemberGetter()
    @Name("g")
    public native byte getG();

    @MemberGetter()
    @Name("b")
    public native byte getB();

    @MemberGetter()
    @Name("a")
    public native byte getA();

    public static final Color4B WHITE = new Color4B(255, 255, 255, 255);
    public static final Color4B YELLOW = new Color4B(255, 255, 0, 255);
    public static final Color4B GREEN = new Color4B(0, 255, 0, 255);
    public static final Color4B BLUE = new Color4B(0, 0, 255, 255);
    public static final Color4B RED = new Color4B(255, 0, 0, 255);
    public static final Color4B MAGENTA = new Color4B(255, 0, 255, 255);
    public static final Color4B BLACK = new Color4B(0, 0, 0, 255);
    public static final Color4B ORANGE = new Color4B(255, 127, 0, 255);
    public static final Color4B GRAY = new Color4B(166, 166, 166, 255);
}
