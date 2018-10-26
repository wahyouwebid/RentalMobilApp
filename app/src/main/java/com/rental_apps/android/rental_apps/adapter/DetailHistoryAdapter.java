package com.rental_apps.android.rental_apps.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.rental_apps.android.rental_apps.R;
import com.rental_apps.android.rental_apps.SPreferenced.SPref;
import com.rental_apps.android.rental_apps.api.client;
import com.rental_apps.android.rental_apps.helper.DateDifference;
import com.rental_apps.android.rental_apps.model.model_detail_history.DataDetailHistory;
import com.rental_apps.android.rental_apps.model.model_detail_transaksi.DataDetailTransaksi;
import com.rental_apps.android.rental_apps.model.model_detail_transaksi.ResponseCancelTransaksi;
import com.rental_apps.android.rental_apps.model.model_detail_transaksi.ResponseDetailTransaksi;
import com.rental_apps.android.rental_apps.user.ActivityDetailListHistory;
import com.rental_apps.android.rental_apps.user.ActivityListTransaksi;

import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;
import customfonts.MyTextView;
import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by USER on 28/01/2018.
 */

public class DetailHistoryAdapter extends RecyclerView.Adapter<DetailHistoryAdapter.MyViewHolder>{
    private List<DataDetailTransaksi> cartList;
    Context mContext;
    private int lastPosition=-1;
    private View mView;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        private MyTextView nama_mobil,merk_mobil,tanggal,plat;
        private TextView total,cancel;
        private View view;

        public MyViewHolder(View view) {
            super(view);
            mView=view;
            nama_mobil=(MyTextView)view.findViewById(R.id.nama_mobil);
            merk_mobil=(MyTextView)view.findViewById(R.id.merk_mobil);
            tanggal=(MyTextView)view.findViewById(R.id.tanggal);
            plat=(MyTextView)view.findViewById(R.id.plat);
            total=(TextView)view.findViewById(R.id.total);
            cancel=(TextView)view.findViewById(R.id.cancel);

            this.view=view;
        }


        public void bindItem(final DataDetailTransaksi cart) {
            long jumlah_hari= DateDifference.betweenDates(cart.getTGLSEWA(),cart.getTGLAKHIRPENYEWAAN())+1;
            nama_mobil.setText(cart.getNAMAMOBIL());
            merk_mobil.setText(cart.getMERKMOBIL());
            tanggal.setText(cart.getTGLSEWA()+" s/d "+cart.getTGLAKHIRPENYEWAAN()+" ("+ jumlah_hari +" Hari)");
            total.setText("Rp. "+String.format("%,.2f", Double.parseDouble(cart.getTOTAL())));
            plat.setText(cart.getPLATNOMOBIL());
            cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    cancelTransaksi(Integer.parseInt(cart.getIDDETAILTRANSAKSI()));
                }
            });
        }
    }

    public void cancelTransaksi(Integer id){
        final Call<ResponseCancelTransaksi> users= client.getApi().cancelTransaksi(id);
        users.enqueue(new Callback<ResponseCancelTransaksi>() {
            @Override
            public void onResponse(Call<ResponseCancelTransaksi> call, Response<ResponseCancelTransaksi> response) {
                if (response.isSuccessful()) {
                    if (response.body().getStatus()) {
                        Toast.makeText(mContext, "Sukses Cancel", Toast.LENGTH_LONG).show();
                        ((ActivityDetailListHistory)mContext).getTransaksi();
                    } else {
                        Toast.makeText(mContext, "Gagal Cancel", Toast.LENGTH_LONG).show();

                    }
                }else {
                    Toast.makeText(mContext, "Gagal Cancel", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseCancelTransaksi> call, Throwable t) {
                Toast.makeText(mContext,t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }



    public DetailHistoryAdapter(Context mContext, List<DataDetailTransaksi> cartList) {
        this.mContext = mContext;
        this.cartList = cartList;
    }


    @Override
    public DetailHistoryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.design_detail_history,parent,false);
        return new DetailHistoryAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DetailHistoryAdapter.MyViewHolder holder, int position) {
        holder.bindItem(cartList.get(position));
        setAnimation(mView, position);
    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }

    private void setAnimation(View viewToAnimate,int position) {
        if (position > lastPosition) {
            lastPosition = position;
            Animation animation = AnimationUtils.loadAnimation(mView.getContext(), R.anim.slide_left_to_right);
            viewToAnimate.startAnimation(animation);
        }
    }
}



