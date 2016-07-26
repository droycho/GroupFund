package com.epicodus.groupfund.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.epicodus.groupfund.Constants;
import com.epicodus.groupfund.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.Bind;
import butterknife.ButterKnife;

public class InviteActivity extends AppCompatActivity implements View.OnClickListener {
    private DatabaseReference mEventReference;

    public static final String TAG = InviteActivity.class.getSimpleName();
    @Bind(R.id.newMemberEditText) EditText mNewMemberEditText;
    @Bind(R.id.addMemberButton) Button mAddMemberButton;
    @Bind(R.id.confirmButton) Button mConfirmButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mEventReference = FirebaseDatabase
                .getInstance()
                .getReference()
                .child(Constants.FIREBASE_CHILD_EVENT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invite);
        ButterKnife.bind(this);
//        Get all data inputted so far
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String startDate = intent.getStringExtra("startDate");
        String endDate = intent.getStringExtra("endDate");
        String location = intent.getStringExtra("location");
        String description = intent.getStringExtra("description");
        String totalCost = intent.getStringExtra("totalCost");
        intent.putExtra("title", title);
        intent.putExtra("startDate", startDate);
        intent.putExtra("endDate", endDate);
        intent.putExtra("location", location);
        intent.putExtra("description", description);
        intent.putExtra("totalCost", totalCost);
//        ConfirmButton
        mConfirmButton.setOnClickListener(this);
    }
            @Override
            public void onClick(View view) {
//                ConfrimEventButton
                if(view == mConfirmButton) {
                    String members = mNewMemberEditText.getText().toString();
                    String title = getIntent().getStringExtra("title");
                    String startDate = getIntent().getStringExtra("startDate");
                    String endDate = getIntent().getStringExtra("endDate");
                    String location = getIntent().getStringExtra("location");
                    String description = getIntent().getStringExtra("description");
                    String totalCost = getIntent().getStringExtra("totalCost");
                    Log.d(TAG, members);
                    saveEventToFirebase(title, startDate, endDate, location, description, totalCost, members);
                    Intent intent = new Intent(InviteActivity.this, HomeActivity.class);
                    intent.putExtra("title", title);
                    intent.putExtra("startDate", startDate);
                    intent.putExtra("endDate", endDate);
                    intent.putExtra("location", location);
                    intent.putExtra("description", description);
                    intent.putExtra("totalCost", totalCost);
                    intent.putExtra("members", members);
                    startActivity(intent);
            }
        }
    public void saveEventToFirebase(String title, String startDate, String endDate, String location, String description, String totalCost, String members) {
        mEventReference.push().setValue(title);
        mEventReference.push().setValue(startDate);
        mEventReference.push().setValue(endDate);
        mEventReference.push().setValue(location);
        mEventReference.push().setValue(description);
        mEventReference.push().setValue(totalCost);
        mEventReference.push().setValue(members);
    }
    }
