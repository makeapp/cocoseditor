/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.net;

import com.googlecode.javacpp.annotation.Name;
import com.googlecode.javacpp.annotation.Platform;
import org.ccj.base.Ref;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-3-6 上午11:27 $
 *          $Id$
 */
@Platform(include = "JavaWebSocketDelegate.h")
@Name("ccj::JavaWebSocketDelegate")
@com.googlecode.javacpp.annotation.Opaque
public class WebSocketDelegate extends Ref
{
    public WebSocketDelegate()
    {
        allocate();
        putRef(this);
    }

    public native void allocate();

//    public native void init();

    public void onOpen()
    {
    }

    private static void onOpen(long address)
    {
        WebSocketDelegate delegate = (WebSocketDelegate) getRef(address);
        if (delegate != null) {
            delegate.onOpen();
        }
    }

    public static void onMessage(long address, byte[] data, boolean isBinary)
    {
        WebSocketDelegate delegate = (WebSocketDelegate) getRef(address);
        if (delegate != null) {
            delegate.onMessage(data, isBinary);
        }
    }

    public void onMessage(byte[] data, boolean isBinary)
    {

    }

    public static void onClose(long address)
    {
        WebSocketDelegate delegate = (WebSocketDelegate) getRef(address);
        if (delegate != null) {
            delegate.onClose();
        }
    }

    public void onClose()
    {

    }

    public void onError(int error)
    {

    }

    public static void onError(long address, int error)
    {
        WebSocketDelegate delegate = (WebSocketDelegate) getRef(address);
        if (delegate != null) {
            delegate.onError(error);
        }
    }
}
