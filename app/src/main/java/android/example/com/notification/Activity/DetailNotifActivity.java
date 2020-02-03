package android.example.com.notification.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.example.com.notification.Fragment.NotifFragment;
import android.example.com.notification.R;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class DetailNotifActivity extends AppCompatActivity {
    EditText etNomorHp;
    String hadir,no_wa,nama,kelas;
    ImageView btnOpenWhatsapp;
    SharedPreferences sharedPreferences;
    TextView txt_nama, txt_nisn, txt_kelas, txt_kategori, txt_gtk, kehadiran, txt_kehadiran;
    RelativeLayout wa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_notif);

        Toolbar toolbar = findViewById(R.id.toolbar1);



        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Data Absensi");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DetailNotifActivity.this, HomeActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });

        sharedPreferences = DetailNotifActivity.this.getSharedPreferences("remember", Context.MODE_PRIVATE);
        sharedPreferences.getString("nama_siswa", "1");


        txt_nisn = findViewById(R.id.txt_nisn);
        txt_nama = findViewById(R.id.txt_nama);
        txt_kelas = findViewById(R.id.txt_kelas);
        txt_gtk = findViewById(R.id.txt_gtk);
        txt_kategori = findViewById(R.id.txt_kategori);
        kehadiran = findViewById(R.id.kehadiran);
        wa = findViewById(R.id.wa);
        txt_kehadiran = findViewById(R.id.txt_kehadiran);

        Intent mIntent = getIntent();
        nama=sharedPreferences.getString("nama_siswa", "1");
        kelas=sharedPreferences.getString("nama_rombel", "1");
        txt_nama.setText(nama);
        txt_nisn.setText(sharedPreferences.getString("nisn", "1"));
        txt_kelas.setText(kelas);
        hadir = mIntent.getStringExtra("keterangan");
        no_wa=mIntent.getStringExtra("no_wa");
        txt_gtk.setText(mIntent.getStringExtra("guru"));
        txt_kategori.setText(mIntent.getStringExtra("kategori"));
        kehadiran.setText(hadir);

        if (hadir.equals("H")) {
            wa.setVisibility(View.GONE);
        } else {
            wa.setVisibility(View.VISIBLE);
        }

        if (hadir.equals("H")) {
            txt_kehadiran.setText("Hadir");
        } else if (hadir.equals("A")) {
            txt_kehadiran.setText("Alpa");
        } else if (hadir.equals("S")) {
            txt_kehadiran.setText("Sakit");
        } else if (hadir.equals("I")) {
            txt_kehadiran.setText("Ijin");
        }

        btnOpenWhatsapp = findViewById(R.id.btnOpenWhatsapp);
        btnOpenWhatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nomorHp = no_wa.substring(1);
                openWhatsApp("+62"+nomorHp);

            }
        });
    }

    private void openWhatsApp(String number) {
        String url = "https://api.whatsapp.com/send?phone=" + number+"&text=Saya orang tua dari " + nama+" Kelas "+kelas;
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
}
