package org.ccj;

import org.ccj.d2.Node;
import org.ccj.d2.ParallaxNode;
import org.ccj.d2.Sprite;
import org.ccj.d2.TileMapAtlas;
import org.ccj.d2.action.MoveBy;
import org.ccj.d2.action.RepeatForever;
import org.ccj.d2.action.Sequence;
import org.ccj.base.Touch;
import org.ccj.event.Event;
import org.ccj.math.Vec2;

/**
 * Created by yuanyou@makeapp.co on 2014/4/19.
 */
public class ParallaxTestScene extends TestScene
{
    public static final int kTagNode = 0;

    public Class[] getLayers()
    {
        return new Class[]{Parallax1.class, Parallax2.class};
    }

    static public class Parallax1 extends TestLayer
        implements TestResource
    {
        @Override
        public void onCreate()
        {
            super.onCreate();

            // Top Layer, a simple image
            Sprite cocosImage = Sprite.create(s_Power);
            // scale the image (optional)
            cocosImage.setScale(2.5f);
            // change the transform anchor point to 0,0 (optional)
            cocosImage.setAnchorPoint(new Vec2(0, 0));


            // Middle layer: a Tile map atlas
            TileMapAtlas tilemap = TileMapAtlas.create(s_TilesPng, s_LevelMapTga, 16, 16);
            tilemap.releaseMap();

            // change the transform anchor to 0,0 (optional)
            tilemap.setAnchorPoint(new Vec2(0, 0));

            // Anti Aliased images
            tilemap.getTexture().setAntiAliasTexParameters();


            // background layer: another image
            Sprite background = Sprite.create(s_back);
            // scale the image (optional)
            background.setScale(1.5f);
            // change the transform anchor point (optional)
            background.setAnchorPoint(new Vec2(0, 0));


            // create a void node, a parent node
            ParallaxNode voidNode = ParallaxNode.create();

            // NOW add the 3 layers to the 'void' node

            // background image is moved at a ratio of 0.4x, 0.5y
            voidNode.addChild(background, -1, new Vec2(0.4f, 0.5f), Vec2.ZERO);

            // tiles are moved at a ratio of 2.2x, 1.0y
            voidNode.addChild(tilemap, 1, new Vec2(2.2f, 1.0f), new Vec2(0, -200));

            // top image is moved at a ratio of 3.0x, 2.5y
            voidNode.addChild(cocosImage, 2, new Vec2(3.0f, 2.5f), new Vec2(200, 800));


            // now create some actions that will move the 'void' node
            // and the children of the 'void' node will move at different
            // speed, thus, simulation the 3D environment
            MoveBy goUp = MoveBy.create(4, new Vec2(0, -500));
            MoveBy goDown = goUp.reverse();
            MoveBy go = MoveBy.create(8, new Vec2(-1000, 0));
            MoveBy goBack = go.reverse();
            Sequence seq = Sequence.create(goUp, go, goDown, goBack);
            voidNode.runAction((RepeatForever.create(seq)));

            addChild(voidNode);
        }

        public String getTitle()
        {
            return "Parallax: parent and 3 children";
        }
    }


    static public class Parallax2 extends TestLayer
        implements TestResource
    {
        public void onEnter()
        {
            super.onEnter();

            setTouchEnabled(true);
            setTouchMode(Touch.MODE_ONE_BY_ONE);

            // Top Layer, a simple image
            Sprite cocosImage = Sprite.create(s_Power);
            // scale the image (optional)
            cocosImage.setScale(2.5f);
            // change the transform anchor point to 0,0 (optional)
            cocosImage.setAnchorPoint(new Vec2(0, 0));


            // Middle layer: a Tile map atlas
            TileMapAtlas tilemap = TileMapAtlas.create(s_TilesPng, s_LevelMapTga, 16, 16);
            tilemap.releaseMap();

            // change the transform anchor to 0,0 (optional)
            tilemap.setAnchorPoint(new Vec2(0, 0));

            // Anti Aliased images
            tilemap.getTexture().setAntiAliasTexParameters();


            // background layer: another image
            Sprite background = Sprite.create(s_back);
            // scale the image (optional)
            background.setScale(1.5f);
            // change the transform anchor point (optional)
            background.setAnchorPoint(new Vec2(0, 0));


            // create a void node, a parent node
            ParallaxNode voidNode = ParallaxNode.create();

            // NOW add the 3 layers to the 'void' node

            // background image is moved at a ratio of 0.4x, 0.5y
            voidNode.addChild(background, -1, new Vec2(0.4f, 0.5f), Vec2.ZERO);

            // tiles are moved at a ratio of 1.0, 1.0y
            voidNode.addChild(tilemap, 1, new Vec2(1.0f, 1.0f), new Vec2(0, -200));

            // top image is moved at a ratio of 3.0x, 2.5y
            voidNode.addChild(cocosImage, 2, new Vec2(3.0f, 2.5f), new Vec2(200, 1000));
            addChild(voidNode, 0, kTagNode);
        }

        public boolean onTouchBegan(Touch touch, Event event)
        {
            return true;
        }

        public void onTouchMoved(Touch touch, Event event)
        {
            super.onTouchMoved(touch, event);
            Vec2 diff = touch.getDelta();

            Node node = getChildByTag(kTagNode);
            Vec2 currentPos = node.getPosition();
            node.setPosition(currentPos.plus(diff));
        }
    }

}
