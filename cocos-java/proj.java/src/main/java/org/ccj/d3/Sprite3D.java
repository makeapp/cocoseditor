/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.d3;

import com.googlecode.javacpp.annotation.*;
import org.ccj.base.VectorMesh;
import org.ccj.d2.Node;
import org.ccj.d2.Texture2D;
import org.ccj.math.Rect;
import org.ccj.renderer.GLProgram;
import org.ccj.renderer.GLProgramState;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-2-28 上午11:39 $
 *          $Id$
 */

@Platform(include = "CCSprite3d.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class Sprite3D
        extends Node {

    public Sprite3D(@StdString String modelPath, @StdString String texturePath) {
        allocate(modelPath,texturePath);
    }

    public Sprite3D(@StdString String modelPath) {
        allocate(modelPath);
    }

    @Allocator
    @NoDeallocator
    @Name("cocos2d::Sprite3D::create")
    protected native  void allocate(@StdString String modelPath, @StdString String texturePath);

    @Allocator
    @NoDeallocator
    @Name("cocos2d::Sprite3D::create")
    protected native  void allocate(@StdString String modelPath);

    public native static Sprite3D create(@StdString String modelPath, @StdString String texturePath);

    public native static Sprite3D create(@StdString String modelPath);

    //set texture
    public native void setTexture(@StdString String texFile);

    public native void setTexture(Texture2D texture);

    /**get Mesh by index*/
     public native Mesh getMeshByIndex(int index) ;

    /**get Mesh by Name, it returns the first one if there are more than one mesh with the same name */
    public native  Mesh getMeshByName(@StdString String name) ;

    /** get mesh array by name, returns all meshes with the given name */
    @ByRef
    public native VectorMesh getMeshArrayByName(@StdString String name) ;

    /**get mesh*/
    public native Mesh getMesh();

    /** get mesh count */
    public native  int getMeshCount();

    /**get skin*/
//    CC_DEPRECATED_ATTRIBUTE MeshSkin* getSkin() const;

    public native Skeleton3D getSkeleton() ;

    /**get AttachNode by bone name, return nullptr if not exist*/
    public native  AttachNode getAttachNode(@StdString String boneName);

    /**remove attach node*/
    public native void removeAttachNode(@StdString String boneName);

    /**remove all attach nodes*/
    public native void removeAllAttachNode();

    // overrides
//    virtual void setBlendFunc(const BlendFunc &blendFunc) override;
//    virtual const BlendFunc &getBlendFunc() const override;

    // overrides
    /** set GLProgramState, you should bind attributes by yourself */
//    public native void setGLProgramState(GLProgramState glProgramState) ;
    /** just rember bind attributes */
//    public native void setGLProgram(GLProgram glprogram) ;

    /*
     * Get AABB
     * If the sprite has animation, it can't be calculated accuratly,
     * because bone can drive the vertices, we just use the origin vertices
     * to calculate the AABB.
     */
    @ByRef @Const
    public native AABB getAABB() ;

    /**
     * Returns 2d bounding-box
     * Note: the bouding-box is just get from the AABB which as Z=0, so that is not very accurate.
     */
    @ByVal @Const
    public native  Rect getBoundingBox() ;

    // set which face is going to cull, GL_BACK, GL_FRONT, GL_FRONT_AND_BACK, default GL_BACK
    public native  void setCullFace(long cullFace);
    // set cull face enable or not
    public native void setCullFaceEnabled(boolean enable);

    /** light mask getter & setter, light works only when _lightmask & light's flag is true, default value of _lightmask is 0xffff */
    public native void setLightMask( int mask) ;
    public native  int getLightMask();
}
