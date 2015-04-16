package org.cce.framework;

import com.makeapp.framework.mconn.MessageAgent;
import com.makeapp.framework.mconn.MessageHandler;
import com.makeapp.framework.mconn.MessagePacket;
import org.cce.framework.event.EventPeer;
import org.cce.framework.pp.*;
import org.ccj.Director;
import org.ccj.base.Acceleration;
import org.ccj.base.MapString;
import org.ccj.base.Ref;
import org.ccj.base.Touch;
import org.ccj.event.*;

import java.util.LinkedList;

/**
 * Created by yuanyou on 2014/12/26.
 */
public class GameEventHandler
        implements MessageHandler {

    private LinkedList queue = new LinkedList();
    static GameEventHandler instance = new GameEventHandler();

    public static GameEventHandler getInstance() {
        return instance;
    }

    public GameEventHandler() {
    }

    public void pollEvent() {
        for (; ; ) {
            Event event = peekEvent();
            if (event != null) {
                dispatchEvent(event);
            } else {
                break;
            }
        }
    }

    public void dispatchEvent(Event event) {
        Director.getInstance().getEventDispatcher().dispatchEvent(event);
    }

    public Event peekEvent() {
        synchronized (queue) {
            if (queue.size() > 0) {
                return (Event) queue.removeFirst();
            }
        }
        return null;
    }

    public void pushEvent(String peerId, Event event) {
        synchronized (queue) {
            event.setSourceId(peerId);
            queue.addLast(event);
        }
    }

    @Override
    public void handle(MessageAgent agent, MessagePacket msg) {
        GameEventMessage gameMessage = (GameEventMessage) msg;

        try {
            handleMessage(msg, gameMessage);
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    private void handleMessage(MessagePacket msg, GameEventMessage gameMessage) {
        System.out.println("handler on msg " + msg);
        String peerId = msg.getPeerID();
        String sourceId = gameMessage.getSourceId();
        if (msg instanceof GameEventKeyboard) {
            GameEventKeyboard keyEvent = (GameEventKeyboard) msg;
            EventKeyboard keyboard = new EventKeyboard(keyEvent.getKeyCode(), keyEvent.getAction() == 0 ? true : false);
            pushEvent(sourceId, keyboard);
        } else if (msg instanceof GameEventTouch) {
            GameEventTouch touchEvent = (GameEventTouch) msg;
            Touch touch = new Touch(0, touchEvent.getX(), touchEvent.getY());
            pushEvent(sourceId, new EventTouch(touch, touchEvent.getAction()));
        } else if (msg instanceof GameEventAcceleration) {
            GameEventAcceleration eventAcceleration = (GameEventAcceleration) msg;
            Acceleration acc = new Acceleration();
            acc.setX(eventAcceleration.getX());
            acc.setY(eventAcceleration.getY());
            acc.setZ(eventAcceleration.getZ());
//            acc.setTimestamp(eventAcceleration.get);
            EventAcceleration acceleration = new EventAcceleration(acc);
            pushEvent(sourceId, acceleration);
        } else if (msg instanceof GameEventTouches) {
            GameEventTouches touchEvent = (GameEventTouches) msg;
            float[] x = touchEvent.getX();
            float[] y = touchEvent.getY();
            int len = Math.min(x.length, y.length);
            Touch[] touches = new Touch[len];
            for (int i = 0; i < len; i++) {
                touches[i] = new Touch(0, x[i], y[i]);
            }
            pushEvent(sourceId, new EventTouch(touches, touchEvent.getAction()));
        } else if (msg instanceof GameEventCustom) {
            GameEventCustom custom = (GameEventCustom) msg;
            EventCustom eventCustom = new EventCustom(custom.getEventName());
            MapString map = new MapString();
            for (String key : custom.getValues().keySet()) {
                map.put(key, String.valueOf(custom.getValues().get(key)));
            }
            eventCustom.setUserData(map);
            pushEvent(peerId, eventCustom);
        } else if (msg instanceof GameEventPeerAction) {
            GameEventPeerAction custom = (GameEventPeerAction) msg;
            GameEventPeer gamePlayer =custom.getPeer();

            EventPeer eventCustom = new EventPeer(custom.getAction());
            eventCustom.setPeerName(gamePlayer.getName());
            eventCustom.setPeerType(gamePlayer.getType());
            Ref.putRef(eventCustom);
            pushEvent(sourceId, eventCustom);
        }
    }
}
