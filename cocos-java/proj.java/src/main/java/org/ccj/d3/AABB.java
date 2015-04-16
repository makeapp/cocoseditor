package org.ccj.d3;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.ByVal;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import org.ccj.math.Mat4;
import org.ccj.math.Vec3;

/**
 * Created by yuanyou on 2014/12/24.
 */

@Platform(include = "CCAABB.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class AABB extends Pointer {

    /**
     * Gets the center point of the bounding box.
     */
    @ByVal
    public native Vec3 getCenter();

    /* Near face, specified counter-clockwise looking towards the origin from the positive z-axis.
     * verts[0] : left top front
     * verts[1] : left bottom front
     * verts[2] : right bottom front
     * verts[3] : right top front
     *
     * Far face, specified counter-clockwise looking towards the origin from the negative z-axis.
     * verts[4] : right top back
     * verts[5] : right bottom back
     * verts[6] : left bottom back
     * verts[7] : left top back
     */
    public native void getCorners(Vec3 dst);

    /**
     * Tests whether this bounding box intersects the specified bounding object.
     */
    public native boolean intersects(@ByRef AABB aabb);

    /**
     * check whether the point is in.
     */
    public native boolean containPoint(@ByRef Vec3 point);

    /**
     * Sets this bounding box to the smallest bounding box
     * that contains both this bounding object and the specified bounding box.
     */
    public native void merge(@ByRef AABB box);

    /**
     * Sets this bounding box to the specified values.
     */
    public native void set(@ByRef Vec3 min, @ByRef Vec3 max);

    /**
     * reset min and max value.
     */
    public native void reset();

    public native boolean isEmpty();

    /**
     * update the _min and _max from the given point.
     */
    public native void updateMinMax(Vec3 point, int num);

    /**
     * Transforms the bounding box by the given transformation matrix.
     */
    public native void transform(@ByRef Mat4 mat);
}
