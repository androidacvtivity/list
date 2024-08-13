package com.bancusoft.list.Helpers;

import android.widget.TextView;

public class ViewUtils {
    public static void setTextSafely(TextView textView, String text) {
        if (textView != null && text != null) {
            textView.setText(text.trim());
        }
    }

    public static String getTextSafely(TextView textView) {
        return textView != null ? textView.getText().toString() : "";
    }
}