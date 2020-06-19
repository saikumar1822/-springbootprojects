package com.hcl.Exception;

import java.util.Date;

public class ErrorResponse {

	private Date timestamp;
	private String message;
	private String detalles;
	private String httpCodeMessage;

	public ErrorResponse() {
		super();
	}

	public ErrorResponse(Date timestamp, String message, String detalles, String httpCodeMessage) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.detalles = detalles;
		this.httpCodeMessage = httpCodeMessage;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetalles() {
		return detalles;
	}

	public void setDetalles(String detalles) {
		this.detalles = detalles;
	}

	public String getHttpCodeMessage() {
		return httpCodeMessage;
	}

	public void setHttpCodeMessage(String httpCodeMessage) {
		this.httpCodeMessage = httpCodeMessage;
	}

}
