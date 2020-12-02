package be.teletask.onvif.listeners;

import be.teletask.onvif.models.*;

import java.util.List;


/**
 * Created by Luke F on 02/12/2020.
 */
public interface OnvifPresetsListener {

    void onPresetsReceived(OnvifDevice device, OnvifMediaProfile profile, List<OnvifPreset> presets);

}
