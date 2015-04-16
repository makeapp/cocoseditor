/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.net;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-2-22 上午10:08 $
 *          $Id$
 */

@Platform(include = "network/HttpClient.h")
@Namespace("cocos2d::network")
@com.googlecode.javacpp.annotation.Opaque
public class HttpClient
    extends Pointer
{
    /**
     * Return the shared instance *
     */
    public native static HttpClient getInstance();

    /**
     * Relase the shared instance *
     */
    public native static void destroyInstance();

    /**
     * Enable cookie support. *
     */
    public native void enableCookies(String cookieFile);

    /**
     * Add a get request to task queue
     *
     * @param request a HttpRequest object, which includes url, response callback etc.
     *                please make sure request->_requestData is clear before calling "send" here.
     */
    public native void send(HttpRequest request);


    /**
     * Change the connect timeout
     *
     * @param value The desired timeout.
     */
    public native void setTimeoutForConnect(int value);

    /**
     * Get connect timeout
     *
     * @return int
     */
    public native int getTimeoutForConnect();


    /**
     * Change the download timeout
     *
     * @param value
     */
    public native void setTimeoutForRead(int value);


    /**
     * Get download timeout
     *
     * @return int
     */
    public native int getTimeoutForRead();
}
