package android.example.com.notification.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.example.com.notification.Adapter.AbsensiAdapter;
import android.example.com.notification.Adapter.PelajaranAdapter;
import android.example.com.notification.Model.Absensi;
import android.example.com.notification.Model.GetAbsensi;
import android.example.com.notification.Model.GetPelajaran;
import android.example.com.notification.Model.Pelajaran;
import android.example.com.notification.R;
import android.example.com.notification.RestApi.ApiInterface;
import android.example.com.notification.RestApi.UtilsApi;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class AbsensiActivity extends AppCompatActivity {
    Handler handler = new Handler();
    TextView tanggal,mapel,nama,rombel, bln, h, i, s, a;
    String month;
    SharedPreferences sharedPreferences;
    String id_siswa, id_pelajaran,nama_pelajaran,nama_siswa,tgl;
    Button lain;
    ApiInterface mApiInterface;
    SwipeRefreshLayout swLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_absensi);

        Toolbar toolbar = findViewById(R.id.toolbar1);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Data Absensi");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AbsensiActivity.this, HomeActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });
        handler.postDelayed(runnable, 0);
        tanggal = findViewById(R.id.tanggal);
        bln = findViewById(R.id.bulan);
        h = findViewById(R.id.h);
        i = findViewById(R.id.i);
        s = findViewById(R.id.s);
        a = findViewById(R.id.a);
        mApiInterface = UtilsApi.getAPIService();

        sharedPreferences = AbsensiActivity.this.getSharedPreferences("remember", Context.MODE_PRIVATE);
        id_siswa = sharedPreferences.getString("id_siswa", "1");
        nama_siswa = sharedPreferences.getString("nama_siswa", "1");

        Intent mIntent = getIntent();
        id_pelajaran = mIntent.getStringExtra("id_pelajaran");
        nama_pelajaran = mIntent.getStringExtra("nama_pelajaran");

        mapel=findViewById(R.id.mapel);
        mapel.setText(nama_pelajaran);
        nama=findViewById(R.id.nama);
        nama.setText("Nama : "+nama_siswa);
        rombel=findViewById(R.id.rombel);

        refresh();

        lain=findViewById(R.id.lain);
        lain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        swLayout=findViewById(R.id.swlayout);

        swLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                refreshItem();
            }

            void refreshItem() {

                refresh();
                onItemLoad();
            }

            void onItemLoad() {
                swLayout.setRefreshing(false);
            }
        });
    }

    private void refresh() {
        Log.e("id_s", id_siswa);
        Log.e("id_k", id_pelajaran);
        Call<Absensi> getAbsensiCall = mApiInterface.getAbsensi(id_siswa, id_pelajaran,month);
        getAbsensiCall.enqueue(new Callback<Absensi>() {
            @Override
            public void onResponse(Call<Absensi> call, Response<Absensi> response) {
                String H = response.body().getJumlah_h();
                String I = response.body().getJumlah_i();
                String S = response.body().getJumlah_s();
                String A = response.body().getJumlah_a();
                tgl = response.body().getTanggal();
                String nama_rombel = response.body().getNama_rombel();
                rombel.setText("Kelas : "+nama_rombel);

                if (!TextUtils.isEmpty(H)) {
                    h.setText(H);
                } else {
                    h.setText("0");
                }

                if (!TextUtils.isEmpty(I)) {
                    i.setText(I);
                } else {
                    i.setText("0");
                }

                if (!TextUtils.isEmpty(S)) {
                    s.setText(S);
                } else {
                    s.setText("0");
                }
                if (!TextUtils.isEmpty(A)) {
                    a.setText(A);
                } else {
                    a.setText("0");
                }

            }

            @Override
            public void onFailure(Call<Absensi> call, Throwable t) {

            }
        });
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            Calendar c1 = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            final String strDate = sdf.format(c1.getTime());
            String key = strDate;
            String[] data_waktu = key.split("-");
            String bulan = data_waktu[1];
            String date = data_waktu[0];
            tanggal.setText("Tanggal : " + tgl +" - "+ date);


            if (bulan.equals("01")) {
                month = "Januari";
            } else if (bulan.equals("02")) {
                month = "Februari";
            } else if (bulan.equals("03")) {
                month = "Maret";
            } else if (bulan.equals("04")) {
                month = "April";
            } else if (bulan.equals("05")) {
                month = "Mei";
            } else if (bulan.equals("06")) {
                month = "Juni";
            } else if (bulan.equals("07")) {
                month = "Juli";
            } else if (bulan.equals("08")) {
                month = "Agustus";
            } else if (bulan.equals("09")) {
                month = "Sebtember";
            } else if (bulan.equals("10")) {
                month = "Oktober";
            } else if (bulan.equals("11")) {
                month = "November";
            } else if (bulan.equals("12")) {
                month = "Desember";
            }

            bln.setText("Rekap Absensi Bulan "+month );
            handler.postDelayed(runnable, 0);
        }

    };


}
