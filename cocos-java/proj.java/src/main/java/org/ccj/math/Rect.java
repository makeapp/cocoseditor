/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.math;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.ByVal;
import com.googlecode.javacpp.annotation.Const;
import com.googlecode.javacpp.annotation.MemberGetter;
import com.googlecode.javacpp.annotation.Name;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-3-3 上午10:30 $
 *          $Id$
 */
@Platform(include = "CCGeometry.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class Rect extends Pointer
{
    /**
     * @js NA
     */
    public Rect()
    {
        allocate();
    }

    /**
     * @js NA
     */
    public Rect(float x, float y, float width, float height)
    {
        allocate(x, y, width, height);
    }

    public native void allocate(@ByRef Rect other);

    public native void allocate();

    public native void allocate(float x, float y, float width, float height);

    /**
     * @js NA
     * @lua NA
     */
    public Rect(Rect other)
    {
        allocate(other);
    }


    /**
     * @js NA
     * @lua NA
     */
//       Rect& operator= ( Rect& other);
    @Name("operator=")
    public native void assign(@ByRef @Const Rect other);

    /**
     * @js NA
     * @lua NA
     */
    public native void setRect(float x, float y, float width, float height);

    /**
     * @js NA
     */
    public native float getMinX(); /// return the leftmost x-value of current rect

    /**
     * @js NA
     */
    public native float getMidX(); /// return the midpoint x-value of current rect

    /**
     * @js NA
     */
    public native float getMaxX(); /// return the rightmost x-value of current rect

    /**
     * @js NA
     */
    public native float getMinY(); /// return the bottommost y-value of current rect

    /**
     * @js NA
     */
    public native float getMidY(); /// return the midpoint y-value of current rect

    /**
     * @js NA
     */
    public native float getMaxY(); /// return the topmost y-value of current rect

    /**
     * @js NA
     */
    public native boolean equals(@ByRef Rect rect);

    /**
     * @js NA
     */
    public native boolean containsPoint(@ByRef Vec2 point);

    /**
     * @js NA
     */
    public native boolean intersectsRect(@ByRef Rect rect);


    public boolean containsRect(@ByRef Rect rect)
    {

        if ((getMinX() >= rect.getMaxX()) || (getMinY() >= rect.getMinY()) ||
            (getMaxX() <= rect.getMaxX()) ||
            (getMaxY() <= rect.getMaxY()))
            return false;
        return true;
    }

    /**
     * @js NA
     * @lua NA
     */
    @ByVal
    public native Rect unionWithRect(@ByRef Rect rect);

    @MemberGetter()
    @Name("origin")
    @ByRef
    public native Vec2 getOrigin();

    @MemberGetter()
    @Name("size")
    @ByRef
    public native Size getSize();

    public String toString()
    {
        StringBuffer buffer = new StringBuffer();
        buffer.append("[{").append(getMinX());
        buffer.append(",").append(getMinY());
        buffer.append("},{").append(getMaxX());
        buffer.append(",").append(getMaxX());
        buffer.append("}]");

        return buffer.toString();
    }
}
