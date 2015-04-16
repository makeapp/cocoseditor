package org.ccj.d3;

import com.googlecode.javacpp.annotation.*;
import org.ccj.base.Ref;

/**
 * Created by yuanyou on 2014/12/24.
 */
@Platform(include = "CCMeshVertexIndexData.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class MeshIndexData extends Ref {
    /** create  */
//   public native static MeshIndexData create(@StdString String id, MeshVertexData vertexData, IndexBuffer indexbuffer, @ByRef AABB aabb);

    /**get index buffer*/
    @Const
    public native  IndexBuffer getIndexBuffer()  ;
    /**get vertex buffer*/
//    @Const
//    public native  VertexBuffer getVertexBuffer()  ;

    /**get vertex data*/
    @Const
    public native  MeshVertexData getMeshVertexData()  ;

    /** aabb getter and setter */
    public native void setAABB(@ByRef AABB aabb)  ;

    @ByRef
    @Const
    public native  AABB getAABB() ;

    /** id setter and getter */
    public native void setId(@StdString String id)  ;
    public native @StdString String getId()  ;

    /**primitive type setter & getter*/
    public native long getPrimitiveType();
    public native  void   setPrimitiveType(long primitive) ;

}
