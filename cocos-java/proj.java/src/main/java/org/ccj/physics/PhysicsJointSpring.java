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
 * @version $Date:2014/4/22 20:20 $
 *          $Id$
 */

@Platform(include = "CCPhysicsJoint.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class PhysicsJointSpring extends PhysicsJoint
{
    public PhysicsJointSpring(Pointer p)
    {
        super(p);
    }

    public native static PhysicsJointSpring construct(
        PhysicsBody a, PhysicsBody b, @ByRef @Const Vec2 anchr1,
        @ByRef @Const Vec2 anchr2, float stiffness, float damping);

    @ByVal
    public native Vec2 getAnchr1();

    public native void setAnchr1(@ByRef @Const Vec2 anchr1);

    @ByVal
    public native Vec2 getAnchr2();

    public native void setAnchr2(@ByRef @Const Vec2 anchr2);

    public native float getRestLength();

    public native void setRestLength(float restLength);

    public native float getStiffness();

    public native void setStiffness(float stiffness);

    public native float getDamping();

    public native void setDamping(float damping);

    public PhysicsJointSpring cast(Ref ref)
    {
        return cast(ref, PhysicsJointSpring.class);
    }
}

