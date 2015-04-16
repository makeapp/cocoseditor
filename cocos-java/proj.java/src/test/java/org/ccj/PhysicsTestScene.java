package org.ccj;

import java.util.HashMap;
import java.util.Map;

import org.ccj.d2.Node;
import org.ccj.d2.Sprite;
import org.ccj.d2.SpriteBatchNode;
import org.ccj.d2.Texture2D;
import org.ccj.base.Touch;
import org.ccj.event.Event;
import org.ccj.math.Vec2;
import org.ccj.math.Rect;
import org.ccj.math.Size;
import org.ccj.base.VectorPhysicsShape;
import org.ccj.physics.*;

/**
 * Created by yuanyou@makeapp.co on 2014/4/19.
 */
public class PhysicsTestScene extends TestScene
{
    public static final int DRAG_BODYS_TAG = 1;

    public void onCreate()
    {
        super.onCreate();
        initWithPhysics();
    }

    public Class[] getLayers()
    {
        return new Class[]{PhysicsDemoPyramidStack.class};
    }

    static public class PhysicsDemo extends TestLayer
    {

        Texture2D _spriteTexture;

        Scene scene;
        Map _mouses = new HashMap();

        public void onCreate()
        {
            super.onCreate();
            setTouchEnabled(true);

            scene = Scene.cast(getParent());

            setTouchMode(Touch.MODE_ONE_BY_ONE);
            _spriteTexture = SpriteBatchNode.create("Images/grossini_dance_atlas.png", 100).getTexture();
        }

        Sprite addGrossiniAtPosition(Vec2 p, float scale/* = 1.0*/)
        {
            int idx = (int) (Math.random() * 14);
            int x = (idx % 5) * 85;
            int y = (0 | (idx / 5)) * 121;

            Sprite sp = Sprite.create(s_grossini_dance_atlas, new Rect(x, y, 85, 121));
            sp.setScale(scale);
            PhysicsBody physicsBody = PhysicsBody.createBox(new Size(48.0f * scale, 108.0f * scale));
            physicsBody.setCategoryBitmask(0x02);    // 0010
            physicsBody.setContactTestBitmask(0x08); // 1000
            physicsBody.setCollisionBitmask(0x01);   // 0001

            physicsBody.setCategoryBitmask(0x08);    // 1000
            physicsBody.setContactTestBitmask(0x02); // 0010
            physicsBody.setCollisionBitmask(0x01);   // 0001

            sp.setPhysicsBody(physicsBody);
            this.addChild(sp);
            sp.setPosition(p);

            return sp;
        }

        public boolean onTouchBegan(Touch touch, Event event)
        {
            Vec2 location = touch.getLocation();
            VectorPhysicsShape shapes = scene.getPhysicsWorld().getShapes(location);

            PhysicsBody body = null;
            System.out.println("size " + shapes.size());
            for (int i = 0; i < shapes.size(); i++) {
                PhysicsShape obj = shapes.get(i);

                if ((obj.getBody().getTag() & DRAG_BODYS_TAG) != 0) {
                    body = obj.getBody();
                    break;
                }
            }

            if (body != null) {
                Node mouse = Node.create();
                mouse.setPhysicsBody(PhysicsBody.create(1000, 1000));
                mouse.getPhysicsBody().setDynamic(false);
                mouse.setPosition(location);
                this.addChild(mouse);
                PhysicsJointPin joint = PhysicsJointPin.construct(mouse.getPhysicsBody(), body, location);
                joint.setMaxForce(5000.0f * body.getMass());
                joint.setCollisionEnable(true);
                scene.getPhysicsWorld().addJoint(joint);
                _mouses.put(touch.getID(), mouse);
                return true;
            }

            return false;
        }

        public void onTouchMoved(Touch touch, Event event)
        {
            super.onTouchMoved(touch, event);

            Node it = (Node) _mouses.get(touch.getID());
            it.setPosition(touch.getLocation());
//
//                if (it != _mouses.end())
//                {
//                    it->second->setPosition(touch->getLocation());
//                }
        }

