package android.example.com.notification.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GetAbsensi {

    @SerializedName("status")
    String status;
    @SerializedName("result")
    ArrayList<Absensi> listAbsensi;
    @SerializedName("message")
    String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<Absensi> getListAbsensi() {
        return listAbsensi;
    }

    public void setListAbsensi(ArrayList<Absensi> listAbsensi) {
        this.listAbsensi = listAbsensi;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
