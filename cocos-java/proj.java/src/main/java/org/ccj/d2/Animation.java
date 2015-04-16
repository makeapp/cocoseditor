/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.d2;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.Const;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import org.ccj.math.Rect;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-3-5 下午2:52 $
 *          $Id$
 */

@Platform(include = "CCAnimation.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class Animation
    extends Pointer
{

    /**
     * Creates an animation
     *
     * @since v0.99.5
     */
    public native static Animation create();

       /* Creates an animation with an array of SpriteFrame and a delay between frames in seconds.
        The frames will be added with one "delay unit".
        @since v0.99.5
        */
//    public  native   static Animation* createWithSpriteFrames(const Vector<SpriteFrame*>& arrayOfSpriteFrameNames, float delay = 0.0f);

       /* Creates an animation with an array of AnimationFrame, the delay per units in seconds and and how many times it should be executed.
        @since v2.0
        * @js NA
        */
//    public  native  static Animation* create(const Vector<AnimationFrame*>& arrayOfAnimationFrameNames, float delayPerUnit, unsigned int loops = 1);

    /**
     * Adds a SpriteFrame to a Animation.
     * The frame will be added with one "delay unit".
     */
    public native void addSpriteFrame(SpriteFrame frame);

    /**
     * Adds a frame with an image filename. Internally it will create a SpriteFrame and it will add it.
     * The frame will be added with one "delay unit".
     * Added to facilitate the migration from v0.8 to v0.9.
     */
    public native void addSpriteFrameWithFile(String filename);
    /**
     @deprecated. Use addSpriteFrameWithFile() instead
     */
//    public  native   void addSpriteFrameWithFileName(String filename){ addSpriteFrameWithFile(filename);}

    /**
     * Adds a frame with a texture and a rect. Internally it will create a SpriteFrame and it will add it.
     * The frame will be added with one "delay unit".
     * Added to facilitate the migration from v0.8 to v0.9.
     */
    public native void addSpriteFrameWithTexture(Texture2D pobTexture, @Const @ByRef Rect rect);

    /**
     * Gets the total Delay units of the Animation.
     */
    public native float getTotalDelayUnits();

    /**
     * Sets the delay in seconds of the "delay unit"
     */
    public native void setDelayPerUnit(float delayPerUnit);

    /**
     * Gets the delay in seconds of the "delay unit"
     */
    public native float getDelayPerUnit();


    /**
     * Gets the duration in seconds of the whole animation. It is the result of totalDelayUnits * delayPerUnit
     */
    public native float getDuration();

    /** Gets the array of AnimationFrames */
//    public  native const Vector<AnimationFrame*>& getFrames() const { return _frames; };

    /** Sets the array of AnimationFrames */
//       public  native void setFrames(const Vector<AnimationFrame*>& frames);

    /**
     * Checks whether to restore the original frame when animation finishes.
     */
    public native boolean getRestoreOriginalFrame();

    /**
     * Sets whether to restore the original frame when animation finishes
     */
    public native void setRestoreOriginalFrame(@Cast("bool") boolean restoreOriginalFrame);

    /**
     * Gets the times the animation is going to loop. 0 means animation is not animated. 1, animation is executed one time, ...
     */
    public native int getLoops();

    /**
     * Sets the times the animation is going to loop. 0 means animation is not animated. 1, animation is executed one time, ...
     */
    public native void setLoops(int loops);

    // overrides
    public native Animation clone();
}
