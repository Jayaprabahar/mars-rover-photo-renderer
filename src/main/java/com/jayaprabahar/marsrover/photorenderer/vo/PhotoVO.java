/**
 * 
 */
package com.jayaprabahar.marsrover.photorenderer.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * <p> Project : marsroverphotorenderer </p>
 * <p> Title : PhotoVO.java </p>
 * <p> Description: </p>
 * <p> Created: Sep 18, 2019</p>
 * 
 * @version 1.0
 * @author <a href="mailto:jpofficial@gmail.com">Jayaprabahar</a>
 */
@Getter
@Setter
@AllArgsConstructor
public class PhotoVO {

	private String rover;
	private String camera;
	private int sol;
	private String earthDate;
	private String imageUrl;
}
