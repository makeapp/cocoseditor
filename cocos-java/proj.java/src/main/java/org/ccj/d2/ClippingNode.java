/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.d2;

import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/5/1 15:11 $
 *          $Id$
 */

@Platform(include = "CCClippingNode.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class ClippingNode extends Node
{
    /**
     * Creates and initializes a clipping node without a stencil.
     */
    public native static ClippingNode create();

    /**
     * Creates and initializes a clipping node with an other node as its stencil.
     * The stencil node will be retained.
     */
    public native static ClippingNode create(Node stencil);

    /**
     * The Node to use as a stencil to do the clipping.
     * The stencil node will be retained.
     * This default to nil.
     */
    public native Node getStencil();

    public native void setStencil(Node stencil);

    /**
     * The alpha threshold.
     * The content is drawn only where the stencil have pixel with alpha greater than the alphaThreshold.
     * Should be a float between 0 and 1.
     * This default to 1 (so alpha test is disabled).
     */
    public native float getAlphaThreshold();

    public native void setAlphaThreshold(float alphaThreshold);

    /**
     * Inverted. If this is set to true,
     * the stencil is inverted, so the content is drawn where the stencil is NOT drawn.
     * This default to false.
     */
    public native boolean isInverted();

    public native void setInverted(boolean inverted);
}
