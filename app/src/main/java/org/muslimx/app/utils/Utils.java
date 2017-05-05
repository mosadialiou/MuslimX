package org.muslimx.app.utils;

import android.content.res.Resources;

/**
 * Created by Mohamed Sadialiou Barry on 4/14/17.
 * you can contact me at : mosadialiou@gmail.com
 */

public class Utils {

    public static int dpToPx(Resources res, int dps) {
        return Math.round(res.getDisplayMetrics().density * dps);
    }

    public static float dpToPx(Resources res, float dps) {
        return res.getDisplayMetrics().density * dps;
    }
}
