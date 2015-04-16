package org.cce.controller;

import org.cce.framework.GameMessageHandler;
import org.cce.framework.GamePlayerClient;
import org.ccj.Director;
import org.ccj.base.Touch;
import org.ccj.d2.Sprite;
import org.ccj.d2.action.FadeOut;
import org.ccj.editor.cce.CCEBind;
import org.ccj.editor.cce.CCEController;
import org.ccj.event.*;
import org.ccj.math.Vec2;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuanyou on 2014/12/17.
 */
public class ControllerTouch
        extends CCEController {

    @CCEBind("touch")
    public Sprite touchSprite;
    @CCEBind
    public Sprite left;
    @CCEBind
    public Sprite right;
    @CCEBind
    public Sprite up;
    @CCEBind
    public Sprite down;

    @Override
    public void onEnter() {
        super.onEnter();

        getOwner().scheduleUpdate();
        EventListenerKeyboard listenerKeyboard = EventListenerKeyboard.create(new EventHandlerKeyboard() {
            @Override
            public void onKeyPressed(int keyCode, Event event) {
                GamePlayerClient.getInstance().sendKeyEvent(keyCode, 0);
            }

            @Override
            public void onKeyReleased(int keyCode, Event event) {
                GamePlayerClient.getInstance().sendKeyEvent(keyCode, 1);
            }
        });
        listenerKeyboard.addWithSceneGraphPriority(getOwner());

        EventListenerTouchOneByOne listenerTouchOneByOne = EventListenerTouchOneByOne.create(new EventHandlerTouchOne() {
            @Override
            public boolean onTouchBegan(Touch touch, Event event) {
                touchSprite.setPosition(touch.getLocation());
                touchSprite.setVisible(true);
                touchSprite.stopAllActions();
                touchSprite.setOpacity(255);

                GamePlayerClient.getInstance().sendTouchEvent(touch, EventTouch.EVENT_BEGAN);

                Director.getInstance().getEventDispatcher().dispatchCustomEvent("onClick", null);

                return true;
            }

            @Override
            public void onTouchMoved(Touch touch, Event event) {
                touchSprite.setPosition(touch.getLocation());
                GamePlayerClient.getInstance().sendTouchEvent(touch, EventTouch.EVENT_MOVED);
            }

            @Override
            public void onTouchEnded(Touch touch, Event event) {
                Vec2 start = touch.getStartLocation();
                Vec2 pos = touch.getLocation();

                float xDis = pos.getX() - start.getX();
                float yDis = pos.getY() - start.getY();
                Sprite dirSprite = null;
                if (Math.abs(xDis) > Math.abs(yDis)) {
                    if (xDis > 10) {
                        right.setVisible(true);
                        dirSprite = right;
                    } else if (xDis < -10) {
                        left.setVisible(true);
                        dirSprite = left;
                    }
                } else {
                    if (yDis > 10) {
                        dirSprite = up;
                        up.setVisible(true);
                    } else if (yDis < -10) {
                        dirSprite = down;
                        down.setVisible(true);
                    }
                }
                if (dirSprite != null) {
                    dirSprite.setOpacity(255);
                    dirSprite.runAction(FadeOut.create(0.5f));
                }
                touchSprite.runAction(FadeOut.create(0.5f));
                GamePlayerClient.getInstance().sendTouchEvent(touch, EventTouch.EVENT_ENDED);

                Map values = new HashMap();
                values.put("test","test1");
                GamePlayerClient.getInstance().sendCustomEvent("onClick",values);
            }

            @Override
            public void onTouchCancelled(Touch touch, Event event) {
                GamePlayerClient.getInstance().sendTouchEvent(touch, EventTouch.EVENT_CANCELLED);
            }
        });
        listenerTouchOneByOne.addWithSceneGraphPriority(getOwner());

        EventListenerTouchAllAtOnce listenerTouchAllAtOnce = EventListenerTouchAllAtOnce.create(new EventHandlerTouchAll() {
            @Override
            public void onTouchesBegan(Touch[] touches, Event event) {
              //  System.out.printf("");

                GamePlayerClient.getInstance().sendTouchEvent(touches, EventTouch.EVENT_CANCELLED);
            }

            @Override
            public void onTouchesMoved(Touch[] touches, Event event) {
                GamePlayerClient.getInstance().sendTouchEvent(touches, EventTouch.EVENT_MOVED);
            }

            @Override
            public void onTouchesEnded(Touch[] touches, Event event) {
                GamePlayerClient.getInstance().sendTouchEvent(touches, EventTouch.EVENT_ENDED);
            }

            @Override
            public void onTouchesCancelled(Touch[] touches, Event event) {
                GamePlayerClient.getInstance().sendTouchEvent(touches, EventTouch.EVENT_CANCELLED);
            }
        });
//        listenerTouchAllAtOnce.addWithSceneGraphPriority(getOwner());


    }

    @Override
    public void onUpdate(float delta) {
        super.onUpdate(delta);
        GameMessageHandler.getInstance().pollEvent();
    }

    @Override
    public void onExit() {
        super.onExit();
    }
}
