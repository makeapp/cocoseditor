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
 * @version $Date:2014/6/3 12:24 $
 *          $Id$
 */

@Platform(include = "CCPhysicsShape.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class PhysicsShapeEdgeChain extends PhysicsShape
{
    public PhysicsShapeEdgeChain()
    {
    }

    public PhysicsShapeEdgeChain(Pointer p)
    {
        super(p);
    }

    public native static PhysicsShapeEdgeChain create(Vec2[] points, int count, @ByRef PhysicsMaterial material, float border);

    public native static PhysicsShapeEdgeChain create(Vec2[] points, int count);

    public static PhysicsShapeEdgeChain create(Vec2[] points)
    {
        return create(points, points.length);
    }


    //    public native void getPoints(Vec2* outPoints) ;
    public native int getPointsCount();

    public PhysicsShapeEdgeChain cast(Ref ref)
    {
        return cast(ref, PhysicsShapeEdgeChain.class);
    }
}
