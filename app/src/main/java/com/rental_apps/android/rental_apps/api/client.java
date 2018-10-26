package com.rental_apps.android.rental_apps.api;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ujang Wahyu on 04/01/2018.
 */

public class client {
    private  static  final  String BASE_URL="http://192.168.43.98/rental-api/";
    private  static  final  String BASE_URL_IMAGE="http://192.168.43.98/rental-api/upload/avatars/";
    private  static  final  String BASE_URL_IMG="http://192.168.43.98/rental-api/upload/";
//    http://192.168.43.221/rental-api/";

//    private  static  final  String BASE_URL="http://192.168.43.98/rental-api/";
//    private  static  final  String BASE_URL_IMAGE="192.168.43.98/rental-api/upload/avatars/";
//    private  static  final  String BASE_URL_IMG="http://192.168.43.98/rental-api/upload/";

    public static request getApi() {
        //Builder Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        request apiService = retrofit.create(request.class);

        return apiService;
    }

    public static request getJson(){
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request original = chain.request();

                // Request customization: add request headers
                Request.Builder requestBuilder = original.newBuilder()
                        .addHeader("Content-Type", "application/json")
                        .addHeader("x-access-token", "eyJhbGci");

                Request request = requestBuilder.build();
                return chain.proceed(request);
            }
        });

        OkHttpClient client = httpClient.build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        request apiService = retrofit.create(request.class);

        return apiService;
    }
    public static String getBaseUrlImage() {
        return BASE_URL_IMAGE;
    }

    public static String getBaseImg() {
        return BASE_URL_IMG;
    }

}
