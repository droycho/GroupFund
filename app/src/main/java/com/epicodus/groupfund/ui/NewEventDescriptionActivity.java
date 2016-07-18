package com.epicodus.groupfund.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.epicodus.groupfund.R;

public class NewEventDescriptionActivity extends AppCompatActivity {
    public static final String TAG = NewEventDescriptionActivity.class.getSimpleName();
    private Button mNewDescriptionToNewTotalCostButton;
    private EditText mNewDescriptionEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event_description);
//        NewEventDescriptionInputField
        mNewDescriptionEditText = (EditText) findViewById(R.id.newDescriptionEditText);
//        NextStepButton
        mNewDescriptionToNewTotalCostButton = (Button) findViewById(R.id.newDescriptionToNewTotalCostButton);
        mNewDescriptionToNewTotalCostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String description = mNewDescriptionEditText.getText().toString();
                Log.d(TAG, description);
                Intent intent = new Intent(NewEventDescriptionActivity.this, NewEventTotalCostActivity.class);
                intent.putExtra("description", description);
                startActivity(intent);
            }
        });
    }
}
