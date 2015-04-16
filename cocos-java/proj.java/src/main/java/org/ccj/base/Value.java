/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.base;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import com.googlecode.javacpp.annotation.StdString;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/4/25 13:59 $
 *          $Id$
 */

@Platform(include = "CCValue.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class Value extends Pointer
{
    @StdString
    public native String asString();

    public native int asInt();
}
