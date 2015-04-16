/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.base;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.Name;
import com.googlecode.javacpp.annotation.Platform;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-3-2 上午9:32 $
 *          $Id$
 */
@Platform(include = "CCValue.h")
@Name("cocos2d::ValueVector")
@com.googlecode.javacpp.annotation.Opaque
public class VectorValue
    extends Pointer
{
    public native long size();

    @ByRef
    public native Value at(long i);

    public String getString(long i)
    {
        Value value = at(i);
        if (value != null) {
            return value.asString();
        }
        return null;
    }

    public int getInt(long i)
    {
        Value value = at(i);
        if (value != null) {
            return value.asInt();
        }
        return 0;
    }


}



