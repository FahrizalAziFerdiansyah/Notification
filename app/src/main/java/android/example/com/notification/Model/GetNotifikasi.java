package android.example.com.notification.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GetNotifikasi {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    ArrayList<Notifikasi> listNotifikasi;
    @SerializedName("message")
    String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<Notifikasi> getListNotifikasi() {
        return listNotifikasi;
    }

    public void setListNotifikasi(ArrayList<Notifikasi> listNotifikasi) {
        this.listNotifikasi = listNotifikasi;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
