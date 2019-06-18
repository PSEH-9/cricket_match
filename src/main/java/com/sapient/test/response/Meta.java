package com.sapient.test.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Meta implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String statusCode;
	private String message;

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Meta() {

	}

	public Meta(String statusCode, String message) {
		super();
		this.statusCode = statusCode;
		this.message = message;
	}

}
