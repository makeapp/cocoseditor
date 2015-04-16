package org.ccj.d3;

import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import com.googlecode.javacpp.annotation.StdString;
import org.ccj.base.Ref;
import org.ccj.base.VectorMat4;
import org.ccj.base.VectorString;
import org.ccj.math.Vec4;

/**
 * Created by yuanyou on 2014/12/24.
 */
@Platform(include = "CCMeshSkin.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class MeshSkin extends Ref {
    /**
     * create a new meshskin if do not want to share meshskin
     */
//    public native static MeshSkin create(Skeleton3D skeleton, @StdString String filename, @StdString String name);

//    public native static MeshSkin create(Skeleton3D skeleton, @ByRef VectorString boneNames, @ByRef VectorMat4 invBindPose);

    /**
     * get total bone count, skin bone + node bone
     */
    public native int getBoneCount();

    /**
     * get bone
     */
    public native Bone3D getBoneByIndex(int index);

    public native Bone3D getBoneByName(@StdString String id);

    /**
     * get bone index
     */
    public native int getBoneIndex(Bone3D bone);

    /**
     * compute matrix palette used by gpu skin
     */
    public native Vec4 getMatrixPalette();

    /**
     * getSkinBoneCount() * 3
     */
    public native int getMatrixPaletteSize();

    /**
     * get root bone of the skin
     */
    public native Bone3D getRootBone();
}
