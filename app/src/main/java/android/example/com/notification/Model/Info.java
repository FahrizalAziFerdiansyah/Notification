package android.example.com.notification.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Info implements Parcelable {
    @SerializedName("id_info")
    String id_info;
    @SerializedName("judul")
    String judul;
    @SerializedName("tgl_publish")
    String tgl_publish;
    @SerializedName("description")
    String description;
    @SerializedName("gambar")
    String gambar;

    public String getId_info() {
        return id_info;
    }

    public void setId_info(String id_info) {
        this.id_info = id_info;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getTgl_publish() {
        return tgl_publish;
    }

    public void setTgl_publish(String tgl_publish) {
        this.tgl_publish = tgl_publish;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public Info(String id_info, String judul, String tgl_publish, String description, String gambar) {
        this.id_info = id_info;
        this.judul = judul;
        this.tgl_publish = tgl_publish;
        this.description = description;
        this.gambar = gambar;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id_info);
        dest.writeString(this.judul);
        dest.writeString(this.tgl_publish);
        dest.writeString(this.description);
        dest.writeString(this.gambar);
    }

    protected Info(Parcel in) {
        this.id_info = in.readString();
        this.judul = in.readString();
        this.tgl_publish = in.readString();
        this.description = in.readString();
        this.gambar = in.readString();
    }

    public static final Parcelable.Creator<Info> CREATOR = new Parcelable.Creator<Info>() {
        @Override
        public Info createFromParcel(Parcel source) {
            return new Info(source);
        }

        @Override
        public Info[] newArray(int size) {
            return new Info[size];
        }
    };
}
