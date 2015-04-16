/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.components;

import com.googlecode.javacpp.Pointer;
import org.ccj.base.Touch;
import org.ccj.d2.action.MoveTo;
import org.ccj.editor.cce.CCEController;
import org.ccj.event.Event;
import org.ccj.math.Vec2;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/6/17 11:08 $
 *          $Id$
 */
public class SpriteMoveComponent
    extends CCEController
{
    public SpriteMoveComponent(Pointer p)
    {
        super(p);
    }

    public SpriteMoveComponent()
    {

    }

    public void onEnter()
    {
        super.onEnter();
//        setTouchEnabled(true);
//        setTouchMode(Touch.MODE_ONE_BY_ONE);
        getOwner().runAction(MoveTo.create(1, new Vec2(100, 100)));
    }

    public void onExit()
    {
        super.onExit();
    }

    public boolean onTouchBegan(Touch touch, Event event)
    {
        reader.playAnimation("test");

//        return super.onTouchBegan(touch, event);
        return false;
    }
}
