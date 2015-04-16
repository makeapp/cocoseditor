/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj;

import org.ccj.network.HttpClientScene;
import org.ccj.network.WebSocketTest;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/4/14 12:29 $
 *          $Id$
 */
public class ExtensionsMainScene
    extends TestMenuScene
{
    public TestMenuLayer.MenuData[] getMenuData()
    {
        return new TestMenuLayer.MenuData[]{
//            new TestMenuLayer.MenuData("CCControlButtonTest", ControlButtonScene.class, true),
//            new TestMenuLayer.MenuData("CocosBuilderTest", CocosBuilderTestScene.class, true),
//            new TestMenuLayer.MenuData("TableViewTest", ArmatureTestScene.class, true),
//            new TestMenuLayer.MenuData("EditBoxTest", ArmatureTestScene.class, true),
            new TestMenuLayer.MenuData("WebSocketTest", WebSocketTest.class, true),
            new TestMenuLayer.MenuData("HttpClientTest", HttpClientScene.class, true)
        };
    }
}
