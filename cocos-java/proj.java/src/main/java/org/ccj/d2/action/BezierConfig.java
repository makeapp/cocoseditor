/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.d2.action;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.*;
import org.ccj.math.Vec2;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-3-5 下午2:54 $
 *          $Id$
 */
@Platform(include = "CCActionInterval.h")
@Name("cocos2d::ccBezierConfig")
@com.googlecode.javacpp.annotation.Opaque
public class BezierConfig extends Pointer {
    //! end position of the bezier
    Vec2 endPosition;
    //! Bezier control point 1
    Vec2 controlPoint1;
    //! Bezier control point 2
    Vec2 controlPoint2;

    public BezierConfig() {
        allocate();
    }

    public native void allocate();

    @MemberSetter()
    @Name("endPosition")
    public native void setEndPosition(@ByVal Vec2 endPosition);

    @MemberSetter()
    @Name("controlPoint_1")
    public native void setControlPoint1(@ByVal Vec2 controlPoint1);

    @MemberSetter()
    @Name("controlPoint_2")
    public native void setControlPoint2(@ByVal Vec2 controlPoint2);

}
