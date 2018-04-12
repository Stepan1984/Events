package com.banana.events;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class MovieAdapter extends RecyclerView.Adapter<viewHolder> {



    Context context;
    public MovieAdapter(Context context){
        this.context = context;
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view =inflater.inflate(R.layout.maket1, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(viewHolder holder, int position) {
        final Movie movie = Database.MOVIES[position];
        String title = movie.Title;
        String moovie = movie.posterPath;
        holder.titleTextView.setText(title);
        String picture = "https://image.tmdb.org/t/p/original" + moovie ;
        Glide.with(context)
                .load(picture)
                .apply(RequestOptions.centerCropTransform())
                .into(holder.Image_View);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startMovieActivity(movie);
            }
        });

    }

    @Override
    public int getItemCount() {
        return Database.MOVIES.length;
    }

    private void startMovieActivity(Movie movie){
        Intent intent = new Intent(context, MovieActivity.class);
        intent.putExtra("MOVIE",movie );
        context.startActivity(intent);

    }
}
