package com.epicodus.groupfund.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.epicodus.groupfund.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NewEventStartDateActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.newStartDateToNewEndDateButton) Button mNewStartDateToNewEndDateButton;
    @Bind(R.id.newStartDateEditText) EditText mNewStartDateEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event_start_date);
        ButterKnife.bind(this);
//        GetDataFromNewTitle
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
//        NewEventStartDateInputField
        mNewStartDateToNewEndDateButton.setOnClickListener(this);
    }
            @Override
            public void onClick(View view) {
//        NextStepButton
                if (view == mNewStartDateToNewEndDateButton) {
                    String startDate = mNewStartDateEditText.getText().toString();
                    Intent intent = new Intent(NewEventStartDateActivity.this, NewEventEndDateActivity.class);
                    intent.putExtra("startDate", startDate);
                    startActivity(intent);
                }
            }
    }

