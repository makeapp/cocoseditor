/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.net;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import org.ccj.base.VectorChar;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-3-6 上午11:21 $
 *          $Id$
 */
@Platform(include = "network/HttpResponse.h")
@Namespace("cocos2d::network")
@com.googlecode.javacpp.annotation.Opaque
public class HttpResponse extends Pointer
{

    /**
     * Override autorelease method to prevent developers from calling it
     */
//    public native cc.lang.Object autorelease();

    // getters, will be called by users

    /**
     * Get the corresponding HttpRequest object which leads to this response
     * There's no paired setter for it, coz it's already setted in class constructor
     */
    public native HttpRequest getHttpRequest();

    /**
     * To see if the http reqeust is returned successfully,
     * Althrough users can judge if (http return code = 200), we want an easier way
     * If this getter returns false, you can call getResponseCode and getErrorBuffer to find more details
     */
    public native boolean isSucceed();

    /**
     * Get the http response raw data
     */
    public native VectorChar getResponseData();

    /**
     * get the Rawheader *
     */
    public native VectorChar getResponseHeader();

    /**
     * Get the http response errorCode
     * I know that you want to see http 200 :)
     */
    public native long getResponseCode();

    /**
     * Get the rror buffer which will tell you more about the reason why http request failed
     */
    public native String getErrorBuffer();

    // setters, will be called by HttpClient
    // users should avoid invoking these methods


    /**
     * Set if the http request is returned successfully,
     * Althrough users can judge if (http code == 200), we want a easier way
     * This setter is mainly used in HttpClient, users mustn't set it directly
     */
//    public native void setSucceed(@Cast("bool") boolean value);


    /**
     * Set the http response raw buffer, is used by HttpClient
     */
//    public native void setResponseData(VectorChar data);

    /**
     * Set the http response Header raw buffer, is used by HttpClient
     */
//    public native void setResponseHeader(VectorChar data);


    /**
     * Set the http response errorCode
     */
//    public native void setResponseCode(long value);


    /**
     * Set the error buffer which will tell you more the reason why http request failed
     */
//    public native void setErrorBuffer(String value);
}
