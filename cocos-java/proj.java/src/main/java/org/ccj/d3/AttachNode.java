package org.ccj.d3;

import com.googlecode.javacpp.annotation.ByVal;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import org.ccj.d2.Node;
import org.ccj.math.Mat4;

/**
 * Created by yuanyou on 2014/12/24.
 */

@Platform(include = "CCAttachNode.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class AttachNode extends Node {
    /**
     * creates an AttachNode
     * @param attachBone The bone to which the AttachNode is going to attach, the attacheBone must be a bone of the AttachNode's parent
     */
    public native static AttachNode create(Bone3D attachBone);

    @ByVal
    public native Mat4 getWorldToNodeTransform() ;
//    public native void visit(Renderer *renderer, const Mat4& parentTransform, uint32_t parentFlags) override;

}
