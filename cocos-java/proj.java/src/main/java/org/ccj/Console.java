/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/3/29 13:11 $
 *          $Id$
 */
@Platform(include = "CCConsole.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class Console
    extends Pointer
{
    /**
     * starts listening to specifed TCP port
     */
    public native boolean listenOnTCP(int port);

    /**
     * starts listening to specifed file descriptor
     */
    public native boolean listenOnFileDescriptor(int fd);

    /**
     * stops the Console. 'stop' will be called at destruction time as well
     */
    public native void stop();

    /** sets user tokens */
//       void setUserCommands( Command* commands, int numberOfCommands);

    /**
     * log something in the console
     */
    public native void log(String msg);
}
