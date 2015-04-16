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
public interface EventHandlerCustom
{
    public void onCustom(String eventName, Event event);
}
