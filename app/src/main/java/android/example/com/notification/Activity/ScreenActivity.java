package android.example.com.notification.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.example.com.notification.DashbordActivity;
import android.example.com.notification.R;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import com.airbnb.lottie.LottieAnimationView;

public class ScreenActivity extends AppCompatActivity {

    private LottieAnimationView animationView;
    SharedPreferences mSettings;
    boolean ceklogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen);

        mSettings = this.getSharedPreferences("Settings", Context.MODE_PRIVATE);
        ceklogin = mSettings.getBoolean("ceklogin", false);
        Log.e("RAG", "onCreate: " + ceklogin );

        animationView = findViewById(R.id.loadingScreen);
        animationView.addAnimatorListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                startActivity(new Intent(ScreenActivity.this, LoginActivity.class));
            }
        });
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (ceklogin){
                    Intent home = new Intent(ScreenActivity.this, HomeActivity.class);
                    startActivity(home);
                    finish();
                } else {
                    Intent home = new Intent(ScreenActivity.this, LoginActivity.class);
                    startActivity(home);
                    finish();
                }
            }
        },5000);
    }
}
