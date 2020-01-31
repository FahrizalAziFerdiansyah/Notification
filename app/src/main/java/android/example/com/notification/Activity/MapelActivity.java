package android.example.com.notification.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Context;
import android.content.Intent;
import android.example.com.notification.Adapter.InfoAdapter;
import android.example.com.notification.Adapter.PelajaranAdapter;
import android.example.com.notification.Model.GetPelajaran;
import android.example.com.notification.Model.Info;
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
import java.util.Map;

public class MapelActivity extends AppCompatActivity {
    RecyclerView rv_mapel;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<Pelajaran> pelajaranList = new ArrayList<>();
    ApiInterface mApiInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapel);
        Toolbar toolbar = findViewById(R.id.toolbar1);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Pilih Pelajaran");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MapelActivity.this, HomeActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });

        rv_mapel=findViewById(R.id.rv_mapel);
        mApiInterface = UtilsApi.getAPIService();
        rv_mapel.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(MapelActivity.this,LinearLayoutManager.VERTICAL,false);
        rv_mapel.setLayoutManager(mLayoutManager);

        refresh();

    }

    private void refresh() {
        Call<GetPelajaran> getPelajaranCall=mApiInterface.getPelajaran();
        getPelajaranCall.enqueue(new Callback<GetPelajaran>() {
            @Override
            public void onResponse(Call<GetPelajaran> call, Response<GetPelajaran> response) {
                pelajaranList = response.body().getListPelajaran();
                Log.d("Retrofit Get", "Jumlah data Item: " + String.valueOf(pelajaranList.size()));
                mAdapter = new PelajaranAdapter(pelajaranList);
                rv_mapel.setAdapter(mAdapter);
                runAnim(rv_mapel);
            }

            @Override
            public void onFailure(Call<GetPelajaran> call, Throwable t) {

            }
        });
    }

    private void runAnim(RecyclerView r) {
        Context context = r.getContext();
        LayoutAnimationController layoutAnimationController = AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_fall_down);
        r.setLayoutAnimation(layoutAnimationController);
        r.getAdapter().notifyDataSetChanged();
        r.scheduleLayoutAnimation();

    }
}
