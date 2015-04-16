package org.ccj.renderer;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
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
public class UniformValue extends Pointer {
    public native void setFloat(float value);

    public native void setInt(int value);

    public native void setVec2(@ByRef Vec2 value);

    public native void setVec3(@ByRef Vec3 value);

    public native void setVec4(@ByRef Vec4 value);

    public native void setMat4(@ByRef Mat4 value);

    //    public  native   void setCallback(const std::function<void(GLProgram*, Uniform*)> &callback);
    public native void setTexture(int textureId, int activeTexture);

    public native void apply();
}
