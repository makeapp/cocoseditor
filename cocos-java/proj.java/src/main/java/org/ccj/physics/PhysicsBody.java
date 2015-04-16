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
import org.ccj.d2.Node;
import org.ccj.math.Size;
import org.ccj.math.Vec2;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/4/22 20:01 $
 *          $Id$
 */

@Platform(include = "CCPhysicsBody.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class PhysicsBody extends Ref
{
    public PhysicsBody()
    {
    }

    public PhysicsBody(Pointer p)
    {
        super(p);
    }

    /**
     * create a body with defult mass and moment.
     */
    public native static PhysicsBody create();

    /**
     * create a body with mass and defult moment.
     */
    public native static PhysicsBody create(float mass);

    /**
     * create a body with mass and moment.
     */
    public native static PhysicsBody create(float mass, float moment);

    /**
     * Create a body contains a circle shape.
     */
    public native static PhysicsBody createCircle(float radius, @ByRef PhysicsMaterial material, @ByRef @Const Vec2 offset);

    public native static PhysicsBody createCircle(float radius);

    /**
     * Create a body contains a box shape.
     */
    public native static PhysicsBody createBox(@ByRef @Const Size size, @ByRef PhysicsMaterial material, @ByRef @Const Vec2 offset);

    public native static PhysicsBody createBox(@ByRef @Const Size size);

    /**
     * @brief Create a body contains a polygon shape.
     * points is an array of Vec2 structs defining a convex hull with a clockwise winding.
     */
    public native static PhysicsBody createPolygon(Vec2[] points, int count, @ByRef PhysicsMaterial material, @ByRef @Const Vec2 offset);

    public static PhysicsBody createPolygon(Vec2[] points, @ByRef PhysicsMaterial material, @ByRef @Const Vec2 offset)
    {
        return createPolygon(points, points.length, material, offset);
    }

    public native static PhysicsBody createPolygon(Vec2[] points, int count);

    public static PhysicsBody createPolygon(Vec2[] points)
    {
        return createPolygon(points, points.length);
    }

    /**
     * Create a body contains a EdgeSegment shape.
     */
    public native static PhysicsBody createEdgeSegment(@ByRef @Const Vec2 a, @ByRef @Const Vec2 b, @ByRef PhysicsMaterial material, float border);

    public native static PhysicsBody createEdgeSegment(@ByRef @Const Vec2 a, @ByRef @Const Vec2 b);

    /**
     * Create a body contains a EdgeBox shape.
     */
    public native static PhysicsBody createEdgeBox(@ByRef @Const Size size, @ByRef PhysicsMaterial material, float border, @ByRef @Const Vec2 offset);

    public native static PhysicsBody createEdgeBox(@ByRef @Const Size size);

    /**
     * Create a body contains a EdgePolygon shape.
     */
    public native static PhysicsBody createEdgePolygon(Vec2[] points, int count, @ByRef PhysicsMaterial material, float border);

    public static PhysicsBody createEdgePolygon(Vec2[] points, @ByRef PhysicsMaterial material, float border)
    {
        return createEdgePolygon(points, points.length, material, border);
    }

    public native static PhysicsBody createEdgePolygon(Vec2[] points, int count);

    public static PhysicsBody createEdgePolygon(Vec2[] points)
    {
        return createEdgePolygon(points, points.length);
    }


    /**
     * Create a body contains a EdgeChain shape.
     */
    public native static PhysicsBody createEdgeChain(Vec2[] points, int count, @ByRef PhysicsMaterial material, float border);

    public static PhysicsBody createEdgeChain(Vec2[] points, @ByRef PhysicsMaterial material, float border)
    {
        return createEdgeChain(points, points.length);
    }

    public native static PhysicsBody createEdgeChain(Vec2[] points, int count);

    public static PhysicsBody createEdgeChain(Vec2[] points)
    {
        return createEdgeChain(points, points.length);
    }

    /*
     * @brief add a shape to body
     * @param shape the shape to be added
     * @param addMassAndMoment if this is true, the shape's mass and moment will be added to body. the default is true
     */
    public native PhysicsShape addShape(PhysicsShape shape, boolean addMassAndMoment);

    /*
     * @brief remove a shape from body
     * @param shape the shape to be removed
     * @param reduceMassAndMoment if this is true, the body mass and moment will be reduced by shape. the default is true
     */
    public native void removeShape(PhysicsShape shape, boolean reduceMassAndMoment);

    /*
     * @brief remove a shape from body
     * @param tag the tag of the shape to be removed
     * @param reduceMassAndMoment if this is true, the body mass and moment will be reduced by shape. the default is true
     */
    public native void removeShape(int tag, boolean reduceMassAndMoment);

    /* remove all shapes */
    public native void removeAllShapes(boolean reduceMassAndMoment);

    /* get the body shapes. */
//         public native  Vector<PhysicsShape> getShapes() ;
        /* get the first shape of the body shapes. */
    public native PhysicsShape getFirstShape();

    /* get the shape of the body. */
    public native PhysicsShape getShape(int tag);

    /**
     * Applies a immediate force to body.
     */
    public native void applyForce(@ByRef @Const Vec2 force);

    /**
     * Applies a immediate force to body.
     */
    public native void applyForce(@ByRef @Const Vec2 force, @ByRef @Const Vec2 offset);

    /**
     * reset all the force applied to body.
     */
    public native void resetForces();

    /**
     * Applies a continuous force to body.
     */
    public native void applyImpulse(@ByRef @Const Vec2 impulse);

    /**
     * Applies a continuous force to body.
     */
    public native void applyImpulse(@ByRef @Const Vec2 impulse, @ByRef @Const Vec2 offset);

    /**
     * Applies a torque force to body.
     */
    public native void applyTorque(float torque);

    /**
     * set the velocity of a body
     */
    public native void setVelocity(@ByRef @Const Vec2 velocity);

    /**
     * get the velocity of a body
     */
    @ByVal
    public native Vec2 getVelocity();

    /**
     * set the angular velocity of a body
     */
    public native void setAngularVelocity(float velocity);

    /**
     * get the angular velocity of a body at a local point
     */
    @ByVal
    public native Vec2 getVelocityAtLocalPoint(@ByRef @Const Vec2 point);

    /**
     * get the angular velocity of a body at a world point
     */
    @ByVal
    public native Vec2 getVelocityAtWorldPoint(@ByRef @Const Vec2 point);

    /**
     * get the angular velocity of a body
     */
    public native float getAngularVelocity();

    /**
     * set the max of velocity
     */
    public native void setVelocityLimit(float limit);

    /**
     * get the max of velocity
     */
    public native float getVelocityLimit();

    /**
     * set the max of angular velocity
     */
    public native void setAngularVelocityLimit(float limit);

    /**
     * get the max of angular velocity
     */
    public native float getAngularVelocityLimit();

    /**
     * remove the body from the world it added to
     */
    public native void removeFromWorld();

    /**
     * get the world body added to.
     */
    public native PhysicsWorld getWorld();
    /** get all joints the body have */
//         public native const std::vector<PhysicsJoint*>& getJoints();

    /**
     * get the sprite the body set to.
     */
    public native Node getNode();

    /**
     * A mask that defines which categories this physics body belongs to.
     * Every physics body in a scene can be assigned to up to 32 different categories, each corresponding to a bit in the bit mask. You define the mask values used in your game. In conjunction with the collisionBitMask and contactTestBitMask properties, you define which physics bodies interact with each other and when your game is notified of these interactions.
     * The default value is 0xFFFFFFFF (all bits set).
     */
    public native void setCategoryBitmask(int bitmask);

    /**
     * A mask that defines which categories of bodies cause intersection notifications with this physics body.
     * When two bodies share the same space, each body’s category mask is tested against the other body’s contact mask by performing a logical AND operation. If either comparison results in a non-zero value, an PhysicsContact object is created and passed to the physics world’s delegate. For best performance, only set bits in the contacts mask for interactions you are interested in.
     * The default value is 0x00000000 (all bits cleared).
     */
    public native void setContactTestBitmask(int bitmask);

    /**
     * A mask that defines which categories of physics bodies can collide with this physics body.
     * When two physics bodies contact each other, a collision may occur. This body’s collision mask is compared to the other body’s category mask by performing a logical AND operation. If the result is a non-zero value, then this body is affected by the collision. Each body independently chooses whether it wants to be affected by the other body. For example, you might use this to avoid collision calculations that would make negligible changes to a body’s velocity.
     * The default value is 0xFFFFFFFF (all bits set).
     */
    public native void setCollisionBitmask(int bitmask);

    /**
     * get the category bit mask
     */
    public native int getCategoryBitmask();

    /**
     * get the contact test bit mask
     */
    public native int getContactTestBitmask();

    /**
     * get the collision bit mask
     */
    public native int getCollisionBitmask();

    /**
     * set the group of body
     * Collision groups let you specify an integral group index. You can have all fixtures with the same group index always collide (positive index) or never collide (negative index)
     * it have high priority than bit masks
     */
    public native void setGroup(int group);

    /**
     * get the group of body
     */
    public native int getGroup();

    /**
     * get the body position.
     */
    @ByVal
    public native Vec2 getPosition();

    /**
     * get the body rotation.
     */
    public native float getRotation();

    /**
     * set body position offset, it's the position witch relative to node
     */
    public native void setPositionOffset(@ByRef @Const Vec2 position);

    /**
     * get body position offset.
     */
    @ByVal
    public native Vec2 getPositionOffset();

    /**
     * set body rotation offset, it's the rotation witch relative to node
     */
    public native void setRotationOffset(float rotation);

    /**
     * set the body rotation offset
     */
    public native float getRotationOffset();

    /**
     * @brief test the body is dynamic or not.
     * a dynamic body will effect with gravity.
     */
    public native boolean isDynamic();

    /**
     * @brief set dynamic to body.
     * a dynamic body will effect with gravity.
     */
    public native void setDynamic(boolean dynamic);

    /**
     * @brief set the body mass.
     * @note if you need add/subtract mass to body, don't use setMass(getMass() +/- mass), because the mass of body may be equal to PHYSICS_INFINITY, it will cause some unexpected result, please use addMass() instead.
     */
    public native void setMass(float mass);

    /**
     * get the body mass.
     */
    public native float getMass();

    /**
     * @brief add mass to body.
     * if _mass(mass of the body) == PHYSICS_INFINITY, it remains.
     * if mass == PHYSICS_INFINITY, _mass will be PHYSICS_INFINITY.
     * if mass == -PHYSICS_INFINITY, _mass will not change.
     * if mass + _mass <= 0, _mass will equal to MASS_DEFAULT(1.0)
     * other wise, mass = mass + _mass;
     */
    public native void addMass(float mass);

    /**
     * @brief set the body moment of inertia.
     * @note if you need add/subtract moment to body, don't use setMoment(getMoment() +/- moment), because the moment of body may be equal to PHYSICS_INFINITY, it will cause some unexpected result, please use addMoment() instead.
     */
    public native void setMoment(float moment);

    /**
     * get the body moment of inertia.
     */
    public native float getMoment();

    /**
     * @brief add moment of inertia to body.
     * if _moment(moment of the body) == PHYSICS_INFINITY, it remains.
     * if moment == PHYSICS_INFINITY, _moment will be PHYSICS_INFINITY.
     * if moment == -PHYSICS_INFINITY, _moment will not change.
     * if moment + _moment <= 0, _moment will equal to MASS_DEFAULT(1.0)
     * other wise, moment = moment + _moment;
     */
    public native void addMoment(float moment);

    /**
     * get linear damping.
     */
    public native float getLinearDamping();

    /**
     * set linear damping.
     * it is used to simulate fluid or air friction forces on the body.
     * the value is 0.0f to 1.0f.
     */
    public native void setLinearDamping(float damping);

    /**
     * get angular damping.
     */
    public native float getAngularDamping();

    /**
     * set angular damping.
     * it is used to simulate fluid or air friction forces on the body.
     * the value is 0.0f to 1.0f.
     */
    public native void setAngularDamping(float damping);

    /**
     * whether the body is at rest
     */
    public native boolean isResting();

    /**
     * set body to rest
     */
    public native void setResting(boolean rest);

    /**
     * whether the body is enabled
     * if the body it isn't enabled, it will not has simulation by world
     */
    public native boolean isEnabled();

    /**
     * set the enable value.
     * if the body it isn't enabled, it will not has simulation by world
     */
    public native void setEnable(boolean enable);

    /**
     * whether the body can rotation
     */
    public native boolean isRotationEnabled();

    /**
     * set the body is allow rotation or not
     */
    public native void setRotationEnable(boolean enable);

    /**
     * whether this physics body is affected by the physics world’s gravitational force.
     */
    public native boolean isGravityEnabled();

    /**
     * set the body is affected by the physics world's gravitational force or not.
     */
    public native void setGravityEnable(boolean enable);

    /**
     * get the body's tag
     */
    public native int getTag();

    /**
     * set the body's tag
     */
    public native void setTag(int tag);

    /**
     * convert the world point to local
     */
    @ByVal
    public native Vec2 world2Local(@ByRef @Const Vec2 point);

    /**
     * convert the local point to world
     */
    @ByVal
    public native Vec2 local2World(@ByRef @Const Vec2 point);
}
