package com.banana.events;

import java.io.Serializable;

public class Event implements Serializable {
    public String name;
    public String discription;
    public boolean eventCost;
    public String picture1;

    public Event(String title, String posterPath, String description, Boolean cost) {
        name = title;
        picture1 = posterPath;
        discription = description;
        eventCost = cost;
    }

}
