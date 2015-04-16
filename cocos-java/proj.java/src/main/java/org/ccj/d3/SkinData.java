package org.ccj.d3;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import com.googlecode.javacpp.annotation.StdString;

/**
 * Created by yuanyou on 2014/12/24.
 */

@Platform(include = "CCBundle3dData.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class SkinData extends Pointer {

    public native void resetData();

    public native void addSkinBoneNames(@StdString String name);

    public native void addNodeBoneNames(@StdString String name);

    public native int getSkinBoneNameIndex(@StdString String name);

    public native int getBoneNameIndex(@StdString String name);
}
