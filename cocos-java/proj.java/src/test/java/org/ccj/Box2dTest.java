/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/4/22 17:13 $
 *          $Id$
 */
public class Box2dTest extends TestScene
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
