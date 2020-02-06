package android.example.com.notification.Adapter;

import android.content.Context;
import android.content.Intent;
import android.example.com.notification.Activity.DetailinfoActivity;
import android.example.com.notification.Model.Info;
import android.example.com.notification.Model.Reminder;
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

public class ReminderAdapter extends RecyclerView.Adapter<ReminderAdapter.InfoViewHolder>{
    final Context mcontext;
    private ArrayList<Reminder> reminderList;

    public ReminderAdapter(ArrayList<Reminder> reminder_list, Context context) {
        this.mcontext = context;
        reminderList = reminder_list;
    }



    @NonNull
    @Override
    public InfoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, final int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_reminder,parent,false);
        return new InfoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InfoViewHolder holder,final int position) {

        holder.judul_reminder.setText(reminderList.get(position).getJudul_reminder());
        holder.tanggal.setText(reminderList.get(position).getTanggal());
        holder.nama_rombel.setText(reminderList.get(position).getNama_rombel());
        holder.description.setText(reminderList.get(position).getDescription());


    }

    @Override
    public int getItemCount() {
        return (reminderList ==  null) ? 0 : reminderList.size();
    }

    public class InfoViewHolder extends RecyclerView.ViewHolder{
        public CardView card_reminder;
        public TextView judul_reminder, description, tanggal, nama_rombel;
        public InfoViewHolder(@NonNull View itemView) {
            super(itemView);
            card_reminder = itemView.findViewById(R.id.card_reminder);
            judul_reminder = itemView.findViewById(R.id.judul_reminder);
            description = itemView.findViewById(R.id.description_reminder);
            tanggal = itemView.findViewById(R.id.tanggal);
            nama_rombel = itemView.findViewById(R.id.nama_rombel);
        }
    }
}
