package com.banana.events;

import java.io.Serializable;

public class Movie implements Serializable {

    public String Title;
    public String posterPath;

    public Movie(String title, String posterPath) {
        Title = title;
        this.posterPath = posterPath;
    }





}
