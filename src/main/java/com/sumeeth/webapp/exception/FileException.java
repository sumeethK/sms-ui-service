package com.sumeeth.webapp.exception;

import org.apache.log4j.Logger;

/**
 * @author sumeeth kumar kanojia
 * 
 */
public class FileException extends Exception {

	private static final long serialVersionUID = 1L;

	public FileException(String message) {
		Logger LOGGER = Logger
				.getLogger(FileException.class);
		LOGGER.error(message);
	}
}
