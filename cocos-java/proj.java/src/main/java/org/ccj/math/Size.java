/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.math;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.ByRef;
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
public class Size extends Pointer
{
    public float width;

    public float height;


    public Size(float width, float height)
    {
        allocate(width, height);
    }

    public native void allocate(float width, float height);
    /**
     * @js NA
     */
//     Size();
    /**
     * @js NA
     */
//     Size(float width, float height);
    /**
     * @js NA
     * @lua NA
     */
//     Size( Size other);
    /**
     * @js NA
     * @lua NA
     */
//     explicit Size( Vec2 point);
    /**
     * @js NA
     * @lua NA
     */
//     Size operator= ( Size other);
    /**
     * @js NA
     * @lua NA
     */
//     Size operator= ( Vec2 point);
    /**
     * @js NA
     * @lua NA
     */
//     Size operator+( Size right) ;
    /**
     * @js NA
     * @lua NA
     */
//     Size operator-( Size right) ;
    /**
     * @js NA
     * @lua NA
     */
//     Size operator*(float a) ;
    /**
     * @js NA
     * @lua NA
     */
//     Size operator/(float a) ;

    /**
     * @js NA
     * @lua NA
     */
    public native void setSize(float width, float height);

    /**
     * @js NA
     */
    public native boolean equals(@ByRef Size target);

    @MemberGetter()
    @Name("width")
    public native float getWidth();

    @MemberGetter()
    @Name("height")
    public native float getHeight();

    public Size fetch()
    {
        width = getWidth();
        height = getHeight();

        return this;
    }

//    public static native @Raw(withEnv=true) void putEnv();
}
