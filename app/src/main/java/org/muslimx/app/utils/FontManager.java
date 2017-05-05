package org.muslimx.app.utils;

import android.content.res.Resources;
import android.graphics.Typeface;

import java.util.Locale;

import uk.co.chrisjenx.calligraphy.TypefaceUtils;

/**
 * Created by Mohamed Sadialiou Barry on 4/11/17.
 * you can contact me at : mosadialiou@gmail.com
 */

public final class FontManager {

    public static final String SOURCESANSPRO_BOLD = "SourceSansPro-Bold";
    public static final String SOURCESANSPRO_REGULAR = "SourceSansPro-Regular";
    public static final String SOURCESANSPRO_LIGHT = "SourceSansPro-Light";

    public static Typeface loadFont(Resources res, String fontName) {
        return TypefaceUtils.load(res.getAssets(), String.format(Locale.FRENCH, "fonts/%s.otf", fontName));
    }

    private FontManager() {
    }
}
