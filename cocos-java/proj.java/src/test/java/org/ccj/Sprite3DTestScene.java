/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj;

import org.ccj.d2.action.CallFunc;
import org.ccj.d2.action.MoveBy;
import org.ccj.d2.action.MoveTo;
import org.ccj.d2.action.RepeatForever;
import org.ccj.d2.action.RotateBy;
import org.ccj.d2.action.Sequence;
import org.ccj.d3.Animate3D;
import org.ccj.d3.Animation3D;
import org.ccj.d3.Sprite3D;
import org.ccj.math.Size;
import org.ccj.math.Vec2;
import org.ccj.math.Vec3;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-3-5 上午10:44 $
 *          $Id$
 */
public class Sprite3DTestScene
    extends TestScene
    implements TestResource
{
    public int getLayersCount()
    {
        return 2;
    }

    public TestLayer getLayer(int idx)
    {
        if (idx == 0) {
            return new SpriteTestLayer();
        }
        else {
            return new Sprite3dTestLayer();
        }
    }


    class SpriteTestLayer extends TestLayer
    {
        public void onEnter()
        {
            Sprite3D model = Sprite3D.create("Sprite3DTest/boss1.obj", "Sprite3DTest/boss.png");
            model.setPosition(VisibleRect.center());
            model.setScale(20f);
            addChild(model);


//            ScaleBy   action = ScaleBy.create(3, 2);
//            TintBy action = TintBy.create(2, 0, -255, -255);
            RotateBy action = RotateBy.create(3, 360);
            model.runAction(RepeatForever.create(action));
        }
    }

    class Sprite3dTestLayer extends TestLayer
    {
        public void onEnter()
        {
            String fileName = "Sprite3DTest/tortoise.c3b";
            final Sprite3D sprite = Sprite3D.create(fileName);
            sprite.setScale(0.1f);
            Size s = Director.getInstance().getWinSize().fetch();
            sprite.setPosition(new Vec2(s.width * 4.f / 5.f, s.height / 2.f));
            addChild(sprite);
            Animation3D animation = Animation3D.create(fileName);
            if (animation != null) {
                Animate3D animate = Animate3D.create(animation, 0.f, 1.933f);
                sprite.runAction(RepeatForever.create(animate));
//                   _swim = animate;
//                   _swim->retain();
                Animate3D _hurt = Animate3D.create(animation, 1.933f, 2.8f);
                _hurt.retain();
//                   _state = State::SWIMMING;
            }

            final MoveTo _moveAction = MoveTo.create(4.f, new Vec2(s.width / 5.f, s.height / 2.f));
            _moveAction.retain();
            Sequence seq = Sequence.create(_moveAction, new CallFunc()
            {
                public void execute()
                {
                    sprite.stopActionByTag(100);
                    MoveBy inverse = _moveAction.reverse();
                    inverse.retain();
                    _moveAction.release();
//                      _moveAction = inverse;
                    RotateBy rot = RotateBy.create(1.f, new Vec3(0f, 180f, 0f));
                    Sequence seq = Sequence.create(rot, _moveAction);
                    seq.setTag(100);
                    sprite.runAction(seq);
                }
            });
            seq.setTag(100);
            sprite.runAction(seq);
        }
    }
}
