package org.ccj.renderer;

import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import com.googlecode.javacpp.annotation.StdString;
import org.ccj.base.Ref;

/**
 * Created by yuanyou on 2014/12/24.
 */

@Platform(include = "CCGLProgram.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class GLProgram extends Ref {
    /**
     * Initializes the GLProgram with a vertex and fragment with bytes array
     *
     * @js initWithString
     * @lua initWithString
     */
    //public native static GLProgram createWithByteArrays(char[] vShaderByteArray, char[] fShaderByteArray);

    //public native boolean initWithByteArrays(char[] vShaderByteArray, char[] fShaderByteArray);

    /**
     * Initializes the GLProgram with a vertex and fragment with contents of filenames
     *
     * @js init
     * @lua init
     */
    public native static GLProgram createWithFilenames(@StdString String vShaderFilename, @StdString String fShaderFilename);

    public native boolean initWithFilenames(@StdString String vShaderFilename, @StdString String fShaderFilename);

//    public native  Uniform* getUniform(@StdString String name);
//    public native  VertexAttrib* getVertexAttrib(@StdString String name);

    /**
     * It will add a new attribute to the shader by calling glBindAttribLocation
     */
    public native void bindAttribLocation(@StdString String attributeName, int index);

    /**
     * calls glGetAttribLocation
     */
    public native int getAttribLocation(@StdString String attributeName);

    /**
     * calls glGetUniformLocation()
     */
    public native int getUniformLocation(@StdString String attributeName);

    /**
     * links the glProgram
     */
    public native boolean link();

    /**
     * it will call glUseProgram()
     */
    public native void use();

    /**
     * It will create 4 uniforms:
     * - kUniformPMatrix
     * - kUniformMVMatrix
     * - kUniformMVPMatrix
     * - GLProgram::UNIFORM_SAMPLER
     * <p/>
     * And it will bind "GLProgram::UNIFORM_SAMPLER" to 0
     */
    public native void updateUniforms();

    /**
     * calls retrieves the named uniform location for this shader program.
     */
    public native int getUniformLocationForName(String name);

    /**
     * calls glUniform1i only if the values are different than the previous call for this same shader program.
     *
     * @js setUniformLocationI32
     * @lua setUniformLocationI32
     */
    public native void setUniformLocationWith1i(int location, int i1);

    /**
     * calls glUniform2i only if the values are different than the previous call for this same shader program.
     */
    public native void setUniformLocationWith2i(int location, int i1, int i2);

    /**
     * calls glUniform3i only if the values are different than the previous call for this same shader program.
     */
    public native void setUniformLocationWith3i(int location, int i1, int i2, int i3);

    /**
     * calls glUniform4i only if the values are different than the previous call for this same shader program.
     */
    public native void setUniformLocationWith4i(int location, int i1, int i2, int i3, int i4);

    /**
     * calls glUniform2iv only if the values are different than the previous call for this same shader program.
     */
    public native void setUniformLocationWith2iv(int location, int[] ints, int numberOfArrays);

    /**
     * calls glUniform3iv only if the values are different than the previous call for this same shader program.
     */
    public native void setUniformLocationWith3iv(int location, int[] ints, int numberOfArrays);

    /**
     * calls glUniform4iv only if the values are different than the previous call for this same shader program.
     */

    public native void setUniformLocationWith4iv(int location, int[] ints, int numberOfArrays);

    /**
     * calls glUniform1f only if the values are different than the previous call for this same shader program.
     * In js or lua,please use setUniformLocationF32
     *
     * @js NA
     */
    public native void setUniformLocationWith1f(int location, float f1);

    /**
     * calls glUniform2f only if the values are different than the previous call for this same shader program.
     * In js or lua,please use setUniformLocationF32
     *
     * @js NA
     */
    public native void setUniformLocationWith2f(int location, float f1, float f2);

    /**
     * calls glUniform3f only if the values are different than the previous call for this same shader program.
     * In js or lua,please use setUniformLocationF32
     *
     * @js NA
     */
    public native void setUniformLocationWith3f(int location, float f1, float f2, float f3);

    /**
     * calls glUniform4f only if the values are different than the previous call for this same shader program.
     * In js or lua,please use setUniformLocationF32
     *
     * @js NA
     */
    public native void setUniformLocationWith4f(int location, float f1, float f2, float f3, float f4);

    /**
     * calls glUniformfv only if the values are different than the previous call for this same shader program.
     */
    public native void setUniformLocationWith1fv(int location, float[] floats, int numberOfArrays);

    /**
     * calls glUniform2fv only if the values are different than the previous call for this same shader program.
     */
    public native void setUniformLocationWith2fv(int location, float[] floats, int numberOfArrays);

    /**
     * calls glUniform3fv only if the values are different than the previous call for this same shader program.
     */
    public native void setUniformLocationWith3fv(int location, float[] floats, int numberOfArrays);

    /**
     * calls glUniform4fv only if the values are different than the previous call for this same shader program.
     */
    public native void setUniformLocationWith4fv(int location, float[] floats, int numberOfArrays);

    /**
     * calls glUniformMatrix2fv only if the values are different than the previous call for this same shader program.
     */
    public native void setUniformLocationWithMatrix2fv(int location, float[] matrixArray, int numberOfMatrices);

    /**
     * calls glUniformMatrix3fv only if the values are different than the previous call for this same shader program.
     */
    public native void setUniformLocationWithMatrix3fv(int location, float[] matrixArray, int numberOfMatrices);

    /**
     * calls glUniformMatrix4fv only if the values are different than the previous call for this same shader program.
     */
    public native void setUniformLocationWithMatrix4fv(int location, float[] matrixArray, int numberOfMatrices);

    /**
     * will update the builtin uniforms if they are different than the previous call for this same shader program.
     */
    public native void setUniformsForBuiltins();
//    public native void setUniformsForBuiltins(Mat4 modelView);

    // Attribute

    /**
     * returns the vertexShader error log
     */
    public native
    @StdString
    String getVertexShaderLog();

    /**
     * returns the fragmentShader error log
     */
    public native
    @StdString
    String getFragmentShaderLog();

    /**
     * returns the program error log
     */
    public native
    @StdString
    String getProgramLog();

    // reload all shaders, this function is designed for android
    // when opengl context lost, so don't call it.
    public native void reset();

    public native short getProgram();
}
