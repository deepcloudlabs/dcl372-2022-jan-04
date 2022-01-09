package com.example.banking.dto;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
public class ErrorResponse {

	private String status;
	private String message;

	public ErrorResponse() {
	}

	public ErrorResponse(String status, String message) {
		this.status = status;
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ErrorResponse [" + (status != null ? "status=" + status + ", " : "")
				+ (message != null ? "message=" + message : "") + "]";
	}

}
