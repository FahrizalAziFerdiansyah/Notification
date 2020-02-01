package android.example.com.notification.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class NotifikasiModel implements Parcelable {
    String tipe_notifikasi, date, time, kehadiran;

    public String getTipe_notifikasi() {
        return tipe_notifikasi;
    }

    public void setTipe_notifikasi(String tipe_notifikasi) {
        this.tipe_notifikasi = tipe_notifikasi;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getKehadiran() {
        return kehadiran;
    }

    public void setKehadiran(String kehadiran) {
        this.kehadiran = kehadiran;
    }

    public NotifikasiModel(String tipe_notifikasi, String date, String time, String kehadiran) {
        this.tipe_notifikasi = tipe_notifikasi;
        this.date = date;
        this.time = time;
        this.kehadiran = kehadiran;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.tipe_notifikasi);
        dest.writeString(this.date);
        dest.writeString(this.time);
        dest.writeString(this.kehadiran);
    }

    protected NotifikasiModel(Parcel in) {
        this.tipe_notifikasi = in.readString();
        this.date = in.readString();
        this.time = in.readString();
        this.kehadiran = in.readString();
    }

    public static final Parcelable.Creator<NotifikasiModel> CREATOR = new Parcelable.Creator<NotifikasiModel>() {
        @Override
        public NotifikasiModel createFromParcel(Parcel source) {
            return new NotifikasiModel(source);
        }

        @Override
        public NotifikasiModel[] newArray(int size) {
            return new NotifikasiModel[size];
        }
    };
}
