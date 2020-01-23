package android.example.com.notification.Fragment;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.example.com.notification.R;
import android.widget.ImageView;
import android.widget.TextView;


public class HomeFragment extends Fragment {
    TextView nama_siswa, nisn, menu1, menu2, menu3, menu4, menu;
    ImageView foto_siswa;


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
        return view;
    }



}
