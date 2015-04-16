/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.event;

import com.googlecode.javacpp.annotation.Name;
import com.googlecode.javacpp.annotation.Platform;
import org.ccj.base.Acceleration;
import org.ccj.base.Ref;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/7/4 12:24 $
 *          $Id$
 */

public class EventListenerAcceleration extends EventListenerJava {
    EventHandlerAcceleration eventHandlerAcceleration;


    public static EventListenerAcceleration create(EventHandlerAcceleration handler) {
        EventListenerAcceleration eventListenerKeyboard = new EventListenerAcceleration();
        eventListenerKeyboard.allocate(ACCELERATION, "__cc_acceleration");
        eventListenerKeyboard.eventHandlerAcceleration = handler;
        Ref.putRef(eventListenerKeyboard);
        return eventListenerKeyboard;
    }

    protected void onEvent(EventAcceleration eventAcceleration) {
        if (eventHandlerAcceleration != null) {
            eventHandlerAcceleration.onAcceleration(eventAcceleration.getAcceleration(), eventAcceleration);
        }
    }
}
