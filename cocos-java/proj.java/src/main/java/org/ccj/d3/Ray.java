package org.ccj.d3;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import org.ccj.math.Mat4;
import org.ccj.math.Vec3;

/**
 * Created by yuanyou on 2014/12/24.
 */

@Platform(include = "CCRay.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class Ray extends Pointer {
    /**
     * Check whether this ray intersects the specified bounding box.
     */
  public native  boolean intersects(@ByRef AABB aabb) ;

    /**
     * Check whether this ray intersects the specified obb.
     */
    public native  boolean intersects(@ByRef OBB obb) ;

    /**
     * Sets this ray to the specified values.
     *
     * @param origin The ray's origin.
     * @param direction The ray's direction.
     */
    public native void set(@ByRef Vec3 origin, @ByRef Vec3 direction);

    /**
     * Transforms this ray by the given transformation matrix.
     *
     * @param matrix The transformation matrix to transform by.
     */
    public native void transform(@ByRef Mat4 matrix);

//    Vec3 _origin;        // The ray origin position.
//    Vec3 _direction;     // The ray direction vector.
}
