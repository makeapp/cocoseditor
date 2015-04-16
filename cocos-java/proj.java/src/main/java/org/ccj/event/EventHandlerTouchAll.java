/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.event;

import org.ccj.base.Touch;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/4/21 15:53 $
 *          $Id$
 */
public interface EventHandlerTouchAll
{
    /**
     * @js NA
     */
    public void onTouchesBegan(Touch[] touches, Event event);

    /**
     * @js NA
     */
    public void onTouchesMoved(Touch[] touches, Event event);

    /**
     * @js NA
     */
    public void onTouchesEnded(Touch[] touches, Event event);

    /**
     * @js NA
     */
    public void onTouchesCancelled(Touch[] touches, Event event);

}
