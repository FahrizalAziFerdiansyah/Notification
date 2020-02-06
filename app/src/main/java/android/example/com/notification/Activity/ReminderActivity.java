package android.example.com.notification.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.example.com.notification.Adapter.InfoAdapter;
import android.example.com.notification.Adapter.ReminderAdapter;
import android.example.com.notification.Model.GetInfo;
import android.example.com.notification.Model.GetReminder;
import android.example.com.notification.Model.Reminder;
import android.example.com.notification.R;
import android.example.com.notification.RestApi.ApiInterface;
import android.example.com.notification.RestApi.UtilsApi;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReminderActivity extends AppCompatActivity {
    RecyclerView rv_reminder;
    ArrayList<Reminder> reminderList = new ArrayList<>();
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ApiInterface mApiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminder);
        Toolbar toolbar = findViewById(R.id.toolbar1);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Data Reminder");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ReminderActivity.this, HomeActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });
        rv_reminder = findViewById(R.id.rv_reminder);
        mApiInterface = UtilsApi.getAPIService();
        rv_reminder.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rv_reminder.setLayoutManager(mLayoutManager);

        ShowInfo();


    }
    public void ShowInfo() {
        Call<GetReminder> ItemCall = mApiInterface.getReminder();
        ItemCall.enqueue(new Callback<GetReminder>() {
            @Override
            public void onResponse(Call<GetReminder> call, Response<GetReminder>
                    response) {
                reminderList = response.body().getListDataReminder();
                Log.d("Retrofit Get", "Jumlah data Item: " + String.valueOf(reminderList.size()));
                mAdapter = new ReminderAdapter(reminderList, getApplicationContext());
                rv_reminder.setAdapter(mAdapter);
                runAnim(rv_reminder);


            }

            @Override
            public void onFailure(Call<GetReminder> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }

    private void runAnim(RecyclerView r) {
        Context context = r.getContext();
        LayoutAnimationController layoutAnimationController = AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_fall_down);
        r.setLayoutAnimation(layoutAnimationController);
        r.getAdapter().notifyDataSetChanged();
        r.scheduleLayoutAnimation();

    }
}
