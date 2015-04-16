package org.ccj.math;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.ByVal;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;

/**
 * Created by yuanyou on 2014/12/24.
 */
@Platform(include = "Mat4.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class Mat4 extends Pointer {

    /**
     * Creates a view matrix based on the specified input parameters.
     *
     * @param eyePosition The eye position.
     * @param targetPosition The target's center position.
     * @param up The up vector.
     * @param dst A matrix to store the result in.
     */
   public native static void createLookAt(@ByRef Vec3 eyePosition, @ByRef Vec3 targetPosition, @ByRef Vec3 up, Mat4 dst);

    /**
     * Creates a view matrix based on the specified input parameters.
     *
     * @param eyePositionX The eye x-coordinate position.
     * @param eyePositionY The eye y-coordinate position.
     * @param eyePositionZ The eye z-coordinate position.
     * @param targetCenterX The target's center x-coordinate position.
     * @param targetCenterY The target's center y-coordinate position.
     * @param targetCenterZ The target's center z-coordinate position.
     * @param upX The up vector x-coordinate value.
     * @param upY The up vector y-coordinate value.
     * @param upZ The up vector z-coordinate value.
     * @param dst A matrix to store the result in.
     */
    public native  static void createLookAt(float eyePositionX, float eyePositionY, float eyePositionZ,
                             float targetCenterX, float targetCenterY, float targetCenterZ,
                             float upX, float upY, float upZ, Mat4 dst);

    /**
     * Builds a perspective projection matrix based on a field of view and returns by value.
     *
     * Projection space refers to the space after applying projection transformation from view space.
     * After the projection transformation, visible content has x- and y-coordinates ranging from -1 to 1,
     * and a z-coordinate ranging from 0 to 1. To obtain the viewable area (in world space) of a scene,
     * create a BoundingFrustum and pass the combined view and projection matrix to the constructor.
     *
     * @param fieldOfView The field of view in the y direction (in degrees).
     * @param aspectRatio The aspect ratio, defined as view space width divided by height.
     * @param zNearPlane The distance to the near view plane.
     * @param zFarPlane The distance to the far view plane.
     * @param dst A matrix to store the result in.
     */
    public native  static void createPerspective(float fieldOfView, float aspectRatio, float zNearPlane, float zFarPlane, Mat4 dst);

    /**
     * Creates an orthographic projection matrix.
     *
     * @param width The width of the view.
     * @param height The height of the view.
     * @param zNearPlane The minimum z-value of the view volume.
     * @param zFarPlane The maximum z-value of the view volume.
     * @param dst A matrix to store the result in.
     */
    public native static void createOrthographic(float width, float height, float zNearPlane, float zFarPlane, Mat4 dst);

    /**
     * Creates an orthographic projection matrix.
     *
     * Projection space refers to the space after applying
     * projection transformation from view space. After the
     * projection transformation, visible content has
     * x and y coordinates ranging from -1 to 1, and z coordinates
     * ranging from 0 to 1.
     *
     * Unlike perspective projection, in orthographic projection
     * there is no perspective foreshortening.
     *
     * The viewable area of this orthographic projection extends
     * from left to right on the x-axis, bottom to top on the y-axis,
     * and zNearPlane to zFarPlane on the z-axis. These values are
     * relative to the position and x, y, and z-axes of the view.
     * To obtain the viewable area (in world space) of a scene,
     * create a BoundingFrustum and pass the combined view and
     * projection matrix to the constructor.
     *
     * @param left The minimum x-value of the view volume.
     * @param right The maximum x-value of the view volume.
     * @param bottom The minimum y-value of the view volume.
     * @param top The maximum y-value of the view volume.
     * @param zNearPlane The minimum z-value of the view volume.
     * @param zFarPlane The maximum z-value of the view volume.
     * @param dst A matrix to store the result in.
     */
    public native  static void createOrthographicOffCenter(float left, float right, float bottom, float top,
                                            float zNearPlane, float zFarPlane, Mat4 dst);

    /**
     * Creates a spherical billboard that rotates around a specified object position.
     *
     * This method computes the facing direction of the billboard from the object position
     * and camera position. When the object and camera positions are too close, the matrix
     * will not be accurate. To avoid this problem, this method defaults to the identity
     * rotation if the positions are too close. (See the other overload of createBillboard
     * for an alternative approach).
     *
     * @param objectPosition The position of the object the billboard will rotate around.
     * @param cameraPosition The position of the camera.
     * @param cameraUpVector The up vector of the camera.
     * @param dst A matrix to store the result in.
     */
    public native static void createBillboard(@ByRef Vec3 objectPosition, @ByRef Vec3 cameraPosition,
                                @ByRef Vec3 cameraUpVector, Mat4 dst);

    /**
     * Creates a spherical billboard that rotates around a specified object position with
     * provision for a safe default orientation.
     *
     * This method computes the facing direction of the billboard from the object position
     * and camera position. When the object and camera positions are too close, the matrix
     * will not be accurate. To avoid this problem, this method uses the specified camera
     * forward vector if the positions are too close. (See the other overload of createBillboard
     * for an alternative approach).
     *
     * @param objectPosition The position of the object the billboard will rotate around.
     * @param cameraPosition The position of the camera.
     * @param cameraUpVector The up vector of the camera.
     * @param cameraForwardVector The forward vector of the camera, used if the positions are too close.
     * @param dst A matrix to store the result in.
     */
    public native  static void createBillboard(@ByRef Vec3 objectPosition, @ByRef Vec3 cameraPosition,
                                @ByRef Vec3 cameraUpVector, @ByRef Vec3 cameraForwardVector,
                                Mat4 dst);

    /**
     * Fills in an existing Mat4 so that it reflects the coordinate system about a specified Plane.
     *
     * @param plane The Plane about which to create a reflection.
     * @param dst A matrix to store the result in.
     */
    //static void createReflection(const Plane& plane, Mat4* dst);

    /**
     * Creates a scale matrix.
     *
     * @param scale The amount to scale.
     * @param dst A matrix to store the result in.
     */
    public native static void createScale(@ByRef Vec3 scale, Mat4 dst);

    /**
     * Creates a scale matrix.
     *
     * @param xScale The amount to scale along the x-axis.
     * @param yScale The amount to scale along the y-axis.
     * @param zScale The amount to scale along the z-axis.
     * @param dst A matrix to store the result in.
     */
    public native  static void createScale(float xScale, float yScale, float zScale, Mat4 dst);

    /**
     * Creates a rotation matrix from the specified quaternion.
     *
     * @param quat A quaternion describing a 3D orientation.
     * @param dst A matrix to store the result in.
     */
//    public native static void createRotation(const Quaternion& quat, Mat4 dst);

    /**
     * Creates a rotation matrix from the specified axis and angle.
     *
     * @param axis A vector describing the axis to rotate about.
     * @param angle The angle (in radians).
     * @param dst A matrix to store the result in.
     */
    public native  static void createRotation(@ByRef Vec3 axis, float angle, Mat4 dst);

    /**
     * Creates a matrix describing a rotation around the x-axis.
     *
     * @param angle The angle of rotation (in radians).
     * @param dst A matrix to store the result in.
     */
    public native static void createRotationX(float angle, Mat4 dst);

    /**
     * Creates a matrix describing a rotation around the y-axis.
     *
     * @param angle The angle of rotation (in radians).
     * @param dst A matrix to store the result in.
     */
    public native static void createRotationY(float angle, Mat4 dst);

    /**
     * Creates a matrix describing a rotation around the z-axis.
     *
     * @param angle The angle of rotation (in radians).
     * @param dst A matrix to store the result in.
     */
    public native static void createRotationZ(float angle, Mat4 dst);

    /**
     * Creates a translation matrix.
     *
     * @param translation The translation.
     * @param dst A matrix to store the result in.
     */
    public native  static void createTranslation(@ByRef Vec3 translation, Mat4 dst);

    /**
     * Creates a translation matrix.
     *
     * @param xTranslation The translation on the x-axis.
     * @param yTranslation The translation on the y-axis.
     * @param zTranslation The translation on the z-axis.
     */
    public native static void createTranslation(float xTranslation, float yTranslation, float zTranslation, Mat4 dst);

    /**
     * Adds a scalar value to each component of this matrix.
     *
     * @param scalar The scalar to add.
     */
    public native  void add(float scalar);

    /**
     * Adds a scalar value to each component of this matrix and stores the result in dst.
     *
     * @param scalar The scalar value to add.
     * @param dst A matrix to store the result in.
     */
    public native void add(float scalar, Mat4 dst);

    /**
     * Adds the specified matrix to this matrix.
     *
     * @param mat The matrix to add.
     */
    public native void add(@ByRef Mat4 mat);

    /**
     * Adds the specified matrices and stores the result in dst.
     *
     * @param m1 The first matrix.
     * @param m2 The second matrix.
     * @param dst The destination matrix to add to.
     */
    public native  static void add(@ByRef Mat4 m1, @ByRef Mat4 m2, Mat4 dst);

    /**
     * Decomposes the scale, rotation and translation components of this matrix.
     *
     * @param scale The scale.
     * @param rotation The rotation.
     * @param translation The translation.
     */
//    public native boolean decompose(Vec3* scale, Quaternion* rotation, Vec3* translation) const;

    /**
     * Computes the determinant of this matrix.
     *
     * @return The determinant.
     */
    public native  float determinant() ;

    /**
     * Gets the scalar component of this matrix in the specified vector.
     *
     * If the scalar component of this matrix has negative parts,
     * it is not possible to always extract the exact scalar component;
     * instead, a scale vector that is mathematically equivalent to the
     * original scale vector is extracted and returned.
     *
     * @param scale A vector to receive the scale.
     */
    public native  void getScale(Vec3 scale) ;

    /**
     * Gets the rotational component of this matrix in the specified quaternion.
     *
     * @param rotation A quaternion to receive the rotation.
     *
     * @return true if the rotation is successfully extracted, false otherwise.
     */
//    public native  bool getRotation(Quaternion* rotation) ;

    /**
     * Gets the translational component of this matrix in the specified vector.
     *
     * @param translation A vector to receive the translation.
     */
    public native void getTranslation(Vec3 translation) ;

    /**
     * Gets the up vector of this matrix.
     *
     * @param dst The destination vector.
     */
    public native void getUpVector(Vec3 dst) ;

    /**
     * Gets the down vector of this matrix.
     *
     * @param dst The destination vector.
     */
    public native  void getDownVector(Vec3 dst) ;

    /**
     * Gets the left vector of this matrix.
     *
     * @param dst The destination vector.
     */
    public native  void getLeftVector(Vec3 dst) ;

    /**
     * Gets the right vector of this matrix.
     *
     * @param dst The destination vector.
     */
    public native  void getRightVector(Vec3 dst) ;

    /**
     * Gets the forward vector of this matrix.
     *
     * @param dst The destination vector.
     */
    public native  void getForwardVector(Vec3 dst) ;

    /**
     * Gets the backward vector of this matrix.
     *
     * @param dst The destination vector.
     */
    public native  void getBackVector(Vec3 dst) ;

    /**
     * Inverts this matrix.
     *
     * @return true if the the matrix can be inverted, false otherwise.
     */
    public native  boolean inverse();

    /**
     * Stores the inverse of this matrix in the specified matrix.
     *
     *
     * @return true if the the matrix can be inverted, false otherwise.
     */
    @ByVal
    public native Mat4 getInversed() ;

    /**
     * Determines if this matrix is equal to the identity matrix.
     *
     * @return true if the matrix is an identity matrix, false otherwise.
     */
    public native  boolean isIdentity() ;

    /**
     * Multiplies the components of this matrix by the specified scalar.
     *
     * @param scalar The scalar value.
     */
    public native void multiply(float scalar);

    /**
     * Multiplies the components of this matrix by a scalar and stores the result in dst.
     *
     * @param scalar The scalar value.
     * @param dst A matrix to store the result in.
     */
    public native  void multiply(float scalar, Mat4 dst) ;

    /**
     * Multiplies the components of the specified matrix by a scalar and stores the result in dst.
     *
     * @param mat The matrix.
     * @param scalar The scalar value.
     * @param dst A matrix to store the result in.
     */
    public native static void multiply(@ByRef Mat4 mat, float scalar, Mat4 dst);

    /**
     * Multiplies this matrix by the specified one.
     *
     * @param mat The matrix to multiply.
     */
    public native  void multiply(@ByRef Mat4 mat);

    /**
     * Multiplies m1 by m2 and stores the result in dst.
     *
     * @param m1 The first matrix to multiply.
     * @param m2 The second matrix to multiply.
     * @param dst A matrix to store the result in.
     */
    public native static void multiply(@ByRef Mat4 m1, @ByRef Mat4 m2, Mat4 dst);

    /**
     * Negates this matrix.
     */
    public native  void negate();

    /**
     * Negates this matrix and stores the result in dst.
     *
     */
    @ByVal
    public native   Mat4 getNegated() ;

    /**
     * Post-multiplies this matrix by the matrix corresponding to the
     * specified quaternion rotation.
     *
     * @param q The quaternion to rotate by.
     */
//    public native void rotate(const Quaternion& q);

    /**
     * Post-multiplies this matrix by the matrix corresponding to the
     * specified quaternion rotation and stores the result in dst.
     *
     * @param q The quaternion to rotate by.
     * @param dst A matrix to store the result in.
     */
//    public native  void rotate(const Quaternion& q, Mat4* dst) const;

    /**
     * Post-multiplies this matrix by the matrix corresponding to the
     * specified rotation about the specified axis.
     *
     * @param axis The axis to rotate about.
     * @param angle The angle (in radians).
     */
    public native  void rotate(@ByRef Vec3 axis, float angle);

    /**
     * Post-multiplies this matrix by the matrix corresponding to the specified
     * rotation about the specified axis and stores the result in dst.
     *
     * @param axis The axis to rotate about.
     * @param angle The angle (in radians).
     * @param dst A matrix to store the result in.
     */
    public native void rotate(@ByRef Vec3 axis, float angle, Mat4 dst) ;

    /**
     * Post-multiplies this matrix by the matrix corresponding to the
     * specified rotation around the x-axis.
     *
     * @param angle The angle (in radians).
     */
    public native void rotateX(float angle);

    /**
     * Post-multiplies this matrix by the matrix corresponding to the
     * specified rotation around the x-axis and stores the result in dst.
     *
     * @param angle The angle (in radians).
     * @param dst A matrix to store the result in.
     */
    public native void rotateX(float angle, Mat4 dst) ;

    /**
     * Post-multiplies this matrix by the matrix corresponding to the
     * specified rotation around the y-axis.
     *
     * @param angle The angle (in radians).
     */
    public native   void rotateY(float angle);

    /**
     * Post-multiplies this matrix by the matrix corresponding to the
     * specified rotation around the y-axis and stores the result in dst.
     *
     * @param angle The angle (in radians).
     * @param dst A matrix to store the result in.
     */
    public native void rotateY(float angle, Mat4 dst) ;

    /**
     * Post-multiplies this matrix by the matrix corresponding to the
     * specified rotation around the z-axis.
     *
     * @param angle The angle (in radians).
     */
    public native   void rotateZ(float angle);

    /**
     * Post-multiplies this matrix by the matrix corresponding to the
     * specified rotation around the z-axis and stores the result in dst.
     *
     * @param angle The angle (in radians).
     * @param dst A matrix to store the result in.
     */
    public native  void rotateZ(float angle, Mat4 dst) ;

    /**
     * Post-multiplies this matrix by the matrix corresponding to the
     * specified scale transformation.
     *
     * @param value The amount to scale along all axes.
     */
    public native  void scale(float value);

    /**
     * Post-multiplies this matrix by the matrix corresponding to the
     * specified scale transformation and stores the result in dst.
     *
     * @param value The amount to scale along all axes.
     * @param dst A matrix to store the result in.
     */
    public native  void scale(float value, Mat4 dst) ;

    /**
     * Post-multiplies this matrix by the matrix corresponding to the
     * specified scale transformation.
     *
     * @param xScale The amount to scale along the x-axis.
     * @param yScale The amount to scale along the y-axis.
     * @param zScale The amount to scale along the z-axis.
     */
    public native  void scale(float xScale, float yScale, float zScale);

    /**
     * Post-multiplies this matrix by the matrix corresponding to the
     * specified scale transformation and stores the result in dst.
     *
     * @param xScale The amount to scale along the x-axis.
     * @param yScale The amount to scale along the y-axis.
     * @param zScale The amount to scale along the z-axis.
     * @param dst A matrix to store the result in.
     */
    public native void scale(float xScale, float yScale, float zScale, Mat4 dst) ;

    /**
     * Post-multiplies this matrix by the matrix corresponding to the
     * specified scale transformation.
     *
     * @param s The scale values along the x, y and z axes.
     */
//    public native  void scale(@ByRef Vec3 s);

    /**
     * Post-multiplies this matrix by the matrix corresponding to the
     * specified scale transformation and stores the result in dst.
     *
     * @param s The scale values along the x, y and z axes.
     * @param dst A matrix to store the result in.
     */
    public native void scale(@ByRef Vec3 s, Mat4 dst) ;

    /**
     * Sets the values of this matrix.
     *
     * @param m11 The first element of the first row.
     * @param m12 The second element of the first row.
     * @param m13 The third element of the first row.
     * @param m14 The fourth element of the first row.
     * @param m21 The first element of the second row.
     * @param m22 The second element of the second row.
     * @param m23 The third element of the second row.
     * @param m24 The fourth element of the second row.
     * @param m31 The first element of the third row.
     * @param m32 The second element of the third row.
     * @param m33 The third element of the third row.
     * @param m34 The fourth element of the third row.
     * @param m41 The first element of the fourth row.
     * @param m42 The second element of the fourth row.
     * @param m43 The third element of the fourth row.
     * @param m44 The fourth element of the fourth row.
     */
    public native  void set(float m11, float m12, float m13, float m14, float m21, float m22, float m23, float m24,
             float m31, float m32, float m33, float m34, float m41, float m42, float m43, float m44);

    /**
     * Sets the values of this matrix to those in the specified column-major array.
     *
     * @param mat An array containing 16 elements in column-major format.
     */
    public native   void set( float[] mat);

    /**
     * Sets the values of this matrix to those of the specified matrix.
     *
     * @param mat The source matrix.
     */
    public native  void set(@ByRef Mat4 mat);

    /**
     * Sets this matrix to the identity matrix.
     */
    public native void setIdentity();

    /**
     * Sets all elements of the current matrix to zero.
     */
    public native void setZero();

    /**
     * Subtracts the specified matrix from the current matrix.
     *
     * @param mat The matrix to subtract.
     */
    public native  void subtract(@ByRef Mat4 mat);

    /**
     * Subtracts the specified matrix from the current matrix.
     *
     * @param m1 The first matrix.
     * @param m2 The second matrix.
     * @param dst A matrix to store the result in.
     */
    public native static void subtract(@ByRef Mat4 m1, @ByRef Mat4 m2, Mat4 dst);

    /**
     * Transforms the specified point by this matrix.
     *
     * The result of the transformation is stored directly into point.
     *
     * @param point The point to transform and also a vector to hold the result in.
     */
    public native void transformPoint(Vec3 point);

    /**
     * Transforms the specified point by this matrix, and stores
     * the result in dst.
     *
     * @param point The point to transform.
     * @param dst A vector to store the transformed point in.
     */
    public native void transformPoint(@ByRef Vec3 point, Vec3 dst) ;

    /**
     * Transforms the specified vector by this matrix by
     * treating the fourth (w) coordinate as zero.
     *
     * The result of the transformation is stored directly into vector.
     *
     * @param vector The vector to transform and also a vector to hold the result in.
     */
    public native void transformVector(Vec3 vector) ;

    /**
     * Transforms the specified vector by this matrix by
     * treating the fourth (w) coordinate as zero, and stores the
     * result in dst.
     *
     * @param vector The vector to transform.
     * @param dst A vector to store the transformed vector in.
     */
    public native void transformVector(@ByRef Vec3 vector, Vec3 dst) ;

    /**
     * Transforms the specified vector by this matrix.
     *
     * @param x The vector x-coordinate to transform by.
     * @param y The vector y-coordinate to transform by.
     * @param z The vector z-coordinate to transform by.
     * @param w The vector w-coordinate to transform by.
     * @param dst A vector to store the transformed point in.
     */
    public native void transformVector(float x, float y, float z, float w, Vec3 dst) ;

    /**
     * Transforms the specified vector by this matrix.
     *
     * The result of the transformation is stored directly into vector.
     *
     * @param vector The vector to transform.
     */
    public native void transformVector(Vec4 vector) ;

    /**
     * Transforms the specified vector by this matrix.
     *
     * @param vector The vector to transform.
     * @param dst A vector to store the transformed point in.
     */
    public native void transformVector(@ByRef Vec4 vector, Vec4 dst) ;

    /**
     * Post-multiplies this matrix by the matrix corresponding to the
     * specified translation.
     *
     * @param x The amount to translate along the x-axis.
     * @param y The amount to translate along the y-axis.
     * @param z The amount to translate along the z-axis.
     */
    public native void translate(float x, float y, float z);

    /**
     * Post-multiplies this matrix by the matrix corresponding to the
     * specified translation and stores the result in dst.
     *
     * @param x The amount to translate along the x-axis.
     * @param y The amount to translate along the y-axis.
     * @param z The amount to translate along the z-axis.
     * @param dst A matrix to store the result in.
     */
    public native void translate(float x, float y, float z, Mat4 dst) ;

    /**
     * Post-multiplies this matrix by the matrix corresponding to the
     * specified translation.
     *
     * @param t The translation values along the x, y and z axes.
     */
    public native void translate(@ByRef Vec3 t);

    /**
     * Post-multiplies this matrix by the matrix corresponding to the
     * specified translation and stores the result in dst.
     *
     * @param t The translation values along the x, y and z axes.
     * @param dst A matrix to store the result in.
     */
    public native void translate(@ByRef Vec3 t, Mat4 dst) ;

    /**
     * Transposes this matrix.
     */
    public native  void transpose();

    /**
     * Transposes this matrix and stores the result in dst.
     *
     */
    @ByVal
    public native  Mat4 getTransposed() ;

    /**
     * Calculates the sum of this matrix with the given matrix.
     *
     * Note: this does not modify this matrix.
     *
     * @param mat The matrix to add.
     * @return The matrix sum.
     */
//    public native const Mat4 operator+(@ByRef Mat4 mat) const;

    /**
     * Adds the given matrix to this matrix.
     *
     * @param mat The matrix to add.
     * @return This matrix, after the addition occurs.
     */
//    public native Mat4& operator+=(@ByRef Mat4 mat);

    /**
     * Calculates the difference of this matrix with the given matrix.
     *
     * Note: this does not modify this matrix.
     *
     * @param mat The matrix to subtract.
     * @return The matrix difference.
     */
//    public native const Mat4 operator-(@ByRef Mat4 mat) const;

    /**
     * Subtracts the given matrix from this matrix.
     *
     * @param mat The matrix to subtract.
     * @return This matrix, after the subtraction occurs.
     */
//    public native Mat4& operator-=(@ByRef Mat4 mat);

    /**
     * Calculates the negation of this matrix.
     *
     * Note: this does not modify this matrix.
     *
     * @return The negation of this matrix.
     */
//    public native const Mat4 operator-() const;

    /**
     * Calculates the matrix product of this matrix with the given matrix.
     *
     * Note: this does not modify this matrix.
     *
     * @param mat The matrix to multiply by.
     * @return The matrix product.
     */
//    public native const Mat4 operator*(@ByRef Mat4 mat) const;

    /**
     * Right-multiplies this matrix by the given matrix.
     *
     * @param mat The matrix to multiply by.
     * @return This matrix, after the multiplication occurs.
     */
//    public native Mat4& operator*=(@ByRef Mat4 mat);

}
