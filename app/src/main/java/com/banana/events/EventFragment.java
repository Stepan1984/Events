package com.banana.events;

import android.annotation.SuppressLint;
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
import com.bumptech.glide.Glide;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class EventFragment extends Fragment {
    Event event;
    TextView description1;
    ImageView imageEvent;
    ImageView dollar;




    public EventFragment(){

    }


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
        description1 = view.findViewById(R.id.name);
        imageEvent = view.findViewById(R.id.imageEvent);
        dollar = view.findViewById(R.id.imageDollar);



        Event event =(Event) getArguments().getSerializable("EVENT");
        MainActivity activity = (MainActivity) getActivity();
        activity.getSupportActionBar().setTitle(event.name);
        Glide.with(this).load(event.picture1).into(imageEvent);
        description1.setText(event.discription);
        if (event.eventCost == false){
            dollar.setVisibility(View.VISIBLE);
        }else{
            dollar.setVisibility(View.GONE);
        }



        return view;
    }



}
