package be.teletask.onvif.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by Luke F on 02/12/2020.
 */
@Getter
@Setter
@NoArgsConstructor
public class OnvifPreset {

    //Constants
    public static final String TAG = OnvifPreset.class.getSimpleName();

    //Attributes

    //Constructors
    private String token, name;

    public OnvifPreset(String token, String name) {
        this.token = token;
        this.name = name;
    }

    private Double pan, tilt, zoom;

    //Constructors

    //Properties


    @Override
    public String toString() {
        return "OnvifPreset{" +
                "token='" + token + '\'' +
                ", name='" + name + '\'' +
                ", pan='" + pan + '\'' +
                ", tilt='" + tilt + '\'' +
                ", zoom='" + zoom + '\'' +
                '}';
    }
}
