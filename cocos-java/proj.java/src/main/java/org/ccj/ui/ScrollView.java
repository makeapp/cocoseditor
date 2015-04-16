/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.ui;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.ByRef;
import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.Const;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import org.ccj.d2.Node;
import org.ccj.math.Vec2;
import org.ccj.math.Size;
import org.ccj.base.VectorNode;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-3-6 下午12:03 $
 *          $Id$
 */
@Platform(include = "ui/UIScrollView.h")
@Namespace("cocos2d::ui")
@com.googlecode.javacpp.annotation.Opaque
public class ScrollView
    extends Widget
{
    public static final int SCROLLVIEW_DIR_NONE = 0,
        SCROLLVIEW_DIR_VERTICAL = 1,
        SCROLLVIEW_DIR_HORIZONTAL = 2,
        SCROLLVIEW_DIR_BOTH = 3;

    public static final int SCROLLVIEW_EVENT_SCROLL_TO_TOP = 0,
        SCROLLVIEW_EVENT_SCROLL_TO_BOTTOM = 1,
        SCROLLVIEW_EVENT_SCROLL_TO_LEFT = 2,
        SCROLLVIEW_EVENT_SCROLL_TO_RIGHT = 3,
        SCROLLVIEW_EVENT_SCROLLING = 4,
        SCROLLVIEW_EVENT_BOUNCE_TOP = 5,
        SCROLLVIEW_EVENT_BOUNCE_BOTTOM = 6,
        SCROLLVIEW_EVENT_BOUNCE_LEFT = 7,
        SCROLLVIEW_EVENT_BOUNCE_RIGHT = 8;

    public ScrollView(Pointer p)
    {
        super(p);
    }

    /**
     * Allocates and initializes.
     */
    public native static ScrollView create();

    /**
     * Changes scroll direction of scrollview.
     *
     * @param SCROLLVIEW_DIR
     *
     * @see SCROLLVIEW_DIR      SCROLLVIEW_DIR_VERTICAL means vertical scroll, SCROLLVIEW_DIR_HORIZONTAL means horizontal scroll
     */
    public native void setDirection(@Cast("cocos2d::ui::ScrollView::Direction") int dir);

    /**
     * Gets scroll direction of scrollview.
     *
     * @return SCROLLVIEW_DIR
     *
     * @see SCROLLVIEW_DIR      SCROLLVIEW_DIR_VERTICAL means vertical scroll, SCROLLVIEW_DIR_HORIZONTAL means horizontal scroll
     */
    @Cast("int")
    public native int getDirection();

    /**
     * Gets inner container of scrollview.
     * <p/>
     * Inner container is the container of scrollview's children.
     *
     * @return inner container.
     */
    public native Layout getInnerContainer();

    /**
     * Scroll inner container to bottom boundary of scrollview.
     */
    public native void scrollToBottom(float time, boolean attenuated);

    /**
     * Scroll inner container to top boundary of scrollview.
     */
    public native void scrollToTop(float time, boolean attenuated);

    /**
     * Scroll inner container to left boundary of scrollview.
     */
    public native void scrollToLeft(float time, boolean attenuated);

    /**
     * Scroll inner container to right boundary of scrollview.
     */
    public native void scrollToRight(float time, boolean attenuated);

    /**
     * Scroll inner container to top and left boundary of scrollview.
     */
    public native void scrollToTopLeft(float time, boolean attenuated);

    /**
     * Scroll inner container to top and right boundary of scrollview.
     */
    public native void scrollToTopRight(float time, boolean attenuated);

    /**
     * Scroll inner container to bottom and left boundary of scrollview.
     */
    public native void scrollToBottomLeft(float time, boolean attenuated);

    /**
     * Scroll inner container to bottom and right boundary of scrollview.
     */
    public native void scrollToBottomRight(float time, boolean attenuated);

    /**
     * Scroll inner container to vertical percent position of scrollview.
     */
    public native void scrollToPercentVertical(float percent, float time, boolean attenuated);

    /**
     * Scroll inner container to horizontal percent position of scrollview.
     */
    public native void scrollToPercentHorizontal(float percent, float time, boolean attenuated);

    /**
     * Scroll inner container to both direction percent position of scrollview.
     */
    public native void scrollToPercentBothDirection(@ByRef @Const Vec2 percent, float time, boolean attenuated);

    /**
     * Move inner container to bottom boundary of scrollview.
     */
    public native void jumpToBottom();

    /**
     * Move inner container to top boundary of scrollview.
     */
    public native void jumpToTop();

    /**
     * Move inner container to left boundary of scrollview.
     */
    public native void jumpToLeft();

    /**
     * Move inner container to right boundary of scrollview.
     */
    public native void jumpToRight();

    /**
     * Move inner container to top and left boundary of scrollview.
     */
    public native void jumpToTopLeft();

    /**
     * Move inner container to top and right boundary of scrollview.
     */
    public native void jumpToTopRight();

    /**
     * Move inner container to bottom and left boundary of scrollview.
     */
    public native void jumpToBottomLeft();

    /**
     * Move inner container to bottom and right boundary of scrollview.
     */
    public native void jumpToBottomRight();

    /**
     * Move inner container to vertical percent position of scrollview.
     */
    public native void jumpToPercentVertical(float percent);

    /**
     * Move inner container to horizontal percent position of scrollview.
     */
    public native void jumpToPercentHorizontal(float percent);

    /**
     * Move inner container to both direction percent position of scrollview.
     */
    public native void jumpToPercentBothDirection(@ByRef @Const Vec2 percent);

    /**
     * Changes inner container size of scrollview.
     * <p/>
     * Inner container size must be larger than or equal scrollview's size.
     *
     * @param inner container size.
     */
    public native void setInnerContainerSize(@ByRef @Const Size size);

    /**
     * Gets inner container size of scrollview.
     * <p/>
     * Inner container size must be larger than or equal scrollview's size.
     *
     * @return inner container size.
     */
    @ByRef
    @Const
    public native Size getInnerContainerSize();

    /**
     * Add call back function called scrollview event triggered
     */
//    public native   void addEventListenerScrollView(Object* target, SEL_ScrollViewEvent selector);
//    public native void addChild(Node child);

    /**
     * Adds a child to the container with a z-order
     * <p/>
     * If the child is added to a 'running' node, then 'onEnter' and 'onEnterTransitionDidFinish' will be called immediately.
     *
     * @param child  A child node
     * @param zOrder Z order for drawing priority. Please refer to setLocalZOrder(int)
     */
//    public native void addChild(Node child, int zOrder);

    /**
     * Adds a child to the container with z order and tag
     * <p/>
     * If the child is added to a 'running' node, then 'onEnter' and 'onEnterTransitionDidFinish' will be called immediately.
     *
     * @param child  A child node
     * @param zOrder Z order for drawing priority. Please refer to setLocalZOrder(int)
     * @param tag    A interger to identify the node easily. Please refer to setTag(int)
     */
//    public native void addChild(Node child, int zOrder, int tag);

    //override "removeAllChildrenAndCleanUp" method of widget.
//    public native void removeAllChildren();

//    public native void removeAllChildrenWithCleanup(@Cast("bool") boolean cleanup);

    //override "removeChild" method of widget.
//    public native void removeChild(Node child, boolean cleaup);

    //override "getChildren" method of widget.
    @ByRef
//    public native VectorNode getChildren();
//    @Const
//    public native  VectorNode getChildren() ;

//    public native int getChildrenCount();

//    public native Node getChildByTag(int tag);

//    public native Widget getChildByName(String name);

//    public native boolean onTouchBegan(Touch *touch, Event *unusedEvent) override;
//    public native void onTouchMoved(Touch *touch, Event *unusedEvent) override;
//    public native void onTouchEnded(Touch *touch, Event *unusedEvent) override;
//    public native void onTouchCancelled(Touch *touch, Event *unusedEvent) override;

//    public native void update(float dt) override;

    public native void setBounceEnabled(@Cast("bool") boolean enabled);

    public native boolean isBounceEnabled();

    public native void setInertiaScrollEnabled(@Cast("bool") boolean enabled);

    public native boolean isInertiaScrollEnabled();

    /**
     * Sets LayoutType.
     *
     * @param LayoutType
     *
     * @see LayoutType
     */
    public native void setLayoutType(@Cast("cocos2d::ui::Layout::Type") int type);

    /**
     * Gets LayoutType.
     *
     * @return LayoutType
     *
     * @see LayoutType
     */
    @Cast("int")
    public native int getLayoutType();
}
