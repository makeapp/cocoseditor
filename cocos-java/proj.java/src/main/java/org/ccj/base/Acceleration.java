/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.base;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.*;
import org.ccj.base.Ref;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/4/12 11:02 $
 *          $Id$
 */

@Platform(include = "ccTypes.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class Acceleration extends Ref {

    public Acceleration() {
        allocate();
    }

    public Acceleration(long address) {
        super(address);
    }

    public Acceleration(Pointer p) {
        super(p);
    }

    private native void allocate();

    @MemberGetter()
    @Name("x")
    public native double getX();

    @MemberSetter()
    @Name("x")
    public native void setX(double x);

    @MemberGetter()
    @Name("y")
    public native double getY();

    @MemberSetter()
    @Name("y")
    public native void setY(double y);

    @MemberGetter()
    @Name("z")
    public native double getZ();

    @MemberSetter()
    @Name("z")
    public native void setZ(double z);

    @MemberGetter()
    @Name("timestamp")
    public native double getTimestamp();

    @MemberSetter()
    @Name("timestamp")
    public native void setTimestamp(double timestamp);
}
