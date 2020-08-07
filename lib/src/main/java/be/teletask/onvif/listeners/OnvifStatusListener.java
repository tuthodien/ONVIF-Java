package be.teletask.onvif.listeners;

import be.teletask.onvif.models.OnvifDevice;
import be.teletask.onvif.models.OnvifMediaProfile;
import be.teletask.onvif.models.OnvifStatus;


/**
 * Created by Luke F on 07/08/2020.
 */
public interface OnvifStatusListener {

    void onStatusReceived(OnvifDevice device, OnvifMediaProfile profile, OnvifStatus status);

}
