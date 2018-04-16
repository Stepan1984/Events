package com.banana.events;

import java.io.Serializable;

public class Event implements Serializable {
    public String name;
    public double latitude; //широта
    public double longitude; //долгота
    public String picture1;

    public Event(String title, String posterPath) {
        name = title;
        picture1 = posterPath;
    }
}
