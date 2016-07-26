package com.epicodus.groupfund.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.epicodus.groupfund.Constants;
import com.epicodus.groupfund.R;
import com.epicodus.groupfund.models.Event;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventDetailFragment extends Fragment implements View.OnClickListener {
    @Bind(R.id.eventTitleTextView) TextView mTitleLabel;
    @Bind(R.id.eventStartDateTextView) TextView mStartDateLabel;
    @Bind(R.id.eventEndDateTextView) TextView mEndDateLabel;
    @Bind(R.id.eventLocationTextView) TextView mLocationLabel;
    @Bind(R.id.eventDescriptionTextView) TextView mDescriptionLabel;
    @Bind(R.id.eventTotalCostTextView) TextView mTotalCostLabel;
    @Bind(R.id.eventMemberTextView) TextView mMemberLabel;
    @Bind(R.id.saveEventButton) TextView mSaveEventButton;

    private Event mEvent;

    public static EventDetailFragment newInstance(Event event) {
        EventDetailFragment eventDetailFragment = new EventDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("event", Parcels.wrap(event));
        eventDetailFragment.setArguments(args);
        return eventDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mEvent = Parcels.unwrap(getArguments().getParcelable("event"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event_detail, container, false);
        ButterKnife.bind(this, view);

        mTitleLabel.setText(mEvent.getTitle());
        mStartDateLabel.setText(mEvent.getStartDate());
        mEndDateLabel.setText(mEvent.getEndDate());
        mLocationLabel.setText(mEvent.getLocation());
        mDescriptionLabel.setText(mEvent.getDescription());
        mTotalCostLabel.setText(mEvent.getTotalCost());
        mMemberLabel.setText(mEvent.getMembers());

        mSaveEventButton.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        if (view == mSaveEventButton) {
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

            Toast.makeText(getContext(), "Saved", Toast.LENGTH_SHORT).show();
        }
    }
}
