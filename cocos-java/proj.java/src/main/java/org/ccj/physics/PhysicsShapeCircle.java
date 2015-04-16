/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.physics;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.ByVal;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import org.ccj.base.Ref;
import org.ccj.math.Vec2;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/6/3 12:24 $
 *          $Id$
 */

@Platform(include = "CCPhysicsShape.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class PhysicsShapeCircle extends PhysicsShape
{
    public PhysicsShapeCircle(Pointer p)
    {
        super(p);
    }

    public native static PhysicsShapeCircle create(float radius, @ByRef PhysicsMaterial material, @ByRef Vec2 offset);

    public native static PhysicsShapeCircle create(float radius, @ByRef PhysicsMaterial material);

    public native static PhysicsShapeCircle create(float radius);

    public native static float calculateArea(float radius);

    public native static float calculateMoment(float mass, float radius, @ByRef Vec2 offset);

    public native float calculateDefaultMoment();

    public native float getRadius();

    @ByVal
    public native Vec2 getOffset();

    public PhysicsShapeCircle cast(Ref ref)
    {
        return cast(ref, PhysicsShapeCircle.class);
    }
}
