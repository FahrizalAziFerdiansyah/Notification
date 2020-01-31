package android.example.com.notification.Adapter;

import android.content.Context;
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

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.InfoViewHolder>{
   final   Context mcontext;
   private ArrayList<Info> infoList;

    public InfoAdapter(ArrayList<Info> info_list, Context context) {
        this.mcontext = context;
        infoList = info_list;
    }



    @NonNull
    @Override
    public InfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new InfoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InfoViewHolder holder, int position) {
//        Glide.with(mcontext)
//                .load("http://192.168.43.103/sdbadean/index.php/vendor/assets/images/info/"+infoList.get(position).getGambar())
//                .apply(new RequestOptions().transform(new RoundedCorners(50)))
//                .into(holder.gambar_info);
//      final String urlGambarBerita = "http://192.168.1.2/sdbadean/vendor/assets/images/info/" + infoList.get(position).getGambar();
//        Picasso.with(mcontext).load(urlGambarBerita).into(holder.gambar_info);
        holder.judul.setText(infoList.get(position).getJudul());

        holder.tgl_publish.setText(infoList.get(position).getTgl_publish());
        holder.description.setText(infoList.get(position).getDescription());


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
