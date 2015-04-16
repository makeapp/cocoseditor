/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.physics;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.Allocator;
import com.googlecode.javacpp.annotation.Name;
import com.googlecode.javacpp.annotation.NoDeallocator;
import com.googlecode.javacpp.annotation.Platform;
import org.ccj.d2.Node;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-2-28 上午11:34 $
 *          $Id$
 */
@Platform(include = "CCScene.h")
@Name("cocos2d::Scene")
@com.googlecode.javacpp.annotation.Opaque
public class PhysicsScene
    extends Node
{
    public PhysicsScene()
    {
        super(null);
        allocate();
        putRef(this);
    }

    public PhysicsScene(Pointer p)
    {
        super(p);
    }

    /**
     * creates a new Scene object
     */
    public static PhysicsScene create()
    {
        return createWithPhysics();
    }

    @Allocator
    @NoDeallocator
    @Name("cocos2d::Scene::createWithPhysics")
    private native void allocate();

    public native PhysicsWorld getPhysicsWorld();

    public native static PhysicsScene createWithPhysics();
}
