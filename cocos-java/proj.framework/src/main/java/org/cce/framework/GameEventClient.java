package org.cce.framework;

import com.makeapp.framework.mconn.MessageAgent;
import com.makeapp.framework.mconn.MessageCodec;
import com.makeapp.framework.mconn.MessagePacket;
import com.makeapp.framework.mconn.MessageUtil;
import com.makeapp.javase.lang.ObjectUtil;
import com.makeapp.javase.lifecycle.LifecycleThread;
import org.cce.framework.event.EventPeer;
import org.cce.framework.pp.*;
import org.ccj.base.Acceleration;
import org.ccj.base.Ref;
import org.ccj.base.Touch;
import org.ccj.math.Vec2;
import org.glassfish.grizzly.Connection;
import org.glassfish.grizzly.filterchain.BaseFilter;
import org.glassfish.grizzly.filterchain.FilterChainContext;
import org.glassfish.grizzly.filterchain.NextAction;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Map;

/**
 * Created by yuanyou on 2014/12/17.
 */
public class GameEventClient
        extends LifecycleThread {
    final MessageAgent messageAgent = new MessageAgent();
    String peerId;
    LinkedList<MessagePacket> queue = new LinkedList();
    private String host = "127.0.0.1";

    private int port = 8001;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public MessagePacket peekEvent() {
        synchronized (queue) {
            if (queue.size() > 0) {
                return queue.removeFirst();
            }
        }
        return null;
    }

    @Override
    protected void doInit() {
        super.doInit();
        messageAgent.init(new MessageCodec(), new BaseFilter() {
            @Override
            public NextAction handleConnect(FilterChainContext ctx) throws IOException {
                final Connection connection = ctx.getConnection();
                peerId = MessageUtil.getPeerId(connection);
                onConnected();

                return super.handleConnect(ctx);
            }

            @Override
            public NextAction handleClose(FilterChainContext ctx) throws IOException {
                onDisconnected();
                peerId = null;
                return super.handleClose(ctx);
            }
        });
        messageAgent.setMessageHandler(GameEventHandler.getInstance());
    }


    @Override
    protected void doRun() throws Exception {

        messageAgent.start();
        peerId = messageAgent.connect(host, port);

        for (; ; ) {
            try {
                MessagePacket event = peekEvent();
                if (event != null) {
                    System.out.printf("EventClient send "+event);
                    messageAgent.sendMessage(event);
                } else {
                    ObjectUtil.wait(queue, 5000);
                }
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isConnected() {
        return peerId != null;
    }


    public void sendTouchEvent(String target,Touch touch, int action) {
        if (peerId == null) {
            return;
        }

        Vec2 point = touch.getLocationInView();

        GameEventTouch touchEvent = new GameEventTouch();
        touchEvent.setX(point.getX());
        touchEvent.setY(point.getY());
        touchEvent.setAction(action);
        touchEvent.setTargetId(target);
        send(touchEvent);
    }

    private void send(GameEventMessage touchEvent) {
        touchEvent.setPeerID(peerId);
        queue.add(touchEvent);
        ObjectUtil.notifyAll(queue);
    }


    public void sendTouchEvent(String target,Touch[] touches, int action) {
        if (peerId == null) {
            return;
        }
        float x[] = new float[touches.length];
        float y[] = new float[touches.length];
        for (int i = 0; i < touches.length; i++) {
            Vec2 point = touches[i].getLocation();
            x[i] = point.getX();
            y[i] = point.getY();
        }

        GameEventTouches touchEvent = new GameEventTouches();
        touchEvent.setX(x);
        touchEvent.setY(y);
        touchEvent.setAction(action);
        touchEvent.setTargetId(target);

        send(touchEvent);

    }

    public void sendKeyEvent(String target,int keyCode, int action) {
        if (peerId == null) {
            return;
        }
        GameEventKeyboard keyEvent = new GameEventKeyboard();
        keyEvent.setKeyCode(keyCode);
        keyEvent.setAction(action);
        keyEvent.setTargetId(target);

        send(keyEvent);
    }

    public void sendAccelerationEvent(String target,Acceleration aac) {
        if (peerId == null) {
            return;
        }
        GameEventAcceleration keyEvent = new GameEventAcceleration();
        keyEvent.setX((float) aac.getX());
        keyEvent.setY((float) aac.getY());
        keyEvent.setZ((float) aac.getZ());
        keyEvent.setTargetId(target);
        send(keyEvent);
    }

    public void sendCustomEvent(String targetId, String eventName) {
        sendCustomEvent(targetId, eventName, null);
    }

    public void sendCustomEvent(String targetId, String eventName, Map values) {
        if (peerId == null) {
            return;
        }
        GameEventCustom eventCustom = new GameEventCustom();
        eventCustom.setEventName(eventName);
        eventCustom.setTargetId(targetId);
        if (values != null) {
            eventCustom.getValues().putAll(values);
        }
        send(eventCustom);
    }

    static GameEventClient instance;

    GameEventPeer peer;

    public static GameEventClient getInstance() {
        if (instance == null) {
            instance = new GameEventClient();
        }
        return instance;
    }

    public GameEventPeer getPeer() {
        return peer;
    }

    public void setPeer(GameEventPeer peer) {
        this.peer = peer;
    }

    public void onConnected() {
        GameEventPeerAction register = new GameEventPeerAction();
        register.setPeer(peer);
        register.setAction(EventPeer.ENTER);
        register.setPeerID(peerId);
        register.setTargetId("*");
        peer.setPeerId(peerId);
        try {
            messageAgent.sendMessage(register);
        } catch (IOException e) {
            e.printStackTrace();
        }

        EventPeer eventPlayer = new EventPeer(EventPeer.CONNECTED);
        eventPlayer.setPeerName(getName());
        eventPlayer.setPeerType(getName());
        Ref.putRef(eventPlayer);
        GameEventHandler.getInstance().pushEvent(peerId,eventPlayer);
    }

    public void onDisconnected() {
        EventPeer eventPlayer = new EventPeer(EventPeer.DISCONNECTED);
        eventPlayer.setPeerName(peer.getName());
        eventPlayer.setPeerType(peer.getType());
        Ref.putRef(eventPlayer);
        GameEventHandler.getInstance().pushEvent(peerId,eventPlayer);
    }

    @Override
    protected void doStop() {

    }

    @Override
    protected void doDestroy() {

    }

    public static void main(String[] args) {
        GameEventClient client = new GameEventClient();
        client.setName("test1");
        client.start();

        for (int i = 0; i < 100; i++) {
            client.sendKeyEvent("*",10, 1);
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
