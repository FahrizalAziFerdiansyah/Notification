package android.example.com.notification;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DashbordActivity extends AppCompatActivity {
    TextView nama_siswa, nisn, menu1, menu2, menu3, menu4, menu;

    ImageView foto_siswa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashbord);

        nama_siswa = findViewById(R.id.nama_siswa);
        nisn = findViewById(R.id.nisn);
        foto_siswa = findViewById(R.id.foto_siswa);
        menu1 = findViewById(R.id.menu1);
        menu2 = findViewById(R.id.menu2);
        menu3 = findViewById(R.id.menu3);
        menu4 = findViewById(R.id.menu4);
        menu = findViewById(R.id.mainMenu);


        //import Font
        Typeface MLight = Typeface.createFromAsset(getAssets(),"fonts/ML.ttf");
        Typeface MMedium = Typeface.createFromAsset(getAssets(), "fonts/MM.ttf");
        Typeface MReguler = Typeface.createFromAsset(getAssets(), "fonts/MR.ttf");

        // custom font
        nama_siswa.setTypeface(MMedium);
        nisn.setTypeface(MLight);

        menu.setTypeface(MReguler);

        menu1.setTypeface(MMedium);
        menu2.setTypeface(MMedium);
        menu3.setTypeface(MMedium);
        menu4.setTypeface(MMedium);


    }
}
