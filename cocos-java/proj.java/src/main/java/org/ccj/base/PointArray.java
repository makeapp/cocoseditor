/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.base;

import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.ByVal;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import org.ccj.math.Vec2;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-2-28 下午5:01 $
 *          $Id$
 */
@Platform(include = "CCActionCatmullRom.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class PointArray
    extends Ref
{

    /**
     * creates and initializes a Points array with capacity
     *
     * @js NA
     */
    public native static PointArray create(int capacity);

    /**
     * @js NA
     * @lua NA
     */
//       virtual ~PointArray();
    /**
     * @js NA
     * @lua NA
     */
//       PointArray();

    /**
     * initializes a Catmull Rom config with a capacity hint
     *
     * @js NA
     */
    public native boolean initWithCapacity(int capacity);

    /**
     * appends a control point
     *
     * @js NA
     */
    public native void addControlPoint(@ByRef Vec2 controlPoint);

    /**
     * inserts a controlPoint at index
     *
     * @js NA
     */
    public native void insertControlPoint(@ByRef Vec2 controlPoint, int index);

    /**
     * replaces an existing controlPoint at index
     *
     * @js NA
     */
    public native void replaceControlPoint(@ByRef Vec2 controlPoint, int index);

    /**
     * get the value of a controlPoint at a given index
     *
     * @js NA
     */
    @ByVal
    public native Vec2 getControlPointAtIndex(int index);

    /**
     * deletes a control point at a given index
     *
     * @js NA
     */
    public native void removeControlPointAtIndex(int index);

    /**
     * returns the number of objects of the control point array
     *
     * @js NA
     */
    public native int count();

    /**
     * returns a new copy of the array reversed. User is responsible for releasing this copy
     *
     * @js NA
     */
    public native PointArray reverse();

    /**
     * reverse the current control point array inline, without generating a new one
     *
     * @js NA
     */
    public native void reverseInline();

    /**
     * @js NA
     * @lua NA
     */
    public native PointArray clone();
    /**
     * @js NA
     */
//    public native  const std::vector<Vec2*> getControlPoints() const;
    /**
     * @js NA
     */
//       public native  void setControlPoints(std::vector<Vec2*> *controlPoints);

}
