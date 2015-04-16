/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj;

import org.ccj.d2.Label;
import org.ccj.d2.Layer;
import org.ccj.d2.Menu;
import org.ccj.d2.MenuItem;
import org.ccj.d2.MenuItemLabel;
import org.ccj.math.Size;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/4/6 14:47 $
 *          $Id$
 */
public class HelloWorld
{
    public static void main(String[] args)
    {
        System.out.println("Main");
//        eglView.init("game", 1024 / 2, 768 / 2);
        Application app = new Application()
        {
            public boolean applicationDidFinishLaunching()
            {
                System.out.println("applicationDidFinishLaunching");

                GLView eglView = GLView.create("CocosPlayer");
                eglView.setFrameSize(1024 / 2, 728 / 2);

                Layer layer = Layer.create();
                                Size winSize = Director.getInstance().getWinSize();
                                Menu itemMenu = Menu.create();
                                Label label = Label.createWithSystemFont("HelloWorld", "Arial", 24);
                                MenuItemLabel menuItem = MenuItemLabel.create(label);
                                itemMenu.addChild(menuItem);
                                menuItem.setPosition(winSize.getWidth() / 2, winSize.getHeight() / 2);
                                menuItem.setOnClickListener(new MenuItem.MenuItemListener()
                                {
                                    public void onClicked(MenuItem item)
                                    {
                                    }
                                });
                                itemMenu.setPosition(200, 200);
                                layer.addChild(itemMenu);
                                Scene scene = Scene.create();
                                scene.addChild(layer);


                Director director = Director.getInstance();
                director.setDisplayStats(true);
                director.setOpenGLView(eglView);
                eglView.setDesignResolutionSize(1024, 768, 2);

                director.runWithScene(scene);

                return true;
            }
        };
        app.run();
    }
}
