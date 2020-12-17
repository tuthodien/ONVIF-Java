package be.teletask.onvif.listeners;

import be.teletask.onvif.models.OnvifDevice;
import be.teletask.onvif.models.OnvifMediaProfile;
import be.teletask.onvif.models.OnvifPreset;

import java.util.List;


/**
 * Created by Luke F on 17/12/2020.
 */
public interface OnvifPresetListener {

    void onPresetReceived(OnvifDevice device, OnvifMediaProfile profile, OnvifPreset preset);

}
