/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.d2;

import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import com.googlecode.javacpp.annotation.StdString;
import org.ccj.base.Ref;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/4/22 17:45 $
 *          $Id$
 */
@Platform(include = "CCAnimationCache.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class AnimationCache extends Ref
{

    /**
     * Returns the shared instance of the Animation cache
     */
    public native static AnimationCache getInstance();

    /**
     * Purges the cache. It releases all the Animation objects and the shared instance.
     */
    public native static void destroyInstance();

//        bool init(void);

    /**
     * Adds a Animation with a name.
     */
    public native void addAnimation(Animation animation, @StdString String name);

    /**
     * Deletes a Animation from the cache.
     */
    public native void removeAnimation(@StdString String name);

    /**
     * Returns a Animation that was previously added.
     * If the name is not found it will return nil.
     * You should retain the returned copy if you are going to use it.
     */
    public native Animation getAnimation(@StdString String name);

    /** Adds an animation from an NSDictionary
     Make sure that the frames were previously loaded in the SpriteFrameCache.
     @param plist The path of the relative file,it use to find the plist path for load SpriteFrames.
     @since v1.1
     */
//        public native  void addAnimationsWithDictionary(const ValueMap& dictionary,@StdString String plist);

    /**
     * Adds an animation from a plist file.
     * Make sure that the frames were previously loaded in the SpriteFrameCache.
     *
     * @js addAnimations
     * @lua addAnimations
     * @since v1.1
     */
    public native void addAnimationsWithFile(@StdString String plist);

}
