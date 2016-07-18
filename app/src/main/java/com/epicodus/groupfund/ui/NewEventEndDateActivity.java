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

public class NewEventEndDateActivity extends AppCompatActivity {
    public static final String TAG = NewEventEndDateActivity.class.getSimpleName();
    @Bind(R.id.newEndDateToNewLocationButton) Button mNewEndDateToNewLocationButton;
    @Bind(R.id.newEndDateEditText) EditText mNewEndDateEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event_end_date);
        ButterKnife.bind(this);
//        GetDataFromNewTitleAndNewStartDate
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String startDate = intent.getStringExtra("startDate");
//        NewEventEndDateInputField
//        mNewEndDateEditText = (EditText) findViewById(R.id.newEndDateEditText);
//        NextStepButton
        mNewEndDateToNewLocationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String endDate = mNewEndDateEditText.getText().toString();
                Log.d(TAG, endDate);
                Intent intent = new Intent(NewEventEndDateActivity.this, NewEventLocationActivity.class);
                intent.putExtra("endDate", endDate);
                startActivity(intent);
            }
        });
    }
}
