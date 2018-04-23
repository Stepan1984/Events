package com.banana.events;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class EventAdapter extends RecyclerView.Adapter<viewHolder> {



    MainActivity activity;

    public EventAdapter(MainActivity activity){
        MainActivity a
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view =inflater.inflate(R.layout.maket1, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(viewHolder holder, int position) {
        final Event event = Database.EVENTS[position];
        String title = event.name;
        String eevent = event.picture1;
        holder.titleTextView.setText(title);
        String picture = "https://image.tmdb.org/t/p/original" + eevent ;
        Glide.with(context)
                .load(picture)
                .apply(RequestOptions.centerCropTransform())
                .into(holder.Image_View);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startEventActivity(event);
            }
        });

    }

    @Override
    public int getItemCount() {
        return Database.EVENTS.length;
    }
    private void showEventFragment(Event event){
        EventFragment fragment = EventFragment.newInstance(event);
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();


    }
}
