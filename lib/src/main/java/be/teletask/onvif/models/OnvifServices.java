package be.teletask.onvif.models;

/**
 * Created by Tomas Verhelst on 03/09/2018.
 * Copyright (c) 2018 TELETASK BVBA. All rights reserved.
 */
public class OnvifServices {

    //Constants
    public static final String TAG = OnvifServices.class.getSimpleName();
    public static final String ONVIF_PATH_SERVICES = "/onvif/services";
    public static final String ONVIF_PATH_DEVICE_URI = "/onvif/device_service";
    public static final String ONVIF_PATH_MEDIA_URI = "/onvif/media_service";
    public static final String ONVIF_PATH_PTZ_URI = "/onvif/ptz_service";

    //Attributes
    private String servicesPath = ONVIF_PATH_SERVICES;
    private String devicePath = ONVIF_PATH_DEVICE_URI;
    private String mediaPath = ONVIF_PATH_MEDIA_URI;
    private String ptzPath = ONVIF_PATH_PTZ_URI;

    //Constructors
    public OnvifServices() {
    }

    //Properties

    public String getServicesPath() {
        return servicesPath;
    }

    public void setServicesPath(String servicesPath) {
        this.servicesPath = servicesPath;
    }

    public String getDevicePath() {
        return devicePath;
    }

    public void setDevicePath(String devicePath) {
        this.devicePath = devicePath;
    }

    public String getMediaPath() {
        return mediaPath;
    }

    public void setMediaPath(String mediaPath) {
        this.mediaPath = mediaPath;
    }

    public String getPtzPath() {
        return ptzPath;
    }

    public void setPtzPath(String ptzPath) {
        this.ptzPath = ptzPath;
    }
}
