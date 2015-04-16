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

@Platform(include = "CCActionProgressTimer.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class FadeOutBLTiles
    extends FadeOutTRTiles
{
    public native FadeOutBLTiles clone();

    /**
     * creates the action with the grid size and the duration
     */
    public native static FadeOutBLTiles create(float duration, @Const @ByRef Size gridSize);

    // Overrides
    public native float testFunc(@Const @ByRef Size pos, float time);
}
