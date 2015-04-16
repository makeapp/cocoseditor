/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.math;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.ByVal;
import com.googlecode.javacpp.annotation.Name;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-3-3 上午10:30 $
 *          $Id$
 */
@Platform(include = "Vec3.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class Vec4 extends Pointer
{
    /**
     * Constructs a new vector initialized to all zeros.
     */
    public Vec4()
    {
        allocate();
    }

    public native void allocate();


    /**
     * Constructs a new vector initialized to the specified values.
     *
     * @param xx The x coordinate.
     * @param yy The y coordinate.
     * @param zz The z coordinate.
     * @param ww The w coordinate.
     */
    public Vec4(float xx, float yy, float zz, float ww)
    {
        allocate(xx, yy, zz, ww);
    }

    public native void allocate(float xx, float yy, float zz, float ww);


    /**
     * Constructs a new vector from the values in the specified array.
     *
     * @param array An array containing the elements of the vector in the order x, y, z, w.
     */
    public Vec4(float[] array)
    {
        allocate(array);
    }

    public native void allocate(float[] array);

    /**
     * Constructs a vector that describes the direction between the specified points.
     *
     * @param p1 The first point.
     * @param p2 The second point.
     */
    public Vec4(@ByRef Vec4 p1, @ByRef Vec4 p2)
    {
        allocate(p1, p2);
    }

    public native void allocate(@ByRef Vec4 p1, @ByRef Vec4 p2);

    /**
     * Constructor.
     * <p/>
     * Creates a new vector that is a copy of the specified vector.
     *
     * @param copy The vector to copy.
     */
    public Vec4(@ByRef Vec4 copy)
    {
        allocate(copy);
    }

    public native void allocate(@ByRef Vec4 copy);

    /**
     * Creates a new vector from an integer interpreted as an RGBA value.
     * E.g. 0xff0000ff represents opaque red or the vector (1, 0, 0, 1).
     *
     * @param color The integer to interpret as an RGBA value.
     *
     * @return A vector corresponding to the interpreted RGBA color.
     */
    @ByVal
    public native static Vec4 fromColor(int color);


    /**
     * Indicates whether this vector contains all zeros.
     *
     * @return true if this vector contains all zeros, false otherwise.
     */
    public native boolean isZero();

    /**
     * Indicates whether this vector contains all ones.
     *
     * @return true if this vector contains all ones, false otherwise.
     */
    public native boolean isOne();

    /**
     * Returns the angle (in radians) between the specified vectors.
     *
     * @param v1 The first vector.
     * @param v2 The second vector.
     *
     * @return The angle between the two vectors (in radians).
     */
    public native static float angle(@ByRef Vec4 v1, @ByRef Vec4 v2);

    /**
     * Adds the elements of the specified vector to this one.
     *
     * @param v The vector to add.
     */
    public native void add(@ByRef Vec4 v);

    /**
     * Adds the specified vectors and stores the result in dst.
     *
     * @param v1 The first vector.
     * @param v2 The second vector.
     * @param dst A vector to store the result in.
     */
//        public native  static void add(@ByRef Vec4& v1, @ByRef Vec4& v2, Vec4* dst);

    /**
     * Clamps this vector within the specified range.
     *
     * @param min The minimum value.
     * @param max The maximum value.
     */
    public native void clamp(@ByRef Vec4 min, @ByRef Vec4 max);

    /**
     * Clamps the specified vector within the specified range and returns it in dst.
     *
     * @param v The vector to clamp.
     * @param min The minimum value.
     * @param max The maximum value.
     * @param dst A vector to store the result in.
     */
//        public native  static void clamp(const Vec4& v, const Vec4& min, const Vec4& max, Vec4* dst);

    /**
     * Returns the distance between this vector and v.
     *
     * @param v The other vector.
     *
     * @return The distance between this vector and v.
     */
    public native float distance(@ByRef Vec4 v);

    /**
     * Returns the squared distance between this vector and v.
     * <p/>
     * When it is not necessary to get the exact distance between
     * two vectors (for example, when simply comparing the
     * distance between different vectors), it is advised to use
     * this method instead of distance.
     *
     * @param v The other vector.
     *
     * @return The squared distance between this vector and v.
     */
    public native float distanceSquared(@ByRef Vec4 v);

    /**
     * Returns the dot product of this vector and the specified vector.
     *
     * @param v The vector to compute the dot product with.
     *
     * @return The dot product.
     */
    public native float dot(@ByRef Vec4 v);

    /**
     * Returns the dot product between the specified vectors.
     *
     * @param v1 The first vector.
     * @param v2 The second vector.
     *
     * @return The dot product between the vectors.
     */
    public native static float dot(@ByRef Vec4 v1, @ByRef Vec4 v2);

    /**
     * Computes the length of this vector.
     *
     * @return The length of the vector.
     */
    public native float length();

    /**
     * Returns the squared length of this vector.
     * <p/>
     * When it is not necessary to get the exact length of a
     * vector (for example, when simply comparing the lengths of
     * different vectors), it is advised to use this method
     * instead of length.
     *
     * @return The squared length of the vector.
     */
    public native float lengthSquared();

    /**
     * Negates this vector.
     */
    public native void negate();

    /**
     * Normalizes this vector.
     * <p/>
     * This method normalizes this Vec4 so that it is of
     * unit length (in other words, the length of the vector
     * after calling this method will be 1.0f). If the vector
     * already has unit length or if the length of the vector
     * is zero, this method does nothing.
     *
     * @return This vector, after the normalization occurs.
     */
    public native void normalize();

    /**
     * Normalizes this vector and stores the result in dst.
     * <p/>
     * If the vector already has unit length or if the length
     * of the vector is zero, this method simply copies the
     * current vector into dst.
     */
    @ByVal
    public native Vec4 getNormalized();

    /**
     * Scales all elements of this vector by the specified value.
     *
     * @param scalar The scalar value.
     */
    public native void scale(float scalar);

    /**
     * Sets the elements of this vector to the specified values.
     *
     * @param xx The new x coordinate.
     * @param yy The new y coordinate.
     * @param zz The new z coordinate.
     * @param ww The new w coordinate.
     */
    public native void set(float xx, float yy, float zz, float ww);

    /**
     * Sets the elements of this vector from the values in the specified array.
     *
     * @param array An array containing the elements of the vector in the order x, y, z, w.
     */
    public native void set(float[] array);

    /**
     * Sets the elements of this vector to those in the specified vector.
     *
     * @param v The vector to copy.
     */
    public native void set(@ByRef Vec4 v);

    /**
     * Sets this vector to the directional vector between the specified points.
     *
     * @param p1 The first point.
     * @param p2 The second point.
     */
    public native void set(@ByRef Vec4 p1, @ByRef Vec4 p2);

    /**
     * Subtracts this vector and the specified vector as (this - v)
     * and stores the result in this vector.
     *
     * @param v The vector to subtract.
     */
    public native void subtract(@ByRef Vec4 v);

    /**
     * Subtracts the specified vectors and stores the result in dst.
     * The resulting vector is computed as (v1 - v2).
     *
     * @param v1 The first vector.
     * @param v2 The second vector.
     * @param dst The destination vector.
     */
//        public native   static void subtract(@ByRef Vec4 v1, @ByRef Vec4 v2, Vec4* dst);

    /**
     * Calculates the sum of this vector with the given vector.
     * <p/>
     * Note: this does not modify this vector.
     *
     * @param v The vector to add.
     *
     * @return The vector sum.
     */
    @ByVal
    @Name("operator+")
    public native Vec4 plus(@ByRef Vec4 v);

    /**
     * Adds the given vector to this vector.
     *
     * @param v The vector to add.
     *
     * @return This vector, after the addition occurs.
     */
    @Name("operator+=")
    @ByVal
    public native Vec4 plusEquals(@ByRef Vec4 v);

    /**
     * Calculates the sum of this vector with the given vector.
     * <p/>
     * Note: this does not modify this vector.
     *
     * @param v The vector to add.
     *
     * @return The vector sum.
     */
    @ByVal
    @Name("operator-")
    public native Vec4 minus(@ByRef Vec4 v);

    /**
     * Subtracts the given vector from this vector.
     *
     * @param v The vector to subtract.
     *
     * @return This vector, after the subtraction occurs.
     */
    @Name("operator-=")
    @ByVal
    public native Vec4 minusEquals(@ByVal Vec4 v);

    /**
     * Calculates the negation of this vector.
     * <p/>
     * Note: this does not modify this vector.
     *
     * @return The negation of this vector.
     */
    @ByVal
    @Name("operator-")
    public native Vec4 minus();

    /**
     * Calculates the scalar product of this vector with the given value.
     * <p/>
     * Note: this does not modify this vector.
     *
     * @param s The value to scale by.
     *
     * @return The scaled vector.
     */
    @ByVal
    @Name("operator*")
    public native Vec4 multiply(float s);

    /**
     * Scales this vector by the given value.
     *
     * @param s The value to scale by.
     *
     * @return This vector, after the scale occurs.
     */
    @ByVal
    @Name("operator*=")
    public native Vec4 multiplyEquals(float s);

    /**
     * Returns the components of this vector divided by the given constant
     * <p/>
     * Note: this does not modify this vector.
     *
     * @param s the constant to divide this vector with
     *
     * @return a smaller vector
     */
    @ByVal
    @Name("operator/")
    public native Vec4 divide(float s);

    /**
     * Determines if this vector is less than the given vector.
     *
     * @param v The vector to compare against.
     *
     * @return True if this vector is less than the given vector, false otherwise.
     */
    @Name("operator<")
    public native boolean lessThan(@ByRef Vec4 v);

    /**
     * Determines if this vector is equal to the given vector.
     *
     * @param v The vector to compare against.
     *
     * @return True if this vector is equal to the given vector, false otherwise.
     */
    @Name("operator==")
    public native boolean equals(@ByRef Vec4 v);

    /**
     * Determines if this vector is not equal to the given vector.
     *
     * @param v The vector to compare against.
     *
     * @return True if this vector is not equal to the given vector, false otherwise.
     */
    @Name("operator!=")
    public native boolean notEquals(@ByRef Vec4 v);

    /**
     * equals to Vec4(0,0,0,0)
     */
    static Vec4 ZERO = new Vec4(0, 0, 0, 0);
    /**
     * equals to Vec4(1,1,1,1)
     */
    static Vec4 ONE = new Vec4(1, 1, 1, 1);
    /**
     * equals to Vec4(1,0,0,0)
     */
    static Vec4 UNIT_X = new Vec4(1, 0, 0, 0);
    /**
     * equals to Vec4(0,1,0,0)
     */
    static Vec4 UNIT_Y = new Vec4(0, 1, 0, 0);
    /**
     * equals to Vec4(0,0,1,0)
     */
    static Vec4 UNIT_Z = new Vec4(0, 0, 1, 0);
    /**
     * equals to Vec4(0,0,0,1)
     */
    static Vec4 UNIT_W = new Vec4(0, 0, 0, 1);
}
