package com.example.movieapp.utils;

import android.content.Context;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.movieapp.R;

public class UIUtils {
    public static void setRatingDots(float rating, LinearLayout dotsLayout, Context context) {
        TextView[] dots = new TextView[5];
        dotsLayout.removeAllViews();

        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(context);
            dots[i].setText("•");
            dots[i].setTextSize(30);
            dotsLayout.addView(dots[i]);
        }

        int fullDots = (int) rating;
        int halfDot = Math.round((rating - fullDots) * 10);

        for (int i = 0; i < fullDots; i++) {
            if (i < dots.length) {
                if (i == dots.length - 1 && halfDot > 0) {
                    dots[i].setTextColor(context.getResources().getColor(R.color.dots_half));
                } else {
                    dots[i].setTextColor(context.getResources().getColor(R.color.primary));
                }
            }
        }
    }
}