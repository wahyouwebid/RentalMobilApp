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
import com.rental_apps.android.rental_apps.adapter.UsersAdapter;
import com.rental_apps.android.rental_apps.api.client;
import com.rental_apps.android.rental_apps.model.model_user.DataUser;
import com.rental_apps.android.rental_apps.model.model_user.ResponseUser;
import com.rental_apps.android.rental_apps.myinterface.InitComponent;
import com.rental_apps.android.rental_apps.utils.move;

import java.util.ArrayList;
import java.util.List;

import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ujang Wahyu on 04/01/2018.
 */

public class AdminListUser extends Fragment implements InitComponent {
    //Declate Toolbar Tittle
    private static final String TEXT_FRAGMENT = "RENTCAR";
    private static final String GroupUser="GroupUser";
    //Declare Component View
    private TextView mTxtTitle;
    private View rootView;
    private RecyclerView recyclerUsers;

    //Declate Activity Context
    Context mContext;

    //Declare Object Users
    ResponseUser dataUsers;
    List<DataUser> listUsers=new ArrayList<>();

    //Declare Adapter
    private UsersAdapter mAdapter;

    public AdminListUser newInstance(String text,String gUser){
        AdminListUser mFragment = new AdminListUser();
        Bundle mBundle = new Bundle();
        mBundle.putString(TEXT_FRAGMENT, text);
        mBundle.putString(GroupUser, gUser);
        mFragment.setArguments(mBundle);
        return mFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        mContext=getActivity();
        // TODO Auto-generated method stub
        rootView = inflater.inflate(R.layout.fragment_admin_user, container, false);
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
        if (Integer.parseInt(getArguments().getString(GroupUser))==2){
            MenuItem menuAdd=menu.findItem(R.id.add);
            menuAdd.setVisible(false);
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.refresh:
                getUsers();
                return true;
            case R.id.add:
                move.moveActivity(mContext,ActivityCreateAdmin.class);
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
        recyclerUsers= (RecyclerView)rootView.findViewById(R.id.rUserList);
    }

    @Override
    public void initValue() {
        prepareUsers();
        getUsers();
    }

    @Override
    public void initEvent() {

    }

    public void getUsers(){
        final Call<ResponseUser> users= client.getApi().dataUser(Integer.parseInt(getArguments().getString(GroupUser)),0);
        users.enqueue(new Callback<ResponseUser>() {
            @Override
            public void onResponse(Call<ResponseUser> call, Response<ResponseUser> response) {
                dataUsers=response.body();
                if (response.isSuccessful()) {
                    if (dataUsers.getStatus()) {
                        listUsers.clear();
                        listUsers.addAll(dataUsers.getData());
                        mAdapter.notifyDataSetChanged();
                    } else {
                        Toasty.error(mContext, "Tidak Ada Data Ditemukan", Toast.LENGTH_LONG).show();
                    }
                }else {
                    Toasty.error(mContext, "Tidak Ada Data Ditemukan", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseUser> call, Throwable t) {
                Toasty.error(mContext,t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }

    private void prepareUsers(){
        mAdapter = new UsersAdapter(listUsers);
        recyclerUsers.setHasFixedSize(true);
        recyclerUsers.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerUsers.setItemAnimator(new DefaultItemAnimator());
        recyclerUsers.setAdapter(mAdapter);
        recyclerUsers.setItemAnimator(new SlideLeftAlphaAnimator());

    }

}
