package com.rental_apps.android.rental_apps.model.model_detail_history;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by USER on 28/01/2018.
 */

public class DataDetailHistory {

    @SerializedName("ID_DETAIL_TRANSAKSI")
    @Expose
    private String iDDETAILTRANSAKSI;
    @SerializedName("KODE_TRANSAKSI")
    @Expose
    private String kODETRANSAKSI;
    @SerializedName("ID_MOBIL")
    @Expose
    private String iDMOBIL;
    @SerializedName("TGL_SEWA")
    @Expose
    private String tGLSEWA;
    @SerializedName("TGL_AKHIR_PENYEWAAN")
    @Expose
    private String tGLAKHIRPENYEWAAN;
    @SerializedName("TGL_PENGEMBALIAN")
    @Expose
    private Object tGLPENGEMBALIAN;
    @SerializedName("HARGA_MOBIL")
    @Expose
    private String hARGAMOBIL;
    @SerializedName("TOTAL")
    @Expose
    private String tOTAL;
    @SerializedName("STATUS_MOBIL")
    @Expose
    private String sTATUSMOBIL;
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
    @SerializedName("CREATED_MOBIL")
    @Expose
    private String cREATEDMOBIL;

    public String getIDDETAILTRANSAKSI() {
        return iDDETAILTRANSAKSI;
    }

    public void setIDDETAILTRANSAKSI(String iDDETAILTRANSAKSI) {
        this.iDDETAILTRANSAKSI = iDDETAILTRANSAKSI;
    }

    public String getKODETRANSAKSI() {
        return kODETRANSAKSI;
    }

    public void setKODETRANSAKSI(String kODETRANSAKSI) {
        this.kODETRANSAKSI = kODETRANSAKSI;
    }

    public String getIDMOBIL() {
        return iDMOBIL;
    }

    public void setIDMOBIL(String iDMOBIL) {
        this.iDMOBIL = iDMOBIL;
    }

    public String getTGLSEWA() {
        return tGLSEWA;
    }

    public void setTGLSEWA(String tGLSEWA) {
        this.tGLSEWA = tGLSEWA;
    }

    public String getTGLAKHIRPENYEWAAN() {
        return tGLAKHIRPENYEWAAN;
    }

    public void setTGLAKHIRPENYEWAAN(String tGLAKHIRPENYEWAAN) {
        this.tGLAKHIRPENYEWAAN = tGLAKHIRPENYEWAAN;
    }

    public Object getTGLPENGEMBALIAN() {
        return tGLPENGEMBALIAN;
    }

    public void setTGLPENGEMBALIAN(Object tGLPENGEMBALIAN) {
        this.tGLPENGEMBALIAN = tGLPENGEMBALIAN;
    }

    public String getHARGAMOBIL() {
        return hARGAMOBIL;
    }

    public void setHARGAMOBIL(String hARGAMOBIL) {
        this.hARGAMOBIL = hARGAMOBIL;
    }

    public String getTOTAL() {
        return tOTAL;
    }

    public void setTOTAL(String tOTAL) {
        this.tOTAL = tOTAL;
    }

    public String getSTATUSMOBIL() {
        return sTATUSMOBIL;
    }

    public void setSTATUSMOBIL(String sTATUSMOBIL) {
        this.sTATUSMOBIL = sTATUSMOBIL;
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

    public String getCREATEDMOBIL() {
        return cREATEDMOBIL;
    }

    public void setCREATEDMOBIL(String cREATEDMOBIL) {
        this.cREATEDMOBIL = cREATEDMOBIL;
    }

}
