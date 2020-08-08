package be.teletask.onvif.parsers;

import be.teletask.onvif.models.OnvifStatus;
import be.teletask.onvif.responses.OnvifResponse;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.StringReader;

/**
 * Created by Luke F on 07/08/2020.
 */
public class GetStatusParser extends OnvifParser<OnvifStatus> {

    //Constants
    public static final String TAG = GetStatusParser.class.getSimpleName();

    private static final String KEY_POSITION = "Position";
    private static final String KEY_POSITION_PANTILT = "PanTilt";
    private static final String KEY_POSITION_ZOOM = "Zoom";

    @Override
    public OnvifStatus parse(OnvifResponse response) {

        OnvifStatus status = new OnvifStatus();
        try {
            getXpp().setInput(new StringReader(response.getXml()));
            eventType = getXpp().getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {

                if (eventType == XmlPullParser.START_TAG && getXpp().getName().equals(KEY_POSITION_PANTILT)) {
                    for (int i = 0; i < getXpp().getAttributeCount(); i++) {
                        if (getXpp().getAttributeName(i).equals("x")) {
                            status.setPan(Double.valueOf(getXpp().getAttributeValue(i)));
                        } else if (getXpp().getAttributeName(i).equals("y")) {
                            status.setTilt(Double.valueOf(getXpp().getAttributeValue(i)));
                        }
                    }
                } else if (eventType == XmlPullParser.START_TAG && getXpp().getName().equals(KEY_POSITION_ZOOM)) {
                    for (int i = 0; i < getXpp().getAttributeCount(); i++) {
                        if (getXpp().getAttributeName(i).equals("x")) {
                            status.setZoom(Double.valueOf(getXpp().getAttributeValue(i)));
                        }
                    }
                } else if (eventType == XmlPullParser.END_TAG && getXpp().getName().equals(KEY_POSITION)) {
                    return status;
                }

                eventType = getXpp().next();
            }
        } catch (XmlPullParserException | IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
