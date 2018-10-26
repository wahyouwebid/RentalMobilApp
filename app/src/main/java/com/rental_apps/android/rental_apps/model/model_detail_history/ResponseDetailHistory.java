package com.rental_apps.android.rental_apps.model.model_detail_history;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.rental_apps.android.rental_apps.model.model_detail_transaksi.DataDetailTransaksi;

import java.util.List;

/**
 * Created by USER on 28/01/2018.
 */

public class ResponseDetailHistory {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private List<DataDetailHistory> data = null;

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

    public List<DataDetailHistory> getData() {
        return data;
    }

    public void setData(List<DataDetailHistory> data) {
        this.data = data;
    }

}
