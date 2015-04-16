/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.base;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.Name;
import com.googlecode.javacpp.annotation.Platform;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/4/25 13:58 $
 *          $Id$
 */

@Platform(include = {"<vector>", "CCRef.h"})
@Name("cocos2d::Vector<cocos2d::Ref*>")
@com.googlecode.javacpp.annotation.Opaque
public class VectorRef
    extends Pointer
{
    public native long size();

    private native Ref at(long i);

    public Ref get(long i)
    {
        return at(i);
    }
}
