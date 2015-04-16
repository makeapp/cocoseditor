package org.ccj;

/**
 * Created by yuanyou@makeapp.co on 2014/4/19.
 */
public class MotionStreakTest extends TestScene
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
