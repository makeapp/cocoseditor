/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.particle;

import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.Const;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import com.googlecode.javacpp.annotation.StdString;
import org.ccj.base.BlendFunc;
import org.ccj.base.Color4F;
import org.ccj.math.Vec2;
import org.ccj.base.Ref;
import org.ccj.d2.Node;
import org.ccj.d2.Texture2D;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-3-9 下午4:17 $
 *          $Id$
 */
@Platform(include = "CCParticleSystem.h")
@Namespace("cocos2d")

@com.googlecode.javacpp.annotation.Opaque
public class ParticleSystem extends Node
{
    public static final int PARTICLE_TYPE_FREE = 0,

    /**
     * Living particles are attached to the world but will follow the emitter repositioning.
     * Use case: Attach an emitter to an sprite, and you want that the emitter follows the sprite.
     */
    PARTICLE_TYPE_RELATIVE = 1,

    /**
     * Living particles are attached to the emitter and are translated along with it.
     */
    PARTICLE_TYPE_GROUPED = 2;

    public static final int MODE_GRAVITY = 0,
        MODE_RADIUS = 1;

    public static final int PARTICLE_START_SIZE_EQUAL_TO_END_SIZE = -1;
    public static final int PARTICLE_START_RADIUS_EQUAL_TO_END_RADIUS = -1;

    /**
     * creates an initializes a ParticleSystem from a plist file.
     * This plist files can be created manually or with Particle Designer:
     * http://particledesigner.71squared.com/
     *
     * @since v2.0
     */
    public native static ParticleSystem create(@StdString String plistFile);

    //! create a system with a fixed number of particles
    public native static ParticleSystem createWithTotalParticles(int numberOfParticles);

    //! Add a particle to the emitter
    public native boolean addParticle();

    //! Initializes a particle
//        public native   void initParticle(tParticle* particle);
    //! stop emitting particles. Running particles will continue to run until they die
    public native void stopSystem();

    //! Kill all living particles.
    public native void resetSystem();

    //! whether or not the system is full
    public native boolean isFull();

    //! should be overridden by subclasses
//         public native  void updateQuadWithParticle(tParticle* particle, const Vec2& newPosition);
    //! should be overridden by subclasses
    public native void postStep();

    public native void updateWithNoTime();

    public native boolean isAutoRemoveOnFinish();

    public native void setAutoRemoveOnFinish(@Cast("bool") boolean var);

    // mode A
    @ByRef
    @Const
    public native Vec2 getGravity();

    public native void setGravity(@Const @ByRef Vec2 g);

    public native float getSpeed();

    public native void setSpeed(float speed);

    public native float getSpeedVar();

    public native void setSpeedVar(float speed);

    public native float getTangentialAccel();

    public native void setTangentialAccel(float t);

    public native float getTangentialAccelVar();

    public native void setTangentialAccelVar(float t);

    public native float getRadialAccel();

    public native void setRadialAccel(float t);

    public native float getRadialAccelVar();

    public native void setRadialAccelVar(float t);

    public native boolean getRotationIsDir();

    public native void setRotationIsDir(@Cast("bool") boolean t);

    // mode B
    public native float getStartRadius();

    public native void setStartRadius(float startRadius);

    public native float getStartRadiusVar();

    public native void setStartRadiusVar(float startRadiusVar);

    public native float getEndRadius();

    public native void setEndRadius(float endRadius);

    public native float getEndRadiusVar();

    public native void setEndRadiusVar(float endRadiusVar);

    public native float getRotatePerSecond();

    public native void setRotatePerSecond(float degrees);

    public native float getRotatePerSecondVar();

    public native void setRotatePerSecondVar(float degrees);

    public native void setScale(float s);

    public native void setRotation(float newRotation);

    public native void setScaleX(float newScaleX);

    public native void setScaleY(float newScaleY);

    public native boolean isActive();

    public native boolean isBlendAdditive();

    public native void setBlendAdditive(@Cast("bool") boolean value);

//         public native  ParticleBatchNode* getBatchNode() ;
//         public native  void setBatchNode(ParticleBatchNode* batchNode);

    // index of system in batch node array
    public native int getAtlasIndex();

    public native void setAtlasIndex(int index);

    /**
     * Quantity of particles that are being simulated at the moment
     */
    public native int getParticleCount();

    /**
     * How many seconds the emitter will run. -1 means 'forever'
     */
    public native float getDuration();

