/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/4/14 12:29 $
 *          $Id$
 */
public class TestMenuScene
    extends TestScene
{
    public int getLayersCount()
    {
        return 1;
    }

    public TestLayer getLayer(int idx)
    {
        return new TestMenuSceneLayer();
    }

    public boolean hasNavigation()
    {
        return false;
    }

    public TestMenuLayer.MenuData[] getMenuData()
    {
        return new TestMenuLayer.MenuData[0];
    }

    class TestMenuSceneLayer extends TestMenuLayer
    {
        public MenuData[] getMenuData()
        {
            return TestMenuScene.this.getMenuData();
        }
    }
}
