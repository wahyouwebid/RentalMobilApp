package com.rental_apps.android.rental_apps.model.model_dashboard;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Ujang Wahyu on 04/01/2018.
 */

public class DataInfoDashboard {

    @SerializedName("TOTAL")
    @Expose
    private String tOTAL;
    @SerializedName("MOBIL")
    @Expose
    private String mOBIL;
    @SerializedName("TRANSAKSI")
    @Expose
    private String tRANSAKSI;
    @SerializedName("ADMIN")
    @Expose
    private String aDMIN;
    @SerializedName("USER")
    @Expose
    private String uSER;

    /**
     * No args constructor for use in serialization
     *
     */
    public DataInfoDashboard() {
    }

    /**
     *
     * @param mOBIL
     * @param tRANSAKSI
     * @param aDMIN
     * @param uSER
     */
    public DataInfoDashboard(String tOTAL,String mOBIL, String tRANSAKSI, String aDMIN, String uSER) {
        super();
        this.tOTAL= tOTAL;
        this.mOBIL = mOBIL;
        this.tRANSAKSI = tRANSAKSI;
        this.aDMIN = aDMIN;
        this.uSER = uSER;
    }

    public String gettOTAL() {
        return tOTAL;
    }

    public void settOTAL(String tOTAL) {
        this.tOTAL = tOTAL;
    }

    public String getMOBIL() {
        return mOBIL;
    }

    public void setMOBIL(String mOBIL) {
        this.mOBIL = mOBIL;
    }

    public String getTRANSAKSI() {
        return tRANSAKSI;
    }

    public void setTRANSAKSI(String tRANSAKSI) {
        this.tRANSAKSI = tRANSAKSI;
    }

    public String getADMIN() {
        return aDMIN;
    }

    public void setADMIN(String aDMIN) {
        this.aDMIN = aDMIN;
    }

    public String getUSER() {
        return uSER;
    }

    public void setUSER(String uSER) {
        this.uSER = uSER;
    }

}