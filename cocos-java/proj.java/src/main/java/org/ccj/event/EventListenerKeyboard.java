/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.event;

import com.googlecode.javacpp.annotation.Name;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import org.ccj.base.Ref;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/7/4 12:22 $
 *          $Id$
 */

public class EventListenerKeyboard extends EventListenerJava {

    EventHandlerKeyboard handler;

    public static EventListenerKeyboard create(EventHandlerKeyboard handler) {
        EventListenerKeyboard eventListenerKeyboard = new EventListenerKeyboard();
        eventListenerKeyboard.allocate(KEYBOARD, "__cc_keyboard");
        eventListenerKeyboard.handler = handler;
        Ref.putRef(eventListenerKeyboard);
        return eventListenerKeyboard;
    }

    public void onEvent(EventKeyboard eventKeyboard) {
        if (handler == null) {
            return;
        }
//        if (eventKeyboard.isPressed()) {
//            handler.onKeyPressed(eventKeyboard.getKeyCode(), eventKeyboard);
//        } else {
//            handler.onKeyReleased(eventKeyboard.getKeyCode(), eventKeyboard);
//        }
    }
}
