package com.epicodus.groupfund.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.epicodus.groupfund.R;

public class NewEventTotalCostActivity extends AppCompatActivity {
    private Button mNewTotalCostToInviteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event_total_cost);
//        InviteButton
        mNewTotalCostToInviteButton = (Button) findViewById(R.id.inviteButton);
        mNewTotalCostToInviteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewEventTotalCostActivity.this, InviteActivity.class);
                startActivity(intent);
            }
        });
    }
}
