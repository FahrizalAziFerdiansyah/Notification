package android.example.com.notification.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class GetReminder implements Parcelable {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    ArrayList<Reminder> listDataReminder;
    @SerializedName("message")
    String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<Reminder> getListDataReminder() {
        return listDataReminder;
    }

    public void setListDataReminder(ArrayList<Reminder> listDataReminder) {
        this.listDataReminder = listDataReminder;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public GetReminder(String status, ArrayList<Reminder> listDataReminder, String message) {
        this.status = status;
        this.listDataReminder = listDataReminder;
        this.message = message;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.status);
        dest.writeTypedList(this.listDataReminder);
        dest.writeString(this.message);
    }

    protected GetReminder(Parcel in) {
        this.status = in.readString();
        this.listDataReminder = in.createTypedArrayList(Reminder.CREATOR);
        this.message = in.readString();
    }

    public static final Parcelable.Creator<GetReminder> CREATOR = new Parcelable.Creator<GetReminder>() {
        @Override
        public GetReminder createFromParcel(Parcel source) {
            return new GetReminder(source);
        }

        @Override
        public GetReminder[] newArray(int size) {
            return new GetReminder[size];
        }
    };
}
