/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj;

import org.ccj.d2.Menu;
import org.ccj.d2.MenuItem;
import org.ccj.d2.MenuItemFont;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/4/17 13:13 $
 *          $Id$
 */
public class TestMenuLayer extends TestLayer
{
    int LINE_SPACE = 40;
    int ITEM_TAG_BASIC = 1000;

    public MenuData[] getMenuData()
    {
        return new MenuData[0];
    }

    public void onCreate()
    {
        super.onCreate();
        Menu pMenu = Menu.create();
        pMenu.setPosition(0, 0);
        MenuItemFont.setFontName("Arial");
        MenuItemFont.setFontSize(24);
        MenuData[] datas = getMenuData();
        for (int i = 0; i < datas.length; ++i) {
           final MenuData data = datas[i];
            MenuItemFont pItem = MenuItemFont.create(data.name);
            if (data.ready) {
                pItem.setOnClickListener(new MenuItem.MenuItemListener()
                {
                    public void onClicked(MenuItem item)
                    {
                        Scene scene= null;
                        try {
                            scene = (Scene)data.sceneClass.newInstance();
                            Director.getInstance().pushScene(scene);
                        }
                        catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
            pItem.setTag(i);
            pItem.setPosition(winSize.getWidth() / 2, winSize.getHeight() - (i + 1) * LINE_SPACE);
            pMenu.addChild(pItem, ITEM_TAG_BASIC + i);
        }
        this.addChild(pMenu);
    }

   public static class MenuData
    {
        String name;

        boolean ready;

        Class sceneClass;

        public MenuData(String name, Class testLayer, boolean ready)
        {
            this.name = name;
            this.sceneClass = testLayer;
            this.ready = ready;
        }
    }
}
