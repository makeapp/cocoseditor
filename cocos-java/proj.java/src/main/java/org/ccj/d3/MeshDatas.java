package org.ccj.d3;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;

/**
 * Created by yuanyou on 2014/12/24.
 */
@Platform(include = "CCBundle3dData.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class MeshDatas extends Pointer {
    public native void resetData();
}
