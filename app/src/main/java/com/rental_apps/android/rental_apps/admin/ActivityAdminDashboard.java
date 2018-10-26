package com.rental_apps.android.rental_apps.admin;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.rental_apps.android.rental_apps.R;
import com.rental_apps.android.rental_apps.api.client;
import com.rental_apps.android.rental_apps.model.model_dashboard.ResponseInfoDashboard;
import com.rental_apps.android.rental_apps.myinterface.InitComponent;

import customfonts.MyTextView;
import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ujang Wahyu on 04/01/2018.
 */

public class ActivityAdminDashboard extends Fragment implements InitComponent {
    //Declate Toolbar Tittle
    private static final String TEXT_FRAGMENT = "RENTCAR";
    private MyTextView jumlah_admin;
    private MyTextView jumlah_pesanan;
    private MyTextView jumlah_user;
    private MyTextView jumlah_mobil;
    private MyTextView jumlah_total;
    //Declare Component View
    private View rootView;
    //Declate Activity Context
    Context mContext;

    public static ActivityAdminDashboard newInstance(String text){
        ActivityAdminDashboard mFragment = new ActivityAdminDashboard();
        Bundle mBundle = new Bundle();
        mBundle.putString(TEXT_FRAGMENT, text);
        mFragment.setArguments(mBundle);
        return mFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mContext=getActivity();
        // TODO Auto-generated method stub
        rootView = inflater.inflate(R.layout.activity_admin_dashboard, container, false);
        startInit();
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // TODO Auto-generated method stub
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_icon, menu);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.refresh:
                getDashboard();
                return true;
            case R.id.add:
                Toasty.success(mContext, "Tambah", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
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
        getActivity().setTitle(getArguments().getString(TEXT_FRAGMENT));
    }

    @Override
    public void initUI() {
        rootView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT ));
        jumlah_admin=(MyTextView)rootView.findViewById(R.id.jumlah_admin);
        jumlah_pesanan=(MyTextView)rootView.findViewById(R.id.jumlah_pesanan);
        jumlah_user=(MyTextView)rootView.findViewById(R.id.jumlah_user);
        jumlah_mobil=(MyTextView)rootView.findViewById(R.id.jumlah_mobil);
        jumlah_total=(MyTextView)rootView.findViewById(R.id.jumlah_penghasilan);
    }

    @Override
    public void initValue() {
        setDashboard("0","0","0","0","0");
        getDashboard();
    }

    @Override
    public void initEvent() {

    }

    public void getDashboard(){
        Call<ResponseInfoDashboard> info;
        info = client.getApi().dataInfoDashboard();
        info.enqueue(new Callback<ResponseInfoDashboard>() {
            @Override
            public void onResponse(Call<ResponseInfoDashboard> call, Response<ResponseInfoDashboard> response) {
                if (response.isSuccessful()){
                    if (response.body().getStatus()){
                        setDashboard(response.body().getData().gettOTAL(),response.body().getData().getADMIN(),response.body().getData().getUSER(),response.body().getData().getTRANSAKSI(),response.body().getData().getMOBIL());
//                        mHelpLiveo.get(1).setCounter(Integer.parseInt(response.body().getData().getTRANSAKSI()));
//                        mHelpLiveo.get(2).setCounter(Integer.parseInt(response.body().getData().getMOBIL()));
//                        mHelpLiveo.get(3).setCounter(Integer.parseInt(response.body().getData().getUSER()));
//                        mHelpLiveo.get(4).setCounter(Integer.parseInt(response.body().getData().getADMIN()));
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseInfoDashboard> call, Throwable t) {

            }
        });

    }

    private void setDashboard(String total,String admin,String user,String pesanan,String mobil){
        jumlah_admin.setText(admin);
        jumlah_user.setText(user);
        jumlah_pesanan.setText(pesanan);
        jumlah_mobil.setText(mobil);
        if(total!=null){
            jumlah_total.setText("Rp. "+String.format("%,.2f", Double.parseDouble(total)));
        }
    }

}
