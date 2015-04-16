/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj;

import com.googlecode.javacpp.annotation.*;
import org.ccj.base.Ref;
import org.ccj.math.Rect;
import org.ccj.math.Size;
import org.ccj.math.Vec2;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-2-28 上午11:04 $
 *          $Id$
 */

@Platform(include = "cocos2d.h")
@Name("cocos2d::GLViewImpl")
@com.googlecode.javacpp.annotation.Opaque
public class GLView
    extends Ref
{
    public GLView(long address)
    {
        init(address, 0, 0);
    }

    public native static GLView create(@StdString String viewName);

    public native static GLView createWithRect(@StdString String viewName, @ByRef Rect size, float frameZoomFactor);

//    public native static GLView createWithCanvas(long address,@StdString String viewName, @ByRef Rect size, float frameZoomFactor);

    public native static GLView createWithRect(@StdString String viewName, @ByRef Rect size);

    public native static GLView createWithFullScreen(@StdString String viewName);

    // The entire application is visible in the specified area without trying to preserve the original aspect ratio.
    // Distortion can occur, and the application may appear stretched or compressed.
    public static final int POLICY_EXACT_FIT = 0;

    // The entire application fills the specified area, without distortion but possibly with some cropping,
    // while maintaining the original aspect ratio of the application.
    public static final int POLICY_NO_BORDER = 1;

    // The entire application is visible in the specified area without distortion while maintaining the original
    // aspect ratio of the application. Borders can appear on two sides of the application.
    public static final int POLICY_SHOW_ALL = 2;

    // The application takes the height of the design resolution size and modifies the width of the internal
    // canvas so that it fits the aspect ratio of the device
    // no distortion will occur however you must make sure your application works on different
    // aspect ratios
    public static final int POLICY_FIXED_HEIGHT = 3;

    // The application takes the width of the design resolution size and modifies the height of the internal
    // canvas so that it fits the aspect ratio of the device
    // no distortion will occur however you must make sure your application works on different
    // aspect ratios
    public static final int POLICY_FIXED_WIDTH = 4;

    public static final int POLICY_UNKNOWN = 5;

    /**
     * Force destroying EGL view, subclass must implement this method.
     */
    public native void end();

    /**
     * Get whether opengl render system is ready, subclass must implement this method.
     */
    public native boolean isOpenGLReady();

    /**
     * Exchanges the front and back buffers, subclass must implement this method.
     */
    public native void swapBuffers();

    /**
     * Open or close IME keyboard , subclass must implement this method.
     */
    public native void setIMEKeyboardState(@Cast("bool") boolean open);

    /**
     * Polls input events. Subclass must implement methods if platform
     * does not provide event callbacks.
     */
    public native void pollInputEvents();

    /**
     * Get the frame size of EGL view.
     * In general, it returns the screen size since the EGL view is a fullscreen view.
     */
    @ByRef
    @Const
    public native Size getFrameSize();

    /**
     * Set the frame size of EGL view.
     */
    public native void setFrameSize(float width, float height);

    /**
     * Get the visible area size of opengl viewport.
     */
    @ByVal
    public native Size getVisibleSize();

    /**
     * Get the visible origin point of opengl viewport.
     */
    @ByVal
    public native Vec2 getVisibleOrigin();

    /**
     * Get the visible rectangle of opengl viewport.
     */
    @ByVal
    public native Rect getVisibleRect();

    /**
     * Set the design resolution size.
     *
     * @param width            Design resolution width.
     * @param height           Design resolution height.
     * @param resolutionPolicy The resolution policy desired, you may choose:
     *                         [1] EXACT_FIT Fill screen by stretch-to-fit: if the design resolution ratio of width to height is different from the screen resolution ratio, your game view will be stretched.
     *                         [2] NO_BORDER Full screen without black border: if the design resolution ratio of width to height is different from the screen resolution ratio, two areas of your game view will be cut.
     *                         [3] SHOW_ALL  Full screen with black border: if the design resolution ratio of width to height is different from the screen resolution ratio, two black borders will be shown.
     */
    public native void setDesignResolutionSize(float width, float height, @Cast("ResolutionPolicy") int resolutionPolicy);

    /**
     * Get design resolution size.
     * Default resolution size is the same as 'getFrameSize'.
     */
    @ByRef
    @Const
    public native Size getDesignResolutionSize();

    /**
     * Set opengl view port rectangle with points.
     */
    public native void setViewPortInPoints(float x, float y, float w, float h);

    /**
     * Set Scissor rectangle with points.
     */
    public native void setScissorInPoints(float x, float y, float w, float h);

    /**
     * Get whether GL_SCISSOR_TEST is enable
     */
    public native boolean isScissorEnabled();

    /**
     * Get the current scissor rectangle
     */
    @ByVal
    public native Rect getScissorRect();


    public native void setViewName(@StdString String viewname);

    @StdString
    @Const
    public native String getViewName();

    /**
     * Touch events are handled by default; if you want to customize your handlers, please override these functions:
     */
    public native void handleTouchesBegin(int num, int ids[], float xs[], float ys[]);

    public native void handleTouchesMove(int num, int ids[], float xs[], float ys[]);

    public native void handleTouchesEnd(int num, int ids[], float xs[], float ys[]);

    public native void handleTouchesCancel(int num, int ids[], float xs[], float ys[]);

    /**
     * Get the opengl view port rectangle.
     */
    @ByRef
    @Const
    public native Rect getViewPortRect();

    /**
     * Get scale factor of the horizontal direction.
     */
    public native float getScaleX();

    /**
     * Get scale factor of the vertical direction.
     */
    public native float getScaleY();

    /**
     * returns the current Resolution policy
     */
    @Cast("int")
    public native int getResolutionPolicy();
}
