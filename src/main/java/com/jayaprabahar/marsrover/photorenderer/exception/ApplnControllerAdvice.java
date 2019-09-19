/**
 * 
 */
package com.jayaprabahar.marsrover.photorenderer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

/**
 * <p> Project : marsroverphotorenderer </p>
 * <p> Title : ApplnControllerAdvice.java </p>
 * <p> Description: </p>
 * <p> Created: Sep 19, 2019</p>
 * 
 * @version 1.0
 * @author <a href="mailto:jpofficial@gmail.com">Jayaprabahar</a>
 */

@RestControllerAdvice
@Slf4j
public class ApplnControllerAdvice {

	@ResponseStatus(HttpStatus.FAILED_DEPENDENCY)
	@ExceptionHandler(value = UnreachableHostException.class)
	public String handleInvalidFileDataException(UnreachableHostException e) {
		log.error("UnreachableHostException : ", e);
		return e.getMessage();
	}

}