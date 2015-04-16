package org.ccj;

import org.ccj.d2.LayerColor;
import org.ccj.d2.Node;
import org.ccj.d2.Sprite;
import org.ccj.d2.action.*;
import org.ccj.base.Color4B;
import org.ccj.base.Touch;
import org.ccj.event.EventTouch;
import org.ccj.math.Vec2;

/**
 * @author touchsnow
 * @time 2014.04.18
 */
public class ClickAndMoveTest extends TestScene {

    static int TAG_SPRITE = 1;

    public Class[] getLayers() {
        return new Class[]{MoveTest.class};
    }

    static public class MoveTest extends TestLayer {

        @Override
        public void onCreate() {
            super.onCreate();

            setTouchEnabled(true);

            System.out.println("ClickAndMoveTest");
            Sprite sprite = Sprite.create(s_pathGrossini);

            LayerColor layer = LayerColor.create(new Color4B(255, 255, 0, 100));
            this.addChild(layer, -1);

            this.addChild(sprite, 0, TAG_SPRITE);
            sprite.setPosition(20, 150);

            sprite.runAction(JumpTo.create(4, new Vec2(300, 48), 100, 4));

            FadeIn fadeIn = FadeIn.create(1);
            FadeOut fadeOut = FadeOut.create(1);
            RepeatForever forever = RepeatForever.create(Sequence.create(fadeIn, fadeOut));
            layer.runAction(forever);
        }

        public boolean onTouchBegan(Touch touch, EventTouch event) {
            Vec2 point = touch.getStartLocationInView();
            System.out.println("point==" + point);
            // point = new Vec2(200, 300);
            moveSprite(point.getX(), point.getY());
            System.out.println("onTouchBegan==" + point.getX());
            return super.onTouchBegan(touch,event );
        }

        public void moveSprite(float x, float y) {
            Node sprite = this.getChildByTag(TAG_SPRITE);
            sprite.stopAllActions();
            sprite.runAction(MoveTo.create(1, new Vec2(x, y)));
            float o = x - sprite.getPosition().getX();
            float a = y - sprite.getPosition().getY();
            float at = (float) (Math.atan(o / a) * 57.29577951);  // radians to degrees

            if (a < 0) {
                if (o < 0)
                    at = 180 + Math.abs(at);
                else
                    at = 180 - Math.abs(at);
            }

            sprite.runAction(RotateTo.create(1, at));
        }
    }
}
