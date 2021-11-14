package com.example.newsapp;

public class News {
    private String mTitle;
    private String mSection;
    private String mDate;
    private String mUrl;
    private String mAuthor;

    public News(String title, String section, String date, String url, String author) {
        this.mTitle = title;
        this.mSection = section;
        this.mDate = date;
        this.mUrl = url;
        this.mAuthor = author;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getSection() {
        return mSection;
    }

    public String getDate() {
        return mDate;
    }

    public String getUrl() {
        return mUrl;
    }

    public String getAuthor() {
        return mAuthor;
    }
}
