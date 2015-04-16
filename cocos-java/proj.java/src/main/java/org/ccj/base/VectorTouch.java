/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.base;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.Name;
import com.googlecode.javacpp.annotation.Platform;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-3-2 上午9:27 $
 *          $Id$
 */
@Platform(include = {"<vector>", "<string>"})
@Name("std::vector<cocos2d::Touch*>")
@com.googlecode.javacpp.annotation.Opaque
public class VectorTouch
        extends Pointer {
    public native long size();

    private native Touch at(long i);

    public Touch get(long i) {
        return at(i);
    }

    private native void push_back(Touch touch);

    public void push(Touch touch) {
        push_back(touch);
    }
}
