/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.ui;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.Name;
import com.googlecode.javacpp.annotation.Platform;
import com.googlecode.javacpp.annotation.StdString;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-3-6 下午12:03 $
 *          $Id$
 */
//@Platform(include = "ui/UIVideoPlayer.h")
//@Name("cocos2d::experimental::ui::VideoPlayer")
//@com.googlecode.javacpp.annotation.Opaque
public class VideoView
    extends Widget
{
    public VideoView(Pointer p)
    {
        super(p);
    }

//    enum class EventType
//              {
//                  PLAYING = 0,
//                  PAUSED,
//                  STOPPED,
//                  COMPLETED
//              };

//              typedef std::function<void(Ref*,VideoPlayer::EventType)> ccVideoPlayerCallback;

   /* public static native VideoView create();

    //Sets local file[support assets' file on android] as a video source for VideoPlayer
    public native void setFileName(@StdString String videoPath);

    @StdString
    public native String getFileName();

    //Sets network link as a video source for VideoPlayer
    public native void setURL(@StdString String videoURL);

    @StdString
    public native String getURL();

    public native void play();

    public native void pause();

    public native void resume();

    public native void stop();

    public native void seekTo(float sec);

    public native boolean isPlaying();

    public native void setVisible(boolean visible);

    public native void setKeepAspectRatioEnabled(boolean enable);

    public native boolean isKeepAspectRatioEnabled();

    public native void setFullScreenEnabled(boolean enabled);

    public native boolean isFullScreenEnabled();*/

//                public native   void addEventListener(const VideoPlayer::ccVideoPlayerCallback& callback);

//                public native   void onPlayEvent(VideoPlayer::EventType event);
}
