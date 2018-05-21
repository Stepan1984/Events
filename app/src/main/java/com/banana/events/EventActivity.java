package com.banana.events;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class EventActivity extends AppCompatActivity {
    ImageView picture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitie_event);
        picture = findViewById(R.id.image_event);

        Event event =(Event) getIntent().getSerializableExtra("EVENT");
        getSupportActionBar().setTitle(event.name);

        String picture = "https://image.tmdb.org/t/p/original" + event.picture1 ;
        Glide.with(this)
                .load(picture)
                .apply(RequestOptions.centerCropTransform())
                .into(this.picture);

    }
}
