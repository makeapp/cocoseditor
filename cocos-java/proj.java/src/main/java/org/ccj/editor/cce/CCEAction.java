package org.ccj.editor.cce;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface CCEAction {
    /**
     * The second element gets used as a suffix to work around arrays of anonymous struct or union.
     */
    ActionType value();

    enum ActionType {
        WidgetTouch, WidgetTouchDown, WidgetTouchMove, WidgetTouchUp, MenuItemClicked, CallBack;
    }

}
