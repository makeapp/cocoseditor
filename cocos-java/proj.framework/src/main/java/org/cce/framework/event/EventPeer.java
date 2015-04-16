package org.cce.framework.event;

import com.makeapp.framework.mconn.MessagePeer;
import org.ccj.event.Event;
import org.ccj.event.EventCustom;

/**
 * Created by yuanyou on 2014/12/22.
 */
public class EventPeer extends EventCustom {

    public static final int ENTER = 0;

    public static final int EXIT = 1;

    public static final int CONNECTED = 2;

    public static final int DISCONNECTED = 3;

    private int action;

    private String peerName;
    private String peerType;


    public EventPeer(int action) {
        super("player");
        this.action = action;
    }

    public String getPeerName() {
        return peerName;
    }

    public void setPeerName(String peerName) {
        this.peerName = peerName;
    }

    public String getPeerType() {
        return peerType;
    }

    public void setPeerType(String peerType) {
        this.peerType = peerType;
    }

    public int getAction() {
        return action;
    }
}
