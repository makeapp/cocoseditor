package org.ccj.network;

import org.ccj.Logger;
import org.ccj.TestLayer;
import org.ccj.TestScene;
import org.ccj.d2.Label;
import org.ccj.d2.Menu;
import org.ccj.d2.MenuItem;
import org.ccj.d2.MenuItemLabel;
import org.ccj.math.Size;
import org.ccj.net.WebSocket;
import org.ccj.net.WebSocketDelegate;

/**
 * Created by yuanyou@makeapp.co on 2014/4/19.
 */
public class WebSocketTest extends TestScene
{

    public Class[] getLayers()
    {
        return new Class[]{WebSocketTestLayer.class};
    }

    static public class WebSocketTestLayer extends TestLayer
    {
        WebSocket _wsiSendText = null;
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
            Label labelSendText = Label.createWithSystemFont("Send Text", "Arial", 22);
            MenuItemLabel itemSendText = MenuItemLabel.create(labelSendText);
            itemSendText.setOnClickListener(new MenuItem.MenuItemListener()
            {
                public void onClicked(MenuItem item)
                {
                    if (_wsiSendText.getReadyState() == WebSocket.OPEN) {

                        _sendTextStatus.setString("Send Text WS is waiting...");
                        _wsiSendText.send("Hello WebSocket中文, I'm a text message.");
                    }
                    else {
                        _sendTextStatus.setString("send text websocket instance wasn't ready...");
                    }
                }
            });
            itemSendText.setPosition(winSize.width / 2, winSize.height - MARGIN - SPACE);
            menuRequest.addChild(itemSendText);

            // Send Binary
            Label labelSendBinary =Label.createWithSystemFont("Send Binary", "Arial", 22);
            MenuItemLabel itemSendBinary = MenuItemLabel.create(labelSendBinary);
            itemSendBinary.setOnClickListener(new MenuItem.MenuItemListener()
            {
                public void onClicked(MenuItem item)
                {
                    if (_wsiSendText.getReadyState() == WebSocket.OPEN) {
                        _sendTextStatus.setString("Send Text WS is waiting...");
                        _wsiSendText.send("Hello WebSocket中文, I'm a text message.".getBytes());
                    }
                    else {
                        _sendTextStatus.setString("send binary websocket instance wasn't ready...");
                    }
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
            this._sendBinaryStatus = Label.createWithSystemFont("Send Binary WS is waiting...", "Arial", 14, new Size(160, 100), Label.TEXTHALIGNMENT_CENTER, Label.TEXTVALIGNMENT_TOP);
            this._sendBinaryStatus.setAnchorPoint(0, 0);
            this._sendBinaryStatus.setPosition(160, 25);
            this.addChild(this._sendBinaryStatus);

            // Error Label
            this._errorStatus = Label.createWithSystemFont("Error WS is waiting...", "Arial", 14, new Size(160, 100), Label.TEXTHALIGNMENT_CENTER, Label.TEXTVALIGNMENT_TOP);
            this._errorStatus.setAnchorPoint(0, 0);
            this._errorStatus.setPosition(320, 25);
            this.addChild(this._errorStatus);


            this._wsiSendText = new WebSocket("ws://echo.websocket.org", new WebSocketDelegate()
            {
//                public void onOpen()
//                {
//                    _sendTextStatus.setString("Send Text WS was opened.");
//                }

                public void onMessage(byte[] data, boolean isBinary)
                {
                    super.onMessage(data, isBinary);
                }

                public void onClose()
                {
                    Logger.log("_wsiSendText websocket instance closed.");
                    _wsiSendText = null;
                }

                public void onError(int error)
                {
                    Logger.log("sendText Error was fired");
                }
            });

//                    this._wsiSendBinary = new WebSocket("ws://echo.websocket.org");
//                    this._wsiSendBinary.binaryType = "arraybuffer";
//                    this._wsiSendBinary.onopen = function(evt) {
//                        self._sendBinaryStatus.setString("Send Binary WS was opened.");
//                    };
//
//                    this._wsiSendBinary.onmessage = function(evt) {
//                        self._sendBinaryTimes++;
//                        var binary = new Uint16Array(evt.data);
//                        var binaryStr = "response bin msg: ";
//
//                        var str = "";
//                        for (var i = 0; i < binary.length; i++) {
//                            if (binary[i] == 0)
//                            {
//                                str += "\'\\0\'";
//                            }
//                            else
//                            {
//                                var hexChar = "0x" + binary[i].toString("16").toUpperCase();
//                                str += String.fromCharCode(hexChar);
//                            }
//                        }
//
//                        binaryStr += str + ", " + self._sendBinaryTimes;
//                        cc.log(binaryStr);
//                        self._sendBinaryStatus.setString(binaryStr);
//                    };
//
//                    this._wsiSendBinary.onerror = function(evt) {
//                        cc.log("sendBinary Error was fired");
//                    };
//
//                    this._wsiSendBinary.onclose = function(evt) {
//                        cc.log("_wsiSendBinary websocket instance closed.");
//                        self._wsiSendBinary = null;
//                    };
//
//                    this._wsiError = new WebSocket("ws://invalid.url.com");
//                    this._wsiError.onopen = function(evt) {};
//                    this._wsiError.onmessage = function(evt) {};
//                    this._wsiError.onerror = function(evt) {
//                        cc.log("Error was fired");
//                        self._errorStatus.setString("an error was fired");
//                    };
//                    this._wsiError.onclose = function(evt) {
//                        cc.log("_wsiError websocket instance closed.");
//                        self._wsiError = null;
//                    };
        }
    }
}
