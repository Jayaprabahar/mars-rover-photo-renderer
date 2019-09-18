/**
 * 
 */
package com.jayaprabahar.marsrover.photorenderer.aop;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.jayaprabahar.marsrover.photorenderer.dao.ApiCallHistory;
import com.jayaprabahar.marsrover.photorenderer.dao.ApiCallHistoryRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * <p> Project : marsroverphotorenderer </p>
 * <p> Title : LoggingAspect.java </p>
 * <p> Description: </p>
 * <p> Created: Sep 17, 2019</p>
 * 
 * @version 1.0
 * @author <a href="mailto:jpofficial@gmail.com">Jayaprabahar</a>
 */

@Aspect
@Component
@Slf4j
public class LoggingAspect {

	@Autowired
	private ApiCallHistoryRepository apiCallHistoryRepository;

	@Around("execution(* com.jayaprabahar.marsrover.photorenderer.controller..*(..))")
	public Object profileExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		LocalDateTime startTime = LocalDateTime.now();

		Object result = joinPoint.proceed();

		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

		log.info(apiCallHistoryRepository.save(new ApiCallHistory(RandomStringUtils.randomNumeric(10),
				request.getRequestURI() + (StringUtils.isNotBlank(request.getQueryString()) ? "/photos?" + request.getQueryString() : ""),
				startTime.until(LocalDateTime.now(), ChronoUnit.MILLIS), LocalDateTime.now())).toString());

		return result;
	}
}