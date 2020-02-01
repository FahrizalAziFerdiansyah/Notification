package android.example.com.notification.Fragment;

import android.content.Context;
import android.example.com.notification.Adapter.NotifikasiAdapter;
import android.example.com.notification.Model.NotifikasiModel;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.example.com.notification.R;

import java.util.ArrayList;


public class NotifFragment extends Fragment {
    RecyclerView rv_notifikasi;
    ArrayList<NotifikasiModel> notifikasiModelArrayList = new ArrayList<>();

    public NotifFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_notif, container, false);

        rv_notifikasi = view.findViewById(R.id.rv_notifikasi);

        NotifikasiModel model1 = new NotifikasiModel("Kehadiran Siswa","10-08-2019","11.30","H");
        NotifikasiModel model2 = new NotifikasiModel("Kehadiran Siswa","10-08-2019","11.30","H");
        NotifikasiModel model3 = new NotifikasiModel("Kehadiran Siswa","10-08-2019","11.30","H");

        notifikasiModelArrayList.add(model1);
        notifikasiModelArrayList.add(model2);
        notifikasiModelArrayList.add(model3);
        NotifikasiAdapter adapter = new NotifikasiAdapter(getActivity().getApplicationContext(),notifikasiModelArrayList);
        rv_notifikasi.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        rv_notifikasi.setAdapter(adapter);

        return view;



    }

}
