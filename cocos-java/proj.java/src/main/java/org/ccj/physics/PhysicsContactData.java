/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.physics;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.ByVal;
import com.googlecode.javacpp.annotation.MemberGetter;
import com.googlecode.javacpp.annotation.Name;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import org.ccj.math.Vec2;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/4/27 8:39 $
 *          $Id$
 */

@Platform(include = "CCPhysicsContact.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class PhysicsContactData extends Pointer
{
//    int   count;
//      Vec2 normal;

    @MemberGetter
    @Name("count")
    public native int getCount();

    @ByVal
    @MemberGetter
    @Name("normal")
    public native Vec2 getNormal();

}
