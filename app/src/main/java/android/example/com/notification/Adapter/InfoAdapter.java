package android.example.com.notification.Adapter;

import android.content.Context;
import android.content.Intent;
import android.example.com.notification.Activity.DetailinfoActivity;
import android.example.com.notification.Model.Info;
import android.example.com.notification.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.InfoViewHolder>{
   final   Context mcontext;
   private ArrayList<Info> infoList;

    public InfoAdapter(ArrayList<Info> info_list, Context context) {
        this.mcontext = context;
        infoList = info_list;
    }



    @NonNull
    @Override
    public InfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent,final int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new InfoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InfoViewHolder holder,final int position) {
//        Glide.with(mcontext)
//                .load("http://192.168.43.103/sdbadean/index.php/vendor/assets/images/info/"+infoList.get(position).getGambar())
//                .apply(new RequestOptions().transform(new RoundedCorners(50)))
//                .into(holder.gambar_info);
        final String urlGambarBerita = "http://sdbadean1.xyz//vendor/assets/images/info/" + infoList.get(position).getGambar();
        Picasso.with(mcontext).load(urlGambarBerita).resize(250,150).into(holder.gambar_info);
        holder.judul.setText(infoList.get(position).getJudul());
        holder.tgl_publish.setText(infoList.get(position).getTgl_publish());
        holder.description.setText(infoList.get(position).getDescription());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent m = new Intent(v.getContext(), DetailinfoActivity.class);
                m.putExtra("judul", infoList.get(position).getJudul());
                m.putExtra("tgl_publish", infoList.get(position).getTgl_publish());
                m.putExtra("description", infoList.get(position).getDescription());
                m.putExtra("gambar", infoList.get(position).getGambar());
                v.getContext().startActivity(m);

            }
        });

    }

    @Override
    public int getItemCount() {
        return (infoList ==  null) ? 0 : infoList.size();
    }

    public class InfoViewHolder extends RecyclerView.ViewHolder{
        public CardView card_info;
        public ImageView gambar_info;
        public TextView judul, description, tgl_publish;
        public InfoViewHolder(@NonNull View itemView) {
            super(itemView);
            card_info = itemView.findViewById(R.id.card_info);
            gambar_info = itemView.findViewById(R.id.gambar);
            judul = itemView.findViewById(R.id.judul);
            description = itemView.findViewById(R.id.description);
            tgl_publish = itemView.findViewById(R.id.tgl_publish);


        }
    }
}
