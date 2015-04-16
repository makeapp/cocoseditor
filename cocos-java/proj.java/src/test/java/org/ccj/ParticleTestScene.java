package org.ccj;

import org.ccj.d2.*;
import org.ccj.d2.action.MoveBy;
import org.ccj.d2.action.RepeatForever;
import org.ccj.d2.action.Sequence;
import org.ccj.base.Color4F;
import org.ccj.base.Touch;
import org.ccj.event.Event;
import org.ccj.math.Vec2;
import org.ccj.math.Rect;
import org.ccj.math.Size;
import org.ccj.particle.ParticleFire;
import org.ccj.particle.ParticleFireworks;
import org.ccj.particle.ParticleFlower;
import org.ccj.particle.ParticleGalaxy;
import org.ccj.particle.ParticleSun;
import org.ccj.particle.ParticleSystem;
import org.ccj.particle.ParticleSystemQuad;

/**
 * Created by yuanyou@makeapp.co on 2014/4/19.
 */
public class ParticleTestScene extends TestScene
{
    static int TAG_LABEL_ATLAS = 1;

    public Class[] getLayers()
    {
        return new Class[]{DemoParticleFromFile.class,DemoFirework.class, DemoFire.class, DemoSun.class, DemoGalaxy.class, DemoFlower.class, DemoBigFlower.class, DemoParticleFromFile.class};
    }

    static public class ParticleDemo extends TestLayer
    {
        ParticleSystem _emitter = null;
        Sprite _background = null;
        MenuItemSprite _shapeModeButton = null;
        MenuItemSprite _textureModeButton = null;
        boolean _isPressed = false;
        MenuItemSprite _freeMovementButton;
        MenuItemSprite _relativeMovementButton;
        MenuItemSprite _groupMovementButton;

