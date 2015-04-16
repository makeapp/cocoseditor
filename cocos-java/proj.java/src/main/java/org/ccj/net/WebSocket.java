/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.net;

import com.googlecode.javacpp.annotation.ByRefPtr;
import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.Const;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import com.googlecode.javacpp.annotation.StdString;
import org.ccj.base.Ref;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-2-22 上午10:08 $
 *          $Id$
 */

@Platform(include = "network/WebSocket.h")
@Namespace("cocos2d::network")
@com.googlecode.javacpp.annotation.Opaque
public class WebSocket
    extends Ref
{
    public static final int TIME_OUT = 0,
        CONNECTION_FAILURE = 1,
        UNKNOWN = 2;

    public static final int CONNECTING = 0,
        OPEN = 1,
        CLOSING = 2,
        CLOSED = 3;

    public WebSocket(String url, WebSocketDelegate delegate)
    {
        allocate();
        init(delegate, url);
    }

    public native void allocate();

    /**
     * @param delegate The delegate which want to receive event from websocket.
     * @param url      The URL of websocket server.
     *
     * @return true: Success, false: Failure
     *
     * @brief The initialized method for websocket.
     * It needs to be invoked right after websocket instance is allocated.
     */
    public native boolean init(@ByRefPtr @Const @Cast("cocos2d::network::WebSocket::Delegate&")
                               WebSocketDelegate delegate, @StdString String url);

    /**
     * @brief Sends string data to websocket server.
     */
    public native void send(@StdString String message);

    public void send(byte[] bytes)
    {
        if (bytes == null) {
            return;
        }
        send(bytes, bytes.length);
    }

//    public void send(byte[] bytes, int length)
//    {
//        if (bytes == null) {
//            return;
//        }
//        send(bytes, 0, length);
//    }
//
//    public void send(byte[] bytes, int offset, int length)
//    {
//        if (bytes == null) {
//            return;
//        }
//        send(bytePointer, length);
//    }

    /**
     * @brief Sends binary data to websocket server.
     */
    private native void send(@Cast("const unsigned char *") byte[] data, int len);

    /**
     * @brief Closes the connection to server.
     */
    public native void close();

    /**
     * @brief Gets current state of connection.
     */
    @Cast("cocos2d::network::WebSocket::State")
    public native int getReadyState();
}
