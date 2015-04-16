package org.ccj.d3;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.Const;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import org.ccj.math.Mat4;
import org.ccj.math.Vec3;

/**
 * Created by yuanyou on 2014/12/24.
 */
@Platform(include = "CCOBB.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class OBB extends Pointer {

    public OBB(AABB aabb) {
        allocate(aabb);
    }

    protected native void allocate(@Const @ByRef AABB aabb);

    /*
    * Check point in
    */
    public native boolean containPoint(@ByRef Vec3 point);

    /*
     * Specify obb values
     */
    public native void set(@ByRef Vec3 center, @ByRef Vec3 _xAxis, @ByRef Vec3 _yAxis, @ByRef Vec3 _zAxis, @ByRef Vec3 _extents);

    /*
     * Clear obb
     */
    public native void reset();

    /* face to the obb's -z direction
     * verts[0] : left top front
     * verts[1] : left bottom front
     * verts[2] : right bottom front
     * verts[3] : right top front
     *
     * face to the obb's z direction
     * verts[4] : right top back
     * verts[5] : right bottom back
     * verts[6] : left bottom back
     * verts[7] : left top back
     */
    public native void getCorners(Vec3 verts);

    /*
     * Check intersect with other
     */
    public native boolean intersects(@ByRef OBB box);

    /**
     * Transforms the obb by the given transformation matrix.
     */
    public native void transform(@ByRef Mat4 mat);
}
