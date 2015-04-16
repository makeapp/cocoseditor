/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.ui;

import com.googlecode.javacpp.FunctionPointer;
import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.*;
import org.ccj.d2.Node;
import org.ccj.math.Vec2;
import org.ccj.base.Ref;
import org.ccj.math.Size;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-3-6 下午12:03 $
 *          $Id$
 */
@Platform(include = "ui/UICheckBox.h")
@Namespace("cocos2d::ui")
@com.googlecode.javacpp.annotation.Opaque
public class CheckBox
    extends Widget
{
    public static final int CHECKBOX_STATE_EVENT_SELECTED = 0,
        CHECKBOX_STATE_EVENT_UNSELECTED = 1;

    public CheckBox(Pointer p)
    {
        super(p);
    }

    /**
     * Allocates and initializes.
     */
    public native static CheckBox create();

    /**
     * Load textures for checkbox.
     *
     * @param backGround         backGround texture.
     * @param backGroundSelected backGround selected state texture.
     * @param cross              cross texture.
     * @param frontCrossDisabled cross dark state texture.
     * @param texType            @see UI_TEX_TYPE_LOCAL
     */
    public native void loadTextures(String backGround, String backGroundSelected, String cross, String backGroundDisabled, String frontCrossDisabled, @Cast("cocos2d::ui::Widget::TextureResType") int texType);

    public void loadTextures(String backGround, String backGroundSelected, String cross, String backGroundDisabled, String frontCrossDisabled)
    {
        loadTextures(backGround, backGroundSelected, cross, backGroundDisabled, frontCrossDisabled, UI_TEX_TYPE_LOCAL);
    }

    /**
     * Load backGround texture for checkbox.
     *
     * @param backGround backGround texture.
     * @param texType    @see UI_TEX_TYPE_LOCAL
     */
    public native void loadTextureBackGround(String backGround, @Cast("cocos2d::ui::Widget::TextureResType") int type);

    public void loadTextureBackGround(String backGround)
    {
        loadTextureBackGround(backGround, UI_TEX_TYPE_LOCAL);
    }

    /**
     * Load backGroundSelected texture for checkbox.
     *
     * @param backGroundSelected backGround selected state texture.
     * @param texType            @see UI_TEX_TYPE_LOCAL
     */
    public native void loadTextureBackGroundSelected(String backGroundSelected, @Cast("cocos2d::ui::Widget::TextureResType") int texType);

    public void loadTextureBackGroundSelected(String backGroundSelected)
    {
        loadTextureBackGroundSelected(backGroundSelected, UI_TEX_TYPE_LOCAL);
    }

    /**
     * Load cross texture for checkbox.
     *
     * @param cross   cross texture.
     * @param texType @see UI_TEX_TYPE_LOCAL
     */
    public native void loadTextureFrontCross(String cross, @Cast("cocos2d::ui::Widget::TextureResType") int texType);

    public void loadTextureFrontCross(String cross)
    {
        loadTextureFrontCross(cross, UI_TEX_TYPE_LOCAL);
    }

    /**
     * Load backGroundDisabled texture for checkbox.
     *
     * @param backGroundDisabled backGroundDisabled texture.
     * @param texType            @see UI_TEX_TYPE_LOCAL
     */
    public native void loadTextureBackGroundDisabled(String backGroundDisabled, @Cast("cocos2d::ui::Widget::TextureResType") int texType);

    public void loadTextureBackGroundDisabled(String backGroundDisabled)
    {
        loadTextureBackGroundDisabled(backGroundDisabled, UI_TEX_TYPE_LOCAL);
    }

    /**
     * Load frontCrossDisabled texture for checkbox.
     *
     * @param frontCrossDisabled frontCrossDisabled texture.
     * @param texType            @see UI_TEX_TYPE_LOCAL
     */
    public native void loadTextureFrontCrossDisabled(String frontCrossDisabled, @Cast("cocos2d::ui::Widget::TextureResType") int texType);

    public void loadTextureFrontCrossDisabled(String frontCrossDisabled)
    {
        loadTextureFrontCrossDisabled(frontCrossDisabled, UI_TEX_TYPE_LOCAL);
    }

    /**
     * Sets selcted state for checkbox.
     *
     * @param selected true that checkbox is selected, false otherwise.
     */
    public native void setSelectedState(@Cast("bool") boolean selected);

    /**
     * Gets selcted state of checkbox.
     *
     * @return selected    true that checkbox is selected, false otherwise.
     */
    public native boolean getSelectedState();

    // "setAnchorPoint" method of widget.
//    public native void setAnchorPoint(@Const @ByRef Vec2 pt);

    //add a call back function would called when checkbox is selected or unselected.
//    public native void addEventListenerCheckBox(Object*target, SEL_SelectedStateEvent selector);

    // "setFlipX" method of widget.
//    public native void setFlipX(@Cast("bool") boolean flipX);

    // "setFlipY" method of widget.
//    public native void setFlipY(@Cast("bool") boolean flipY);

    // "isFlipX" method of widget.
//    public native boolean isFlipX();

    // "isFlipY" method of widget.
//    public native boolean isFlipY();

    // "onTouchEnded" method of widget.
//    public native void onTouchEnded(Touch*touch, Event*unusedEvent);

    // "getContentSize" method of widget.
//    public native
//    @Const
//    @ByRef
//    Size getContentSize();

    // "getVirtualRenderer" method of widget.
//    public native Node getVirtualRenderer();

    //    public native void addEventListenerCheckBox(Object*target, SEL_SelectedStateEvent selector);

    public void addEventListenerCheckBox(CheckBoxListener listener)
    {
        CheckBoxCallback callback = new CheckBoxCallback(listener);
        addEventListenerCheckBox(callback, callback);
    }

    private native void addEventListenerCheckBox(@Target @Cast("cocos2d::Ref *") CheckBoxCallback target, CheckBoxCallback selector);

    public interface CheckBoxListener
    {
        public void onSelected(Ref ref, int action);
    }

    @Type("cocos2d::ui::SEL_SelectedStateEvent")
    @Parent("cocos2d::Ref")
    private static class CheckBoxCallback
        extends FunctionPointer
    {
        CheckBoxListener listener;

        public CheckBoxCallback(CheckBoxListener listener)
        {
            this.listener = listener;
            allocate();
        }

        public native void allocate();

        public void call(Ref ref, @Cast("cocos2d::ui::CheckBoxEventType") int eventType)
        {
            if (listener != null) {
                listener.onSelected(ref, eventType);
            }
        }
    }

}
