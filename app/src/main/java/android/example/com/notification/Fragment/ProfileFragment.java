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

    TextView nama_s, nisn, jk, rombel, ttl, alamat;
    Button btnlogout;
    boolean ceklogin;
    ApiInterface mApiInterface;
    SharedPreferences.Editor editor;
    SharedPreferences sharedPreferences;
    String tempat_lahir, tanggal_lahir;


    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        nama_s = view.findViewById(R.id.nama_siswa);
        nisn = view.findViewById(R.id.nisn_profil);
        jk = view.findViewById(R.id.jk_profil);
        rombel = view.findViewById(R.id.nama_rombel);
        ttl = view.findViewById(R.id.ttl);
        alamat = view.findViewById(R.id.alamat);
        btnlogout = view.findViewById(R.id.btnlogout);
        mApiInterface = UtilsApi.getAPIService();
        sharedPreferences = getActivity().getSharedPreferences("remember", Context.MODE_PRIVATE);
        editor =  sharedPreferences.edit();


        String nama = sharedPreferences.getString("nama_siswa", "1");
        nama_s.setText(nama);
        String nisn1 = sharedPreferences.getString("nisn", "2");
        nisn.setText(nisn1);
        String rombel1 = sharedPreferences.getString("nama_rombel", "3");
        rombel.setText(rombel1);
        String jenis_kelamin_siswa = sharedPreferences.getString("jenis_kelamin_siswa", "5");
        if(jenis_kelamin_siswa.equals("P")){
            jk.setText("Perempuan");
        } else if (jenis_kelamin_siswa.equals("L")){
            jk.setText("Laki-laki");
        }

         tempat_lahir = sharedPreferences.getString("tempat_lahir","6");
        tanggal_lahir = sharedPreferences.getString("tanggal_lahir","7");
        ttl.setText(tempat_lahir+","+tanggal_lahir);
        String alamat1 = sharedPreferences.getString("alamat", "8");
        alamat.setText(alamat1);

        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent m = new Intent(v.getContext(), LoginActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                editor.clear();
                editor.commit();
                v.getContext().startActivity(m);
                getActivity().finish();

            }
        });
        return view;
    }


}
