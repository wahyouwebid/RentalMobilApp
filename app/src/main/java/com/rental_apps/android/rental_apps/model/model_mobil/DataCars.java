package com.rental_apps.android.rental_apps.model.model_mobil;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Ujang Wahyu on 04/01/2018.
 */
public class DataCars {
    @SerializedName("ID_MOBIL")
    @Expose
    private String iDMOBIL;
    @SerializedName("NAMA_MOBIL")
    @Expose
    private String nAMAMOBIL;
    @SerializedName("MERK_MOBIL")
    @Expose
    private String mERKMOBIL;
    @SerializedName("DESKRIPSI_MOBIL")
    @Expose
    private String dESKRIPSIMOBIL;
    @SerializedName("TAHUN_MOBIL")
    @Expose
    private String tAHUNMOBIL;
    @SerializedName("KAPASITAS_MOBIL")
    @Expose
    private String kAPASITASMOBIL;
    @SerializedName("HARGA_MOBIL")
    @Expose
    private String hARGAMOBIL;
    @SerializedName("WARNA_MOBIL")
    @Expose
    private String wARNAMOBIL;
    @SerializedName("BENSIN_MOBIL")
    @Expose
    private String bENSINMOBIL;
    @SerializedName("PLAT_NO_MOBIL")
    @Expose
    private String pLATNOMOBIL;
    @SerializedName("STATUS_SEWA")
    @Expose
    private String sTATUSSEWA;
    @SerializedName("STATUS_MOBIL")
    @Expose
    private String sTATUSMOBIL;
    @SerializedName("CREATED_MOBIL")
    @Expose
    private String cREATEDMOBIL;
    @SerializedName("IMAGE")
    @Expose
    private List<String> iMAGE = null;

    public String getIDMOBIL() {
        return iDMOBIL;
    }

    public void setIDMOBIL(String iDMOBIL) {
        this.iDMOBIL = iDMOBIL;
    }

    public String getNAMAMOBIL() {
        return nAMAMOBIL;
    }

    public void setNAMAMOBIL(String nAMAMOBIL) {
        this.nAMAMOBIL = nAMAMOBIL;
    }

    public String getMERKMOBIL() {
        return mERKMOBIL;
    }

    public void setMERKMOBIL(String mERKMOBIL) {
        this.mERKMOBIL = mERKMOBIL;
    }

    public String getDESKRIPSIMOBIL() {
        return dESKRIPSIMOBIL;
    }

    public void setDESKRIPSIMOBIL(String dESKRIPSIMOBIL) {
        this.dESKRIPSIMOBIL = dESKRIPSIMOBIL;
    }

    public String getTAHUNMOBIL() {
        return tAHUNMOBIL;
    }

    public void setTAHUNMOBIL(String tAHUNMOBIL) {
        this.tAHUNMOBIL = tAHUNMOBIL;
    }

    public String getKAPASITASMOBIL() {
        return kAPASITASMOBIL;
    }

    public void setKAPASITASMOBIL(String kAPASITASMOBIL) {
        this.kAPASITASMOBIL = kAPASITASMOBIL;
    }

    public String getHARGAMOBIL() {
        return hARGAMOBIL;
    }

    public void setHARGAMOBIL(String hARGAMOBIL) {
        this.hARGAMOBIL = hARGAMOBIL;
    }

    public String getWARNAMOBIL() {
        return wARNAMOBIL;
    }

    public void setWARNAMOBIL(String wARNAMOBIL) {
        this.wARNAMOBIL = wARNAMOBIL;
    }

    public String getBENSINMOBIL() {
        return bENSINMOBIL;
    }

    public void setBENSINMOBIL(String bENSINMOBIL) {
        this.bENSINMOBIL = bENSINMOBIL;
    }

    public String getPLATNOMOBIL() {
        return pLATNOMOBIL;
    }

    public void setPLATNOMOBIL(String pLATNOMOBIL) {
        this.pLATNOMOBIL = pLATNOMOBIL;
    }

    public String getSTATUSSEWA() {
        return sTATUSSEWA;
    }

    public void setSTATUSSEWA(String sTATUSSEWA) {
        this.sTATUSSEWA = sTATUSSEWA;
    }

    public String getSTATUSMOBIL() {
        return sTATUSMOBIL;
    }

    public void setSTATUSMOBIL(String sTATUSMOBIL) {
        this.sTATUSMOBIL = sTATUSMOBIL;
    }

    public String getCREATEDMOBIL() {
        return cREATEDMOBIL;
    }

    public void setCREATEDMOBIL(String cREATEDMOBIL) {
        this.cREATEDMOBIL = cREATEDMOBIL;
    }

    public List<String> getIMAGE() {
        return iMAGE;
    }

    public void setIMAGE(List<String> iMAGE) {
        this.iMAGE = iMAGE;
    }
}
