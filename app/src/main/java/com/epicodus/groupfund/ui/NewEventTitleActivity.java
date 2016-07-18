package com.epicodus.groupfund.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.epicodus.groupfund.R;

public class NewEventTitleActivity extends AppCompatActivity {
    public static final String TAG = NewEventTitleActivity.class.getSimpleName();
    private Button mNewTitleToNewStartDateButton;
    private Button mNewEventToHomeButton;
    private EditText mNewTitleEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event_title);
//        NewEventTitleInputField
        mNewTitleEditText = (EditText) findViewById(R.id.newTitleEditText);
//        NextStepButton
        mNewTitleToNewStartDateButton = (Button) findViewById(R.id.newTitleToNewStartDateButton);
        mNewTitleToNewStartDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = mNewTitleEditText.getText().toString();
                Log.d(TAG, title);
                Intent intent = new Intent(NewEventTitleActivity.this, NewEventStartDateActivity.class);
                intent.putExtra("title", title);
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