        public void onTouchEnded(Touch touch, Event event)
        {
            super.onTouchEnded(touch, event);


            Node it = (Node) _mouses.get(touch.getID());
//
            if (it != null) {
                removeChild(it, true);
                _mouses.remove(it);
            }
        }
    }

    static public class PhysicsDemoPyramidStack extends PhysicsDemo
    {
        @Override
        public void onCreate()
        {
            super.onCreate();
            scene.addPhysicsContactListener(new PhysicsContactListener()
            {
                {
                    regContactBegin();
                    regContactPostSolve();
                    regContactPreSolve();
                    regContactSeperate();
                }

                public boolean onContactBegin(PhysicsContact contact)
                {
                    PhysicsShape shapeA = contact.getShapeA();
                    PhysicsShape shapeB = contact.getShapeB();

                    super.onContactBegin(contact);
                    return false;
                }

                public boolean onContactPreSolve(PhysicsContact contact, PhysicsContactPreSolve solve)
                {
                    return super.onContactPreSolve(contact, solve);
                }

                public void onContactPostSolve(PhysicsContact contact, PhysicsContactPostSolve solve)
                {
                    super.onContactPostSolve(contact, solve);
                }

                public void onContactSeperate(PhysicsContact contact)
                {
                    super.onContactSeperate(contact);
                }
            });
            scene.getPhysicsWorld().setDebugDrawMask(PhysicsWorld.DEBUGDRAW_ALL);

            Node node = Node.create();
            Vec2 p1 = VisibleRect.bottomLeft().plus(new Vec2(0, 50));
            Vec2 p2 = VisibleRect.bottomRight().plus(new Vec2(0, 50));

            System.out.println("p1" + p1);
            System.out.println("p2" + p2);

            PhysicsMaterial material = new PhysicsMaterial(0.1f, 1, 0.0f);

            node.setPhysicsBody(PhysicsBody.createEdgeSegment(p1, p2));
            this.addChild(node);

            final Sprite ball = Sprite.create("Images/ball.png");
            ball.setScale(1);
            ball.setTag(100);
            PhysicsBody physicsBody = PhysicsBody.createCircle(10);

            ball.setPhysicsBody(physicsBody);
            physicsBody.setTag(DRAG_BODYS_TAG);
            physicsBody.setCategoryBitmask(0x02);    // 0010
            physicsBody.setContactTestBitmask(0x08); // 1000
            physicsBody.setCollisionBitmask(0x01);   // 0001

            ball.setPosition(VisibleRect.bottom().plus(new Vec2(0, 60)));
            this.addChild(ball);
            this.scheduleOnce(new Scheduler.SchedulerCallback()
            {
                public void onUpdate(float delta)
                {
                    super.onUpdate(delta);
                    ball.setScale(ball.getScale() * 3);
                    PhysicsBody physicsBody = PhysicsBody.createCircle(30);
                    physicsBody.setCategoryBitmask(0x02);    // 0010
                    physicsBody.setContactTestBitmask(0x08); // 1000
                    physicsBody.setCollisionBitmask(0x01);   // 0001
                    ball.setPhysicsBody(physicsBody);
                    ball.getPhysicsBody().setTag(DRAG_BODYS_TAG);
                }
            }, 3);
            for (int i = 0; i < 14; i++) {
                for (int j = 0; j <= i; j++) {
                    Vec2 p = new Vec2((i / 2 - j) * 11, (14 - i) * 23 + 100);
                    Sprite sp = addGrossiniAtPosition(VisibleRect.bottom().plus(p), 0.2f);
                    sp.getPhysicsBody().setTag(DRAG_BODYS_TAG);
                }
            }

        }
    }


    static public class PhysicsContactTest extends TestLayer
    {

        public void onEnter()
        {
            super.onEnter();


        }
    }
}
