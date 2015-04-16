/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj;

import org.ccj.math.Vec2;
import org.ccj.math.Rect;
import org.ccj.math.Size;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/4/21 12:50 $
 *          $Id$
 */
@com.googlecode.javacpp.annotation.Opaque
public class VisibleRect
{
    public static Rect getVisibleRect()
    {
        return Director.getInstance().getOpenGLView().getVisibleRect();
    }

    public static Vec2 leftTop()
    {
        return getGrid4Vec2(0, 2);
    }

    public static Vec2 leftCenter()
    {
        return getGrid4Vec2(0, 1);
    }

    public static Vec2 leftBottom()
    {
        return getGrid4Vec2(0, 0);
    }

    public static Vec2 top()
    {
        return getGrid4Vec2(1, 2);
    }

    public static Vec2 topLeft()
    {
        return getGrid4Vec2(0, 2);
    }

    public static Vec2 topRight()
    {
        return getGrid4Vec2(2, 2);
    }

    public static Vec2 bottom()
    {
        return bottomCenter();
    }

    public static Vec2 bottomCenter()
    {
        return getGrid4Vec2(1, 0);
    }

    public static Vec2 bottomLeft()
    {
        return getGrid4Vec2(0, 0);
    }

    public static Vec2 bottomRight()
    {
        return getGrid4Vec2(2, 0);
    }

    public static Vec2 center()
    {
        return getGrid4Vec2(1, 1);
    }


    public static Vec2 centerTop()
    {
        return getGrid4Vec2(1, 2);
    }

    public static Vec2 centerBottom()
    {
        return getGrid4Vec2(1, 0);
    }


    public static Vec2 centerLeft()
    {
        return getGrid4Vec2(0, 1);
    }

    public static Vec2 centerRight()
    {
        return getGrid4Vec2(2, 1);
    }

    public static Vec2 rightTop()
    {
        return getGrid4Vec2(2, 2);
    }

    public static Vec2 rightCenter()
    {
        return getGrid4Vec2(2, 1);
    }

    public static Vec2 rightBottom()
    {
        return getGrid4Vec2(2, 0);
    }

    public static Vec2 getGrid4Vec2(int xIdx, int yIdx)
    {
        return getGridVec2(2, xIdx, yIdx);
    }

    public static Vec2 getGrid9Vec2(int xIdx, int yIdx)
    {
        return getGridVec2(3, xIdx, yIdx);
    }

    public static Vec2 getGrid16Vec2(int xIdx, int yIdx)
    {
        return getGridVec2(4, xIdx, yIdx);
    }

    public static Vec2 getGrid25Vec2(int xIdx, int yIdx)
    {
        return getGridVec2(5, xIdx, yIdx);
    }

    public static Vec2 getGrid36Vec2(int xIdx, int yIdx)
    {
        return getGridVec2(6, xIdx, yIdx);
    }

    public static Vec2 getGridVec2(int count, int xIdx, int yIdx)
    {
        return getVec2(count, count, xIdx, yIdx);
    }

    public static Vec2 getVec2(int xCount, int yCount, int xIdx, int yIdx)
    {
        Rect visibleRect = getVisibleRect();
        Vec2 origin = visibleRect.getOrigin().fetch();
        Size size = visibleRect.getSize().fetch();

        float w = size.width / xCount;
        float h = size.height / yCount;

        return new Vec2(origin.x + xIdx * w, origin.y + yIdx + h * yIdx);
    }
}
