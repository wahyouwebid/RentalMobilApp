package com.rental_apps.android.rental_apps.model.model_transaksi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Ujang Wahyu on 04/01/2018.
 */


public class ResponseTransaksi {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private List<DataTransaksi> data = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public ResponseTransaksi() {
    }

    /**
     *
     * @param message
     * @param status
     * @param data
     */
    public ResponseTransaksi(Boolean status, String message, List<DataTransaksi> data) {
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

    public List<DataTransaksi> getData() {
        return data;
    }

    public void setData(List<DataTransaksi> data) {
        this.data = data;
    }

}
