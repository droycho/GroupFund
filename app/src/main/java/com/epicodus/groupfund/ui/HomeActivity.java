package com.epicodus.groupfund.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.epicodus.groupfund.R;
import com.epicodus.groupfund.adapters.EventListAdapter;
import com.epicodus.groupfund.models.Event;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity {
    public static final String TAG = HomeActivity.class.getSimpleName();
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private EventListAdapter mAdapter;
    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;
    @Bind(R.id.upcomingEventsListView) ListView mUpcomingEventsListView;
    @Bind(R.id.friendUpcomingEventsListView) ListView mFriendUpcomingEventsListView;
    @Bind(R.id.newEventButton) Button mNewEventButton;

    public ArrayList<Event> mEvents = new ArrayList<>();
//    TestEvents
    private String[] events = new String[] {"Test Event 1", "Test Event 2", "Test Event 3", "Test Event 4", "Test Event 5", "Test Event 6", "Test Event 7", "Test Event 8", "Test Event 9"};
    private String[] friendEvents = new String[] {"Friend Event 1", "Friend Event 2", "Friend Event 3", "Friend Event 4", "Friend Event 5", "Friend Event 6", "Friend Event 7", "Friend Event 9"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    getSupportActionBar().setTitle("Welcome,  " + user.getDisplayName() + "!");
                }else {

                }
            }
        };
//        UpcomingEventsListView
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, events);
        mUpcomingEventsListView.setAdapter(adapter);

        mUpcomingEventsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String event = ((TextView)view).getText().toString();
                Toast.makeText(HomeActivity.this, event, Toast.LENGTH_LONG).show();
            }
        });

//        CreateNewEventButton
        mNewEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, NewEventTitleActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_logout) {
            logout();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void logout() {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

}
