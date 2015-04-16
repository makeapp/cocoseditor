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
public class PhysicsJointGroove extends PhysicsJoint
{
    public PhysicsJointGroove(Pointer p)
    {
        super(p);
    }

    public native static PhysicsJointGroove construct(
        PhysicsBody a, PhysicsBody b, @ByRef @Const Vec2 grooveA, @ByRef @Const Vec2 grooveB, @ByRef @Const Vec2 anchr2);

    @ByVal
    public native Vec2 getGrooveA();

    public native void setGrooveA(@ByRef @Const Vec2 grooveA);

    @ByVal
    public native Vec2 getGrooveB();

    public native void setGrooveB(@ByRef @Const Vec2 grooveB);

    @ByVal
    public native Vec2 getAnchr2();

    public native void setAnchr2(@ByRef @Const Vec2 anchr2);

    public PhysicsJointGroove cast(Ref ref)
        {
            return cast(ref, PhysicsJointGroove.class);
        }
}
