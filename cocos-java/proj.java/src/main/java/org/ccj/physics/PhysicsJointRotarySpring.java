/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.physics;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import org.ccj.base.Ref;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/4/22 20:21 $
 *          $Id$
 */

@Platform(include = "CCPhysicsJoint.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class PhysicsJointRotarySpring extends PhysicsJoint
{
    public PhysicsJointRotarySpring(Pointer p)
    {
        super(p);
    }

    public native static PhysicsJointRotarySpring construct(PhysicsBody a, PhysicsBody b, float stiffness, float damping);

    public native float getRestAngle();

    public native void setRestAngle(float restAngle);

    public native float getStiffness();

    public native void setStiffness(float stiffness);

    public native float getDamping();

    public native void setDamping(float damping);

    public PhysicsJointRotarySpring cast(Ref ref)
    {
        return cast(ref, PhysicsJointRotarySpring.class);
    }
}
