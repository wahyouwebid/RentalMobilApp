package com.rental_apps.android.rental_apps.adapter;

import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pixplicity.easyprefs.library.Prefs;
import com.rental_apps.android.rental_apps.SPreferenced.SPref;
import com.rental_apps.android.rental_apps.model.model_carts.DataCarts;

import java.lang.reflect.Type;
import java.util.ArrayList;

import es.dmoral.toasty.Toasty;

/**
 * Created by Ujang Wahyu on 04/01/2018.
 */

public class Carts {

    public static void order(DataCarts dataCarts,String key){
        Boolean ket=true;
        ArrayList<DataCarts> dCarts;
        if (!Prefs.contains(key)){
            dCarts=new ArrayList<>();
        }else{
           dCarts=getOrder(key);
        }
        for (int i=0;i<dCarts.size();i++){
            if (dCarts.get(i).getID_MOBIL().equals(dataCarts.getID_MOBIL())){
                dCarts.get(i).setHARGA_MOBIL(dataCarts.getHARGA_MOBIL());
                dCarts.get(i).setID_MOBIL(dataCarts.getID_MOBIL());
                dCarts.get(i).setTGL_AKHIR_PENYEWAAN(dataCarts.getTGL_AKHIR_PENYEWAAN());
                dCarts.get(i).setTGL_SEWA(dataCarts.getTGL_SEWA());
                dCarts.get(i).setTOTAL(dataCarts.getTOTAL());
                ket=false;
            }
        }
        if (ket)
            dCarts.add(dataCarts);

        saveOrder(dCarts,key);
    }


    public static void saveOrder(ArrayList<DataCarts> list, String key){
        Gson gson = new Gson();
        String listCart = gson.toJson(list);
        Prefs.putString(key,listCart);
    }

    public static ArrayList<DataCarts> getOrder(String key){
        Gson gson = new Gson();
        String json = Prefs.getString(key,null);
        Type type = new TypeToken<ArrayList<DataCarts>>() {}.getType();
        return gson.fromJson(json, type);
    }

    public static String getAllOrder(String key){
        Gson gson = new Gson();
        return gson.toJson(getOrder(key));
    }

    public static Integer getSize(String key){
        if (!Prefs.contains(key)) {
            return 0;
        }else{
            ArrayList<DataCarts>data=getOrder(key);
            return data.size();
        }
    }

    public static void cancel(String key,Integer position){
        ArrayList<DataCarts> dCarts;
        ArrayList<DataCarts> tempCarts=new ArrayList<>();
        if (!Prefs.contains(key)){
            dCarts=new ArrayList<>();
        }else{
            dCarts=getOrder(key);
        }
        for (int i=0;i<dCarts.size();i++){
            if (i!=position){
                tempCarts.add(dCarts.get(i));
            }
        }
        saveOrder(tempCarts,key);
    }

    public static Integer totalAmount(String key){
        ArrayList<DataCarts> dCarts;
        int total=0;
        if (!Prefs.contains(key)){
            dCarts=new ArrayList<>();
        }else{
            dCarts=getOrder(key);
        }
        for (int i=0;i<dCarts.size();i++){
            total+=Integer.parseInt(dCarts.get(i).getTOTAL());
        }
        return total;
    }

    public static void reset(String key){
        saveOrder(new ArrayList<DataCarts>(),key);
    }
}
