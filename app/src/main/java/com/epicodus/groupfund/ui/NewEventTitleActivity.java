package com.epicodus.groupfund.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.epicodus.groupfund.R;

public class NewEventTitleActivity extends AppCompatActivity {
    private Button mNextStepButton;
    private Button mNewEventToHomeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event);
//        SubmitFormButton
        mNextStepButton = (Button) findViewById(R.id.nextStepButton);
        mNextStepButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewEventTitleActivity.this, InviteActivity.class);
                startActivity(intent);
            }
        });
//        GoHomeFromNewEventFormButton
        mNewEventToHomeButton = (Button) findViewById(R.id.newEventToHomeButton);
        mNewEventToHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewEventTitleActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });

    }
}
