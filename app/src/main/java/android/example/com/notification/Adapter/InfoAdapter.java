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

import java.util.ArrayList;

public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.InfoViewHolder>{
    private Context context;
    private ArrayList<Info> infoModelArrayList;

    public InfoAdapter(Context context, ArrayList<Info> infoModelArrayList) {
        this.context = context;
        this.infoModelArrayList = infoModelArrayList;
    }

    @NonNull
    @Override
    public InfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new InfoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InfoViewHolder holder, int position) {
        Info model = infoModelArrayList.get(position);

        holder.titlecard.setText(model.getTittle());
        holder.description.setText(model.getDesc());
        holder.card_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(context, )
            }
        });

    }

    @Override
    public int getItemCount() {
        return infoModelArrayList.size();
    }

    public class InfoViewHolder extends RecyclerView.ViewHolder{
        CardView card_info;
//        ImageView image;
        TextView titlecard, description;
        public InfoViewHolder(@NonNull View itemView) {
            super(itemView);
            card_info = itemView.findViewById(R.id.card_info);
//            image = itemView.findViewById(R.id.image);
            titlecard = itemView.findViewById(R.id.titlecard);
            description = itemView.findViewById(R.id.desc_card);
        }
    }
}
