package com.epicodus.groupfund.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.epicodus.groupfund.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CountryActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.countryNameEditText) EditText mCountryNameEditText;
    @Bind(R.id.countrySubmitButton) Button mCountrySubmitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country);
        ButterKnife.bind(this);

        mCountrySubmitButton.setOnClickListener(this);
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
