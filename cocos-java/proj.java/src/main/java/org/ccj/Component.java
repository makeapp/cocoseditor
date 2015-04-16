/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.Const;
import com.googlecode.javacpp.annotation.Name;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.NoDeallocator;
import com.googlecode.javacpp.annotation.Platform;
import com.googlecode.javacpp.annotation.StdString;
import org.ccj.d2.Node;
import org.ccj.base.Ref;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/4/17 15:37 $
 *          $Id$
 */

@Platform(include = "CCComponent.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class Component extends Ref
    implements Lifecycle, Scheduler.SchedulerListener
{
    public native boolean init();

    long lastTime = -1;

    public Component()
    {
        allocate();
    }

    public Component(Pointer p)
    {
        super(p);
    }

    public void onCreate()
    {

    }

    @NoDeallocator
    @Name("cocos2d::Component::create")
    private native void allocate();

    public void onEnter()
    {

    }

    public void onExit()
    {

    }

    public void onCleanup()
    {

    }

    public void onEnterTransitionDidFinish()
    {

    }

    public void onExitTransitionDidStart()
    {

    }

    public void update()
    {
        if (lastTime == -1) {
            lastTime = System.currentTimeMillis();
        }
        float delta = (float) (System.currentTimeMillis() - lastTime) / 1000;
        onUpdate(delta);
        lastTime = System.currentTimeMillis();
    }

    public void onUpdate(float delta)
    {

    }

    //         public native  boolean serialize(void* r);
    public native boolean isEnabled();

    public native void setEnabled(@Cast("bool") boolean b);

//    public native static Component create();

    @StdString
    @Const
    public native String getName();

    public native void setName(@StdString String name);

    public native void setOwner(Node pOwner);

    public native Node getOwner();
}
