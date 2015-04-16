/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.d2;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.Const;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import org.ccj.base.Ref;
import org.ccj.math.Vec2;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/4/25 15:53 $
 *          $Id$
 */

@Platform(include = "CCParallaxNode.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class ParallaxNode extends Node
{
    public ParallaxNode()
    {
    }

    public ParallaxNode(Pointer p)
    {
        super(p);
    }

    // Create a Parallax node
    public native static ParallaxNode create();

    // prevents compiler warning: "Included function hides overloaded public native functions"
//    using Node::addChild;

    public native void addChild(Node child, int z, @ByRef @Const Vec2 parallaxRatio, @ByRef @Const Vec2 positionOffset);

    /** Sets an array of layers for the Parallax node */
//    public native  void setParallaxArray( struct _ccArray *parallaxArray) { _parallaxArray = parallaxArray; }

    /**
     * Returns the array of layers of the Parallax node
     */
//    public native struct _ccArray* getParallaxArray() { return _parallaxArray; }
//    public native const struct _ccArray* getParallaxArray() const { return _parallaxArray; }

    //
    // Overrides
    //
//    public native void addChild(Node  child, int zOrder, int tag) override;
//    public native void removeChild(Node child, boolean cleanup) override;
//    public native void removeAllChildrenWithCleanup(bool cleanup) override;
//    public native void visit(Renderer *renderer, const kmMat4 &parentTransform, bool parentTransformUpdated) override;

    public static ParallaxNode cast(Ref ref)
    {
        return cast(ref, ParallaxNode.class);
    }
}
