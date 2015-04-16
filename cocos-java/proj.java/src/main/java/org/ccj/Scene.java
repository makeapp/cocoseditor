/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.Allocator;
import com.googlecode.javacpp.annotation.Name;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.NoDeallocator;
import com.googlecode.javacpp.annotation.Platform;
import org.ccj.base.Ref;
import org.ccj.d2.Node;
import org.ccj.physics.PhysicsWorld;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-2-28 上午11:34 $
 *          $Id$
 */
@Platform(include = "CCScene.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class Scene
    extends Node
{
    public Scene()
    {
        super(null);
        allocate();
        putRef(this);
    }

    public Scene(Pointer p)
    {
        super(p);
    }

    public native boolean initWithPhysics();

    public native PhysicsWorld getPhysicsWorld();

    /**
     * creates a new Scene object
     */
    public native static Scene create();

    @Allocator
    @NoDeallocator
    @Name("cocos2d::Scene::create")
    private native void allocate();

    public static Scene cast(Ref parent)
    {
        return cast(parent, Scene.class);
    }
}
