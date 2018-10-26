package com.rental_apps.android.rental_apps.admin;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.rental_apps.android.rental_apps.R;
import com.rental_apps.android.rental_apps.api.client;
import com.rental_apps.android.rental_apps.helper.DrawableColor;
import com.rental_apps.android.rental_apps.model.model_mobil.DataCars;
import com.rental_apps.android.rental_apps.myinterface.InitComponent;
import com.rental_apps.android.rental_apps.user.ActivityDetailUserCars;
import com.rental_apps.android.rental_apps.utils.move;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import customfonts.MyTextView;

/**
 * Created by Ujang Wahyu on 04/01/2018.
 */

public class ActivityDetailCars extends AppCompatActivity implements InitComponent , View.OnClickListener {
    private Context mContext;
    private DataCars car;
    private Toolbar toolbar;
    private TextView merk;
    private TextView year;
    private TextView capacity;
    private TextView plat;
    private TextView warna_mobil;
    private TextView bensin_mobil;
    private TextView price;

    private MyTextView description;
    private MyTextView nama_mobil;

    private ImageView ic_merk;
    private ImageView ic_year;
    private ImageView ic_capacity;
    private ImageView ic_plat;
    private ImageView ic_warna_mobil;
    private ImageView ic_bensin_mobil;
    private FloatingActionButton action_mobil;
    private ImageView mainbackdrop;

    @Override
    protected void onCreate(Bundle SavedInstance) {
        super.onCreate(SavedInstance);
        setContentView(R.layout.activity_detail_cars);
        mContext=this;
        Gson gson = new Gson();
        car= gson.fromJson(getIntent().getStringExtra("car"), DataCars.class);

        startInit();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.action_mobil:
                Gson gson = new Gson();
                String datacar = gson.toJson(car);
                Intent i=new Intent(view.getContext(),ActivityEditMobil.class);
                i.putExtra("car", datacar);
                view.getContext().startActivity(i);
                break;
        }
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
        toolbar = (Toolbar) findViewById(R.id.maintoolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle(car.getNAMAMOBIL());
    }

    @Override
    public void initUI() {
        merk        =(TextView)findViewById(R.id.merk);
        year        =(TextView)findViewById(R.id.year);
        plat        =(TextView)findViewById(R.id.plat);
        price       =(TextView)findViewById(R.id.price);
        capacity    =(TextView)findViewById(R.id.capacity);
        warna_mobil =(TextView)findViewById(R.id.warna);
        bensin_mobil=(TextView)findViewById(R.id.bensin);
        description =(MyTextView) findViewById(R.id.description);
        nama_mobil=(MyTextView) findViewById(R.id.nama_mobil);
        ic_merk        =(ImageView) findViewById(R.id.ic_merk);
        ic_year        =(ImageView)findViewById(R.id.ic_year);
        ic_plat        =(ImageView)findViewById(R.id.ic_plat);
        ic_capacity    =(ImageView)findViewById(R.id.ic_capacity);
        ic_warna_mobil =(ImageView)findViewById(R.id.ic_warna);
        ic_bensin_mobil=(ImageView)findViewById(R.id.ic_bensin);
        mainbackdrop   =(ImageView)findViewById(R.id.mainbackdrop);
        action_mobil=(FloatingActionButton)findViewById(R.id.action_mobil);


        Drawable yearIcon= ContextCompat.getDrawable(mContext, R.drawable.ic_action_go_to_today);
        Drawable capacityIcon= ContextCompat.getDrawable(mContext, R.drawable.ic_action_cc_bcc);
        Drawable colorIcon= ContextCompat.getDrawable(mContext, R.drawable.ic_action_picture);
        Drawable fuelIcon= ContextCompat.getDrawable(mContext, R.drawable.ic_action_fuel);
        Drawable merkIcon= ContextCompat.getDrawable(mContext, R.drawable.ic_action_storage);
        Drawable platIcon= ContextCompat.getDrawable(mContext, R.drawable.ic_action_screen_locked_to_landscape);

        ic_year.setImageDrawable(DrawableColor.setColor(yearIcon,R.color.nliveo_orange_colorPrimaryDark));
        ic_capacity.setImageDrawable(DrawableColor.setColor(capacityIcon,R.color.nliveo_orange_colorPrimaryDark));
        ic_warna_mobil.setImageDrawable(DrawableColor.setColor(colorIcon,R.color.nliveo_orange_colorPrimaryDark));
        ic_bensin_mobil.setImageDrawable(DrawableColor.setColor(fuelIcon,R.color.nliveo_orange_colorPrimaryDark));
        ic_merk.setImageDrawable(DrawableColor.setColor(merkIcon,R.color.nliveo_orange_colorPrimaryDark));
        ic_plat.setImageDrawable(DrawableColor.setColor(platIcon,R.color.nliveo_orange_colorPrimaryDark));
    }

    @Override
    public void initValue() {
        description.setText(car.getDESKRIPSIMOBIL());
        merk.setText(car.getMERKMOBIL());
        year.setText(car.getTAHUNMOBIL());
        capacity.setText(car.getKAPASITASMOBIL());
        plat.setText(car.getPLATNOMOBIL());
        warna_mobil.setText(car.getWARNAMOBIL());
        bensin_mobil.setText(car.getBENSINMOBIL());
        price.setText("Rp. "+String.format("%,.2f", Double.parseDouble(car.getHARGAMOBIL().toString())));
        nama_mobil.setText(car.getNAMAMOBIL());
        if (car.getIMAGE().size()>0)
            Picasso.with(mContext).load(client.getBaseImg()+"mobil/"+car.getIMAGE().get(0)).into(mainbackdrop);

    }


    @Override
    public void initEvent() {
        action_mobil.setOnClickListener(this);

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
