package com.rental_apps.android.rental_apps.user;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rental_apps.android.rental_apps.R;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Thread thread = new Thread() {
            public void run() {
                try {
                    sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    startActivity(new Intent(SplashActivity.this, UserMain.class));
                    finish();
                }
            }
        };
        thread.start();
    }
}