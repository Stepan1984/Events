package com.banana.events;

import java.io.Serializable;

public class Event implements Serializable {
    public String name;
    public String discription;
    public double startTime;
    public String picture1;

    public Event(String title, String posterPath, String description) {
        name = title;
        picture1 = posterPath;
        discription = description;
    }
}
