/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj;

import org.ccj.d2.Animation;
import org.ccj.d2.AnimationCache;
import org.ccj.d2.Sprite;
import org.ccj.d2.action.Animate;
import org.ccj.d2.action.Sequence;
import org.ccj.math.Size;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-3-5 上午10:44 $
 *          $Id$
 */
public class ActionsTestScene extends TestScene
{
    static int SPRITE_GROSSINI_TAG = 1;
    static int SPRITE_TAMARA_TAG = 2;
    static int SPRITE_KATHIA_TAG = 3;

    public Class[] getLayers()
    {
        return new Class[]{ActionAnimate.class};
    }

    static public class ActionsDemo extends TestLayer
    {
        Sprite _grossini,
            _tamara,
            _kathia;

        @Override
        public void onCreate()
        {
            super.onCreate();

            this._grossini = Sprite.create(s_pathGrossini);
            this._tamara = Sprite.create(s_pathSister1);
            this._kathia = Sprite.create(s_pathSister2);
            this.addChild(this._grossini, SPRITE_GROSSINI_TAG);
            this.addChild(this._tamara, SPRITE_TAMARA_TAG);
            this.addChild(this._kathia, SPRITE_KATHIA_TAG);
            Size s = Director.getInstance().getWinSize().fetch();
            this._grossini.setPosition(s.width / 2, s.height / 3);
            this._tamara.setPosition(s.width / 2, 2 * s.height / 3);
            this._kathia.setPosition(s.width / 2, s.height / 2);
        }
    }

    static public class ActionManual extends TestLayer
    {
        @Override
        public void onCreate()
        {
            super.onCreate();
        }
    }

    static public class ActionAnimate extends ActionsDemo
    {
        @Override
        public void onCreate()
        {
            super.onCreate();

            //
            // Manual animation
            //
            Animation animation = Animation.create();
            for (int i = 1; i < 15; i++) {
                String frameName = "Images/grossini_dance_" + ((i < 10) ? ("0" + i) : i) + ".png";
                animation.addSpriteFrameWithFile(frameName);
            }
            animation.setDelayPerUnit(2.8f / 14);
            animation.setRestoreOriginalFrame(true);

            Animate action = Animate.create(animation);
            this._grossini.runAction(Sequence.create(action, action.reverse()));

//
//                    //
//                    // File animation
//                    //
//                    // With 2 loops and reverse
            AnimationCache animCache = AnimationCache.getInstance();
//
            animCache.addAnimationsWithFile(s_animations2Plist);
            Animation animation2 = animCache.getAnimation("dance_1");
//
            Animate action2 = Animate.create(animation2);
            this._tamara.runAction(Sequence.create(action2, action2.reverse()));
//
//                    //
//                    // File animation
//                    //
//                    // with 4 loops
            Animation animation3 = animation2.clone();
            animation3.setLoops(4);
//
            Animate action3 = Animate.create(animation3);
            this._kathia.runAction(action3);
        }

        public String getTitle()
        {
            return "Animation";
        }

        public String getSubTitle()
        {
            return "Center: Manual animation. Border: using file format animation";
        }
    }
}
