package com.banana.events;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.banana.events.Event;
import com.banana.events.Movie;

public class EventFragment extends Fragment {

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

        Event event =(Event) getArguments().getSerializable("EVENT");
        MainActivity activity = (MainActivity) getActivity();
        activity.getSupportActionBar().setTitle(event.name);


        return view;
        // 75CVUEYPMPG7WHIHFMNE

        // https://www.eventbriteapi.com/v3/events/search/?token=75CVUEYPMPG7WHIHFMNE
    }

}
