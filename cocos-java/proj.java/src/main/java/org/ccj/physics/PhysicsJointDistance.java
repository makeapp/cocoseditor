/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.physics;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.ByRef;
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
public class PhysicsJointDistance extends PhysicsJoint
{
    public PhysicsJointDistance()
    {
    }

    public PhysicsJointDistance(Pointer p)
    {
        super(p);
    }

    public native static PhysicsJointDistance construct
        (PhysicsBody a, PhysicsBody b, @Const @ByRef Vec2 anchr1, @Const @ByRef Vec2 anchr2);

    public native float getDistance();

    public native void setDistance(float distance);

    public PhysicsJointDistance cast(Ref ref)
    {
        return cast(ref, PhysicsJointDistance.class);
    }
}
