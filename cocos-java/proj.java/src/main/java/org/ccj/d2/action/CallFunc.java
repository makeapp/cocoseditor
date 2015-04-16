/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.d2.action;

import java.util.HashMap;
import java.util.Map;

import com.googlecode.javacpp.annotation.Name;
import com.googlecode.javacpp.annotation.Platform;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-2-28 上午11:39 $
 *          $Id$
 */

@Platform(include = "JavaCallFunc.h")
@Name("ccj::JavaCallFunc")
@com.googlecode.javacpp.annotation.Opaque
public class CallFunc
    extends ActionInstant
{
    protected static Map<Long, CallFunc> schedulerCallbacks = new HashMap();

    public CallFunc()
    {
        allocate();
        schedulerCallbacks.put(address, this);
    }

    @Name("ccj::JavaCallFunc::create")
    private native void allocate();

//    public native static CallFunc create(int fid);

    public void execute()
    {

    }

    public static void handleCallFuncActionEvent(long address)
    {
        if (schedulerCallbacks.containsKey(address)) {
            schedulerCallbacks.get(address).execute();
        }
    }
}
