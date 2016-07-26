package com.epicodus.groupfund.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.epicodus.groupfund.Constants;
import com.epicodus.groupfund.R;
import com.epicodus.groupfund.adapters.FirebaseEventViewHolder;
import com.epicodus.groupfund.models.Event;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SavedEventsListActivity extends AppCompatActivity {
    private DatabaseReference mEventReference;
    private FirebaseRecyclerAdapter mFirebaseAdapter;

    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        mEventReference = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_EVENT);
        setUpFirebaseAdapter();
    }

    private void setUpFirebaseAdapter() {
        mFirebaseAdapter = new FirebaseRecyclerAdapter<Event, FirebaseEventViewHolder>
                (Event.class, R.layout.event_list_item, FirebaseEventViewHolder.class,
                        mEventReference) {
            @Override
            protected void populateViewHolder (FirebaseEventViewHolder viewHolder,
                                               Event model, int position) {
                viewHolder.bindEvent(model);
            }
        };
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mFirebaseAdapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mFirebaseAdapter.cleanup();
    }
}
