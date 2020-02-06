package android.example.com.notification.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.example.com.notification.Fragment.HomeFragment;
import android.example.com.notification.Model.Info;
import android.example.com.notification.R;
import android.example.com.notification.RestApi.ApiInterface;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

public class DetailinfoActivity extends AppCompatActivity {
    ApiInterface mApiInterface;
    private ProgressBar progressBar;
    TextView judul, tgl_publish, description;
    ImageView img_Full, img;
    private String img_info, s_title, s_tglPublish, s_description, coba;
    private int runTime;

    private String build;
    public static final String STATE_LIST = "state_list";
    private Info info;
    private String[] name;
    private StringBuilder stringBuilder;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail2);

        judul = findViewById(R.id.judul_detail);
        tgl_publish = findViewById(R.id.tgl_publish);
        description = findViewById(R.id.description_detail);
        img = findViewById(R.id.gambar_detail);
        img_Full = findViewById(R.id.gambarfull_detail);


//
        Intent m = getIntent();
        judul.setText(m.getStringExtra("judul"));
        tgl_publish.setText(m.getStringExtra("tgl_publish"));
        description.setText(m.getStringExtra("description"));
        Picasso.with(DetailinfoActivity.this).load("http://sdbadean1.xyz//vendor/assets/images/info/"+m.getStringExtra("gambar")).resize(0,300).into(img_Full);
        Picasso.with(DetailinfoActivity.this).load("http://sdbadean1.xyz//vendor/assets/images/info/"+m.getStringExtra("gambar")).resize(160, 127).into(img);


    }
}
