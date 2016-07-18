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

public class NewEventDescriptionActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = NewEventDescriptionActivity.class.getSimpleName();
    @Bind(R.id.newDescriptionToNewTotalCostButton) Button mNewDescriptionToNewTotalCostButton;
    @Bind(R.id.newDescriptionEditText) EditText mNewDescriptionEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event_description);
        ButterKnife.bind(this);
//        GetDataFromNewTitleAndNewStartDateAndNewEndDateAndNewLocation
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String startDate = intent.getStringExtra("startDate");
        String endDate = intent.getStringExtra("endDate");
        String location = intent.getStringExtra("location");
//        NewEventDescriptionInputField
        mNewDescriptionToNewTotalCostButton.setOnClickListener(this);
    }
            @Override
            public void onClick(View view) {
//        NextStepButton
                if(view == mNewDescriptionToNewTotalCostButton) {
                String description = mNewDescriptionEditText.getText().toString();
                Log.d(TAG, description);
                Intent intent = new Intent(NewEventDescriptionActivity.this, NewEventTotalCostActivity.class);
                intent.putExtra("description", description);
                startActivity(intent);
            }
        }
    }
