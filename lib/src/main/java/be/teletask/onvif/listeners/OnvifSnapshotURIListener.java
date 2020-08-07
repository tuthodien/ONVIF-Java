package be.teletask.onvif.listeners;

import be.teletask.onvif.models.OnvifDevice;
import be.teletask.onvif.models.OnvifMediaProfile;


/**
 * Created by Luke F on 07/08/2020.
 */
public interface OnvifSnapshotURIListener {

    void onSnapshotURIReceived(OnvifDevice device, OnvifMediaProfile profile, String uri);

}
