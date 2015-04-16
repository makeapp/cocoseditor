/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.d2;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.*;
import org.ccj.Component;
import org.ccj.Director;
import org.ccj.Lifecycle;
import org.ccj.Scene;
import org.ccj.Scheduler;
import org.ccj.base.Color3B;
import org.ccj.base.Ref;
import org.ccj.base.VectorNode;
import org.ccj.d2.action.Action;
import org.ccj.d2.action.ActionManager;
import org.ccj.math.Rect;
import org.ccj.math.Size;
import org.ccj.math.Vec2;
import org.ccj.math.Vec3;
import org.ccj.physics.PhysicsBody;
import org.ccj.physics.PhysicsContactListener;
import org.ccj.renderer.GLProgram;
import org.ccj.renderer.GLProgramState;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-2-28 上午11:39 $
 *          $Id$
 */

@Platform(include = "CCNode.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class Node
        extends Ref
        implements Lifecycle, Scheduler.SchedulerListener {
    Object userData;

    List<Scheduler.SchedulerCallback> schedulerCallbacks = null;

    public Node() {

    }

    public Node(boolean create) {
        if (create) {
            allocate();
            putRef(this);
        }
    }

    public Node(Pointer p) {
        super(p);
    }

    /**
     * kNodeOnEnter,
     * kNodeOnExit,
     * kNodeOnEnterTransitionDidFinish,
     * kNodeOnExitTransitionDidStart,
     * kNodeOnCleanup
     */
    public native static Node create();

    @Allocator
    @NoDeallocator
    @Name("cocos2d::Node::create")
    private native void allocate();


    public void onCreate() {

    }

    /**
     * Gets the description string. It makes debugging easier.
     *
     * @return A string
     * @js NA
     * @lua NA
     */
    @StdString
    public native String getDescription();

    /**
     * LocalZOrder is the 'key' used to sort the node relative to its siblings.
     * <p/>
     * The Node's parent will sort all its children based ont the LocalZOrder value.
     * If two nodes have the same LocalZOrder, then the node that was added first to the children's array will be in front of the other node in the array.
     * <p/>
     * Also, the Scene Graph is traversed using the "In-Order" tree traversal algorithm ( http://en.wikipedia.org/wiki/Tree_traversal#In-order )
     * And Nodes that have LocalZOder values < 0 are the "left" subtree
     * While Nodes with LocalZOder >=0 are the "right" subtree.
     *
     * @see `setGlobalZOrder`
     * @see `setVertexZ`
     */
    public native void setLocalZOrder(int localZOrder);

    /**
     * Gets the local Z order of this node.
     *
     * @return The local (relative to its siblings) Z order.
     * @see `setLocalZOrder(int)`
     */
    public native int getLocalZOrder();


    /**
     * Defines the oder in which the nodes are renderer.
     * Nodes that have a Global Z Order lower, are renderer first.
     * <p/>
     * In case two or more nodes have the same Global Z Order, the oder is not guaranteed.
     * The only exception if the Nodes have a Global Z Order == 0. In that case, the Scene Graph order is used.
     * <p/>
     * By default, all nodes have a Global Z Order = 0. That means that by default, the Scene Graph order is used to render the nodes.
     * <p/>
     * Global Z Order is useful when you need to render nodes in an order different than the Scene Graph order.
     * <p/>
     * Limitations: Global Z Order can't be used used by Nodes that have SpriteBatchNode as one of their acenstors.
     * And if ClippingNode is one of the ancestors, then "global Z order" will be relative to the ClippingNode.
     *
     * @see `setLocalZOrder()`
     * @see `setVertexZ()`
     * @since v3.0
     */
    public native void setGlobalZOrder(float globalZOrder);

    /**
     * Returns the Node's Global Z Order.
     *
     * @return The node's global Z order
     * @see `setGlobalZOrder(int)`
     */
    public native float getGlobalZOrder();

    /**
     * Sets the 'z' value in the OpenGL Depth Buffer.
     * <p/>
     * The OpenGL depth buffer and depth testing are disabled by default. You need to turn them on
     * in order to use this property correctly.
     * <p/>
     * `setVertexZ()` also sets the `setGlobalZValue()` with the vertexZ value.
     *
     * @param vertexZ OpenGL Z vertex of this node.
     *
     * @see `setGlobalZValue()`
    //     */
//    public native void setVertexZ(float vertexZ);

    /**
     * Gets OpenGL Z vertex of this node.
     *
     * @return OpenGL Z vertex of this node
     */
//    public native float getVertexZ();


    /**
     * Changes the scale factor on X axis of this node
     * <p/>
     * The deafult value is 1.0 if you haven't changed it before
     *
     * @param scaleX The scale factor on X axis.
     */
    public native void setScaleX(float scaleX);

    /**
     * Returns the scale factor on X axis of this node
     *
     * @return The scale factor on X axis.
     */
    public native float getScaleX();


    /**
     * Changes the scale factor on Y axis of this node
     * <p/>
     * The Default value is 1.0 if you haven't changed it before.
     *
     * @param scaleY The scale factor on Y axis.
     */
    public native void setScaleY(float scaleY);

    /**
     * Returns the scale factor on Y axis of this node
     *
     * @return The scale factor on Y axis.
     * @see `setScaleY(float)`
     */
    public native float getScaleY();


    /**
     * Changes both X and Y scale factor of the node.
     * <p/>
     * 1.0 is the default scale factor. It modifies the X and Y scale at the same time.
     *
     * @param scale The scale factor for both X and Y axis.
     */
    public native void setScale(float scale);

    /**
     * Gets the scale factor of the node,  when X and Y have the same scale factor.
     *
     * @return The scale factor of the node.
     * @warning Assert when `_scaleX != _scaleY`
     */
    public native float getScale();

    /**
     * Changes both X and Y scale factor of the node.
     * <p/>
     * 1.0 is the default scale factor. It modifies the X and Y scale at the same time.
     *
     * @param scaleX The scale factor on X axis.
     * @param scaleY The scale factor on Y axis.
     */
    public native void setScale(float scaleX, float scaleY);

    /**
     * Changes the position (x,y) of the node in OpenGL coordinates
     * <p/>
     * Usually we use `Vec2(x,y)` to compose Vec2 object.
     * The original point (0,0) is at the left-bottom corner of screen.
     * For example, this codesnip sets the node in the center of screen.
     *
     * @param position The position (x,y) of the node in OpenGL coordinates
     * @code Size size = Director::getInstance()->getWinSize();
     * node->setPosition( Vec2(size.width/2, size.height/2) )
     * @endcode
     */
    public native void setPosition(@ByRef @Const Vec2 position);

    /**
     * Gets the position (x,y) of the node in OpenGL coordinates
     *
     * @return The position (x,y) of the node in OpenGL coordinates
     * @code In js and lua return value is table which contains x,y
     * @endcode
     * @see #setPosition
     */
    @ByRef
    @Const
    public native Vec2 getPosition();

    /**
     * Sets position in a more efficient way.
     * <p/>
     * Passing two numbers (x,y) is much efficient than passing Vec2 object.
     * This method is binded to lua and javascript.
     * Passing a number is 10 times faster than passing a object from lua to c++
     *
     * @param x X coordinate for position
     * @param y Y coordinate for position
     * @code // sample code in lua
     * local pos  = node::getPosition()  -- returns Vec2 object from C++
     * node:setPosition(x, y)            -- pass x, y coordinate to C++
     * @endcode
     */
    public native void setPosition(float x, float y);

    public void setPosition(double x, double y) {
        setPosition((float) x, (float) y);
    }

    /**
     * Sets the position (X, Y, and Z) in its parent's coordinate system
     */
    public native void setPosition3D(@ByRef @Const Vec3 position);

    /**
     * returns the position (X,Y,Z) in its parent's coordinate system
     */
    @ByVal
    @Const
    public native Vec3 getPosition3D();

    /**
     * Gets position in a more efficient way, returns two number instead of a Vec2 object
     *
     * @see `setPosition(float, float)`
     * In js,out value not return
     */
//        public native void getPosition(float x, float y) ;

    /**
     * Gets/Sets x or y coordinate individually for position.
     * These methods are used in Lua and Javascript Bindings
     */
    public native void setPositionX(float x);

    public native float getPositionX();

    public native void setPositionY(float y);

    public native float getPositionY();

    public native void setPositionZ(float positionZ);

    public native float getPositionZ();


    /**
     * Changes the X skew angle of the node in degrees.
     * <p/>
     * This angle describes the shear distortion in the X direction.
     * Thus, it is the angle between the Y axis and the left edge of the shape
     * The default skewX angle is 0. Positive values distort the node in a CW direction.
     *
     * @param fSkewX The X skew angle of the node in degrees.
     */
    public native void setSkewX(float fSkewX);

    /**
     * Returns the X skew angle of the node in degrees.
     *
     * @return The X skew angle of the node in degrees.
     * @see `setSkewX(float)`
     */
    public native float getSkewX();


    /**
     * Changes the Y skew angle of the node in degrees.
     * <p/>
     * This angle describes the shear distortion in the Y direction.
     * Thus, it is the angle between the X axis and the bottom edge of the shape
     * The default skewY angle is 0. Positive values distort the node in a CCW direction.
     *
     * @param fSkewY The Y skew angle of the node in degrees.
     */
    public native void setSkewY(float fSkewY);

    /**
     * Returns the Y skew angle of the node in degrees.
     *
     * @return The Y skew angle of the node in degrees.
     * @see `setSkewY(float)`
     */
    public native float getSkewY();

    /**
     * Returns a string that is used to identify the node.
     *
     * @return A string that identifies the node.
     * @since v3.2
     */
    @StdString
    public native String getName();

    /**
     * Changes the name that is used to identify the node easily.
     *
     * @param name A string that identifies the node.
     * @since v3.2
     */
    public native void setName(@StdString String name);

    /**
     * Sets the anchor point in percent.
     * <p/>
     * anchorPoint is the point around which all transformations and positioning manipulations take place.
     * It's like a pin in the node where it is "attached" to its parent.
     * The anchorPoint is normalized, like a percentage. (0,0) means the bottom-left corner and (1,1) means the top-right corner.
     * But you can use values higher than (1,1) and lower than (0,0) too.
     * The default anchorPoint is (0.5,0.5), so it starts in the center of the node.
     *
     * @param anchorPoint The anchor point of node.
     */
    public native void setAnchorPoint(@ByRef @Const Vec2 anchorPoint);

    public void setAnchorPoint(float x, float y) {
        setAnchorPoint(new Vec2(x, y));
    }

    /**
     * Returns the anchor point in percent.
     *
     * @return The anchor point of node.
     * @see `setAnchorPoint( Vec2&)`
     */
    @ByRef
    @Const
    public native Vec2 getAnchorPoint();

    /**
     * Returns the anchorPoint in absolute pixels.
     *
     * @return The anchor point in absolute pixels.
     * @warning You can only read it. If you wish to modify it, use anchorPoint instead.
     * @see `getAnchorPoint()`
     */
    @ByRef
    @Const
    public native Vec2 getAnchorPointInPoints();


    /**
     * Sets the untransformed size of the node.
     * <p/>
     * The contentSize remains the same no matter the node is scaled or rotated.
     * All nodes has a size. Layer and Scene has the same size of the screen.
     *
     * @param contentSize The untransformed size of the node.
     */
    public native void setContentSize(@Const @ByRef Size contentSize);

    public void setContentSize(float width, float height) {
        setContentSize(new Size(width, height));
    }

    /**
     * Returns the untransformed size of the node.
     *
     * @return The untransformed size of the node.
     * @see `setContentSize( Size&)`
     */
    @ByRef
    @Const
    public native Size getContentSize();


    /**
     * Sets whether the node is visible
     * <p/>
     * The default value is true, a node is default to visible
     *
     * @param visible true if the node is visible, false if the node is hidden.
     */
    public native void setVisible(@Cast("bool") boolean visible);

    /**
     * Determines if the node is visible
     *
     * @return true if the node is visible, false if the node is hidden.
     * @see `setVisible(@Cast("bool") boolean)`
     */
    public native boolean isVisible();


    /**
     * Sets the rotation (angle) of the node in degrees.
     * <p/>
     * 0 is the default rotation angle.
     * Positive values rotate node clockwise, and negative values for anti-clockwise.
     *
     * @param rotation The rotation of the node in degrees.
     */
    public native void setRotation(float rotation);

    /**
     * Returns the rotation of the node in degrees.
     *
     * @return The rotation of the node in degrees.
     * @see `setRotation(float)`
     */
    public native float getRotation();


    /**
     * Sets the X rotation (angle) of the node in degrees which performs a horizontal rotational skew.
     * <p/>
     * 0 is the default rotation angle.
     * Positive values rotate node clockwise, and negative values for anti-clockwise.
     *
     * @param rotationX The X rotation in degrees which performs a horizontal rotational skew.
     */
    public native void setRotationSkewX(float rotationX);

    /**
     * Gets the X rotation (angle) of the node in degrees which performs a horizontal rotation skew.
     *
     * @return The X rotation in degrees.
     * @see `setRotationX(float)`
     */
    public native float getRotationSkewX();


    /**
     * Sets the Y rotation (angle) of the node in degrees which performs a vertical rotational skew.
     * <p/>
     * 0 is the default rotation angle.
     * Positive values rotate node clockwise, and negative values for anti-clockwise.
     *
     * @param rotationY The Y rotation in degrees.
     */
    public native void setRotationSkewY(float rotationY);

    /**
     * Gets the Y rotation (angle) of the node in degrees which performs a vertical rotational skew.
     *
     * @return The Y rotation in degrees.
     * @see `setRotationY(float)`
     */
    public native float getRotationSkewY();

    /**
     * Sets the rotation (X,Y,Z) in degrees.
     * Useful for 3d rotations
     *
     * @warning The physics body doesn't support this.
     */
    public native void setRotation3D(@Const @ByRef Vec3 rotation);
    /**
     * returns the rotation (X,Y,Z) in degrees.
     */
    @Const @ByVal
    public native Vec3 getRotation3D() ;

    /**
     * Sets the arrival order when this node has a same ZOrder with other children.
     * <p/>
     * A node which called addChild subsequently will take a larger arrival order,
     * If two children have the same Z order, the child with larger arrival order will be drawn later.
     *
     * @param orderOfArrival The arrival order.
     * @warning This method is used internally for localZOrder sorting, don't change this manually
     */
    public native void setOrderOfArrival(int orderOfArrival);

    /**
     * Returns the arrival order, indecates which children is added previously.
     *
     * @return The arrival order.
     * @see `setOrderOfArrival(unsigned int)`
     */
    public native int getOrderOfArrival();


    /**
     * @js NA
     * @lua NA
     * @deprecated No longer needed
     */
    public native void setGLServerState(int serverState);

    /**
     * @js NA
     * @lua NA
     * @deprecated No longer needed
     */
    public native int getGLServerState();

    /**
     * Sets whether the anchor point will be (0,0) when you position this node.
     * <p/>
     * This is an internal method, only used by Layer and Scene. Don't call it outside framework.
     * The default value is false, while in Layer and Scene are true
     *
     * @param ignore true if anchor point will be (0,0) when you position this node
     * @todo This method shoud be renamed as setIgnoreAnchorPointForPosition(@Cast("bool") boolean) or something with "set"
     */
    public native void ignoreAnchorPointForPosition(@Cast("bool") boolean ignore);

    /**
     * Gets whether the anchor point will be (0,0) when you position this node.
     *
     * @return true if the anchor point will be (0,0) when you position this node.
     * @see `ignoreAnchorPointForPosition(@Cast("bool") boolean)`
     */
    public native boolean isIgnoreAnchorPointForPosition();


    /**
     * Adds a child to the container with z-order as 0.
     * <p/>
     * If the child is added to a 'running' node, then 'onEnter' and 'onEnterTransitionDidFinish' will be called immediately.
     *
     * @param child A child node
     */
    public native void addChild(Node child);

    /**
     * Adds a child to the container with a local z-order
     * <p/>
     * If the child is added to a 'running' node, then 'onEnter' and 'onEnterTransitionDidFinish' will be called immediately.
     *
     * @param child       A child node
     * @param localZOrder Z order for drawing priority. Please refer to `setLocalZOrder(int)`
     */
    public native void addChild(Node child, int localZOrder);

    /**
     * Adds a child to the container with z order and tag
     * <p/>
     * If the child is added to a 'running' node, then 'onEnter' and 'onEnterTransitionDidFinish' will be called immediately.
     *
     * @param child       A child node
     * @param localZOrder Z order for drawing priority. Please refer to setLocalZOrder(int)
     * @param tag         A interger to identify the node easily. Please refer to setTag(int)
     */
    public native void addChild(Node child, int localZOrder, int tag);

    /**
     * Gets a child from the container with its tag
     *
     * @param tag An identifier to find the child node.
     * @return a Node object whose tag equals to the input parameter
     */
    public native Node getChildByTag(int tag);

    /**
     * Gets a child from the container with its name
     *
     * @param name An identifier to find the child node.
     * @return a Node object whose name equals to the input parameter
     * @since v3.2
     */
    public native Node getChildByName(String name);

    /**
     * Return an array of children
     * <p/>
     * Composing a "tree" structure is a very important feature of Node
     * Here's a sample code of traversing children array:
     *
     * @return An array of children
     * @code Node* node = nullptr;
     * CCARRAY_FOREACH(parent->getChildren(), node)
     * {
     * node->setPosition(0,0);
     * }
     * @endcode This sample code traverses all children nodes, and set their position to (0,0)
     */
    @ByRef
    public native VectorNode getChildren();


    /**
     * Get the amount of children.
     *
     * @return The amount of children.
     */
    public native int getChildrenCount();

    /**
     * Sets the parent node
     *
     * @param parent A pointer to the parent node
     */
    public native void setParent(Node parent);

    /**
     * Returns a pointer to the parent node
     *
     * @returns A pointer to the parent node
     * @see `setParent(Node*)`
     */
    public native Node getParent();


    ////// REMOVES //////

    /**
     * Removes this node itself from its parent node with a cleanup.
     * If the node orphan, then nothing happens.
     *
     * @see `removeFromParentAndCleanup(@Cast("bool") boolean)`
     */
    public native void removeFromParent();

    /**
     * Removes this node itself from its parent node.
     * If the node orphan, then nothing happens.
     *
     * @param cleanup true if all actions and callbacks on this node should be removed, false otherwise.
     * @js removeFromParent
     * @lua removeFromParent
     */
    public native void removeFromParentAndCleanup(@Cast("bool") boolean cleanup);

    /**
     * Removes a child from the container. It will also cleanup all running actions depending on the cleanup parameter.
     *
     * @param child   The child node which will be removed.
     * @param cleanup true if all running actions and callbacks on the child node will be cleanup, false otherwise.
     */
    public native void removeChild(Node child, boolean cleanup);

    public void removeChild(Node child) {
        removeChild(child, true);
    }

    /**
     * Removes a child from the container by tag value. It will also cleanup all running actions depending on the cleanup parameter
     *
     * @param tag     An interger number that identifies a child node
     * @param cleanup true if all running actions and callbacks on the child node will be cleanup, false otherwise.
     */
    public native void removeChildByTag(int tag, boolean cleanup);

    public void removeChildByTag(int tag) {
        removeChildByTag(tag, false);
    }

    /**
     * Removes all children from the container with a cleanup.
     *
     * @see `removeAllChildrenWithCleanup(@Cast("bool") boolean)`
     */
    public native void removeAllChildren();

    /**
     * Removes all children from the container, and do a cleanup to all running actions depending on the cleanup parameter.
     *
     * @param cleanup true if all running actions on all children nodes should be cleanup, false oterwise.
     * @js removeAllChildren
     * @lua removeAllChildren
     */
    public native void removeAllChildrenWithCleanup(@Cast("bool") boolean cleanup);

    /**
     * Reorders a child according to a new z value.
     *
     * @param child       An already added child node. It MUST be already added.
     * @param localZOrder Z order for drawing priority. Please refer to setLocalZOrder(int)
     */
    public native void reorderChild(Node child, int localZOrder);

    /**
     * Sorts the children array once before drawing, instead of every time when a child is added or reordered.
     * This appraoch can improves the performance massively.
     *
     * @note Don't call this manually unless a child added needs to be removed in the same frame
     */
    public native void sortAllChildren();


    /**
     * Returns a tag that is used to identify the node easily.
     * <p/>
     * You can set tags to node then identify them easily.
     *
     * @return A interger that identifies the node.
     * @code #define TAG_PLAYER  1
     * #define TAG_MONSTER 2
     * #define TAG_BOSS    3
     * // set tags
     * node1->setTag(TAG_PLAYER);
     * node2->setTag(TAG_MONSTER);
     * node3->setTag(TAG_BOSS);
     * parent->addChild(node1);
     * parent->addChild(node2);
     * parent->addChild(node3);
     * // identify by tags
     * Node* node = nullptr;
     * CCARRAY_FOREACH(parent->getChildren(), node)
     * {
     * switch(node->getTag())
     * {
     * case TAG_PLAYER:
     * break;
     * case TAG_MONSTER:
     * break;
     * case TAG_BOSS:
     * break;
     * }
     * }
     * @endcode
     */
    public native int getTag();

    /**
     * Changes the tag that is used to identify the node easily.
     * <p/>
     * Please refer to getTag for the sample code.
     *
     * @param tag A interger that indentifies the node.
     */
    public native void setTag(int tag);

    /**
     * Returns a custom user data pointer
     * <p/>
     * You can set everything in UserData pointer, a data block, a structure or an object.
     *
     * @return A custom user data pointer
     * @js NA
     * @lua NA
     */
    public Object getUserData() {
        return userData;
    }


    /**
     * Sets a custom user data pointer
     * <p/>
     * You can set everything in UserData pointer, a data block, a structure or an object, etc.
     *
     * @param userData A custom user data pointer
     * @warning Don't forget to release the memory manually,
     * especially before you change this data pointer, and before this node is autoreleased.
     * @js NA
     * @lua NA
     */
    public void setUserData(Object userData) {
        this.userData = userData;
    }

    /**
     * Returns a user assigned Object
     * <p/>
     * Similar to userData, but instead of holding a void* it holds an object
     *
     * @return A user assigned Object
     * @js NA
     * @lua NA
     */
    public native Ref getUserObject();


    /**
     * Returns a user assigned Object
     * <p/>
     * Similar to UserData, but instead of holding a void* it holds an object.
     * The UserObject will be retained once in this method,
     * and the previous UserObject (if existed) will be relese.
     * The UserObject will be released in Node's destructure.
     *
     * @param userObject A user assigned Object
     */
    public native void setUserObject(Ref userObject);


    /// @{
    /// @name Shader Program
    /**
     * Return the shader program currently used for this node
     *
     * @return The shader program currelty used for this node
     */
//        public native GLProgram* getShaderProgram() { return _shaderProgram; }
//        public native  GLProgram* getShaderProgram()  { return _shaderProgram; }

    /**
     * Sets the shader program for this node
     *
     * Since v2.0, each rendering node must set its shader program.
     * It should be set in initialize phase.
     @code node->setShaderProgram(ShaderCache::getInstance()->getProgram(GLProgram::SHADER_NAME_POSITION_TEXTURE_COLOR));
     @endcode
      *
      * @param shaderProgram The shader program which fetchs from ShaderCache.
     */
//        public native void setShaderProgram(GLProgram *shaderProgram);
    /// @} end of Shader Program


    /**
     * Returns whether or not the node accepts event callbacks.
     * <p/>
     * Running means the node accept event callbacks like onEnter(), onExit(), update()
     *
     * @return Whether or not the node is running.
     */
    public native boolean isRunning();

    /**
     * Schedules for lua script.
     *
     * @js NA
     */
    public native void scheduleUpdateWithPriorityLua(int handler, int priority);


    /**
     * Event callback that is invoked every time when Node enters the 'stage'.
     * If the Node enters the 'stage' with a transition, this event is called when the transition starts.
     * During onEnter you can't access a "sister/brother" node.
     * If you override onEnter, you shall call its parent's one, e.g., Node::onEnter().
     *
     * @js NA
     * @lua NA
     */
    public void onEnter() {

    }

    /**
     * Event callback that is invoked when the Node enters in the 'stage'.
     * If the Node enters the 'stage' with a transition, this event is called when the transition finishes.
     * If you override onEnterTransitionDidFinish, you shall call its parent's one, e.g. Node::onEnterTransitionDidFinish()
     *
     * @js NA
     * @lua NA
     */
    public void onEnterTransitionDidFinish() {

    }

    /**
     * Event callback that is invoked every time the Node leaves the 'stage'.
     * If the Node leaves the 'stage' with a transition, this event is called when the transition finishes.
     * During onExit you can't access a sibling node.
     * If you override onExit, you shall call its parent's one, e.g., Node::onExit().
     *
     * @js NA
     * @lua NA
     */
    public void onExit() {
        if (schedulerCallbacks != null) {
            for (Scheduler.SchedulerCallback callback : schedulerCallbacks) {
                getScheduler().unschedule(callback);
            }
        }
    }

    /**
     * Event callback that is called every time the Node leaves the 'stage'.
     * If the Node leaves the 'stage' with a transition, this callback is called when the transition starts.
     *
     * @js NA
     * @lua NA
     */
    public void onExitTransitionDidStart() {

    }

    /**
     * Event callback that is called every time the Node leaves the 'stage'.
     * If the Node leaves the 'stage' with a transition, this callback is called when the transition starts.
     *
     * @js NA
     * @lua NA
     */
    public void onCleanup() {

    }


    /**
     * Stops all running actions and schedulers
     */
    public native void cleanup();

    /**
     * Override this method to draw your own node.
     * The following GL states will be enabled by default:
     * - `glEnableClientState(GL_VERTEX_ARRAY);`
     * - `glEnableClientState(GL_COLOR_ARRAY);`
     * - `glEnableClientState(GL_TEXTURE_COORD_ARRAY);`
     * - `glEnable(GL_TEXTURE_2D);`
     * AND YOU SHOULD NOT DISABLE THEM AFTER DRAWING YOUR NODE
     * But if you enable any other GL state, you should disable it after drawing your node.
     */
    public native void draw();

    /**
     * Visits this node's children and draw them recursively.
     */
    public native void visit();

    /**
     * Returns the Scene that contains the Node.
     * It returns `nullptr` if the node doesn't belong to any Scene.
     * This function recursively calls parent->getScene() until parent is a Scene object. The results are not cached. It is that the user caches the results in case this functions is being used inside a loop.
     */
    public native Scene getScene();

    /**
     * Returns a "local" axis aligned bounding box of the node.
     * The returned box is relative only to its parent.
     *
     * @return A "local" axis aligned boudning box of the node.
     * @note This method returns a temporaty variable, so it can't returns  Rect&
     */
    @ByVal
    public native Rect getBoundingBox();

//        public native void setEventDispatcher(EventDispatcher* dispatcher);
//        public native EventDispatcher* getEventDispatcher()  { return _eventDispatcher; };

    /// @{
    /// @name Actions

    /**
     * Sets the ActionManager object that is used by all actions.
     *
     * @warning If you set a new ActionManager, then previously created actions will be removed.
     *
     * @param actionManager     A ActionManager object that is used by all actions.
     */
//        public native void setActionManager(ActionManager* actionManager);

    /**
     * Gets the ActionManager object that is used by all actions.
     *
     * @return A ActionManager object.
     */
    public native ActionManager getActionManager();


    /**
     * Executes an action, and returns the action that is executed.
     * <p/>
     * This node becomes the action's target. Refer to Action::getTarget()
     *
     * @return An Action pointer
     * @warning Actions don't retain their target.
     */
    public native Action runAction(Action action);

    /**
     * Stops and removes all actions from the running action list .
     */
    public native void stopAllActions();

    /**
     * Stops and removes an action from the running action list.
     *
     * @param action    The action object to be removed.
     */
//        public native  void stopAction(Action* action);

    /**
     * Removes an action from the running action list by its tag.
     *
     * @param tag A tag that indicates the action to be removed.
     */
    public native void stopActionByTag(int tag);

    /**
     * Gets an action from the running action list by its tag.
     *
     * @return The action object with the given tag.
     * @see `setTag(int)`, `getTag()`.
     */
    public native Action getActionByTag(int tag);

    /**
     * Returns the numbers of actions that are running plus the ones that are schedule to run (actions in actionsToAdd and actions arrays).
     *
     * Composable actions are counted as 1 action. Example:
     *    If you are running 1 Sequence of 7 actions, it will return 1.
     *    If you are running 7 Sequences of 2 actions, it will return 7.
     * @todo Rename to getNumberOfRunningActions()
     *
     * @return The number of actions that are running plus the ones that are schedule to run
     */
//        ssize_t getNumberOfRunningActions() ;

//        CC_DEPRECATED_ATTRIBUTE ssize_t numberOfRunningActions()  { return getNumberOfRunningActions(); };

    /// @} end of Actions


    /// @{
    /// @name Scheduler and Timer

    /**
     * Sets a Scheduler object that is used to schedule all "updates" and timers.
     *
     * @warning If you set a new Scheduler, then previously created timers/update are going to be removed.
     * @param scheduler     A Shdeduler object that is used to schedule all "update" and timers.
     */
//        public native void setScheduler(Scheduler* scheduler);

    /**
     * Gets a Sheduler object.
     *
     * @return A Scheduler object.
     */
    public native Scheduler getScheduler();

    /**
     * Checks whether a selector is scheduled.
     *
     * @param selector A function selector
     *
     * @return Whether the funcion selector is scheduled.
     *
     * @js NA
     * @lua NA
     */
//    public native boolean isScheduled(ScheduleCallback selector);

    /**
     * Schedules the "update" method.
     * <p/>
     * It will use the order number 0. This method will be called every frame.
     * Scheduled methods with a lower order value will be called before the ones that have a higher order value.
     * Only one "update" method could be scheduled per node.
     *
     * @js NA
     * @lua NA
     */
    public void scheduleUpdate() {
        scheduleUpdateWithPriorityLua((int) address, 0);
    }

    /**
     * Schedules the "update" method with a custom priority.
     * <p/>
     * This selector will be called every frame.
     * Scheduled methods with a lower priority will be called before the ones that have a higher value.
     * Only one "update" selector could be scheduled per node (You can't have 2 'update' selectors).
     *
     * @js NA
     * @lua NA
     */
    public native void scheduleUpdateWithPriority(int priority);

    /*
     * Unschedules the "update" method.
     * @see scheduleUpdate();
     */
    public native void unscheduleUpdate();

    /**
     * Schedules a custom selector.
     * <p/>
     * If the selector is already scheduled, then the interval parameter will be updated without scheduling it again.
     *
     * @param selector The SEL_SCHEDULE selector to be scheduled.
     * @param interval Tick interval in seconds. 0 means tick every frame. If interval = 0, it's recommended to use scheduleUpdate() instead.
     * @param repeat   The selector will be excuted (repeat + 1) times, you can use kRepeatForever for tick infinitely.
     * @param delay    The amount of time that the first tick will wait before execution.
     * @code // firstly, implement a schedule function
     * void MyNode::TickMe(float dt);
     * // wrap this function into a selector via schedule_selector marco.
     * this->schedule(schedule_selector(MyNode::TickMe), 0, 0, 0);
     * @endcode
     * @lua NA
     */
    public void schedule(Scheduler.SchedulerCallback selector, float interval, int repeat, float delay) {
        if (schedulerCallbacks == null) {
            schedulerCallbacks = new ArrayList();
        }
        Ref.putRef(this);
        schedulerCallbacks.add(selector);
        getScheduler().schedule(selector, selector, interval, repeat, delay, false);
    }

    /**
     * Schedules a custom selector with an interval time in seconds.
     *
     * @param selector The SEL_SCHEDULE selector to be scheduled.
     * @param interval Callback interval time in seconds. 0 means tick every frame,
     * @lua NA
     * @see `schedule(SEL_SCHEDULE, float, unsigned int, float)`
     */
    public void schedule(Scheduler.SchedulerCallback selector, float interval) {
        if (schedulerCallbacks == null) {
            schedulerCallbacks = new ArrayList();
        }
        schedulerCallbacks.add(selector);
        Ref.putRef(this);
        getScheduler().schedule(selector, selector, interval, -1, -1, false);
    }


    /**
     * Schedules a selector that runs only once, with a delay of 0 or larger
     *
     * @param selector The SEL_SCHEDULE selector to be scheduled.
     * @param delay    The amount of time that the first tick will wait before execution.
     * @lua NA
     * @see `schedule(SEL_SCHEDULE, float, unsigned int, float)`
     */
    public void scheduleOnce(Scheduler.SchedulerCallback selector, float delay) {
        schedule(selector, 0, 0, delay);
    }


    /**
     * Schedules a custom selector, the scheduled selector will be ticked every frame
     * //     * @see schedule(SEL_SCHEDULE, float, unsigned int, float)
     *
     * @param selector A function wrapped as a selector
     * @lua NA
     */
    public void schedule(Scheduler.SchedulerCallback selector) {
        schedule(selector, 0, -1, 0);
    }

    /**
     * Unschedules a custom selector.
     *
     * @param selector A function wrapped as a selector
     * @lua NA
     * @see `schedule(SEL_SCHEDULE, float, unsigned int, float)`
     */
    public void unschedule(Scheduler.SchedulerCallback selector) {
        getScheduler().unschedule(selector);
    }

    /**
     * Unschedule all scheduled selectors: custom selectors, and the 'update' selector.
     * Actions are not affected by this method.
     *
     * @lua NA
     */
    public void unscheduleAllSelectors() {
        getScheduler().unscheduleAllForTarget(this);
    }

    /**
     * Resumes all scheduled selectors, actions and event listeners.
     * This method is called internally by onEnter
     */
    public native void resume();

    /**
     * Pauses all scheduled selectors, actions and event listeners..
     * This method is called internally by onExit
     */
    public native void pause();

    /**
     * Resumes all scheduled selectors, actions and event listeners.
     * This method is called internally by onEnter
     */
    public native void resumeSchedulerAndActions();

    /**
     * Pauses all scheduled selectors, actions and event listeners..
     * This method is called internally by onExit
     */
    public native void pauseSchedulerAndActions();

    /*
     * Update method will be called automatically every frame if "scheduleUpdate" is called, and the node is "live"
     */
    public void onUpdate(float delta) {

    }


//    /**
//     * Performs OpenGL view-matrix transformation based on position, scale, rotation and other attributes.
//     */
//    public native void transform();

//    /**
//     * Performs OpenGL view-matrix transformation of it's ancestors.
//     * Generally the ancestors are already transformed, but in certain cases (eg: attaching a FBO)
//     * It's necessary to transform the ancestors again.
//     */
//    public native void transformAncestors();

//    /**
//     * Calls children's updateTransform() method recursively.
//     * <p/>
//     * This method is moved from Sprite, so it's no longer specific to Sprite.
//     * As the result, you apply SpriteBatchNode's optimization on your customed Node.
//     * e.g., `batchNode->addChild(myCustomNode)`, while you can only addChild(sprite) before.
//     */
//    public native void updateTransform();

    /**
     * Returns the matrix that transform the node's (local) space coordinates into the parent's space coordinates.
     * The matrix is in Pixels.
     */
//        public native  kmMat4& getNodeToParentTransform() ;
//        public native AffineTransform getNodeToParentAffineTransform() ;

    /**
     * Sets the Transformation matrix manually.
     */
//        public native void setNodeToParentTransform( kmMat4& transform);

    /** @deprecated use getNodeToParentTransform() instead */
//        CC_DEPRECATED_ATTRIBUTE inline public native AffineTransform nodeToParentTransform()  { return getNodeToParentAffineTransform(); }

    /**
     * Returns the matrix that transform parent's space coordinates to the node's (local) space coordinates.
     * The matrix is in Pixels.
     */
//        public native  kmMat4& getParentToNodeTransform() ;
//        public native AffineTransform getParentToNodeAffineTransform() ;

    /** @deprecated Use getParentToNodeTransform() instead */
//        CC_DEPRECATED_ATTRIBUTE inline public native AffineTransform parentToNodeTransform()  { return getParentToNodeAffineTransform(); }

    /**
     * Returns the world affine transform matrix. The matrix is in Pixels.
     */
//        public native kmMat4 getNodeToWorldTransform() ;
//        public native AffineTransform getNodeToWorldAffineTransform() ;

//    /** @deprecated Use getNodeToWorldTransform() instead */
//        CC_DEPRECATED_ATTRIBUTE inline public native AffineTransform nodeToWorldTransform()  { return getNodeToWorldAffineTransform(); }

    /**
     * Returns the inverse world affine transform matrix. The matrix is in Pixels.
     */
//        public native kmMat4 getWorldToNodeTransform() ;
//        public native AffineTransform getWorldToNodeAffineTransform() ;


    /**
     * @deprecated Use worldToNodeTransform() instead
     */
//        CC_DEPRECATED_ATTRIBUTE inline public native AffineTransform worldToNodeTransform()  { return getWorldToNodeAffineTransform(); }

    /// @} end of Transformations


    /// @{
    /// @name Coordinate Converters

//        /**
//         * Converts a Vec2 to node (local) space coordinates. The result is in Points.
//         */
    @ByVal
    public native Vec2 convertToNodeSpace(@ByRef Vec2 worldPoint);

    //
//        /**
//         * Converts a Vec2 to world space coordinates. The result is in Points.
//         */
    @ByVal
    public native Vec2 convertToWorldSpace(@ByRef Vec2 nodePoint);

    //
//        /**
//         * Converts a Vec2 to node (local) space coordinates. The result is in Points.
//         * treating the returned/received node point as anchor relative.
//         */
    @ByVal
    public native Vec2 convertToNodeSpaceAR(@ByRef Vec2 worldPoint);

    //
//        /**
//         * Converts a local Vec2 to world space coordinates.The result is in Points.
//         * treating the returned/received node point as anchor relative.
//         */
    @ByVal
    public native Vec2 convertToWorldSpaceAR(@ByRef Vec2 nodePoint);
//
//        /**
//         * convenience methods which take a Touch instead of Vec2
//         */
//        Vec2 convertTouchToNodeSpace(Touch * touch) ;
//
//        /**
//         * converts a Touch (world coordinates) into a local coordinate. This method is AR (Anchor Relative).
//         */
//        Vec2 convertTouchToNodeSpaceAR(Touch * touch) ;


//        void setAdditionalTransform( AffineTransform& additionalTransform);
//        void setAdditionalTransform( kmMat4& additionalTransform);

    /// @} end of Coordinate Converters

    /// @{
    /// @name component functions

    /**
     * gets a component by its name
     */
    public native Component getComponent(@StdString String pName);

    /**
     * adds a component
     */
    public native boolean addComponent(Component pComponent);

    /**
     * removes a component by its name
     */
    public native boolean removeComponent(@StdString String name);

    /**
     * removes all components
     */
    public native void removeAllComponents();
    /// @} end of component functions


//    #if CC_USE_PHYSICS

    /**
     * set the PhysicsBody that let the sprite effect with physics
     */
    public native void setPhysicsBody(PhysicsBody body);

    //

    /**
     * get the PhysicsBody the sprite have
     */
    public native PhysicsBody getPhysicsBody();

    public void addPhysicsContactListener(PhysicsContactListener listener) {
        Director.getInstance().getEventDispatcher().addEventListenerWithSceneGraphPriority(listener, this);
    }

    public void removePhysicsContactListener(PhysicsContactListener listener) {
        Director.getInstance().getEventDispatcher().removeEventListener(listener);
    }
    //

//    /**
//     * update rotation and position from physics body
//     */
//    public native boolean updatePhysicsTransform();
//    
//    #endif

    /**
     * Sets the shader program for this node
     *
     * Since v2.0, each rendering node must set its shader program.
     * It should be set in initialize phase.
     @code
     node->setGLrProgram(GLProgramCache::getInstance()->getProgram(GLProgram::SHADER_NAME_POSITION_TEXTURE_COLOR));
     @endcode
      *
      * @param shaderProgram The shader program
     */
    public native void setGLProgram(GLProgram glprogram);

    public native GLProgram getGLProgram() ;

    public native GLProgramState getGLProgramState() ;

    public native void setGLProgramState(GLProgramState glProgramState);



    // overrides
    @Cast("int")
    public native int getOpacity();

    @Cast("int")
    public native int getDisplayedOpacity();

    public native void setOpacity(@Cast("GLubyte") int opacity);

    public native void updateDisplayedOpacity(@Cast("GLubyte") int parentOpacity);

    public native boolean isCascadeOpacityEnabled();

    public native void setCascadeOpacityEnabled(@Cast("bool") boolean cascadeOpacityEnabled);

    @ByRef
    @Const
    public native Color3B getColor();

    @ByRef
    @Const
    public native Color3B getDisplayedColor();

    public native void setColor(@ByRef @Const Color3B color);

    public native void updateDisplayedColor(@ByRef @Const Color3B parentColor);

    public native boolean isCascadeColorEnabled();

    public native void setCascadeColorEnabled(@Cast("bool") boolean cascadeColorEnabled);

    public native void setOpacityModifyRGB(@Cast("bool") boolean bValue);

    public native boolean isOpacityModifyRGB();

    public float getWidth() {
        return getContentSize().getWidth();
    }

    public float getHeight() {
        return getContentSize().getHeight();
    }

    public static Node cast(Ref node) {
        return cast(node, Node.class);
    }


}
