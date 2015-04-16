/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj;

import java.util.ArrayList;
import java.util.List;

import org.ccj.d2.Label;
import org.ccj.d2.Menu;
import org.ccj.d2.MenuItem;
import org.ccj.d2.MenuItemFont;
import org.ccj.d2.MenuItemImage;
import org.ccj.d2.MenuItemLabel;
import org.ccj.d2.MenuItemToggle;
//import org.ccj.d3.Hello3DTestScene;
import org.ccj.base.Touch;
import org.ccj.event.Event;
import org.ccj.math.Vec2;
import org.ccj.math.Size;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/4/14 10:42 $
 *          $Id$
 */
public class TestMainScene
    extends TestScene
{
    static List<TestData> testes = new ArrayList();

    public static int LINE_SPACE = 60;

    static {
        testes.add(new TestData("Sprite Test", SpriteTestScene.class, true));
        testes.add(new TestData("Physics Test", PhysicsTestScene.class, true));
        testes.add(new TestData("Parallax Test", ParallaxTestScene.class, true));
        testes.add(new TestData("Extensions Test", ExtensionsMainScene.class, true));
        testes.add(new TestData("MutiTouch", MutiTouchTest.class, true));
        testes.add(new TestData("Sprite3d Test", Sprite3DTestScene.class, true));
        testes.add(new TestData("Particle Test", ParticleTestScene.class, true));
//        testes.add(new TestData("3D Test", Hello3DTestScene.class, true));
//        testes.add(new TestData("ActionManager Test", ActionManagerTestScene.class, true));
//        testes.add(new TestData("Actions Test", ActionsTestScene.class, true));
//        testes.add(new TestData("Scheduler Test", SchedulerTestScene.class, true));
//        testes.add(new TestData("Box2D Test", SpriteTestScene.class, true));
//        testes.add(new TestData("Chipmunk Test", ChipmunkTestScene.class, true));
//        testes.add(new TestData("Click and Move Test", ClickAndMoveTest.class, true));
//        testes.add(new TestData("ClippingNode Test", ClippingNodeTest.class, true));
//        testes.add(new TestData("CocosDenshion Test", CocosDenshionTestScene.class, true));
//        testes.add(new TestData("CurrentLanguage Test", CurrentLanguageTest.class, true));
//        testes.add(new TestData("DrawPrimitives Test", DrawPrimitivesTest.class, true));
//        testes.add(new TestData("EaseActions Test", EaseActionsTest.class, true));
//        testes.add(new TestData("Event Test", EventTest.class, true));
//        testes.add(new TestData("Effects Test", EffectsTest.class, true));
//        testes.add(new TestData("Effects Advanced Test", EffectsAdvancedTest.class, true));
//        testes.add(new TestData("Font Test", FontTest.class, true));
//        testes.add(new TestData("Interval Test", IntervalTest.class, true));
//        testes.add(new TestData("Label Test", LabelTest.class, true));
//        testes.add(new TestData("Layer Test", LayerTest.class, true));
//        testes.add(new TestData("Menu Test", MenuTest.class, true));
//        testes.add(new TestData("MotionStreak Test", SpriteTestScene.class, true));
//        testes.add(new TestData("Node Test", SpriteTestScene.class, true));
//        testes.add(new TestData("OpenGL Test", OpenGLTestScene.class, true));
//        testes.add(new TestData("Particle Test", ParticleTestScene.class, true));
//        testes.add(new TestData("Performance Test", PerformanceTestScene.class, true));
//        testes.add(new TestData("ProgressActions Test", ProgressActionsTestScene.class, true));
//        testes.add(new TestData("RenderTexture Test", RenderTextureTestScene.class, true));
//        testes.add(new TestData("RotateWorld Test", RotateWorldTestScene.class, true));
//        testes.add(new TestData("Scene Test", SceneTestScene.class, true));
//        testes.add(new TestData("Spine Test", SpineTestScene.class, true));
//        testes.add(new TestData("Scale9Sprite Test", S9SpriteTestScene.class, true));
//        testes.add(new TestData("TextInput Test", TextInputTestScene.class, true));
//        testes.add(new TestData("TextureCache Test", TextureCacheTestScene.class, true));
//        testes.add(new TestData("TileMap Test", TileMapTestScene.class, true));
//        testes.add(new TestData("Touches Test", TouchesTestScene.class, true));
//        testes.add(new TestData("Transitions Test", TransitionsTestScene.class, true));
//        testes.add(new TestData("Unit Tests", UnitTestScene.class, true));
//        testes.add(new TestData("Sys Tests", SysTestScene.class, true));
//        testes.add(new TestData("cocos2d Java Presentation", PresentationScene.class, true));
//        testes.add(new TestData("XMLHttpRequest", XHRTestScene.class, true));
    }

    public int getLayersCount()
    {
        return 1;
    }

    public TestLayer getLayer(int idx)
    {
        return new TestMainLayer();
    }

    static class TestData
    {
        String name;

        boolean ready;

        Class testLayer;

        TestData(String name, Class testLayer, boolean ready)
        {
            this.name = name;
            this.testLayer = testLayer;
            this.ready = ready;
        }
    }

    class TestMainLayer extends TestLayer
        implements TestResource
    {
        Menu menu;

        public void onCreate()
        {
            setTouchMode(Touch.MODE_ONE_BY_ONE);
            setTouchEnabled(true);

            Size winSize = Director.getInstance().getWinSize();

            MenuItemImage closeItem = MenuItemImage.create(s_pathClose, s_pathClose);
            closeItem.setPosition(winSize.getWidth() - 30, winSize.getHeight() - 30);
            closeItem.setOnClickListener(new MenuItem.MenuItemListener()
            {
                public void onClicked(MenuItem item)
                {
                    Director.getInstance().popScene();
                }
            });

            MenuItemFont subItem1 = MenuItemFont.create("Automated Test: Off");
            subItem1.setFontSize(18);
            MenuItemFont subItem2 = MenuItemFont.create("Automated Test: On");
            subItem2.setFontSize(18);

            MenuItemToggle toggleAutoTestItem = MenuItemToggle.create();
            toggleAutoTestItem.addSubItem(subItem1);
            toggleAutoTestItem.addSubItem(subItem2);
            //                toggleAutoTestItem.setCallback(this.onToggleAutoTest, this);
            toggleAutoTestItem.setPosition(winSize.getWidth() - 90, 20);
            //                if( autoTestEnabled )
            toggleAutoTestItem.setSelectedIndex(1);

            menu = Menu.create();

            int i = 0;
            for (final TestData testData : testes) {
                MenuItemLabel menuItem = MenuItemLabel.create(Label.createWithSystemFont(testData.name, "Arial", 24));
                menuItem.setAnchorPoint(0.5f, 0.5f);
                menuItem.setPosition(winSize.getWidth() / 2, winSize.getHeight() - ((i + 1) * LINE_SPACE));
                if (testData.ready) {
                    menuItem.setOnClickListener(new MenuItem.MenuItemListener()
                    {
                        public void onClicked(MenuItem item)
                        {
                            Scene scene = null;
                            try {
                                scene = (Scene) testData.testLayer.newInstance();
                            }
                            catch (Exception e) {
                                e.printStackTrace();
                            }

                            Director.getInstance().pushScene(scene);
                        }
                    });
                }
                i++;
                menu.addChild(menuItem);
            }

            Menu menu1 = Menu.create();
            menu1.addChild(closeItem);
            menu1.addChild(toggleAutoTestItem);

            menu.setContentSize(new Size(winSize.getWidth(), (float) (testes.size() + 1) * LINE_SPACE));
            menu.setAnchorPoint(0.5f, 0.5f);
            menu.setPosition(0, 0);
            menu1.setPosition(0, 0);
            addChild(menu);
            addChild(menu1);
        }

        public boolean onTouchBegan(Touch touch, Event event)
        {
            Vec2 p = touch.getLocation();

            System.out.println("onTouchBegan " + p.getX() + " , " + p.getY());
            return true;
        }

        public void onTouchMoved(Touch touch, Event event)
        {
            Vec2 delta = touch.getDelta();
            Vec2 p = touch.getLocation();
//            System.out.println("p " + p.getX());
            this.moveMenu(delta);
        }

        public void moveMenu(Vec2 delta)
        {
            Vec2 current = this.menu.getPosition();

//            System.out.println("delta " + delta.getY());

            float cy = current.getY();
            float newY = cy + delta.getY() * 2;
            if (newY < 0)
                newY = 0;

            float maxHeight = (testes.size() + 1) * LINE_SPACE - winSize.getHeight();
            if (newY > maxHeight) {
                newY = maxHeight;
            }
            this.menu.setPosition(current.getX(), newY);
        }
    }
}
