package com.jayaprabahar.marsrover.photorenderer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * <p> Project : marsroverphotorenderer </p>
 * <p> Title : MarsRoverApiRenderingApplication.java </p>
 * <p> Description: </p>
 * <p> Created: Sep 18, 2019</p>
 * 
 * @version 1.0
 * @author <a href="mailto:jpofficial@gmail.com">Jayaprabahar</a>
 */
@SpringBootApplication
@EnableAsync
@EnableAspectJAutoProxy
public class MarsRoverApiRenderingApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarsRoverApiRenderingApplication.class, args);
	}

}
