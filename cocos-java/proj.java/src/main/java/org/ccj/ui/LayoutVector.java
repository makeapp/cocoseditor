/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.ui;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.Name;
import com.googlecode.javacpp.annotation.Platform;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-3-2 上午9:27 $
 *          $Id$
 */
@Platform(include = {"<vector>", "<string>"})
@Name("cocos2d::Vector<cocos2d::ui::Layout*>")
@com.googlecode.javacpp.annotation.Opaque
public class LayoutVector
    extends Pointer
{
    public native long size();

    private native Layout at(long i);

    public Layout get(long i)
    {
        Layout node = at(i);

        return node;
    }

    /*@Name("at")
    @Cast("cocos2d::Sprite* ")
    public native Sprite asSprite(long i);

    @Name("at")
    @Cast("cocos2d::Layer* ")
    public native Layer asLayer(long i);

    @Name("at")
    @Cast("cocos2d::Menu* ")
    public native Menu asMenu(long i);

    @Name("at")
    @Cast("cocos2d::MenuItem* ")
    public native MenuItem asMenuItem(long i);*/
}
