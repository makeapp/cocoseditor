/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.d2;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.ByVal;
import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.Const;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import org.ccj.base.Color4F;
import org.ccj.math.Vec2;
import org.ccj.base.PointArray;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/4/25 14:41 $
 *          $Id$
 */

@Platform(include = "CCDrawingPrimitives.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class DrawPrimitives extends Pointer
{
    /**
     * Initializes the drawing primitives
     */
    public native static void init();

    /**
     * Frees allocated resources by the drawing primitives
     */
    public native static void free();

    /**
     * draws a point given x and y coordinate measured in points
     */
    public native static void drawPoint(@ByRef @Const Vec2 point);

    /**
     * draws an array of points.
     *
     * @since v0.7.2
     */
    public native static void drawPoints(Vec2 points, int numberOfPoints);

    /**
     * draws a line given the origin and destination point measured in points
     */
    public native static void drawLine(@ByRef @Const Vec2 origin, @ByRef @Const Vec2 destination);

    /**
     * draws a rectangle given the origin and destination point measured in points.
     */
    public native static void drawRect(@ByVal Vec2 origin, @ByVal Vec2 destination);

    /**
     * draws a solid rectangle given the origin and destination point measured in points.
     *
     * @since 1.1
     */
    public native static void drawSolidRect(@ByRef Vec2 origin, @ByRef Vec2 destination, @ByRef Color4F color);

    /**
     * draws a polygon given a pointer to Vec2 coordinates and the number of vertices measured in points.
     * The polygon can be closed or open
     */
    public native static void drawPoly(@Const Vec2 vertices, int numOfVertices, boolean closePolygon);

    /**
     * draws a solid polygon given a pointer to CGPoint coordinates, the number of vertices measured in points, and a color.
     */
    public native static void drawSolidPoly(@Const Vec2 poli, int numberOfPoints, @ByRef Color4F color);

    /**
     * draws a circle given the center, radius and number of segments.
     */
    public native static void drawCircle(@ByRef @Const Vec2 center, float radius, float angle, int segments, boolean drawLineToCenter, float scaleX, float scaleY);

    public native static void drawCircle(@ByRef @Const Vec2 center, float radius, float angle, int segments, boolean drawLineToCenter);

    /**
     * draws a solid circle given the center, radius and number of segments.
     */
    public native static void drawSolidCircle(@ByRef @Const Vec2 center, float radius, float angle, int segments, float scaleX, float scaleY);

    public native static void drawSolidCircle(@ByRef @Const Vec2 center, float radius, float angle, int segments);

    /**
     * draws a quad bezier path
     *
     * @warning This function could be pretty slow. Use it only for debugging purposes.
     * @since v0.8
     */
    public native static void drawQuadBezier(@ByRef @Const Vec2 origin, @ByRef @Const Vec2 control, @ByRef @Const Vec2 destination, int segments);

    /**
     * draws a cubic bezier path
     *
     * @warning This function could be pretty slow. Use it only for debugging purposes.
     * @since v0.8
     */
    public native static void drawCubicBezier(@ByRef @Const Vec2 origin, @ByRef @Const Vec2 control1, @ByRef @Const Vec2 control2, @ByRef @Const Vec2 destination, int segments);

    /**
     * draws a Catmull Rom path.
     *
     * @warning This function could be pretty slow. Use it only for debugging purposes.
     * @since v2.0
     */
    public native static void drawCatmullRom(PointArray arrayOfControlPoints, int segments);

    /**
     * draws a Cardinal Spline path.
     *
     * @warning This function could be pretty slow. Use it only for debugging purposes.
     * @since v2.0
     */
    public native static void drawCardinalSpline(PointArray config, float tension, int segments);

    /**
     * set the drawing color with 4 unsigned bytes
     *
     * @since v2.0
     */
    public native static void setDrawColor4B(@Cast("GLubyte") int r, @Cast("GLubyte") int g, @Cast("GLubyte") int b, @Cast("GLubyte") int a);

    /**
     * set the drawing color with 4 floats
     *
     * @since v2.0
     */
    public native static void setDrawColor4F(@Cast("GLfloat") float r, @Cast("GLfloat") float g, @Cast("GLfloat") float b, @Cast("GLfloat") float a);

    /**
     * set the point size in points. Default 1.
     *
     * @since v2.0
     */
    public native static void setPointSize(@Cast("GLfloat") float pointSize);
}
