package be.teletask.onvif.listeners;

import be.teletask.onvif.models.OnvifDevice;
import be.teletask.onvif.responses.OnvifResponse;


/**
 * Created by Luke F on 07/08/2020.
 *
 * to handle ptz response that doesn't require data extraction, like GotoHomePositionResponse, AbsoluteMoveResponse
 */
public interface OnvifBlankResponseListener {

    void onResponse(OnvifDevice onvifDevice, OnvifResponse response);

    void onError(OnvifDevice onvifDevice, int errorCode, String errorMessage);

}
