package com.epicodus.groupfund.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.epicodus.groupfund.R;

public class NewEventLocationActivity extends AppCompatActivity {
    public static final String TAG = NewEventLocationActivity.class.getSimpleName();
    private Button mNewLocationToNewDescriptionButton;
    private EditText mNewLocationEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event_location);
//        NewEventLocationInputField
        mNewLocationEditText = (EditText) findViewById(R.id.newLocationEditText);
//        NextStepButton
        mNewLocationToNewDescriptionButton = (Button) findViewById(R.id.newLocationToNewDescriptionButton);
        mNewLocationToNewDescriptionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String location = mNewLocationEditText.getText().toString();
                Log.d(TAG, location);
                Intent intent = new Intent(NewEventLocationActivity.this, NewEventDescriptionActivity.class);
                intent.putExtra("location", location);
                startActivity(intent);
            }
        });
    }
}
