/**
 * 
 */
package com.jayaprabahar.marsrover.photorenderer.vo;

import java.util.Optional;

import lombok.Value;

/**
 * <p Project : marsroverphotorenderer </p
 * <p Title : SearchCriteria.java </p
 * <p Description: </p
 * <p Created: Sep 17, 2019</p
 * 
 * @version 1.0
 * @author <a href="mailto:jpofficial@gmail.com"Jayaprabahar</a>
 */

@Value
public class SearchCriteria {

	private String roverName;
	private Optional<String> cameraName;
	private Optional<String> sol;
	private Optional<String> earthDate;
	private Optional<String> page;

}
