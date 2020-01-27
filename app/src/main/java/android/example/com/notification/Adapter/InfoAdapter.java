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

import java.util.ArrayList;
import java.util.List;

public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.InfoViewHolder>{
     Context context;
    ArrayList<Info> infoArrayList;

    public InfoAdapter(ArrayList<Info> listinfo, Context context) {
        this.context = context;
        infoArrayList = listinfo;
    }


    @NonNull
    @Override
    public InfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new InfoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InfoViewHolder holder, int position) {
        Glide.with(context)
                .load("http://192.168.43.103/sdbadean/vendor/assets/images/"+infoArrayList.get(position).getGambar())
                .apply(new RequestOptions().transform(new RoundedCorners(50)))
                .into(holder.gambar);
        holder.judul.setText(infoArrayList.get(position).getJudul());
        holder.tgl_publish.setText(infoArrayList.get(position).getTgl_publish());
        holder.description.setText(infoArrayList.get(position).getDescription());
        holder.card_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(context, )
            }
        });

    }

    @Override
    public int getItemCount() {
        return infoArrayList.size();
    }

    public class InfoViewHolder extends RecyclerView.ViewHolder{
        public CardView card_info;
        public ImageView gambar;
        public TextView judul, description, tgl_publish;
        public InfoViewHolder(@NonNull View itemView) {
            super(itemView);
            card_info = itemView.findViewById(R.id.card_info);
            gambar = itemView.findViewById(R.id.image);
            judul = itemView.findViewById(R.id.judul);
            description = itemView.findViewById(R.id.description);
            tgl_publish = itemView.findViewById(R.id.tgl_publish);
        }
    }
}
