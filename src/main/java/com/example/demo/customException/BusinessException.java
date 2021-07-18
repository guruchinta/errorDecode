package com.example.demo.customException;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class BusinessException extends RuntimeException {

	private static final long serialVersionUID= 1L;
	private String errorCode;
	private String errorMessage;
	
	public BusinessException(String errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}  
	
	public BusinessException() {
		super();
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}  
	
	
	
	
}
