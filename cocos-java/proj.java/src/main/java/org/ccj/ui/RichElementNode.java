/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.ui;

import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.Name;
import com.googlecode.javacpp.annotation.Platform;
import org.ccj.base.Color3B;
import org.ccj.d2.Node;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/7/4 12:41 $
 *          $Id$
 */

@Platform(include = "ui/UIRichText.h")
@Name("cocos2d::ui::RichElementCustomNode")
@com.googlecode.javacpp.annotation.Opaque
public class RichElementNode extends RichElement
{
    public native boolean init(int tag, @ByRef Color3B color, int opacity, Node customNode);

    public native static RichElementNode create(int tag, @ByRef Color3B color, int opacity, Node customNode);
}
