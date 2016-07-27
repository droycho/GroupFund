package com.epicodus.groupfund.ui;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.epicodus.groupfund.Constants;
import com.epicodus.groupfund.R;
import com.epicodus.groupfund.models.Event;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NewEventTitleActivity extends AppCompatActivity implements View.OnClickListener {
    private DatabaseReference mEventReference;
    private ValueEventListener mEventReferenceListener;

    @Bind(R.id.newEventSubmitButton)
    Button mNewEventSubmitButton;
    @Bind(R.id.newEventToHomeButton)
    Button mNewEventToHomeButton;
    @Bind(R.id.newTitleEditText)
    EditText mNewTitleEditText;
    @Bind(R.id.newStartDateEditText)
    EditText mNewStartDateEditText;
    @Bind(R.id.newEndDateEditText)
    EditText mNewEndDateEditText;
    @Bind(R.id.newLocationEditText)
    EditText mNewLocationEditText;
    @Bind(R.id.newDescriptionEditText)
    EditText mNewDescriptionEditText;
    @Bind(R.id.newTotalCostEditText)
    EditText mNewTotalCostEditText;
    @Bind(R.id.newMembersEditText)
    EditText mNewMembersEditText;

    private Event mEvent;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mEventReference = FirebaseDatabase
                .getInstance()
                .getReference()
                .child(Constants.FIREBASE_CHILD_EVENT);

        mEventReferenceListener = mEventReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot titleSnapshot : dataSnapshot.getChildren()) {
                    String title = titleSnapshot.getValue().toString();
                    Log.d("Titles updated", "title: " + title);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event_title);
        ButterKnife.bind(this);

        // NewEventTitleInputField
        mNewEventSubmitButton.setOnClickListener(this);
        mNewEventToHomeButton.setOnClickListener(this);

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
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
        }
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String uid = user.getUid();
        DatabaseReference eventRef = FirebaseDatabase
                .getInstance()
                .getReference(Constants.FIREBASE_CHILD_EVENT)
                .child(uid);

        DatabaseReference pushRef = eventRef.push();
        String pushId = pushRef.getKey();
        mEvent.setPushId(pushId);
        pushRef.setValue(mEvent);


        // GoHomeFromNewEventFormButton
        if (view == mNewEventToHomeButton) {
            Intent intent = new Intent(NewEventTitleActivity.this, HomeActivity.class);
            startActivity(intent);
        }
    }

    public void saveEventToFirebase(Event newEvent) {
        mEventReference.push().setValue(newEvent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mEventReference.removeEventListener(mEventReferenceListener);
    }


    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "NewEventTitle Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.epicodus.groupfund.ui/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "NewEventTitle Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.epicodus.groupfund.ui/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}

