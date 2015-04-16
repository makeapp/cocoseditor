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
public class TransitionScene extends Scene {

    /// An horizontal orientation where the Left is nearer
    public static final int LEFT_OVER = 0,
    /// An horizontal orientation where the Right is nearer
    RIGHT_OVER = 1,
    /// A vertical orientation where the Up is nearer
    UP_OVER = 0,
    /// A vertical orientation where the Bottom is nearer
    DOWN_OVER = 1;

    public native static TransitionScene create(float t, Scene scene);

}
