package android.example.com.notification;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.example.com.notification.Firebase.SharedPrefManager;
import android.example.com.notification.Model.PostDevices;
import android.example.com.notification.RestApi.ApiClient;
import android.example.com.notification.RestApi.ApiInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //defining views
    private Button buttonDisplayToken;
    private TextView textViewToken;
    private EditText nisn,password;
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nisn=findViewById(R.id.nisn);
        password=findViewById(R.id.password);
        buttonDisplayToken = (Button) findViewById(R.id.buttonDisplayToken);
        apiInterface= ApiClient.getClient().create(ApiInterface.class);
        //adding listener to view
        buttonDisplayToken.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == buttonDisplayToken) {
            String token = SharedPrefManager.getInstance(this).getDeviceToken();
            Log.e("Token",token);
            Call<PostDevices> postDevicesCall=apiInterface.postDevice(nisn.getText().toString(),password.getText().toString(),token);
            postDevicesCall.enqueue(new Callback<PostDevices>() {
                @Override
                public void onResponse(Call<PostDevices> call, Response<PostDevices> response) {

                    Toast.makeText(MainActivity.this,"Berhasil",Toast.LENGTH_LONG).show();
                }

                @Override
                public void onFailure(Call<PostDevices> call, Throwable t) {
                    Toast.makeText(MainActivity.this,"Gagal",Toast.LENGTH_LONG).show();
                }
            });
            //getting token from shared preferences

            /*if token is not null
            if (token != null) {
                //displaying the token
                textViewToken.setText(token);
            } else {
                //if token is null that means something wrong
                textViewToken.setText("Token not generated");
            }*/
        }

    }
}
