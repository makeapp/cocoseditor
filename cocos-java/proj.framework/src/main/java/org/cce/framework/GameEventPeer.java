package org.cce.framework;

import com.makeapp.framework.mconn.MessageAgent;
import com.makeapp.framework.mconn.MessagePacket;
import com.makeapp.framework.mconn.MessagePeer;
import org.ccj.base.Touch;
import org.ccj.math.Vec2;

import java.io.Serializable;

/**
 * Created by yuanyou on 2014/12/17.
 */
public class GameEventPeer
        implements Serializable{

    private String peerId;

    private String name;

    private String type;

    private byte[] icon;

    public GameEventPeer(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public byte[] getIcon() {
        return icon;
    }

    public void setIcon(byte[] icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPeerId(String peerId) {
        this.peerId = peerId;
    }

    public String getPeerId() {
        return peerId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("GamePeer{");
        sb.append("peerId='").append(peerId).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", type='").append(type).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
