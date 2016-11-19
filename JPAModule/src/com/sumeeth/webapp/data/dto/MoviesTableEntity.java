package com.sumeeth.webapp.data.dto;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by daljit on 13-Nov-16.
 */
@Entity
@Table(name = "MOVIES_TABLE", schema = "TEST", catalog = "")
public class MoviesTableEntity {
    private int id;
    private String path;
    private String category;
    private Timestamp modifieddate;
    private String name;
    private Long filesize;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "PATH")
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Basic
    @Column(name = "CATEGORY")
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Basic
    @Column(name = "MODIFIEDDATE")
    public Timestamp getModifieddate() {
        return modifieddate;
    }

    public void setModifieddate(Timestamp modifieddate) {
        this.modifieddate = modifieddate;
    }

    @Basic
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "FILESIZE")
    public Long getFilesize() {
        return filesize;
    }

    public void setFilesize(Long filesize) {
        this.filesize = filesize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MoviesTableEntity that = (MoviesTableEntity) o;

        if (id != that.id) return false;
        if (path != null ? !path.equals(that.path) : that.path != null) return false;
        if (category != null ? !category.equals(that.category) : that.category != null) return false;
        if (modifieddate != null ? !modifieddate.equals(that.modifieddate) : that.modifieddate != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (filesize != null ? !filesize.equals(that.filesize) : that.filesize != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (path != null ? path.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (modifieddate != null ? modifieddate.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (filesize != null ? filesize.hashCode() : 0);
        return result;
    }
}
