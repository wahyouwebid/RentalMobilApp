package com.rental_apps.android.rental_apps.adapter;

/**
 * Created by Ujang Wahyu on 04/01/2018.
 */

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
import com.rental_apps.android.rental_apps.helper.DateDifference;
import com.rental_apps.android.rental_apps.model.model_carts.DataCarts;
import com.rental_apps.android.rental_apps.model.model_detail_transaksi.DataDetailTransaksi;
import com.rental_apps.android.rental_apps.user.ActivityListTransaksi;

import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;
import customfonts.MyTextView;
import es.dmoral.toasty.Toasty;

public class DetailTransaksiAdapter extends RecyclerView.Adapter<DetailTransaksiAdapter.MyViewHolder>{
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
                    AlertDialog.Builder builder = new AlertDialog.Builder(mContext);

                    builder.setTitle("Confirm");
                    builder.setMessage("Are you sure?");

                    builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                        public void onClick(DialogInterface dialog, int which) {
                            Carts.cancel(SPref.getCARTS(),getAdapterPosition());
                                    cartList.remove(getAdapterPosition());
                                    notifyItemRemoved(getAdapterPosition());
                                    ((ActivityListTransaksi)mContext).setCheckout();
                            // Do nothing, but close the dialog
                            dialog.dismiss();
                            Toasty.success(mContext,"berhasil dihapus", Toast.LENGTH_LONG).show();
                        }
                    });


                   // AlertDialog alert = builder.create();
                    builder.show();


//                    new SweetAlertDialog(mContext, SweetAlertDialog.WARNING_TYPE)
//                            .setTitleText("Are you sure?")
//                            .setContentText("Won't be able to recover this file!")
//                            .setConfirmText("Yes,delete it!")
//                            .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
//                                @Override
//                                public void onClick(SweetAlertDialog sDialog) {
//                                    Carts.cancel(SPref.getCARTS(),getAdapterPosition());
//                                    cartList.remove(getAdapterPosition());
//                                    notifyItemRemoved(getAdapterPosition());
//                                    ((ActivityListTransaksi)mContext).setCheckout();
//
//                                    sDialog
//                                            .setTitleText("Deleted!")
//                                            .setContentText("Your data has been deleted!")
//                                            .setConfirmText("OK")
//                                            .setConfirmClickListener(null)
//                                            .changeAlertType(SweetAlertDialog.SUCCESS_TYPE);
//                                }
//                            })
//                            .show();

                }
            });
        }



    }


    public DetailTransaksiAdapter(Context mContext, List<DataDetailTransaksi> cartList) {
        this.mContext = mContext;
        this.cartList = cartList;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.design_cart,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(DetailTransaksiAdapter.MyViewHolder holder, int position) {
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



