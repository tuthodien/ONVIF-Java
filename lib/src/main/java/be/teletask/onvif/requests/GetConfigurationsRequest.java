package be.teletask.onvif.requests;

import be.teletask.onvif.listeners.OnvifConfigurationsListener;
import be.teletask.onvif.models.OnvifType;


/**
 * Created by Luke F on 10/01/2022.
 */
public class GetConfigurationsRequest implements OnvifRequest {

    //Constants
    public static final String TAG = GetConfigurationsRequest.class.getSimpleName();

    //Attributes
    private final OnvifConfigurationsListener listener;

    //Constructors
    public GetConfigurationsRequest(OnvifConfigurationsListener listener) {
        super();
        this.listener = listener;
    }

    //Properties

    public OnvifConfigurationsListener getListener() {
        return listener;
    }

    @Override
    public String getXml() {
        return "<GetConfigurations xmlns=\"http://www.onvif.org/ver20/ptz/wsdl\">" + "</GetConfigurations>";
    }

    @Override
    public OnvifType getType() {
        return OnvifType.GET_CONFIGURATIONS;
    }

}
