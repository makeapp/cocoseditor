package org.ccj.network;

import java.io.UnsupportedEncodingException;

import org.ccj.TestLayer;
import org.ccj.TestScene;
import org.ccj.d2.Label;
import org.ccj.d2.Menu;
import org.ccj.d2.MenuItem;
import org.ccj.d2.MenuItemLabel;
import org.ccj.math.Size;
import org.ccj.base.VectorChar;
import org.ccj.net.HttpClient;
import org.ccj.net.HttpRequest;
import org.ccj.net.HttpResponse;
import org.ccj.net.WebSocket;

/**
 * Created by yuanyou@makeapp.co on 2014/4/19.
 */
public class HttpClientScene extends TestScene
{
    public Class[] getLayers()
    {
        return new Class[]{HttpClientTest.class};
    }

    static public class HttpClientTest extends TestLayer
    {
        HttpClient _wsiSendText = null;
        WebSocket _wsiSendBinary = null;
        WebSocket _wsiError = null;

        Label _sendTextStatus = null;
        Label _sendBinaryStatus = null;
        Label _errorStatus = null;

        int _sendTextTimes = 0;
        int _sendBinaryTimes = 0;

        @Override
        public void onCreate()
        {
            super.onCreate();

            int MARGIN = 40;
            int SPACE = 35;

            Label label = Label.createWithSystemFont("WebSocket Test", "Arial", 28);
            label.setPosition(winSize.width / 2, winSize.height - MARGIN);
            this.addChild(label, 0);

            Menu menuRequest = Menu.create();
            menuRequest.setPosition(0, 0);
            this.addChild(menuRequest);

            // Send Text
            Label labelSendText =Label.createWithSystemFont("HTTP GET", "Arial", 22);
            MenuItemLabel itemSendText = MenuItemLabel.create(labelSendText);
            itemSendText.setOnClickListener(new MenuItem.MenuItemListener()
            {
                public void onClicked(MenuItem item)
                {
                    testGet();
                }
            });
            itemSendText.setPosition(winSize.width / 2, winSize.height - MARGIN - SPACE);
            menuRequest.addChild(itemSendText);

            // Send Binary
            Label labelSendBinary = Label.createWithSystemFont("Send Binary", "Arial", 22);
            MenuItemLabel itemSendBinary = MenuItemLabel.create(labelSendBinary);
            itemSendBinary.setOnClickListener(new MenuItem.MenuItemListener()
            {
                public void onClicked(MenuItem item)
                {
//                        if (_wsiSendText.getReadyState() == WebSocket.OPEN) {
//                            _sendTextStatus.setString("Send Text WS is waiting...");
//                            _wsiSendText.send("Hello WebSocket中文, I'm a text message.".getBytes());
//                        }
//                        else {
//                            _sendTextStatus.setString("send binary websocket instance wasn't ready...");
//                        }
                }
            });
            itemSendBinary.setPosition(winSize.width / 2, winSize.height - MARGIN - 2 * SPACE);
            menuRequest.addChild(itemSendBinary);


            // Send Text Status Label
            this._sendTextStatus = Label.createWithSystemFont("Send Text WS is waiting...", "Arial", 14, new Size(160, 100), Label.TEXTHALIGNMENT_CENTER, Label.TEXTVALIGNMENT_TOP);
            this._sendTextStatus.setAnchorPoint(0, 0);

            this._sendTextStatus.setPosition(0, 25);

            this.addChild(this._sendTextStatus);

            // Send Binary Status Label
            this._sendBinaryStatus =  Label.createWithSystemFont("Send Binary WS is waiting...", "Arial", 14, new Size(160, 100), Label.TEXTHALIGNMENT_CENTER, Label.TEXTVALIGNMENT_TOP);
            this._sendBinaryStatus.setAnchorPoint(0, 0);
            this._sendBinaryStatus.setPosition(160, 25);
            this.addChild(this._sendBinaryStatus);

            // Error Label
            this._errorStatus =  Label.createWithSystemFont("Error WS is waiting...", "Arial", 14, new Size(160, 100), Label.TEXTHALIGNMENT_CENTER, Label.TEXTVALIGNMENT_TOP);
            this._errorStatus.setAnchorPoint(0, 0);
            this._errorStatus.setPosition(320, 25);
            this.addChild(this._errorStatus);


        }

        public void testGet()
        {
            HttpRequest request = new HttpRequest();
            request.setUrl("http://www.makeapp.co");
            request.setRequestType(HttpRequest.GET);
            request.setResponseCallback(new HttpRequest.HttpResponseCallback()
            {
                public void onResult(HttpClient client, HttpResponse response)
                {
                    super.onResult(client, response);
                    VectorChar chars = response.getResponseData();

                    try {
                        System.out.println("onResult " + new String(response.getResponseHeader().getBytes(), "UTF-8"));
                        System.out.println("onResult " + new String(chars.getBytes(), "UTF-8"));
                    }
                    catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }
                }
            });
            request.setTag("GET test1");
            HttpClient.getInstance().send(request);
            request.release();
        }

        public void testPost()
        {
            HttpRequest request = new HttpRequest();
            request.setUrl("http://httpbin.org/post");
            request.setRequestType(HttpRequest.POST);
            request.setResponseCallback(new HttpRequest.HttpResponseCallback()
            {

            });

            // write the post data
            String form = "visitor=cocos2d&TestSuite=Extensions Test/NetworkTest";
            request.setRequestData(form, form.length());

            request.setTag("POST test1");
            HttpClient.getInstance().send(request);
            request.release();
        }
    }
}
