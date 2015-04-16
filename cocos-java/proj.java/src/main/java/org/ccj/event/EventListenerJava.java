/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.event;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.Name;
import com.googlecode.javacpp.annotation.Platform;
import com.googlecode.javacpp.annotation.StdString;
import org.ccj.Director;
import org.ccj.base.Ref;
import org.ccj.d2.Node;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/4/21 13:32 $
 *          $Id$
 */

@Platform(include = "JavaEventListener.h")
@Name("ccj::JavaEventListener")
@com.googlecode.javacpp.annotation.Opaque
public class EventListenerJava extends EventListener {

    public EventListenerJava() {
    }

    public EventListenerJava(Pointer p) {
        super(p);
    }

    @Name("ccj::JavaEventListener::create")
    protected native void allocate(@Cast("cocos2d::EventListener::Type") int eventType, @StdString String listenerID);

    private static void onEvent(long eventListener, int eventType, long eventAddress) {
        EventListener listener = (EventListener) Ref.getRef(eventListener);
        if (listener == null) {
            return;
        }
        if (KEYBOARD == eventType) {
            EventKeyboard eventKeyboard = new EventKeyboard(eventAddress);
            EventListenerKeyboard listenerKeyboard = (EventListenerKeyboard) listener;
            listenerKeyboard.onEvent(eventKeyboard);
        } else if (ACCELERATION == eventType) {
            EventAcceleration eventAcceleration = new EventAcceleration(eventAddress);
            EventListenerAcceleration listenerKeyboard = (EventListenerAcceleration) listener;
            listenerKeyboard.onEvent(eventAcceleration);
        } else if (FOCUS == eventType) {
            EventFocus eventFocus = new EventFocus(eventAddress);
            EventListenerFocus listenerFocus = (EventListenerFocus) listener;
            listenerFocus.onEvent(eventFocus);
        } else if (CUSTOM == eventType) {
            EventCustom eventCustom = new EventCustom(eventAddress);
            EventListenerCustom listenerCustom = (EventListenerCustom) listener;
            listenerCustom.onEvent(eventCustom);
        }
    }


}
