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

//@Platform(include = "JavaEventListenerFocus.h")
//@Name("ccj::JavaEventListenerFocus")
//@com.googlecode.javacpp.annotation.Opaque
public class EventListenerFocus extends EventListenerJava {

    EventHandlerFocus handler;

    public static EventListenerFocus create(EventHandlerFocus handler) {
        EventListenerFocus eventListenerFocus = new EventListenerFocus();
        eventListenerFocus.allocate(FOCUS, "__cc_focus_event");
        eventListenerFocus.handler = handler;
        Ref.putRef(eventListenerFocus);
        return eventListenerFocus;
    }

    public void onEvent(EventFocus eventFocus) {
        if(handler!=null){
//            eventFocus.
//            handler.onFocusChanged();
        }
    }

//    std::function<void(ui::Widget*, ui::Widget*)> onFocusChanged;
}
