package com.example.a16046562.p10firebasetodoapp;

import java.io.Serializable;

public class Item implements Serializable {
    private Boolean completed;
    private String date;
    private Integer numOfDays;
    private String title;

    public Item() {
    }

    public Item(Boolean completed, String date, Integer numOfDays, String title) {
        this.completed = completed;
        this.date = date;
        this.numOfDays = numOfDays;
        this.title = title;
    }
    public Boolean getCompleted() {
        return completed;
    }
    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public Integer getNumOfDays() {
        return numOfDays;
    }
    public void setNumOfDays(Integer numOfDays) {
        this.numOfDays = numOfDays;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Item{" +
                "completed=" + completed +
                ", date='" + date + '\'' +
                ", numOfDays=" + numOfDays +
                ", title='" + title + '\'' +
                '}';
    }
}
