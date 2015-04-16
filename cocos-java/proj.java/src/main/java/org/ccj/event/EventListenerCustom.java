package org.ccj.event;

import com.googlecode.javacpp.annotation.Name;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import com.googlecode.javacpp.annotation.StdString;
import org.ccj.base.Ref;
import org.ccj.ui.Widget;

/**
 * Created by yuanyou on 2014/12/16.
 */

//@Platform(include = "JavaEventListenerCustom.h")
//@Name("ccj::JavaEventListenerCustom")
//@com.googlecode.javacpp.annotation.Opaque
public class EventListenerCustom extends EventListenerJava {

    EventHandlerCustom handler;

    public static EventListenerCustom create(String eventName, EventHandlerCustom handler) {
        EventListenerCustom eventListenerCustom = new EventListenerCustom();
        eventListenerCustom.allocate(FOCUS, eventName);
        eventListenerCustom.handler = handler;
        Ref.putRef(eventListenerCustom);
        return eventListenerCustom;
    }

    protected void onEvent(EventCustom eventCustom) {
        if (handler != null) {
            String eventName = eventCustom.getEventName();
            handler.onCustom(eventName, eventCustom);
        }
    }
}
