package com.epicodus.groupfund.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.epicodus.groupfund.Constants;
import com.epicodus.groupfund.R;
import com.epicodus.groupfund.models.Event;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NewEventTitleActivity extends AppCompatActivity implements View.OnClickListener {
    private DatabaseReference mEventReference;

    @Bind(R.id.newEventSubmitButton) Button mNewEventSubmitButton;
    @Bind(R.id.newEventToHomeButton) Button mNewEventToHomeButton;
    @Bind(R.id.newTitleEditText) EditText mNewTitleEditText;
    @Bind(R.id.newStartDateEditText) EditText mNewStartDateEditText;
    @Bind(R.id.newEndDateEditText) EditText mNewEndDateEditText;
    @Bind(R.id.newLocationEditText) EditText mNewLocationEditText;
    @Bind(R.id.newDescriptionEditText) EditText mNewDescriptionEditText;
    @Bind(R.id.newTotalCostEditText) EditText mNewTotalCostEditText;
    @Bind(R.id.newMembersEditText) EditText mNewMembersEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mEventReference = FirebaseDatabase
                .getInstance()
                .getReference()
                .child(Constants.FIREBASE_CHILD_EVENT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event_title);
        ButterKnife.bind(this);

        // NewEventTitleInputField
        mNewEventSubmitButton.setOnClickListener(this);
        mNewEventToHomeButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        // EventSubmitButton

        if (view == mNewEventSubmitButton) {
            String title = mNewTitleEditText.getText().toString();
            String startDate = mNewStartDateEditText.getText().toString();
            String endDate = mNewEndDateEditText.getText().toString();
            String location = mNewLocationEditText.getText().toString();
            String description = mNewDescriptionEditText.getText().toString();
            String totalCost = mNewTotalCostEditText.getText().toString();
            String members = mNewMembersEditText.getText().toString();

            Event eventToWrite = new Event(title, startDate, endDate, location, description, totalCost, members);
            saveEventToFirebase(eventToWrite);

            Intent intent = new Intent(NewEventTitleActivity.this, HomeActivity.class);
            intent.putExtra("title", title);
            intent.putExtra("startDate", startDate);
            intent.putExtra("endDate", endDate);
            intent.putExtra("location", location);
            intent.putExtra("description", description);
            intent.putExtra("totalCost", totalCost);
            intent.putExtra("members", members);
            startActivity(intent);
        }

        // GoHomeFromNewEventFormButton
        if (view == mNewEventToHomeButton) {
            Intent intent = new Intent(NewEventTitleActivity.this, HomeActivity.class);
            startActivity(intent);
        }
    }

    public void saveEventToFirebase(Event newEvent) {
        mEventReference.push().setValue(newEvent);
    }
}

