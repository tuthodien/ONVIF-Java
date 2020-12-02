package be.teletask.onvif.parsers;

import be.teletask.onvif.models.OnvifPreset;
import be.teletask.onvif.responses.OnvifResponse;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Luke F on 02/12/2020.
 */
public class GetPresetsParser extends OnvifParser<List<OnvifPreset>> {

    //Constants
    public static final String TAG = GetPresetsParser.class.getSimpleName();

    private static final String KEY_PRESET = "Preset";
    private static final String ATTR_TOKEN = "token";
    private static final String ATTR_NAME = "Name";

    private static final String KEY_POSITION = "PTZPosition";
    private static final String KEY_POSITION_PANTILT = "PanTilt";
    private static final String KEY_POSITION_ZOOM = "Zoom";


    @Override
    public List<OnvifPreset> parse(OnvifResponse response) {

        List<OnvifPreset> presets = new ArrayList<>();

        try {
            getXpp().setInput(new StringReader(response.getXml()));
            eventType = getXpp().getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {

                OnvifPreset onvifPreset = new OnvifPreset();

                if (eventType == XmlPullParser.START_TAG && getXpp().getName().equals(KEY_PRESET)) {

                    String token = getXpp().getAttributeValue(null, ATTR_TOKEN);
                    onvifPreset.setToken(token);
                    getXpp().nextTag();

                    if (getXpp().getName().equals(ATTR_NAME)) {
                        getXpp().next();
                        String name = getXpp().getText();
                        onvifPreset.setName(name);
                        // move to the end of current tag
                        getXpp().nextTag();
                    }

                    getXpp().nextTag();
                    if (getXpp().getName().equals(KEY_POSITION)) {

                        getXpp().nextTag();
                        if (getXpp().getName().equals(KEY_POSITION_PANTILT)) {

                            onvifPreset.setPan(Double.valueOf(getXpp().getAttributeValue(null, "x")));
                            onvifPreset.setTilt(Double.valueOf(getXpp().getAttributeValue(null, "y")));
                            getXpp().nextTag();
                        }

                        getXpp().nextTag();
                        if (getXpp().getName().equals(KEY_POSITION_ZOOM)) {
                            onvifPreset.setZoom(Double.valueOf(getXpp().getAttributeValue(null, "x")));
                        }
                        getXpp().nextTag();

                    }

                    presets.add(onvifPreset);
                }

                eventType = getXpp().next();
            }
        } catch (XmlPullParserException | IOException e) {
            e.printStackTrace();
        }

        return presets;
    }

}
