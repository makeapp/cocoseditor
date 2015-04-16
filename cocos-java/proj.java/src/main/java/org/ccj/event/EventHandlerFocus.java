/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.event;

import org.ccj.base.Acceleration;
import org.ccj.base.Touch;
import org.ccj.ui.Widget;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/4/21 15:53 $
 *          $Id$
 */
public interface EventHandlerFocus
{
    /**
     * @js NA
     */
    public void onFocusChanged(Widget src, Widget dest);

}
