package android.example.com.notification.RestApi;

import android.example.com.notification.Model.PostDevices;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("RegisterDevice/daftar")
    Call<PostDevices> postDevice(@Field("nisn")String nisn,
                                 @Field("password") String password,
                                 @Field("token") String token);
}