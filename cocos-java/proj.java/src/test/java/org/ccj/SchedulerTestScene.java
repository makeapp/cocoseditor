/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/4/21 10:13 $
 *          $Id$
 */
public class SchedulerTestScene
    extends TestScene
{
    public Class[] getLayers()
    {
        return new Class[]{SchedulerAutoremove.class};
    }



    static class SchedulerAutoremove extends TestLayer
    {
        float accum = 0;

        public void onCreate()
        {
            super.onCreate();

            this.schedule(new Scheduler.SchedulerCallback()
            {
                public void onUpdate(float delta)
                {
                    super.onUpdate(delta);
                    accum += delta;
                    Logger.log("Time: " + accum);
                    if (accum > 3) {
                        unschedule(this);
                        Logger.log("scheduler removed");
                    }
                }
            }, 0.5f);

            this.schedule(new Scheduler.SchedulerCallback()
            {
                public void onUpdate(float delta)
                {
                    super.onUpdate(delta);
                    Logger.log("This scheduler should not be removed");
                }
            }, 0.5f);
        }

        public String getTitle()
        {
            return "Self-remove an scheduler";
        }

        public String getSubTitle()
        {
            return "1 scheduler will be autoremoved in 3 seconds. See console";
        }
    }
}
