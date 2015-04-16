/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.d3;

import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import com.googlecode.javacpp.annotation.StdString;
import org.ccj.d2.action.ActionInterval;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/7/20 10:15 $
 *          $Id$
 */

@Platform(include = "CCSprite3d.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class Animate3D extends ActionInterval
{

    /**
     * create Animate3D using Animation.
     */
    public native static Animate3D create(Animation3D animation);

    /**
     * create Animate3D
     *
     * @param animation used to generate animate3D
     * @param formTime
     * @param duration  Time the Animate3D lasts
     *
     * @return Animate3D created using animate
     */
    public native static Animate3D create(Animation3D animation, float fromTime, float duration);

    public static Animate3D create(@StdString String filename, @StdString String animationName)
    {
        return Animate3D.create(Animation3D.create(filename, animationName));
    }

    public static Animate3D create(@StdString String filename)
    {
        return Animate3D.create(Animation3D.create(filename));
    }

    //
    // Overrides
    //
//     public native void step(float dt) override;
//     public native void startWithTarget(Node *target) override;

    public native Animate3D reverse();

    public native Animate3D clone();

//     public native void update(float t) override;

    /**
     * get & set speed, negative speed means playing reverse
     */
    public native float getSpeed();

    public native void setSpeed(float speed);

    /**
     * get & set blend weight, weight must positive
     */
    public native float getWeight();

    public native void setWeight(float weight);
}
