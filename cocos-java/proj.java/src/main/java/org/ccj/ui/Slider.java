/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.ui;

import com.googlecode.javacpp.FunctionPointer;
import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.*;
import org.ccj.d2.Node;
import org.ccj.math.Rect;
import org.ccj.base.Ref;
import org.ccj.math.Size;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-3-6 下午12:03 $
 *          $Id$
 */
@Platform(include = "ui/UISlider.h")
@Namespace("cocos2d::ui")
@com.googlecode.javacpp.annotation.Opaque
public class Slider
    extends Widget
{
    public static final int UI_TEX_TYPE_LOCAL = 0;

    public static final int UI_TEX_TYPE_PLIST = 1;

    public Slider(Pointer p)
    {
        super(p);
    }

    /**
     * Allocates and initializes.
     */
    public native static Slider create();

    /**
     * Load texture for slider bar.
     *
     * @param fileName file name of texture.
     * @param texType  @see UI_TEX_TYPE_LOCAL
     */
    public native void loadBarTexture(String fileName, @Cast("cocos2d::ui::Widget::TextureResType") int texType);

    public void loadBarTexture(String fileName)
    {
        loadBarTexture(fileName, UI_TEX_TYPE_LOCAL);
    }

    /**
     * Sets if slider is using scale9 renderer.
     *
     * @param true that using scale9 renderer, false otherwise.
     */
    public native void setScale9Enabled(@Cast("bool") boolean able);

    /**
     * Sets capinsets for slider, if slider is using scale9 renderer.
     *
     * @param capInsets capinsets for slider
     */
    public native void setCapInsets(@Const @ByRef Rect capInsets);

    /**
     * Sets capinsets for slider, if slider is using scale9 renderer.
     *
     * @param capInsets capinsets for slider
     */
    public native void setCapInsetsBarRenderer(@Const @ByRef Rect capInsets);

    /**
     * Sets capinsets for slider, if slider is using scale9 renderer.
     *
     * @param capInsets capinsets for slider
     */
    public native void setCapInsetProgressBarRebderer(@Const @ByRef Rect capInsets);

    /**
     * Load textures for slider ball.
     *
     * @param slider  ball normal    normal state texture.
     * @param slider  ball selected    selected state texture.
     * @param slider  ball disabled    dark state texture.
     * @param texType @see UI_TEX_TYPE_LOCAL
     */
    public native void loadSlidBallTextures(String normal, String pressed, String disabled, @Cast("cocos2d::ui::Widget::TextureResType") int texType);

    public void loadSlidBallTextures(String normal, String pressed, String disabled)
    {
        loadSlidBallTextures(normal, pressed, disabled, UI_TEX_TYPE_LOCAL);
    }

    /**
     * Load normal state texture for slider ball.
     *
     * @param normal  normal state texture.
     * @param texType @see UI_TEX_TYPE_LOCAL
     */
    public native void loadSlidBallTextureNormal(String normal, @Cast("cocos2d::ui::Widget::TextureResType") int texType);

    public void loadSlidBallTextureNormal(String normal)
    {
        loadSlidBallTextureNormal(normal, UI_TEX_TYPE_LOCAL);
    }

    /**
     * Load selected state texture for slider ball.
     *
     * @param selected selected state texture.
     * @param texType  @see UI_TEX_TYPE_LOCAL
     */
    public native void loadSlidBallTexturePressed(String pressed, @Cast("cocos2d::ui::Widget::TextureResType") int texType);

    public void loadSlidBallTexturePressed(String pressed)
    {
        loadSlidBallTexturePressed(pressed, UI_TEX_TYPE_LOCAL);
    }

    /**
     * Load dark state texture for slider ball.
     *
     * @param disabled dark state texture.
     * @param texType  @see UI_TEX_TYPE_LOCAL
     */
    public native void loadSlidBallTextureDisabled(String disabled, @Cast("cocos2d::ui::Widget::TextureResType") int texType);

    public void loadSlidBallTextureDisabled(String disabled)
    {
        loadSlidBallTextureDisabled(disabled, UI_TEX_TYPE_LOCAL);
    }

    /**
     * Load dark state texture for slider progress bar.
     *
     * @param fileName file path of texture.
     * @param texType  @see UI_TEX_TYPE_LOCAL
     */
    public native void loadProgressBarTexture(String fileName, @Cast("cocos2d::ui::Widget::TextureResType") int texType);

    public void loadProgressBarTexture(String fileName)
    {
        loadProgressBarTexture(fileName, UI_TEX_TYPE_LOCAL);
    }

    /**
     * Changes the progress direction of slider.
     *
     * @param percent percent value from 1 to 100.
     */
    public native void setPercent(int percent);

    /**
     * Gets the progress direction of slider.
     *
     * @return percent    percent value from 1 to 100.
     */
    public native int getPercent();

    /**
     * Add call back function called when slider's percent has changed to slider.
     */
//    public native  void addEventListenerSlider(Object*target, SEL_SlidPercentChangedEvent selector);

//    public native boolean onTouchBegan(Touch*touch, Event*unusedEvent);

//    public native void onTouchMoved(Touch*touch, Event*unusedEvent);

//    public native void onTouchEnded(Touch*touch, Event*unusedEvent);

//    public native void onTouchCancelled(Touch*touch, Event*unusedEvent);

    // "getContentSize" method of widget.
//    @Const
//    @ByRef
//    public native Size getContentSize();

    // "getVirtualRenderer" method of widget.
//    public native Node getVirtualRenderer();

    // "ignoreContentAdaptWithSize" method of widget.
//    public native void ignoreContentAdaptWithSize(@Cast("bool") boolean ignore);

    public void addEventListenerSlider(SliderListener listener)
    {
        SliderCallback callback = new SliderCallback(listener);
        addEventListenerSlider(callback, callback);
    }

    private native void addEventListenerSlider(@Target @Cast("cocos2d::Ref *") SliderCallback target, SliderCallback selector);

    public interface SliderListener
    {
        public void onChanged(Ref ref, int action);
    }

    @Type("cocos2d::ui::SEL_SlidPercentChangedEvent")
    @Parent("cocos2d::Ref")
    private static class SliderCallback
        extends FunctionPointer
    {
        SliderListener listener;

        public SliderCallback(SliderListener listener)
        {
            this.listener = listener;
            allocate();
        }

        public native void allocate();

        public void call(Ref ref, @Cast("cocos2d::ui::SliderEventType") int eventType)
        {
            if (listener != null) {
                listener.onChanged(ref, eventType);
            }
        }
    }
}
