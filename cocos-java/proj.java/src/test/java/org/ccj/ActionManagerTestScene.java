
package org.ccj;

import org.ccj.d2.Label;
import org.ccj.d2.Node;
import org.ccj.d2.Sprite;
import org.ccj.d2.action.*;
import org.ccj.math.Vec2;
import org.ccj.math.Size;
import org.ccj.particle.ParticleSnow;
import org.ccj.particle.ParticleSun;

import java.util.HashMap;

/**
 * @author touchsnow
 * @time 2014.04.17
 */

public class ActionManagerTestScene
        extends TestScene {

    static int TAG_NODE = 5560;
    static int TAG_GROSSINI = 5561;
    static int TAG_SEQUENCE = 5562;

    static int ActionMgrTestIdx = -1;
    static String NOT_CRASHED_CONST = "NOT_CRASHED";

    public Class[] getLayers() {
        return new Class[]{BaseTest.class,
                CrashTest.class, LogicTest.class, PauseTest.class,
                RemoveTest.class, ResumeTest.class, BaseTest.class};
    }


    /**
     * Test1
     */
    static public class CrashTest extends TestLayer {

        public String getTitle() {
            return "Test 1. Should not crash";
        }

        public void onCreate() {
            super.onCreate();
            System.out.println("CrashTest==");
            final Sprite child = Sprite.create(s_pathGrossini);
            child.setPosition(200, 200);
            this.addChild(child, 1);

            //Sum of all action's duration is 1.5 second.
            child.runAction(RotateBy.create(1.5f, 90));
            //  child.runAction(Sequence.create(DelayTime.create(1.4f), FadeOut.create(1.1f)));

            //After 1.5 second, self will be removed.
            this.runAction(Sequence.create(
                    DelayTime.create(1.4f),
                    new CallFunc() {
                        @Override
                        public void execute() {
                            super.execute();
                            onRemoveThis(child);
                        }
                    }
            ));

            ActionManagerTestScene testScene = new ActionManagerTestScene();
            testScene.labelTitle.setString("l am testing");
        }

        public void onRemoveThis(Sprite child) {
            System.out.println("onRemoveThis");
            child.removeFromParent();

            ActionManagerTestScene testScene = new ActionManagerTestScene();
            System.out.println("testScene.index1==" + testScene.index);
            testScene.index++;
            System.out.println("testScene.index2==" + testScene.index);
//            testScene.onClicked(testScene.item3);
            TestLayer current = testScene.getLayer(1);
            if (current != null) {
                current.removeFromParent();
            }
            addChild(current);

            if (testScene.labelTitle != null) {
                testScene.labelTitle.setString(current.getTitle());
                System.out.println("getitle==" + current.getTitle());
            }
        }

    }

    /**
     * Test2
     */
    static public class LogicTest extends TestLayer {
        public String getTitle() {
            return "Logic Test";
        }

        public void onCreate() {
            super.onCreate();

            final Sprite grossini = Sprite.create(s_pathGrossini);
            this.addChild(grossini, 0, 2);
            grossini.setPosition(200, 200);

            grossini.runAction(Sequence.create(
                            MoveBy.create(1, new Vec2(150, 0)),
                            new CallFunc() {
                                @Override
                                public void execute() {
                                    super.execute();
                                    onBugMe();
                                }
                            }
                    )
            );
        }

        public void onBugMe() {
            this.stopAllActions();
            this.runAction(ScaleTo.create(2, 2));
        }
    }

    /**
     * PauseTest
     */
    static public class PauseTest extends TestLayer {
        public String getTitle() {
            return "Pause Test";
        }

        public void onCreate() {
            super.onCreate();
            Size s = Director.getInstance().getWinSize().fetch();

            final Label l = Label.createWithSystemFont("After 3 seconds grossini should move", "Thonburi", 16);
            this.addChild(l);
            l.setPosition(s.width / 2, 245);

            //  l.setString("l am testing");


            //
            // Also, this test MUST be done, after [super onEnter]
            //
            Sprite grossini = Sprite.create(s_pathGrossini);
            this.addChild(grossini, 0, TAG_GROSSINI);
            grossini.setPosition(200, 200);

            MoveBy action = MoveBy.create(1, new Vec2(150, 0));

            // cc.Director.getActionManager.addAction(action, grossini, true);

            this.schedule(new Scheduler.SchedulerCallback() {
                @Override
                public void onUpdate(float delta) {
                    System.out.println("schedule");
                    l.setString("schedule per 2s");
                }
            }, 2);

            scheduleOnce(new Scheduler.SchedulerCallback() {
                @Override
                public void onUpdate(float delta) {
                    System.out.println("scheduleOnce after 5 s");
                }
            }, 5);

            grossiniData gros = new grossiniData();
            grossini.setUserData(gros);
            HashMap<String, grossiniData> map = new HashMap<String, grossiniData>();
            map.put("gros", gros);

            map.get("gros").setPos(200);

            System.out.println("ss==" + map.get("gros").pos);

            /*grossiniData gr=(grossiniData) grossini.getUserData();
            System.out.println("name=="+gr.name);*/

        }

        class grossiniData {
            String name = "grossini";
            int pos = 100;

            public void setPos(int pos) {
                this.pos = pos;
            }
        }
    }

    /**
     * RemoveTest
     */
    static public class RemoveTest extends TestLayer {
        public String getTitle() {
            return "Remove Test";
        }

        public void onCreate() {
            super.onCreate();
            Size s = Director.getInstance().getWinSize().fetch();
            Label l = Label.createWithSystemFont("Should not crash", "Thonburi", 16);
            this.addChild(l);
            l.setPosition(s.width / 2, 245);

            MoveBy move = MoveBy.create(2, new Vec2(200, 0));
            //  CallFunc callback = CallFunc.create(this.stopAction(), this);
            Sequence sequence = Sequence.create(move);
            sequence.setTag(TAG_SEQUENCE);

            Sprite child = Sprite.create(s_pathGrossini);
            child.setPosition(200, 200);

            this.addChild(child, 1, TAG_GROSSINI);
            child.runAction(sequence);
        }

        public void stopAction() {
            Sprite sprite = (Sprite) this.getChildByTag(TAG_GROSSINI);
            sprite.stopActionByTag(TAG_SEQUENCE);
        }
    }

    /**
     * ResumeTest
     */
    static public class ResumeTest extends TestLayer {
        public String getTitle() {
            return "Resume Test";
        }

        public void onCreate() {
            super.onCreate();
            Size s = Director.getInstance().getWinSize().fetch();
            Label l = Label.createWithSystemFont("Grossini only rotate/scale in 3 seconds", "Thonburi", 16);
            this.addChild(l);
            l.setPosition(s.width / 2, 245);

            Sprite grossini = Sprite.create(s_pathGrossini);
            this.addChild(grossini, 0, TAG_GROSSINI);
            grossini.setPosition(s.width / 2, s.height / 2);
            grossini.runAction(ScaleBy.create(2, 2));

            //   cc.Director.getInstance().getActionManager().pauseTarget(grossini);
            grossini.runAction(RotateBy.create(2, 360));

            this.schedule(this.resumeGrossini(), 3.0f);
        }

        public Scheduler.SchedulerCallback resumeGrossini() {
            Sprite grossini = (Sprite) this.getChildByTag(TAG_GROSSINI);
            // director.getActionManager().resumeTarget(grossini);
            return null;
        }
    }

    static public class BaseTest extends TestLayer {
        public String getTitle() {
            return "Test";
        }

        public void onCreate() {

            setTouchEnabled(true);

            ParticleSnow snow = ParticleSnow.create();
            this.addChild(snow);

            ParticleSun sun = ParticleSun.create();
            this.addChild(sun);

            sun.runAction(MoveTo.create(1.0f, new Vec2(100, 100)));
            /*LocalStorage.getInstance().localStorageSetItem("test",100+"");
            UserDefault.getInstance().setBoolForKey("test1",true);
            Button btn=Button.create();
            btn.set*/
//            SceneReader scene = SceneReader.getInstance();

          //  Node node = scene.createNodeWithSceneFile("scenetest/ZuoWenFishTest/publish/FishScene.json");
//            Node node=scene.createNodeWithSceneFile("scenetest/LoadSceneEdtiorFileTest/FishJoy2.json");
//            this.addChild(node);
            // ccs.actionManager.playActionByName("startMenu_1.json", "Animation1");
            // this.initSize(node);

        }

    /*    public void initSize(Ndoe node) {
            *//*float scale = winSize.height / 320;
            node.set = scale;*//*
            *//*node.x = (winSize.width - 480 * scale) / 2;
            node.y = (winSize.height - 320 * scale) / 2;*//*
        }*/

    }

}
