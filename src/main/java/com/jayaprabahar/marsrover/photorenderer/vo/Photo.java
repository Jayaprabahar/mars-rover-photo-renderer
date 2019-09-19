/**
 * 
 */
package com.jayaprabahar.marsrover.photorenderer.vo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * <p> Project : marsroverphotorenderer </p>
 * <p> Title : Photo.java </p>
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
@ToString
@EqualsAndHashCode
public class Photo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5251290800251605095L;

	@JsonProperty
	private Integer id;
	@JsonProperty
	private Integer sol;
	@JsonProperty
	private Camera camera;
	@JsonProperty("img_src")
	private String imgSrc;
	@JsonProperty("earth_date")
	private String earthDate;
	@JsonProperty
	private Rover rover;

}