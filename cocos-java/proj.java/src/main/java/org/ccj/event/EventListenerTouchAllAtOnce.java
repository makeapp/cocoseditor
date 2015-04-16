/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.event;

import com.googlecode.javacpp.annotation.Name;
import com.googlecode.javacpp.annotation.Platform;
import org.ccj.base.Ref;
import org.ccj.base.Touch;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/7/4 12:21 $
 *          $Id$
 */
@Platform(include = "JavaEventListenerTouchAllAtOnce.h")
@Name("ccj::JavaEventListenerTouchAllAtOnce")
@com.googlecode.javacpp.annotation.Opaque
public class EventListenerTouchAllAtOnce
        extends EventListener {

    EventHandlerTouchAll handler;

    private EventListenerTouchAllAtOnce() {
    }

    private native static EventListenerTouchAllAtOnce create();

    public static EventListenerTouchAllAtOnce create(EventHandlerTouchAll handler) {
        EventListenerTouchAllAtOnce listenerTouchAllAtOnce = create();
        listenerTouchAllAtOnce.handler = handler;
        Ref.putRef(listenerTouchAllAtOnce);
        return listenerTouchAllAtOnce;
    }

    private static void handleTouchesEvent(long targetAddress, long[] touchesAddress, int eventCode, long eventAddress) {
        Ref obj = Ref.getRef(targetAddress);
        if (obj instanceof EventListenerTouchAllAtOnce) {
            EventListenerTouchAllAtOnce layer = (EventListenerTouchAllAtOnce) obj;
            Touch touches[] = new Touch[touchesAddress.length];
            for (int i = 0; i < touchesAddress.length; i++) {
                touches[i] = new Touch(touchesAddress[i]);
            }
            EventTouch eventTouch = new EventTouch(eventAddress);
            if (eventCode == EventTouch.EVENT_BEGAN) {
                layer.handler.onTouchesBegan(touches, eventTouch);
            } else if (eventCode == EventTouch.EVENT_MOVED) {
                layer.handler.onTouchesMoved(touches, eventTouch);
            } else if (eventCode == EventTouch.EVENT_ENDED) {
                layer.handler.onTouchesEnded(touches, eventTouch);
            } else if (eventCode == EventTouch.EVENT_CANCELLED) {
                layer.handler.onTouchesCancelled(touches, eventTouch);
            }
        }
    }
}
