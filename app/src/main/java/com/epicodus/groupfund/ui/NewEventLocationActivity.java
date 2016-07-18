package com.epicodus.groupfund.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.epicodus.groupfund.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NewEventLocationActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = NewEventLocationActivity.class.getSimpleName();
    @Bind(R.id.newLocationToNewDescriptionButton) Button mNewLocationToNewDescriptionButton;
    @Bind(R.id.newLocationEditText) EditText mNewLocationEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event_location);
        ButterKnife.bind(this);
//        GetDataFromNewTitleAndNewStartDateAndNewEndDate
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String startDate = intent.getStringExtra("startDate");
        String endDate = intent.getStringExtra("endDate");
//        NewEventLocationInputField
        mNewLocationToNewDescriptionButton.setOnClickListener(this);
    }
            @Override
            public void onClick(View view) {
//        NextStepButton
                if(view == mNewLocationToNewDescriptionButton) {
                String location = mNewLocationEditText.getText().toString();
                Log.d(TAG, location);
                Intent intent = new Intent(NewEventLocationActivity.this, NewEventDescriptionActivity.class);
                intent.putExtra("location", location);
                startActivity(intent);
            }
        }
    }
