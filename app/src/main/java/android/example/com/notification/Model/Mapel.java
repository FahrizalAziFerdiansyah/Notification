package android.example.com.notification.Model;

import com.google.gson.annotations.SerializedName;

public class Mapel {

    @SerializedName("nama_kategori")
    String nama_kategori;
    @SerializedName("nama_gtk")
    String nama_gtk;
    @SerializedName("waktu_mulai")
    String waktu_mulai;

    public Mapel() {
    }

    public Mapel(String nama_kategori, String nama_gtk, String waktu_mulai) {
        this.nama_kategori = nama_kategori;
        this.nama_gtk = nama_gtk;
        this.waktu_mulai = waktu_mulai;
    }

    public String getNama_kategori() {
        return nama_kategori;
    }

    public void setNama_kategori(String nama_kategori) {
        this.nama_kategori = nama_kategori;
    }

    public String getNama_gtk() {
        return nama_gtk;
    }

    public void setNama_gtk(String nama_gtk) {
        this.nama_gtk = nama_gtk;
    }

    public String getWaktu_mulai() {
        return waktu_mulai;
    }

    public void setWaktu_mulai(String waktu_mulai) {
        this.waktu_mulai = waktu_mulai;
    }
}
