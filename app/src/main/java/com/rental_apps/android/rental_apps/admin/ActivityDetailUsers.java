package com.rental_apps.android.rental_apps.admin;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.gson.Gson;
import com.rental_apps.android.rental_apps.R;
import com.rental_apps.android.rental_apps.api.client;
import com.rental_apps.android.rental_apps.model.model_mobil.DataCars;
import com.rental_apps.android.rental_apps.model.model_user.DataUser;
import com.rental_apps.android.rental_apps.myinterface.InitComponent;
import com.squareup.picasso.Picasso;

import customfonts.MyTextView;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Ujang Wahyu on 04/01/2018.
 */

public class ActivityDetailUsers extends AppCompatActivity implements InitComponent {
    private MyTextView name;
    private MyTextView email;
    private MyTextView noTelp;
    private MyTextView address;
    private MyTextView jenis_kelamin;
    private MyTextView status;
    private CircleImageView userPhoto;
    Context mContext;
    Toolbar toolbar;
    DataUser user;
    @Override
    protected void onCreate(Bundle SavedInstance){
        super.onCreate(SavedInstance);
        setContentView(R.layout.activity_detail_user);

        Gson gson = new Gson();
        user= gson.fromJson(getIntent().getStringExtra("user"), DataUser.class);

        mContext=this;
        startInit();
    }

    @Override
    public void startInit() {
        initToolbar();
        initUI();
        initValue();
        initEvent();
    }

    @Override
    public void initToolbar() {
        toolbar=(Toolbar)findViewById(R.id.maintoolbar);
        setSupportActionBar(toolbar);
        final Drawable upArrow = getResources().getDrawable(R.drawable.ic_action_back);
        upArrow.setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
        getSupportActionBar().setHomeAsUpIndicator(upArrow);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("");
    }

    @Override
    public void initUI() {
        name=(MyTextView)findViewById(R.id.name);
        email=(MyTextView)findViewById(R.id.email);
        noTelp=(MyTextView)findViewById(R.id.notelp);
        address=(MyTextView)findViewById(R.id.address);
        jenis_kelamin=(MyTextView)findViewById(R.id.jenis_kelamin);
        status=(MyTextView)findViewById(R.id.status);
        userPhoto=(CircleImageView)findViewById(R.id.userPhoto);

    }

    @Override
    public void initValue() {
        name.setText(user.getName());
        email.setText(user.getEmail());
        noTelp.setText(user.getNo_telp());
        address.setText(user.getAlamat());

        if (user.getJenis_kelamin()=='L'){
            jenis_kelamin.setText("Laki-laki");
        }else{
            jenis_kelamin.setText("Perempuan");
        }

        if (user.getActivated()==1)
            status.setText("Aktif");
        else
            status.setText("Tidak Aktif");

        if(!user.getPhoto().isEmpty())
            Picasso.with(mContext).load(client.getBaseUrlImage()+user.getPhoto()).into(userPhoto);


    }

    @Override
    public void initEvent() {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
