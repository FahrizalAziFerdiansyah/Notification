package android.example.com.notification;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
    private TextView Appname, subAppname;
    private Button btnlogin;
    private EditText ET_email, ET_password;
    private ImageView logo;
    private Animation smalltobig, btta, btta2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //i
        smalltobig = AnimationUtils.loadAnimation(this, R.anim.smalltobig);
        btta = AnimationUtils.loadAnimation(this, R.anim.btta);
        btta2 = AnimationUtils.loadAnimation(this, R.anim.btta2);
        logo = findViewById(R.id.logo);
        Appname = findViewById(R.id.Appname);
        subAppname = findViewById(R.id.subName);
        btnlogin = findViewById(R.id.button);
        ET_email = findViewById(R.id.editText);
        ET_password = findViewById(R.id.editText2);

        //pass anim
        logo.startAnimation(smalltobig);
        Appname.startAnimation(btta);
        subAppname.startAnimation(btta);
        btnlogin.startAnimation(btta2);
        ET_email.startAnimation(btta2);
        ET_password.startAnimation(btta2);
    }
}
