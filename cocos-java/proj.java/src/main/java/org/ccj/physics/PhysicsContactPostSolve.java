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
 * @version $Date:2014/4/25 20:39 $
 *          $Id$
 */

@Platform(include = "CCPhysicsContact.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class PhysicsContactPostSolve extends Ref
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
}
