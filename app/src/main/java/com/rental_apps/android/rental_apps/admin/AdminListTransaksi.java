package com.rental_apps.android.rental_apps.admin;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.view.ViewGroup.LayoutParams;
import android.widget.Toast;

import com.mikepenz.itemanimators.SlideLeftAlphaAnimator;
import com.rental_apps.android.rental_apps.R;
import com.rental_apps.android.rental_apps.adapter.TransaksiAdapter;
import com.rental_apps.android.rental_apps.adapter.UsersAdapter;
import com.rental_apps.android.rental_apps.api.client;
import com.rental_apps.android.rental_apps.model.model_transaksi.DataTransaksi;
import com.rental_apps.android.rental_apps.model.model_transaksi.ResponseTransaksi;
import com.rental_apps.android.rental_apps.model.model_user.DataUser;
import com.rental_apps.android.rental_apps.model.model_user.ResponseUser;
import com.rental_apps.android.rental_apps.myinterface.InitComponent;

import java.util.ArrayList;
import java.util.List;

import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ujang Wahyu on 04/01/2018.
 */

public class AdminListTransaksi extends Fragment implements InitComponent {
    //Declate Toolbar Tittle
    private static final String TEXT_FRAGMENT = "RENTCAR";

    //Declare Component View
    private TextView mTxtTitle;
    private View rootView;
    private RecyclerView recyclerTransaksi;
    //Declate Activity Context
    Context mContext;

    //Declare Object Transaksi
    ResponseTransaksi dataTransaksi;
    List<DataTransaksi> listTransaksi=new ArrayList<>();

    //Declare Adapter
    private TransaksiAdapter mAdapter;

    public static AdminListTransaksi newInstance(String text){
        AdminListTransaksi mFragment = new AdminListTransaksi();
        Bundle mBundle = new Bundle();
        mBundle.putString(TEXT_FRAGMENT, text);
        mFragment.setArguments(mBundle);
        return mFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        mContext=getActivity();
        // TODO Auto-generated method stub
        rootView = inflater.inflate(R.layout.fragment_admin_transaksi, container, false);
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
        setItem(menu);
    }

    private void setItem(Menu menu){
        MenuItem menuAdd = menu.findItem(R.id.add);
        menuAdd.setVisible(false);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.refresh:
                getTransaksi();
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
        rootView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT ));
        recyclerTransaksi= (RecyclerView)rootView.findViewById(R.id.rTransaksiList);
    }

    @Override
    public void initValue() {
        prepareTransaksi();
        getTransaksi();
    }

    @Override
    public void initEvent() {

    }

    public void getTransaksi(){
        final Call<ResponseTransaksi> transaksi= client.getApi().dataTransaksi();
        transaksi.enqueue(new Callback<ResponseTransaksi>() {
            @Override
            public void onResponse(Call<ResponseTransaksi> call, Response<ResponseTransaksi> response) {
                if (response.isSuccessful()) {
                    dataTransaksi=response.body();
                    if (dataTransaksi.getStatus()) {
                        listTransaksi.clear();
                        listTransaksi.addAll(dataTransaksi.getData());
                        mAdapter.notifyDataSetChanged();
                    } else {
                        Toasty.error(mContext, "Tidak Di Temukan Data", Toast.LENGTH_LONG).show();
                    }
                }else {
                    Toasty.error(mContext, "Tidak Di Temukan Data", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseTransaksi> call, Throwable t) {
                Toasty.error(mContext, "Tidak Di Temukan Data", Toast.LENGTH_LONG).show();
//                Toasty.error(mContext,t.getMessage(),Toast.LENGTH_LONG).show();
            }

        });
    }

    private void prepareTransaksi(){
        mAdapter = new TransaksiAdapter(listTransaksi);
        recyclerTransaksi.setHasFixedSize(true);
        recyclerTransaksi.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerTransaksi.setItemAnimator(new DefaultItemAnimator());
        recyclerTransaksi.setAdapter(mAdapter);
        recyclerTransaksi.setItemAnimator(new SlideLeftAlphaAnimator());

    }

}
