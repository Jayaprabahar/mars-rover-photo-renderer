/**
 * 
 */
package com.jayaprabahar.marsrover.photorenderer.vo;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

/**
 * <p> Project : marsroverphotorenderer </p>
 * <p> Title : Rover.java </p>
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
public class Rover implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -199323495106192092L;

	public int id;
	public String name;
	@JsonProperty("landing_date")
	public String landingDate;
	@JsonProperty("launch_date")
	public String launchDate;
	public String status;
	@JsonProperty("max_sol")
	public int maxSol;
	@JsonProperty("max_date")
	public String maxDate;
	@JsonProperty("total_photos")
	public int totalPhotos;
	@JsonProperty("cameras")
	List<Camera> cameras;

}