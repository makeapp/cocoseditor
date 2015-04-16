/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.physics;

import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.Const;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import org.ccj.base.Ref;
import org.ccj.d2.Node;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/4/22 20:23 $
 *          $Id$
 */

@Platform(include = "CCPhysicsContact.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class PhysicsContact extends Ref
{
    //    enum class EventCode
//      {
    public static final int NONE = 0,
        BEGIN = 1,
        PRESOLVE = 2,
        POSTSOLVE = 3,
        SEPERATE = 4;
//      };

    /**
     * get contact shape A.
     */
    public native PhysicsShape getShapeA();

    /**
     * get contact shape B.
     */
    public native PhysicsShape getShapeB();

    /**
     * get contact data
     */
    @Const
    public native PhysicsContactData getContactData();

    /**
     * get previous contact data
     */
    @Const
    public native PhysicsContactData getPreContactData();
    /** get data. */
//        public native void* getData() ;

    /**
     * @brief set data to contact. you must manage the memory yourself, Generally you can set data at contact begin, and distory it at contact seperate.
     */
//        public native void setData(void* data);
    public PhysicsShape getPhysicsShape(int tag)
    {
        PhysicsShape shapeA = getShapeA();
        PhysicsShape shapeB = getShapeB();

        if (shapeA!=null && shapeA.getTag() == tag) {
            return shapeA;
        }
        else if (shapeB!=null && shapeB.getTag() == tag) {
            return shapeB;
        }
        return null;
    }

    public PhysicsBody getPhysicsBody(int tag)
    {
        PhysicsShape shapeA = getShapeA();
        PhysicsShape shapeB = getShapeB();

        PhysicsBody bodyA = shapeA.getBody();
        PhysicsBody bodyB = shapeB.getBody();

        if (bodyA!=null && bodyA.getTag() == tag) {
            return bodyA;
        }
        else if (bodyB!=null && bodyB.getTag() == tag) {
            return bodyB;
        }
        return null;
    }

    public Node getNode(int tag)
    {
        PhysicsShape shapeA = getShapeA();
        PhysicsShape shapeB = getShapeB();

        PhysicsBody bodyA = shapeA.getBody();
        PhysicsBody bodyB = shapeB.getBody();

        Node nodeA = bodyA.getNode();
        Node nodeB = bodyB.getNode();

        if (nodeA!=null && nodeA.getTag() == tag) {
            return nodeA;
        }
        else if (nodeB!=null && nodeB.getTag() == tag) {
            return nodeB;
        }
        return null;
    }


    /**
     * get the event code
     */
    @Cast("int")
    public native int getEventCode();
}
