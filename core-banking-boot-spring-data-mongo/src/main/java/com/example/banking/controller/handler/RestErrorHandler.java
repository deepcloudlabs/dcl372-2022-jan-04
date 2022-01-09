package com.example.banking.controller.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.banking.dto.ErrorResponse;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@deepcloudlabs.com>
 *
 */
@RestControllerAdvice
public class RestErrorHandler {

	@ExceptionHandler(RuntimeException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse handleAllOtherExceptions(Exception e) {
		return new ErrorResponse("FAILED", e.getMessage());
	}

}