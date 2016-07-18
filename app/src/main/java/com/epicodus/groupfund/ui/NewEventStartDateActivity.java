package com.epicodus.groupfund.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.epicodus.groupfund.R;

public class NewEventStartDateActivity extends AppCompatActivity {
    public static final String TAG = NewEventStartDateActivity.class.getSimpleName();
    private Button mNewStartDateToNewEndDateButton;
    private EditText mNewStartDateEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event_start_date);
//        NewEventStartDateInputField
        mNewStartDateEditText = (EditText) findViewById(R.id.newStartDateEditText);
//        NextStepButton
        mNewStartDateToNewEndDateButton = (Button) findViewById(R.id.newStartDateToNewEndDateButton);
        mNewStartDateToNewEndDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String startDate = mNewStartDateEditText.getText().toString();
                Log.d(TAG,startDate);
                Intent intent = new Intent(NewEventStartDateActivity.this, NewEventEndDateActivity.class);
                startActivity(intent);
            }
        });

    }
}
