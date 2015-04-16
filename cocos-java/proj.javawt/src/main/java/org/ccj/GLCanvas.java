/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import org.ccj.util.StringUtil;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/3/29 7:42 $
 *          $Id$
 */
@com.googlecode.javacpp.annotation.Opaque
public class GLCanvas
    extends Canvas
    implements ActionListener
{
    public final static int TIMER_SECONDS = 2;

    boolean inited = false;
    Director director;
    javax.swing.Timer timer;

    static {
        String jvmName = System.getProperty("java.vm.name", "");
        String osName = System.getProperty("os.name", "");
        String osArch = System.getProperty("os.arch", "");
        String cocosjdkHome = System.getProperty("CDK_HOME", "");
        String javaLibPath = System.getProperty("java.library.path");

        if (osName.startsWith("Windows")) {
            if (StringUtil.isValid(cocosjdkHome)) {
                javaLibPath = cocosjdkHome + "/bin";
            }
            if (StringUtil.isValid(javaLibPath)) {
                System.load(javaLibPath + "/jawt.dll");
                System.load(javaLibPath + "/cocosjawt.dll");
            }
            else {
                System.err.println("Can't find dll path in COCOSJDK_HOME or java.library.path");
            }
        }

    }


    public GLCanvas()
    {
        addKeyListener(new KeyAdapter()
        {
            public void keyTyped(KeyEvent e)
            {
                super.keyTyped(e);
            }
        });
        addMouseMotionListener(new MouseMotionListener()
        {
            public void mouseDragged(MouseEvent e)
            {
                if (inited) {
                    float x = e.getX();
                    float y = e.getY();
                    Director.getInstance().getOpenGLView().handleTouchesMove(1, new int[0], new float[]{x}, new float[]{y});
                }
            }

            public void mouseMoved(MouseEvent e)
            {
            }
        });
        addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent e)
            {
                if (inited) {
                    float x = e.getX();
                    float y = e.getY();
                    GLView glView = Director.getInstance().getOpenGLView();
                    if (glView != null) {
                        glView.handleTouchesBegin(1, new int[0], new float[]{x}, new float[]{y});
                    }
                }
            }

            public void mouseReleased(MouseEvent e)
            {
                if (inited) {
                    float x = e.getX();
                    float y = e.getY();
                    GLView glView = Director.getInstance().getOpenGLView();
                    if (glView != null) {
                        glView.handleTouchesEnd(1, new int[0], new float[]{x}, new float[]{y});
                    }
                }
            }

            public void mouseMoved(MouseEvent e)
            {
                if (inited) {
                    float x = e.getX();
                    float y = e.getY();
                    GLView glView = Director.getInstance().getOpenGLView();
                    if (glView != null) {
                        glView.handleTouchesMove(1, new int[0], new float[]{x}, new float[]{y});
                    }
                }
            }
        });
    }

    public synchronized void actionPerformed(ActionEvent evt)
    {
//        repaint();

        if (!inited) {
            onStart();
            inited = true;
        }
        if (inited) {
            Director.getInstance().mainLoop();
        }
    }
//
//    public void paint(Graphics g)
//    {
//
//
//    }

    public void addNotify()
    {
        super.addNotify();
        timer = new javax.swing.Timer(TIMER_SECONDS, this);
        timer.start();
    }

    public void onStart()
    {

    }

    public void onStop()
    {

    }

    public void removeNotify()
    {
        super.removeNotify();

        onStop();
        inited = false;
        timer.stop();
        Director.getInstance().end();
        Director.getInstance().mainLoop();
    }

//    private static native boolean nativeKeyDown(final int pKeyCode);

    //    public native void init();
    public native static int getHWND(Object obj);

    public native static long createWithCanvas(long address, String viewName, int width, int height, float frameZoomFactor);
}
