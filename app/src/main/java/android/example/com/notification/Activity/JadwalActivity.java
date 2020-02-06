package android.example.com.notification.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.example.com.notification.Adapter.MapelAdapter;
import android.example.com.notification.Adapter.PelajaranAdapter;
import android.example.com.notification.Model.GetMapel;
import android.example.com.notification.Model.Mapel;
import android.example.com.notification.Model.Pelajaran;
import android.example.com.notification.R;
import android.example.com.notification.RestApi.ApiInterface;
import android.example.com.notification.RestApi.UtilsApi;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class JadwalActivity extends AppCompatActivity {
    RecyclerView rv_jadwal;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<Mapel> mapelList = new ArrayList<>();
    ApiInterface mApiInterface;
    SharedPreferences sharedPreferences;
    TextView day,namasi,rombel;
    String id_rombel,id_hari,hari;
    Spinner sp_hari;
    Button lain;
    ProgressBar loadingView;
    CardView cardEnpty;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jadwal);

        rv_jadwal=findViewById(R.id.rv_jadwal);
        mApiInterface = UtilsApi.getAPIService();
        rv_jadwal.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(JadwalActivity.this,LinearLayoutManager.VERTICAL,false);
        rv_jadwal.setLayoutManager(mLayoutManager);
        day=findViewById(R.id.hari);
        namasi=findViewById(R.id.nama);
        rombel=findViewById(R.id.rombel);
        Toolbar toolbar = findViewById(R.id.toolbar1);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Data Jadwal");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(JadwalActivity.this, HomeActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });

        sharedPreferences = JadwalActivity.this.getSharedPreferences("remember", Context.MODE_PRIVATE);
        String nama = sharedPreferences.getString("nama_siswa", "1");
        id_rombel = sharedPreferences.getString("id_rombel", "2");

        namasi.setText("Nama : "+nama);
        rombel.setText("Kelas : " + sharedPreferences.getString("nama_rombel", "1"));

        cardEnpty=findViewById(R.id.card_empty);

        loadingView = findViewById(R.id.loading_spinner);
        Calendar calendar=Calendar.getInstance();
        int hari=calendar.get(Calendar.DAY_OF_WEEK);

        switch (hari){
            case Calendar.SATURDAY:
                day.setText("Sabtu");
                id_hari="6";
            case Calendar.SUNDAY:
                day.setText("Minggu");
                id_hari="7";
            case Calendar.MONDAY:
                day.setText("Senin");
                id_hari="1";
            case Calendar.TUESDAY:
                day.setText("Selasa");
                id_hari="2";
            case Calendar.WEDNESDAY:
                day.setText("Rabu");
                id_hari="3";
            case Calendar.THURSDAY:
                day.setText("Kamis");
                id_hari="4";
            case Calendar.FRIDAY:
                day.setText("Jumat");
                id_hari="5";


        }

        refresh();

        sp_hari=findViewById(R.id.sp_hari);

        lain = findViewById(R.id.lain);
        lain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingView.setVisibility(View.VISIBLE);
                if (sp_hari.getSelectedItem().toString().equals("Senin")){
                    id_hari="1";
                    day.setText("Senin");
                }else if (sp_hari.getSelectedItem().toString().equals("Selasa")){
                    id_hari="2";
                    day.setText("Selasa");
                }else if (sp_hari.getSelectedItem().toString().equals("Rabu")){
                    id_hari="3";
                    day.setText("Rabu");
                }else if (sp_hari.getSelectedItem().toString().equals("Kamis")){
                    id_hari="4";
                    day.setText("Kamis");
                }else if (sp_hari.getSelectedItem().toString().equals("Jumat")){
                    id_hari="5";
                    day.setText("Jumat");
                }else if (sp_hari.getSelectedItem().toString().equals("Sabtu")){
                    id_hari="6";
                    day.setText("Sabtu");
                }

                refresh();
            }
        });



    }

    private void refresh() {

        Call<GetMapel> getMapelCall=mApiInterface.postMapel(id_rombel,id_hari);
        getMapelCall.enqueue(new Callback<GetMapel>() {
            @Override
            public void onResponse(Call<GetMapel> call, Response<GetMapel> response) {
                loadingView.setVisibility(View.VISIBLE);
                mapelList = response.body().getListMapel();
                Log.d("Retrofit Get", "Jumlah data Item: " + mapelList.size());
                if (mapelList.size()==0){
                    loadingView.setVisibility(View.GONE);
                    cardEnpty.setVisibility(View.VISIBLE);
                    rv_jadwal.setVisibility(View.GONE);
                } else {
                    loadingView.setVisibility(View.GONE);
                    cardEnpty.setVisibility(View.GONE);
                    rv_jadwal.setVisibility(View.VISIBLE);
                    mAdapter = new MapelAdapter(mapelList);
                    rv_jadwal.setAdapter(mAdapter);

                }


            }

            @Override
            public void onFailure(Call<GetMapel> call, Throwable t) {

            }
        });
    }

}
