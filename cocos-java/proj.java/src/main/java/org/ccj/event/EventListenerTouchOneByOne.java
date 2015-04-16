/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.event;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.Name;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import org.ccj.base.Ref;
import org.ccj.base.Touch;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/7/4 12:20 $
 *          $Id$
 */

@Platform(include = "JavaEventListenerTouchOneByOne.h")
@Name("ccj::JavaEventListenerTouchOneByOne")
@com.googlecode.javacpp.annotation.Opaque
public class EventListenerTouchOneByOne
        extends EventListenerJava {

    EventHandlerTouchOne handler;

    private native static EventListenerTouchOneByOne create();

    public static EventListenerTouchOneByOne create(EventHandlerTouchOne handler) {
        EventListenerTouchOneByOne eventListenerTouchOneByOne = create();
        eventListenerTouchOneByOne.handler = handler;
        Ref.putRef(eventListenerTouchOneByOne);
        return eventListenerTouchOneByOne;
    }

    private static int handleTouchEvent(long address, long touchAddress, int eventCode, long eventAddress) {
        Ref obj = Ref.getRef(address);
        if (obj instanceof EventListenerTouchOneByOne) {
            EventListenerTouchOneByOne oneByOne = (EventListenerTouchOneByOne) obj;
            if (oneByOne.handler == null) {
                return 0;
            }
            Touch touch = new Touch(touchAddress);
            EventTouch eventTouch = new EventTouch(eventAddress);
            if (eventCode == EventTouch.EVENT_BEGAN) {
                return oneByOne.handler.onTouchBegan(touch, eventTouch) ? 1 : 0;
            } else if (eventCode == EventTouch.EVENT_MOVED) {
                oneByOne.handler.onTouchMoved(touch, eventTouch);
            } else if (eventCode == EventTouch.EVENT_ENDED) {
                oneByOne.handler.onTouchEnded(touch, eventTouch);
            } else if (eventCode == EventTouch.EVENT_CANCELLED) {
                oneByOne.handler.onTouchCancelled(touch, eventTouch);
            }
        }
        return 0;
    }
}
