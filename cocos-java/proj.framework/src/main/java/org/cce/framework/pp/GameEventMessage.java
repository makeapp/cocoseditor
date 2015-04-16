package org.cce.framework.pp;

import com.makeapp.framework.mconn.MessagePacketObject;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * Created by yuanyou on 2014/12/27.
 */
public class GameEventMessage
        extends MessagePacketObject implements Cloneable{

    private String sourceId = "";

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    private String targetId="";

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        super.writeExternal(out);
        if (sourceId == null) {
            sourceId = "";
        }
        out.writeUTF(sourceId);

        if (targetId == null) {
            targetId = "";
        }
        out.writeUTF(targetId);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        super.readExternal(in);
        sourceId = in.readUTF();
        targetId = in.readUTF();
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("GameEventMessage{");
        sb.append("sourceId='").append(sourceId).append('\'');
        sb.append(",peerId='").append(getPeerID()).append('\'');
        sb.append(",targetId='").append(targetId).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
