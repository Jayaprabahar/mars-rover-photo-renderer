/**
 * 
 */
package com.jayaprabahar.marsrover.photorenderer.util;

import org.springframework.web.util.UriComponentsBuilder;

import com.jayaprabahar.marsrover.photorenderer.vo.SearchCriteria;

/**
 * <p> Project : marsroverphotorenderer </p>
 * <p> Title : ApplicationUtil.java </p>
 * <p> Description: </p>
 * <p> Created: Sep 20, 2019</p>
 * 
 * @version 1.0
 * @author <a href="mailto:jpofficial@gmail.com">Jayaprabahar</a>
 */

public class ApplicationUtil {

	/**
	 * 
	 */
	private ApplicationUtil() {
		// DO-NOTHING
	}

	/**
	 * Creates Nasa Photo Render api URL based on search criteria and api's Url & access key
	 * 
	 * @param apiUrl
	 * @param apiKey
	 * @param criteria
	 * 
	 * @return URLString
	 */
	public static String createNasaPhotoRenderAPIURL(String apiUrl, String apiKey, SearchCriteria criteria) {
		UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(apiUrl).pathSegment(criteria.getRoverName(), "photos");

		uriComponentsBuilder.queryParam("api_key", apiKey);

		criteria.getCameraName().ifPresent(e -> uriComponentsBuilder.queryParam("camera", e));
		criteria.getSol().ifPresent(e -> uriComponentsBuilder.queryParam("sol", e));
		criteria.getEarthDate().ifPresent(e -> uriComponentsBuilder.queryParam("earthDate", e));
		criteria.getPage().ifPresent(e -> uriComponentsBuilder.queryParam("page", e));

		return uriComponentsBuilder.build().toUriString();

	}

}
