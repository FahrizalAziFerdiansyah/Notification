package android.example.com.notification.Model;

import com.google.gson.annotations.SerializedName;

public class InfoMapel {

    @SerializedName("id_info_mapel")
    String id_info_mapel;
    @SerializedName("ulasan_informasi")
    String ulasan_informasi;
    @SerializedName("tanggal_informasi")
    String tanggal_informasi;
    @SerializedName("dateline")
    String dateline;
    @SerializedName("jenis_info")
    String jenis_info;
    @SerializedName("id_jenis_informasi")
    String id_jenis_informasi;
    @SerializedName("nama_pelajaran")
    String nama_pelajaran;
    @SerializedName("nama_gtk")
    String nama_gtk;

    public InfoMapel() {
    }

    public InfoMapel(String id_info_mapel, String ulasan_informasi, String tanggal_informasi, String dateline, String jenis_info, String id_jenis_informasi, String nama_pelajaran, String nama_gtk) {
        this.id_info_mapel = id_info_mapel;
        this.ulasan_informasi = ulasan_informasi;
        this.tanggal_informasi = tanggal_informasi;
        this.dateline = dateline;
        this.jenis_info = jenis_info;
        this.id_jenis_informasi = id_jenis_informasi;
        this.nama_pelajaran = nama_pelajaran;
        this.nama_gtk = nama_gtk;
    }

    public String getId_info_mapel() {
        return id_info_mapel;
    }

    public void setId_info_mapel(String id_info_mapel) {
        this.id_info_mapel = id_info_mapel;
    }

    public String getUlasan_informasi() {
        return ulasan_informasi;
    }

    public void setUlasan_informasi(String ulasan_informasi) {
        this.ulasan_informasi = ulasan_informasi;
    }

    public String getTanggal_informasi() {
        return tanggal_informasi;
    }

    public void setTanggal_informasi(String tanggal_informasi) {
        this.tanggal_informasi = tanggal_informasi;
    }

    public String getDateline() {
        return dateline;
    }

    public void setDateline(String dateline) {
        this.dateline = dateline;
    }

    public String getJenis_info() {
        return jenis_info;
    }

    public void setJenis_info(String jenis_info) {
        this.jenis_info = jenis_info;
    }

    public String getId_jenis_informasi() {
        return id_jenis_informasi;
    }

    public void setId_jenis_informasi(String id_jenis_informasi) {
        this.id_jenis_informasi = id_jenis_informasi;
    }

    public String getNama_pelajaran() {
        return nama_pelajaran;
    }

    public void setNama_pelajaran(String nama_pelajaran) {
        this.nama_pelajaran = nama_pelajaran;
    }

    public String getNama_gtk() {
        return nama_gtk;
    }

    public void setNama_gtk(String nama_gtk) {
        this.nama_gtk = nama_gtk;
    }
}
