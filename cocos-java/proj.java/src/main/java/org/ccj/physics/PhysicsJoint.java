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
 * @version $Date:2014/4/22 20:15 $
 *          $Id$
 */
@Platform(include = "CCPhysicsJoint.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class PhysicsJoint extends Ref
{
    public PhysicsJoint()
    {
    }

    public PhysicsJoint(Pointer p)
    {
        super(p);
    }

    public native PhysicsBody getBodyA();

    public native PhysicsBody getBodyB();

    public native PhysicsWorld getWorld();

    public native int getTag();

    public native void setTag(int tag);

    public native boolean isEnabled();

    /**
     * Enable/Disable the joint
     */
    public native void setEnable(boolean enable);

    public native boolean isCollisionEnabled();

    /**
     * Enable/disable the collision between two bodies
     */
    public native void setCollisionEnable(boolean enable);

    /**
     * Remove the joint from the world
     */
    public native void removeFormWorld();

//    public native static void destroy(PhysicsJoint joint);

    /**
     * Set the max force between two bodies
     */
    public native void setMaxForce(float force);

    /**
     * Get the max force setting
     */
    public native float getMaxForce();

    public PhysicsJoint cast(Ref ref)
    {
        return cast(ref, PhysicsJoint.class);
    }
}
