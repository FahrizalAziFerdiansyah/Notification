package android.example.com.notification.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.example.com.notification.Adapter.InfoMapelAdapter;
import android.example.com.notification.Adapter.PelajaranAdapter;
import android.example.com.notification.Model.GetInfoMapel;
import android.example.com.notification.Model.GetPelajaran;
import android.example.com.notification.Model.InfoMapel;
import android.example.com.notification.Model.Pelajaran;
import android.example.com.notification.R;
import android.example.com.notification.RestApi.ApiInterface;
import android.example.com.notification.RestApi.UtilsApi;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import java.util.ArrayList;

public class InfoRombelActivity extends AppCompatActivity {
    RecyclerView rv_info_mapel;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<InfoMapel> mapelList = new ArrayList<>();
    SharedPreferences sharedPreferences;
    String id_siswa,id_rombel;
    ApiInterface mApiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_rombel);

        Toolbar toolbar = findViewById(R.id.toolbar1);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Informasi Rombel");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(InfoRombelActivity.this, HomeActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });

        sharedPreferences = InfoRombelActivity.this.getSharedPreferences("remember", Context.MODE_PRIVATE);
        id_siswa=sharedPreferences.getString("id_siswa", "1");
        id_rombel=sharedPreferences.getString("id_rombel", "1");

        rv_info_mapel=findViewById(R.id.rv_info_mapel);
        mApiInterface = UtilsApi.getAPIService();
        rv_info_mapel.setHasFixedSize(true);
        mLayoutManager = new GridLayoutManager(InfoRombelActivity.this,2);
        rv_info_mapel.setLayoutManager(mLayoutManager);

        refresh();
    }

    private void refresh() {
        Log.e("id_rombel",id_rombel);
       Call<GetInfoMapel> infoMapelCall=mApiInterface.postInfo(id_rombel);
       infoMapelCall.enqueue(new Callback<GetInfoMapel>() {
           @Override
           public void onResponse(Call<GetInfoMapel> call, Response<GetInfoMapel> response) {
               mapelList = response.body().getInfoMapelArrayList();
               Log.e("Retrofit Get", "Jumlah data Item: " + String.valueOf(mapelList.size()));
               mAdapter = new InfoMapelAdapter(mapelList,InfoRombelActivity.this);
               rv_info_mapel.setAdapter(mAdapter);
               runAnim(rv_info_mapel);
           }

           @Override
           public void onFailure(Call<GetInfoMapel> call, Throwable t) {

           }
       });
    }
    private void runAnim(RecyclerView r) {
        Context context = r.getContext();
        LayoutAnimationController layoutAnimationController = AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_slide_right);
        r.setLayoutAnimation(layoutAnimationController);
        r.getAdapter().notifyDataSetChanged();
        r.scheduleLayoutAnimation();

    }
}
