package com.sumeeth.webapp.data.dto;

import java.util.Date;
public class QuestionCategory {

    protected int id;

    protected Date creationDate;

    protected Date modifiedDate;

    protected boolean isActive;

    protected boolean isLatestVersion;

    protected String name;

    protected String description;

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
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isLatestVersion() {
        return isLatestVersion;
    }

    public void setLatestVersion(boolean latestVersion) {
        isLatestVersion = latestVersion;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "QuestionCategory{" +
                "id=" + id +
                ", creationDate=" + creationDate +
                ", modifiedDate=" + modifiedDate +
                ", isActive=" + isActive +
                ", isLatestVersion=" + isLatestVersion +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

}
