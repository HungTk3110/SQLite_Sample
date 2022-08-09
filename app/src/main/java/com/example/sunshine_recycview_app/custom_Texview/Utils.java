package com.example.sunshine_recycview_app.custom_Texview;

import android.content.Context;
import android.graphics.Typeface;

public class Utils {

    private static Typeface typeface;

    public static Typeface getTypeface(Context context) {
        if(typeface == null)
            typeface = Typeface.createFromAsset(context.getAssets(), "fonts/ZaiRoyalPTypewriter1933-z8o6a.ttf");
        return typeface;
    }
}
