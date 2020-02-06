package android.example.com.notification.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Map;

public class GetMapel {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    ArrayList<Mapel> listMapel;
    @SerializedName("message")
    String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<Mapel> getListMapel() {
        return listMapel;
    }

    public void setListMapel(ArrayList<Mapel> listMapel) {
        this.listMapel = listMapel;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
