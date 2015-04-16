package org.cce.controller;

import org.cce.framework.GamePlayerClient;
import org.ccj.base.Ref;
import org.ccj.base.Touch;
import org.ccj.d2.Sprite;
import org.ccj.editor.cce.CCEAction;
import org.ccj.editor.cce.CCEBind;
import org.ccj.editor.cce.CCEController;
import org.ccj.event.Event;
import org.ccj.event.EventHandlerTouchOne;
import org.ccj.event.EventKeyboard;
import org.ccj.event.EventListenerTouchOneByOne;
import org.ccj.math.Rect;
import org.ccj.math.Vec2;

/**
 * Created by yuanyou on 2014/12/18.
 */
public class ControllerWheel
        extends CCEController {

    @CCEBind("wheel")
    public Sprite wheel;


    @Override
    public void onEnter() {
        super.onEnter();

        EventListenerTouchOneByOne.create(new EventHandlerTouchOne() {

            @Override
            public boolean onTouchBegan(Touch touch, Event event) {
                return true;
            }

            @Override
            public void onTouchMoved(Touch touch, Event event) {
                wheel.setRotation(70);
            }

            @Override
            public void onTouchEnded(Touch touch, Event event) {
            }

            @Override
            public void onTouchCancelled(Touch touch, Event event) {
            }
        }).addWithSceneGraphPriority(getOwner());
    }


    @CCEBind("XKey")
    @CCEAction(CCEAction.ActionType.WidgetTouch)
    public void onXClicked(Ref ref, int action) {
        if (action == 0) {
            GamePlayerClient.getInstance().sendKeyEvent(EventKeyboard.KEY_X, 0);
        } else if (action == 2) {
            GamePlayerClient.getInstance().sendKeyEvent(EventKeyboard.KEY_X, 1);
        }
    }

    @CCEBind("YKey")
    @CCEAction(CCEAction.ActionType.WidgetTouch)
    public void onYClicked(Ref ref, int action) {
        if (action == 0) {
            GamePlayerClient.getInstance().sendKeyEvent(EventKeyboard.KEY_Y, 0);
        } else if (action == 2) {
            GamePlayerClient.getInstance().sendKeyEvent(EventKeyboard.KEY_Y, 1);
        }
    }

    @CCEBind("AKey")
    @CCEAction(CCEAction.ActionType.WidgetTouch)
    public void onAClicked(Ref ref, int action) {
        if (action == 0) {
            GamePlayerClient.getInstance().sendKeyEvent(EventKeyboard.KEY_A, 0);
        } else if (action == 2) {
            GamePlayerClient.getInstance().sendKeyEvent(EventKeyboard.KEY_A, 1);
        }
    }

    @CCEBind("BKey")
    @CCEAction(CCEAction.ActionType.WidgetTouch)
    public void onBClicked(Ref ref, int action) {
        if (action == 0) {
            GamePlayerClient.getInstance().sendKeyEvent(EventKeyboard.KEY_B, 0);
        } else if (action == 2) {
            GamePlayerClient.getInstance().sendKeyEvent(EventKeyboard.KEY_B, 1);
        }
    }

    @Override
    public void onExit() {
        super.onExit();
    }
}
