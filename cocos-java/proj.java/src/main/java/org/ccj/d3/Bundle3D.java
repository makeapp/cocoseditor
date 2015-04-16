package org.ccj.d3;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.*;
import org.ccj.base.VectorFloat;
import org.ccj.base.VectorInt;

/**
 * Created by yuanyou on 2014/12/24.
 */

@Platform(include = "CCBundle3D.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class Bundle3D extends Pointer {
    /**
     * you can define yourself bundle and set it, use default bundle otherwise
     */
//    public native static void setBundleInstance(Bundle3D bundleInstance);

    public native static Bundle3D createBundle();

    public static native void destroyBundle(Bundle3D bundle);

    public native void clear();

    /**
     * load a file. You must load a file first, then call loadMeshData, loadSkinData, and so on
     *
     * @param path File to be loaded
     * @return result of load
     */
    public native boolean load(@StdString String path);

    /**
     * load skin data from bundle
     *
     * @param id The ID of the skin, load the first Skin in the bundle if it is empty
     */
    public native boolean loadSkinData(@StdString String id, SkinData skindata);

    /**
     * load material data from bundle
     *
     * @param id The ID of the animation, load the first animation in the bundle if it is empty
     */
    public native boolean loadAnimationData(@StdString String id, Animation3DData animationdata);

    //since 3.3, to support reskin
    public native boolean loadMeshDatas(@ByRef MeshDatas meshdatas);

    //since 3.3, to support reskin
    public native boolean loadNodes(@ByRef NodeDatas nodedatas);

    //since 3.3, to support reskin
    public native boolean loadMaterials(@ByRef MaterialDatas materialdatas);

    //load .obj file
    public native static boolean loadObj(@ByRef MeshDatas meshdatas, @ByRef MaterialDatas materialdatas, @ByRef NodeDatas nodedatas, @StdString String fullPath, String mtl_basepath);

    //calculate aabb
//    @ByRef
//    public native static AABB calculateAABB(@ByRef VectorFloat vertex, int stride, @ByRef VectorInt index);


}
