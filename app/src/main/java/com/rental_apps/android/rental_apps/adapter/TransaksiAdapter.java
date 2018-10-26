package com.rental_apps.android.rental_apps.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.rental_apps.android.rental_apps.R;
import com.rental_apps.android.rental_apps.admin.ActivityDetailListTransaksi;
import com.rental_apps.android.rental_apps.admin.ActivityDetailUsers;
import com.rental_apps.android.rental_apps.api.client;
import com.rental_apps.android.rental_apps.model.model_transaksi.DataTransaksi;
import com.squareup.picasso.Picasso;

import java.util.List;

import customfonts.MyTextView;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Ujang Wahyu on 04/01/2018.
 */

public class TransaksiAdapter extends RecyclerView.Adapter<TransaksiAdapter.MyViewHolder>{
    private List<DataTransaksi> transaksiList;
    private Context mContext;
    private int lastPosition=0;
    private View mView;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        private View view;
        private TextView kode_transaksi;
        private TextView tanggal_pesanan;
        private TextView nama_pemesan;
        private TextView total_transaksi;
        private LinearLayout bg_transaksi;
        public MyViewHolder(View view) {
            super(view);
            mView=view;
            kode_transaksi=(TextView) view.findViewById(R.id.kode_transaksi);
            tanggal_pesanan=(TextView) view.findViewById(R.id.tanggal_pesanan);
            nama_pemesan=(TextView) view.findViewById(R.id.nama_pemesan);
            total_transaksi=(TextView)view.findViewById(R.id.total_transaksi);
            bg_transaksi=(LinearLayout) view.findViewById(R.id.bg_transaksi);
            this.view=view;
            mContext=view.getContext();
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Gson gson=new Gson();
                    String transaksi=gson.toJson(transaksiList.get(getAdapterPosition()));
                    Intent i=new Intent(mContext, ActivityDetailListTransaksi.class);
                    i.putExtra("transaksi",transaksi);
                    mContext.startActivity(i);
                }
            });
        }

        public void bindItem(DataTransaksi transaksi) {
            kode_transaksi.setText(transaksi.getKODETRANSAKSI());
            tanggal_pesanan.setText(transaksi.getTGLORDER());
            nama_pemesan.setText(transaksi.getNAME());
            total_transaksi.setText("Rp. "+String.format("%,.2f", Double.parseDouble(transaksi.getTOTALPEMBAYARAN().toString())));

            if (transaksi.getSTATUSPEMBAYARAN().equals("0")){
                bg_transaksi.setBackgroundColor(Color.parseColor("#da4749"));
            }
        }
    }


    public TransaksiAdapter(List<DataTransaksi> transaksiList) {
        this.transaksiList= transaksiList;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.design_transaksi,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.bindItem(transaksiList.get(position));
        setAnimation(mView, position);
    }

    @Override
    public int getItemCount() {
        return transaksiList.size();
    }

    private void setAnimation(View viewToAnimate,int position) {
        if (position > lastPosition) {
            lastPosition = position;
            Animation animation = AnimationUtils.loadAnimation(mView.getContext(), R.anim.slide_left_to_right);
            viewToAnimate.startAnimation(animation);
        }
    }
}
