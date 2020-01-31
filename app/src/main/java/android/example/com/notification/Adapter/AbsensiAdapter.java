package android.example.com.notification.Adapter;

import android.example.com.notification.Model.Absensi;
import android.example.com.notification.Model.Pelajaran;
import android.example.com.notification.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AbsensiAdapter extends RecyclerView.Adapter<AbsensiAdapter.MyViewHolder> {
    private ArrayList<Absensi> absensiList;

    public AbsensiAdapter(ArrayList<Absensi> mListAbsensi) {

        absensiList = mListAbsensi;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_absensi,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.keterangan.setText(absensiList.get(position).getKeterangan());
        holder.jumlah.setText(absensiList.get(position).getJumlah());

    }

    @Override
    public int getItemCount() {
        return absensiList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView keterangan,jumlah;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            keterangan=itemView.findViewById(R.id.keterangan);
            jumlah=itemView.findViewById(R.id.jumlah);
        }
    }
}
