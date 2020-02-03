package android.example.com.notification.Adapter;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.example.com.notification.Activity.AbsensiActivity;
import android.example.com.notification.Model.InfoMapel;
import android.example.com.notification.Model.Pelajaran;
import android.example.com.notification.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class InfoMapelAdapter extends RecyclerView.Adapter<InfoMapelAdapter.MyViewHolder> {


    private ArrayList<InfoMapel> InfoMapelList;
    Context context;
    TextView mapel,deadline,keterangan;
    RelativeLayout ulangan,pr;
    SharedPreferences sharedPreferences;
    Button ok;

    public InfoMapelAdapter(ArrayList<InfoMapel> mListInfoMapel,Context context) {
        this.context = context;
        InfoMapelList = mListInfoMapel;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_info_mapel,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        sharedPreferences = context.getSharedPreferences("remember", Context.MODE_PRIVATE);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.txt_mapel.setText(InfoMapelList.get(position).getNama_pelajaran());
        holder.txt_tanggal.setText(InfoMapelList.get(position).getTanggal_informasi());
        if (InfoMapelList.get(position).getId_jenis_informasi().equals("J-1")){
            holder.ulangan.setVisibility(View.GONE);
            holder.pr.setVisibility(View.VISIBLE);

        } else if (InfoMapelList.get(position).getId_jenis_informasi().equals("J-2")){
            holder.pr.setVisibility(View.GONE);
            holder.ulangan.setVisibility(View.VISIBLE);
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("mapel",InfoMapelList.get(position).getNama_pelajaran());
                editor.putString("dateline",InfoMapelList.get(position).getDateline());
                editor.putString("ulasan" ,InfoMapelList.get(position).getUlasan_informasi());
                editor.putString("id_jenis" ,InfoMapelList.get(position).getId_jenis_informasi());
                editor.apply();
                showDialog();
            }
        });

    }

    @Override
    public int getItemCount() {
        return (InfoMapelList ==  null) ? 0 : InfoMapelList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txt_mapel,txt_tanggal;
        RelativeLayout ulangan,pr;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_mapel=itemView.findViewById(R.id.txt_mapel);
            txt_tanggal=itemView.findViewById(R.id.txt_tanggal);
            ulangan=itemView.findViewById(R.id.re1);
            pr=itemView.findViewById(R.id.re2);
        }
    }

    private void showDialog() {
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_info);

        ulangan=dialog.findViewById(R.id.re1);
        pr=dialog.findViewById(R.id.re2);
        mapel = dialog.findViewById(R.id.mapel);
        deadline = dialog.findViewById(R.id.deadline);
        keterangan = dialog.findViewById(R.id.keterangan);
        ok=dialog.findViewById(R.id.ok);
        String sMapel = sharedPreferences.getString("mapel", "1");
        String sDateline = sharedPreferences.getString("dateline", "2");
        String sUlasan = sharedPreferences.getString("ulasan", "2");
        String sJenis = sharedPreferences.getString("id_jenis", "2");

        if (sJenis.equals("J-1")){
            ulangan.setVisibility(View.GONE);
            pr.setVisibility(View.VISIBLE);
            deadline.setText("Pengumpulan : "+sDateline);

        } else if (sJenis.equals("J-2")){
            pr.setVisibility(View.GONE);
            ulangan.setVisibility(View.VISIBLE);
            deadline.setText("Dilaksanakan : "+sDateline);
        }
        mapel.setText("Pelajaran : "+sMapel);

        keterangan.setText("Deskripsi : "+sUlasan);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();

    }
}
