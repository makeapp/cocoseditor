/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.base;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.ByVal;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import org.ccj.math.Vec2;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/4/12 10:58 $
 *          $Id$
 */
@Platform(include = "CCTouch.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class Touch extends Ref {
    public Touch(Pointer p) {
        super(p);
    }

    public Touch(long address) {
        super(address);
    }

    public Touch(int id, float x, float y) {
        allocate();
        setTouchInfo(id, x, y);
    }

    private native void allocate();

    public static final int MODE_ALL_AT_ONCE = 0;
    /**
     * one by one
     */
    public static final int MODE_ONE_BY_ONE = 1;

    public native void setTouchInfo(int id, float x, float y);

    /**
     * returns the current touch location in OpenGL coordinates
     */
    @ByVal
    public native Vec2 getLocation();

    /**
     * returns the previous touch location in OpenGL coordinates
     */
    @ByVal
    public native Vec2 getPreviousLocation();

    /**
     * returns the start touch location in OpenGL coordinates
     */
    @ByVal
    public native Vec2 getStartLocation();

    /**
     * returns the delta of 2 current touches locations in screen coordinates
     */
    @ByVal
    public native Vec2 getDelta();

    /**
     * returns the current touch location in screen coordinates
     */
    @ByVal
    public native Vec2 getLocationInView();

    /**
     * returns the previous touch location in screen coordinates
     */
    @ByVal
    public native Vec2 getPreviousLocationInView();

    /**
     * returns the start touch location in screen coordinates
     */
    @ByVal
    public native Vec2 getStartLocationInView();

    public native int getID();

    public String toString() {
        return "ID="+getID()+","+getLocation().toString();
    }
}
