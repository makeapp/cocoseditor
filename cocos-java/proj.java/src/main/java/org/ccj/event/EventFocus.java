package org.ccj.event;

import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import org.ccj.ui.Widget;

/**
 * Created by yuanyou on 2014/12/16.
 */
@Platform(include = "CCEventFocus.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class EventFocus extends Event {

    public EventFocus(long address) {
        super(address);
    }

    public native void allocate(Widget widgetLoseFocus, Widget widgetGetFocus);
}
