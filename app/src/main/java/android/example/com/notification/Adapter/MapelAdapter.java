package android.example.com.notification.Adapter;

import android.content.Intent;
import android.example.com.notification.Activity.AbsensiActivity;
import android.example.com.notification.Model.Mapel;
import android.example.com.notification.Model.Pelajaran;
import android.example.com.notification.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MapelAdapter extends RecyclerView.Adapter<MapelAdapter.MyViewHolder> {


    private ArrayList<Mapel> mapelList;

    public MapelAdapter(ArrayList<Mapel> mListMapel) {

        mapelList = mListMapel;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_jadwal,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.nama_kateegori.setText(mapelList.get(position).getNama_kategori());
        holder.waktu_mulai.setText(mapelList.get(position).getWaktu_mulai());
        holder.gtk.setText(mapelList.get(position).getNama_gtk());
   /*     holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent= new Intent(v.getContext(), AbsensiActivity.class);
                mIntent.putExtra("id_pelajaran",pelajaranList.get(position).getId_pelajaran());
                mIntent.putExtra("nama_pelajaran",pelajaranList.get(position).getNama_pelajaran());
                v.getContext().startActivity(mIntent);
            }
        });*/

    }

    @Override
    public int getItemCount() {
        return (mapelList ==  null) ? 0 : mapelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nama_kateegori,waktu_mulai,gtk;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nama_kateegori=itemView.findViewById(R.id.nama_kategori);
            waktu_mulai=itemView.findViewById(R.id.waktu_mulai);
            gtk=itemView.findViewById(R.id.gtk);
        }
    }
}
