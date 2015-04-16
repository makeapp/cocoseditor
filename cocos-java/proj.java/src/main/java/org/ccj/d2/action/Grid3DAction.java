/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.d2.action;

import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.ByVal;
import com.googlecode.javacpp.annotation.Const;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import org.ccj.d2.GridBase;
import org.ccj.math.Vec2;
import org.ccj.base.Vertex3F;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-2-28 上午11:39 $
 *          $Id$
 */
@Platform(include = "CCActionGrid.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class Grid3DAction
    extends GridAction
{
    /**
     * returns the grid
     */
    public native GridBase getGrid();

    public native Grid3DAction clone();

    public native GridAction reverse();


    /** returns the grid */
//      virtual GridBase* getGrid();

    /**
     * returns the vertex than belongs to certain position in the grid
     *
     * @js NA
     * @lua NA
     */
    @ByVal
    public native Vertex3F getVertex(@Const @ByRef Vec2 position);

    /**
     * @js NA
     * @lua NA
     */
//      CC_DEPRECATED_ATTRIBUTE inline Vertex3F vertex(const Vec2& position) { return getVertex(position); }

    /**
     * returns the non-transformed vertex than belongs to certain position in the grid
     *
     * @js NA
     * @lua NA
     */
    @ByVal
    public native Vertex3F getOriginalVertex(@Const @ByRef Vec2 position);


    /**
     * sets a new vertex to a certain position of the grid
     *
     * @js NA
     * @lua NA
     */
    public native void setVertex(@Const @ByRef Vec2 position, @Const @ByRef Vertex3F vertex);

    // Overrides
//    public native Grid3DAction * clone() const override = 0;
}
