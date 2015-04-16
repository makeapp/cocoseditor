/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.event;

import org.ccj.base.Acceleration;
import org.ccj.base.Touch;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/4/21 15:53 $
 *          $Id$
 */
public interface EventHandlerKeyboard
{
    /**
     * @js NA
     */
    public void onKeyPressed(int keyCode, Event event);

    /**
     * @js NA
     */
    public void onKeyReleased(int keyCode, Event event);

}
