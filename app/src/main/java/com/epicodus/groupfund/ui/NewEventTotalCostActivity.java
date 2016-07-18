package com.epicodus.groupfund.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.epicodus.groupfund.R;

public class NewEventTotalCostActivity extends AppCompatActivity {
    public static final String TAG = NewEventTotalCostActivity.class.getSimpleName();
    private Button mNewTotalCostToInviteButton;
    private EditText mNewTotalCostEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event_total_cost);
//        NewEventTotalCostInputField
        mNewTotalCostEditText = (EditText) findViewById(R.id.newTotalCostEditText);
//        InviteButton
        mNewTotalCostToInviteButton = (Button) findViewById(R.id.inviteButton);
        mNewTotalCostToInviteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String totalCost = mNewTotalCostEditText.getText().toString();
                Log.d(TAG, totalCost);
                Intent intent = new Intent(NewEventTotalCostActivity.this, InviteActivity.class);
                intent.putExtra("totalCost", totalCost);
                startActivity(intent);
            }
        });
    }
}
