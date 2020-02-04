package android.example.com.notification.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.example.com.notification.Activity.LoginActivity;
import android.example.com.notification.RestApi.ApiInterface;
import android.example.com.notification.RestApi.UtilsApi;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.example.com.notification.R;
import android.widget.Button;
import android.widget.TextView;


public class ProfileFragment extends Fragment {

    TextView nama_s, nisn, jk, rombel;
    Button btnlogout;
    boolean ceklogin;
    ApiInterface mApiInterface;
    SharedPreferences.Editor editor;
    SharedPreferences sharedPreferences;


    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        nama_s = view.findViewById(R.id.nama_profil);
        nisn = view.findViewById(R.id.nisn_profil);
        jk = view.findViewById(R.id.jk_profil);
        rombel = view.findViewById(R.id.rombel_profil);
        btnlogout = view.findViewById(R.id.btn_logout);

        mApiInterface = UtilsApi.getAPIService();
        sharedPreferences = getActivity().getSharedPreferences("remember", Context.MODE_PRIVATE);
        editor =  sharedPreferences.edit();


        String nama = sharedPreferences.getString("nama_siswa", "1");
        nama_s.setText(nama);
        String nisn1 = sharedPreferences.getString("nisn", "2");
        nisn.setText(nisn1);
        String rombel1 = sharedPreferences.getString("nama_rombel", "3");
        rombel.setText(rombel1);
        String jk1 = sharedPreferences.getString("jenis_kelamin_siswa", "4");
        jk.setText(jk1);

        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent m = new Intent(v.getContext(), LoginActivity.class);
                editor.clear();
                editor.commit();
                v.getContext().startActivity(m);

            }
        });
        return view;
    }


}
