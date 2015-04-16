package org.ccj.d2.action;

import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;

/**
 * Created by yuanyou on 2014/9/27.
 */

@Platform(include = "CCActionEase.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class EaseBezierAction
        extends ActionEase {
    /**
     * creates the action
     */
    public native static EaseBezierAction create(ActionInterval action);

//    public native EaseBezierAction clone() ;
//    public native EaseBezierAction reverse() ;

    public native void setBezierParamer(float p0, float p1, float p2, float p3);
}
