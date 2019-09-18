/**
 * 
 */
package com.jayaprabahar.marsrover.photorenderer.vo;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <p> Project : marsroverphotorenderer </p>
 * <p> Title : Photos.java </p>
 * <p> Description: </p>
 * <p> Created: Sep 18, 2019</p>
 * 
 * @version 1.0
 * @author <a href="mailto:jpofficial@gmail.com">Jayaprabahar</a>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@NoArgsConstructor
public class Photos implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2558539417816461300L;

	List<Photo> photos;

}
