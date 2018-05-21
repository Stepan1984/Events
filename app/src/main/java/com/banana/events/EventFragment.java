package com.banana.events;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.banana.events.Event;
import com.banana.events.Movie;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class EventFragment extends Fragment {
    TextView name;
    ImageView imageEvent;


    public static EventFragment newInstance (Event event){
        EventFragment fragment = new EventFragment();
        Bundle arguments = new Bundle();
        arguments.putSerializable("EVENT",event);
        fragment.setArguments(arguments);

        return fragment;
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event, container,false);
        name = view.findViewById(R.id.name);
        imageEvent = view.findViewById(R.id.image_event);

        Event event =(Event) getArguments().getSerializable("EVENT");
        MainActivity activity = (MainActivity) getActivity();
        activity.getSupportActionBar().setTitle(event.name);
        //ActionBar actionBar = getSupportActionBar();


        return view;
    }



}
