package com.epicodus.groupfund.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.epicodus.groupfund.R;

public class NewEventDescriptionActivity extends AppCompatActivity {
    private Button mNewDescriptionToNewTotalCostButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event_description);
//        NextStepButton
        mNewDescriptionToNewTotalCostButton = (Button) findViewById(R.id.newDescriptionToNewTotalCostButton);
        mNewDescriptionToNewTotalCostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewEventDescriptionActivity.this, NewEventTotalCostActivity.class);
                startActivity(intent);
            }
        });
    }
}
