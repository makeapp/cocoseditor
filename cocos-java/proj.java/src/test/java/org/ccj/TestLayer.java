/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj;

import org.ccj.d2.LayerGradient;
import org.ccj.base.Color3B;
import org.ccj.math.Size;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/4/14 13:00 $
 *          $Id$
 */
public class TestLayer
    extends LayerGradient
{
    protected Size winSize = Director.getInstance().getWinSize().fetch();

    public String getTitle()
    {
        return "";
    }

    public String getSubTitle()
    {
        return "";
    }

    private boolean created = false;

    public TestLayer()
    {
        setStartColor(new Color3B(0, 0, 0));
        setEndColor(new Color3B(0x46, 0x82, 0xB4));
    }

    public void onCreate()
    {

    }

    public void onEnter()
    {
        if (!created) {
            onCreate();
            created = true;
        }
        super.onEnter();
    }
}