        @Override
        public void onCreate()
        {
            super.onCreate();
            Size s = Director.getInstance().getWinSize().fetch();

            Sprite freeBtnNormal = Sprite.create(s_MovementMenuItem, new Rect(0, 23 * 2, 123, 23));
            Sprite freeBtnSelected = Sprite.create(s_MovementMenuItem, new Rect(0, 23, 123, 23));
            Sprite freeBtnDisabled = Sprite.create(s_MovementMenuItem, new Rect(0, 0, 123, 23));

            Sprite relativeBtnNormal = Sprite.create(s_MovementMenuItem, new Rect(123, 23 * 2, 138, 23));
            Sprite relativeBtnSelected = Sprite.create(s_MovementMenuItem, new Rect(123, 23, 138, 23));
            Sprite relativeBtnDisabled = Sprite.create(s_MovementMenuItem, new Rect(123, 0, 138, 23));

            Sprite groupBtnNormal = Sprite.create(s_MovementMenuItem, new Rect(261, 23 * 2, 136, 23));
            Sprite groupBtnSelected = Sprite.create(s_MovementMenuItem, new Rect(261, 23, 136, 23));
            Sprite groupBtnDisabled = Sprite.create(s_MovementMenuItem, new Rect(261, 0, 136, 23));

            _freeMovementButton = MenuItemSprite.create(freeBtnNormal, freeBtnSelected, freeBtnDisabled);
            _freeMovementButton.setOnClickListener(new MenuItem.MenuItemListener()
            {
                public void onClicked(MenuItem item)
                {
                    _emitter.setPositionType(_emitter.PARTICLE_TYPE_RELATIVE);
                    _relativeMovementButton.setVisible(true);
                    _freeMovementButton.setVisible(false);
                    _groupMovementButton.setVisible(false);
                }
            });
            this._freeMovementButton.setAnchorPoint(0, 0);
            this._freeMovementButton.setPosition(10, 150);
            this._relativeMovementButton = MenuItemSprite.create(relativeBtnNormal, relativeBtnSelected, relativeBtnDisabled);
            _relativeMovementButton.setOnClickListener(new MenuItem.MenuItemListener()
            {
                public void onClicked(MenuItem item)
                {
                    _emitter.setPositionType(_emitter.PARTICLE_TYPE_GROUPED);
                    _relativeMovementButton.setVisible(false);
                    _freeMovementButton.setVisible(false);
                    _groupMovementButton.setVisible(true);
                }
            });
            this._relativeMovementButton.setVisible(false);

            _relativeMovementButton.setPosition(10, 150);
            this._relativeMovementButton.setAnchorPoint(0, 0);

            this._groupMovementButton = MenuItemSprite.create(groupBtnNormal, groupBtnSelected, groupBtnDisabled);
            _groupMovementButton.setOnClickListener(new MenuItem.MenuItemListener()
            {
                public void onClicked(MenuItem item)
                {
                    _emitter.setPositionType(_emitter.PARTICLE_TYPE_FREE);
                    _relativeMovementButton.setVisible(false);
                    _freeMovementButton.setVisible(true);
                    _groupMovementButton.setVisible(false);
                }
            });
            this._groupMovementButton.setVisible(false);
            this._groupMovementButton.setPosition(10, 150);
            this._groupMovementButton.setAnchorPoint(0, 0);

            Sprite spriteNormal = Sprite.create(s_shapeModeMenuItem, new Rect(0, 23 * 2, 115, 23));
            Sprite spriteSelected = Sprite.create(s_shapeModeMenuItem, new Rect(0, 23, 115, 23));
            Sprite spriteDisabled = Sprite.create(s_shapeModeMenuItem, new Rect(0, 0, 115, 23));

            this._shapeModeButton = MenuItemSprite.create(spriteNormal, spriteSelected, spriteDisabled);
            _shapeModeButton.setOnClickListener(new MenuItem.MenuItemListener()
            {
                public void onClicked(MenuItem item)
                {
//                    if (_emitter.setDrawMode)
//                                                    _emitter.setDrawMode(PARTICLE_TEXTURE_MODE);
                    _textureModeButton.setVisible(true);
                    _shapeModeButton.setVisible(false);
                }
            });
            this._shapeModeButton.setPosition(10, 100);
            this._shapeModeButton.setAnchorPoint(0, 0);

//                    if ('opengl' in sys.capabilities ) {
//                        // Shape type is not compatible with JSB
//                        this._shapeModeButton.enabled = false;
//                    }

            Sprite spriteNormal_t = Sprite.create(s_textureModeMenuItem, new Rect(0, 23 * 2, 115, 23));
            Sprite spriteSelected_t = Sprite.create(s_textureModeMenuItem, new Rect(0, 23, 115, 23));
            Sprite spriteDisabled_t = Sprite.create(s_textureModeMenuItem, new Rect(0, 0, 115, 23));

            this._textureModeButton = MenuItemSprite.create(spriteNormal_t, spriteSelected_t, spriteDisabled_t);
            _textureModeButton.setOnClickListener(new MenuItem.MenuItemListener()
            {
                public void onClicked(MenuItem item)
                {
//                    if (_emitter.setDrawMode)
//                                                    _emitter.setDrawMode(PARTICLE_SHAPE_MODE);
                    _textureModeButton.setVisible(false);
                    _shapeModeButton.setVisible(true);
                }
            });
            this._textureModeButton.setVisible(false);
            this._textureModeButton.setPosition(10, 100);
            this._textureModeButton.setAnchorPoint(0, 0);

            Menu menu = Menu.create(this._shapeModeButton, this._textureModeButton,
                this._freeMovementButton, this._relativeMovementButton, this._groupMovementButton);
            menu.setPosition(0, 0);
            this.addChild(menu, 100);

            //TODO
            LabelAtlas labelAtlas = LabelAtlas.create("0123456789", s_fpsImages, 16, 24, '.');
            this.addChild(labelAtlas, 100, TAG_LABEL_ATLAS);
            labelAtlas.setPosition(s.width - 66, 50);
            // moving background
            this._background = Sprite.create(s_back3);
            this.addChild(this._background);
            this._background.setPosition(s.width / 2, s.height - 180);

            MoveBy move = MoveBy.create(4, new Vec2(300, 0));
            MoveBy move_back = move.reverse();

            Sequence seq = Sequence.create(move, move_back);
            this._background.runAction(RepeatForever.create(seq));

//            this.scheduleUpdate();
            setTouchEnabled(true);
            setTouchMode(Touch.MODE_ONE_BY_ONE);
        }

