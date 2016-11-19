/**
 * 
 */
package com.sumeeth.webapp.exception;

import org.apache.log4j.Logger;

/**
 * @author sumeeth kumar kanojia
 * 
 */
public class FileException extends Exception {

	private static final long serialVersionUID = 1L;
	private Logger LOGGER = Logger
			.getLogger(FileException.class);

	public FileException(String message) {
		LOGGER.error(message);
	}
}
