package be.teletask.onvif.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Luke F on 07/08/2020.
 */
@Getter
@Setter
@NoArgsConstructor
public class OnvifStatus {

    //Constants
    public static final String TAG = OnvifStatus.class.getSimpleName();

    //Attributes

    //Constructors
    private Double pan, tilt, zoom;

    //Constructors

    //Properties


    @Override
    public String toString() {
        return "OnvifStatus{" +
                "pan='" + pan + '\'' +
                ", tilt='" + tilt + '\'' +
                ", zoom='" + zoom + '\'' +
                '}';
    }
}
