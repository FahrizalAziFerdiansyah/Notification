package android.example.com.notification.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.example.com.notification.Fragment.HomeFragment;
import android.example.com.notification.Model.Info;
import android.example.com.notification.R;
import android.example.com.notification.RestApi.ApiInterface;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

public class DetailinfoActivity extends AppCompatActivity {
    ApiInterface mApiInterface;
    private ProgressBar progressBar;
    TextView judul, tgl_publish, description;
     ImageView img_Full;
    private String img_info, s_title, s_tglPublish, s_description;
    private int runTime;

    private String build;
    public static final String STATE_LIST = "state_list";
    private Info info;
    private String[] name;
    private StringBuilder stringBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailinfo);

        judul = findViewById(R.id.judul_detail);
        tgl_publish = findViewById(R.id.tgl_publish);
        description = findViewById(R.id.description_detail);
        img_Full = findViewById(R.id.gambar_detail);


        Intent m = getIntent();
        judul.setText(m.getStringExtra("judul"));
        tgl_publish.setText(m.getStringExtra("tgl_publish"));
        description.setText(m.getStringExtra("description"));
        Picasso.with(DetailinfoActivity.this).load("http://192.168.43.103/sdbadean/vendor/assets/images/info/"+m.getStringExtra("gambar")).into(img_Full);


    }
}
