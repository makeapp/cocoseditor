/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right Resourceserved.
 */
package org.ccj;

import org.ccj.base.FileUtils;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-2-23 上午11:15 $
 *          $Id$
 */
public class TestMain
{
    public static void main(String[] args)
    {
        int w = 900;
        int h = 600;

        if (args != null && args.length >= 2) {
            w = Integer.parseInt(args[0]);
            h = Integer.parseInt(args[1]);
        }

        final int width = w;
        final int height = h;

        Application app = new Application()
        {
            public boolean applicationDidFinishLaunching()
            {
                if (OS_WINDOWS == getTargetPlatform() || OS_ANDROID == getTargetPlatform()) {
                    GLView eglView = GLView.create("CocosPlayer");
                    eglView.setFrameSize(width, height);
                    Director.getInstance().setOpenGLView(eglView);
                }

                runTest();

                return true;
            }
        };

        app.run();
    }

    public static void runTest()
    {
        String paths[] = {
            "",
            "scenetest",
            "scenetest/ArmatureComponentTest",
            "scenetest/AttributeComponentTest",
            "scenetest/BackgroundComponentTest",
            "scenetest/EffectComponentTest",
            "scenetest/LoadSceneEdtiorFileTest",
            "scenetest/ParticleComponentTest",
            "scenetest/SpriteComponentTest",
            "scenetest/TmxMapComponentTest",
            "scenetest/UIComponentTest",
            "scenetest/TriggerTest",
        };
        for (String path : paths) {
            FileUtils.getInstance().addSearchPath(path);
        }
        Director director = Director.getInstance();
        director.setDisplayStats(true);

        director.getOpenGLView().setDesignResolutionSize(900, 600, GLView.POLICY_EXACT_FIT);
        director.runWithScene(new TestMainScene());
    }
}
