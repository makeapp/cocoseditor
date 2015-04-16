package org.ccj.event;

import com.googlecode.javacpp.annotation.*;
import org.ccj.math.Vec2;

/**
 * Created by yuanyou on 2014/12/16.
 */

@Platform(include = "CCEventMouse.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class EventMouse extends Event {
    public static final int MOUSE_BUTTON_LEFT = 0;
    public static final int MOUSE_BUTTON_RIGHT = 1;
    public static final int MOUSE_BUTTON_MIDDLE = 2;
    public static final int MOUSE_BUTTON_4 = 3;
    public static final int MOUSE_BUTTON_5 = 4;
    public static final int MOUSE_BUTTON_6 = 5;
    public static final int MOUSE_BUTTON_7 = 6;
    public static final int MOUSE_BUTTON_8 = 7;

    public static final int
            MOUSE_NONE = 0,
            MOUSE_DOWN = 1,
            MOUSE_UP = 2,
            MOUSE_MOVE = 3,
            MOUSE_SCROLL = 4;

    public native void setScrollData(float scrollX, float scrollY);

    public native float getScrollX();

    public native float getScrollY();

    public native void setCursorPosition(float x, float y);

    public native void setMouseButton(int button);

    public native int getMouseButton();

    public native float getCursorX();

    public native float getCursorY();

    /**
     * returns the current touch location in OpenGL coordinates
     */
    @ByVal
    @Const
    public native Vec2 getLocation();

    /**
     * returns the previous touch location in OpenGL coordinates
     */
    @ByVal
    @Const
    public native Vec2 getPreviousLocation();

    /**
     * returns the start touch location in OpenGL coordinates
     */
    @ByVal
    @Const
    public native Vec2 getStartLocation();

    /**
     * returns the delta of 2 current touches locations in screen coordinates
     */
    @ByVal
    @Const
    public native Vec2 getDelta();

    /**
     * returns the current touch location in screen coordinates
     */
    @ByVal
    @Const
    public native Vec2 getLocationInView();

    /**
     * returns the previous touch location in screen coordinates
     */

    @ByVal
    @Const
    public native Vec2 getPreviousLocationInView();

    /**
     * returns the start touch location in screen coordinates
     */
    @ByVal
    @Const
    public native Vec2 getStartLocationInView();

    ;
}