        public void _moveToTouchPoint(Vec2 location)
        {
            location.fetch();
            Vec2 pos = new Vec2(0, 0);
            if (this._background != null) {
                pos = this._background.convertToWorldSpace(pos).fetch();
            }
            this._emitter.setPosition(location.x - pos.x, location.y - pos.y);
        }

        public void onTouchMoved(Touch touch, Event event)
        {
            super.onTouchMoved(touch, event);
            _moveToTouchPoint(touch.getLocation());
        }

        public boolean onTouchBegan(Touch touch, Event event)
        {
            _moveToTouchPoint(touch.getLocation());
            return true;
        }

        public void onEnter()
        {
            super.onEnter();
        }

        public void onUpdate(float dt)
        {
            if (this._emitter != null) {
                Label atlas = Label.cast(this.getChildByTag(TAG_LABEL_ATLAS));
                atlas.setString("" + this._emitter.getParticleCount());
            }
        }

        public void setEmitterPosition()
        {
            Vec2 sourcePos = this._emitter.getSourcePosition();
            if (sourcePos.x == 0 && sourcePos.y == 0) {
                _moveToTouchPoint(VisibleRect.center());
            }
        }
    }

    static public class DemoFirework extends ParticleDemo
    {
        @Override
        public void onCreate()
        {
            super.onCreate();

            this._emitter = ParticleFireworks.create();
            this._background.addChild(this._emitter, 10);
            Texture2D myTexture = TextureCache.getInstance().addImage(s_stars1);
            _emitter.setTexture(myTexture);
//            if (this._emitter.setShapeType)
//                this._emitter.setShapeType(cc.PARTICLE_STAR_SHAPE);
            this.setEmitterPosition();
        }

        public String getTitle()
        {
            return "ParticleFireworks";
        }
    }

    static public class DemoFire extends ParticleDemo
    {
        @Override
        public void onCreate()
        {
            super.onCreate();

            this._emitter = ParticleFire.create();
            this._background.addChild(this._emitter, 10);
            Texture2D myTexture = TextureCache.getInstance().addImage(s_stars1);
            _emitter.setTexture(myTexture);
//            if (this._emitter.setShapeType)
//                this._emitter.setShapeType(cc.PARTICLE_STAR_SHAPE);
            this.setEmitterPosition();
        }

        public String getTitle()
        {
            return "ParticleFire";
        }
    }

    static public class DemoSun extends ParticleDemo
    {
        @Override
        public void onCreate()
        {
            super.onCreate();

            this._emitter = ParticleSun.create();
            this._background.addChild(this._emitter, 10);
            Texture2D myTexture = TextureCache.getInstance().addImage(s_fire);
            _emitter.setTexture(myTexture);
//            if (this._emitter.setShapeType)
//                this._emitter.setShapeType(cc.PARTICLE_STAR_SHAPE);
            this.setEmitterPosition();
        }

        public String getTitle()
        {
            return "ParticleSun";
        }
    }

    static public class DemoGalaxy extends ParticleDemo
    {
        @Override
        public void onCreate()
        {
            super.onCreate();

            this._emitter = ParticleGalaxy.create();
            this._background.addChild(this._emitter, 10);
            Texture2D myTexture = TextureCache.getInstance().addImage(s_fire);
            _emitter.setTexture(myTexture);
//            if (this._emitter.setShapeType)
//                this._emitter.setShapeType(cc.PARTICLE_STAR_SHAPE);
            this.setEmitterPosition();
        }

        public String getTitle()
        {
            return "ParticleGalaxy";
        }
    }

