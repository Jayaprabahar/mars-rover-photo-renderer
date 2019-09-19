/**
 * 
 */
package com.jayaprabahar.marsrover.photorenderer.service;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayaprabahar.marsrover.photorenderer.config.MarsRoverApiProperties;
import com.jayaprabahar.marsrover.photorenderer.exception.UnreachableHostException;
import com.jayaprabahar.marsrover.photorenderer.util.ApplicationUtil;
import com.jayaprabahar.marsrover.photorenderer.vo.Photos;
import com.jayaprabahar.marsrover.photorenderer.vo.Rovers;
import com.jayaprabahar.marsrover.photorenderer.vo.SearchCriteria;

/**
 * <p> Project : marsroverphotorenderer </p>
 * <p> Title : MarsRoverApiRenderingControllerTest.java </p>
 * <p> Description: </p>
 * <p> Created: Sep 19, 2019</p>
 * 
 * @version 1.0
 * @author <a href="mailto:jpofficial@gmail.com">Jayaprabahar</a>
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext
@TestPropertySource("classpath:application.properties")
public class MarsRoverApiRenderingServiceTest {

	@Autowired
	private MarsRoverApiRenderingService apiRenderingService;

	@Autowired
	private MarsRoverApiProperties marsRoverApiProperties;

	@Autowired
	private RestTemplate restTemplate;

	private MockRestServiceServer mockRestServiceServer;
	private ObjectMapper mapper = new ObjectMapper();

	@Before
	public void init() {
		mockRestServiceServer = MockRestServiceServer.createServer(restTemplate);
	}

	@Value("${nasa.mars-photos.api.url}")
	private String nasaUrl;

	@Value("${nasa.mars-photos.api.key}")
	private String nasaAccessKey;

	@Value("classpath:manifest.json")
	Resource manifestResource;

	@Value("classpath:photosFHAZ1000.json")
	Resource photosFhaz1000solResource;

	@Test
	public void testRenderManiFestInformation() throws Exception {
		Rovers extepctedRovers = mapper.readValue(manifestResource.getInputStream(), new TypeReference<Rovers>() {
		});

		UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(nasaUrl).queryParam("api_key", nasaAccessKey);

		mockRestServiceServer.expect(requestTo(uriComponentsBuilder.build().toUriString())).andExpect(method(HttpMethod.GET))
				.andRespond(withSuccess(mapper.writeValueAsString(extepctedRovers), MediaType.APPLICATION_JSON));

		this.apiRenderingService.getManifestInformation();

		mockRestServiceServer.verify();
	}

	@Test
	public void testRenderPhotosInformation() throws Exception {
		Photos extepctedPhotos = new ObjectMapper().readValue(photosFhaz1000solResource.getInputStream(), new TypeReference<Photos>() {
		});

		SearchCriteria criteria = new SearchCriteria("Curiosity", Optional.of("FHAZ"), Optional.of("1000"), Optional.empty(), Optional.empty());

		mockRestServiceServer.expect(requestTo(ApplicationUtil.createNasaPhotoRenderAPIURL(nasaUrl, nasaAccessKey, criteria)))
				.andExpect(method(HttpMethod.GET)).andRespond(withSuccess(mapper.writeValueAsString(extepctedPhotos), MediaType.APPLICATION_JSON));

		this.apiRenderingService.getPhotosInformation(criteria);

		mockRestServiceServer.verify();
	}

	@Test(expected = UnreachableHostException.class)
	public void testUnreachableHostError() throws Exception {
		marsRoverApiProperties.setUrl("http://Random_URL.com");
		mockRestServiceServer.expect(method(HttpMethod.GET)).andRespond(withStatus(HttpStatus.FAILED_DEPENDENCY));

		this.apiRenderingService.getManifestInformation();

		mockRestServiceServer.verify();
	}

}