    public native void setDuration(float duration);

    /**
     * sourcePosition of the emitter
     */
    @ByRef
    @Const
    public native Vec2 getSourcePosition();

    public native void setSourcePosition(@ByRef @Const Vec2 pos);

    /**
     * Position variance of the emitter
     */
    @ByRef
    @Const
    public native Vec2 getPosVar();

    public native void setPosVar(@ByRef @Const Vec2 pos);

    /**
     * life, and life variation of each particle
     */
    public native float getLife();

    public native void setLife(float life);

    /**
     * life variance of each particle
     */
    public native float getLifeVar();

    public native void setLifeVar(float lifeVar);

    /**
     * angle and angle variation of each particle
     */
    public native float getAngle();

    public native void setAngle(float angle);

    /**
     * angle variance of each particle
     */
    public native float getAngleVar();

    public native void setAngleVar(float angleVar);

    /**
     * Switch between different kind of emitter modes:
     * - kParticleModeGravity: uses gravity, speed, radial and tangential acceleration
     * - kParticleModeRadius: uses radius movement + rotation
     */
    @Cast("int")
    public native int getEmitterMode();

    public native void setEmitterMode(@Cast("cocos2d::ParticleSystem::Mode") int mode);

    /**
     * start size in pixels of each particle
     */
    public native float getStartSize();

    public native void setStartSize(float startSize);

    /**
     * size variance in pixels of each particle
     */
    public native float getStartSizeVar();

    public native void setStartSizeVar(float sizeVar);

    /**
     * end size in pixels of each particle
     */
    public native float getEndSize();

    public native void setEndSize(float endSize);

    /**
     * end size variance in pixels of each particle
     */
    public native float getEndSizeVar();

    public native void setEndSizeVar(float sizeVar);

    /**
     * start color of each particle
     */
    @ByRef
    @Const
    public native Color4F getStartColor();

    public native void setStartColor(@Const @ByRef Color4F color);

    /**
     * start color variance of each particle
     */
    @ByRef
    @Const
    public native Color4F getStartColorVar();

    public native void setStartColorVar(@ByRef @Const Color4F color);

    /**
     * end color and end color variation of each particle
     */
    @ByRef
    @Const
    public native Color4F getEndColor();

    public native void setEndColor(@ByRef @Const Color4F color);

    /**
     * end color variance of each particle
     */
    @ByRef
    @Const
    public native Color4F getEndColorVar();

    public native void setEndColorVar(@ByRef @Const Color4F color);

    //* initial angle of each particle
    public native float getStartSpin();

    public native void setStartSpin(float spin);

    //* initial angle of each particle
    public native float getStartSpinVar();

    public native void setStartSpinVar(float pinVar);

    //* initial angle of each particle
    public native float getEndSpin();

    public native void setEndSpin(float endSpin);

    //* initial angle of each particle
    public native float getEndSpinVar();

    public native void setEndSpinVar(float endSpinVar);

    /**
     * emission rate of the particles
     */
    public native float getEmissionRate();

    public native void setEmissionRate(float rate);

    /**
     * maximum particles of the system
     */
    public native int getTotalParticles();

    public native void setTotalParticles(int totalParticles);

    /**
     * does the alpha value modify color
     */
    public native void setOpacityModifyRGB(@Cast("bool") boolean opacityModifyRGB);

    public native boolean isOpacityModifyRGB();
//        CC_DEPRECATED_ATTRIBUTE public native boolean getOpacityModifyRGB() ;

    /**
     * particles movement type: Free or Grouped
     *
     * @since v0.8
     */
    @Cast("int")
    public native int getPositionType();

    public native void setPositionType(@Cast("cocos2d::ParticleSystem::PositionType") int type);

    // Overrides
//         public native  void update(float dt) override;
    public native Texture2D getTexture();

    public native void setTexture(Texture2D texture);

    /**
     * @code When this function bound into js or lua,the parameter will be changed
     * In js: var setBlendFunc(var src, var dst)
     * In lua: local setBlendFunc(local src, local dst)
     * @endcode
     */
    public native void setBlendFunc(@Const @ByRef BlendFunc blendFunc);

    /**
     * @js NA
     * @lua NA
     */
    @ByRef
    @Const
    public native BlendFunc getBlendFunc();

    public static ParticleSystem cast(Ref node)
    {
        return cast(node, ParticleSystem.class);
    }
}
