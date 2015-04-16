package org.ccj;

import java.util.HashMap;
import java.util.Map;

import org.ccj.d2.Sprite;
import org.ccj.base.Touch;
import org.ccj.event.Event;

/**
 * Created by yuanyou@makeapp.co on 2014/4/19.
 */
public class MutiTouchTest extends TestScene
{

    public Class[] getLayers()
    {
        return new Class[]{MutiTouchTestLayer.class};
    }

    static public class MutiTouchTestLayer extends TestLayer
    {
        Map<Integer, Sprite> nodes = new HashMap();

        @Override
        public void onEnter()
        {
            super.onCreate();
            setTouchMode(Touch.MODE_ALL_AT_ONCE);
            setTouchEnabled(true);
        }

        public void onTouchesBegan(Touch[] touches, Event event)
        {
            super.onTouchesBegan(touches, event);
            for (Touch t : touches) {
                Sprite ball = Sprite.create("Images/ball.png");
//                DrawNode touchNode = new DrawNode();
//                touchNode.setContentSize(getContentSize());
//                touchNode.setAnchorPoint(0, 0);
//                touchNode.setPosition(t.getLocation());
//                touchNode.drawDot(new Vec2(10, 10), 5,new Color4F(1f, 0.5f, 0f, 1f));
                ball.setPosition(t.getLocation());
                addChild(ball);
                nodes.put(t.getID(), ball);
            }
        }

        public void onTouchesMoved(Touch[] touches, Event event)
        {
            super.onTouchesMoved(touches, event);
            for (Touch t : touches) {
                Sprite touchNode = nodes.get(t.getID());
                if (touchNode != null) {
                    touchNode.setPosition(t.getLocation());
                }
            }
        }

        public void onTouchesEnded(Touch[] touches, Event event)
        {
            super.onTouchesEnded(touches, event);
            nodes.clear();
            removeAllChildren();
        }

        public void onTouchesCancelled(Touch[] touches, Event event)
        {
            super.onTouchesCancelled(touches, event);
            nodes.clear();
            removeAllChildren();
        }
    }
}
