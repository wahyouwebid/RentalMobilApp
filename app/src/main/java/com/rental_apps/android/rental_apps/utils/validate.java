package com.rental_apps.android.rental_apps.utils;

import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.rental_apps.android.rental_apps.helper.DatePickerView;

/**
 * Created by Ujang Wahyu on 04/01/2018.
 */
public class validate {

    public static boolean cek(EditText et) {
            View focusView = null;
            Boolean cancel=false;
            if (TextUtils.isEmpty(et.getText().toString().trim())) {
                et.setError("Inputan Harus Di Isi");
                focusView = et;
                cancel = true;
            }
            if (cancel) {
                focusView.requestFocus();
            }
            return cancel;
    }

    public static boolean cek(DatePickerView et) {
        View focusView = null;
        Boolean cancel=false;
        if (TextUtils.isEmpty(et.getText().toString().trim())) {
            et.setError("Inputan Harus Di Isi");
            focusView = et;
            cancel = true;
        }
        if (cancel) {
            focusView.requestFocus();
        }
        return cancel;
    }

    public static boolean cekPassword(EditText et,String Password,String ConfirmPassword){
        View focusView = null;
        Boolean cancel=false;
        if (!Password.equals(ConfirmPassword)) {
            et.setError("Password tidak sama");
            focusView = et;
            cancel = true;
        }
        if (cancel) {
            focusView.requestFocus();
        }
        return cancel;
    }
}
