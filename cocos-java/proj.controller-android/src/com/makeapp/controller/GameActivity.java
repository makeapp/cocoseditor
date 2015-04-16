package com.makeapp.controller;
/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */


import org.cce.android.CocosActivity;
import org.cce.game.MainController;

/**
 * -
 * -Game Engine:Cocos2d-Java
 * -
 * -Game Develop Tool:CocosEditor
 * -
 * -Doc Links
 * http://www.cocoseditor.com/ (Office Website)
 * http://blog.makeapp.co/ (Office Blog(
 * http://blog.csdn.net/touchsnow (csdn Blog)
 * https://github.com/makeapp      (github)
 * -
 * -Support
 * E-Mail:  zuowen@makeapp.co
 * QQ    :  232361142
 */
public class GameActivity
        extends CocosActivity {

    @Override
    public void main(String[] args) {
        super.main(args);
        MainController.main(args);
    }
}
