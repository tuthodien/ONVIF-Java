package be.teletask.onvif.parsers;

import be.teletask.onvif.models.OnvifStatus;
import be.teletask.onvif.responses.OnvifResponse;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.StringReader;

/**
 * Created by Luke F on 07/08/2020.
 *
 * sample:
 * <SOAP-ENV:Envelope xmlns:SOAP-ENV="http://www.w3.org/2003/05/soap-envelope" xmlns:SOAP-ENC="http://www.w3.org/2003/05/soap-encoding" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:xsd="http://www.w3.org/2001/XMLSchema" xmlns:c14n="http://www.w3.org/2001/10/xml-exc-c14n#" xmlns:wsu="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd" xmlns:ds="http://www.w3.org/2000/09/xmldsig#" xmlns:wsse="http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd" xmlns:wsa5="http://www.w3.org/2005/08/addressing" xmlns:tt="http://www.onvif.org/ver10/schema" xmlns:tptz="http://www.onvif.org/ver20/ptz/wsdl" xmlns:ter="http://www.onvif.org/ver10/error">
 *    <SOAP-ENV:Header/>
 *    <SOAP-ENV:Body>
 *       <tptz:GetStatusResponse>
 *          <tptz:PTZStatus>
 *             <tt:Position>
 *                <tt:PanTilt space="http://www.onvif.org/ver10/tptz/PanTiltSpaces/PositionGenericSpace" x="-0.0900000036" y="0.670000017"/>
 *                <tt:Zoom space="http://www.onvif.org/ver10/tptz/ZoomSpaces/PositionGenericSpace" x="0.0435043499"/>
 *             </tt:Position>
 *             <tt:MoveStatus>
 *                <tt:PanTilt>IDLE</tt:PanTilt>
 *                <tt:Zoom>IDLE</tt:Zoom>
 *             </tt:MoveStatus>
 *             <tt:UtcTime>2020-08-07T12:10:32Z</tt:UtcTime>
 *          </tptz:PTZStatus>
 *       </tptz:GetStatusResponse>
 *    </SOAP-ENV:Body>
 * </SOAP-ENV:Envelope>
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

                if (eventType == XmlPullParser.START_TAG && getXpp().getName().equals(KEY_POSITION)) {
                    eventType = getXpp().next();

                    while (true) {
                        eventType = getXpp().next();
                        if (getXpp().getName() != null) {
                            switch (getXpp().getName()) {
                                case KEY_POSITION_PANTILT:
                                    for (int i = 0; i < getXpp().getAttributeCount(); i++) {
                                        if (getXpp().getAttributeName(i).equals("x")) {
                                            status.setPan(Double.valueOf(getXpp().getAttributeValue(i)));
                                        } else if (getXpp().getAttributeName(i).equals("y")) {
                                            status.setTilt(Double.valueOf(getXpp().getAttributeValue(i)));
                                        }
                                    }
                                    break;
                                case KEY_POSITION_ZOOM:
                                    for (int i = 0; i < getXpp().getAttributeCount(); i++) {
                                        if (getXpp().getAttributeName(i).equals("x")) {
                                            status.setZoom(Double.valueOf(getXpp().getAttributeValue(i)));
                                        }
                                    }
                                    break;
                            }
                        }
                        if (eventType == XmlPullParser.END_TAG && getXpp().getName().equals(KEY_POSITION)) {
                            // stop at Position tag
                            return status;
                        }
                    }

                }

                eventType = getXpp().next();

            }
        } catch (XmlPullParserException | IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
