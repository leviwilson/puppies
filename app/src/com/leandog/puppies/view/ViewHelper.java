package com.leandog.puppies.view;

import android.app.Activity;
import android.text.Spanned;
import android.view.View;
import android.widget.TextView;

public class ViewHelper {

    @SuppressWarnings("unchecked")
    public static <ViewType extends View> ViewType findFor(final Activity activity, int id) {
        return (ViewType) activity.findViewById(id);
    }

    @SuppressWarnings("unchecked")
    public static <ViewType extends View> ViewType findFor(final View view, int id) {
        return (ViewType) view.findViewById(id);
    }

    public static void setText(final View view, final int id, final String text) {
        final TextView textView = findFor(view, id);
        textView.setText(text);
    }

    public static void setText(final Activity activity, final int id, final String text) {
        final TextView textView = findFor(activity, id);
        textView.setText(text);
    }

    public static void setText(final Activity activity, final int id, final Spanned spanned) {
        final TextView textView = findFor(activity, id);
        textView.setText(spanned);
    }

    public static void setText(final View view, final int id, final Spanned spanned) {
        final TextView textView = findFor(view, id);
        textView.setText(spanned);
    }

}
