package org.ccj.renderer;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;

/**
 * Created by yuanyou on 2014/12/24.
 */

@Platform(include = "CCGLProgramState.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class VertexAttribValue extends Pointer {
//  public native  void setPointer(int size, long type, boolean normalized, GLsizei stride, GLvoid *pointer);
//    public native  void setCallback(const std::function<void(VertexAttrib*)> &callback);
    public native  void apply();
}
