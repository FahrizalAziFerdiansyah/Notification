package android.example.com.notification.Model;

import com.google.gson.annotations.SerializedName;

public class Siswa {
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

}
