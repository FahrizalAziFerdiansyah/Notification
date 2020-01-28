package android.example.com.notification.Model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GetSiswa {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    ArrayList<Siswa> listSiswa;
    @SerializedName("message")
    String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<Siswa> getListSiswa() {
        return listSiswa;
    }

    public void setListSiswa(ArrayList<Siswa> listSiswa) {
        this.listSiswa = listSiswa;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
