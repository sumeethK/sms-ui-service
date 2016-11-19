/**
 * 
 */
package com.sumeeth.webapp.util;

import com.sumeeth.webapp.data.dto.FileInfo;

import java.util.Date;


/**
 * @author sumeeth kumar kanojia
 * 
 */
public class FIleInfoBuilder {

	private FileInfo fileInfo;

	public FIleInfoBuilder() {
		fileInfo = new FileInfo();
	}

	public FIleInfoBuilder withName(String name) {
		fileInfo.setName(name);
		return this;
	}

	public FIleInfoBuilder withModifiedDate(
			Date modifiedDate) {
		fileInfo.setModifiedDate(modifiedDate);
		return this;
	}

	public FIleInfoBuilder withSize(long size) {
		fileInfo.setSize(size);
		return this;
	}

	public FIleInfoBuilder withCategory(String category) {
		fileInfo.setCategory(category);
		return this;
	}

	public FIleInfoBuilder withAbsolutePath(
			String absolutePath) {
		fileInfo.setAbsolutePath(absolutePath);
		return this;
	}

	public FileInfo build() {
		return fileInfo;
	}

}
