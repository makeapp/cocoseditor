/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.ccj.base.FileUtils;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/3/29 10:11 $
 *          $Id$
 */
public class MainCanvasTest implements Runnable
{
    boolean loaded = false;

    public void run()
    {
        final Frame f = new Frame();
        f.setSize(900, 600);
        f.setLayout(new BorderLayout());
        f.setTitle("CocosJavaCanvas");

        final GLCanvas glCanvas = new GLCanvas()
        {
            public void onStart()
            {
                final long hwnd = getHWND(this);

                Application app = new Application()
                {
                    public boolean applicationDidFinishLaunching()
                    {
                        final int width = getWidth();
                        final int height = getHeight() - 50;
                        long glView = createWithCanvas(hwnd, "CocosGame", width, height, 1);

                        GLView eglView = new GLView(glView);//GLView.createWithCanvas(hwnd, "CocosPlayer", new Rect(0, 0, width, height), 1);
                        eglView.retain();

                        Director dir= Director.getInstance();

                        dir.setOpenGLView(eglView);
                        TestMain.runTest();
                        return true;
                    }
                };
                app.applicationDidFinishLaunching();
            }
        };
        glCanvas.setSize(900, 700);
        glCanvas.setBackground(Color.BLUE);

        Button button = new Button("Load");
        button.addActionListener(new ActionListener()
        {

            public void actionPerformed(ActionEvent e)
            {
                if (!loaded) {
                    f.add(glCanvas, BorderLayout.CENTER);
                    loaded = true;
                }
                else {
                    f.remove(glCanvas);
                    loaded = false;
                }
            }
        });
        f.add(button, BorderLayout.SOUTH);
        f.setVisible(true);

        f.add(glCanvas, BorderLayout.CENTER);
        loaded = true;
    }


    public static void main(String[] argv)
    {
        new MainCanvasTest().run();
        try {
            Thread.sleep(100000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
