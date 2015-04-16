package org.cce.framework;

import com.makeapp.framework.mconn.MessageAgent;
import com.makeapp.framework.mconn.MessagePacket;
import com.makeapp.javase.lang.StringUtil;
import org.cce.framework.event.EventPeer;
import org.cce.framework.pp.*;

import java.io.IOException;
import java.util.List;

/**
 * Created by yuanyou on 2014/12/26.
 */
public class GameEventDispatcher
        extends GameEventHandler {

    GameEventServer server;

    public GameEventDispatcher(GameEventServer server) {
        this.server = server;
    }

    @Override
    public void handle(MessageAgent agent, MessagePacket msg) {
        GameEventMessage gameMessage = (GameEventMessage) msg;
        List<GameEventPeer> peers = server.getPeers();
        System.out.println("dispatcher on msg " + msg);
        String target = gameMessage.getTargetId();

        if ("*".equals(target) || StringUtil.isInvalid(target)) {//all
            for (GameEventPeer peer : peers) {
                GameEventMessage newMessage = (GameEventMessage) gameMessage.clone();
                try {
                    newMessage.setSourceId(msg.getPeerID());
                    newMessage.setPeerID(peer.getPeerId());
                    agent.sendMessage(newMessage);
                    System.out.println("dispatcher send to peer " + newMessage);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else if (target.startsWith("@")) {
            String id = target.substring(1);
            for (GameEventPeer peer : peers) {
                if (StringUtil.equals(id, peer.getPeerId())) {
                    GameEventMessage newMessage = (GameEventMessage) gameMessage.clone();
                    try {
                        newMessage.setSourceId(msg.getPeerID());
                        newMessage.setPeerID(peer.getPeerId());
                        System.out.println("dispatcher send to peer " + newMessage);
                        agent.sendMessage(newMessage);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else if (target.startsWith("#")) {
            String type = target.substring(1);
            for (GameEventPeer peer : peers) {
                if (StringUtil.equals(peer.getType(), type)) {
                    GameEventMessage newMessage = (GameEventMessage) gameMessage.clone();
                    try {
                        newMessage.setSourceId(msg.getPeerID());
                        newMessage.setPeerID(peer.getPeerId());
                        System.out.println("dispatcher send to peer " + newMessage);
                        agent.sendMessage(newMessage);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        if (msg instanceof GameEventPeerAction) {
            GameEventPeerAction reg = (GameEventPeerAction) msg;
            GameEventPeer peer = reg.getPeer();
            peer.setPeerId(msg.getPeerID());

            if (reg.getAction() == EventPeer.ENTER) {
                for (GameEventPeer player : peers) {
                    try {
                        GameEventPeerAction peerEnter = new GameEventPeerAction();
                        peerEnter.setPeer(player);
                        peerEnter.setSourceId(player.getPeerId());
                        peerEnter.setPeerID(msg.getPeerID());
                        agent.sendMessage(peerEnter);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                peers.add(peer);
            }else if(reg.getAction() == EventPeer.EXIT){
                for (GameEventPeer eventPeer : peers) {
                    if (StringUtil.equals(eventPeer.getPeerId(), msg.getPeerID())) {
                        peers.remove(eventPeer);
                        break;
                    }
                }
            }
        }
    }
}
