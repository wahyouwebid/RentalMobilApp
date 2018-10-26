package com.rental_apps.android.rental_apps.model.model_mobil;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Ujang Wahyu on 04/01/2018.
 */

public class ResponseRegisterCars {
    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private DataCars data;

    /**
     * No args constructor for use in serialization
     *
     */
    public ResponseRegisterCars() {
    }

    /**
     *
     * @param message
     * @param status
     * @param data
     */
    public ResponseRegisterCars(Boolean status, String message, DataCars data) {
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

    public DataCars getData() {
        return data;
    }

    public void setData(DataCars data) {
        this.data = data;
    }
}
