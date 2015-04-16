package org.ccj;

import org.ccj.d2.Label;
import org.ccj.math.Size;

/**
 * @author touchsnow
 * @time 2014.04.19
 */
public class CurrentLanguageTest extends TestScene {

    @Override
    public void onCreate() {
        super.onCreate();
        Size s = Director.getInstance().getWinSize().fetch();
        Label label = Label.createWithSystemFont("Current language Test", "Arial", 28);
        this.addChild(label, 0);
        label.setPosition(s.width / 2, s.height - 50);

        Label labelLanguage = Label.createWithSystemFont("", "Arial", 20);
        labelLanguage.setPosition(s.width / 2, s.height / 2);
        labelLanguage.setString("current language is Chinese");

       /* String cur=System.getProperties().getProperty("os.name").toUpperCase();
        var currentLanguageType = cc.sys.language;
        switch (currentLanguageType) {
            case sys.LANGUAGE_ENGLISH:
                labelLanguage.setString("current language is English");
                break;
            case cc.sys.LANGUAGE_CHINESE:
                labelLanguage.setString("current language is Chinese");
                break;
            case cc.sys.LANGUAGE_FRENCH:
                labelLanguage.setString("current language is French");
                break;
            case cc.sys.LANGUAGE_GERMAN:
                labelLanguage.setString("current language is German");
                break;
            case cc.sys.LANGUAGE_ITALIAN:
                labelLanguage.setString("current language is Italian");
                break;
            case cc.sys.LANGUAGE_RUSSIAN:
                labelLanguage.setString("current language is Russian");
                break;
            case cc.sys.LANGUAGE_SPANISH:
                labelLanguage.setString("current language is Spanish");
                break;
        }*/

        this.addChild(labelLanguage);

    }


}
