/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.d2;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.Allocator;
import com.googlecode.javacpp.annotation.Name;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.NoDeallocator;
import com.googlecode.javacpp.annotation.Platform;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-2-28 上午11:39 $
 *          $Id$
 */

@Platform(include = "CCLayer.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class LayerMultiplex
    extends Layer
{
    public LayerMultiplex()
    {
        super(null);
        allocate();
        putRef(this);
    }

    public LayerMultiplex(Pointer p)
    {
        super(p);
    }

    @Allocator
    @NoDeallocator
    @Name("cocos2d::LayerMultiplex::create")
    public native void allocate();

    /**
     * creates and initializes a LayerMultiplex object
     *
     * @js NA
     * @lua NA
     */
    public native static LayerMultiplex create();

    /** creates a LayerMultiplex with an array of layers.
     @since v2.1
      * @js NA
     */
//       public native  static LayerMultiplex createWithArray(const Vector<Layer*>& arrayOfLayers);

    /**
     * creates a LayerMultiplex with one or more layers using a variable argument list.
     *
     * @code When this function bound to lua or js,the input params are changed.
     * In js:var create(...)
     * In lua:local create(...)
     * @endcode
     */
    public native static LayerMultiplex create(Layer layer);

    /**
     * lua script can not init with undetermined number of variables
     * so add these functions to be used with lua.
     *
     * @js NA
     * @lua NA
     */
    public native static LayerMultiplex createWithLayer(Layer layer);


    public native void addLayer(Layer layer);

}
