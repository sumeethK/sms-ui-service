package com.sumeeth.webapp.data.dto;

/**
 * Created by daljit on 29-Jan-17.
 */
public class Answer {


    private String key;
    private String description;


    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "key='" + key + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
