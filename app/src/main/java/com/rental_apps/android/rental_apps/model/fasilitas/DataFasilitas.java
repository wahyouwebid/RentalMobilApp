package com.rental_apps.android.rental_apps.model.fasilitas;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Ujang Wahyu on 02/02/2018.
 */

public class DataFasilitas {
    @SerializedName("ID_FASILITAS")
    @Expose
    private String iDFASILITAS;

    @SerializedName("FASILITAS")
    @Expose
    private String fASILITAS;

    @SerializedName("KETFASILITAS")
    @Expose
    private String kETFASILITAS;

    @SerializedName("BIAYA")
    @Expose
    private String bIAYA;

    /**
     * No args constructor for use in serialization
     *
     */
    public DataFasilitas() {
    }

    //get
    public String getiDFASILITAS(){
        return iDFASILITAS;
    }

    public String getfASILITAS(){
        return fASILITAS;
    }

    public String getkETFASILITAS(){
        return kETFASILITAS;
    }

    public String getbIAYA(){
        return getbIAYA();
    }

    //set

    public void setiDFASILITAS(String iDFASILITAS){
        this.iDFASILITAS = iDFASILITAS;
    }

    public void setfASILITAS(String fASILITAS){
        this.fASILITAS = fASILITAS;
    }

    public void setkETFASILITAS(String kETFASILITAS){
        this.kETFASILITAS = kETFASILITAS;
    }

    public void setbIAYA(String kETFASILITAS){
        this.bIAYA = bIAYA;
    }
}
