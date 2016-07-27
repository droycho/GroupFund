package com.epicodus.groupfund.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.epicodus.groupfund.R;
import com.epicodus.groupfund.models.Event;
import com.epicodus.groupfund.ui.EventDetailActivity;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by DJRoy on 7/19/16.
 */
public class EventListAdapter extends RecyclerView.Adapter<EventListAdapter.EventViewHolder> {
    private ArrayList<Event> mEvents = new ArrayList<>();
    private Context mContext;

    public EventListAdapter(Context context, ArrayList<Event> events) {
        mContext = context;
        mEvents = events;
    }

    @Override
    public EventListAdapter.EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.event_list_item, parent, false);
        EventViewHolder viewHolder = new EventViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(EventListAdapter.EventViewHolder holder, int position) {
        holder.bindEvent(mEvents.get(position));
    }

    @Override
    public int getItemCount() {
        return mEvents.size();
    }

    public class EventViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @Bind(R.id.eventTitleTextView) TextView mTitleTextView;
        @Bind(R.id.eventStartDateTextView) TextView mStartDateTextView;
        @Bind(R.id.eventEndDateTextView) TextView mEndDateTextView;
        @Bind(R.id.eventTotalCostTextView) TextView mTotalCostTextView;

        private Context mContext;

        public EventViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(mContext, EventDetailActivity.class);
            intent.putExtra("position", itemPosition);
            intent.putExtra("events", Parcels.wrap(mEvents));
            mContext.startActivity(intent);
        }

        public void bindEvent(Event event) {
            mTitleTextView.setText(event.getTitle());
            mStartDateTextView.setText("Start Date: " + event.getStartDate());
            mEndDateTextView.setText("End Date: " + event.getEndDate());
            mTotalCostTextView.setText("Total Cost: $ " + event.getTotalCost());
        }
    }
}
