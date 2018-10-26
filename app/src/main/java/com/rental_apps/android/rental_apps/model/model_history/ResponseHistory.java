package com.rental_apps.android.rental_apps.model.model_history;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.rental_apps.android.rental_apps.model.model_history.DataHistory;

import java.util.List;

/**
 * Created by USER on 28/01/2018.
 */

public class ResponseHistory {

    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private List<DataHistory> data = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public ResponseHistory() {
    }

    /**
     *
     * @param message
     * @param status
     * @param data
     */
    public ResponseHistory(Boolean status, String message, List<DataHistory> data) {
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

    public List<DataHistory> getData() {
        return data;
    }

    public void setData(List<DataHistory> data) {
        this.data = data;
    }

}
