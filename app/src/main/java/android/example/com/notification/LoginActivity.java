package android.example.com.notification;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.example.com.notification.Model.Siswa;
import android.example.com.notification.RestApi.ApiClient;
import android.example.com.notification.RestApi.ApiInterface;
import android.example.com.notification.RestApi.UtilsApi;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private TextView Appname, subAppname;
    private Button btnlogin;
    private EditText ET_nisn, ET_password;
    private ImageView logo;
    private Animation smalltobig, btta, btta2;
    ProgressDialog progressDialog;



    ApiInterface mApiInterface;
    SharedPreferences sharedPreferences;
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
        ET_nisn = findViewById(R.id.editText);
        ET_password = findViewById(R.id.editText2);

        //pass anim
        logo.startAnimation(smalltobig);
        Appname.startAnimation(btta);
        subAppname.startAnimation(btta);
        btnlogin.startAnimation(btta2);
        ET_nisn.startAnimation(btta2);
        ET_password.startAnimation(btta2);
        mApiInterface = UtilsApi.getAPIService();
        sharedPreferences = LoginActivity.this.getSharedPreferences("remember", Context.MODE_PRIVATE);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String nisn = ET_nisn.getText().toString();
            String password = ET_password.getText().toString();
            if(nisn.equals("")) {
                Toast.makeText(LoginActivity.this, "NISN Harus Diisi", Toast.LENGTH_SHORT).show();
            }else  if(password.equals("")) {
                Toast.makeText(LoginActivity.this, "Password Harus Diisi", Toast.LENGTH_SHORT).show();
            } else {
                progressDialog =new ProgressDialog(LoginActivity.this);
                progressDialog.setMessage("Mohon Tunggu...");
                progressDialog.show();

                retrofit2.Call<Siswa> postLogin=mApiInterface.postLogin(nisn,password);
                postLogin.enqueue(new Callback<Siswa>() {
                    @Override
                    public void onResponse(Call<Siswa> call, Response<Siswa> response) {
                        progressDialog.dismiss();

                    }

                    @Override
                    public void onFailure(Call<Siswa> call, Throwable t) {

                    }
                });
            }
            }
        });

    }
}
