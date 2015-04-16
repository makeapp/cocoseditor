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
 * @version $Date:2014/4/22 20:22 $
 *          $Id$
 */

@Platform(include = "CCPhysicsJoint.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class PhysicsJointGear extends PhysicsJoint
{
    public PhysicsJointGear()
    {
    }

    public PhysicsJointGear(Pointer p)
    {
        super(p);
    }

    public native static PhysicsJointGear construct(PhysicsBody a, PhysicsBody b, float phase, float ratio);

    public native float getPhase();

    public native void setPhase(float phase);

    public native float getRatio();

    public native void setRatio(float ratchet);

    public PhysicsJointGear cast(Ref ref)
    {
        return cast(ref, PhysicsJointGear.class);
    }

}
