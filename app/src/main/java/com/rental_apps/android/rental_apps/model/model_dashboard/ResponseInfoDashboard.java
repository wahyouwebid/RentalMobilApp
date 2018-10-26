package com.rental_apps.android.rental_apps.model.model_dashboard;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Ujang Wahyu on 04/01/2018.
 */

public class ResponseInfoDashboard {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private DataInfoDashboard data;

    /**
     * No args constructor for use in serialization
     *
     */
    public ResponseInfoDashboard() {
    }

    /**
     *
     * @param message
     * @param status
     * @param data
     */
    public ResponseInfoDashboard(Boolean status, String message, DataInfoDashboard data) {
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

    public DataInfoDashboard getData() {
        return data;
    }

    public void setData(DataInfoDashboard data) {
        this.data = data;
    }

}
