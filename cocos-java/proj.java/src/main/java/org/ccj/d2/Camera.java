package org.ccj.d2;

import com.googlecode.javacpp.annotation.*;
import org.ccj.math.Size;
import org.ccj.math.Vec3;

/**
 * Created by yuanyou on 2014/12/16.
 */

@Platform(include = "CCCamera.h")
@Namespace("cocos2d")
@com.googlecode.javacpp.annotation.Opaque
public class Camera extends Node {
   public static final   int Type_PERSPECTIVE = 1;
    public static final    int Type_ORTHOGRAPHIC = 2;

    /**
     * Creates a perspective camera.
     *
     * @param fieldOfView The field of view for the perspective camera (normally in the range of 40-60 degrees).
     * @param aspectRatio The aspect ratio of the camera (normally the width of the viewport divided by the height of the viewport).
     * @param nearPlane The near plane distance.
     * @param farPlane The far plane distance.
     */
  public native  static Camera    createPerspective(float fieldOfView, float aspectRatio, float nearPlane, float farPlane);
    /**
     * Creates an orthographic camera.
     *
     * @param zoomX The zoom factor along the X-axis of the orthographic projection (the width of the ortho projection).
     * @param zoomY The zoom factor along the Y-axis of the orthographic projection (the height of the ortho projection).
     * @param aspectRatio The aspect ratio of the orthographic projection.
     * @param nearPlane The near plane distance.
     * @param farPlane The far plane distance.
     */
    public native   static Camera  createOrthographic(float zoomX, float zoomY, float nearPlane, float farPlane);

    /** create default camera, the camera type depends on Director::getProjection */
    public native   static Camera create();

    /**
     * Gets the type of camera.
     *
     * @return The camera type.
     */
    @Cast("int")
    public native  int  getType();

    /**get & set Camera flag*/
    @Cast("int")
    public native   int getCameraFlag();

    public native   void setCameraFlag(@Cast("cocos2d::CameraFlag") int flag) ;
    /**
     * Sets the position (X, Y, and Z) in its parent's coordinate system
     */
    public native  void setPosition3D(@Const @ByRef Vec3 position) ;
    /**
     * Creates a view matrix based on the specified input parameters.
     *
     * @param eyePosition The eye position.
     * @param targetPosition The target's center position.
     * @param up The up vector.
     * @param dst A matrix to store the result in.
     */
    public native  void lookAt(@Const @ByRef Vec3 target, @Const @ByRef Vec3 up);

    /**
     * Gets the camera's projection matrix.
     *
     * @return The camera projection matrix.
     */
//    @Const @ByRef
//    public native  Mat4 getProjectionMatrix() ;
    /**
     * Gets the camera's view matrix.
     *
     * @return The camera view matrix.
     */
//    @Const @ByRef
//    public native    Mat4 getViewMatrix() ;

    /**get view projection matrix*/
//    @Const @ByRef
//    public native   Mat4 getViewProjectionMatrix() ;

    /**
     * Convert the specified point of viewport from screenspace coordinate into the worldspace coordinate.
     */
    public native  void unproject(@Const @ByRef Size viewport, Vec3 src, Vec3 dst) ;

    @Const
    public native  static  Camera getVisitingCamera() ;
}
