package android.example.com.notification.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.example.com.notification.Activity.AbsensiActivity;
import android.example.com.notification.Activity.InfoRombelActivity;
import android.example.com.notification.Activity.JadwalActivity;
import android.example.com.notification.Activity.ReminderActivity;
import android.example.com.notification.Adapter.InfoAdapter;
import android.example.com.notification.Model.GetInfo;
import android.example.com.notification.Model.Info;
import android.example.com.notification.RestApi.ApiInterface;
import android.example.com.notification.RestApi.UtilsApi;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.example.com.notification.R;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {
    TextView nama_siswa, nisn, menu1, menu2, menu3, menu4, menu;
    ImageView foto_siswa,absen,icplug,jadwal, reminder;
    RecyclerView rv_card;
    ArrayList<Info> infoList = new ArrayList<>();
    InfoAdapter infoAdapter;
    Context mContext;
    ApiInterface mApiInterface;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    SharedPreferences sharedPreferences;
    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        nama_siswa = view.findViewById(R.id.nama_siswa);
        nisn = view.findViewById(R.id.nisn);
        foto_siswa = view.findViewById(R.id.foto_siswa);
        menu1 = view.findViewById(R.id.menu1);
        menu2 = view.findViewById(R.id.menu2);
        menu3 = view.findViewById(R.id.menu3);
        menu4 = view.findViewById(R.id.menu4);
        menu = view.findViewById(R.id.mainMenu);
        rv_card = view.findViewById(R.id.rv_info);
        sharedPreferences = getActivity().getSharedPreferences("remember", Context.MODE_PRIVATE);
        String nama = sharedPreferences.getString("nama_siswa", "1");
        String id_rombel2 = sharedPreferences.getString("id_rombel", "2");
        Log.e("id",id_rombel2);
        nama_siswa.setText(nama);
        String nisn1 = sharedPreferences.getString("nisn", "2");
        nisn.setText(nisn1);
//
        absen=view.findViewById(R.id.absen);
        absen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getContext(), AbsensiActivity.class);
                startActivity(intent);
            }
        });
        icplug=view.findViewById(R.id.tugas);
        icplug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getContext(), InfoRombelActivity.class);
                startActivity(intent);
            }
        });
//        mContext = getContext();
        mApiInterface = UtilsApi.getAPIService();
        rv_card.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        rv_card.setLayoutManager(mLayoutManager);

        jadwal=view.findViewById(R.id.jadwal);
        jadwal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getContext(), JadwalActivity.class);
                startActivity(intent);
            }
        });
        reminder=view.findViewById(R.id.reminder);
        reminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ReminderActivity.class);
                startActivity(intent);
            }
        });




        //import Font
        Typeface MLight = Typeface.createFromAsset(getActivity().getAssets(),"fonts/ML.ttf");
        Typeface MMedium = Typeface.createFromAsset(getActivity().getAssets(), "fonts/MM.ttf");
        Typeface MReguler = Typeface.createFromAsset(getActivity().getAssets(), "fonts/MR.ttf");

        // custom font
        nama_siswa.setTypeface(MMedium);
        nisn.setTypeface(MLight);
        menu.setTypeface(MReguler);
        menu1.setTypeface(MMedium);
        menu2.setTypeface(MMedium);
        menu3.setTypeface(MMedium);
        menu4.setTypeface(MMedium);


        ShowInfo();
        return view;
    }
//
    public void ShowInfo() {
        Call<GetInfo> ItemCall = mApiInterface.getInfo();
        ItemCall.enqueue(new Callback<GetInfo>() {
            @Override
            public void onResponse(Call<GetInfo> call, Response<GetInfo>
                    response) {
                infoList = response.body().getListDataInfo();
                Log.d("Retrofit Get", "Jumlah data Item: " + String.valueOf(infoList.size()));
                mAdapter = new InfoAdapter(infoList, getContext());
                rv_card.setAdapter(mAdapter);
                runAnim(rv_card);

            }

            @Override
            public void onFailure(Call<GetInfo> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
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
