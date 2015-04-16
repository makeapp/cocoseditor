/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.d2.action;

import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.Const;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import org.ccj.math.Size;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-2-28 上午11:39 $
 *          $Id$
 */

@Platform(include = "CCActionPageTurn3D.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class PageTurn3D
    extends Grid3DAction
{
    public native PageTurn3D clone();

    /**
     * create the action
     */
    public native static PageTurn3D create(float duration, @Const @ByRef Size gridSize);

}
