package com.rental_apps.android.rental_apps.adapter;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.rental_apps.android.rental_apps.R;
import com.rental_apps.android.rental_apps.admin.ActivityDetailCars;
import com.rental_apps.android.rental_apps.api.client;
import com.rental_apps.android.rental_apps.helper.DrawableColor;
import com.rental_apps.android.rental_apps.model.model_mobil.DataCars;
import com.rental_apps.android.rental_apps.utils.move;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.List;

import es.dmoral.toasty.Toasty;

/**
 * Created by Asus on 04/01/2018.
 */

public class CarsAdapter extends RecyclerView.Adapter<CarsAdapter.MyViewHolder>{
    private List<DataCars> carsList;
    private int lastPosition=-1;
    private View mView;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView carName;
        private TextView year;
        private TextView capacity;
        private TextView color;
        private TextView bensin;
        private TextView price;
        private TextView status;
        private ImageView ic_year;
        private ImageView ic_color;
        private ImageView ic_capacity;
        private ImageView ic_bensin;
        private ImageView imgCar;
        private View view;

        public MyViewHolder(View view) {
            super(view);
            mView=view;
            carName = (TextView) view.findViewById(R.id.carName);
            year = (TextView) view.findViewById(R.id.year);
            capacity = (TextView) view.findViewById(R.id.capacity);
            color=(TextView)view.findViewById(R.id.color);
            bensin=(TextView)view.findViewById(R.id.bensin);
            price=(TextView)view.findViewById(R.id.price);
            status=(TextView)view.findViewById(R.id.status);
            ic_year=(ImageView)view.findViewById(R.id.ic_year);
            ic_color=(ImageView)view.findViewById(R.id.ic_color);
            ic_capacity=(ImageView)view.findViewById(R.id.ic_capacity);
            ic_bensin=(ImageView)view.findViewById(R.id.ic_bensin);
            imgCar=(ImageView)view.findViewById(R.id.imgCar);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Gson gson = new Gson();
                    String car = gson.toJson(carsList.get(getAdapterPosition()));
                    Intent i=new Intent(view.getContext(),ActivityDetailCars.class);
                    i.putExtra("car", car);
                    view.getContext().startActivity(i);
                }
            });
            this.view=view;
        }

        public void bindItem(DataCars cars) {
            carName.setText(cars.getNAMAMOBIL().toString());
            year.setText(cars.getTAHUNMOBIL().toString());
            capacity.setText(cars.getKAPASITASMOBIL().toString());
            color.setText(cars.getWARNAMOBIL().toString());
            bensin.setText(cars.getBENSINMOBIL().toString());
            price.setText("Rp. "+String.format("%,.2f", Double.parseDouble(cars.getHARGAMOBIL().toString())));

            if (Integer.parseInt(cars.getSTATUSSEWA().toString())==1){
                status.setText("Disewa");
            }
            else {
                status.setText("Tersedia");
            }

            if (cars.getIMAGE().size()>0)
                Picasso.with(view.getContext()).load(client.getBaseImg()+"mobil/"+cars.getIMAGE().get(0)).into(imgCar);



            Drawable yearIcon= ContextCompat.getDrawable(view.getContext(), R.drawable.ic_action_go_to_today);
            Drawable capacityIcon= ContextCompat.getDrawable(view.getContext(), R.drawable.ic_action_cc_bcc);
            Drawable colorIcon= ContextCompat.getDrawable(view.getContext(), R.drawable.ic_action_picture);
            Drawable fuelIcon= ContextCompat.getDrawable(view.getContext(), R.drawable.ic_action_fuel);

            ic_year.setImageDrawable(DrawableColor.setColor(yearIcon,R.color.nliveo_orange_colorPrimaryDark));
            ic_capacity.setImageDrawable(DrawableColor.setColor(capacityIcon,R.color.nliveo_orange_colorPrimaryDark));
            ic_color.setImageDrawable(DrawableColor.setColor(colorIcon,R.color.nliveo_orange_colorPrimaryDark));
            ic_bensin.setImageDrawable(DrawableColor.setColor(fuelIcon,R.color.nliveo_orange_colorPrimaryDark));
        }



    }


    public CarsAdapter(List<DataCars> carsList) {
        this.carsList = carsList;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.design_cars,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CarsAdapter.MyViewHolder holder, int position) {
        holder.bindItem(carsList.get(position));
        setAnimation(mView, position);
    }

    @Override
    public int getItemCount() {
        return carsList.size();
    }

    private void setAnimation(View viewToAnimate,int position) {
        if (position > lastPosition) {
            lastPosition = position;
            Animation animation = AnimationUtils.loadAnimation(mView.getContext(), R.anim.slide_left_to_right);
            viewToAnimate.startAnimation(animation);
        }
    }
}
