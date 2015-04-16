package org.cce.framework.pp;

import com.makeapp.framework.mconn.MessagePacketObject;
import com.makeapp.framework.npp.NPPFooter;
import com.makeapp.framework.npp.NPPHeader;
import com.makeapp.framework.npp.NPPMessage;
import com.makeapp.framework.npp.NPPRequest;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * Created by yuanyou on 2014/12/16.
 */
public class GameEventKeyboard
        extends GameEventMessage implements Cloneable{

    int keyCode = 0;
    int action = 0;

    public int getKeyCode() {
        return keyCode;
    }

    public void setKeyCode(int keyCode) {
        this.keyCode = keyCode;
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
        out.writeInt(keyCode);
        out.writeByte(action);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        super.readExternal(in);

        keyCode = in.readInt();
        action = in.readByte();
    }

    @Override
    public String toString() {
        return "TVCKeyEvent{" +
                "keyCode=" + keyCode +
                ", action=" + action +
                '}'+super.toString();
    }
}
