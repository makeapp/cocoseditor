/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj;

import com.googlecode.javacpp.FunctionPointer;
import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.*;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/4/12 13:21 $
 *          $Id$
 */
@Platform(include = "CCScheduler.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class Scheduler extends Pointer {
    // Priority level reserved for system services.
//   public  static final  int PRIORITY_SYSTEM=0;

    // Minimum priority level for user scheduling.
//    static  int PRIORITY_NON_SYSTEM_MIN;

    public native float getTimeScale();

    /**
     * Modifies the time of all scheduled callbacks.
     * You can use this property to create a 'slow motion' or 'fast forward' effect.
     * Default is 1.0. To create a 'slow motion' effect, use values below 1.0.
     * To create a 'fast forward' effect, use values higher than 1.0.
     *
     * @warning It will affect EVERY scheduled selector / action.
     * @since v0.8
     */
    public native void setTimeScale(float timeScale);

    /** 'update' the scheduler.
     You should NEVER call this method, unless you know what you are doing.
     * @js NA
     * @lua NA
     */
//        void update(float dt);

    /**
     * The scheduled method will be called every 'interval' seconds.
     * If paused is true, then it won't be called until it is resumed.
     * If 'interval' is 0, it will be called every frame, but if so, it's recommended to use 'scheduleUpdateForTarget:' instead.
     * If the selector is already scheduled, then only the interval parameter will be updated without re-scheduling it again.
     * repeat let the action be repeated repeat + 1 times, use kRepeatForever to let the action run continuously
     * delay is the amount of time the action will wait before it'll start
     *
     * @since v0.99.3, repeat and delay added in v1.1
     */
    public native void schedule(SchedulerCallback selector, @Target @Cast("cocos2d::Ref *") Pointer target, float interval, int repeat, float delay, boolean paused);

    public void schedule(SchedulerCallback selector, float interval, int repeat, float delay, boolean paused) {
        schedule(selector, selector, interval, repeat, delay, paused);
    }

    /**
     * calls scheduleSelector with kRepeatForever and a 0 delay
     */
//    private native void scheduleSelector(SchedulerCallback selector, @Target @Cast("cocos2d::Ref *") SchedulerCallback target, float interval, boolean paused);
    public void schedule(SchedulerCallback selector, float interval, boolean paused) {
        schedule(selector, interval, -1, 0, paused);
    }

    /**
     * Schedules the 'update' selector for a given target with a given priority.
     * The 'update' selector will be called every frame.
     * The lower the priority, the earlier it is called.
     *
     * @since v0.99.3
     */
//    public native void scheduleUpdateForTarget(Ref target, int priority, boolean paused);

    /**
     * Checks whether a selector for a given taget is scheduled.
     *
     * @since v3.0.0
     */
    public boolean isScheduled(SchedulerCallback selector) {
        return isScheduled(selector, selector);
    }

    private native boolean isScheduled(SchedulerCallback selector, @Target @Cast("cocos2d::Ref *") SchedulerCallback target);


    /**
     * The scheduled script callback will be called every 'interval' seconds.
     * If paused is true, then it won't be called until it is resumed.
     * If 'interval' is 0, it will be called every frame.
     * return schedule script entry ID, used for unscheduleScriptFunc().
     */
    public native int scheduleScriptFunc(int handler, float interval, boolean paused);

    /**
     * Unschedule a script entry.
     */
    public native void unscheduleScriptEntry(int scheduleScriptEntryID);

    /**
     * Unschedule a selector for a given target.
     * If you want to unschedule the "update", use unscheudleUpdateForTarget.
     *
     * @since v0.99.3
     */
    private native void unschedule(SchedulerCallback selector, @Target @Cast("cocos2d::Ref *") SchedulerCallback target);

    public void unschedule(SchedulerCallback selector) {
        unschedule(selector, selector);
    }

    /**
     * Unschedules the update selector for a given target
     *
     * @since v0.99.3
     */
    public native void unscheduleUpdate(Pointer target);

    /**
     * Unschedules all selectors for a given target.
     * This also includes the "update" selector.
     *
     * @since v0.99.3
     */
    public native void unscheduleAllForTarget(Pointer target);

    /**
     * Unschedules all selectors from all targets.
     * You should NEVER call this method, unless you know what you are doing.
     *
     * @since v0.99.3
     */
    public native void unscheduleAll();

    /**
     * Unschedules all selectors from all targets with a minimum priority.
     * You should only call this with kPriorityNonSystemMin or higher.
     *
     * @since v2.0.0
     */
    public native void unscheduleAllWithMinPriority(int minPriority);


    /**
     * Pauses the target.
     * All scheduled selectors/update for a given target won't be 'ticked' until the target is resumed.
     * If the target is not present, nothing happens.
     *
     * @since v0.99.3
     */
    public native void pauseTarget(Pointer target);

    /**
     * Resumes the target.
     * The 'target' will be unpaused, so all schedule selectors/update will be 'ticked' again.
     * If the target is not present, nothing happens.
     *
     * @since v0.99.3
     */
    public native void resumeTarget(Pointer target);

    /**
     * Returns whether or not the target is paused
     *
     * @lua NA
     * @since v1.0.0
     * In js: var isTargetPaused(var jsObject)
     */
    public native boolean isTargetPaused(Pointer target);

    /** Pause all selectors from all targets.
     You should NEVER call this method, unless you know what you are doing.
     @since v2.0.0
     */
//    Vector<Object*>   pauseAllTargets();

    /** Pause all selectors from all targets with a minimum priority.
     You should only call this with kPriorityNonSystemMin or higher.
     @since v2.0.0
     */
//    Vector<Object*>   pauseAllTargetsWithMinPriority(int minPriority);

    /**
     * Resume selectors on a set of targets.
     * This can be useful for undoing a call to pauseAllSelectors.
     *
     * @since v2.0.0
     */
//    void resumeTargets(const Vector<Object*>&targetsToResume);

    /**
     * calls a function on the cocos2d thread. Useful when you need to call a cocos2d function from another thread.
     * This function is thread safe.
     *
     * @since v3.0
     */
//    void performFunctionInCocosThread(const std::function<void() >&function);

    @Type("cocos2d::SEL_SCHEDULE")
    @Parent("cocos2d::Ref")
    public abstract static class SchedulerCallback
            extends FunctionPointer {
        public SchedulerCallback() {
            allocate();
        }

        @Allocator
        private native void allocate();

        private void call(float delta) {
            onUpdate(delta);
        }

        public void onUpdate(float delta) {

        }
    }

    public interface SchedulerListener {
        public void onUpdate(float delta);
    }
}
