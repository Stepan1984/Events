package com.banana.events;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class MovieActivity extends AppCompatActivity {
    ImageView Picture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
        Picture = findViewById(R.id.imageView3);

        Movie movie =(Movie) getIntent().getSerializableExtra("MOVIE");
        getSupportActionBar().setTitle(movie.Title);

        String picture = "https://image.tmdb.org/t/p/original" + movie.posterPath ;
        Glide.with(this)
                .load(picture)
                .apply(RequestOptions.centerCropTransform())
                .into(Picture);

    }
}
