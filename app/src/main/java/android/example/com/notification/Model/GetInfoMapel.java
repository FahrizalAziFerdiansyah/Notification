package android.example.com.notification.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GetInfoMapel {

    @SerializedName("status")
    String status;
    @SerializedName("result")
    ArrayList<InfoMapel> infoMapelArrayList;
    @SerializedName("message")
    String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<InfoMapel> getInfoMapelArrayList() {
        return infoMapelArrayList;
    }

    public void setInfoMapelArrayList(ArrayList<InfoMapel> infoMapelArrayList) {
        this.infoMapelArrayList = infoMapelArrayList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
