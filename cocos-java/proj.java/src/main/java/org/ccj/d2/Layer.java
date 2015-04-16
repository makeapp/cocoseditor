/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.d2;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.Allocator;
import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.Name;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.NoDeallocator;
import com.googlecode.javacpp.annotation.Platform;
import org.ccj.base.Acceleration;
import org.ccj.event.*;
import org.ccj.base.Touch;
import org.ccj.base.Ref;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-2-28 上午11:39 $
 *          $Id$
 */

@Platform(include = "CCLayer.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class Layer
        extends Node
        implements EventHandlerTouchOne, EventHandlerTouchAll, EventHandlerAcceleration, EventHandlerCustom, EventHandlerKeyboard {
    public native static Layer create();

    public Layer() {
        super(false);
        allocate();
        putRef(this);
    }

    public Layer(Pointer p) {
        super(p);
        if (p != null) {
            putRef(this);
        }
    }

    @Allocator
    @NoDeallocator
    @Name("cocos2d::Layer::create")
    private native void allocate();


    public void onKeyPressed(int keyCode, Event event) {

    }

    public void onKeyReleased(int keyCode, Event event) {

    }

    public boolean onTouchBegan(Touch touch, Event event) {
        return false;
    }

    public void onTouchMoved(Touch touch, Event event) {

    }

    public void onTouchEnded(Touch touch, Event event) {

    }

    public void onTouchCancelled(Touch touch, Event event) {

    }

    public void onTouchesBegan(Touch[] touches, Event event) {

    }

    public void onTouchesMoved(Touch[] touches, Event event) {

    }

    public void onTouchesEnded(Touch[] touches, Event event) {

    }

    public void onTouchesCancelled(Touch[] touches, Event event) {

    }

    @Override
    public void onCustom(String eventName, Event event) {

    }

    //    public void onTouchesBegan(Touch[] touches, TouchEvent event)
//    {
//        for (Touch touch : touches) {
//            onTouchBegan(touch, event);
//        }
//    }

    /* Callback function should not be deprecated, it will generate lots of warnings.
    Since 'setAccelerometerEnabled' was deprecated, it will make warnings if developer overrides onAcceleration and invokes setAccelerometerEnabled(true) instead of using EventDispatcher::addEventListenerWithXXX.
    */
    public void onAcceleration(Acceleration acc, Event event) {

    }

    /** If isTouchEnabled, this method is called onEnter. Override it to change the
     way Layer receives touch events.
     ( Default: TouchDispatcher::sharedDispatcher()->addStandardDelegate(this,0); )
     Example:
     void Layer::registerWithTouchDispatcher()
     {
     TouchDispatcher::sharedDispatcher()->addTargetedDelegate(this,INT_MIN+1,true);
     }
     @since v0.8.0
     */
//        public  native void registerWithTouchDispatcher() final {};

    /**
     * whether or not it will receive Touch events.
     * You can enable / disable touch events with this property.
     * Only the touches of this node will be affected. This "method" is not propagated to it's children.
     *
     * @since v0.8.1
     */
    private boolean touchEnable = false;
    EventListenerTouchOneByOne listenerTouchOneByOne;
    EventListenerTouchAllAtOnce listenerTouchAllAtOnce;

    public boolean isTouchEnabled() {
        return touchEnable;
    }

    public void setTouchEnabled(@Cast("bool") boolean value) {
        if (touchEnable != value) {
            if (value) {
                if (this.touchMode == Touch.MODE_ONE_BY_ONE) {
                    listenerTouchOneByOne = EventListenerTouchOneByOne.create(this);
                    listenerTouchOneByOne.addWithSceneGraphPriority(this);
                } else if (this.touchMode == Touch.MODE_ALL_AT_ONCE) {
                    listenerTouchAllAtOnce = EventListenerTouchAllAtOnce.create(this);
                    listenerTouchAllAtOnce.addWithSceneGraphPriority(this);
                }
            } else {
                if (listenerTouchOneByOne != null) {
                    listenerTouchOneByOne.remove();
                    listenerTouchOneByOne = null;
                }
                if (listenerTouchAllAtOnce != null) {
                    listenerTouchAllAtOnce.remove();
                    listenerTouchAllAtOnce = null;
                }
            }
        }
    }

    private int touchMode = Touch.MODE_ONE_BY_ONE;

    public void setTouchMode(@Cast("cocos2d::Touch::DispatchMode") int mode) {
        if (mode != touchMode) {
            this.touchMode = mode;
            setTouchEnabled(false);
            setTouchEnabled(true);
        }
    }

    @Cast("int")
    public int getTouchMode() {
        return touchMode;
    }

    /**
     * swallowsTouches of the touch events. Default is true
     */
    public native void setSwallowsTouches(@Cast("bool") boolean swallowsTouches);

    public native boolean isSwallowsTouches();

    /**
     * whether or not it will receive Accelerometer events
     * You can enable / disable accelerometer events with this property.
     *
     * @since v0.8.1
     */
    boolean accelerometerEnabled=false;
    public  boolean isAccelerometerEnabled(){
        return accelerometerEnabled;
    }

    public  void setAccelerometerEnabled(@Cast("bool") boolean value){

    }

//    public  void setAccelerometerInterval(double interval){
//
//    }

    /**
     * whether or not it will receive keyboard or keypad events
     * You can enable / disable accelerometer events with this property.
     * it's new in cocos2d-x
     */

    public native boolean isKeyboardEnabled();

    public native void setKeyboardEnabled(@Cast("bool") boolean value);


    public static Layer cast(Ref node) {
        return cast(node, Layer.class);
    }

}
