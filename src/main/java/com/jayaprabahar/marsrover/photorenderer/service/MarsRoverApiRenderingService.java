/**
 * 
 */
package com.jayaprabahar.marsrover.photorenderer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.jayaprabahar.marsrover.photorenderer.config.MarsRoverApiProperties;
import com.jayaprabahar.marsrover.photorenderer.exception.UnreachableHostException;
import com.jayaprabahar.marsrover.photorenderer.util.ApplicationUtil;
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

	/**
	 * Performs api call to get manifest information and returns JSON equivalent of response
	 * 
	 * @return Rovers
	 */
	public Rovers getManifestInformation() {
		try {
			return restTemplate.getForObject(marsRoverApiProperties.getUrl().concat("?api_key=").concat(marsRoverApiProperties.getKey()),
					Rovers.class);
		} catch (HttpClientErrorException e) {
			throw new UnreachableHostException(e);
		}
	}

	/**
	 * Performs api call to get photo information and returns JSON equivalent of response
	 * 
	 * @param criteria
	 * @return Photos
	 */
	public Photos getPhotosInformation(SearchCriteria criteria) {
		try {
			return restTemplate.getForObject(
					ApplicationUtil.createNasaPhotoRenderAPIURL(marsRoverApiProperties.getUrl(), marsRoverApiProperties.getKey(), criteria),
					Photos.class, criteria.getRoverName());
		} catch (HttpClientErrorException e) {
			throw new UnreachableHostException(e);
		}

	}

}
