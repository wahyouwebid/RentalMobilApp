package com.rental_apps.android.rental_apps.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.widget.Toast;

/**
 * Created by Ujang Wahyu on 04/01/2018.
 */
public class move extends Intent {

    public static void moveActivity(Context mContext,Class<?> activity){
        Intent i=new Intent(mContext,activity);
        mContext.startActivity(i);
    }


}
