/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.cce.android;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.WindowManager;
import android.widget.Toast;
import org.cocos2dx.lib.Cocos2dxActivity;
import org.cocos2dx.lib.Cocos2dxGLSurfaceView;
import org.cocos2dx.lib.Cocos2dxRenderer;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/3/31 10:16 $
 *          $Id$
 */
public class CocosActivity
    extends Cocos2dxActivity
{
    long lastBackTime = 0;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
//        setKeepScreenOn(true);
    }


    public void onSurfaceChanged(GL10 pGL10, int pWidth, int pHeight)
    {

    }

    public  Cocos2dxRenderer getRenderer(){
        return new Cocos2dxRenderer()
        {
            public void onSurfaceCreated(GL10 pGL10, EGLConfig pEGLConfig)
            {
                if (!"cocosjava".equals(libName)) {
                    super.onSurfaceCreated(pGL10, pEGLConfig);
                }
                CocosActivity.this.onSurfaceCreated(pGL10, pEGLConfig, mScreenWidth, mScreenHeight);
            }

            //
            public void onSurfaceChanged(GL10 pGL10, int pWidth, int pHeight)
            {
                super.onSurfaceChanged(pGL10, pWidth, pHeight);
                CocosActivity.this.onSurfaceChanged(pGL10, pWidth, pHeight);
            }
        };
    }

    public void onSurfaceCreated(GL10 pGL10, EGLConfig pEGLConfig, final int mScreenWidth, final int mScreenHeight)
    {
        main(new String[]{String.valueOf(mScreenWidth), String.valueOf(mScreenHeight)});
    }

    public void main(String[] args)
    {

    }

    public boolean dispatchKeyEvent(KeyEvent event)
    {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK
            && event.getAction() == KeyEvent.ACTION_UP) {
            onBackPressed();
            return true;
        }
        return super.dispatchKeyEvent(event);
    }

    public void onFinish()
    {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);// 注意
        intent.addCategory(Intent.CATEGORY_HOME);
        this.startActivity(intent);
    }

    public void onBackPressed()
    {
        long time = System.currentTimeMillis();
        if (time - lastBackTime < 2000) {
            onFinish();
        }
        else {
            onShowFinish();
            lastBackTime = time;
        }
    }

    public void onShowFinish()
    {
        Toast.makeText(this, "再按一次返回键退出游戏!", Toast.LENGTH_SHORT).show();
    }
}
