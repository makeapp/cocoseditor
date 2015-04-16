/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.event;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.Name;
import com.googlecode.javacpp.annotation.Namespace;
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

@Platform(include = "CCEventListener.h")
@Name("cocos2d::EventListener")
@com.googlecode.javacpp.annotation.Opaque
public class EventListener extends Ref {
    public static final int TOUCH = 0,
            KEYBOARD = 1,
            ACCELERATION = 2,
            MOUSE = 3,
            FOCUS = 4,
            GAME_CONTROLLER = 5,
            CUSTOM = 6;

    public EventListener() {
    }

    public EventListener(Pointer p) {
        super(p);
    }


    /**
     * Enables or disables the listener
     *
     * @note Only listeners with `enabled` state will be able to receive events.
     * When an listener was initialized, it's enabled by default.
     * An event listener can receive events when it is enabled and is not paused.
     * paused state is always false when it is a fixed priority listener.
     */
    public native void setEnabled(boolean enabled);

    /**
     * Checks whether the listener is enabled
     */
    public native boolean isEnabled();

    public void addWithSceneGraphPriority(Node node) {
        Director.getInstance().getEventDispatcher().addEventListenerWithSceneGraphPriority(this, node);
    }

    public void addWithFixedPriority(int priority) {
        Director.getInstance().getEventDispatcher().addEventListenerWithFixedPriority(this, priority);
    }

    public void remove() {
        Director.getInstance().getEventDispatcher().removeEventListener(this);
    }
}
