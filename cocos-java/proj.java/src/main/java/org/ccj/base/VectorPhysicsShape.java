/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.base;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.Name;
import com.googlecode.javacpp.annotation.Platform;
import org.ccj.physics.PhysicsShape;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/4/25 13:58 $
 *          $Id$
 */

@Platform(include = {"<vector>", "<string>"})
@Name("cocos2d::Vector<cocos2d::PhysicsShape*>")
@com.googlecode.javacpp.annotation.Opaque
public class VectorPhysicsShape
    extends Pointer
{
    public native long size();

    private native PhysicsShape at(long i);

    public PhysicsShape get(long i)
    {
        return at(i);
    }
}
