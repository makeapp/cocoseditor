package org.ccj.d3;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import com.googlecode.javacpp.annotation.StdString;
import org.ccj.base.VectorNodeData;

/**
 * Created by yuanyou on 2014/12/24.
 */

@Platform(include = "CCSkeleton3D.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class Skeleton3D extends Pointer{

    public native static Skeleton3D create(@ByRef VectorNodeData skeletondata);

    /**
     * get total bone count
     */
    public native int getBoneCount();

    /**
     * get bone
     */
    public native Bone3D getBoneByIndex(int index);

    public native Bone3D getBoneByName(@StdString String id);

    /**
     * get & set root bone
     */
    public native int getRootCount();

    public native Bone3D getRootBone(int index);

    /**
     * get bone index
     */
    public native int getBoneIndex(Bone3D bone);

    /**
     * refresh bone world matrix
     */
    public native void updateBoneMatrix();
}
