package android.example.com.notification.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.app.Dialog;
import android.content.Intent;
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
import android.widget.TextView;
import android.widget.Toast;

public class DaftarActivity extends AppCompatActivity implements View.OnClickListener {

    Button daftar,cek;
    CardView data_siswa;
    private View loadingView;
    EditText nisn;
    TextView nis_n,nama,kelas,alamat,ttl;
    ApiInterface mApiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);
        Toolbar toolbar = findViewById(R.id.toolbar1);
        daftar = findViewById(R.id.daftar);
        daftar.setOnClickListener(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Daftar");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DaftarActivity.this, LoginActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });
        nisn=findViewById(R.id.nisn);
        cek=findViewById(R.id.cek);
        cek.setOnClickListener(this);

        data_siswa=findViewById(R.id.data_siswa);
        loadingView=findViewById(R.id.loading_spinner);

        mApiInterface = UtilsApi.getAPIService();
        //------------------------------
        nis_n=findViewById(R.id.nomor);
        nama=findViewById(R.id.nama);
        ttl=findViewById(R.id.ttl);
        alamat=findViewById(R.id.alamat);
        kelas=findViewById(R.id.kelas);

    }

    @Override
    public void onClick(View v) {
        if (v==cek){
            loadingView.setVisibility(View.VISIBLE);
            Call<Siswa> postNisn=mApiInterface.postNisn(nisn.getText().toString());

            postNisn.enqueue(new Callback<Siswa>() {
                @Override
                public void onResponse(Call<Siswa> call, Response<Siswa> response) {
                    String nis=response.body().getNomor_induk_sn();
                    if (TextUtils.isEmpty(nis)){
                        Toast.makeText(DaftarActivity.this,"NISN yang anda masukkan tidak ada",Toast.LENGTH_SHORT).show();
                        loadingView.setVisibility(View.GONE);
                        data_siswa.setVisibility(View.GONE);
                    } else {
                        loadingView.setVisibility(View.GONE);
                        nis_n.setText(response.body().getNomor_induk_sn());
                        nama.setText(response.body().getNama_siswa());
                        ttl.setText(response.body().getTempat_lahir_siswa()+","+response.body().getTanggal_lahir_siswa());
                        data_siswa.setVisibility(View.VISIBLE);
                    }
                }

                @Override
                public void onFailure(Call<Siswa> call, Throwable t) {

                }
            });
        }
       else if (v == daftar) {
            showDialog();
        }
    }

    private void showDialog() {
        final Dialog dialog = new Dialog(DaftarActivity.this);
        dialog.setContentView(R.layout.dialog_daftar);




        dialog.show();

    }
}
