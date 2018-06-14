package com.banana.events;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<viewHolder> {

    public List<Event> events = new ArrayList<>();

    MainActivity activity;

    public EventAdapter(MainActivity activity){
       this.activity = activity;
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(activity);
        View view =inflater.inflate(R.layout.maket1, parent, false);
        viewHolder viewHolder = new viewHolder(view);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(viewHolder holder, final int position) {
        final Event event = events.get(position);
        String title = event.name;
        String eevent = event.picture1;
        holder.titleTextView.setText(title);
        Glide.with(activity)
                .load(eevent)
                .apply(RequestOptions.centerCropTransform())
                .into(holder.Image_View);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Event event = events.get(position);
                showEventFragment(event);
            }
        });

    }


    public int getItemCount() {
        return events.size();
    }

     private void showEventFragment(Event event){
         EventFragment fragment = EventFragment.newInstance(event);
         activity.getSupportFragmentManager().beginTransaction().replace(R.id.content, fragment).commit();
    }

}
