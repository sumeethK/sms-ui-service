/**
 * 
 */
package com.sumeeth.webapp.data.dto;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author sumeeth kumar kanojia
 * 
 */
@XmlRootElement(name = "files")
public class FileInfoList {

	private List<FileInfo> fileInfoList;

	/**
	 * @param fileInfoList
	 */
	public FileInfoList(List<FileInfo> fileInfoList) {
		super();
		this.fileInfoList = fileInfoList;
	}

	/**
	 * 
	 */
	public FileInfoList() {
		super();
		fileInfoList = new ArrayList<FileInfo>();
	}

	/**
	 * @return the fileInfoList
	 */
	@XmlElement(name = "file")
	public List<FileInfo> getFileInfoList() {
		return fileInfoList;
	}

	/**
	 * @param fileInfoList
	 *            the fileInfoList to set
	 */
	public void setFileInfoList(List<FileInfo> fileInfoList) {
		this.fileInfoList = fileInfoList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (FileInfo fInfo : fileInfoList) {
			sb.append(fInfo.toString() + "\n");
		}
		return sb.toString();
	}

}
