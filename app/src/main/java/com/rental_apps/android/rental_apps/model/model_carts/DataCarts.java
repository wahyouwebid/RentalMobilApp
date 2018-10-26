package com.rental_apps.android.rental_apps.model.model_carts;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Ujang Wahyu on 04/01/2018.
 */

public class DataCarts {
    @SerializedName("ID_MOBIL")
    @Expose
    private String ID_MOBIL;
    @SerializedName("NAMA_MOBIL")
    @Expose
    private String NAMA_MOBIL;
    @SerializedName("MERK_MOBIL")
    @Expose
    private String MERK_MOBIL;
    @SerializedName("PLAT_NO_MOBIL")
    @Expose
    private String PLAT_NO_MOBIL;
    @SerializedName("TGL_SEWA")
    @Expose
    private String TGL_SEWA;
    @SerializedName("TGL_AKHIR_PENYEWAAN")
    @Expose
    private String TGL_AKHIR_PENYEWAAN;
    @SerializedName("HARGA_MOBIL")
    @Expose
    private String HARGA_MOBIL;
    @SerializedName("TOTAL")
    @Expose
    private String TOTAL;

    public DataCarts(String ID_MOBIL, String NAMA_MOBIL, String MERK_MOBIL, String PLAT_NO_MOBIL, String TGL_SEWA, String TGL_AKHIR_PENYEWAAN, String HARGA_MOBIL, String TOTAL) {
        this.ID_MOBIL = ID_MOBIL;
        this.NAMA_MOBIL = NAMA_MOBIL;
        this.MERK_MOBIL = MERK_MOBIL;
        this.PLAT_NO_MOBIL = PLAT_NO_MOBIL;
        this.TGL_SEWA = TGL_SEWA;
        this.TGL_AKHIR_PENYEWAAN = TGL_AKHIR_PENYEWAAN;
        this.HARGA_MOBIL = HARGA_MOBIL;
        this.TOTAL = TOTAL;
    }

    public String getID_MOBIL() {
        return ID_MOBIL;
    }

    public void setID_MOBIL(String ID_MOBIL) {
        this.ID_MOBIL = ID_MOBIL;
    }

    public String getNAMA_MOBIL() {
        return NAMA_MOBIL;
    }

    public void setNAMA_MOBIL(String NAMA_MOBIL) {
        this.NAMA_MOBIL = NAMA_MOBIL;
    }

    public String getMERK_MOBIL() {
        return MERK_MOBIL;
    }

    public void setMERK_MOBIL(String MERK_MOBIL) {
        this.MERK_MOBIL = MERK_MOBIL;
    }

    public String getPLAT_NO_MOBIL() {
        return PLAT_NO_MOBIL;
    }

    public void setPLAT_NO_MOBIL(String PLAT_NO_MOBIL) {
        this.PLAT_NO_MOBIL = PLAT_NO_MOBIL;
    }

    public String getTGL_SEWA() {
        return TGL_SEWA;
    }

    public void setTGL_SEWA(String TGL_SEWA) {
        this.TGL_SEWA = TGL_SEWA;
    }

    public String getTGL_AKHIR_PENYEWAAN() {
        return TGL_AKHIR_PENYEWAAN;
    }

    public void setTGL_AKHIR_PENYEWAAN(String TGL_AKHIR_PENYEWAAN) {
        this.TGL_AKHIR_PENYEWAAN = TGL_AKHIR_PENYEWAAN;
    }

    public String getHARGA_MOBIL() {
        return HARGA_MOBIL;
    }

    public void setHARGA_MOBIL(String HARGA_MOBIL) {
        this.HARGA_MOBIL = HARGA_MOBIL;
    }

    public String getTOTAL() {
        return TOTAL;
    }

    public void setTOTAL(String TOTAL) {
        this.TOTAL = TOTAL;
    }
}
