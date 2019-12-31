package com.apps.pickup_lines;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.annotation.Nullable;

public class CustomTextView extends androidx.appcompat.widget.AppCompatTextView {

    static Typeface typeface = Typeface.createFromAsset(ApplicationClass.getContext().getAssets(), "Lato-Bold.ttf");

    public CustomTextView(Context context) {
        super(context);
        this.setTypeface(typeface);
    }

    public CustomTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        this.setTypeface(typeface);
    }

    public CustomTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        this.setTypeface(typeface);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
