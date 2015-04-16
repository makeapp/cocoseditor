/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/4/21 10:35 $
 *          $Id$
 */
@com.googlecode.javacpp.annotation.Opaque
public class Logger
{
    public static void log(String msg)
    {
        System.out.println(""+msg);
//        Engine.log(msg);
    }
}
