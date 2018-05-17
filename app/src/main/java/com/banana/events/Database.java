package com.banana.events;

import android.util.Log;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Database {

    public static final String DATA_URL ="https://www.eventbriteapi.com/v3/events/search/?q=I.EYE%C2%A0&sort_by=best&location.latitude=40.730610&location.longitude=+-73.935242&token=75CVUEYPMPG7WHIHFMNE";
    // массив (список) с данными
    public static final List<Event> EVENTS = new ArrayList<>();

    /**
     * Запуск операции получения данных из интернета и заполнения ими базы данных.
     */
    public static void load() {
        // создаём запрос
        Request request = new Request.Builder()
                .url(DATA_URL) // устанавливаем ссылку
                .build();
        // создаём клиент, отправляем запрос и подписываемся на ответ
        OkHttpClient client = new OkHttpClient();
        client.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                // этот метод запускается, если есть ошибка
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String data = response.body().string(); // получаем строку с данными
                parse(data); // парсим их
            }

        });
    }

    public static void parse(String data) {
        try {
            //создаём корневой json-обЪект
            JSONObject object = new JSONObject(data);
            JSONArray events = object.getJSONArray("events");
            for (int i = 0; i < events.length(); ++i) {
                JSONObject event = events.getJSONObject(i);
                String title = event.getJSONObject("name").getString("text");
                String url = null;
                if (event.has("logo") && !event.get("logo").toString().equals("null")) {
                    Log.v("GUB", "? " + event.get("logo"));
                    JSONObject logo = event.getJSONObject("logo");
                    if (logo.has("original")){
                        JSONObject original = logo.getJSONObject("original");
                        if (original.has("url")){
                            url = original.getString("url");
                        }
                    }
                }
                Event event01 = new Event(title, url);
                EVENTS.add(event01);


            }
            EventBus.getDefault().post(new OnMovieChangedEvent());
        } catch (JSONException e) {
            Log.e("AHAH", "ERROR!", e);
        }
    }

    /**
     * Класс события внесения в базу данных изменений.
     */
    public static class OnMovieChangedEvent {}



}
