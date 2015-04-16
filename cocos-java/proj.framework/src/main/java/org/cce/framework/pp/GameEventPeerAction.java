package org.cce.framework.pp;

import org.cce.framework.GameEventPeer;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * Created by yuanyou on 2014/12/26.
 */
public class GameEventPeerAction
        extends GameEventMessage implements Cloneable{

    int action;

    GameEventPeer peer;

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }

    public GameEventPeer getPeer() {
        return peer;
    }

    public void setPeer(GameEventPeer peer) {
        this.peer = peer;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        super.writeExternal(out);
        out.writeInt(action);
        out.writeObject(peer);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        super.readExternal(in);
        action = in.readInt();
        peer = (GameEventPeer)in.readObject();
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("GameEventPeerEnter{");
        sb.append("peer=").append(peer);
        sb.append("action=").append(action);
        sb.append('}');
        sb.append(super.toString());
        return sb.toString();
    }
}
