/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.physics;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.ByVal;
import com.googlecode.javacpp.annotation.Const;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import org.ccj.base.Ref;
import org.ccj.math.Vec2;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/4/22 20:19 $
 *          $Id$
 */

@Platform(include = "CCPhysicsJoint.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class PhysicsJointLimit extends PhysicsJoint
{
    public PhysicsJointLimit(Pointer p)
    {
        super(p);
    }

    public native static PhysicsJointLimit construct(PhysicsBody a, PhysicsBody b, @ByRef @Const Vec2 anchr1, @ByRef @Const Vec2 anchr2);

    public native static PhysicsJointLimit construct(PhysicsBody a, PhysicsBody b, @ByRef @Const Vec2 anchr1, @ByRef @Const Vec2 anchr2, float min, float max);

    @ByVal
    public native Vec2 getAnchr1();

    public native void setAnchr1(@ByRef @Const Vec2 anchr1);

    @ByVal
    public native Vec2 getAnchr2();

    public native void setAnchr2(@ByRef @Const Vec2 anchr2);

    public native float getMin();

    public native void setMin(float min);

    public native float getMax();

    public native void setMax(float max);

    public PhysicsJointLimit cast(Ref ref)
    {
        return cast(ref, PhysicsJointLimit.class);
    }
}
