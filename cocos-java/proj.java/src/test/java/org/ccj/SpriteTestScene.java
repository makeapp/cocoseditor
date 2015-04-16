/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj;

import org.ccj.d2.Sprite;
import org.ccj.editor.cce.CCEReader;
import org.ccj.d2.action.*;
import org.ccj.math.Vec2;
import org.ccj.math.Rect;
import org.ccj.physics.PhysicsWorld;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-3-5 上午10:44 $
 *          $Id$
 */
public class SpriteTestScene
    extends TestScene
    implements TestResource
{
    public void onCreate()
    {
        super.onCreate();
        initWithPhysics();
        getPhysicsWorld().setDebugDrawMask(PhysicsWorld.DEBUGDRAW_ALL);
    }

    public int getLayersCount()
    {
        return 1;
    }

    public TestLayer getLayer(int idx)
    {
        return new SpriteReaderTestLayer();
    }


    class SpriteTestLayer extends TestLayer
    {
        public void onEnter()
        {

            Vec2 p = new Vec2(winSize.getWidth() / 2, winSize.getHeight() / 2);

            int idx = (int) (Math.random() * 14);
            int x = (idx % 5) * 85;
            int y = (0 | (idx / 5)) * 121;

            Sprite sprite = Sprite.create(s_grossini_dance_atlas, new Rect(x, y, 85, 121));
            addChild(sprite);
            sprite.setPosition(p.getX(), p.getY());

            Sprite sprite2 = Sprite.create(s_grossini_dance_atlas, new Rect(x, y, 85, 121));
            addChild(sprite2);
            sprite2.setPosition(p.getX()+120, p.getY());

            System.out.println("sprite1 "+sprite.getBoundingBox() +" " +sprite.getBoundingBox().containsPoint(new Vec2(p.getX()+20, p.getY())));
            System.out.println("sprite2 "+sprite2.getBoundingBox());

            FiniteTimeAction action;
            int random = (int) Math.random();
            if (random < 0.20) {
                action = ScaleBy.create(3, 2);
            }
            else if (random < 0.40) {
                action = RotateBy.create(3, 360);
            }
            else if (random < 0.60) {
                action = Blink.create(1, 3);
            }
            else if (random < 0.8) {
                action = TintBy.create(2, 0, -255, -255);
            }
            else {
                action = FadeOut.create(2);
            }

            FiniteTimeAction action_back = action.reverse();

            ActionInterval seq = Sequence.create(action, action_back);
            sprite.runAction(seq);
        }
    }

    class SpriteReaderTestLayer extends TestLayer
    {
        public void onEnter()
        {
            CCEReader spriteReader= CCEReader.create();
            Sprite sprite= spriteReader.readSprite("sprite/sprite1.xml");
            sprite.setPosition(VisibleRect.center());
            addChild(sprite);

        }
    }
}
