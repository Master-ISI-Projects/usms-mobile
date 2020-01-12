package com.USMS.Mobile.models;

public class EventItem {
    private int id;
    private String title;
    private String image;
    private String description;
    private String start_at;
    private String duration;
    private String scholar_year_id;
    private String createdAt;

    public EventItem(int id, String title, String image, String description, String start_at, String duration, String scholar_year_id, String createdAt) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.description = description;
        this.start_at = start_at;
        this.duration = duration;
        this.scholar_year_id = scholar_year_id;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStart_at() {
        return start_at;
    }

    public void setStart_at(String start_at) {
        this.start_at = start_at;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getScholar_year_id() {
        return scholar_year_id;
    }

    public void setScholar_year_id(String scholar_year_id) {
        this.scholar_year_id = scholar_year_id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
