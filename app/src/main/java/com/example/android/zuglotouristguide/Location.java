package com.example.android.zuglotouristguide;

/**
 * Created by Peny on 2017.05.19..
 */

public class Location {
    private String title;
    private String description;
    private String address = "";
    private String url = "";

    private int imageResourceId = -1;

    private static final int NO_IMAGE_SET = -1;

    public Location(String title, String description, int imageResourceId) {
        this.title = title;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }

    public Location(String title, String description, String url, int imageResourceId) {
        this.title = title;
        this.description = description;
        this.url = url;
        this.imageResourceId = imageResourceId;
    }

    public Location(String title, String description, String address) {
        this.title = title;
        this.description = description;
        this.address = address;
    }

    public boolean hasAddress() {
        return this.address != "";
    }

    public boolean hasUrl() {
        return this.url != "";
    }

    public boolean hasImage() {
        return this.imageResourceId != NO_IMAGE_SET;
    }
}
