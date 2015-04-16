package org.cce.controller;

import org.cce.framework.GamePlayerClient;
import org.ccj.base.Touch;
import org.ccj.d2.Layer;
import org.ccj.d2.Sprite;
import org.ccj.editor.cce.CCEBind;
import org.ccj.editor.cce.CCEController;
import org.ccj.event.Event;
import org.ccj.event.EventHandlerTouchOne;
import org.ccj.event.EventKeyboard;
import org.ccj.event.EventListenerTouchOneByOne;
import org.ccj.math.Rect;
import org.ccj.math.Size;
import org.ccj.math.Vec2;

/**
 * Created by yuanyou on 2014/12/18.
 */
public class ControllerDirection
        extends CCEController {

    @CCEBind("dir")
    public Sprite dir;

    int position = 0;

    @Override
    public void onEnter() {
        super.onEnter();

        EventListenerTouchOneByOne.create(new EventHandlerTouchOne() {
            @Override
            public boolean onTouchBegan(Touch touch, Event event) {
                handleDir(touch, 0);
                return true;
            }

            @Override
            public void onTouchMoved(Touch touch, Event event) {
                handleDir(touch, 1);
            }

            @Override
            public void onTouchEnded(Touch touch, Event event) {
                handleDir(touch, 2);
            }

            @Override
            public void onTouchCancelled(Touch touch, Event event) {
            }
        }).addWithSceneGraphPriority(getOwner());
    }

    public void handleDir(Touch touch, int action) {
        Rect rect = dir.getBoundingBox();
        if (action == 0 || action == 1) {
            if (rect.containsPoint(touch.getLocation())) {
                Vec2 pos = dir.convertToNodeSpace(touch.getLocation());
                float px = pos.getX();
                float py = pos.getY();
                if (px < 215) {
                    position = 0;
                    dir.setTexture("textures/remotecontrol_5way_pressed_left.png");
                } else if (px >= 215 && px < 414) {
                    if (py < 215) {
                        position = 2;
                        dir.setTexture("textures/remotecontrol_5way_pressed_down.png");
                    } else if (py > 215 && py < 414) {
                        position = 4;
                        dir.setTexture("textures/remotecontrol_5way_pressed_center.png");
                    } else {
                        position = 3;
                        dir.setTexture("textures/remotecontrol_5way_pressed_up.png");
                    }
                } else {
                    position = 1;
                    dir.setTexture("textures/remotecontrol_5way_pressed_right.png");
                }
            }
        } else {
            dir.setTexture("textures/remotecontrol_5way_normal.png");
        }

        if (position == 0) {
            GamePlayerClient.getInstance().sendKeyEvent(EventKeyboard.KEY_LEFT_ARROW, action == 2 ? 1 : 0);
        } else if (position == 1) {
            GamePlayerClient.getInstance().sendKeyEvent(EventKeyboard.KEY_RIGHT_ARROW, action == 2 ? 1 : 0);
        } else if (position == 2) {
            GamePlayerClient.getInstance().sendKeyEvent(EventKeyboard.KEY_DOWN_ARROW, action == 2 ? 1 : 0);
        } else if (position == 3) {
            GamePlayerClient.getInstance().sendKeyEvent(EventKeyboard.KEY_UP_ARROW, action == 2 ? 1 : 0);
        } else if (position == 4) {
            GamePlayerClient.getInstance().sendKeyEvent(EventKeyboard.KEY_ENTER, action == 2 ? 1 : 0);
        }
    }

    @Override
    public void onExit() {
        super.onExit();
    }
}


