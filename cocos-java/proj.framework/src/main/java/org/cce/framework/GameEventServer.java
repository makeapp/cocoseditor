package org.cce.framework;

import com.makeapp.framework.mconn.*;
import com.makeapp.javase.lang.StringUtil;
import com.makeapp.javase.lifecycle.Lifecycle;
import org.cce.framework.event.EventPeer;
import org.cce.framework.pp.GameEventPeerAction;
import org.glassfish.grizzly.Connection;
import org.glassfish.grizzly.filterchain.FilterChainContext;
import org.glassfish.grizzly.filterchain.NextAction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuanyou on 2014/12/17.
 */
public class GameEventServer extends Lifecycle {

    List<GameEventPeer> peers = new ArrayList();

    MessageAgent messageAgent = new MessageAgent();

    static GameEventServer instance;

    public static GameEventServer getInstance() {
        if (instance == null) {
            instance = new GameEventServer();
        }
        return instance;
    }

    public List<GameEventPeer> getPeers() {
        return peers;
    }

    private int port = 8001;

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    protected void doInit() {

        final GameEventDispatcher messageDispatcher = new GameEventDispatcher(this);

        messageAgent.init(new MessageCodec() {
            public NextAction handleAccept(FilterChainContext ctx)
                    throws IOException {
                handleConnect(ctx);

                return super.handleAccept(ctx);
            }

            @Override
            public NextAction handleConnect(FilterChainContext ctx) throws IOException {
                final Connection connection = ctx.getConnection();
                final String pid = MessageUtil.getPeerId(connection);
                return super.handleConnect(ctx);
            }

            @Override
            public NextAction handleClose(FilterChainContext ctx) throws IOException {
                final Connection connection = ctx.getConnection();
                final String pid = MessageUtil.getPeerId(connection);

                GameEventPeer peer = null;
                for (GameEventPeer player : peers) {
                    if (StringUtil.equals(pid, player.getPeerId())) {
                        peers.remove(player);
                        peer = player;
                        break;
                    }
                }

                if (peer != null) {
                    GameEventPeerAction exit = new GameEventPeerAction();
                    exit.setPeer(peer);
                    exit.setAction(EventPeer.EXIT);
                    exit.setPeerID(pid);
                    exit.setTargetId("*");

                    messageDispatcher.handle(messageAgent, exit);
                }
                return super.handleClose(ctx);
            }
        });
        messageAgent.bind(port);
        messageAgent.setMessageHandler(messageDispatcher);
        messageAgent.start();
    }

    @Override
    protected void doStart() {

    }

    @Override
    protected void doStop() {

    }

    @Override
    protected void doDestroy() {

    }

    public static void main(String[] args) {
        GameEventServer gameServer = new GameEventServer();
        gameServer.start();
        try {
            Thread.sleep(10000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
