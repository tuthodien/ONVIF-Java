package be.teletask.onvif.listeners;

import be.teletask.onvif.models.OnvifDevice;
import be.teletask.onvif.models.OnvifConfiguration;

import java.util.List;


/**
 * Created by Luke F on 10/01/2022.
 */
public interface OnvifConfigurationsListener {

    void onConfigurationsReceived(OnvifDevice device, List<OnvifConfiguration> onvifConfigurations);

}
