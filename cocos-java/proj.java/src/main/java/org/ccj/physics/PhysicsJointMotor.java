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
public class PhysicsJointMotor extends PhysicsJoint
{
    public PhysicsJointMotor(Pointer p)
    {
        super(p);
    }

    public native static PhysicsJointMotor construct(PhysicsBody a, PhysicsBody b, float rate);

    public native float getRate();

    public native void setRate(float rate);

    public PhysicsJointMotor cast(Ref ref)
    {
        return cast(ref, PhysicsJointMotor.class);
    }
}
