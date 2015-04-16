/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.ui;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/4/19 11:34 $
 *          $Id$
 */

@Platform(include = "ui/UIHelper.h")
@Namespace("cocos2d::ui")
@com.googlecode.javacpp.annotation.Opaque
public class Helper extends Pointer
{
    /**
     * Finds a widget whose tag equals to param tag from root widget.
     *
     * @param root widget which will be seeked.
     *
     * @return finded result.
     *
     * @tag tag value.
     */
    public native static Widget seekWidgetByTag(Widget root, int tag);

    /**
     * Finds a widget whose name equals to param name from root widget.
     *
     * @param root widget which will be seeked.
     *
     * @return finded result.
     *
     * @name name value.
     */
    public native static Widget seekWidgetByName(Widget root, String name);

    /*temp action*/
    public native static Widget seekActionWidgetByActionTag(Widget root, int tag);
}
