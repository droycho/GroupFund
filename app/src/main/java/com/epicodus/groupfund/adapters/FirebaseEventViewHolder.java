package com.epicodus.groupfund.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.epicodus.groupfund.Constants;
import com.epicodus.groupfund.R;
import com.epicodus.groupfund.models.Event;
import com.epicodus.groupfund.ui.EventDetailActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.parceler.Parcels;

import java.util.ArrayList;

/**
 * Created by DJRoy on 7/26/16.
 */
public class FirebaseEventViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    View mView;
    Context mContext;

    public FirebaseEventViewHolder (View itemView) {
        super(itemView);
        mView = itemView;
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
    }

    public void bindEvent(Event event) {
        TextView titleTextView = (TextView) mView.findViewById(R.id.eventTitleTextView);
        TextView startDateTextView = (TextView) mView.findViewById(R.id.eventStartDateTextView);
        TextView endDateTextView = (TextView) mView.findViewById(R.id.eventEndDateTextView);
        TextView locationTextView = (TextView) mView.findViewById(R.id.eventLocationTextView);
        TextView descriptionTextView = (TextView) mView.findViewById(R.id.eventDescriptionTextView);
        TextView totalCostTextView = (TextView) mView.findViewById(R.id.eventTotalCostTextView);
        TextView memberTextView = (TextView) mView.findViewById(R.id.eventMemberTextView);

        titleTextView.setText(event.getTitle());
        startDateTextView.setText("Event Start Date: " + event.getStartDate());
        endDateTextView.setText("Event End Date: " + event.getEndDate());
        locationTextView.setText(event.getLocation());
        descriptionTextView.setText(event.getDescription());
        totalCostTextView.setText("$ " + event.getTotalCost());
        memberTextView.setText("Participants: " + event.getMembers());
        Log.d("title", event.getStartDate());
    }

    @Override
    public void onClick (View view) {
        final ArrayList<Event> events = new ArrayList<>();
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference(Constants.FIREBASE_CHILD_EVENT);
        ref.addListenerForSingleValueEvent(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    events.add(snapshot.getValue(Event.class));
                }

                int itemPosition = getLayoutPosition();

                Intent intent = new Intent (mContext, EventDetailActivity.class);
                intent.putExtra("position", itemPosition + "");
                intent.putExtra("events", Parcels.wrap(events));

                mContext.startActivity(intent);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
