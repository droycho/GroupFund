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

public class NewEventTitleActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.newTitleToNewStartDateButton) Button mNewTitleToNewStartDateButton;
    @Bind(R.id.newEventToHomeButton) Button mNewEventToHomeButton;
    @Bind(R.id.newTitleEditText) EditText mNewTitleEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event_title);
        ButterKnife.bind(this);
//        NewEventTitleInputField
        mNewTitleToNewStartDateButton.setOnClickListener(this);
        mNewEventToHomeButton.setOnClickListener(this);
    }
            @Override
            public void onClick(View view) {
//        NextStepButton
                if (view == mNewTitleToNewStartDateButton) {
                    String title = mNewTitleEditText.getText().toString();
                    Intent intent = new Intent(NewEventTitleActivity.this, NewEventStartDateActivity.class);
                    intent.putExtra("title", title);
                    startActivity(intent);
                }
//        GoHomeFromNewEventFormButton
                if (view == mNewEventToHomeButton) {
                    Intent intent = new Intent(NewEventTitleActivity.this, HomeActivity.class);
                    startActivity(intent);
                }
            }
    }

