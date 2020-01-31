package android.example.com.notification.Adapter;

import android.content.Context;
import android.content.Intent;
import android.example.com.notification.Activity.AbsensiActivity;
import android.example.com.notification.Model.Info;
import android.example.com.notification.Model.Pelajaran;
import android.example.com.notification.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class PelajaranAdapter extends RecyclerView.Adapter<PelajaranAdapter.MyViewHolder> {


    private ArrayList<Pelajaran> pelajaranList;

    public PelajaranAdapter(ArrayList<Pelajaran> mListPelajaran) {

        pelajaranList = mListPelajaran;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pelajaran,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.nama_pelajaran.setText(pelajaranList.get(position).getNama_pelajaran());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mIntent= new Intent(v.getContext(), AbsensiActivity.class);
                mIntent.putExtra("id_pelajaran",pelajaranList.get(position).getId_pelajaran());
                mIntent.putExtra("nama_pelajaran",pelajaranList.get(position).getNama_pelajaran());
                v.getContext().startActivity(mIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return pelajaranList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nama_pelajaran;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nama_pelajaran=itemView.findViewById(R.id.nama_pelajaran);
        }
    }
}
