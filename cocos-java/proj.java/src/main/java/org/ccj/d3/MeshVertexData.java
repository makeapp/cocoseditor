package org.ccj.d3;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.*;

/**
 * Created by yuanyou on 2014/12/24.
 */

@Platform(include = "CCMeshVertexIndexData.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class MeshVertexData extends Pointer{
    /**create*/
//  public native  static MeshVertexData create(@ByRef MeshData meshdata);

    /** get vertexbuffer */
    @Const
//    public native VertexBuffer getVertexBuffer() ;

    /** get attributes count */
    public native  int getMeshVertexAttribCount();

    /** get attribute by index */
//    public native   MeshVertexAttrib getMeshVertexAttrib(ssize_t index) const { return _attribs[index]; }

    /** get index data count */
    public native   int getMeshIndexDataCount() ;
    /** get index data by index */
    public native  MeshIndexData getMeshIndexDataByIndex(int index) ;

    /** get index data by id */
//    public native MeshIndexData getMeshIndexDataById(@StdString String id) ;

    /**has vertex attribute?*/
//    public native boolean hasVertexAttrib(int attrib) ;
}
