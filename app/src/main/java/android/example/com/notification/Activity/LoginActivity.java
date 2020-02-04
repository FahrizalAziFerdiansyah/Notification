package android.example.com.notification.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.example.com.notification.Activity.HomeActivity;
import android.example.com.notification.Fragment.HomeFragment;
import android.example.com.notification.Model.Siswa;
import android.example.com.notification.R;
import android.example.com.notification.RestApi.ApiInterface;
import android.example.com.notification.RestApi.UtilsApi;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private TextView Appname, subAppname, daftar;
    private Button btnlogin;
    private EditText ET_nisn, ET_password;
    private ImageView logo;
    private Animation smalltobig, btta, btta2;
    ProgressDialog progressDialog;
  //  SharedPreferences mSettings;
    ApiInterface mApiInterface;
    SharedPreferences.Editor editor;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        //i
       //mSettings = this.getSharedPreferences("Settings", Context.MODE_PRIVATE);



        smalltobig = AnimationUtils.loadAnimation(this, R.anim.smalltobig);
        btta = AnimationUtils.loadAnimation(this, R.anim.btta);
        btta2 = AnimationUtils.loadAnimation(this, R.anim.btta2);
        logo = findViewById(R.id.logo_sd);
        Appname = findViewById(R.id.nama_sd);
//        subAppname = findViewById(R.id.subName);
        btnlogin = findViewById(R.id.btn_login);
        ET_nisn = findViewById(R.id.et_nisn);
        ET_password = findViewById(R.id.et_password);
//
//        daftar=findViewById(R.id.txt_daftar);
//        daftar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(LoginActivity.this,DaftarActivity.class);
//                startActivity(intent);
//            }
//        });
//
//        //pass anim
//        logo.startAnimation(smalltobig);
//        Appname.startAnimation(btta);
////        subAppname.startAnimation(btta);
//        btnlogin.startAnimation(btta2);
//        ET_nisn.startAnimation(btta2);
//        ET_password.startAnimation(btta2);
//        //i
        mApiInterface = UtilsApi.getAPIService();
        sharedPreferences = LoginActivity.this.getSharedPreferences("remember", Context.MODE_PRIVATE);
        editor =  sharedPreferences.edit();

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String nisn = ET_nisn.getText().toString();
            String password = ET_password.getText().toString();
            //required
            if(nisn.equals("")) {
                Toast.makeText(LoginActivity.this, "NISN Harus Diisi", Toast.LENGTH_SHORT).show();
            }else  if(password.equals("")) {
                Toast.makeText(LoginActivity.this, "Password Harus Diisi", Toast.LENGTH_SHORT).show();
            } else {
                //dialog
                progressDialog =new ProgressDialog(LoginActivity.this);
                progressDialog.setMessage("Mohon Tunggu...");
                progressDialog.setCancelable(false);
                progressDialog.show();
                //login
                retrofit2.Call<Siswa> postLogin= mApiInterface.postLogin(nisn,password);
                postLogin.enqueue(new Callback<Siswa>() {
                    @Override
                    public void onResponse(Call<Siswa> call, Response<Siswa> response) {
                        progressDialog.dismiss();
                        String id_device = response.body().getId_device();
                        String nisn = response.body().getNisn();
                        String token = response.body().getToken();
                        String nama_siswa = response.body().getNama_siswa();
                      // String keterangan = response.body().getKeterangan();
                       // String tanggal_absensi = response.body().getTanggal_absensi();
                        //String waktu_mulai = response.body().getWaktu_mulai();
                        //String waktu_selesai = response.body().getWaktu_selesai();
                        //String nama_pelajaran = response.body().getNama_pelajaran();
                        String nama_rombel = response.body().getNama_rombel();
                        String id_rombel = response.body().getId_rombel();
                        String jk = response.body().getJenis_kelamin_siswa();
                        //String nama_gtk = response.body().getNama_gtk();
                       // Log.e("id_rombel", id_rombel);
                        //Log.e("Berhasil Login", "Berhasil " +nisn+nama_siswa);
                        if(TextUtils.isEmpty(id_device)){
                            Toast.makeText(LoginActivity.this,"NISN atau Password salah", Toast.LENGTH_LONG).show();
                        } else{
                            Toast.makeText(LoginActivity.this,"Berhasil Login", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                            editor.putString("id_device", id_device);
                            editor.putString("token", token);
                            //editor.putString("keterangan", keterangan);
                            //editor.putString("tanggal_absensi", tanggal_absensi);
                            //editor.putString("waktu_mulai", waktu_mulai);
                            //editor.putString("waktu_selesai", waktu_selesai);
                            //editor.putString("nama_pelajaran", nama_pelajaran);
                            editor.putString("nama_rombel", nama_rombel);
                            editor.putString("id_rombel", id_rombel);
                            editor.putString("nama_siswa", nama_siswa);
                            editor.putString("jk", jk);
                            editor.putString("nisn", nisn);
                            editor.putBoolean("ceklogin", true);
                            editor.apply();
                            startActivity(intent);
                        }

                    }

                    @Override
                    public void onFailure(Call<Siswa> call, Throwable t) {
                        progressDialog.dismiss();
                        Log.e("gagal", "gagal" + t);
                        Toast.makeText(LoginActivity.this, "Gagal Login", Toast.LENGTH_LONG).show();
                    }
                });
             //batas else required
            }
            }
        //batas klik login
        });

    }

    public void onLoginClick(View view) {
        startActivity(new Intent(LoginActivity.this, DaftarActivity.class));
    }
}
