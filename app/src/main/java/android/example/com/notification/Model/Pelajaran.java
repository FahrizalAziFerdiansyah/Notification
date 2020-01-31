package android.example.com.notification.Model;

import com.google.gson.annotations.SerializedName;

public class Pelajaran {
    @SerializedName("id_pelajaran")
    String id_pelajaran;
    @SerializedName("nama_pelajaran")
    String nama_pelajaran;

    public Pelajaran() {
    }

    public Pelajaran(String id_pelajaran, String nama_pelajaran) {
        this.id_pelajaran = id_pelajaran;
        this.nama_pelajaran = nama_pelajaran;
    }

    public String getId_pelajaran() {
        return id_pelajaran;
    }

    public void setId_pelajaran(String id_pelajaran) {
        this.id_pelajaran = id_pelajaran;
    }

    public String getNama_pelajaran() {
        return nama_pelajaran;
    }

    public void setNama_pelajaran(String nama_pelajaran) {
        this.nama_pelajaran = nama_pelajaran;
    }
}
