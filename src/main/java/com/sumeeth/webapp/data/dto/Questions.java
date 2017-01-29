package com.sumeeth.webapp.data.dto;

import java.util.Date;
import java.util.Objects;

public class Questions {

    protected int id;


    protected Date creationDate;


    protected Date modifiedDate;


    protected int isActive;


    protected int isLatestVersion;


    protected String question;


    protected Option options;

    protected Answer answer;


    protected String comments;


    protected int level;


    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public boolean isActive() {
        return this.isActive == 1 ? true : false;
    }

    public void setActive(int active) {
        isActive = active;
    }

    public boolean isLatestVersion() {
        return this.isLatestVersion == 1 ? true : false;
    }

    public void setLatestVersion(int latestVersion) {
        isLatestVersion = latestVersion;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Option getOptions() {
        return options;
    }

    public void setOptions(Option option) {
        this.options = option;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }


    @Override
    public boolean equals(Object o) {
        if (o instanceof Questions) {
            Questions q = (Questions) o;
            return this.getId() == q.getId();
        } else return false;

    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.getId()) * 37 + 19;

    }


    @Override
    public String toString() {
        return "Questions{" +
                "id=" + id +
                ", creationDate=" + creationDate +
                ", modifiedDate=" + modifiedDate +
                ", isActive=" + isActive +
                ", isLatestVersion=" + isLatestVersion +
                ", question='" + question + '\'' +
                ", options=" + options +
                ", answer=" + answer +
                ", comments='" + comments + '\'' +
                ", level=" + level +
                '}';
    }
}
