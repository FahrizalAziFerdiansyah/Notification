package android.example.com.notification.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.example.com.notification.R;
import android.os.Bundle;
import android.os.Handler;

import com.airbnb.lottie.LottieAnimationView;

public class ScreenActivity extends AppCompatActivity {

    private LottieAnimationView animationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen);

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
                Intent home = new Intent(ScreenActivity.this, LoginActivity.class);
                startActivity(home);
                finish();

            }
        },5000);
    }
}
