package org.ccj.transition;

import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import org.ccj.Scene;

/**
 * Created by yuanyou on 2014/12/18.
 */
@Platform(include = "CCTransition.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class TransitionFlipAngular extends TransitionScene {

    public native static TransitionFlipAngular create(float t, Scene scene);
    
    public native static TransitionFlipAngular create(float t, Scene scene,@Cast("cocos2d::TransitionScene::Orientation") int orientation);

}
