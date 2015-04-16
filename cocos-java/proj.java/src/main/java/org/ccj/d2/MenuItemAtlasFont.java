/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.d2;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-2-28 上午11:39 $
 *          $Id$
 */

@Platform(include = "CCMenuItem.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class MenuItemAtlasFont
    extends MenuItemLabel
{

    public MenuItemAtlasFont(Pointer p)
    {
        super(p);
    }

    /**
     * creates a menu item from a string and atlas with a target/selector
     */
    public native static MenuItemAtlasFont create(String value, String charMapFile, int itemWidth, int itemHeight, char startCharMap);

}
