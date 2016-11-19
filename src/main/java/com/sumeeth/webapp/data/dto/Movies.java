package com.sumeeth.webapp.data.dto;

import java.util.Date;
import javax.persistence.*;

/**
 * @author sumeeth kumar kanojia
 * 
 */

@Entity
@Table(name = "movies_table", uniqueConstraints = { @UniqueConstraint(columnNames = {
		"id", "path" }) })
public class Movies {

	@Id
	@GeneratedValue
	@Column
	protected int id;

	@Column
	protected String name;

	@Column
	protected String category;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "modifieddate")
	protected Date modifiedDate;
	@Column(name = "filesize")
	protected long size;
	@Column(name = "path")
	protected String absolutePath;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getAbsolutePath() {
		return absolutePath;
	}

	public void setAbsolutePath(String absolutePath) {

		this.absolutePath = absolutePath.replace("\\", "/");
	}

	@Override
	public String toString() {
		return "Movies [id=" + id + ", name=" + name
				+ ", category=" + category
				+ ", modifiedDate=" + modifiedDate
				+ ", size=" + size + ", absolutePath="
				+ absolutePath + "]";
	}

}
