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
public class ControllerJoystick
        extends CCEController {

    @CCEBind("dir")
    public Sprite dir;

    @CCEBind("sensorIcon")
    public Sprite sensorIcon;

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
        if (action == 1 || action == 0) {
            if (rect.containsPoint(touch.getLocation())) {
                Vec2 pos = dir.convertToNodeSpace(touch.getLocation());
                float px = pos.getX();
                float py = pos.getY();
                if (px < 160) {
                    dir.setTexture("textures/joystick_direction_left.png");
                    position = 0;
                    GamePlayerClient.getInstance().sendKeyEvent(EventKeyboard.KEY_LEFT_ARROW, 0);
                } else if (px > 308) {
                    position = 1;
                    GamePlayerClient.getInstance().sendKeyEvent(EventKeyboard.KEY_RIGHT_ARROW, 0);
                    dir.setTexture("textures/joystick_direction_right.png");
                } else {
                    if (py < 229) {
                        position = 2;
                        GamePlayerClient.getInstance().sendKeyEvent(EventKeyboard.KEY_DOWN_ARROW, 0);
                        dir.setTexture("textures/joystick_direction_bottom.png");
                    } else if (py > 234) {
                        position = 3;
                        GamePlayerClient.getInstance().sendKeyEvent(EventKeyboard.KEY_UP_ARROW, 0);
                        dir.setTexture("textures/joystick_direction_top.png");
                    }
                }
            }
        } else {
            dir.setTexture("textures/joystick_direction_normal.png");
            if (position == 0) {
                GamePlayerClient.getInstance().sendKeyEvent(EventKeyboard.KEY_LEFT_ARROW, 1);
            } else if (position == 1) {
                GamePlayerClient.getInstance().sendKeyEvent(EventKeyboard.KEY_RIGHT_ARROW, 1);
            } else if (position == 2) {
                GamePlayerClient.getInstance().sendKeyEvent(EventKeyboard.KEY_DOWN_ARROW, 1);
            } else if (position == 3) {
                GamePlayerClient.getInstance().sendKeyEvent(EventKeyboard.KEY_UP_ARROW, 1);
            }
        }
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

    @CCEBind("LKey")
    @CCEAction(CCEAction.ActionType.WidgetTouch)
    public void onLClicked(Ref ref, int action) {
        if (action == 0) {
            GamePlayerClient.getInstance().sendKeyEvent(EventKeyboard.KEY_L, 0);
        } else if (action == 2) {
            GamePlayerClient.getInstance().sendKeyEvent(EventKeyboard.KEY_L, 1);
        }
    }

    @CCEBind("RKey")
    @CCEAction(CCEAction.ActionType.WidgetTouch)
    public void onRClicked(Ref ref, int action) {
        if (action == 0) {
            GamePlayerClient.getInstance().sendKeyEvent(EventKeyboard.KEY_R, 0);
        } else if (action == 2) {
            GamePlayerClient.getInstance().sendKeyEvent(EventKeyboard.KEY_R, 1);
        }
    }

    @CCEBind("SelectKey")
    @CCEAction(CCEAction.ActionType.WidgetTouch)
    public void onSelectKeyClicked(Ref ref, int action) {
        if (action == 0) {
            GamePlayerClient.getInstance().sendKeyEvent(EventKeyboard.KEY_S, 0);
        } else if (action == 2) {
            GamePlayerClient.getInstance().sendKeyEvent(EventKeyboard.KEY_S, 1);
        }
    }

    @CCEBind("StartKey")
    @CCEAction(CCEAction.ActionType.WidgetTouch)
    public void onStartKeyClicked(Ref ref, int action) {
        if (action == 0) {
            GamePlayerClient.getInstance().sendKeyEvent(EventKeyboard.KEY_S, 0);
        } else if (action == 2) {
            GamePlayerClient.getInstance().sendKeyEvent(EventKeyboard.KEY_S, 1);
        }
    }

    private boolean sensor=false;

    @CCEBind("SensorKey")
    @CCEAction(CCEAction.ActionType.WidgetTouch)
    public void onSensorKeyClicked(Ref ref, int action) {
        if (action == 2) {
            sensor=!sensor;
          if(sensor){
              sensorIcon.setSpriteFrame("rc_icon_sensor_disable.png");
          }else{
              sensorIcon.setSpriteFrame("rc_icon_sensor_enable.png");
          }
        }
    }

    @Override
    public void onExit() {
        super.onExit();
    }
}
