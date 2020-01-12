package com.USMS.Mobile.models;

public class NewsItem {
    private int id;
    private String title;
    private String image;
    private String description;
    private String published_at;
    private String scholar_year_id;
    private String createdAt;

    public NewsItem(int id, String title, String image, String description, String published_at, String scholar_year_id, String createdAt) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.description = description;
        this.published_at = published_at;
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

    public String getPublished_at() {
        return published_at;
    }

    public void setPublished_at(String published_at) {
        this.published_at = published_at;
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

    @Override
    public String toString() {
        return "NewsItem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                ", published_at='" + published_at + '\'' +
                ", scholar_year_id='" + scholar_year_id + '\'' +
                ", createdAt='" + createdAt + '\'' +
                '}';
    }
}
