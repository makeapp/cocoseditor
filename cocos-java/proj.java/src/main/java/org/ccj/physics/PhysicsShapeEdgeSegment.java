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
public class PhysicsShapeEdgeSegment extends PhysicsShape
{
    public PhysicsShapeEdgeSegment()
    {
    }

    public PhysicsShapeEdgeSegment(Pointer p)
    {
        super(p);
    }

    public native static PhysicsShapeEdgeSegment create(@ByRef Vec2 a, @ByRef Vec2 b, @ByRef PhysicsMaterial material, float border);

    public native static PhysicsShapeEdgeSegment create(@ByRef Vec2 a, @ByRef Vec2 b, @ByRef PhysicsMaterial material);

    public native static PhysicsShapeEdgeSegment create(@ByRef Vec2 a, @ByRef Vec2 b);

    @ByVal
    public native Vec2 getPointA();

    @ByVal
    public native Vec2 getPointB();

    public PhysicsShapeEdgeSegment cast(Ref ref)
        {
            return cast(ref, PhysicsShapeEdgeSegment.class);
        }

}
