package be.teletask.onvif.models;

/**
 * Created by Luke F on 07/08/2020.
 */
public class OnvifSnapshotUri {

    //Constants
    public static final String TAG = OnvifSnapshotUri.class.getSimpleName();

    //Attributes
    private final String name;
    private final String token;

    //Constructors

    public OnvifSnapshotUri(String name, String token) {
        this.name = name;
        this.token = token;
    }

    //Properties

    public String getName() {
        return name;
    }

    public String getToken() {
        return token;
    }

    @Override
    public String toString() {
        return "OnvifSnapshotUri{" +
                "name='" + name + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
