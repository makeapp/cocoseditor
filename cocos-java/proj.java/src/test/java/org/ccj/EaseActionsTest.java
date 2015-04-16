package org.ccj;

import org.ccj.d2.Sprite;
import org.ccj.d2.action.*;
import org.ccj.math.Vec2;
import org.ccj.math.Size;

/**
 * @author touchsnow
 * @time 2014.04.19
 */
public class EaseActionsTest extends TestScene {

    public Class[] getLayers() {
        return new Class[]{
                SpriteEase.class,
//                SpriteEaseInOut.class,
//                SpriteEaseExponential.class,
//                SpriteEaseExponentialInOut.class,
//                SpriteEaseSine.class,
//                SpriteEaseSineInOut.class,
//                SpriteEaseElastic.class,
//                SpriteEaseElasticInOut.class,
//                SpriteEaseBounce.class,
//                SpriteEaseBounceInOut.class,
//                SpriteEaseBack.class,
//                SpriteEaseBackInOut.class,
//                SpeedTest.class,
//                SchedulerTest.class
        };
    }

    static public class EaseActionBase extends TestLayer{
        int TAG_ACTION1_EASE_ACTIONS = 1;
        int TAG_ACTION2_EASE_ACTIONS = 2;
        int TAG_SLIDER_EASE_ACTIONS = 1;

        int easeActionsTestIdx = -1;
        public Sprite _grossini, _tamara, _kathia;
        public String _code;
        public Size s;
        public boolean twoSprites;

        public void log(String name) {
            System.out.println("Java:" + name);
        }

        @Override
        public void onCreate() {
            super.onCreate();

            // Or you can create an sprite using a filename. PNG and BMP files are supported. Probably TIFF too
            this._grossini = Sprite.create(s_pathGrossini);
            this._tamara = Sprite.create(s_pathSister1);
            this._kathia = Sprite.create(s_pathSister2);

            this.addChild(this._grossini, 3);
            this.addChild(this._kathia, 2);
            this.addChild(this._tamara, 1);

            this._grossini.setPositionX(60);

            s = Director.getInstance().getWinSize().fetch();
            this._grossini.setPositionY(winSize.height / 5);
            this._kathia.setPositionX(60);
            this._kathia.setPositionY(winSize.height / 2);
            this._tamara.setPositionX(60);
            this._tamara.setPositionY(winSize.height * 4 / 5);

            this.twoSprites = false;
        }

        public void positionForTwo() {
            this.twoSprites = true;
            this._grossini.setPositionX(60);
            this._grossini.setPositionY(winSize.height / 5);
            this._tamara.setPositionX(60);
            this._tamara.setPositionY(winSize.height * 4 / 5);
            this._kathia.setVisible(false);
        }
    }

    /**
     * SpriteEase
     */
    static public class SpriteEase extends EaseActionBase {

        @Override
        public String getTitle() {
            return "EaseIn - EaseOut - Stop";
        }

        @Override
        public void onCreate() {
            super.onCreate();
            MoveBy move = MoveBy.create(2, new Vec2(winSize.width - 80, 0));
            MoveBy move_back = move.reverse();

            EaseIn move_ease_in = EaseIn.create(move.clone(), 2.0f);
            EaseIn move_ease_in_back = move_ease_in.reverse();

            EaseOut move_ease_out = EaseOut.create(move.clone(), 2.0f);
            EaseOut move_ease_out_back = move_ease_out.reverse();


            DelayTime delay = DelayTime.create(0.10f);

            Sequence seq1 = Sequence.create(move, delay, move_back, delay.clone());
            Sequence seq2 = Sequence.create(move_ease_in, delay.clone(), move_ease_in_back, delay.clone());
            Sequence seq3 = Sequence.create(move_ease_out, delay.clone(), move_ease_out_back, delay.clone());


            Action a2 = this._grossini.runAction(RepeatForever.create(seq1));
            a2.setTag(1);

            Action a1 = this._tamara.runAction(RepeatForever.create(seq2));
            a1.setTag(1);

            Action a = this._kathia.runAction(RepeatForever.create(seq3));
            a.setTag(1);

            this.scheduleOnce(new Scheduler.SchedulerCallback() {
                @Override
                public void onUpdate(float delta) {
                    //  testStopAction();
                }
            }, 4.1f);
        }

        public void testStopAction() {
            this._tamara.stopActionByTag(1);
            this._kathia.stopActionByTag(1);
            this._grossini.stopActionByTag(1);
        }
    }
}
