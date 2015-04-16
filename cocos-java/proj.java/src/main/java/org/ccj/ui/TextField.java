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
@Platform(include = "ui/UITextField.h")
@Namespace("cocos2d::ui")
@com.googlecode.javacpp.annotation.Opaque
public class TextField
    extends Widget
{
    public static final int EVENT_ATTACH_WITH_IME = 0,
        EVENT_DETACH_WITH_IME = 1,
        EVENT_INSERT_TEXT = 2,
        EVENT_DELETE_BACKWARD = 3;

    public TextField(Pointer p)
    {
        super(p);
    }

    public native static TextField create();

    public native void setTouchSize(@ByRef @Const Size size);

    public native void setText(@StdString String text);

    public native void setPlaceHolder(@StdString String value);

    public native void setFontSize(int size);

    public native void setFontName(@StdString String name);

    public native void didNotSelectSelf();

    @StdString
    @Const
    public native String getStringValue();

    //         public native  boolean onTouchBegan(Touch *touch, Event *unusedEvent) override;
    public native void setMaxLengthEnabled(@Cast("bool") boolean enable);

    public native boolean isMaxLengthEnabled();

    public native void setMaxLength(int length);

    public native int getMaxLength();

    public native void setPasswordEnabled(@Cast("bool") boolean enable);

    public native boolean isPasswordEnabled();

    public native void setPasswordStyleText(String styleText);

    //    public native     public native  void update(float dt) ;
    public native boolean getAttachWithIME();

    public native void setAttachWithIME(@Cast("bool") boolean attach);

    public native boolean getDetachWithIME();

    public native void setDetachWithIME(@Cast("bool") boolean detach);

    public native boolean getInsertText();

    public native void setInsertText(@Cast("bool") boolean insertText);

    public native boolean getDeleteBackward();

    public native void setDeleteBackward(@Cast("bool") boolean deleteBackward);

//    public native void setAnchorPoint(@ByRef @Const Vec2 pt);

    /**
     * Returns the "class name" of widget.
     */
//    @StdString
//    @Const
//    public native String getDescription();

//    @ByRef
//    @Const
//    public native Size getContentSize();

//    public native Node getVirtualRenderer();

    public native void attachWithIME();

//    public native void onEnter();

    //    public native     void addEventListenerTextField(Object* target, SEL_TextFieldEvent selecor);

    public void addEventListenerTextField(TextFieldListener listener)
    {
        TextFieldCallback callback = new TextFieldCallback(listener);
        addEventListenerTextField(callback, callback);
    }

    private native void addEventListenerTextField(@Target @Cast("cocos2d::Ref *") TextFieldCallback target, TextFieldCallback selector);

    public static TextField cast(Ref ref)
    {
        return cast(ref, TextField.class);
    }

    public interface TextFieldListener
    {
        public void onChanged(Ref ref, int action);
    }

    @Type("cocos2d::ui::SEL_TextFieldEvent")
    @Parent("cocos2d::Ref")
    private static class TextFieldCallback
        extends FunctionPointer
    {
        TextFieldListener listener;

        public TextFieldCallback(TextFieldListener listener)
        {
            this.listener = listener;
            allocate();
        }

        public native void allocate();

        public void call(Ref ref, @Cast("cocos2d::ui::TextFiledEventType") int eventType)
        {
            if (listener != null) {
                listener.onChanged(ref, eventType);
            }
        }
    }
}
