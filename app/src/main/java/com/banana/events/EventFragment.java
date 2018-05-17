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

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater(); // создаватель меню
        menuInflater.inflate(R.menu.login_activity_menu, menu); // заполняем меню
        return true; // мол, всё ок
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) { // смотрим, на какое действие нажали
            case R.id.about_action: // если на действие с android:id="about_action", то
                Intent intent = new Intent(LoginActivity.this, AboutActivity.class); // создаём запрос
                startActivity(intent); // отправляем запрос на открытие активности
                return true; // мол, обработали нажатие
            case R.id.exit_action: // если на действие с android:id="exit_action", то
                finish(); // закрываем текущую активность
                return true; // мол, обработали нажатие
            default: // остальные действия не поддерживаем
                return false; // мол, кнопочка неизвестна нам
        }
    */


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event, container,false);

        Event event =(Event) getArguments().getSerializable("EVENT");
        MainActivity activity = (MainActivity) getActivity();
        activity.getSupportActionBar().setTitle(event.name);
        //ActionBar actionBar = getSupportActionBar();


        return view;

        // 75CVUEYPMPG7WHIHFMNE

        // https://www.eventbriteapi.com/v3/events/search/?token=75CVUEYPMPG7WHIHFMNE
    }


}
