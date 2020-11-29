package com.example.wisnu;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wisnu.adapter.WisataAdapter;
import com.example.wisnu.alarm.AlarmActivity;
import com.example.wisnu.db.DBWisata;
import com.example.wisnu.model.RootPariwisataModel;
import com.example.wisnu.model.WisataItem;
import com.example.wisnu.rest.ApiConfig;
import com.example.wisnu.rest.ApiService;

import org.w3c.dom.Text;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ArrayList<WisataItem> wisataItems;
    private WisataAdapter wisataAdapter;
    private Text mAlarm;
    private SharedPreferences mPreferences;
    private String sharedPrefFile = "com.example.wisnu";
    public static DBWisata db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        wisataItems = new ArrayList<>();
        getData();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mPreferences = getSharedPreferences(sharedPrefFile,MODE_PRIVATE);

        db = DBWisata.getInstance(MainActivity.this);
    }

    private void getData() {
        ApiService apiService = ApiConfig.getApiService();
        apiService.getData().enqueue(new Callback<RootPariwisataModel>() {
            @Override
            public void onResponse(Call<RootPariwisataModel> call, Response<RootPariwisataModel> response) {
                if (response.isSuccessful()) {
                    wisataItems = response.body().getWisata();
                    wisataAdapter = new WisataAdapter(wisataItems, getApplicationContext());
                    recyclerView.setAdapter(wisataAdapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                }
            }

            @Override
            public void onFailure(Call<RootPariwisataModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, "" + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initView() {
        recyclerView = findViewById(R.id.recyclerView);
        mAlarm= findViewById(R.id.action_alarm);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_alarm:
                Intent intent = new Intent(MainActivity.this, AlarmActivity.class);
                String mOrderMessage = null;
                intent.putExtra(EXTRA_MESSAGE, mOrderMessage);
                startActivity(intent);
                return true;
            default:
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences.Editor preferencesEditor = mPreferences.edit();
        preferencesEditor.apply();
    }
}