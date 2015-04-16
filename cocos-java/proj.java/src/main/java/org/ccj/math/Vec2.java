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
@Platform(include = "Vec2.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class Vec2 extends Pointer
{
    public float x;
    public float y;

    /**
     * @js NA
     */
//      Vec2();
    public static Vec2 create(float x, float y)
    {
        return new Vec2(x, y);
    }

    /**
     * @js NA
     */
    public Vec2(float x, float y)
    {
        allocate(x, y);
        this.x = x;
        this.y = y;
    }

    public native void allocate(float x, float y);

    public native void allocate(@ByRef Vec2 point);

    /**
     * @js NA
     * @lua NA
     */
    public Vec2(Vec2 other)
    {
        allocate(other);
    }

    /**
     * @js NA
     * @lua NA
     */
//      explicit Vec2( Size size);
    public Vec2 fetch()
    {
        x = getX();
        y = getY();
        return this;
    }

    /**
     * @js NA
     * @lua NA
     */
//      Vec2 operator= ( Vec2 other);
    @Name("operator=")
    @ByVal
    public native Vec2 assign(@ByRef @Const Vec2 point);

    /**
     * @js NA
     * @lua NA
     */
//      Vec2 operator= ( Size size);
    @Name("operator=")
    @ByVal
    public native Vec2 assign(@ByRef @Const Size size);

    /**
     * @js NA
     * @lua NA
     */
//      Vec2 operator+( Vec2 right) ;
    @Name("operator+")
    @ByVal
    public native Vec2 plus(@ByRef Vec2 right);

    /**
     * @js NA
     * @lua NA
     */
//      Vec2 operator+=( Vec2 right);
//    @Name("operator+")
//    public native void plus(@ByRef Vec2 right);

    /**
     * @js NA
     * @lua NA
     */
//      Vec2 operator-( Vec2 right) ;
    @Name("operator-")
    @ByVal
    public native Vec2 minus(@ByRef Vec2 right);

    /**
     * @js NA
     * @lua NA
     */
//      Vec2 operator-=( Vec2 right);
    /**
     * @js NA
     * @lua NA
     */
//      Vec2 operator-() ;

    /**
     * @js NA
     * @lua NA
     */
//      boolean  operator==( Vec2 right) ;
    @Name("operator==")
    public native boolean equal(@Const @ByRef Vec2 point);

    /**
     * @js NA
     * @lua NA
     */
//      boolean  operator!=( Vec2 right) ;
    @Name("operator!=")

    public native boolean notEqual(@Const @ByRef Vec2 point);


    @MemberGetter()
    @Name("x")
    public native float getX();

    @MemberGetter()
    @Name("y")
    public native float getY();

    /**
     * @js NA
     * @lua NA
     */
//      Vec2 operator*(float a) ;
//    @Name("operator*")
//    @ByVal
//    public native Vec2 multiply(@Const @ByRef Vec2 point);

    /**
     * @js NA
     * @lua NA
     */
//      Vec2 operator/(float a) ;
//    @Name("operator/")
//    @ByVal
//    public native Vec2 divide(@Const @ByRef Vec2 point);


    /**
     * @js NA
     * @lua NA
     */
    public native void setPoint(float x, float y);

    /**
     * @js NA
     */
    public native boolean equals(@ByRef Vec2 target);

    /**
     * @returns if points have fuzzy equality which means equal with some degree of variance.
     * @js NA
     * @lua NA
     * @since v2.1.4
     */
    public native boolean fuzzyEquals(@ByRef Vec2 target, float variance);

    /**
     * Calculates distance between point an origin
     *
     * @return float
     *
     * @js NA
     * @lua NA
     * @since v2.1.4
     */
    public native float getLength();

    /**
     * Calculates the square length of a Vec2 (not calling sqrt() )
     *
     * @return float
     *
     * @js NA
     * @lua NA
     * @since v2.1.4
     */
    public native float getLengthSq();

    /**
     * Calculates the square distance between two points (not calling sqrt() )
     *
     * @return float
     *
     * @js NA
     * @lua NA
     * @since v2.1.4
     */
    public native float getDistanceSq(@ByRef Vec2 other);

    /**
     * Calculates the distance between two points
     *
     * @return float
     *
     * @js NA
     * @lua NA
     * @since v2.1.4
     */
    public native float getDistance(@ByRef Vec2 other);

    /**
     * @returns the angle in radians between this vector and the x axis
     * @js NA
     * @lua NA
     * @since v2.1.4
     */
    public native float getAngle();

    /**
     * @returns the angle in radians between two vector directions
     * @js NA
     * @lua NA
     * @since v2.1.4
     */
    public native float getAngle(@ByRef Vec2 other);

    /**
     * Calculates dot product of two points.
     *
     * @return float
     *
     * @js NA
     * @lua NA
     * @since v2.1.4
     */
    public native float dot(@ByRef Vec2 other);

    /**
     * Calculates cross product of two points.
     *
     * @return float
     *
     * @js NA
     * @lua NA
     * @since v2.1.4
     */
    public native float cross(@ByRef Vec2 other);

    /**
     * Calculates perpendicular of v, rotated 90 degrees counter-clockwise -- cross(v, perp(v)) >= 0
     *
     * @return Vec2
     *
     * @js NA
     * @lua NA
     * @since v2.1.4
     */
    @ByVal
    public native Vec2 getPerp();

    /**
     * Calculates midpoint between two points.
     *
     * @return Vec2
     *
     * @js NA
     * @lua NA
     * @since v3.0
     */
    @ByVal
    public native Vec2 getMidpoint(@ByRef Vec2 other);

    /**
     * Clamp a point between from and to.
     *
     * @js NA
     * @lua NA
     * @since v3.0
     */
    @ByVal
    public native Vec2 getClampPoint(@ByRef Vec2 min_inclusive, @ByRef Vec2 max_inclusive);

    /** Run a math operation function on each point component
     * absf, fllorf, ceilf, roundf
     * any function that has the signature: float func(float);
     * For example: let's try to take the floor of x,y
     * p.compOp(floorf);
     @since v3.0
      * @js NA
     * @lua NA
     */
//      public native Vec2 compOp(std::function<float(float)> function) ;

    /**
     * Calculates perpendicular of v, rotated 90 degrees clockwise -- cross(v, rperp(v)) <= 0
     *
     * @return Vec2
     *
     * @js NA
     * @lua NA
     * @since v2.1.4
     */
    @ByVal
    public native Vec2 getRPerp();

    /**
     * Calculates the projection of this over other.
     *
     * @return Vec2
     *
     * @js NA
     * @lua NA
     * @since v2.1.4
     */
    @ByVal
    public native Vec2 project(@ByRef Vec2 other);

    /**
     * Complex multiplication of two points ("rotates" two points).
     *
     * @return Vec2 vector with an angle of this.getAngle() + other.getAngle(),
     * and a length of this.getLength() * other.getLength().
     *
     * @js NA
     * @lua NA
     * @since v2.1.4
     */
    @ByVal
    public native Vec2 rotate(@ByRef Vec2 other);

    /**
     * Unrotates two points.
     *
     * @return Vec2 vector with an angle of this.getAngle() - other.getAngle(),
     * and a length of this.getLength() * other.getLength().
     *
     * @js NA
     * @lua NA
     * @since v2.1.4
     */
    @ByVal
    public native Vec2 unrotate(@ByRef Vec2 other);

    /**
     * Returns point multiplied to a length of 1.
     * If the point is 0, it returns (1, 0)
     *
     * @return Vec2
     *
     * @js NA
     * @lua NA
     * @since v2.1.4
     */
//    @ByVal
//    public native Vec2 normalize();

    /**
     * Linear Interpolation between two points a and b
     *
     * @returns alpha == 0 ? a
     * alpha == 1 ? b
     * otherwise a value between a..b
     * @js NA
     * @lua NA
     * @since v2.1.4
     */
    @ByVal
    public native Vec2 lerp(@ByRef Vec2 other, float alpha);

    /**
     * Rotates a point counter clockwise by the angle around a pivot
     *
     * @param pivot is the pivot, naturally
     * @param angle is the angle of rotation ccw in radians
     *
     * @returns the rotated point
     * @js NA
     * @lua NA
     * @since v2.1.4
     */
    @ByVal
    public native Vec2 rotateByAngle(@ByRef Vec2 pivot, float angle);

    /**
     * @js NA
     * @lua NA
     */
    @ByVal
    public native Vec2 forAngle(float a);

    /** A general line-line intersection test
     @param A   the startpoint for the first line L1 = (A - B)
     @param B   the endpoint for the first line L1 = (A - B)
     @param C   the startpoint for the second line L2 = (C - D)
     @param D   the endpoint for the second line L2 = (C - D)
     @param S   the range for a hitpoint in L1 (p = A + S*(B - A))
     @param T   the range for a hitpoint in L2 (p = C + T*(D - C))
     @returns whether these two lines interects.

     Note that to truly test intersection for segments we have to make
     sure that S & T lie within [0..1] and for rays, make sure S & T > 0
     the hit point is        C + T * (D - C);
     the hit point also is   A + S * (B - A);
     @since 3.0
      * @js NA
     * @lua NA
     */
//      public native  static boolean  isLineIntersect( Vec2 A,  Vec2 B,
//                                    Vec2 C,  Vec2 D,
//                                   float *S = nullptr, float *T = nullptr);

    /**
     * returns true if Line A-B overlap with segment C-D
     *
     * @js NA
     * @lua NA
     * @since v3.0
     */
    public native static boolean isLineOverlap(@ByRef Vec2 A, @ByRef Vec2 B,
                                               @ByRef Vec2 C, @ByRef Vec2 D);

    /**
     * returns true if Line A-B parallel with segment C-D
     *
     * @js NA
     * @lua NA
     * @since v3.0
     */
    public native static boolean isLineParallel(@ByRef Vec2 A, @ByRef Vec2 B,
                                                @ByRef Vec2 C, @ByRef Vec2 D);

    /**
     returns true if Segment A-B overlap with segment C-D
     @since v3.0
      * @js NA
     * @lua NA
     */
//      public native  static boolean  isSegmentOverlap( Vec2 A,  Vec2 B,
//                                    Vec2 C,  Vec2 D,
//                                   Vec2* S = nullptr, Vec2* E = nullptr);

    /**
     * returns true if Segment A-B intersects with segment C-D
     *
     * @js NA
     * @lua NA
     * @since v3.0
     */
    public native static boolean isSegmentIntersect(@ByRef Vec2 A, @ByRef Vec2 B, @ByRef Vec2 C, @ByRef Vec2 D);

    /**
     * returns the intersection point of line A-B, C-D
     *
     * @js NA
     * @lua NA
     * @since v3.0
     */
    @ByVal
    public native static Vec2 getIntersectPoint(@ByRef Vec2 A, @ByRef Vec2 B, @ByRef Vec2 C, @ByRef Vec2 D);


    public static Vec2[] createArray(float[][] values)
    {
        Vec2[] result = new Vec2[values.length];
        for (int i = 0; i < values.length; i++) {
            result[i] = new Vec2(values[i][0], values[i][1]);
        }
        return result;
    }

    /**
     * equals to Vec2(0,0)
     */
    public static final Vec2 ZERO = new Vec2(0, 0);
    /**
     * equals to Vec2(0.5, 0.5)
     */
    public static final Vec2 ANCHOR_MIDDLE = new Vec2(0.5f, 0.5f);
    /**
     * equals to Vec2(0, 0)
     */
    public static final Vec2 ANCHOR_BOTTOM_LEFT = new Vec2(0, 0);
    /**
     * equals to Vec2(0, 1)
     */
    public static final Vec2 ANCHOR_TOP_LEFT = new Vec2(0, 1);
    /**
     * equals to Vec2(1, 0)
     */
    public static final Vec2 ANCHOR_BOTTOM_RIGHT = new Vec2(1, 0);
    /**
     * equals to Vec2(1, 1)
     */
    public static final Vec2 ANCHOR_TOP_RIGHT = new Vec2(1, 1);
    /**
     * equals to Vec2(1, 0.5)
     */
    public static final Vec2 ANCHOR_MIDDLE_RIGHT = new Vec2(1, 0.5f);
    /**
     * equals to Vec2(0, 0.5)
     */
    public static final Vec2 ANCHOR_MIDDLE_LEFT = new Vec2(0, 0.5f);
    /**
     * equals to Vec2(0.5, 1)
     */
    public static final Vec2 ANCHOR_MIDDLE_TOP = new Vec2(0.5f, 1);
    /**
     * equals to Vec2(0.5, 0)
     */
    public static final Vec2 ANCHOR_MIDDLE_BOTTOM = new Vec2(0.5f, 0);

    public String toString()
    {
        return "{" + getX() + "," + getY() + "}";
    }
}
