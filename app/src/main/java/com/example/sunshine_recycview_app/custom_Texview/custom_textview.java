package com.example.sunshine_recycview_app.custom_Texview;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

public class custom_textview extends AppCompatTextView {
    public custom_textview(@NonNull Context context) {
        super(context);
        setFontsTextView();
    }

    public custom_textview(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setFontsTextView();
    }

    public custom_textview(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFontsTextView();
    }

    private void setFontsTextView(){
        Typeface typeface = Utils.getTypeface(getContext());
        setTypeface(typeface);
    }
}
