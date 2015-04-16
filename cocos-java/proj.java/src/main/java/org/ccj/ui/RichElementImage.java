/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.ui;

import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import com.googlecode.javacpp.annotation.StdString;
import org.ccj.base.Color3B;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/7/4 12:40 $
 *          $Id$
 */

@Platform(include = "ui/UIRichText.h")
@Namespace("cocos2d::ui")
@com.googlecode.javacpp.annotation.Opaque
public class RichElementImage extends RichElement
{
    public native boolean init(int tag, @ByRef Color3B color, int opacity, @StdString String filePath);

    public native static RichElementImage create(int tag, @ByRef Color3B color, int opacity, @StdString String filePath);
}
