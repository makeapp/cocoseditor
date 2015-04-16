package org.cce.framework.pp;

import com.makeapp.framework.mconn.MessagePacketObject;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * Created by yuanyou on 2014/12/16.
 */
public class GameEventTouches extends GameEventMessage implements Cloneable{

    private float x[];
    private float y[];
    private int action;


    public float[] getY() {
        return y;
    }

    public void setY(float[] y) {
        this.y = y;
    }

    public float[] getX() {
        return x;
    }

    public void setX(float[] x) {
        this.x = x;
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
        out.writeByte(x.length);
        for (int i = 0; i < x.length; i++) {
            out.writeFloat(x[i]);
        }

        out.writeByte(y.length);
        for (int i = 0; i < y.length; i++) {
            out.writeFloat(y[i]);
        }

        out.writeByte(action);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        super.readExternal(in);
        int len = in.readByte();
        x = new float[len];
        for (int i = 0; i < len; i++) {
            x[i] = in.readFloat();
        }
        len = in.readByte();
        y = new float[len];
        for (int i = 0; i < len; i++) {
            y[i] = in.readFloat();
        }
        action = in.readByte();
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("GameEventTouches{");
        sb.append("x=");
        if (x == null) sb.append("null");
        else {
            sb.append('[');
            for (int i = 0; i < x.length; ++i)
                sb.append(i == 0 ? "" : ", ").append(x[i]);
            sb.append(']');
        }
        sb.append(", y=");
        if (y == null) sb.append("null");
        else {
            sb.append('[');
            for (int i = 0; i < y.length; ++i)
                sb.append(i == 0 ? "" : ", ").append(y[i]);
            sb.append(']');
        }
        sb.append(", action=").append(action);
        sb.append('}');
        sb.append(super.toString());
        return sb.toString();
    }
}
