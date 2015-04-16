/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.event;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.Allocator;
import com.googlecode.javacpp.annotation.Const;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import com.googlecode.javacpp.annotation.StdString;
import org.ccj.base.MapString;
import org.ccj.base.Ref;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/4/27 13:23 $
 *          $Id$
 */

@Platform(include = "CCEventCustom.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class EventCustom extends Event
{
    public EventCustom(long address) {
        super(address);
    }

    public EventCustom(String name) {
        allocate(name);
    }

    @Allocator
    public native void allocate(@StdString String name);

    @StdString
    @Const
    public native String getEventName();

    /** Sets user data */
    public native void setUserData(Pointer data);

    /** Gets user data */
    public native Pointer getUserData();

    public void setMapString(MapString values){
        setUserData(values);
    }

    public MapString getMapString(){
        Pointer pointer = getUserData();
        if(pointer!=null && pointer.address()>0){
            return new MapString(pointer);
        }else{
            return  null;
        }
    }
}
