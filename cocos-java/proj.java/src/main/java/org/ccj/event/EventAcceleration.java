package org.ccj.event;

import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.Const;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import org.ccj.base.Acceleration;

/**
 * Created by yuanyou on 2014/12/16.
 */

@Platform(include = "CCEventAcceleration.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class EventAcceleration extends Event {

    public EventAcceleration(long address) {
        super(address);
    }

    public EventAcceleration(Acceleration acc) {
        allocate(acc);
    }

    public native void allocate(@Const @ByRef Acceleration an);

    public native Acceleration getAcceleration();

}
