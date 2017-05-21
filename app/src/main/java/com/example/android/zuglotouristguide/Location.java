package com.example.android.zuglotouristguide;

public class Location {
    private static final int NO_IMAGE_SET = -1;
    private int imageResourceId = -1;
    private String title;
    private String description;
    private String address;
    private String url;

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

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getAddress() {
        return address;
    }

    public String getUrl() {
        return url;
    }

    public boolean hasAddress() {
        return this.address != null;
    }

    public boolean hasUrl() {
        return this.url != null;
    }

    public boolean hasImage() {
        return this.imageResourceId != NO_IMAGE_SET;
    }
}
