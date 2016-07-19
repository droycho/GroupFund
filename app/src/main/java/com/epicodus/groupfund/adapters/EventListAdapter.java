package com.epicodus.groupfund.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.epicodus.groupfund.R;
import com.epicodus.groupfund.models.Event;

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
    public EventListAdapter.EventViewHolder onCreate ViewHolder(ViewGroup parent, int viewType) {
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

    public class EventViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.eventTitleTextView) TextView mTitleTextView;
        @Bind(R.id.startDateTextView) TextView mStartDateTextView;
        @Bind(R.id.endDateTextView) TextView mEndDateTextView;
        @Bind(R.id.totalCostTextView) TextView mTotalCostTextView;
        private Context mContext;

        public EventViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindEvent(Event event) {
            mTitleTextView.setText(event.getTitle());
            mStartDateTextView.setText("Start Date: " + event.getStartDate().get(0));
            mEndDateTextView.setText("End Date: " + event.getEndDate().get(0));
            mTotalCostTextView.setText("Total Cost: $ " + event.getTotcalCost());
        }
    }
}
