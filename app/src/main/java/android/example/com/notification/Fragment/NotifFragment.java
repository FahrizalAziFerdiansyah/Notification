package android.example.com.notification.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.example.com.notification.Activity.AbsensiActivity;
import android.example.com.notification.Activity.DetailNotifActivity;
import android.example.com.notification.Activity.HomeActivity;
import android.example.com.notification.Activity.MapelActivity;
import android.example.com.notification.Adapter.NotifikasiAdapter;
import android.example.com.notification.Adapter.PelajaranAdapter;
import android.example.com.notification.Model.GetNotifikasi;
import android.example.com.notification.Model.Notifikasi;
import android.example.com.notification.Model.NotifikasiModel;
import android.example.com.notification.Model.Pelajaran;
import android.example.com.notification.RestApi.ApiInterface;
import android.example.com.notification.RestApi.UtilsApi;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.example.com.notification.R;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import java.util.ArrayList;


public class NotifFragment extends Fragment {
    ApiInterface mApiInterface;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<Notifikasi> notifikasiArrayListList = new ArrayList<>();
    SharedPreferences sharedPreferences;
    RecyclerView rv_notifikasi;
    String id_siswa;

    public NotifFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_notif, container, false);

        sharedPreferences = getContext().getSharedPreferences("remember", Context.MODE_PRIVATE);
        id_siswa = sharedPreferences.getString("id_siswa", "1");

        rv_notifikasi = view.findViewById(R.id.rv_notifikasi);
        mApiInterface = UtilsApi.getAPIService();
        rv_notifikasi.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        rv_notifikasi.setLayoutManager(mLayoutManager);
        refresh();

        return view;



    }

    private void refresh() {
        Call<GetNotifikasi> getNotifikasiCall=mApiInterface.postNotifikasi(id_siswa);
        getNotifikasiCall.enqueue(new Callback<GetNotifikasi>() {
            @Override
            public void onResponse(Call<GetNotifikasi> call, Response<GetNotifikasi> response) {
                notifikasiArrayListList=response.body().getListNotifikasi();
                //Log.d("Retrofit Get", "Jumlah data Item: " + String.valueOf(notifikasiArrayListList.size()));
                mAdapter = new NotifikasiAdapter(getContext(), notifikasiArrayListList);
                rv_notifikasi.setAdapter(mAdapter);
                runAnim(rv_notifikasi);
            }

            @Override
            public void onFailure(Call<GetNotifikasi> call, Throwable t) {

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
