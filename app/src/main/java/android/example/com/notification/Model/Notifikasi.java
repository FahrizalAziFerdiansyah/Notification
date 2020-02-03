package android.example.com.notification.Model;

import com.google.gson.annotations.SerializedName;

public class Notifikasi {
    @SerializedName("keterangan")
    String keterangan;
    @SerializedName("waktu_mulai")
    String waktu_mulai;
    @SerializedName("nama_pelajaran")
    String nama_pelajaran;
    @SerializedName("waktu_selesai")
    String waktu_selesai;
    @SerializedName("nama_gtk")
    String nama_gtk;
    @SerializedName("tanggal_absensi")
    String tanggal_absensi;
    @SerializedName("nama_kategori")
    String nama_kategori;
    @SerializedName("no_wa")
    String no_wa;



    public Notifikasi() {
    }

    public Notifikasi(String keterangan, String waktu_mulai, String nama_pelajaran, String waktu_selesai, String nama_gtk, String tanggal_absensi, String nama_kategori, String no_wa) {
        this.keterangan = keterangan;
        this.waktu_mulai = waktu_mulai;
        this.nama_pelajaran = nama_pelajaran;
        this.waktu_selesai = waktu_selesai;
        this.nama_gtk = nama_gtk;
        this.tanggal_absensi = tanggal_absensi;
        this.nama_kategori = nama_kategori;
        this.no_wa = no_wa;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getWaktu_mulai() {
        return waktu_mulai;
    }

    public void setWaktu_mulai(String waktu_mulai) {
        this.waktu_mulai = waktu_mulai;
    }

    public String getNama_pelajaran() {
        return nama_pelajaran;
    }

    public void setNama_pelajaran(String nama_pelajaran) {
        this.nama_pelajaran = nama_pelajaran;
    }

    public String getWaktu_selesai() {
        return waktu_selesai;
    }

    public void setWaktu_selesai(String waktu_selesai) {
        this.waktu_selesai = waktu_selesai;
    }

    public String getNama_gtk() {
        return nama_gtk;
    }

    public void setNama_gtk(String nama_gtk) {
        this.nama_gtk = nama_gtk;
    }

    public String getTanggal_absensi() {
        return tanggal_absensi;
    }

    public void setTanggal_absensi(String tanggal_absensi) {
        this.tanggal_absensi = tanggal_absensi;
    }

    public String getNama_kategori() {
        return nama_kategori;
    }

    public void setNama_kategori(String nama_kategori) {
        this.nama_kategori = nama_kategori;
    }

    public String getNo_wa() {
        return no_wa;
    }

    public void setNo_wa(String no_wa) {
        this.no_wa = no_wa;
    }
}
