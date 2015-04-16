package org.cce.framework.pp;

import com.makeapp.framework.mconn.MessagePacketObject;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yuanyou on 2014/12/16.
 */
public class GameEventCustom
        extends GameEventMessage implements Cloneable{

    private String eventName;

    private Map<String, Object> values = new HashMap();

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Map<String, Object> getValues() {
        return values;
    }



    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        super.writeExternal(out);
        out.writeUTF(eventName);
        out.writeObject(values);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        super.readExternal(in);
        eventName = in.readUTF();
        values = (Map)in.readObject();
    }


    public String toString() {
        final StringBuffer sb = new StringBuffer("GameEventCustom{");
        sb.append("eventName='").append(eventName).append('\'');
        sb.append(", values=").append(values);
        sb.append('}');
        sb.append(super.toString());
        return sb.toString();
    }
}
