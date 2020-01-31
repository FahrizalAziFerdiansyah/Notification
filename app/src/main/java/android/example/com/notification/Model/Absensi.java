package android.example.com.notification.Model;

import com.google.gson.annotations.SerializedName;

public class Absensi {
    @SerializedName("jumlah")
    String jumlah;
    @SerializedName("jumlah_a")
    String jumlah_a;
    @SerializedName("jumlah_h")
    String jumlah_h;
    @SerializedName("jumlah_i")
    String jumlah_i;
    @SerializedName("jumlah_s")
    String jumlah_s;
    @SerializedName("keterangan")
    String keterangan;
    @SerializedName("nama_rombel")
    String nama_rombel;
    @SerializedName("tanggal")
    String tanggal;

    public String getNama_rombel() {
        return nama_rombel;
    }

    public void setNama_rombel(String nama_rombel) {
        this.nama_rombel = nama_rombel;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getJumlah_s() {
        return jumlah_s;
    }

    public void setJumlah_s(String jumlah_s) {
        this.jumlah_s = jumlah_s;
    }

    public String getJumlah_a() {
        return jumlah_a;
    }

    public void setJumlah_a(String jumlah_a) {
        this.jumlah_a = jumlah_a;
    }

    public String getJumlah_h() {
        return jumlah_h;
    }

    public void setJumlah_h(String jumlah_h) {
        this.jumlah_h = jumlah_h;
    }

    public String getJumlah_i() {
        return jumlah_i;
    }

    public void setJumlah_i(String jumlah_i) {
        this.jumlah_i = jumlah_i;
    }

    public Absensi() {
    }

    public String getJumlah() {
        return jumlah;
    }

    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
}
