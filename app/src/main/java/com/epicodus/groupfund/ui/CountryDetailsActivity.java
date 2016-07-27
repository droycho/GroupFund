package com.epicodus.groupfund.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.epicodus.groupfund.R;
import com.epicodus.groupfund.services.TravelbriefingService;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class CountryDetailsActivity extends AppCompatActivity {
    public static final String TAG = CountryActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_details);

        Intent intent = getIntent();
        String country = intent.getStringExtra("country");

        getCountry(country);
    }

    private void getCountry(String country) {
        final TravelbriefingService travelbriefingService = new TravelbriefingService();
        travelbriefingService.findCountries(country, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try{
                    String jsonData = response.body().string();
                    Log.v(TAG, jsonData);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
