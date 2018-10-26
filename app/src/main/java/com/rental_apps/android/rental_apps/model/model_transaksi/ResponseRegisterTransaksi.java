package com.rental_apps.android.rental_apps.model.model_transaksi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Ujang Wahyu on 04/01/2018.
 */


public class ResponseRegisterTransaksi {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private DataTransaksi data = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public ResponseRegisterTransaksi() {
    }

    /**
     *
     * @param message
     * @param status
     * @param data
     */
    public ResponseRegisterTransaksi(Boolean status, String message,DataTransaksi data) {
        super();
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataTransaksi getData() {
        return data;
    }

    public void setData(DataTransaksi data) {
        this.data = data;
    }

}

