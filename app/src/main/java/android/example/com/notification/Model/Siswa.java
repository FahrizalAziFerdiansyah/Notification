package android.example.com.notification.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Siswa  {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    String result;
    @SerializedName("message")
    String message;
    @SerializedName("id_device")
    String id_device;
    @SerializedName("nisn")
    String nisn;
    @SerializedName("password")
    String password;
    @SerializedName("token")
    String token;
    @SerializedName("nama_siswa")
    String nama_siswa;
    @SerializedName("keterangan")
    String keterangan;
    @SerializedName("tanggal_absensi")
    String tanggal_absensi;
    @SerializedName("waktu_mulai")
    String waktu_mulai;
    @SerializedName("waktu_selesai")
    String waktu_selesai;
    @SerializedName("nama_pelajaran")
    String nama_pelajaran;
    @SerializedName("nama_rombel")
    String nama_rombel;
    @SerializedName("nama_gtk")
    String nama_gtk;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getId_device() {
        return id_device;
    }

    public void setId_device(String id_device) {
        this.id_device = id_device;
    }

    public String getNisn() {
        return nisn;
    }

    public void setNisn(String nisn) {
        this.nisn = nisn;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getNama_siswa() {
        return nama_siswa;
    }

    public void setNama_siswa(String nama_siswa) {
        this.nama_siswa = nama_siswa;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getTanggal_absensi() {
        return tanggal_absensi;
    }

    public void setTanggal_absensi(String tanggal_absensi) {
        this.tanggal_absensi = tanggal_absensi;
    }

    public String getWaktu_mulai() {
        return waktu_mulai;
    }

    public void setWaktu_mulai(String waktu_mulai) {
        this.waktu_mulai = waktu_mulai;
    }

    public String getWaktu_selesai() {
        return waktu_selesai;
    }

    public void setWaktu_selesai(String waktu_selesai) {
        this.waktu_selesai = waktu_selesai;
    }

    public String getNama_pelajaran() {
        return nama_pelajaran;
    }

    public void setNama_pelajaran(String nama_pelajaran) {
        this.nama_pelajaran = nama_pelajaran;
    }

    public String getNama_rombel() {
        return nama_rombel;
    }

    public void setNama_rombel(String nama_rombel) {
        this.nama_rombel = nama_rombel;
    }

    public String getNama_gtk() {
        return nama_gtk;
    }

    public void setNama_gtk(String nama_gtk) {
        this.nama_gtk = nama_gtk;
    }
}
