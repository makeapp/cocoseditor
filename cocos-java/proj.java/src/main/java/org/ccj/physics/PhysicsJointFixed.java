/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.physics;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import org.ccj.base.Ref;
import org.ccj.math.Vec2;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/4/22 20:18 $
 *          $Id$
 */

@Platform(include = "CCPhysicsJoint.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class PhysicsJointFixed extends PhysicsJoint
{
    public PhysicsJointFixed()
    {
    }

    public PhysicsJointFixed(Pointer p)
    {
        super(p);
    }

    public native static PhysicsJointFixed construct(PhysicsBody a, PhysicsBody b, @ByRef Vec2 anchr);

    public PhysicsJointFixed cast(Ref ref)
    {
        return cast(ref, PhysicsJointFixed.class);
    }
}
