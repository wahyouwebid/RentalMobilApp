package com.rental_apps.android.rental_apps.model.fasilitas;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.rental_apps.android.rental_apps.model.model_mobil.DataCars;

/**
 * Created by Ujang Wahyu on 02/02/2018.
 */

public class ResponseRegisterFasilitas {
    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private DataFasilitas data;

    /**
     * No args constructor for use in serialization
     *
     */
    public ResponseRegisterFasilitas() {
    }

    /**
     *
     * @param message
     * @param status
     * @param data
     */
    public ResponseRegisterFasilitas(Boolean status, String message, DataFasilitas data) {
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

    public DataFasilitas getData() {
        return data;
    }

    public void setData(DataFasilitas data) {
        this.data = data;
    }
}
