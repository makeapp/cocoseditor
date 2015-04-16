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
public class PhysicsJointRotaryLimit extends PhysicsJoint
{
    public PhysicsJointRotaryLimit(Pointer p)
    {
        super(p);
    }

    public native static PhysicsJointRotaryLimit construct(PhysicsBody a, PhysicsBody b, float min, float max);

    public native static PhysicsJointRotaryLimit construct(PhysicsBody a, PhysicsBody b);

    public native float getMin();

    public native void setMin(float min);

    public native float getMax();

    public native void setMax(float max);

    public PhysicsJointRotaryLimit cast(Ref ref)
    {
        return cast(ref, PhysicsJointRotaryLimit.class);
    }
}
