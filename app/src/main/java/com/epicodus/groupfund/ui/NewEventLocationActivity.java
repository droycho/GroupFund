package com.epicodus.groupfund.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.epicodus.groupfund.R;

public class NewEventLocationActivity extends AppCompatActivity {
    private Button mNewLocationToNewDescriptionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event_location);
//        NextStepButton
        mNewLocationToNewDescriptionButton = (Button) findViewById(R.id.newLocationToNewDescriptionButton);
        mNewLocationToNewDescriptionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewEventLocationActivity.this, NewEventDescriptionActivity.class);
                startActivity(intent);
            }
        });
    }
}
