package com.socgen.bookmark.sgbookmark.exception;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.exceptions.UnauthorizedUserException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException.Unauthorized;
import com.socgen.bookmark.sgbookmark.model.ApiResponse;

public class ExceptionMapper {
	
	@ExceptionHandler({IllegalArgumentException.class})
	public ResponseEntity<ApiResponse> handleIllegalArgException(IllegalArgumentException e){
		ApiResponse response = new ApiResponse();
		response.addError(HttpStatus.BAD_REQUEST.getReasonPhrase(), e.getMessage() != null ? e.getMessage() : "Payload Error");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}
	
	@ExceptionHandler({ConstraintViolationException.class})
	public ResponseEntity<ApiResponse> handleConstraintViolation(ConstraintViolationException e){
		ApiResponse response = new ApiResponse();
		response.addError(HttpStatus.BAD_REQUEST.getReasonPhrase(), e.getMessage() != null ? e.getMessage() : "Payload Error");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}
	
	@ExceptionHandler({EntityNotFoundException.class})
	public ResponseEntity<ApiResponse> handleEntityException(EntityNotFoundException e){
		ApiResponse response = new ApiResponse();
		response.addError(HttpStatus.NOT_FOUND.getReasonPhrase(), "Requested Entity is Expired Or Never Existed");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}
	
	@SuppressWarnings("deprecation")
	@ExceptionHandler({UnauthorizedUserException.class})
	public ResponseEntity<ApiResponse> handleUnauthorizedUserException(UnauthorizedUserException e){
		ApiResponse response = new ApiResponse();
		response.addError(HttpStatus.UNAUTHORIZED.getReasonPhrase(), "Session is Expired, please reload the page");
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
	}
	
	@ExceptionHandler({Unauthorized.class})
	public ResponseEntity<ApiResponse> handleUnauthorizedException(Unauthorized e){
		ApiResponse response = new ApiResponse();
		response.addError(HttpStatus.UNAUTHORIZED.getReasonPhrase(), "Session is Expired, please reload the page");
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
	}

	@ExceptionHandler({RuntimeException.class})
	public ResponseEntity<ApiResponse> handleRunTimeException(RuntimeException e) {
		ApiResponse response = new ApiResponse();
		response.addError(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), "Something Went Wrong");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	}
}
