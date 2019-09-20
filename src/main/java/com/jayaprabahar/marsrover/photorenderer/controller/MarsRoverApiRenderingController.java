/**
 * 
 */
package com.jayaprabahar.marsrover.photorenderer.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jayaprabahar.marsrover.photorenderer.service.MarsRoverApiRenderingService;
import com.jayaprabahar.marsrover.photorenderer.vo.PhotoVO;
import com.jayaprabahar.marsrover.photorenderer.vo.Photos;
import com.jayaprabahar.marsrover.photorenderer.vo.Rovers;
import com.jayaprabahar.marsrover.photorenderer.vo.SearchCriteria;

/**
 * <p> Project : mt940FileValidator </p>
 * <p> Title : MarsRoverApiRenderingController.java </p>
 * <p> Description: </p>
 * <p> Created: Jul 21, 2019</p>
 * 
 * @version 1.0
 * @author <a href="mailto:jpofficial@gmail.com">Jayaprabahar</a>
 */

@RestController
@RequestMapping("api")
@CrossOrigin
public class MarsRoverApiRenderingController {

	private MarsRoverApiRenderingService apiRenderingService;

	@Autowired
	public MarsRoverApiRenderingController(MarsRoverApiRenderingService apiRenderingService) {
		this.apiRenderingService = apiRenderingService;
	}

	/**
	 * Controller method to render nasa rover's manifest information such as list of rovers, cameras, max-sol and max earth dates
	 *   
	 * @return Rovers
	 * 
	 */
	@GetMapping
	@ResponseBody
	public Rovers renderManiFestInformation() {
		return apiRenderingService.getManifestInformation();
	}

	/**
	 * Controller method for rendering photo information based on search criteria
	 * 
	 * @param rover
	 * @param camera
	 * @param sol
	 * @param page
	 * @param earthDate
	 * @return List<PhotoVO>
	 */
	@GetMapping("/photos")
	@ResponseBody
	public List<PhotoVO> renderPhotosInformation(@RequestParam("rover") String rover, @RequestParam("camera") Optional<String> camera,
			@RequestParam("sol") Optional<String> sol, @RequestParam("page") Optional<String> page,
			@RequestParam("earthDate") Optional<String> earthDate) {

		Photos photos = apiRenderingService.getPhotosInformation(new SearchCriteria(rover, camera, sol, earthDate, page));

		return photos.getPhotos().stream()
				.map(e -> new PhotoVO(e.getRover().getName(), e.getCamera().getName(), e.getSol(), e.getEarthDate(), e.getImgSrc()))
				.collect(Collectors.toList());
	}
}
