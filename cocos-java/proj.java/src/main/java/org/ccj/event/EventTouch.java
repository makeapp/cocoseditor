/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.event;

import com.googlecode.javacpp.annotation.*;
import org.ccj.base.Touch;
import org.ccj.base.VectorTouch;
import org.ccj.event.Event;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/4/12 11:12 $
 *          $Id$
 */
@Platform(include = "CCEventTouch.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class EventTouch extends Event {

    public static final int EVENT_BEGAN = 0;
    public static final int EVENT_MOVED = 1;
    public static final int EVENT_ENDED = 2;
    public static final int EVENT_CANCELLED = 3;
    public static final int MAX_TOUCHES = 15;

    public EventTouch(long address) {
        super(address);
    }

    public EventTouch(Touch[] touches, int eventCode) {
        allocate();
        VectorTouch vectorTouch = getTouches();
        for (Touch touch : touches) {
            vectorTouch.push(touch);
        }
        setEventCode(eventCode);
    }

    public EventTouch(Touch touch, int eventCode) {
        allocate();
        VectorTouch vectorTouch = getTouches();
        vectorTouch.push(touch);
        setEventCode(eventCode);
    }

    public native void allocate();

    @Cast("int")
    public native int getEventCode();

    public native void setEventCode(@Cast("cocos2d::EventTouch::EventCode") int eventCode);

    @ByRef
    @Const
    public native VectorTouch getTouches();
}
