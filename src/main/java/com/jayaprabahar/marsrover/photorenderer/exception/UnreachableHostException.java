/**
 * 
 */
package com.jayaprabahar.marsrover.photorenderer.exception;

import org.springframework.web.client.HttpClientErrorException;

/**
 * <p> Project : marsroverphotorenderer </p>
 * <p> Title : UnreachableHostException.java </p>
 * <p> Description: </p>
 * <p> Created: Sep 19, 2019</p>
 * 
 * @version 1.0
 * @author <a href="mailto:jpofficial@gmail.com">Jayaprabahar</a>
 */

public class UnreachableHostException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7627191341357159510L;

	/**
	 * @param e
	 */
	public UnreachableHostException(HttpClientErrorException e) {
		super("Connection to the NASA API is lost", e);
	}

}