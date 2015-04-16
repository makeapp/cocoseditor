/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.editor.cce;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.Name;
import com.googlecode.javacpp.annotation.Platform;
import org.ccj.*;
import org.ccj.base.Acceleration;
import org.ccj.base.Ref;
import org.ccj.d2.MenuItem;
import org.ccj.d2.Node;
import org.ccj.event.*;
import org.ccj.base.Touch;
import org.ccj.ui.Widget;
import org.fun.Function;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/6/18 19:09 $
 *          $Id$
 */

@Platform(include = "CCEController.h")
@Name("cce::CCEController")
public class CCEController
    extends Component
        implements EventHandlerTouchOne,EventHandlerTouchAll,EventHandlerAcceleration,EventHandlerCustom,EventHandlerKeyboard
{
    protected Node owner;

    protected CCEReader reader;

    Function<Ref, Void> onEnterListener;
    Function<Ref, Void> onExitListener;

    public CCEController()
    {
        allocate();
        putRef(this);
    }

    public CCEController(Pointer p)
    {
        super(p);
        putRef(this);
    }

    @Name("cce::CCEController::create")
    private native void allocate();

    public void onEnter()
    {
        super.onEnter();
        owner = getOwner();
        if (onEnterListener != null) {
            onEnterListener.apply(owner);
        }
        if (reader != null) {
            reader.retain();
        }
    }

    public void onExit()
    {
        super.onExit();
        if (onExitListener != null) {
            onExitListener.apply(owner);
        }
        if (reader != null) {
            reader.release();
        }
    }

    public void removeFromParent()
    {
        owner.removeFromParent();
    }

    public CCEReader getReader()
    {
        return reader;
    }

    public void setReader(CCEReader reader)
    {
        this.reader = reader;
    }

    public void setOnEnterListener(final Function<Ref, Void> fn)
    {
        this.onEnterListener = fn;
    }

    public void setOnExitListener(final Function<Ref, Void> fn)
    {
        this.onExitListener = fn;
    }

    public void addWidgetTouchDownListener(String name, final Function<Ref, Void> fn)
    {
        addWidgetListener(name, 0, fn);
    }

    public void addWidgetTouchUpListener(String name, final Function<Ref, Void> fn)
    {
        addWidgetListener(name, 2, fn);
    }

    public void addWidgetTouchMoveListener(String name, final Function<Ref, Void> fn)
    {
        addWidgetListener(name, 1, fn);
    }

    public void addWidgetListener(String name, final int action, final Function<Ref, Void> fn)
    {
        Widget widget = reader.getWidget(name);
        if (widget != null) {
            widget.addTouchEventListener(new Widget.TouchEventListener()
            {
                public void onTouch(Ref ref, int a)
                {
                    if (action == a) {
                        fn.apply(ref);
                    }
                }
            });
        }
    }

    public void addMenuItemListener(String name, final Function<Ref, Void> fn)
    {
        MenuItem widget = reader.getMenuItem(name);
        if (widget != null) {
            widget.setOnClickListener(new MenuItem.MenuItemListener()
            {
                public void onClicked(MenuItem item)
                {
                    fn.apply(item);
                }
            });
        }
    }

    public native boolean isTouchEnabled();

    public native void setTouchEnabled(@Cast("bool") boolean value);

    public native boolean isAccelerometerEnabled();

    public native void setAccelerometerEnabled(@Cast("bool") boolean value);

    public native boolean isKeypadEnabled();

    public native void setKeypadEnabled(@Cast("bool") boolean value);

    public native void setTouchMode(@Cast("cocos2d::Touch::DispatchMode") int mode);

    @Cast("int")
    public native int getTouchMode();

    public native void setTouchPriority(int priority);

    public native int getTouchPriority();


    public void onAcceleration(Acceleration acc, Event event)
    {

    }

    public void onKeyPressed(int keyCode, Event event)
    {

    }

    public void onKeyReleased(int keyCode, Event event)
    {

    }

    public boolean onTouchBegan(Touch touch, Event event)
    {
        return true;
    }

    public void onTouchMoved(Touch touch, Event event)
    {

    }

    public void onTouchEnded(Touch touch, Event event)
    {

    }

    public void onTouchCancelled(Touch touch, Event event)
    {

    }

    public void onTouchesBegan(Touch[] touches, Event event)
    {

    }

    public void onTouchesMoved(Touch[] touches, Event event)
    {

    }

    public void onTouchesEnded(Touch[] touches, Event event)
    {

    }

    public void onTouchesCancelled(Touch[] touches, Event event)
    {

    }

    @Override
    public void onCustom(String eventName, Event event) {

    }
}
