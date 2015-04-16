/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.d2;

import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.Const;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import org.ccj.base.Color4F;
import org.ccj.math.Vec2;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/4/25 15:08 $
 *          $Id$
 */

@Platform(include = "CCDrawNode.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class DrawNode extends Node
{
    /**
     * creates and initialize a DrawNode node
     */
    public native static DrawNode create();

    /**
     * draw a dot at a position, with a given radius and color
     */
    public native void drawDot(@ByRef @Const Vec2 pos, float radius, @ByRef @Const Color4F color);

    /**
     * draw a segment with a radius and color
     */
    public native void drawSegment(@ByRef @Const Vec2 from, @ByRef @Const Vec2 to, float radius, @ByRef @Const Color4F color);

    /**
     * draw a polygon with a fill color and line color
     *
     * @code When this function bound into js or lua,the parameter will be changed
     * In js: var drawPolygon(var Arrayofpoints, var fillColor, var width, var borderColor)
     * In lua:local drawPolygon(local pointTable,local tableCount,local fillColor,local width,local borderColor)
     * @endcode
     */
    public native void drawPolygon(Vec2[] verts, int count, @ByRef @Const Color4F fillColor, float borderWidth, @ByRef @Const Color4F borderColor);

    /**
     * draw a triangle with color
     */
    public native void drawTriangle(@ByRef @Const Vec2 p1, @ByRef @Const Vec2 p2, @ByRef @Const Vec2 p3, @ByRef @Const Color4F color);

    /**
     * draw a cubic bezier curve with color and number of segments
     */
    public native void drawCubicBezier(@ByRef @Const Vec2 from, @ByRef @Const Vec2 control1, @ByRef @Const Vec2 control2, @ByRef @Const Vec2 to, int segments, @ByRef @Const Color4F color);

    /**
     * draw a quadratic bezier curve with color and number of segments
     */
    public native void drawQuadraticBezier(@ByRef @Const Vec2 from, @ByRef @Const Vec2 control, @ByRef @Const Vec2 to, int segments, @ByRef @Const Color4F color);

    /**
     * Clear the geometry in the node's buffer.
     */
    public native void clear();
    /**
     * @js NA
     * @lua NA
     */
//        const BlendFunc& getBlendFunc() const;
    /**
     * @code
     * When this function bound into js or lua,the parameter will be changed
     * In js: var setBlendFunc(var src, var dst)
     * @endcode
     * @lua NA
     */
//        void setBlendFunc(const BlendFunc &blendFunc);

//        void onDraw(const kmMat4 &transform, bool transformUpdated);

    // Overrides
//        virtual void draw(Renderer *renderer, const kmMat4 &transform, bool transformUpdated) override;

}
