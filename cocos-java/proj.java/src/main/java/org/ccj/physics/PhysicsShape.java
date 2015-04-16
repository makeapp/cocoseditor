/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.physics;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.ByVal;
import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.Const;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import org.ccj.base.Ref;
import org.ccj.math.Vec2;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/4/22 20:04 $
 *          $Id$
 */

@Platform(include = "CCPhysicsShape.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class PhysicsShape extends Ref
{
    public PhysicsShape()
    {
    }

    public PhysicsShape(Pointer p)
    {
        super(p);
    }

    public static final int UNKNOWN = 0,
        CIRCLE = 1,
        BOX = 2,
        POLYGEN = 3,
        EDGESEGMENT = 4,
        EDGEBOX = 5,
        EDGEPOLYGEN = 6,
        EDGECHAIN = 7;

    /**
     * Get the body that this shape attaches
     */
    public native PhysicsBody getBody();

    /**
     * Return the type of this shape
     */
    @Cast("int")
    public native int getType();

    /**
     * return the area of this shape
     */
    public native float getArea();

    /**
     * get moment
     */
    public native float getMoment();

    /**
     * Set moment, it will change the body's moment this shape attaches
     */
    public native void setMoment(float moment);

    public native void setTag(int tag);

    public native int getTag();

    /**
     * get mass
     */
    public native float getMass();

    /**
     * Set mass, it will change the body's mass this shape attaches
     */
    public native void setMass(float mass);

    public native float getDensity();

    public native void setDensity(float density);

    public native float getRestitution();

    public native void setRestitution(float restitution);

    public native float getFriction();

    public native void setFriction(float friction);

    @ByRef
    @Const
    public native PhysicsMaterial getMaterial();

    public native void setMaterial(@ByRef @Const PhysicsMaterial material);

    /**
     * Calculate the default moment value
     */
    public native float calculateDefaultMoment();

    /**
     * Get offset
     */
    @ByVal
    public native Vec2 getOffset();

    /**
     * Get center of this shape
     */
    @ByVal
    public native Vec2 getCenter();

    /**
     * Test point is in shape or not
     */
    public native boolean containsPoint(@ByRef @Const Vec2 point);

    /**
     * move the points to the center
     */
    public native static void recenterPoints(Vec2 points, int count, @ByRef @Const Vec2 center);

    /**
     * get center of the polyon points
     */
    @ByVal
    public native static Vec2 getPolyonCenter(Vec2 points, int count);

    /**
     * A mask that defines which categories this physics body belongs to.
     * Every physics body in a scene can be assigned to up to 32 different categories, each corresponding to a bit in the bit mask. You define the mask values used in your game. In conjunction with the collisionBitMask and contactTestBitMask properties, you define which physics bodies interact with each other and when your game is notified of these interactions.
     * The default value is 0xFFFFFFFF (all bits set).
     */
    public native void setCategoryBitmask(int bitmask);

    public native int getCategoryBitmask();

    /**
     * A mask that defines which categories of bodies cause intersection notifications with this physics body.
     * When two bodies share the same space, each body’s category mask is tested against the other body’s contact mask by performing a logical AND operation. If either comparison results in a non-zero value, an PhysicsContact object is created and passed to the physics world’s delegate. For best performance, only set bits in the contacts mask for interactions you are interested in.
     * The default value is 0x00000000 (all bits cleared).
     */
    public native void setContactTestBitmask(int bitmask);

    public native int getContactTestBitmask();

    /**
     * A mask that defines which categories of physics bodies can collide with this physics body.
     * When two physics bodies contact each other, a collision may occur. This body’s collision mask is compared to the other body’s category mask by performing a logical AND operation. If the result is a non-zero value, then this body is affected by the collision. Each body independently chooses whether it wants to be affected by the other body. For example, you might use this to avoid collision calculations that would make negligible changes to a body’s velocity.
     * The default value is 0xFFFFFFFF (all bits set).
     */
    public native void setCollisionBitmask(int bitmask);

    public native int getCollisionBitmask();

    public native void setGroup(int group);

    public native int getGroup();

    public PhysicsShape cast(Ref ref)
    {
        return cast(ref, PhysicsShape.class);
    }
}
