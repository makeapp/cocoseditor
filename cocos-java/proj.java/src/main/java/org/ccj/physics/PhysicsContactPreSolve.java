/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.physics;

import com.googlecode.javacpp.annotation.ByVal;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import org.ccj.math.Vec2;
import org.ccj.base.Ref;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/4/25 20:38 $
 *          $Id$
 */

@Platform(include = "CCPhysicsContact.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class PhysicsContactPreSolve extends Ref
{

    /**
     * get restitution between two bodies
     */
    public native float getRestitution();

    /**
     * get friction between two bodies
     */

    public native float getFriction();

    /**
     * get surface velocity between two bodies
     */
    @ByVal
    public native Vec2 getSurfaceVelocity();
    /** set the restitution*/
//       void setRestitution(float restitution);
    /** set the friction*/
//       void setFriction(float friction);
    /** set the surface velocity*/
//       void setSurfaceVelocity(const Vect& velocity);

    /**
     * ignore the rest of the contact presolve and postsolve callbacks
     */
    public native void ignore();
}
