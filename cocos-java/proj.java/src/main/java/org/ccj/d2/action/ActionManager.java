/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.d2.action;

import com.googlecode.javacpp.annotation.Const;
import com.googlecode.javacpp.annotation.Namespace;
import com.googlecode.javacpp.annotation.Platform;
import org.ccj.d2.Node;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-2-28 上午11:39 $
 *          $Id$
 */

/**
 * @brief ActionManager is a singleton that manages all the actions.
 * Normally you won't need to use this singleton directly. 99% of the cases you will use the Node interface,
 * which uses this singleton.
 * But there are some cases where you might need to use this singleton.
 * Examples:
 * - When you want to run an action where the target is different from a Node.
 * - When you want to pause / resume the actions
 * @since v0.8
 */
@Platform(include = "CCActionProgressTimer.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class ActionManager
    extends FadeOutUpTiles
{
    /**
     * Adds an action with a target.
     * If the target is already present, then the action will be added to the existing target.
     * If the target is not present, a new instance of this target will be created either paused or not, and the action will be added to the newly created target.
     * When the target is paused, the queued actions won't be 'ticked'.
     */
    public native void addAction(Action action, Node target, boolean paused);

    /**
     * Removes all actions from all the targets.
     */
    public native void removeAllActions();

    /**
     * Removes all actions from a certain target.
     * All the actions that belongs to the target will be removed.
     */
    public native void removeAllActionsFromTarget(Node target);

    /**
     * Removes an action given an action reference.
     */
    public native void removeAction(Action action);

    /**
     * Removes an action given its tag and the target
     */
    public native void removeActionByTag(int tag, Node target);

    /**
     * Gets an action given its tag an a target
     *
     * @return the Action the with the given tag
     */
    public native Action getActionByTag(int tag, @Const Node target);

    /** Returns the numbers of actions that are running in a certain target.
     * Composable actions are counted as 1 action. Example:
     * - If you are running 1 Sequence of 7 actions, it will return 1.
     * - If you are running 7 Sequences of 2 actions, it will return 7.
     */
//     public native  ssize_t getNumberOfRunningActionsInTarget(const Node *target) const;

    /** @deprecated use getNumberOfRunningActionsInTarget() instead */
//     CC_DEPRECATED_ATTRIBUTE inline ssize_t numberOfRunningActionsInTarget(Node *target) const { return getNumberOfRunningActionsInTarget(target); }

    /**
     * Pauses the target: all running actions and newly added actions will be paused.
     */
    public native void pauseTarget(Node target);

    /**
     * Resumes the target. All queued actions will be resumed.
     */
    public native void resumeTarget(Node target);

    /** Pauses all running actions, returning a list of targets whose actions were paused.
     */
//    public native Vector<Node*> pauseAllRunningActions();

    /** Resume a set of targets (convenience function to reverse a pauseAllRunningActions call)
     */
//     public native void resumeTargets(const Vector<Node*>& targetsToResume);
}