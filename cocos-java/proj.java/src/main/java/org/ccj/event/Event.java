/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.event;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import com.googlecode.javacpp.annotation.StdString;
import org.ccj.base.Ref;
import org.ccj.d2.Node;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/4/12 10:56 $
 *          $Id$
 */
@Platform(include = "CCEventDispatcher.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class Event extends Ref {
    public static final int TYPE_TOUCH = 0;
    public static final int TYPE_KEYBOARD = 1;
    public static final int TYPE_ACCELERATION = 2;
    public static final int TYPE_MOUSE = 3;
    public static final int TYPE_CUSTOM = 4;

    public Event() {
    }

    public Event(Pointer p) {
        super(p);
    }

    public Event(long address) {
        this(getPointer(address));
    }

    private static Pointer getPointer(long address) {
        Pointer p = new Pointer();
        p.init(address, 0, 0);
        return p;
    }

    @Cast("int")
    public native int getType();

//    inline Type getType() const { return _type; };

    /**
     * Stops propagation for current event
     */
    public native void stopPropagation();

    /**
     * Checks whether the event has been stopped
     */
    public native boolean isStopped();

    /**
     * @return The target with which the event associates.
     * @brief Gets current target of the event
     * @note It onlys be available when the event listener is associated with node.
     * It returns 0 when the listener is associated with fixed priority.
     */
    public native Node getCurrentTarget();

    public native void setSourceId(@StdString String id);

    @StdString
    public native String getSourceId();
}
