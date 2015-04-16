/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.editor.cce;

import java.util.ArrayList;
import java.util.List;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.Name;
import com.googlecode.javacpp.annotation.Platform;
import org.ccj.Logger;
import org.ccj.base.Ref;
import org.ccj.d2.action.Action;
import org.ccj.d2.action.CallFunc;
import org.ccj.d2.action.Sequence;
import org.ccj.d2.action.Spawn;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/8/22 15:11 $
 *          $Id$
 */


@Platform(include = "CCEAnimation.h")
@Name("cce::CCEAnimation")
@com.googlecode.javacpp.annotation.Opaque
public class CCEAnimation
    extends org.ccj.base.Ref
{
    List<org.ccj.d2.action.Action> list = new ArrayList();

    public CCEAnimation(Pointer p)
    {
        super(p);
    }

    class ReuseAction extends CallFunc
    {
        public org.ccj.d2.action.Action action;

        @Override
        public void execute()
        {
            super.execute();
            synchronized (list) {
                list.add(action);
            }
        }
    }

    private native Spawn createActions();

    private Action createActionPool()
    {
        Spawn action = createActions();
        if (action == null) {
            Logger.log("Invalid action ");
            return null;
        }
        ReuseAction callFunc = new ReuseAction();

        Action newAction = Sequence.create(action, callFunc);
        callFunc.action = newAction;

        newAction.retain();

//        Logger.log("action " + action);
        return newAction;
    }

    public void createPooledActions(int size)
    {
        for (int i = 0; i < size; i++) {
            list.add(createActionPool());
        }
    }

    public Action getAction()
    {
        synchronized (list) {
            if (list.size() == 0) {
                return createActionPool();
            }
            else {
                return list.remove(0);
            }
        }
    }

    public static CCEAnimation cast(Ref ref)
    {
        return Ref.cast(ref, CCEAnimation.class);
    }
}
