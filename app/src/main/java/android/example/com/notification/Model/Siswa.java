package android.example.com.notification.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Siswa  {
    @SerializedName("stat")
    String stat;
    @SerializedName("id_device")
    String id_device;
    @SerializedName("id_siswa")
    String id_siswa;
    @SerializedName("nisn")
    String nisn;
    @SerializedName("alamat")
    String alamat;
    @SerializedName("kelas")
    String kelas;
    @SerializedName("nama_ayah")
    String nama_ayah;
    @SerializedName("nama_ibu")
    String nama_ibu;
    @SerializedName("nomor_induk_sn")
    String nomor_induk_sn;
    @SerializedName("tempat_lahir_siswa")
    String tempat_lahir_siswa;
    @SerializedName("tanggal_lahir_siswa")
    String tanggal_lahir_siswa;
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
    @SerializedName("ket")
    String ket;
    @SerializedName("id_rombel")
    String id_rombel;
    @SerializedName("jenis_kelamin_siswa")
    String jenis_kelamin_siswa;

    public String getJenis_kelamin_siswa() {
        return jenis_kelamin_siswa;
    }

    public void setJenis_kelamin_siswa(String jenis_kelamin_siswa) {
        this.jenis_kelamin_siswa = jenis_kelamin_siswa;
    }

    public String getKet() {
        return ket;
    }

    public void setKet(String ket) {
        this.ket = ket;
    }

    public String getTempat_lahir_siswa() {
        return tempat_lahir_siswa;
    }

    public void setTempat_lahir_siswa(String tempat_lahir_siswa) {
        this.tempat_lahir_siswa = tempat_lahir_siswa;
    }

    public String getId_siswa() {
        return id_siswa;
    }

    public void setId_siswa(String id_siswa) {
        this.id_siswa = id_siswa;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getAlamat() {
        return alamat;
    }


    public String getNama_ayah() {
        return nama_ayah;
    }

    public void setNama_ayah(String nama_ayah) {
        this.nama_ayah = nama_ayah;
    }

    public String getNama_ibu() {
        return nama_ibu;
    }

    public void setNama_ibu(String nama_ibu) {
        this.nama_ibu = nama_ibu;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTanggal_lahir_siswa() {
        return tanggal_lahir_siswa;
    }

    public void setTanggal_lahir_siswa(String tanggal_lahir_siswa) {
        this.tanggal_lahir_siswa = tanggal_lahir_siswa;
    }




    public String getNomor_induk_sn() {
        return nomor_induk_sn;
    }

    public void setNomor_induk_sn(String nomor_induk_sn) {
        this.nomor_induk_sn = nomor_induk_sn;
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
