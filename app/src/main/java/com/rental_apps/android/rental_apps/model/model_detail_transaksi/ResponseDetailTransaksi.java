package com.rental_apps.android.rental_apps.model.model_detail_transaksi;

/**
 * Created by Ujang Wahyu on 04/01/2018.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseDetailTransaksi {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private List<DataDetailTransaksi> data = null;

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

    public List<DataDetailTransaksi> getData() {
        return data;
    }

    public void setData(List<DataDetailTransaksi> data) {
        this.data = data;
    }

}

