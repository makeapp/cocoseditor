/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.d2.action;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-2-28 上午11:39 $
 *          $Id$
 */

/**
 * @brief Spawn a new action immediately
 */
@Platform(include = "CCActionInterval.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class Spawn
        extends ActionInterval {
    public Spawn(Pointer p) {
        super(p);
    }

    public Spawn() {
    }

    /**
     * helper constructor to create an array of spawned actions
     *
     * @code When this funtion bound to the js or lua,the input params changed
     * in js  :var   create(var   object1,var   object2, ...)
     * in lua :local create(local object1,local object2, ...)
     * @endcode
     */
    private native static Spawn create(FiniteTimeAction action1,@Cast("NULL") int nullValue);

    public static Spawn create(FiniteTimeAction action1) {
        return create(action1, 0);
    }

    private native static Spawn create(FiniteTimeAction action1, FiniteTimeAction action2,@Cast("NULL") int nullValue);

    public static Spawn create(FiniteTimeAction action1, FiniteTimeAction action2) {
        return create(action1, action2, 0);
    }

    private native static Spawn create(FiniteTimeAction action1, FiniteTimeAction action2, FiniteTimeAction action3,@Cast("NULL") int nullValue);

    public static Spawn create(FiniteTimeAction action1, FiniteTimeAction action2, FiniteTimeAction action3) {
        return create(action1, action2, action3, 0);
    }

    private native static Spawn create(FiniteTimeAction action1, FiniteTimeAction action2, FiniteTimeAction action3, FiniteTimeAction action4,@Cast("NULL") int nullValue);

    public static Spawn create(FiniteTimeAction action1, FiniteTimeAction action2, FiniteTimeAction action3, FiniteTimeAction action4) {
        return create(action1, action2, action3, action4, 0);
    }

    /** helper constructor to create an array of spawned actions */
//    public native static Spawn createWithVariableList(FiniteTimeAction *action1, va_list args);

    /** helper constructor to create an array of spawned actions given an array */
//    public native static Spawn create(const Vector<FiniteTimeAction*>& arrayOfActions);

    /**
     * creates the Spawn action
     */
    public native static Spawn createWithTwoActions(FiniteTimeAction action1, FiniteTimeAction action2);

    //
    // Overrides
    //
    public native Spawn clone();

    public native Spawn reverse();

}
