package org.ccj.transition;

import com.googlecode.javacpp.annotation.*;
import org.ccj.Scene;
import org.ccj.base.Color3B;

/**
 * Created by yuanyou on 2014/12/18.
 */
@Platform(include = "CCTransition.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class TransitionFade extends TransitionScene {

    public native static TransitionFade create(float t, Scene scene);
    
    public native static TransitionFade create(float t, Scene scene,@Const @ByRef Color3B color);

}
