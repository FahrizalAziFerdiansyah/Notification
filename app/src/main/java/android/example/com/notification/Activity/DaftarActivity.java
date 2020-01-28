package android.example.com.notification.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Dialog;
import android.content.Intent;
import android.example.com.notification.R;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DaftarActivity extends AppCompatActivity implements View.OnClickListener {

    Button daftar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar);
        Toolbar toolbar = findViewById(R.id.toolbar1);
        daftar = findViewById(R.id.daftar);
        daftar.setOnClickListener(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Daftar");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DaftarActivity.this, LoginActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v == daftar) {
            showDialog();
        }
    }

    private void showDialog() {
        final Dialog dialog = new Dialog(DaftarActivity.this);
        dialog.setContentView(R.layout.dialog_daftar);
        dialog.show();

    }
}
