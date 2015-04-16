package org.ccj.d3;

import com.googlecode.javacpp.annotation.*;
import org.ccj.base.Ref;
import org.ccj.base.VectorFloat;
import org.ccj.d2.Texture2D;
import org.ccj.renderer.GLProgramState;

/**
 * Created by yuanyou on 2014/12/24.
 */

@Platform(include = "CCMesh.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class Mesh extends Ref {
    /**create mesh from positions, normals, and so on, sigle SubMesh*/
//  public native  static Mesh create(@ByRef VectorFloat positions, @ByRef VectorFloat normals, @ByRef VectorFloat texs, const IndexArray& indices);
    /**create mesh with vertex attributes*/
//    CC_DEPRECATED_ATTRIBUTE static Mesh* create(const std::vector<float>& vertices, int perVertexSizeInFloat, const IndexArray& indices, int numIndex, const std::vector<MeshVertexAttrib>& attribs, int attribCount){ return create(vertices, perVertexSizeInFloat, indices, attribs); }

//    public native   static Mesh create(@ByRef VectorFloat vertices, int perVertexSizeInFloat, const IndexArray& indices, const std::vector<MeshVertexAttrib>& attribs);


    /** create mesh */
    public native    static Mesh create(@StdString String name, MeshIndexData indexData, MeshSkin skin);

    /**get vertex buffer*/
    public native   short getVertexBuffer() ;
    /**has vertex attribute?*/
    public native  boolean hasVertexAttrib(int attrib) ;
    /**get mesh vertex attribute count*/
    public native  int getMeshVertexAttribCount() ;
    /**get MeshVertexAttribute by index*/
//    public native  MeshVertexAttrib getMeshVertexAttribute(int idx);
    /**get per vertex size in bytes*/
    public native int getVertexSizeInBytes() ;

    /**texture getter and setter*/
    public native void setTexture(@StdString String texPath);
    public native void setTexture(Texture2D tex);
    public native Texture2D getTexture();

    /**visible getter and setter*/
    public native void setVisible(boolean visible);
    public native boolean isVisible() ;

    /**skin getter */
    public native MeshSkin getSkin();

    /**mesh index data getter */
    public native MeshIndexData getMeshIndexData();
    /**get GLProgramState*/
    public native GLProgramState getGLProgramState();

    /**name getter */
    @StdString public native String getName() ;

//    public native  void setBlendFunc(const BlendFunc &blendFunc);
//    public native const BlendFunc &getBlendFunc() const;

    /** get primitive type*/
    public native  long getPrimitiveType() ;
    /**get index count*/
    public native int getIndexCount() ;
    /**get index format*/
    public native long getIndexFormat() ;
    /**get index buffer*/
    public native long getIndexBuffer() ;

    /**get AABB*/
    @ByRef
    @Const
    public native   AABB getAABB() ;
}