    static public class DemoFlower extends ParticleDemo
    {
        @Override
        public void onCreate()
        {
            super.onCreate();

            this._emitter = ParticleFlower.create();
            this._background.addChild(this._emitter, 10);
            Texture2D myTexture = TextureCache.getInstance().addImage(s_stars1);
            _emitter.setTexture(myTexture);
//            if (this._emitter.setShapeType)
//                this._emitter.setShapeType(cc.PARTICLE_STAR_SHAPE);
            this.setEmitterPosition();
        }

        public String getTitle()
        {
            return "ParticleFlower";
        }
    }


    static public class DemoBigFlower extends ParticleDemo
    {
        @Override
        public void onCreate()
        {
            super.onCreate();

            this._emitter = ParticleSystem.createWithTotalParticles(50);

            this._background.addChild(this._emitter, 10);
            this._emitter.setTexture(TextureCache.getInstance().addImage(s_stars1));
//                   this._emitter.shapeType = cc.PARTICLE_STAR_SHAPE;

            this._emitter.setDuration(-1);

            // gravity
            this._emitter.setGravity(new Vec2(0, 0));

            // angle
            this._emitter.setAngle(90f);
            this._emitter.setAngleVar(360f);

            // speed of particles
            this._emitter.setSpeed(160f);
            this._emitter.setSpeedVar(20f);

            // radial
            this._emitter.setRadialAccel(-120f);
            this._emitter.setRadialAccelVar(0);

            // tagential
            this._emitter.setTangentialAccel(30f);
            this._emitter.setTangentialAccelVar(0f);

            // emitter position
            this._emitter.setPosition(160, 240);
            this._emitter.setPosVar(new Vec2(0, 0));

            // life of particles
            this._emitter.setLife(4f);
            this._emitter.setLifeVar(1f);

            // spin of particles
            this._emitter.setStartSpin(0);
            this._emitter.setStartSpinVar(0);
            this._emitter.setEndSpin(0f);
            ;
            this._emitter.setEndSpinVar(0f);

            // color of particles
            this._emitter.setStartColor(new Color4F(128, 128, 128, 255));

            this._emitter.setStartColorVar(new Color4F(128, 128, 128, 255));

            this._emitter.setEndColor(new Color4F(26, 26, 26, 50));

            this._emitter.setEndColorVar(new Color4F(26, 26, 26, 50));

            // size, in pixels
            this._emitter.setStartSize(80.0f);
            this._emitter.setStartSizeVar(40.0f);
            this._emitter.setEndSize(_emitter.PARTICLE_START_SIZE_EQUAL_TO_END_SIZE);

            // emits per second
            this._emitter.setEmissionRate(this._emitter.getTotalParticles() / this._emitter.getLife());

            // additive
            this._emitter.setBlendAdditive(true);

            this.setEmitterPosition();
        }

        public String getTitle()
        {
            return "ParticleBigFlower";
        }
    }

    static public class DemoParticleFromFile extends ParticleDemo
    {
        String[] filenames = {"BoilingFoam", "BurstPipe", "Comet", "debian", "ExplodingRing", "LavaFlow", "SpinningPeas", "SpookyPeas", "Upsidedown", "Flower", "Spiral", "Galaxy"};
        String filename;
        static int idx = 0;

        @Override
        public void onCreate()
        {
            super.onCreate();
            if (idx >= filenames.length) {
                idx = 0;
            }
            filename = filenames[idx++];
//            if (this._background != null) {
//                this.removeChild(this._background, true);
//                this._background = null;
//            }
            Logger.log("load " + s_resprefix + "Particles/" + this.filename + ".plist");
            this._emitter = ParticleSystemQuad.create(s_resprefix + "Particles/" + this.filename + ".plist");
//            this._emitter.retain();
            this._background.addChild(this._emitter, 10);

//                    if (this._title == "Flower") {
//                        this._emitter.shapeType = cc.PARTICLE_STAR_SHAPE;
//                    }//else if( this._title == "Upsidedown"){
            //   this._emitter.setDrawMode(cc.PARTICLE_TEXTURE_MODE);
            //}

            this.setEmitterPosition();
        }

        public String getTitle()
        {
            return filename;
        }
    }
}
