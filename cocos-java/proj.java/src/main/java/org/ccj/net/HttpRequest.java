/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.net;

import com.googlecode.javacpp.FunctionPointer;
import com.googlecode.javacpp.annotation.ByVal;
import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Parent;
import com.googlecode.javacpp.annotation.Platform;
import com.googlecode.javacpp.annotation.Target;
import com.googlecode.javacpp.annotation.Type;
import org.ccj.base.Ref;
import org.ccj.base.VectorString;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-2-22 上午10:33 $
 *          $Id$
 */

@Platform(include = "network/HttpRequest.h")
@Namespace("cocos2d::network")
@com.googlecode.javacpp.annotation.Opaque
public class HttpRequest extends Ref
{
    public static final int GET = 0,
        POST = 1,
        PUT = 2,
        DELETE = 3,
        UNKNOWN = 3;

    public HttpRequest()
    {
        allocate();
    }

    //
    native void allocate();

    /**
     * Required field for HttpRequest object before being sent.
     * kHttpGet & kHttpPost is currently supported
     */
    public native void setRequestType(@Cast("cocos2d::network::HttpRequest::Type") int type);

    /**
     * Get back the kHttpGet/Post/... enum value
     */
    @Cast("cocos2d::network::HttpRequest::Type")
    public native int getRequestType();

    /**
     * Required field for HttpRequest object before being sent.
     */
    public native void setUrl(String url);

    /**
     * Get back the setted url
     */
    public native String getUrl();

    /**
     * Option field. You can set your post data here
     */
    public native void setRequestData(String buffer, int len);

    public void setRequestData(String buffer)
    {
        if (buffer == null) {
            return;
        }
        setRequestData(buffer, buffer.length());
    }

    /**
     * Get the request data pointer back
     */
    public native String getRequestData();

    /**
     * Get the size of request data back
     */
    public native int getRequestDataSize();

    /**
     * Option field. You can set a string tag to identify your request, this tag can be found in HttpResponse->getHttpRequest->getTag()
     */
    public native void setTag(String tag);

    /**
     * Get the string tag back to identify the request.
     * The best practice is to use it in your MyClass::onMyHttpRequestCompleted(sender, HttpResponse*) callback
     */
    public native String getTag();

    /** Option field. You can attach a customed data in each request, and get it back in response callback.
     But you need to new/delete the data pointer manully
     */
//          public  native  void setUserData(void* pUserData);

    /** Get the pre-setted custom data pointer back.
     Don't forget to delete it. HttpClient/HttpResponse/HttpRequest will do nothing with this pointer
     */
//          public  native  void* getUserData();

    /** Required field. You should set the callback selector function at ack the http request completed
     */
//        CC_DEPRECATED_ATTRIBUTE   public  native  void setResponseCallback(cocos2d::Object* pTarget, cocos2d::SEL_CallFuncND pSelector);

//          public  native  void setResponseCallback(cocos2d::Object* pTarget, SEL_HttpResponse pSelector);

    /** Get the target of callback selector funtion, mainly used by HttpClient */
//          public  native  cocos2d::Object* getTarget();

//        /* This sub class is just for migration SEL_CallFuncND to SEL_HttpResponse, 
//           someday this way will be removed */
//        class _prxy
//        {
//        public:
//            _prxy( SEL_HttpResponse cb ) :_cb(cb) {}
//            ~_prxy(){};
//            operator SEL_HttpResponse() const { return _cb; }
//            CC_DEPRECATED_ATTRIBUTE operator cocos2d::SEL_CallFuncND()   const { return (cocos2d::SEL_CallFuncND) _cb; }
//        protected:
//            SEL_HttpResponse _cb;
//        };
//        
//        /** Get the selector function pointer, mainly used by HttpClient */
//          public  native  _prxy getSelector()
//        {
//            return _prxy(_pSelector);
//        }

    /**
     * Set any custom headers *
     */
    public native void setHeaders(@ByVal VectorString pHeaders);

    /**
     * Get custom headers *
     */
    @ByVal
    public native VectorString getHeaders();

    public void setResponseCallback(HttpResponseCallback target)
    {
        setResponseCallback(target, target);
    }


    private native void setResponseCallback(@Target @Cast("cocos2d::Ref *") HttpResponseCallback target, HttpResponseCallback selector);


    @Type("cocos2d::network::SEL_HttpResponse")
    @Parent("cocos2d::Ref")
    public static class HttpResponseCallback
        extends FunctionPointer
    {
        public HttpResponseCallback()
        {
            allocate();
        }

        public native void allocate();

        public void onSuccess(HttpClient client, HttpResponse response)
        {

        }

        public void onError(HttpClient client, HttpResponse response)
        {

        }

        public void onResult(HttpClient client, HttpResponse response)
        {
            if (response.getResponseCode() == 20) {
                onSuccess(client, response);
            }
            else {
                onError(client, response);
            }
        }

        private void call(HttpClient client, HttpResponse response)
        {
            onResult(client, response);
        }
    }
}
