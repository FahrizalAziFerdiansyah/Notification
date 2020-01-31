package android.example.com.notification.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GetPelajaran {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    ArrayList<Pelajaran> listPelajaran;
    @SerializedName("message")
    String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<Pelajaran> getListPelajaran() {
        return listPelajaran;
    }

    public void setListPelajaran(ArrayList<Pelajaran> listPelajaran) {
        this.listPelajaran = listPelajaran;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
