/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.ui;

import com.googlecode.javacpp.FunctionPointer;
import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.*;
import org.ccj.base.Ref;
import org.ccj.d2.Node;
import org.ccj.math.Size;
import org.ccj.math.Vec2;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-3-6 下午12:03 $
 *          $Id$
 */
@Platform(include = "ui/UIWidget.h")
@Namespace("cocos2d::ui")
@com.googlecode.javacpp.annotation.Opaque
public class Widget
    extends Node
{
    public static final int POSITION_ABSOLUTE = 0;
    public static final int POSITION_PERCENT = 1;

    public static final int SIZE_ABSOLUTE = 0;
    public static final int SIZE_PERCENT = 1;

    public static final int TOUCH_BAGAN = 0;
    public static final int TOUCH_MOVED = 1;
    public static final int TOUCH_ENDED = 2;
    public static final int TOUCH_CANCELED = 3;

    public static final int UI_TEX_TYPE_LOCAL = 0;
    public static final int UI_TEX_TYPE_PLIST = 1;

    public static final int WidgetTypeWidget = 0; //control
    public static final int WidgetTypeContainer = 1; //container

    public static final int BRIGHT_NONE = -1;
    public static final int BRIGHT_NORMAL = 0;
    public static final int BRIGHT_HIGHLIGHT = 1;

    public Widget(Pointer p)
    {
        super(p);
    }

    /**
     * Allocates and initializes a widget.
     */
    public native static Widget create();

    /**
     * Sets whether the widget is enabled
     * <p/>
     * Highest control of widget.
     * The default value is true, a widget is default to enabled
     *
     * @param enabled true if the widget is enabled, widget may be touched and visible, false if the widget is disabled, widget cannot be touched and hidden.
     */
    public native void setEnabled(@Cast("bool") boolean enabled);

    /**
     * Determines if the widget is enabled
     *
     * @return true if the widget is enabled, false if the widget is disabled.
     */
    public native boolean isEnabled();

    /**
     * Sets whether the widget is bright
     * <p/>
     * The default value is true, a widget is default to bright
     *
//     * @param visible true if the widget is bright, false if the widget is dark.
     */
    public native void setBright(@Cast("bool") boolean bright);

    /**
     * Determines if the widget is bright
     *
     * @return true if the widget is bright, false if the widget is dark.
     */
    public native boolean isBright();

    /**
     * Sets whether the widget is touch enabled
     * <p/>
     * The default value is false, a widget is default to touch disabled
     *
//     * @param visible true if the widget is touch enabled, false if the widget is touch disabled.
     */
    public native void setTouchEnabled(@Cast("bool") boolean enabled);

    /**
     * To set the bright style of widget.
     *
     * @see BrightStyle
     *
     * @param style   BRIGHT_NORMAL the widget is normal state, BRIGHT_HIGHLIGHT the widget is height light state.
     */
//        void setBrightStyle(BrightStyle style);

    /**
     * Determines if the widget is touch enabled
     *
     * @return true if the widget is touch enabled, false if the widget is touch disabled.
     */
    public native boolean isTouchEnabled();

    /**
     * Determines if the widget is on focused
     *
     * @return true if the widget is on focused, false if the widget is not on focused.
     */
    public native boolean isFocused();

    /**
     * Sets whether the widget is on focused
     * <p/>
     * The default value is false, a widget is default to not on focused
     *
     * @param fucosed true if the widget is on focused, false if the widget is not on focused.
     */
    public native void setFocused(@Cast("bool") boolean fucosed);

    /**
     * Gets the left boundary position of this widget.
     *
     * @return The left boundary position of this widget.
     */
    public native float getLeftInParent();

    /**
     * Gets the bottom boundary position of this widget.
     *
     * @return The bottom boundary position of this widget.
     */
    public native float getBottomInParent();

    /**
     * Gets the right boundary position of this widget.
     *
     * @return The right boundary position of this widget.
     */
    public native float getRightInParent();

    /**
     * Gets the top boundary position of this widget.
     *
     * @return The top boundary position of this widget.
     */
    public native float getTopInParent();

    /**
     * Adds a child to the container with z-order as 0.
     * <p/>
     * If the child is added to a 'running' node, then 'onEnter' and 'onEnterTransitionDidFinish' will be called immediately.
     *
     * @param child A child node
    //     */
//    public native void addChild(Node child);

    /**
     * Adds a child to the container with a z-order
     * <p/>
     * If the child is added to a 'running' node, then 'onEnter' and 'onEnterTransitionDidFinish' will be called immediately.
     *
     * @param child  A child node
     * @param zOrder Z order for drawing priority. Please refer to setLocalZOrder(int)
    //     */
//    public native void addChild(Node child, int zOrder);

    /**
     * Adds a child to the container with z order and tag
     * <p/>
     * If the child is added to a 'running' node, then 'onEnter' and 'onEnterTransitionDidFinish' will be called immediately.
     *
     * @param child  A child node
     * @param zOrder Z order for drawing priority. Please refer to setLocalZOrder(int)
     * @param tag    A interger to identify the node easily. Please refer to setTag(int)
    //     */
//    public native void addChild(Node child, int zOrder, int tag);

    /**
     * Gets a child from the container with its tag
     *
     * @param tag An identifier to find the child node.
     *
     * @return a Node object whose tag equals to the input parameter
    //     */
//    public native Node getChildByTag(int tag);

//    public native void sortAllChildren();

    /**
     * Return an array of children
     * <p/>
     * Composing a "tree" structure is a very important feature of Node
     * Here's a sample code of traversing children array:
     *
     * @return An array of children
     *
     * @code Node* node = NULL;
     * CCARRAY_FOREACH(parent->getChildren(), node)
     * {
     * node->setPosition(0,0);
     * }
     * @endcode This sample code traverses all children nodes, and set their position to (0,0)
     */
//         public native VectorNode getChildren() ;
//    @ByRef
//    public native VectorNode getChildren();

    /**
     * Get the amount of children.
     *
     * @return The amount of children.
    //     */
//    public native int getChildrenCount();

    /**
     * Removes this node itself from its parent node with a cleanup.
     * If the node orphan, then nothing happens.
     *
     * @see `removeFromParentAndCleanup(@Cast("bool") boolean)`
    //     */
//    public native void removeFromParent();

    /**
     * Removes this node itself from its parent node.
     * If the node orphan, then nothing happens.
     *
     * @param cleanup true if all actions and callbacks on this node should be removed, false otherwise.
     *
     * @js removeFromParent
     * @lua removeFromParent
    //     */
//    public native void removeFromParentAndCleanup(@Cast("bool") boolean cleanup);

    /**
     * Removes a child from the container. It will also cleanup all running actions depending on the cleanup parameter.
     *
     * @param child   The child node which will be removed.
     * @param cleanup true if all running actions and callbacks on the child node will be cleanup, false otherwise.
    //     */
//    public native void removeChild(Node child, boolean cleanup);

    /**
     * Removes a child from the container by tag value. It will also cleanup all running actions depending on the cleanup parameter
     *
     * @param tag     An interger number that identifies a child node
     * @param cleanup true if all running actions and callbacks on the child node will be cleanup, false otherwise.
    //     */
//    public native void removeChildByTag(int tag, boolean cleanup);

    /**
     * Removes all children from the container with a cleanup.
     *
     * @see `removeAllChildrenWithCleanup(@Cast("bool") boolean)`
    //     */
//    public native void removeAllChildren();

    /**
     * Removes all children from the container, and do a cleanup to all running actions depending on the cleanup parameter.
     *
     * @param cleanup true if all running actions on all children nodes should be cleanup, false oterwise.
     *
     * @js removeAllChildren
     * @lua removeAllChildren
     */
//    public native void removeAllChildrenWithCleanup(@Cast("bool") boolean cleanup);

    /**
     * Gets a child from the container with its name
     *
     * @param name An key to find the child widget.
     *
     * @return a Widget object whose name equals to the input parameter
     */
    public native Node getChildByName(String name);

//    public native void addNode(Node node);

//    public native void addNode(Node node, int zOrder);

//    public native void addNode(Node node, int zOrder, int tag);

//    public native Node getNodeByTag(int tag);

//    @ByRef
//    public native VectorNode getNodes();

//    public native void removeNode(Node node);

//    public native void removeNodeByTag(int tag);

//    public native void removeAllNodes();

//    public native void visit();


    //cocos2d property

    /**
     * Changes the position (x,y) of the widget in OpenGL coordinates
     * <p/>
     * Usually we use p(x,y) to compose Vec2 object.
     * The original point (0,0) is at the left-bottom corner of screen.
     *
//     * @param position The position (x,y) of the widget in OpenGL coordinates
     */
    public native void setPosition(@Const @ByRef Vec2 pos);

    /**
     * Changes the position (x,y) of the widget in OpenGL coordinates
     * <p/>
     * Usually we use p(x,y) to compose Vec2 object.
     * The original point (0,0) is at the left-bottom corner of screen.
     *
     * @param percent The percent (x,y) of the widget in OpenGL coordinates
     */
    public native void setPositionPercent(@Const @ByRef Vec2 percent);

    /**
     * Gets the percent (x,y) of the widget in OpenGL coordinates
     *
     * @return The percent (x,y) of the widget in OpenGL coordinates
     *
//     * @see setPosition(const org.ccj.math.Vec2 &)
     */
    @Const
    @ByRef
    public native Vec2 getPositionPercent();

    /**
     * Changes the position type of the widget
     *
     * @param type the position type of widget
     *
//     * @see PositionType
     */
    public native void setPositionType(@Cast("cocos2d::ui::Widget::PositionType") int type);

    /**
     * Gets the position type of the widget
     *
     * @return type  the position type of widget
     *
//     * @see PositionType
     */
    @Cast("int")
    public native int getPositionType();

    /**
     * Sets whether the widget should be flipped horizontally or not.
     *
//     * @param true if the widget should be flipped horizaontally, false otherwise.
     */
    public native void setFlipX(@Cast("bool") boolean flipX);

    /**
     * Returns the flag which indicates whether the widget is flipped horizontally or not.
     * <p/>
     * It only flips the texture of the widget, and not the texture of the widget's children.
     * Also, flipping the texture doesn't alter the anchorPoint.
     * If you want to flip the anchorPoint too, and/or to flip the children too use:
     * widget->setScaleX(sprite->getScaleX() * -1);
     *
     * @return true if the widget is flipped horizaontally, false otherwise.
     */
    public native boolean isFlipX();

    /**
     * Sets whether the widget should be flipped vertically or not.
     *
//     * @param bFlipY true if the widget should be flipped vertically, flase otherwise.
     */
    public native void setFlipY(@Cast("bool") boolean flipY);

    /**
     * Return the flag which indicates whether the widget is flipped vertically or not.
     * <p/>
     * It only flips the texture of the widget, and not the texture of the widget's children.
     * Also, flipping the texture doesn't alter the anchorPoint.
     * If you want to flip the anchorPoint too, and/or to flip the children too use:
     * widget->setScaleY(widget->getScaleY() * -1);
     *
     * @return true if the widget is flipped vertically, flase otherwise.
     */
    public native boolean isFlipY();

    /**
     * A call back function when widget lost of focus.
     */
//    public native void didNotSelectSelf();

    /*
     * Checks a point if in parent's area.
     *
     * @param point
     *
     * @return true if the point is in parent's area, flase otherwise.
     */
    public native boolean clippingParentAreaContainPoint(@Const @ByRef Vec2 pt);

        /*
         * Sends the touch event to widget's parent
         */
//         public native  void checkChildInfo(int handleState,Widget* sender,const Vec2 &touchPoint);

    /*
     * Gets the touch began point of widget when widget is selected.
     *
     * @return the touch began point.
     */
    @Const
    @ByRef
    public native Vec2 getTouchStartPos();

    /*
     * Gets the touch move point of widget when widget is selected.
     *
     * @return the touch move point.
     */
    @Const
    @ByRef
    public native Vec2 getTouchMovePos();

    /*
     * Gets the touch end point of widget when widget is selected.
     *
     * @return the touch end point.
     */
    @Const
    @ByRef
    public native Vec2 getTouchEndPos();

    /**
     * Changes the name that is used to identify the widget easily.
     *
     * @param A const char* that indentifies the widget.
     */
//    public native void setName(String name);

    /**
     * Returns a name that is used to identify the widget easily.
     * <p/>
     * You can set tags to widget then identify them easily.
     *
     * @return A const char* that identifies the widget.
     */
    @StdString
//    public native String getName();

    /**
     * Returns a type that is widget's type
     *
     * @see WidgetType
     *
     * @return A WidgetType
     */
//        WidgetType getWidgetType() ;

    /**
     * Changes the size that is widget's size
     *
     * @param size that is widget's size
     */
    public native void setSize(@Const @ByRef Size size);

    /**
     * Changes the percent that is widget's percent size
     *
     * @param percent that is widget's percent size
     */
    public native void setSizePercent(@Const @ByRef Vec2 percent);

    /**
     * Changes the size type of widget.
     *
     * @see SizeType
     *
     * @param type that is widget's size type
     */
//        public native  void setSizeType(SizeType type);

    /**
     * Gets the size type of widget.
     *
     * @see SizeType
     *
     * @param type that is widget's size type
     */
//        public native  SizeType getSizeType() const;

    /**
     * Returns size of widget
     *
     * @return size
     */
    public native
    @Const
    @ByRef
    Size getSize();

    /**
     * Returns size percent of widget
     *
     * @return size percent
     */
    @Const
    @ByRef
    public native Vec2 getSizePercent();

    /**
     * Checks a point if is in widget's space
     *
//     * @param point
     *
     * @return true if the point is in widget's space, flase otherwise.
     */
    public native boolean hitTest(@Const @ByRef Vec2 pt);

//    public native boolean onTouchBegan(Touch touch, Event unusedEvent);
//
//    public native void onTouchMoved(Touch touch, Event unusedEvent);
//
//    public native void onTouchEnded(Touch touch, Event unusedEvent);
//
//    public native void onTouchCancelled(Touch touch, Event unusedEvent);

    /**
     * Sets a LayoutParameter to widget.
     *
//     * @param LayoutParameter pointer
//     * @param type            Relative or Linear
     *
     * @see LayoutParameter
     */
    public native void setLayoutParameter(LayoutParameter parameter);

    /**
     * Gets LayoutParameter of widget.
     *
     * @see LayoutParameter
     *
     * @param type  Relative or Linear
     *
     * @return LayoutParameter
     */
//    public native  LayoutParameter getLayoutParameter(LayoutParameterType type);

    /**
     * Ignore the widget size
     *
     * @param ignore, true that widget will ignore it's size, use texture size, false otherwise. Default value is true.
     */
    public native void ignoreContentAdaptWithSize(@Cast("bool") boolean ignore);

    /**
     * Gets the widget if is ignore it's size.
     *
     * @param , true that widget will ignore it's size, use texture size, false otherwise. Default value is true.
     */
    public native boolean isIgnoreContentAdaptWithSize();

    /**
     * Gets world position of widget.
     *
     * @return world position of widget.
     */
    @ByVal
    public native Vec2 getWorldPosition();

    /**
     * Gets the Virtual Renderer of widget.
     * <p/>
     * For example, a button's Virtual Renderer is it's texture renderer.
     *
     * @return Node pointer.
     */
    public native Node getVirtualRenderer();

    /**
     * Gets the content size of widget.
     * <p/>
     * Content size is widget's texture size.
     */
//    @Const
//    @ByRef
//    public native Size getContentSize();

    /**
     * Returns the "class name" of widget.
     */

    public native Widget clone();

//    public native void onEnter();

//    public native void onExit();

    public native void updateSizeAndPosition();

    /*temp action*/
    public native void setActionTag(int tag);

    public native int getActionTag();

    /**
     * Sets the touch event target/selector of the menu item
     */
    public void addTouchEventListener(TouchEventListener listener)
    {
        TouchEventCallback callback = new TouchEventCallback(listener);
        addTouchEventListener(callback, callback);
    }

    private native void addTouchEventListener(@Target @Cast("cocos2d::Ref *") TouchEventCallback target, TouchEventCallback selector);

    public static Widget cast(Ref component)
    {
        return cast(component, Widget.class);
    }

    public interface TouchEventListener
    {
        public void onTouch(Ref ref, int action);
    }

    @Type("cocos2d::ui::SEL_TouchEvent")
    @Parent("cocos2d::Ref")
    private static class TouchEventCallback
        extends FunctionPointer
    {
        TouchEventListener listener;

        public TouchEventCallback(TouchEventListener listener)
        {
            this.listener = listener;
            allocate();
        }

        public native void allocate();

        public void call(Ref ref, @Cast("cocos2d::ui::TouchEventType") int eventType)
        {
            if (listener != null) {
                listener.onTouch(ref, eventType);
            }
        }
    }
}
