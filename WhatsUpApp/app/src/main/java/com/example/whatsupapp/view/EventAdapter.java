package com.example.whatsupapp.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.whatsupapp.R;
import com.example.whatsupapp.databinding.FragmentHomeBinding;
import com.example.whatsupapp.model.Event;

import java.util.ArrayList;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {

    private ArrayList<Event> events;
    private FragmentHomeBinding binding;
    private LayoutInflater inflater;
    private PostEventFragment.Listener mClickListener;
    private ItemClickListener iClickListener;

    // data is passed into the constructor
    EventAdapter(Context context, ArrayList<Event> events) {
        this.inflater = LayoutInflater.from(context);
        this.events = events;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.rec_row, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Event event = events.get(position);
        holder.myTextView.setText(event.toString());
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return events.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView myTextView;

        ViewHolder(View itemView) {
            super(itemView);
            myTextView = itemView.findViewById(R.id.event_name);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            if (iClickListener != null) iClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    Event getItem(int id) {
        return events.get(id);
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.iClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
