package com.epicodus.groupfund.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.epicodus.groupfund.R;

public class NewEventStartDateActivity extends AppCompatActivity {
    private Button mNewStartDateToNewEndDateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event_start_date);
//        NextStepButton
        mNewStartDateToNewEndDateButton = (Button) findViewById(R.id.newStartDateToNewEndDateButton);
        mNewStartDateToNewEndDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewEventStartDateActivity.this, NewEventEndDateActivity.class);
                startActivity(intent);
            }
        });

    }
}
