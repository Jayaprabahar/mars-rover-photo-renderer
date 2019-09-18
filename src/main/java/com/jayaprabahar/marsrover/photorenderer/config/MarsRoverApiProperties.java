/**
 * 
 */
package com.jayaprabahar.marsrover.photorenderer.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

/**
 * <p> Project : marsroverphotorenderer </p>
 * <p> Title : MarsRoverApiProperties.java </p>
 * <p> Description: </p>
 * <p> Created: Sep 17, 2019</p>
 * 
 * @version 1.0
 * @author <a href="mailto:jpofficial@gmail.com">Jayaprabahar</a>
 */
@ConfigurationProperties(prefix = "nasa.mars-photos.api")
@Configuration
@Getter
@Setter
public class MarsRoverApiProperties {

	private String url;
	private String key;

}
