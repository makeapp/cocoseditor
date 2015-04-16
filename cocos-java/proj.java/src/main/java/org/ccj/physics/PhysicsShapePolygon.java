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
public class PhysicsShapePolygon extends PhysicsShape
{
    public PhysicsShapePolygon(Pointer p)
    {
        super(p);
    }

    public native static PhysicsShapePolygon create(Vec2[] points, int count, @ByRef PhysicsMaterial material, @ByRef Vec2 offset);

    public native static PhysicsShapePolygon create(Vec2[] points, int count, @ByRef PhysicsMaterial material);

    public native static PhysicsShapePolygon create(Vec2[] points, int count);

    public static PhysicsShapePolygon create(Vec2[] points, @ByRef PhysicsMaterial material, @ByRef Vec2 offset)
    {
        return create(points, points.length, material, offset);
    }

    public static PhysicsShapePolygon create(Vec2[] points, @ByRef PhysicsMaterial material)
    {
        return create(points, points.length, material);
    }

    public static PhysicsShapePolygon create(Vec2[] points)
    {
        return create(points, points.length);
    }

    public native static float calculateArea(Vec2[] points, int count);

    public native static float calculateMoment(float mass, Vec2[] points, int count, @ByRef Vec2 offset);

    public native static float calculateMoment(float mass, Vec2[] points, int count);

//    public native float calculateDefaultMoment() ;

    @ByVal
    public native Vec2 getPoint(int i);

    //    public native void getPoints(Vec2* outPoints) const;
    public native int getPointsCount();
//    public native Vec2 getCenter() ;

    public PhysicsShapePolygon cast(Ref ref)
    {
        return cast(ref, PhysicsShapePolygon.class);
    }
}
