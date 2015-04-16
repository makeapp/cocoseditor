/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.particle;

import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.Const;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import com.googlecode.javacpp.annotation.StdString;
import org.ccj.d2.SpriteFrame;
import org.ccj.d2.Texture2D;
import org.ccj.math.Rect;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-3-9 下午4:19 $
 *          $Id$
 */
@Platform(include = "CCParticleSystem.h")
@Namespace("cocos2d")

@com.googlecode.javacpp.annotation.Opaque
public class ParticleSystemQuad extends ParticleSystem
{
    /**
     * creates a Particle Emitter
     */
    public native static ParticleSystemQuad create();

    /**
     * creates a Particle Emitter with a number of particles
     */
    public native static ParticleSystemQuad createWithTotalParticles(int numberOfParticles);

    /**
     * creates an initializes a ParticleSystemQuad from a plist file.
     * This plist files can be created manually or with Particle Designer:
     */
    public native static ParticleSystemQuad create(@StdString String filename);

    /**
     * Sets a new SpriteFrame as particle.
     * WARNING: this method is experimental. Use setTextureWithRect instead.
     *
     * @since v0.99.4
     */
    public native void setDisplayFrame(SpriteFrame spriteFrame);

    /**
     * Sets a new texture with a rect. The rect is in Points.
     *
     * @js NA
     * @lua NA
     * @since v0.99.4
     */
    public native void setTextureWithRect(Texture2D texture, @ByRef @Const Rect rect);

    /** listen the event that coming to foreground on Android
     * @js NA
     * @lua NA
     */
//        void listenBackToForeground(EventCustom*event);

    /**
     * @js NA
     * @lua NA
     */
    public native void setTexture(Texture2D texture);
    /**
     * @js NA
     * @lua NA
     */
//        virtual void updateQuadWithParticle(tParticle* particle, const Vec2& newPosition) override;

    /**
     * @js NA
     * @lua NA
     */
    public native void postStep();
    /**
     * @js NA
     * @lua NA
     */
//        virtual void draw() override;

    /**
     * @js NA
     * @lua NA
     */
//        virtual void setBatchNode(ParticleBatchNode* batchNode) override;

    /**
     * @js NA
     * @lua NA
     */
    public native void setTotalParticles(int tp);

//        virtual std::string getDescription() const override;
}
