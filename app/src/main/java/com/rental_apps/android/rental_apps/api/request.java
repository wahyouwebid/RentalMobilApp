package com.rental_apps.android.rental_apps.api;

import com.rental_apps.android.rental_apps.model.model_carts.DataCarts;
import com.rental_apps.android.rental_apps.model.model_dashboard.ResponseInfoDashboard;
import com.rental_apps.android.rental_apps.model.model_detail_transaksi.ResponseCancelTransaksi;
import com.rental_apps.android.rental_apps.model.model_detail_transaksi.ResponseDetailTransaksi;
import com.rental_apps.android.rental_apps.model.model_history.ResponseHistory;
import com.rental_apps.android.rental_apps.model.model_mobil.DataCars;
import com.rental_apps.android.rental_apps.model.model_mobil.ResponseRegisterCars;
import com.rental_apps.android.rental_apps.model.model_transaksi.ResponseRegisterTransaksi;
import com.rental_apps.android.rental_apps.model.model_transaksi.ResponseTransaksi;
import com.rental_apps.android.rental_apps.model.model_user.ResponseLogin;
import com.rental_apps.android.rental_apps.model.model_mobil.ResponseCars;
import com.rental_apps.android.rental_apps.model.model_user.ResponseRegister;
import com.rental_apps.android.rental_apps.model.model_user.ResponseUser;

import org.json.JSONStringer;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;

/**
 * Created by Ujang Wahyu on 04/01/2018.
 */

public interface request{
    @FormUrlEncoded
    @POST("Api/auth")
    Call<ResponseLogin> auth(@Field("USERNAME") String username,
                             @Field("PASSWORD") String password);

    @FormUrlEncoded
    @POST("Api/user")
    Call<ResponseRegister> userRegister(@Field("NAME")String name,
                                        @Field("NIK")String nik,
                                        @Field("USERNAME")String username,
                                        @Field("EMAIL")String email,
                                        @Field("NO_TELP")String no_telp,
                                        @Field("JENIS_KELAMIN")Character jenis_kelamin,
                                        @Field("ALAMAT")String alamat,
                                        @Field("PASSWORD")String password,
                                        @Field("ACTIVATED")Integer activated,
                                        @Field("GROUP_USER")Integer group_user);
    @FormUrlEncoded
    @PUT("Api/user")
    Call<ResponseRegister> userUpdate(@Field("ID_USER")String ID_USER,
                                      @Field("NAME")String name,
                                      @Field("NIK")String nik,
                                      @Field("USERNAME")String username,
                                      @Field("EMAIL")String email,
                                      @Field("NO_TELP")String no_telp,
                                      @Field("JENIS_KELAMIN")String jenis_kelamin,
                                      @Field("ALAMAT")String alamat,
                                      @Field("PASSWORD")String password,
                                      @Field("ACTIVATED")Integer activated,
                                      @Field("GROUP_USER")Integer group_user,
                                      @Field("PHOTO")String photo);


    @GET("Api/mobil")
    Call<ResponseCars>  dataMobil();


    @FormUrlEncoded
        @POST("Api/mobil")
    Call<ResponseRegisterCars> mobilRegister(@Field("NAMA_MOBIL") String NAMA_MOBIL,
                                             @Field("MERK_MOBIL") String MERK_MOBIL,
                                             @Field("DESKRIPSI_MOBIL") String DESKRIPSI_MOBIL,
                                             @Field("TAHUN_MOBIL") String TAHUN_MOBIL,
                                             @Field("KAPASITAS_MOBIL") String KAPASITAS_MOBIL,
                                             @Field("HARGA_MOBIL") String HARGA_MOBIL,
                                             @Field("WARNA_MOBIL") String WARNA_MOBIL,
                                             @Field("BENSIN_MOBIL") Integer BENSIN_MOBIL,
                                             @Field("PLAT_NO_MOBIL") String PLAT_NO_MOBIL,
                                             @Field("STATUS_MOBIL") String STATUS_MOBIL,
                                             @Field("PHOTO") String PHOTO
                                             );

    @FormUrlEncoded
    @PUT("Api/mobil")
    Call<ResponseRegisterCars> mobilUpdate(@Field("ID_MOBIL") String ID_MOBIL,
                                           @Field("NAMA_MOBIL") String NAMA_MOBIL,
                                             @Field("MERK_MOBIL") String MERK_MOBIL,
                                             @Field("DESKRIPSI_MOBIL") String DESKRIPSI_MOBIL,
                                             @Field("TAHUN_MOBIL") String TAHUN_MOBIL,
                                             @Field("KAPASITAS_MOBIL") String KAPASITAS_MOBIL,
                                             @Field("HARGA_MOBIL") String HARGA_MOBIL,
                                             @Field("WARNA_MOBIL") String WARNA_MOBIL,
                                             @Field("BENSIN_MOBIL") Integer BENSIN_MOBIL,
                                             @Field("PLAT_NO_MOBIL") String PLAT_NO_MOBIL,
                                             @Field("STATUS_MOBIL") String STATUS_MOBIL,
                                             @Field("PHOTO") String PHOTO
    );


    @GET("Api/user/{GROUP_USER}/{ID_USER}")
    Call<ResponseUser> dataUser(
            @Path("GROUP_USER") Integer GROUP_USER,
            @Path("ID_USER") Integer ID_USER
    );


    @GET("Api/pesanan")
    Call<ResponseTransaksi>  dataTransaksi();

    @GET("Api/dashboard")
    Call<ResponseInfoDashboard>  dataInfoDashboard();

    @FormUrlEncoded
    @POST("Api/pesanan")
    Call<ResponseRegisterTransaksi> checkout(@Field("ID_USER") String ID_USER,
                                             @Field("TOTAL_PEMBAYARAN") String TOTAL_PEMBAYARAN,
                                             @Field("LIST_CART") String LIST_CART
                                             );

    @GET("Api/pesanan/{KODE_TRANSAKSI}")
    Call<ResponseDetailTransaksi> dataDetailTransaksi(
            @Path("KODE_TRANSAKSI") String KODE_TRANSAKSI
    );

    @GET("api/pesanan/history/{ID_USER}")
    Call<ResponseHistory> dataHistory(
            @Path("ID_USER") Integer ID_USER
    );

    @GET("Api/fasilitas")
    Call<ResponseCars>  dataFasilitas();

    @DELETE("api/transaksi/{ID_DETAIL_TRANSAKSI}")
    Call<ResponseCancelTransaksi> cancelTransaksi(
            @Path("ID_DETAIL_TRANSAKSI") Integer ID_DETAIL_TRANSAKSI
    );

//    @FormUrlEncoded
//    @POST("Api/pesanan")
//    Call<ResponseRegisterTransaksi> checkout(@Body DataCarts data);
}
