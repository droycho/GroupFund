package com.epicodus.groupfund.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.epicodus.groupfund.R;

public class HomeActivity extends AppCompatActivity {
    private ListView mUpcomingEventsListView;
    private ListView mFriendUpcomingEventsListView;
    private Button mNewEventButton;
//    TestEvents
    private String[] events = new String[] {"Test Event 1", "Test Event 2", "Test Event 3", "Test Event 4", "Test Event 5", "Test Event 6", "Test Event 7", "Test Event 8", "Test Event 9"};
    private String[] friendEvents = new String[] {"Friend Event 1", "Friend Event 2", "Friend Event 3", "Friend Event 4", "Friend Event 5", "Friend Event 6", "Friend Event 7", "Friend Event 9"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
//        UpcomingEventsListView
        mUpcomingEventsListView = (ListView) findViewById(R.id.upcomingEventsListView);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, events);
        mUpcomingEventsListView.setAdapter(adapter);

        mUpcomingEventsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String event = ((TextView)view).getText().toString();
                Toast.makeText(HomeActivity.this, event, Toast.LENGTH_LONG).show();
            }
        });
//        FriendsUpcomingEventsListView
        mFriendUpcomingEventsListView = (ListView) findViewById(R.id.friendUpcomingEventsListView);
//        CreateNewEventButton
        mNewEventButton = (Button) findViewById(R.id.newEventButton);
        mNewEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, NewEventTitleActivity.class);
                startActivity(intent);
            }
        });

    }
}
