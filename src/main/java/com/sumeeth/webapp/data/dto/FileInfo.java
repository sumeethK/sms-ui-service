/**
 * 
 */
package com.sumeeth.webapp.data.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author sumeeth kumar kanojia
 * 
 */
@XmlRootElement(name = "file")
public class FileInfo {

	private String name;
	private String category;
	private Date modifiedDate;
	private long size;
	private String absolutePath;

	/**
	 * @return the name
	 */
	@XmlElement
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the category
	 */
	@XmlElement
	public String getCategory() {
		return category;
	}

	/**
	 * @param category
	 *            the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the size
	 */
	@XmlElement
	public long getSize() {
		return size;
	}

	/**
	 * @param size
	 *            the size to set
	 */
	public void setSize(long size) {
		this.size = size;
	}

	/**
	 * @return the modifiedDate
	 */
	@XmlElement
	public Date getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * @param modifiedDate
	 *            the modifiedDate to set
	 */
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	/**
	 * @return the absolutePath
	 */
	@XmlElement
	public String getAbsolutePath() {
		return absolutePath;
	}

	/**
	 * @param absolutePath
	 *            the absolutePath to set
	 */
	public void setAbsolutePath(String absolutePath) {

		this.absolutePath = absolutePath.replace("\\", "/");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FileInfo [name=" + name + ", category="
				+ category + ", modifiedDate="
				+ modifiedDate + ", size=" + size
				+ ", absolutePath=" + absolutePath + "]";
	}

}
