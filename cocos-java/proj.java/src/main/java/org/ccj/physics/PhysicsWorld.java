/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.physics;

import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.ByVal;
import com.googlecode.javacpp.annotation.Const;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import org.ccj.Scene;
import org.ccj.math.Vec2;
import org.ccj.base.Ref;
import org.ccj.base.VectorPhysicsBody;
import org.ccj.base.VectorPhysicsShape;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/4/22 20:05 $
 *          $Id$
 */

@Platform(include = "CCPhysicsWorld.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class PhysicsWorld extends Ref
{

    public static final int DEBUGDRAW_NONE = 0x00;        ///< draw nothing
    public static final int DEBUGDRAW_SHAPE = 0x01;       ///< draw shapes
    public static final int DEBUGDRAW_JOINT = 0x02;       ///< draw joints
    public static final int DEBUGDRAW_CONTACT = 0x04;     ///< draw contact
    public static final int DEBUGDRAW_ALL = DEBUGDRAW_SHAPE | DEBUGDRAW_JOINT | DEBUGDRAW_CONTACT;         ///< draw all

    /**
     * Adds a joint to the physics world.
     */
    public native void addJoint(PhysicsJoint joint);

    /**
     * Remove a joint from physics world.
     */
    public native void removeJoint(PhysicsJoint joint, boolean destroy);

    /**
     * Remove all joints from physics world.
     */
    public native void removeAllJoints(boolean destroy);

    /**
     * Remove a body from physics world.
     */
    public native void removeBody(PhysicsBody body);

    /**
     * Remove body by tag.
     */
    public native void removeBody(int tag);

    /**
     * Remove all bodies from physics world.
     */
    public native void removeAllBodies();

    /** Searches for physics shapes that intersects the ray. */
//        void rayCast(PhysicsRayCastCallbackFunc func, const Vec2& start, const Vec2& end, void* data);
    /** Searches for physics shapes that contains in the rect. */
//        void queryRect(PhysicsQueryRectCallbackFunc func, const Rect& rect, void* data);
    /** Searches for physics shapes that contains the point. */
//        void queryPoint(PhysicsQueryPointCallbackFunc func, const Vec2& point, void* data);

    /**
     * Get phsyics shapes that contains the point.
     */
    @ByVal
//    @Cast("cocos2d::Vector<cocos2d::PhysicsShape*>")
    public native VectorPhysicsShape getShapes(@ByRef Vec2 point);

    /**
     * return physics shape that contains the point.
     */
    public native PhysicsShape getShape(@ByRef @Const Vec2 point);

    /**
     * Get all the bodys that in the physics world.
     */
    @ByVal
    public native VectorPhysicsBody getAllBodies();

    /**
     * Get body by tag
     */
    public native PhysicsBody getBody(int tag);

    /**
     * Get scene contain this physics world
     */
    @ByRef
    public native Scene getScene();

    /**
     * get the gravity value
     */
    @ByVal
    public native Vec2 getGravity();

    /**
     * set the gravity value
     */
    public native void setGravity(@ByRef Vec2 gravity);

    /**
     * Set the speed of physics world, speed is the rate at which the simulation executes. default value is 1.0
     */
    public native void setSpeed(float speed);

    /**
     * get the speed of physics world
     */
    public native float getSpeed();

    /**
     * set the update rate of physics world, update rate is the value of EngineUpdateTimes/PhysicsWorldUpdateTimes.
     * set it higher can improve performance, set it lower can improve accuracy of physics world simulation.
     * default value is 1.0
     */
    public native void setUpdateRate(int rate);

    /**
     * get the update rate
     */
    public native int getUpdateRate();

    /**
     * set the debug draw mask
     */
    public native void setDebugDrawMask(int mask);

    /**
     * get the bebug draw mask
     */
    public native int getDebugDrawMask();


}
