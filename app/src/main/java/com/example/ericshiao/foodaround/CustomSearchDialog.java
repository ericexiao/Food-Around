package com.example.ericshiao.foodaround;

import android.app.Activity;
import android.app.Dialog;

/**
 * Created by Eric on 4/3/2015.
 */
public class CustomSearchDialog extends Dialog {
    public Activity activity;
    public Dialog dialog;

    public CustomSearchDialog(Activity a) {
        super(a);
        this.activity = a;
    }
}
