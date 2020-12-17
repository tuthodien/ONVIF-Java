package be.teletask.onvif.parsers;

import be.teletask.onvif.models.OnvifPreset;
import be.teletask.onvif.responses.OnvifResponse;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.StringReader;

/**
 * Created by Luke F on 17/12/2020.
 */
public class SetPresetParser extends OnvifParser<OnvifPreset> {

    //Constants
    public static final String TAG = SetPresetParser.class.getSimpleName();

    private static final String KEY_PRESET_TOKEN = "PresetToken";

    @Override
    public OnvifPreset parse(OnvifResponse response) {

        OnvifPreset preset = new OnvifPreset();
        try {
            getXpp().setInput(new StringReader(response.getXml()));
            eventType = getXpp().getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {

                if (eventType == XmlPullParser.START_TAG && getXpp().getName().equals(KEY_PRESET_TOKEN)) {

                    getXpp().next();
                    preset.setToken(getXpp().getText());
                    return preset;
                }

                eventType = getXpp().next();
            }
        } catch (XmlPullParserException | IOException e) {
            e.printStackTrace();
        }

        return preset;
    }

}
