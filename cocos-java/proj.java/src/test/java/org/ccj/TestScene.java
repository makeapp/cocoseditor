/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj;

import org.ccj.d2.Label;
import org.ccj.d2.Menu;
import org.ccj.d2.MenuItem;
import org.ccj.d2.MenuItemFont;
import org.ccj.d2.MenuItemImage;
import org.ccj.math.Size;


/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/4/14 14:07 $
 *          $Id$
 */
public abstract class TestScene
    extends Scene implements TestResource, MenuItem.MenuItemListener
{
    int index = 0;

    int BASE_TEST_MENUITEM_PREV_TAG = 1;
    int BASE_TEST_MENUITEM_RESET_TAG = 2;
    int BASE_TEST_MENUITEM_NEXT_TAG = 3;

    int BASE_TEST_MENU_TAG = 10;
    int BASE_TEST_TITLE_TAG = 11;
    int BASE_TEST_SUBTITLE_TAG = 12;

    public TestScene()
    {
        onCreate();
    }

    TestLayer current = null;
    Label labelTitle = null;
    Label subTitle = null;

    public void onCreate()
    {
        Size winSize = Director.getInstance().getWinSize();
        float winWidth = winSize.getWidth();
        float winHeight = winSize.getHeight();

        int size = getLayersCount();

        if (size > 0) {
            current = getLayer(index);
            if (current == null) {
                return;
            }
            addChild(current);

        }


        if (!this.getClass().isAssignableFrom(TestMainScene.class)) {
            Menu menu = Menu.create();

            MenuItemFont pItem = MenuItemFont.create("MainScene");
            pItem.setOnClickListener(new MenuItem.MenuItemListener()
            {
                public void onClicked(MenuItem item)
                {
                    Director.getInstance().popScene();
                }
            });
            menu.addChild(pItem);
            pItem.setPosition(winSize.getWidth() - 90, 20);

            if (size > 0 && current != null && hasNavigation()) {
                String t = current.getTitle();
                labelTitle = Label.createWithSystemFont(t, "Arial", 28);
                this.addChild(labelTitle, 100, BASE_TEST_TITLE_TAG);
                labelTitle.setPosition(winSize.getWidth() / 2, winSize.getHeight() - 50);

                String st = current.getSubTitle();
                if (st != null) {
                    subTitle = Label.createWithSystemFont(st.toString(), "Thonburi", 16);
                    this.addChild(subTitle, 101, BASE_TEST_SUBTITLE_TAG);
                    subTitle.setPosition(winWidth / 2, winHeight - 80);
                }

                MenuItemImage item1 = MenuItemImage.create(s_pathB1, s_pathB2);
                MenuItemImage item2 = MenuItemImage.create(s_pathR1, s_pathR2);
                MenuItemImage item3 = MenuItemImage.create(s_pathF1, s_pathF2);

                item1.setOnClickListener(this);
                item2.setOnClickListener(this);
                item3.setOnClickListener(this);

                item1.setTag(BASE_TEST_MENUITEM_PREV_TAG);
                item2.setTag(BASE_TEST_MENUITEM_RESET_TAG);
                item3.setTag(BASE_TEST_MENUITEM_NEXT_TAG);


                Size cs = item2.getContentSize();
                item1.setPosition(winWidth / 2 - cs.getWidth() * 2, cs.getHeight() / 2);
                item2.setPosition(winWidth / 2, cs.getHeight() / 2);
                item3.setPosition(winWidth / 2 + cs.getWidth() * 2, cs.getHeight() / 2);
                menu.addChild(item1);
                menu.addChild(item2);
                menu.addChild(item3);
            }
            menu.setPosition(0, 0);
            addChild(menu, 100);
        }
    }

    public void onEnter()
    {
        super.onEnter();
    }

    public void onExit()
    {
        super.onExit();
    }

    public boolean hasNavigation()
    {
        return true;
    }

    public int getLayersCount()
    {
        return getLayers().length;
    }

    public TestLayer getLayer(int idx)
    {
        try {
            return (TestLayer) getLayers()[idx].newInstance();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Class[] getLayers()
    {
        return new Class[0];
    }


    public void onClicked(MenuItem item)
    {
        if (item.getTag() == BASE_TEST_MENUITEM_PREV_TAG) {
            index--;
        }
        else if (item.getTag() == BASE_TEST_MENUITEM_NEXT_TAG) {
            index++;
        }
        else if (item.getTag() == BASE_TEST_MENUITEM_RESET_TAG) {

        }

        if (index <= 0) {
            index = 0;
        }

        if (index < getLayersCount()) {
            TestLayer current = getLayer(index);
            if (current != null) {
                current.removeFromParent();
            }
            addChild(current);

            if (labelTitle != null) {
                labelTitle.setString(current.getTitle());
            }
            else if (subTitle != null) {
                subTitle.setString(current.getSubTitle());
            }
        }
    }
}
