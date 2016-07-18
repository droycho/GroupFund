package com.epicodus.groupfund.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.epicodus.groupfund.R;

public class NewEventEndDateActivity extends AppCompatActivity {
    private Button mNewEndDateToNewLocationButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event_end_date);
//        NextStepButton
        mNewEndDateToNewLocationButton = (Button) findViewById(R.id.newEndDateToNewLocationButton);
        mNewEndDateToNewLocationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewEventEndDateActivity.this, NewEventLocationActivity.class);
                startActivity(intent);
            }
        });
    }
}
