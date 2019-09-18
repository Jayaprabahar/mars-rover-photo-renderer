/**
 * 
 */
package com.jayaprabahar.marsrover.photorenderer.vo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <p> Project : marsroverphotorenderer </p>
 * <p> Title : Camera.java </p>
 * <p> Description: </p>
 * <p> Created: Sep 17, 2019</p>
 * 
 * @version 1.0
 * @author <a href="mailto:jpofficial@gmail.com">Jayaprabahar</a>
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@NoArgsConstructor
public class Camera implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4224859172957624567L;

	private Integer id;
	private String name;
	@JsonProperty("rover_id")
	private Integer roverId;
	@JsonProperty("full_name")
	private String fullName;
}
