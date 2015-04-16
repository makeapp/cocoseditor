/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.ByVal;
import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.Const;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import org.ccj.d2.TextureCache;
import org.ccj.event.EventDispatcher;
import org.ccj.math.Vec2;
import org.ccj.math.Size;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-2-23 上午10:42 $
 *          $Id$
 */

@Platform(include = "CCDirector.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class Director
    extends Pointer
{
    /**
     * returns a shared instance of the director
     */
    public static native Director getInstance();

    /**
     * @js NA
     * @lua NA
     */
    public native boolean init();

    // attribute

    /**
     * Get current running Scene. Director can only run one Scene at a time
     */
    public native Scene getRunningScene();

    /**
     * Get the FPS value
     */
    public native double getAnimationInterval();

    /**
     * Set the FPS value.
     */
    public native void setAnimationInterval(double interval);

    /**
     * Whether or not to display the FPS on the bottom-left corner
     */
    public native boolean isDisplayStats();

    /**
     * Display the FPS on the bottom-left corner
     */
    public native void setDisplayStats(@Cast("bool") boolean displayStats);

    /**
     * seconds per frame
     */
    public native float getSecondsPerFrame();

    /**
     * Get the EGLView, where everything is rendered
     *
     * @js NA
     * @lua NA
     */
    @Cast("cocos2d::GLViewImpl*")
    public native GLView getOpenGLView();

    public native void setOpenGLView(GLView openGLView);

    public native TextureCache getTextureCache();

    public native boolean isNextDeltaTimeZero();

    public native void setNextDeltaTimeZero(@Cast("bool") boolean nextDeltaTimeZero);

    /**
     * Whether or not the Director is paused
     */
    public native boolean isPaused();

    /**
     * How many frames were called since the director started
     */
    public native int getTotalFrames();

    /** Sets an OpenGL projection
     @since v0.8.2
      * @js NA
     * @lua NA
     */
//        public native Projection getProjection() { return _projection; }
//        void setProjection(Projection projection);

    /**
     * Sets the glViewport
     */
//    public native void setViewport();

    /** How many frames were called since the director started */


    /**
     * Whether or not the replaced scene will receive the cleanup message.
     * If the new scene is pushed, then the old scene won't receive the "cleanup" message.
     * If the new scene replaces the old one, the it will receive the "cleanup" message.
     *
     * @since v0.99.0
     */
    public native boolean isSendCleanupToScene();

    /** This object will be visited after the main scene is visited.
     This object MUST implement the "visit" selector.
     Useful to hook a notification object, like Notifications (http://github.com/manucorporat/CCNotifications)
     @since v0.99.5
     */
//        Node* getNotificationNode() const { return _notificationNode; }
//        void setNotificationNode(Node *node);

    // window size

    /**
     * returns the size of the OpenGL view in points.
     */
    @ByRef
    @Const
    public native Size getWinSize();

    /**
     * returns the size of the OpenGL view in pixels.
     */
    @ByVal
    public native Size getWinSizeInPixels();

    /**
     * returns visible size of the OpenGL view in points.
     * the value is equal to getWinSize if don't invoke
     * EGLView::setDesignResolutionSize()
     */
    @ByVal
    public native Size getVisibleSize();

    /**
     * returns visible origin of the OpenGL view in points.
     */
    @ByVal
    public native Vec2 getVisibleOrigin();

    /**
     * converts a UIKit coordinate to an OpenGL coordinate
     * Useful to convert (multi) touch coordinates to the current layout (portrait or landscape)
     */
    @ByVal
    public native Vec2 convertToGL(@ByRef Vec2 point);

    /**
     * converts an OpenGL coordinate to a UIKit coordinate
     * Useful to convert node points to window points for calls such as glScissor
     */
//        Vec2 convertToUI(const Vec2& point);

    /// XXX: missing description
    public native float getZEye();

    // Scene Management

    /**
     * Enters the Director's main loop with the given Scene.
     * Call it to run only your FIRST scene.
     * Don't call it if there is already a running scene.
     * <p/>
     * It will call pushScene: and then it will call startAnimation
     */
    public native void runWithScene(Scene scene);

    /**
     * Suspends the execution of the running scene, pushing it on the stack of suspended scenes.
     * The new scene will be executed.
     * Try to avoid big stacks of pushed scenes to reduce memory allocation.
     * ONLY call it if there is a running scene.
     */
    public native void pushScene(Scene scene);

    /**
     * Pops out a scene from the stack.
     * This scene will replace the running one.
     * The running scene will be deleted. If there are no more scenes in the stack the execution is terminated.
     * ONLY call it if there is a running scene.
     */
    public native void popScene();

    /**
     * Pops out all scenes from the stack until the root scene in the queue.
     * This scene will replace the running one.
     * Internally it will call `popToSceneStackLevel(1)`
     */
    public native void popToRootScene();

    /**
     * Pops out all scenes from the stack until it reaches `level`.
     * If level is 0, it will end the director.
     * If level is 1, it will pop all scenes until it reaches to root scene.
     * If level is <= than the current stack level, it won't do anything.
     */
    public native void popToSceneStackLevel(int level);

    /**
     * Replaces the running scene with a new one. The running scene is terminated.
     * ONLY call it if there is a running scene.
     */
    public native void replaceScene(Scene scene);

    /**
     * Ends the execution, releases the running scene.
     * It doesn't remove the OpenGL view from its parent. You have to do it manually.
     *
     * @lua endToLua
     */
    public native void end();

    /**
     * Pauses the running scene.
     * The running scene will be _drawed_ but all scheduled timers will be paused
     * While paused, the draw rate will be 4 FPS to reduce CPU consumption
     */
    public native void pause();

    /**
     * Resumes the paused scene
     * The scheduled timers will be activated again.
     * The "delta time" will be 0 (as if the game wasn't paused)
     */
    public native void resume();

    /**
     * Stops the animation. Nothing will be drawn. The main loop won't be triggered anymore.
     * If you don't want to pause your animation call [pause] instead.
     */
    public native void stopAnimation();

    /**
     * The main loop is triggered again.
     * Call this function only if [stopAnimation] was called earlier
     *
     * @warning Don't call this function to start the main loop. To run the main loop call runWithScene
     */
    public native void startAnimation();

    /**
     * Draw the scene.
     * This method is called every frame. Don't call it manually.
     */
    public native void drawScene();

    // Memory Helper

    /**
     * Removes all cocos2d cached data.
     * It will purge the TextureCache, SpriteFrameCache, LabelBMFont cache
     *
     * @since v0.99.3
     */
    public native void purgeCachedData();

    /**
     * sets the default values based on the Configuration info
     */
    public native void setDefaultValues();

    // OpenGL Helper

    /**
     * sets the OpenGL default values
     */
    public native void setGLDefaultValues();

    /**
     * enables/disables OpenGL alpha blending
     */
    public native void setAlphaBlending(@Cast("bool") boolean on);

    /**
     * enables/disables OpenGL depth test
     */
    public native void setDepthTest(@Cast("bool") boolean on);

    public native void mainLoop();

    /**
     * The size in pixels of the surface. It could be different than the screen size.
     * High-res devices might have a higher surface size than the screen size.
     * Only available when compiled using SDK >= 4.0.
     *
     * @since v0.99.4
     */
    public native void setContentScaleFactor(float scaleFactor);

    public native float getContentScaleFactor();

    /**
     Get the Culling Frustum
     */

//        Frustum* getFrustum() const { return _cullingFrustum; }

    /**
     * Gets the Scheduler associated with this director
     *
     * @since v2.0
     */
    public native Scheduler getScheduler();

    /**
     * Sets the Scheduler associated with this director
     *
     * @since v2.0
     */
    public native void setScheduler(Scheduler scheduler);

    /** Gets the ActionManager associated with this director
     @since v2.0
     */
//        ActionManager* getActionManager() const { return _actionManager; }

    /** Sets the ActionManager associated with this director
     @since v2.0
     */
//        void setActionManager(ActionManager* actionManager);

    /**
     * Gets the EventDispatcher associated with this director
     *
     * @since v3.0
     */
    public native EventDispatcher getEventDispatcher();

    /**
     * Sets the EventDispatcher associated with this director
     *
     * @since v3.0
     */
    public native void setEventDispatcher(EventDispatcher dispatcher);

    /** Returns the Renderer
     @since v3.0
     */
//        Renderer* getRenderer() const { return _renderer; }

    /**
     * Returns the Console
     *
     * @since v3.0
     */
    public native Console getConsole();

    /* Gets delta time since last tick to main loop */
    public native float getDeltaTime();

    /**
     * get Frame Rate
     */
    public native float getFrameRate();
}
