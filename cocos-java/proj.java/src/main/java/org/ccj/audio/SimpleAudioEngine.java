/**
 *  Copyright(c) Shanghai YiJun Network Technologies Inc. All right reserved.
 */
package org.ccj.audio;

import com.googlecode.javacpp.Pointer;
import com.googlecode.javacpp.annotation.Cast;
import com.googlecode.javacpp.annotation.Name;
import com.googlecode.javacpp.annotation.Platform;

/**
 * @author <a href="mailto:yuanyou@makeapp.co">yuanyou</a>
 * @version $Date:14-3-6 下午12:24 $
 *          $Id$
 */
@Platform(include = "SimpleAudioEngine.h")
@Name("CocosDenshion::SimpleAudioEngine")
@com.googlecode.javacpp.annotation.Opaque
public class SimpleAudioEngine extends Pointer
{
    /**
     * @brief Get the shared Engine object,it will new one when first time be called
     */
    public native static SimpleAudioEngine getInstance();

    /**
     * @brief Release the shared Engine object
     * @warning It must be called before the application exit, or a memory leak will be casued.
     */
    public native static void end();

    /**
     * @param pszFilePath The path of the background music file.
     *
     * @brief Preload background music
     * @js preloadMusic
     * @lua preloadMusic
     */
    public native void preloadBackgroundMusic(String pszFilePath);

    /**
     * @param pszFilePath The path of the background music file,or the FileName of T_SoundResInfo
     * @param bLoop       Whether the background music loop or not
     *
     * @brief Play background music
     * @js playMusic
     * @lua playMusic
     */
    public native void playBackgroundMusic(String pszFilePath, boolean bLoop);

    /**
     * @param bReleaseData If release the background music data or not.As default value is false
     *
     * @brief Stop playing background music
     * @js stopMusic
     * @lua stopMusic
     */
    public native void stopBackgroundMusic(@Cast("bool") boolean bReleaseData);

    /**
     * @brief Pause playing background music
     * @js pauseMusic
     * @lua pauseMusic
     */
    public native void pauseBackgroundMusic();

    /**
     * @brief Resume playing background music
     * @js resumeMusic
     * @lua resumeMusic
     */
    public native void resumeBackgroundMusic();

    /**
     * @brief Rewind playing background music
     * @js rewindMusic
     * @lua rewindMusic
     */
    public native void rewindBackgroundMusic();

    /**
     * @return <i>true</i> if background music can be played, otherwise <i>false</i>.
     *
     * @brief Indicates whether any background music can be played or not.
     * @js willPlayMusic
     * @lua willPlayMusic
     */
    public native boolean willPlayBackgroundMusic();

    /**
     * @return <i>true</i> if the background music is playing, otherwise <i>false</i>
     *
     * @brief Indicates whether the background music is playing
     * @js isMusicPlaying
     * @lua isMusicPlaying
     */
    public native boolean isBackgroundMusicPlaying();

    //
    // properties
    //

    /**
     * @brief The volume of the background music within the range of 0.0 as the minimum and 1.0 as the maximum.
     * @js getMusicVolume
     * @lua getMusicVolume
     */
    public native float getBackgroundMusicVolume();

    /**
     * @param volume must be within the range of 0.0 as the minimum and 1.0 as the maximum.
     *
     * @brief Set the volume of background music
     * @js setMusicVolume
     * @lua setMusicVolume
     */
    public native void setBackgroundMusicVolume(float volume);

    /**
     * @brief The volume of the effects within the range of 0.0 as the minimum and 1.0 as the maximum.
     */
    public native float getEffectsVolume();

    /**
     * @param volume must be within the range of 0.0 as the minimum and 1.0 as the maximum.
     *
     * @brief Set the volume of sound effects
     */
    public native void setEffectsVolume(float volume);

    //
    // for sound effects

    /**
     * @param pszFilePath The path of the effect file.
     * @param bLoop       Determines whether to loop the effect playing or not. The default value is false.
     * @param pitch       Frequency, normal value is 1.0. Will also change effect play time.
     * @param pan         Stereo effect, in the range of [-1..1] where -1 enables only left channel.
     * @param gain        Volume, in the range of [0..1]. The normal value is 1.
     *
     * @return the OpenAL source id
     *
     * @brief Play sound effect with a file path, pitch, pan and gain
     * @note Full support is under development, now there are limitations:
     * - no pitch effect on Samsung Galaxy S2 with OpenSL backend enabled;
     * - no pitch/pan/gain on emscrippten, win32, marmalade.
     * float pitch = 1.0f, float pan = 0.0f, float gain = 1.0f
     */
    public native int playEffect(String pszFilePath, boolean bLoop, float pitch, float pan, float gain);

    public int playEffect(String pszFilePath)
    {
        return playEffect(pszFilePath, false, 1.0f, 0f, 1f);
    }

    /**
     * @param nSoundId The return value of function playEffect
     *
     * @brief Pause playing sound effect
     */
    public native void pauseEffect(int nSoundId);

    /**
     * @brief Pause all playing sound effect
     */
    public native void pauseAllEffects();

    /**
     * @param nSoundId The return value of function playEffect
     *
     * @brief Resume playing sound effect
     */
    public native void resumeEffect(int nSoundId);

    /**
     * @brief Resume all playing sound effect
     */
    public native void resumeAllEffects();

    /**
     * @param nSoundId The return value of function playEffect
     *
     * @brief Stop playing sound effect
     */
    public native void stopEffect(int nSoundId);

    /**
     * @brief Stop all playing sound effects
     */
    public native void stopAllEffects();

    /**
     * @param pszFilePath The path of the effect file
     *
     * @brief preload a compressed audio file
     * @details the compressed audio will be decoded to wave, then written into an internal buffer in SimpleAudioEngine
     */
    public native void preloadEffect(String pszFilePath);

    /**
     * @param pszFilePath The path of the effect file
     *
     * @brief unload the preloaded effect from internal buffer
     */
    public native void unloadEffect(String pszFilePath);
}
