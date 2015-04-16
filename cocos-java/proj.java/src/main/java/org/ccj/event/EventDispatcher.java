/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.event;

import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import com.googlecode.javacpp.annotation.StdString;
import org.ccj.d2.Node;
import org.ccj.base.Ref;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/4/17 9:43 $
 *          $Id$
 */

@Platform(include = "CCEventDispatcher.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class EventDispatcher extends Ref {
    /**
     * Adds a event listener for a specified event with the priority of scene graph.
     *
     * @param listener The listener of a specified event.
     * @param node     The priority of the listener is based on the draw order of this node.
     * @note The priority of scene graph will be fixed value 0. So the order of listener item
     * in the vector will be ' <0, scene graph (0 priority), >0'.
     */
    public native void addEventListenerWithSceneGraphPriority(EventListener listener, Node node);

    /**
     * Adds a event listener for a specified event with the fixed priority.
     *
     * @param listener      The listener of a specified event.
     * @param fixedPriority The fixed priority of the listener.
     * @note A lower priority will be called before the ones that have a higher value.
     * 0 priority is forbidden for fixed priority since it's used for scene graph based priority.
     */
    public native void addEventListenerWithFixedPriority(EventListener listener, int fixedPriority);

    /** Adds a Custom event listener.
     It will use a fixed priority of 1.
     @return the generated event. Needed in order to remove the event from the dispather
     */
//        EventListenerCustom* addCustomEventListener(const std::string &eventName, const std::function<void(EventCustom*)>& callback);

    /////////////////////////////////////////////

    // Removes event listener

    /**
     * Remove a listener
     *
     * @param listener The specified event listener which needs to be removed.
     */
    public native void removeEventListener(EventListener listener);

    /**
     * Removes all listeners with the same event listener type
     */
    public native void removeEventListenersForType(@Cast("cocos2d::EventListener::Type") int listenerType);

    /**
     * Removes all listeners which are associated with the specified target.
     */
    public native void removeEventListenersForTarget(Node target);

    /**
     * Removes all custom listeners with the same event name
     */
    public native void removeCustomEventListeners(@StdString String customEventName);

    /**
     * Removes all listeners
     */
    public native void removeAllEventListeners();

    /////////////////////////////////////////////

    // Pauses / Resumes event listener

    /**
     * Pauses all listeners which are associated the specified target.
     */
    public native void pauseEventListenersForTarget(Node target, boolean recursive);

    /**
     * Resumes all listeners which are associated the specified target.
     */
    public native void resumeEventListenersForTarget(Node target, boolean recursive);

    /////////////////////////////////////////////

    /**
     * Sets listener's priority with fixed value.
     */
    public native void setPriority(EventListener listener, int fixedPriority);

    /**
     * Whether to enable dispatching events
     */
    public native void setEnabled(@Cast("bool") boolean isEnabled);

    /**
     * Checks whether dispatching events is enabled
     */
    public native boolean isEnabled();

    /////////////////////////////////////////////

    /**
     * Dispatches the event
     * Also removes all EventListeners marked for deletion from the
     * event dispatcher list.
     */
    public native void dispatchEvent(Event event);

    /**
     * Dispatches a Custom Event with a event name an optional user data
     */
    public native void dispatchCustomEvent(@StdString String eventName, Ref optionalUserData);


}
