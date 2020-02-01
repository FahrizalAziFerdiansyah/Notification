package android.example.com.notification.RestApi;

import android.example.com.notification.Model.Absensi;
import android.example.com.notification.Model.GetAbsensi;
import android.example.com.notification.Model.GetInfo;
import android.example.com.notification.Model.GetPelajaran;
import android.example.com.notification.Model.GetSiswa;
import android.example.com.notification.Model.PostDevices;
import android.example.com.notification.Model.Siswa;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("RegisterDevice/index")
    Call<PostDevices> postDevice(@Field("nisn")String nisn,
                                 @Field("password") String password,
                                 @Field("token") String token);

    @FormUrlEncoded
    @POST("RegisterDevice/cek")
    Call<Siswa> postNisn(@Field("nisn") String nisn);

    @FormUrlEncoded
    @POST("LoginOrtu")
    Call<Siswa> postLogin(@Field("nisn")String nisn,
                           @Field("password") String password);

    @GET("List_info")
    Call<GetInfo> getInfo();

    @GET("Absen")
    Call<GetPelajaran> getPelajaran();

    @FormUrlEncoded
    @POST("Absen/absensi")
    Call<Absensi> getAbsensi(@Field("id_siswa")String id_siswa,
                             @Field("id_pelajaran") String id_pelajaran,
                             @Field("bulan") String bulan);

    @FormUrlEncoded
    @POST("Absen/bulan")
    Call<Absensi> cekAbsensi(@Field("id_siswa")String id_siswa,
                             @Field("id_pelajaran") String id_pelajaran,
                             @Field("bulan") String bulan);

}
