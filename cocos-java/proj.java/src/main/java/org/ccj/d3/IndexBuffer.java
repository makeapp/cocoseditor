package org.ccj.d3;

import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import org.ccj.base.Ref;

/**
 * Created by yuanyou on 2014/12/24.
 */

@Platform(include = "CCVertexIndexBuffer.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class IndexBuffer extends Ref {

    public static int INDEX_TYPE_SHORT_16 = 0,
            INDEX_TYPE_UINT_32 = 1;

    public native static IndexBuffer create(@Cast("cocos2d::IndexBuffer::IndexType") int type, int number);

    @Cast("int")
    public native int getType();

    public native int getSizePerIndex();

    public native int getIndexNumber();
//    public native  boolean updateIndices(const void* indices, int count, int begin);

    public native int getSize();

    public native long getVBO();
}
