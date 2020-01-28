package android.example.com.notification.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class GetInfo implements Parcelable {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    ArrayList<Info> listDataInfo;
    @SerializedName("message")
    String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<Info> getListDataInfo() {
        return listDataInfo;
    }

    public void setListDataInfo(ArrayList<Info> listDataInfo) {
        this.listDataInfo = listDataInfo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.status);
        dest.writeTypedList(this.listDataInfo);
        dest.writeString(this.message);
    }

    public GetInfo() {
    }

    protected GetInfo(Parcel in) {
        this.status = in.readString();
        this.listDataInfo = in.createTypedArrayList(Info.CREATOR);
        this.message = in.readString();
    }

    public static final Parcelable.Creator<GetInfo> CREATOR = new Parcelable.Creator<GetInfo>() {
        @Override
        public GetInfo createFromParcel(Parcel source) {
            return new GetInfo(source);
        }

        @Override
        public GetInfo[] newArray(int size) {
            return new GetInfo[size];
        }
    };
}
