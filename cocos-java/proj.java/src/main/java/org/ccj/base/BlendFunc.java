/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.base;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.Allocator;
import com.googlecode.javacpp.annotation.MemberSetter;
import com.googlecode.javacpp.annotation.Name;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-3-5 上午11:08 $
 *          $Id$
 */

@Platform(include = "CCTypes.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class BlendFunc extends Pointer
{
    public BlendFunc()
    {
        allocate();
    }

    @Allocator
    public native void allocate();

    @MemberSetter()
    @Name("src")
    public native void setSrc(int src);

    @MemberSetter()
    @Name("dst")
    public native void setDst(int dst);
}
