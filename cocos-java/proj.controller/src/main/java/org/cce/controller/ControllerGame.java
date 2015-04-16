package org.cce.controller;

import org.cce.framework.GameMessageHandler;
import org.cce.framework.event.EventPlayer;
import org.ccj.base.MapString;
import org.ccj.base.Ref;
import org.ccj.base.Touch;
import org.ccj.d2.Sprite;
import org.ccj.d2.action.FadeOut;
import org.ccj.editor.cce.CCEBind;
import org.ccj.editor.cce.CCEController;
import org.ccj.event.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuanyou on 2014/12/21.
 */
public class ControllerGame
        extends CCEController {

    @CCEBind("touch")
    public Sprite touchSprite;

    Map<String, Sprite> spriteMap = new HashMap();

    @Override
    public void onEnter() {
        super.onEnter();
        getOwner().scheduleUpdate();
        EventListenerCustom eventListenerCustom = EventListenerCustom.create("player", new EventHandlerCustom() {
            @Override
            public void onCustom(String eventName, Event event) {
                EventPlayer eventPlayer = (EventPlayer) Ref.getRef(event.address());
                if (eventPlayer.getAction() == EventPlayer.ENTER) {
                    Sprite sprite = Sprite.createWithSpriteFrameName("rc_remotecontrol_cursor.png");
                    spriteMap.put(eventPlayer.getID(), sprite);
                    getOwner().addChild(sprite);
                } else if (eventPlayer.getAction() == EventPlayer.EXIT) {
                    Sprite sprite = spriteMap.get(eventPlayer.getSourceId());
                    if (sprite != null) {
                        sprite.removeFromParent();
                    }
                }
            }
        });
        eventListenerCustom.addWithSceneGraphPriority(getOwner());
        EventListenerKeyboard listenerKeyboard = EventListenerKeyboard.create(new EventHandlerKeyboard() {
            @Override
            public void onKeyPressed(int keyCode, Event event) {
                System.out.println("onKeyPressed " + keyCode + event);
            }

            @Override
            public void onKeyReleased(int keyCode, Event event) {
                System.out.println("onKeyReleased " + keyCode + event);
            }
        });
        listenerKeyboard.addWithSceneGraphPriority(getOwner());

        EventListenerCustom custom = EventListenerCustom.create("onClick", new EventHandlerCustom() {
            @Override
            public void onCustom(String eventName, Event event) {
                EventCustom eventCustom = (EventCustom) event;
                MapString values = eventCustom.getMapString();
                if(values!=null){
                    System.out.println("onCustom " + eventName +" "+ values.get("test"));
                }else{
                    System.out.println("onCustom " + eventName );
                }
            }
        });
        custom.addWithSceneGraphPriority(getOwner());

        EventListenerTouchOneByOne listenerTouchOneByOne = EventListenerTouchOneByOne.create(new EventHandlerTouchOne() {
            @Override
            public boolean onTouchBegan(Touch touch, Event event) {
                System.out.println("onTouchBegan " + touch);
                touchSprite.setPosition(touch.getLocation());
                touchSprite.setVisible(true);
                touchSprite.stopAllActions();
                touchSprite.setOpacity(255);
                return true;
            }

            @Override
            public void onTouchMoved(Touch touch, Event event) {
                System.out.println("onTouchMoved " + event);
                touchSprite.setPosition(touch.getLocation());

            }

            @Override
            public void onTouchEnded(Touch touch, Event event) {
//                System.out.println("onTouchEnded " + touch);

//                touchSprite.runAction(FadeOut.create(0.5f));

                Sprite touchSprite = spriteMap.get(event.getSourceId());
                if (touchSprite != null) {
                    touchSprite.runAction(FadeOut.create(0.5f));
                }
            }

            @Override
            public void onTouchCancelled(Touch touch, Event event) {
//                System.out.println("onTouchCancelled " + touch);
            }
        });
//        listenerTouchOneByOne.addWithSceneGraphPriority(getOwner());

        EventListenerTouchAllAtOnce eventListenerTouchAllAtOnce = EventListenerTouchAllAtOnce.create(new EventHandlerTouchAll() {
            @Override
            public void onTouchesBegan(Touch[] touches, Event event) {
//                System.out.println("onTouchesBegan " + touches.length);
            }

            @Override
            public void onTouchesMoved(Touch[] touches, Event event) {
//                System.out.println("onTouchesMoved " + event);
                for (Touch touch : touches) {
//                    touchSprite.setPosition(touch.getLocation());
                    Sprite touchSprite = spriteMap.get(event.getSourceId());
                    if (touchSprite != null) {
                        touchSprite.setPosition(touch.getLocation());
                    }
                }
            }

            @Override
            public void onTouchesEnded(Touch[] touches, Event event) {
//                System.out.println("onTouchesEnded " + touches.length);
            }

            @Override
            public void onTouchesCancelled(Touch[] touches, Event event) {

            }
        });
        eventListenerTouchAllAtOnce.addWithSceneGraphPriority(getOwner());
    }


    @Override
    public void onExit() {
        super.onExit();
    }

    @Override
    public void onUpdate(float delta) {
        super.onUpdate(delta);
        GameMessageHandler.getInstance().pollEvent();
    }

}
