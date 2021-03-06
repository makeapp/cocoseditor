package org.ccj.transition;

import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import org.ccj.Scene;

/**
 * Created by yuanyou on 2014/12/18.
 */
@Platform(include = "CCTransition.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class TransitionSlideInL extends TransitionScene {

    public native static TransitionSlideInL create(float t, Scene scene);

}
