/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.d2.action;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import com.googlecode.javacpp.annotation.StdString;
import org.ccj.base.Ref;
import org.ccj.d2.Node;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-2-28 上午11:39 $
 *          $Id$
 */

@Platform(include = "CCAction.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class Action
    extends Ref
{
    public Action(Pointer p)
    {
        super(p);
    }

    public Action()
    {
    }

    @StdString
    public native String description();

    /**
     * returns a clone of action
     */
    public native Action clone();

    /**
     * returns a new action that performs the exactly the reverse action
     */
    public native Action reverse();

    //! return true if the action has finished
    public native boolean isDone();

    //! called before the action start. It will also set the target.
    public native void startWithTarget(Node target);

    /**
     * called after the action has finished. It will set the 'target' to nil.
     * IMPORTANT: You should never call "[action stop]" manually. Instead, use: "target->stopAction(action);"
     */
    public native void stop();

    //! called every frame with it's delta time. DON'T override unless you know what you are doing.
    public native void step(float dt);

    /**
     * called once per frame. time a value between 0 and 1
     * <p/>
     * For example:
     * - 0 means that the action just started
     * - 0.5 means that the action is in the middle
     * - 1 means that the action is over
     */
    public native void update(float time);

    public native Node getTarget();

    /**
     * The action will modify the target properties.
     */
    public native void setTarget(Node target);

    public native Node getOriginalTarget();

    /**
     * Set the original target, since target can be nil.
     * Is the target that were used to run the action. Unless you are doing something complex, like ActionManager, you should NOT call this method.
     * The target is 'assigned', it is not 'retained'.
     *
     * @since v0.8.2
     */
    public native void setOriginalTarget(Node originalTarget);

    public native int getTag();

    public native void setTag(int tag);


    public static Action cast(Ref node)
    {
        return cast(node, Action.class);
    }
}
