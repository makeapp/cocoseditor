package org.ccj.renderer;

import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import com.googlecode.javacpp.annotation.StdString;
import org.ccj.base.Ref;
import org.ccj.d2.Texture2D;
import org.ccj.math.Mat4;
import org.ccj.math.Vec2;
import org.ccj.math.Vec3;
import org.ccj.math.Vec4;

/**
 * Created by yuanyou on 2014/12/24.
 */
@Platform(include = "CCGLProgramState.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class GLProgramState extends Ref {
    /** returns a new instance of GLProgramState for a given GLProgram */
   public native static GLProgramState create(GLProgram glprogram);

    /** gets-or-creates an instance of GLProgramState for a given GLProgram */
    public native static GLProgramState getOrCreateWithGLProgram(GLProgram glprogram);

    /** gets-or-creates an instance of GLProgramState for a given GLProgramName */
    public native static GLProgramState getOrCreateWithGLProgramName(@StdString String glProgramName );

    // apply GLProgram, attributes and uniforms
    public native  void apply(@ByRef Mat4 modelView);

    public native  void applyGLProgram(@ByRef Mat4 modelView);
    /**
     * apply vertex attributes
     * @param applyAttribFlags Call GL::enableVertexAttribs(_vertexAttribsFlags) or not
     */
    public native  void applyAttributes(boolean applyAttribFlags);
    public native   void applyUniforms();

    public native  void setGLProgram(GLProgram glprogram);
    public native  GLProgram getGLProgram() ;

    // vertex attribs
    public native   int getVertexAttribsFlags();
    public native   int getVertexAttribCount() ;
//    public native   void setVertexAttribCallback(@StdString String name, const std::function<void(VertexAttrib*)> &callback);
//    public native   void setVertexAttribPointer(@StdString String name, int size, long type, boolean normalized, GLsizei stride, GLvoid *pointer);

    // user defined uniforms
    public native   int getUniformCount() ;
    public native  void setUniformInt(@StdString String uniformName, int value);
    public native  void setUniformFloat(@StdString String uniformName, float value);
    public native  void setUniformVec2(@StdString String uniformName, @ByRef Vec2 value);
    public native  void setUniformVec3(@StdString String uniformName, @ByRef Vec3 value);
    public native  void setUniformVec4(@StdString String uniformName, @ByRef Vec4 value);
    public native  void setUniformMat4(@StdString String uniformName, @ByRef Mat4 value);
//    public native  void setUniformCallback(@StdString String uniformName, const std::function<void(GLProgram*, Uniform*)> &callback);
    public native  void setUniformTexture(@StdString String uniformName, Texture2D texture);
    public native  void setUniformTexture(@StdString String uniformName, short textureId);

    public native  void setUniformInt(int uniformLocation, int value);
    public native void setUniformFloat(int uniformLocation, float value);
    public native void setUniformVec2(int uniformLocation, @ByRef Vec2  value);
    public native void setUniformVec3(int uniformLocation, @ByRef Vec3 value);
    public native void setUniformVec4(int uniformLocation, @ByRef Vec4 value);
    public native void setUniformMat4(int uniformLocation, @ByRef Mat4 value);
//    public native void setUniformCallback(int uniformLocation, const std::function<void(GLProgram*, Uniform*)> &callback);
    public native void setUniformTexture(int uniformLocation, Texture2D texture);
    public native  void setUniformTexture(int uniformLocation, short textureId);

}
