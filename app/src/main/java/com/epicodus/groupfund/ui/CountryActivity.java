package com.epicodus.groupfund.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.epicodus.groupfund.R;
import com.epicodus.groupfund.services.TravelbriefingService;

import java.io.IOException;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class CountryActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = CountryActivity.class.getSimpleName();
    @Bind(R.id.countryNameEditText) EditText mCountryNameEditText;
    @Bind(R.id.countrySubmitButton) Button mCountrySubmitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String country = intent.getStringExtra("country");

        mCountrySubmitButton.setOnClickListener(this);
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
                try {
                    String jsonData = response.body().string();
                    Log.v(TAG, jsonData);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        if(v == mCountrySubmitButton) {
            String country = mCountryNameEditText.getText().toString();
            Intent intent = new Intent(CountryActivity.this, CountryDetailsActivity.class);
            intent.putExtra("country", country);
            startActivity(intent);
        }
    }
}
