package org.smartregister.bidan.lib;

import android.content.Context;
import android.util.Log;

import com.flurry.android.FlurryAgent;

import org.smartregister.AllConstants;
import org.smartregister.bidan.utils.BidanConstants;

import java.util.Map;

/**
 * Created by Dimas on 9/22/2015
 */
public class FlurryFacade {

    public static void logEvent(String event) {
        FlurryAgent.logEvent(event);
    }

    public static void logEvent(String event,
                                Map<String, String> map) {
        FlurryAgent.logEvent(event, map);
    }

    public static void setUserId(String userId) {
        FlurryAgent.setUserId(userId);
    }

    public static void init(Context context) {
        // Configure Flurry
        FlurryAgent.setLogEnabled(true);
        FlurryAgent.setLogEvents(true);
        FlurryAgent.setLogLevel(Log.VERBOSE);

        // init Flurry
//        FlurryAgent.init(context, AllConstants.FLURRY_KEY);
    }


}
