package org.cce.framework.pp;

import com.makeapp.framework.mconn.MessagePacketObject;
import com.makeapp.framework.npp.NPPMessage;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * Created by yuanyou on 2014/12/16.
 */
public class GameEventTouch extends GameEventMessage implements Cloneable{

    private float x;
    private float y;
    private int action;

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getAction() {
        return action;
    }

    public void setAction(int action) {
        this.action = action;
    }


    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        super.writeExternal(out);
        out.writeFloat(x);
        out.writeFloat(y);
        out.writeByte(action);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        super.readExternal(in);
        x = in.readFloat();
        y = in.readFloat();
        action = in.readByte();
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("GameEventTouch{");
        sb.append("x=").append(x);
        sb.append(", y=").append(y);
        sb.append(", action=").append(action);
        sb.append('}');
        sb.append(super.toString());
        return sb.toString();
    }
}
