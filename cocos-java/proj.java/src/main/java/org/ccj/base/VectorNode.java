/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.base;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.Name;
import com.googlecode.javacpp.annotation.Platform;
import org.ccj.d2.Layer;
import org.ccj.d2.Menu;
import org.ccj.d2.MenuItem;
import org.ccj.d2.Node;
import org.ccj.d2.Sprite;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-3-2 上午9:27 $
 *          $Id$
 */
@Platform(include = {"<vector>", "<string>"})
@Name("cocos2d::Vector<cocos2d::Node*>")
@com.googlecode.javacpp.annotation.Opaque
public class VectorNode
    extends Pointer
{
    public native long size();

    private native Node at(long i);

    public Node get(long i)
    {
        Node node = at(i);
//        if (node != null) {
//            String desc = node.getDescription();
//            if (desc.indexOf("MenuItem") > 0) {
//                return asMenuItem(i);
//            }
//            else if (desc.indexOf("Sprite") > 0) {
//                return asSprite(i);
//            }
////            else if (desc.indexOf("Control") > 0) {
////                return asControl(i);
////            }
//        }
        return node;
    }

    @Name("at")
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
    public native MenuItem asMenuItem(long i);

//    @Name("at")
//    @Cast("cocos2d::extension::Control* ")
//    public native Control asControl(long i);
}
