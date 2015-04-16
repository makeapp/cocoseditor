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
public class PhysicsJointRatchet extends PhysicsJoint
{
    public PhysicsJointRatchet(Pointer p)
    {
        super(p);
    }

    public native static PhysicsJointRatchet construct(PhysicsBody a, PhysicsBody b,
                                                       float phase, float ratchet);

    public native float getAngle();

    public native void setAngle(float angle);

    public native float getPhase();

    public native void setPhase(float phase);

    public native float getRatchet();

    public native void setRatchet(float ratchet);

    public PhysicsJointRatchet cast(Ref ref)
    {
        return cast(ref, PhysicsJointRatchet.class);
    }
}
