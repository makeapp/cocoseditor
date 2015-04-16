package org.cce.android;
/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.makeapp.android.extras.FunctionAndroid;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:2014/3/31 10:16 $
 *          $Id$
 */
public class CocosExtrasActivity
        extends CocosActivity {
    protected FrameLayout rootView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FunctionAndroid.doCreate(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        FunctionAndroid.doResume();
    }

    protected void onStart() {
        super.onStart();
        FunctionAndroid.doStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
        FunctionAndroid.doPause();
    }

    protected void onDestroy() {
        super.onDestroy();
        FunctionAndroid.doDestroy();
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        FunctionAndroid.doActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void init() {
        super.init();
        FunctionAndroid.doShow(mFrameLayout);
    }
}
