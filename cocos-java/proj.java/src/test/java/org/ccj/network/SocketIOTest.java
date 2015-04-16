package org.ccj.network;

import org.ccj.TestLayer;
import org.ccj.TestScene;

/**
 * Created by yuanyou@makeapp.co on 2014/4/19.
 */
public class SocketIOTest extends TestScene
{

    public Class[] getLayers()
    {
        return new Class[]{MoveTest.class};
    }

    static public class MoveTest extends TestLayer
    {
        @Override
        public void onCreate()
        {
            super.onCreate();
        }
    }
}
