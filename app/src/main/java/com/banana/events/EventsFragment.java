package com.banana.events;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.banana.events.EventAdapter;
import com.banana.events.MainActivity;
import com.banana.events.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

public class EventsFragment extends android.support.v4.app.Fragment {



    EventAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_events, container,false);

        Context context = getContext();

        Activity activity = getActivity();



        adapter = new EventAdapter((MainActivity) activity);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(context, 2));

        return view;

    }


    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(EventsFragment.this);
    }


    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(EventsFragment.this);
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(Database.OnMovieChangedEvent event) {
        adapter.events = Database.EVENTS;
        adapter.notifyDataSetChanged();
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onMessageEvent(FilterActivity.OnFilterChangedEvent event) {
        Log.v("PRIVET", "onlyFree=" + event.onlyFree);
        ArrayList<Event> a = new ArrayList<>();
        for(Event e : Database.EVENTS){
            if(e.eventCost == event.onlyFree){
                a.add(e);
            }
        }
        adapter.events = a;
        adapter.notifyDataSetChanged();
    }


    public static EventsFragment newInstance (){
        EventsFragment fragment = new EventsFragment();
        Bundle arguments = new Bundle();;
        fragment.setArguments(arguments);

        return fragment;
    }

}
