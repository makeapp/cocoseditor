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
 * @version $Date:14-3-5 上午11:06 $
 *          $Id$
 */
@Platform(include = "CCTypes.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class Color3B extends Pointer
{
    byte r;
    byte g;
    byte b;

    public Color3B(int r, int g, int b)
    {
        this((byte) r, (byte) g, (byte) b);
    }

    public Color3B(byte r, byte g, byte b)
    {
        allocate(r, g, b);
    }

    public native void allocate(byte r, byte g, byte b);

    @MemberGetter()
    @Name("r")
    public native byte getR();

    @MemberGetter()
    @Name("g")
    public native byte getG();

    @MemberGetter()
    @Name("b")
    public native byte getB();

    public static Color3B white()
    {
        return new Color3B(255, 255, 255);
    }


    public static final Color3B WHITE = new Color3B(255, 255, 255);
    public static final Color3B YELLOW = new Color3B(255, 255, 0);
    public static final Color3B GREEN = new Color3B(0, 255, 0);
    public static final Color3B BLUE = new Color3B(0, 0, 255);
    public static final Color3B RED = new Color3B(255, 0, 0);
    public static final Color3B MAGENTA = new Color3B(255, 0, 255);
    public static final Color3B BLACK = new Color3B(0, 0, 0);
    public static final Color3B ORANGE = new Color3B(255, 127, 0);
    public static final Color3B GRAY = new Color3B(166, 166, 166);
}
