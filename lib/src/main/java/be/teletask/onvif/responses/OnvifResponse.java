package be.teletask.onvif.responses;

import be.teletask.onvif.requests.OnvifRequest;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Tomas Verhelst on 03/09/2018.
 * Copyright (c) 2018 TELETASK BVBA. All rights reserved.
 */
@Getter
@Setter
public class OnvifResponse<T> {

    //Constants
    public static final String TAG = OnvifResponse.class.getSimpleName();

    //Attributes
    private boolean success;
    private int errorCode;
    private String errorMessage;
    private String xml;

    private OnvifRequest onvifRequest;

    //Constructors
    public OnvifResponse(String xml) {
        this.xml = xml;
    }

    public OnvifResponse(OnvifRequest onvifRequest) {
        this.onvifRequest = onvifRequest;
    }

    //Properties
    public OnvifRequest request() {
        return onvifRequest;
    }
}
