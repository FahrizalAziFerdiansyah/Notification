package android.example.com.notification.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.app.Dialog;
import android.content.Intent;
import android.example.com.notification.Firebase.SharedPrefManager;
import android.example.com.notification.MainActivity;
import android.example.com.notification.Model.PostDevices;
import android.example.com.notification.Model.Siswa;
import android.example.com.notification.R;
import android.example.com.notification.RestApi.ApiInterface;
import android.example.com.notification.RestApi.UtilsApi;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class DaftarActivity extends AppCompatActivity
//        implements View.OnClickListener
{
    String nama_ayah;
    String nama_ibu;
    String nis;
    Button daftar, cek, lihat,buat_akun;
    CardView data_siswa;
    ProgressBar loadingView;
    EditText nisn, nama_ortu,password;
    TextView nis_n, nama, kelas, alamat, ttl;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi);
//        Toolbar toolbar = findViewById(R.id.toolbar1);
//        daftar = findViewById(R.id.daftar);
//        daftar.setOnClickListener(this);
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setTitle("Daftar");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(DaftarActivity.this, LoginActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
//            }
//        });
//        nisn = findViewById(R.id.nisn);
//        cek = findViewById(R.id.cek);
//        cek.setOnClickListener(this);
//
//        data_siswa = findViewById(R.id.data_siswa);
//        loadingView = findViewById(R.id.loading_spinner);
//
//        mApiInterface = UtilsApi.getAPIService();
//        //------------------------------
//        nis_n = findViewById(R.id.nomor);
//        nama = findViewById(R.id.nama);
//        ttl = findViewById(R.id.ttl);
//        alamat = findViewById(R.id.alamat);
//        kelas = findViewById(R.id.kelas);
//
//    }
//
//    @Override
//    public void onClick(View v) {
//        if (v == cek) {
//            loadingView.setVisibility(View.VISIBLE);
//            Call<Siswa> postNisn = mApiInterface.postNisn(nisn.getText().toString());
//
//            postNisn.enqueue(new Callback<Siswa>() {
//                @Override
//                public void onResponse(Call<Siswa> call, Response<Siswa> response) {
//                    nis = response.body().getNomor_induk_sn();
//                    nama_ayah = response.body().getNama_ayah();
//                    nama_ibu = response.body().getNama_ibu();
//                    String status = response.body().getStat();
//                    String ket = response.body().getKet();
//                   // Log.e("status",status);
//                 //   Log.e("keterangan",ket);
//                    if (TextUtils.isEmpty(status)){
//                        if (TextUtils.isEmpty(ket)) {
//                            loadingView.setVisibility(View.GONE);
//                            nis_n.setText(response.body().getNomor_induk_sn());
//                            nama.setText(response.body().getNama_siswa());
//                            alamat.setText(response.body().getAlamat());
//                            kelas.setText(response.body().getKelas());
//                            ttl.setText(response.body().getTempat_lahir_siswa() + "," + response.body().getTanggal_lahir_siswa());
//                            data_siswa.setVisibility(View.VISIBLE);
//                        } else {
//                            Toast.makeText(DaftarActivity.this, "NISN yang anda masukkan tidak ada", Toast.LENGTH_SHORT).show();
//                            loadingView.setVisibility(View.GONE);
//                            data_siswa.setVisibility(View.GONE);
//
//                        }
//
//                    } else {
//                        Toast.makeText(DaftarActivity.this, "NISN sudah terdaftar, silahkan login!", Toast.LENGTH_SHORT).show();
//                        loadingView.setVisibility(View.GONE);
//                        data_siswa.setVisibility(View.GONE);
//
//                    }
//
//                }
//
//                @Override
//                public void onFailure(Call<Siswa> call, Throwable t) {
//
//                }
//            });
//        } else if (v == daftar) {
//            showDialog();
//        }
//    }
//
//    private void showDialog() {
//        final Dialog dialog = new Dialog(DaftarActivity.this);
//        dialog.setContentView(R.layout.dialog_daftar);
//        nama_ortu = dialog.findViewById(R.id.nama_ortu);
//        password=dialog.findViewById(R.id.password);
//        buat_akun=dialog.findViewById(R.id.buat_akun);
//        lihat=dialog.findViewById(R.id.lihat);
//        lihat.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (nama_ortu.getText().toString().equals(nama_ayah)){
//                    Toast.makeText(DaftarActivity.this, "Hai "+nama_ortu.getText().toString(), Toast.LENGTH_SHORT).show();
//                    nama_ortu.setEnabled(false);
//                    password.setVisibility(View.VISIBLE);
//                    lihat.setVisibility(View.GONE);
//                    buat_akun.setVisibility(View.VISIBLE);
//                } else if (nama_ortu.getText().toString().equals(nama_ibu)){
//                    Toast.makeText(DaftarActivity.this, "Hai "+nama_ortu.getText().toString(), Toast.LENGTH_SHORT).show();
//                    nama_ortu.setEnabled(false);
//                    lihat.setVisibility(View.GONE);
//                    password.setVisibility(View.VISIBLE);
//                    buat_akun.setVisibility(View.VISIBLE);
//                } else {
//                    Toast.makeText(DaftarActivity.this, nama_ortu.getText().toString()+" Bukan Wali Murid", Toast.LENGTH_SHORT).show();
//                    password.setVisibility(View.GONE);
//                    buat_akun.setVisibility(View.GONE);
//                }
//            }
//        });
//        buat_akun.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String token = SharedPrefManager.getInstance(DaftarActivity.this).getDeviceToken();
//                //AJA
//                Log.e("Token",token);
//                Log.e("NISN",nis);
//                Call<PostDevices> postDevicesCall=mApiInterface.postDevice(nis,password.getText().toString(),token);
//                postDevicesCall.enqueue(new Callback<PostDevices>() {
//                    @Override
//                    public void onResponse(Call<PostDevices> call, Response<PostDevices> response) {
//
//                        Toast.makeText(DaftarActivity.this,"Berhasil Membuat Akun",Toast.LENGTH_LONG).show();
//                        startActivity(new Intent(DaftarActivity.this, LoginActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
//
//                    }
//
//                    @Override
//                    public void onFailure(Call<PostDevices> call, Throwable t) {
//                        Toast.makeText(DaftarActivity.this,"Gagal",Toast.LENGTH_LONG).show();
//                    }
//                });
//            }
//        });
//
//
//        dialog.show();

    }
}
