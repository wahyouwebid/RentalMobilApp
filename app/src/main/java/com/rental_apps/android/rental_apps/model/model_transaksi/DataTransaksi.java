package com.rental_apps.android.rental_apps.model.model_transaksi;

/**
 * Created by Ujang Wahyu on 04/01/2018.
 */


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataTransaksi {
    @SerializedName("KODE_TRANSAKSI")
    @Expose
    private String kODETRANSAKSI;
    @SerializedName("ID_USER")
    @Expose
    private String iDUSER;
    @SerializedName("TGL_ORDER")
    @Expose
    private String tGLORDER;
    @SerializedName("TOTAL_PEMBAYARAN")
    @Expose
    private String tOTALPEMBAYARAN;
    @SerializedName("TGL_PEMBAYARAN")
    @Expose
    private String tGLPEMBAYARAN;
    @SerializedName("BUKTI_PEMBAYARAN")
    @Expose
    private String bUKTIPEMBAYARAN;
    @SerializedName("STATUS_PEMBAYARAN")
    @Expose
    private String sTATUSPEMBAYARAN;
    @SerializedName("STATUS_TRANSAKSI")
    @Expose
    private String sTATUSTRANSAKSI;
    @SerializedName("NAME")
    @Expose
    private String nAME;

    /**
     * No args constructor for use in serialization
     *
     */
    public DataTransaksi() {
    }

    /**
     *
     * @param bUKTIPEMBAYARAN
     * @param tGLORDER
     * @param kODETRANSAKSI
     * @param sTATUSTRANSAKSI
     * @param tGLPEMBAYARAN
     * @param iDUSER
     * @param sTATUSPEMBAYARAN
     * @param tOTALPEMBAYARAN
     */
    public DataTransaksi(String kODETRANSAKSI, String iDUSER, String tGLORDER, String tOTALPEMBAYARAN, String tGLPEMBAYARAN, String bUKTIPEMBAYARAN, String sTATUSPEMBAYARAN, String sTATUSTRANSAKSI, String nAME) {
        super();
        this.kODETRANSAKSI = kODETRANSAKSI;
        this.iDUSER = iDUSER;
        this.tGLORDER = tGLORDER;
        this.tOTALPEMBAYARAN = tOTALPEMBAYARAN;
        this.tGLPEMBAYARAN = tGLPEMBAYARAN;
        this.bUKTIPEMBAYARAN = bUKTIPEMBAYARAN;
        this.sTATUSPEMBAYARAN = sTATUSPEMBAYARAN;
        this.sTATUSTRANSAKSI = sTATUSTRANSAKSI;
        this.nAME = nAME;
    }

    public String getKODETRANSAKSI() {
        return kODETRANSAKSI;
    }

    public void setKODETRANSAKSI(String kODETRANSAKSI) {
        this.kODETRANSAKSI = kODETRANSAKSI;
    }

    public String getIDUSER() {
        return iDUSER;
    }

    public void setIDUSER(String iDUSER) {
        this.iDUSER = iDUSER;
    }

    public String getTGLORDER() {
        return tGLORDER;
    }

    public void setTGLORDER(String tGLORDER) {
        this.tGLORDER = tGLORDER;
    }

    public String getTOTALPEMBAYARAN() {
        return tOTALPEMBAYARAN;
    }

    public void setTOTALPEMBAYARAN(String tOTALPEMBAYARAN) {
        this.tOTALPEMBAYARAN = tOTALPEMBAYARAN;
    }

    public String getTGLPEMBAYARAN() {
        return tGLPEMBAYARAN;
    }

    public void setTGLPEMBAYARAN(String tGLPEMBAYARAN) {
        this.tGLPEMBAYARAN = tGLPEMBAYARAN;
    }

    public String getBUKTIPEMBAYARAN() {
        return bUKTIPEMBAYARAN;
    }

    public void setBUKTIPEMBAYARAN(String bUKTIPEMBAYARAN) {
        this.bUKTIPEMBAYARAN = bUKTIPEMBAYARAN;
    }

    public String getSTATUSPEMBAYARAN() {
        return sTATUSPEMBAYARAN;
    }

    public void setSTATUSPEMBAYARAN(String sTATUSPEMBAYARAN) {
        this.sTATUSPEMBAYARAN = sTATUSPEMBAYARAN;
    }

    public String getSTATUSTRANSAKSI() {
        return sTATUSTRANSAKSI;
    }

    public void setSTATUSTRANSAKSI(String sTATUSTRANSAKSI) {
        this.sTATUSTRANSAKSI = sTATUSTRANSAKSI;
    }

    public String getNAME() {
        return nAME;
    }

    public void setNAME(String nAME) {
        this.nAME = nAME;
    }

}