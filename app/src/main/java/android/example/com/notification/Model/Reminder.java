package android.example.com.notification.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Reminder implements Parcelable {
    @SerializedName("id_reminder")
    String id_reminder;
    @SerializedName("judul_reminder")
    String judul_reminder;
    @SerializedName("tanggal")
    String tanggal;
    @SerializedName("description")
    String description;
    @SerializedName("nama_rombel")
    String nama_rombel;
    @SerializedName("id_rombel")
    String id_rombel;

    public String getId_reminder() {
        return id_reminder;
    }

    public void setId_reminder(String id_reminder) {
        this.id_reminder = id_reminder;
    }

    public String getJudul_reminder() {
        return judul_reminder;
    }

    public void setJudul_reminder(String judul_reminder) {
        this.judul_reminder = judul_reminder;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNama_rombel() {
        return nama_rombel;
    }

    public void setNama_rombel(String nama_rombel) {
        this.nama_rombel = nama_rombel;
    }

    public String getId_rombel() {
        return id_rombel;
    }

    public void setId_rombel(String id_rombel) {
        this.id_rombel = id_rombel;
    }

    public Reminder(String id_reminder, String judul_reminder, String tanggal, String description, String nama_rombel, String id_rombel) {
        this.id_reminder = id_reminder;
        this.judul_reminder = judul_reminder;
        this.tanggal = tanggal;
        this.description = description;
        this.nama_rombel = nama_rombel;
        this.id_rombel = id_rombel;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id_reminder);
        dest.writeString(this.judul_reminder);
        dest.writeString(this.tanggal);
        dest.writeString(this.description);
        dest.writeString(this.nama_rombel);
        dest.writeString(this.id_rombel);
    }

    protected Reminder(Parcel in) {
        this.id_reminder = in.readString();
        this.judul_reminder = in.readString();
        this.tanggal = in.readString();
        this.description = in.readString();
        this.nama_rombel = in.readString();
        this.id_rombel = in.readString();
    }

    public static final Parcelable.Creator<Reminder> CREATOR = new Parcelable.Creator<Reminder>() {
        @Override
        public Reminder createFromParcel(Parcel source) {
            return new Reminder(source);
        }

        @Override
        public Reminder[] newArray(int size) {
            return new Reminder[size];
        }
    };
}
