/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.d2.action;

import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.Const;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-2-28 上午11:39 $
 *          $Id$
 */

@Platform(include = "CCActionInterval.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class Sequence
    extends ActionInterval
{
    /**
     * helper constructor to create an array of sequenceable actions
     */
    private native static Sequence create(FiniteTimeAction action1,@Cast("NULL") int nullValue);


    private native static Sequence create(FiniteTimeAction action1, FiniteTimeAction action2,@Cast("NULL") int nullValue);

    private native static Sequence create(FiniteTimeAction action1, FiniteTimeAction action2, FiniteTimeAction action3,@Cast("NULL") int nullValue);

    private native static Sequence create(FiniteTimeAction action1, FiniteTimeAction action2, FiniteTimeAction action3, FiniteTimeAction action4,@Cast("NULL") int nullValue);

    private native static Sequence create(FiniteTimeAction action1, FiniteTimeAction action2, FiniteTimeAction action3, FiniteTimeAction action4, FiniteTimeAction action5,@Cast("NULL") int nullValue);

    private native static Sequence create(FiniteTimeAction action1, FiniteTimeAction action2, FiniteTimeAction action3, FiniteTimeAction action4, FiniteTimeAction action5, FiniteTimeAction action6,@Cast("NULL") int nullValue);

    public static Sequence create(FiniteTimeAction action1)
    {
        return create(action1, 0);
    }

    public static Sequence create(FiniteTimeAction action1, FiniteTimeAction action2)
    {
        return create(action1, action2, 0);
    }

    public static Sequence create(FiniteTimeAction action1, FiniteTimeAction action2, FiniteTimeAction action3)
    {
        return create(action1, action2, action3, 0);
    }

    public static Sequence create(FiniteTimeAction action1, FiniteTimeAction action2, FiniteTimeAction action3, FiniteTimeAction action4)
    {
        return create(action1, action2, action3, action4, 0);
    }

    public static Sequence create(FiniteTimeAction action1, FiniteTimeAction action2, FiniteTimeAction action3, FiniteTimeAction action4, FiniteTimeAction action5)
    {
        return create(action1, action2, action3, action4, action5, 0);
    }

    public static Sequence create(FiniteTimeAction action1, FiniteTimeAction action2, FiniteTimeAction action3, FiniteTimeAction action4, FiniteTimeAction action5, FiniteTimeAction action6)
    {
        return create(action1, action2, action3, action4, action5, action6, 0);
    }

    /** helper constructor to create an array of sequenceable actions given an array
     * @code
     * When this funtion bound to the js or lua,the input params changed
     * in js  :var   create(var   object1,var   object2, ...)
     * in lua :local create(local object1,local object2, ...)
     * @endcode
     */
//      public native static Sequence create(const Vector<FiniteTimeAction*>& arrayOfActions);
    /** helper constructor to create an array of sequence-able actions */
//      public native static Sequence createWithVariableList(FiniteTimeAction *action1, va_list args);

    /**
     * creates the action
     */
    public native static Sequence createWithTwoActions(FiniteTimeAction actionOne, FiniteTimeAction actionTwo);

    //
    // Overrides
    //
    public native Sequence clone();

    public native Sequence reverse();

}
