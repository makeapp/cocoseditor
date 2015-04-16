package org.cce.game;

import org.cce.controller.GamePlayerClient;
import org.cce.controller.pp.GameEventTouch;
import org.ccj.base.Ref;
import org.ccj.base.Touch;
import org.ccj.d2.Layer;
import org.ccj.d2.Sprite;
import org.ccj.editor.cce.CCEAction;
import org.ccj.editor.cce.CCEBind;
import org.ccj.editor.cce.CCEController;
import org.ccj.event.Event;
import org.ccj.event.EventTouch;
import org.ccj.math.Vec2;

/**
 */
public class SceneController
        extends CCEController {

    @CCEBind()
    public Sprite bgSprite;

    @Override
    public void onEnter() {
        super.onEnter();
//        bgSprite.runAction(Sequence.create(ScaleTo.create(0.5f, 0.3f), ScaleTo.create(0.5f, 1f)));
        setTouchEnabled(true);
        setTouchMode(Touch.MODE_ONE_BY_ONE);
        setKeypadEnabled(true);
        Layer layer = new Layer() {

//            @Override
//            public boolean onTouchBegan(Touch touch) {
//                System.out.println("onTouchBegan " + touch);
//                return true;
//            }
//
//            @Override
//            public void onTouchMoved(Touch touch) {
//                super.onTouchMoved(touch);
//                System.out.println("onTouchMoved touch" + touch);
//            }
//
//            @Override
//            public void onTouchEnded(Touch touch) {
//                super.onTouchEnded(touch);
//            }
        };
        layer.setContentSize(200, 200);
        layer.setTouchEnabled(true);
        layer.setTouchMode(Touch.MODE_ONE_BY_ONE);
        bgSprite.addChild(layer);


    }

    @Override
    public void onExit() {
        super.onExit();
    }

    @Override
    public void onUpdate(float delta) {
        super.onUpdate(delta);
    }

    @CCEBind("closeButton")
    @CCEAction(CCEAction.ActionType.WidgetTouchUp)
    public void onCloseClicked(Ref ref) {

    }

    @Override
    public boolean onTouchBegan(Touch touch,Event e) {
        System.out.println("onTouchBegan" + touch);

        Vec2 point = touch.getLocation();

        GameEventTouch keyEvent = new GameEventTouch();
        keyEvent.setX(point.getX());
        keyEvent.setY(point.getY());
        keyEvent.setAction(0);


        return true;
    }

    @Override
    public void onTouchMoved(Touch touch,Event e) {
        Vec2 point = touch.getLocation();

        GameEventTouch keyEvent = new GameEventTouch();
        keyEvent.setX(point.getX());
        keyEvent.setY(point.getY());
        keyEvent.setAction(1);

    }

    @Override
    public void onKeyPressed(int keyCode,Event e) {

        GamePlayerClient.getInstance().sendKeyEvent(keyCode, 0);
    }

    @Override
    public void onKeyReleased(int keyCode,Event e) {
        System.out.println(" onKeyReleased keyCode" + keyCode);

        GamePlayerClient.getInstance().sendKeyEvent(keyCode, 1);
    }

    @Override
    public void onTouchEnded(Touch touch,Event e) {
        Vec2 point = touch.getLocation();

        GamePlayerClient.getInstance().sendTouchEvent(touch, EventTouch.EVENT_ENDED);
    }
}
