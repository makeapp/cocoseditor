package org.ccj.d3;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.*;
import org.ccj.math.Mat4;
import org.ccj.math.Vec4;

/**
 * Created by yuanyou on 2014/12/24.
 */

@Platform(include = "CCSkeleton3D.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class Bone3D extends Pointer{

    /**
     * Returns the inverse bind pose matrix for this joint.
     *
     * @return Inverse bind pose matrix.
     */
    @ByRef
    @Const
   public native Mat4 getInverseBindPose();

    /**update own world matrix and children's*/
    public native void updateWorldMat();

    /**get wrod matrix*/
    @ByRef
    @Const
    public native   Mat4 getWorldMat();

    /**get bone name*/
    public native @StdString String getName();

    /**
     * set animation value
     * @param trans translate vec3
     * @param rot   rotation quaternion
     * @param scale scale vec3
     * @param tag, unique tag, only blend animation between different tags
     * @param weight, blend weight
     */
    public native void setAnimationValue(float[] trans, float[] rot, float[] scale, int[] tag, float weight);

    /**clear bone blend states*/
    public native  void clearBoneBlendState();
    /**
     * Creates C3DBone.
     */
    public native  static Bone3D create(@StdString String id);

    /**
     * Sets the inverse bind pose matrix.
     *
     * @param m Mat4 representing the inverse bind pose for this Bone.
     */
    public native  void setInverseBindPose(@ByRef Mat4 m);

    /**
     * Sets the bone's original pose.
     *
     * @param m Mat4 representing the original pose for this Bone.
     */
    public native  void setOriPose(@ByRef Mat4 m);

    /**
     * reset pose to origin
     */
    public native  void resetPose();

    /**
     * Updates the joint matrix.
     *
     * @param matrixPalette The matrix palette to update.
     */
    public native  void updateJointMatrix(Vec4 matrixPalette);

    /**bone tree, we do not inherit from Node, Node has too many properties that we do not need. A clean Node is needed.*/
    public native Bone3D getParentBone();
    /**get child bone count*/
    public native int getChildBoneCount() ;
    /**get child bone by index*/
    public native  Bone3D getChildBoneByIndex(int index) ;
    /**add child bone*/
    public native  void addChildBone(Bone3D bone);
    /**remove child bone by index*/
    public native  void removeChildBoneByIndex(int index);
    /**remove child bone*/
    public native void removeChildBone(Bone3D bone);
    /**remove all child bone*/
    public native void removeAllChildBone();

}
