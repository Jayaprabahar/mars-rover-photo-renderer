/**
 * 
 */
package com.jayaprabahar.marsrover.photorenderer.dao;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * <p> Project : marsroverphotorenderer </p>
 * <p> Title : ApiCallHistory.java </p>
 * <p> Description: </p>
 * <p> Created: Sep 17, 2019</p>
 * 
 * @version 1.0
 * @author <a href="mailto:jpofficial@gmail.com">Jayaprabahar</a>
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ApiCallHistory {

	@Id
	String callId;
	String apiCall;
	long responseTime;
	LocalDateTime createdTime;

}
