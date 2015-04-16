/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj;

import com.googlecode.javacpp.Pointer;
import org.ccj.base.Acceleration;
import org.ccj.base.Ref;
import org.ccj.d2.MenuItem;
import org.ccj.d2.action.CallFunc;
import org.ccj.event.*;
import org.ccj.base.Touch;
import org.fun.Function;
import org.fun.FunctionFactory;


/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/4/10 21:07 $
 *          $Id$
 */
@com.googlecode.javacpp.annotation.Opaque
public class Engine {
    static Engine javaEngine;

    public static Engine getInstance() {
        if (javaEngine == null) {
            javaEngine = new Engine();
            javaEngine.init();
        }
        return javaEngine;
    }

    public native void init();

    public native String invoke(String methodName, String param);

    public void addFunction(String name, Function function) {
        FunctionFactory.getInstance().addFunction(name, function);
    }

    public static String call(String methodName, String param) {
        return FunctionFactory.getInstance().call(methodName, param);
    }

    public static String execute(String methodName, String param) {
        return String.valueOf(FunctionFactory.getInstance().call(methodName, param));
    }

    private static int executeString(String str) {
        return 0;
    }

    public static native void log(String log);

    public static void handleCallFuncActionEvent(long address) {
        CallFunc.handleCallFuncActionEvent(address);
    }

    private static void handleScheduler(long handler, float elapse) {
        Ref obj = Ref.getRef(handler);
        if (obj instanceof Scheduler.SchedulerListener) {
            Scheduler.SchedulerListener listener = (Scheduler.SchedulerListener) obj;
            listener.onUpdate(elapse);
        }
    }

    public static void handleKeypadEvent(long address, int keycode, long eventAddress) {
        if (Ref.containsRef(address)) {
            EventHandlerKeyboard layer = (EventHandlerKeyboard) Ref.getRef(address);
            layer.onKeyPressed(keycode, new EventKeyboard(eventAddress));
        }
    }



    private static void releaseObject(long address) {
        Ref.releaseRef(address);
    }


    private static void releaseHandler(long address) {
//        System.out.println("releassHandler" + address);
//        Node.handleScheduler(address);
    }

    private static void handleCommonEvent(long address, int handler, String event) {

    }

    private static void handleControlEvent(long address, int action) {
//        Control.handleControlEvent(address, action);
    }

    private static void handleKeypadPressEvent(long address, int keycode, long eventAddress) {
        if (Ref.containsRef(address)) {
            EventHandlerKeyboard layer = (EventHandlerKeyboard) Ref.getRef(address);
            layer.onKeyPressed(keycode, new EventKeyboard(eventAddress));
        }
    }

    private static void handleKeypadReleaseEvent(long address, int keycode, long eventAddress) {
        if (Ref.containsRef(address)) {
            EventHandlerKeyboard layer = (EventHandlerKeyboard) Ref.getRef(address);
            layer.onKeyReleased(keycode, new EventKeyboard(eventAddress));
        }
    }

    private static void handleEvenCustom(long address, String eventName,long eventAddress) {
        Ref obj = Ref.getRef(address);
        if (obj instanceof EventHandlerTouchOne) {
            EventHandlerCustom layer = (EventHandlerCustom) obj;
            EventCustom evenCustom = new EventCustom("");
            layer.onCustom(eventName, evenCustom);
        }
    }

    private static void handleEventAcc(long targetAddress, long accAddress, long eventAddress) {
        Ref obj = Ref.getRef(targetAddress);
        if (obj instanceof EventHandlerAcceleration) {
            EventHandlerAcceleration handlerAcceleration = (EventHandlerAcceleration) obj;
            handlerAcceleration.onAcceleration(new Acceleration(accAddress), new EventAcceleration(eventAddress));
        }
    }

    private static int handleTouchEvent(long targetAddress, long touchAddress, int eventCode, long eventAddress) {
        Ref obj = Ref.getRef(targetAddress);
        if (obj instanceof EventHandlerTouchOne) {
            EventHandlerTouchOne layer = (EventHandlerTouchOne) obj;
            Pointer pointer = new Pointer();
            pointer.init(touchAddress, 0, 0);
            Touch touch = new Touch(pointer);
            EventTouch eventTouch = new EventTouch(eventAddress);
            if (eventCode == EventTouch.EVENT_BEGAN) {
                return layer.onTouchBegan(touch, eventTouch) ? 1 : 0;
            } else if (eventCode == EventTouch.EVENT_MOVED) {
                layer.onTouchMoved(touch, eventTouch);
            } else if (eventCode == EventTouch.EVENT_ENDED) {
                layer.onTouchEnded(touch, eventTouch);
            } else if (eventCode == EventTouch.EVENT_CANCELLED) {
                layer.onTouchCancelled(touch, eventTouch);
            }
        }
        return 0;
    }

    private static void handleTouchesEvent(long targetAddress, long[] touchesAddress, int eventCode, long eventAddress) {
        Ref obj = Ref.getRef(targetAddress);
        if (obj instanceof EventHandlerTouchOne) {
            EventHandlerTouchAll layer = (EventHandlerTouchAll) obj;
            Touch touches[] = new Touch[touchesAddress.length];
            EventTouch eventTouch = new EventTouch(eventAddress);
            if (eventCode == EventTouch.EVENT_BEGAN) {
                layer.onTouchesBegan(touches, eventTouch);
            } else if (eventCode == EventTouch.EVENT_MOVED) {
                layer.onTouchesMoved(touches, eventTouch);
            } else if (eventCode == EventTouch.EVENT_ENDED) {
                layer.onTouchesEnded(touches, eventTouch);
            } else if (eventCode == EventTouch.EVENT_CANCELLED) {
                layer.onTouchesCancelled(touches, eventTouch);
            }
        }
    }

    private static void handleMenuClickedEvent(long address) {
        if (Ref.containsRef(address)) {
            MenuItem listener = (MenuItem) Ref.getRef(address);
            listener.onItemClicked();
        }
    }

    /**
     * enum ScriptEventType
     * {
     * kNodeEvent = 0,
     * kMenuClickedEvent,
     * kCallFuncEvent,
     * kScheduleEvent,
     * kTouchEvent,
     * kTouchesEvent,
     * kKeypadEvent,
     * kAccelerometerEvent,
     * kControlEvent,
     * kCommonEvent,
     * };
     * <p/>
     * kNodeOnEnter,
     * kNodeOnExit,
     * kNodeOnEnterTransitionDidFinish,
     * kNodeOnExitTransitionDidStart,
     * kNodeOnCleanup
     */
    public static void handleNodeEvent(long address, int action) {
        Ref obj = Ref.getRef(address);
        if (obj instanceof Lifecycle) {
            Lifecycle node = (Lifecycle) obj;
            if (action == 0) {
                node.onEnter();
            } else if (action == 1) {
                node.onExit();
            } else if (action == 2) {
                node.onEnterTransitionDidFinish();
            } else if (action == 3) {
                node.onExitTransitionDidStart();
            } else if (action == 4) {
                node.onCleanup();
            }
        }
    }

    //kComponentOnEnter,
//        kComponentOnExit,
//        kComponentOnUpdate
    public static void handlerComponentEvent(long address, int type) {
        Ref obj = Ref.getRef(address);
        if (obj instanceof Component) {
            Component component = (Component) obj;
            component.update();
        }
    }
}
