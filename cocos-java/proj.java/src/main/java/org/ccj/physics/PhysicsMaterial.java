/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.physics;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.Allocator;
import com.googlecode.javacpp.annotation.Name;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.NoDeallocator;
import com.googlecode.javacpp.annotation.Platform;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/4/22 20:10 $
 *          $Id$
 */

@Platform(include = "CCPhysicsShape.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class PhysicsMaterial extends Pointer
{

    public PhysicsMaterial(float aDensity, float aRestitution, float aFriction)
    {
        allocate(aDensity, aRestitution, aFriction);
    }

    public PhysicsMaterial(float aDensity, float aRestitution)
    {
        allocate(aDensity, aRestitution, 0f);
    }

    @Allocator
    @NoDeallocator
    @Name("new PhysicsMaterial")
    public native void allocate(float aDensity, float aRestitution, float aFriction);
}
