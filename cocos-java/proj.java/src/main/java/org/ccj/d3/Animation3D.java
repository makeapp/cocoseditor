/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.d3;

import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import com.googlecode.javacpp.annotation.StdString;
import org.ccj.base.Ref;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/7/20 10:01 $
 *          $Id$
 */


@Platform(include = "CCSprite3d.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class Animation3D extends Ref
{
    /**read all animation or only the animation with given animationName? animationName == "" read the first.*/
    public native   static Animation3D create(@StdString String filename,@StdString String  animationName);
    public native   static Animation3D create(@StdString String filename);

//     CC_DEPRECATED_ATTRIBUTE static Animation3D* getOrCreate(@StdString String filename, @StdString String animationName = ""){ return create(filename, animationName); }

     /**get duration*/
  public native    float getDuration();

}
