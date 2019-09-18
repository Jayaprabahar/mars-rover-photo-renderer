/**
 * 
 */
package com.jayaprabahar.marsrover.photorenderer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jayaprabahar.marsrover.photorenderer.config.MarsRoverApiProperties;
import com.jayaprabahar.marsrover.photorenderer.vo.Photos;
import com.jayaprabahar.marsrover.photorenderer.vo.Rovers;
import com.jayaprabahar.marsrover.photorenderer.vo.SearchCriteria;

/**
 * <p> Project : marsroverphotorenderer </p>
 * <p> Title : MarsRoverApiRenderingService.java </p>
 * <p> Description: </p>
 * <p> Created: Sep 17, 2019</p>
 * 
 * @version 1.0
 * @author <a href="mailto:jpofficial@gmail.com">Jayaprabahar</a>
 */
@Service
public class MarsRoverApiRenderingService {

	@Autowired
	private RestTemplate restTemplate;

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	private MarsRoverApiProperties marsRoverApiProperties;

	@Autowired
	public MarsRoverApiRenderingService(MarsRoverApiProperties marsRoverApiProperties) {
		this.marsRoverApiProperties = marsRoverApiProperties;
	}

	public Rovers getManifestInformation() {
		return restTemplate.getForObject(marsRoverApiProperties.getUrl().concat("?api_key=").concat(marsRoverApiProperties.getKey()), Rovers.class);
	}

	public Photos getPhotosInformation(SearchCriteria criteria) {
		return restTemplate.getForObject(
				marsRoverApiProperties.getUrl()
						.concat("/{rover}/photos?api_key={apiKey}&camera={camera}&sol={sol}&page={page}&earthDate={earthDate}"),
				Photos.class, criteria.getRoverName(), marsRoverApiProperties.getKey(), criteria.getCameraName(), criteria.getSol(),
				criteria.getEarthDate(), criteria.getPage());
	}

}
